package me.zhang.coreJava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zhang on 2017/10/17 18:18.
 */
public class ProxyTest {

    public static void main(String[] args) {
        /* Example 1 */
        Object[] elements = new Object[1000];

        // fill elements with proxies for the integers 1...1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        // construct a random integer
        Integer key = new Random().nextInt(elements.length) + 1;

        // search for the key
        int result = Arrays.binarySearch(elements, key);

        // print match if found
        if (result >= 0) System.out.println(elements[result]);

        /* Example 2 */
        System.out.println("*********************");
        final Integer target = 10;
        // proxy of integer 10
        Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, (p, method, a) -> {
            printMethodCall(target, method, a);
            return method.invoke(target, a);
        });
        int res = ((Comparable) proxy).compareTo(5);
        System.out.println(res >= 0 ? (res == 0 ? "=" : ">") : "<");

        /* Example 3 */
        System.out.println("*********************");
        Class proxyClass = Proxy.getProxyClass(null, Comparable.class);
        System.out.println(proxyClass.getName());
        Method[] methods = proxyClass.getDeclaredMethods();
        for (Method m : methods) {
            // print modifiers
            int modifiers = m.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");

            // print return type
            Class returnType = m.getReturnType();
            System.out.print(returnType.getSimpleName() + " ");

            // print method signature
            System.out.print(m.getName() + "(");
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getSimpleName());
                if (i < paramTypes.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }
    }

    /**
     * An invocation handler that prints out the method name and parameters,
     * then invokes the original method.
     */
    static class TraceHandler implements InvocationHandler {

        private Object target;

        /**
         * Constructs a TraceHandler
         *
         * @param target the implicit parameter of the method call
         */
        public TraceHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            printMethodCall(target, method, args);
            // invoke actual method
            return method.invoke(target, args);
        }

    }

    private static void printMethodCall(Object target, Method method, Object[] args) {
        // print implicit argument
        System.out.print(target);
        // print method name
        System.out.print("." + method.getName() + "(");

        // print explicit arguments
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}
