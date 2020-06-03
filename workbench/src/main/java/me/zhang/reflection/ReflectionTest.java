package me.zhang.reflection;

import java.lang.reflect.*;

/**
 * Created by Zhang on 12/10/2016 6:29 PM.
 * <p>
 * Reflection == Class Manipulator
 */
public class ReflectionTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Enemy.class;
        String clazzName = clazz.getName();
        System.out.println(clazzName);

        int clsModifier = clazz.getModifiers();
        System.out.println("Class Modifier: " + clsModifier + ", " + Modifier.isPublic(clsModifier));

        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println("Interface: " + i.getName());
        }

        Class superClazz = clazz.getSuperclass();
        System.out.println("Super Class: " + superClazz.getName());

        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            if (m.getName().startsWith("get")) {
                System.out.println("Getter: " + m.getName());
            } else if (m.getName().startsWith("set")) {
                System.out.println("Setter: " + m.getName());
            }
            System.out.println("Return Type: " + m.getReturnType());

            Class[] parameterTypes = m.getParameterTypes();
            for (Class c : parameterTypes) {
                System.out.println("Parameter Type: " + c.getName());
            }
        }

        Constructor constructor = clazz.getConstructor(int.class);
        Class[] constructParameters = constructor.getParameterTypes();
        for (Class c : constructParameters) {
            System.out.println("Constructor Parameters: " + c.getName());
        }

        Object enemy = clazz.getConstructor(int.class).newInstance(123);
        System.out.println("Vitality: " + ((Enemy) enemy).getVitality());

        Field field = clazz.getDeclaredField("vitality");
        field.setAccessible(true);
        System.out.println("Field: " + field.getName() + ", Values: " + field.getInt(enemy));

        Method innerGetter = clazz.getDeclaredMethod("innerGetter");
        innerGetter.setAccessible(true);
        System.out.println(innerGetter.invoke(enemy));

        Class[] parameterTypes = new Class[]{Integer.TYPE};
        Object[] parameterArgs = new Object[]{new Integer(789)};

        Method setVitality = clazz.getDeclaredMethod("setVitality", parameterTypes);
        setVitality.setAccessible(true);
        setVitality.invoke(enemy, parameterArgs);
        System.out.println(innerGetter.invoke(enemy));
    }

}
