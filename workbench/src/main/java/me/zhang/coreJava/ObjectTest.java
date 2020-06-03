package me.zhang.coreJava;

import java.util.UUID;

/**
 * Created by Zhang on 10/3/2017 1:07 PM.
 */
public class ObjectTest {

    public static void main(String[] args) {
        Order order = new Order("食品订单");
        System.out.println("  order: " + order);
        System.out.println("\t" + order.getSerial());
        System.out.println("\t" + order.getDetail());
        try {
            Order another = order.clone();
            System.out.println("another: " + another);
            System.out.println("\t" + another.getSerial());
            System.out.println("\t" + another.getDetail());

            System.out.println(order != another); // is the same object?
            System.out.println(order.getClass() == another.getClass()); // is the same type of class?
            System.out.println(order.equals(another)); // has same contents?
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    static class Order implements Cloneable {
        private String serial;
        private String detail;

        public Order() {
            this.serial = UUID.randomUUID().toString();
        }

        public Order(String detail) {
            this();
            this.detail = detail;
        }

        public String getSerial() {
            return serial;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Order) {
                Order another = (Order) obj;
                return serial.equals(another.serial) && detail.equals(another.detail);
            }
            return false;
        }

        /**
         * @return Cloned object
         * @throws CloneNotSupportedException exception
         * @see Cloneable
         */
        // must be public modifier.
        @Override
        public Order clone() throws CloneNotSupportedException {
            Order cloned = (Order) super.clone();
            // serial is unique
            cloned.serial = UUID.randomUUID().toString();
            return cloned;
        }
    }

}
