package me.zhang.coreJava;

import java.util.Arrays;

/**
 * Created by Zhang on 2017/10/13 19:12.
 */
public class EnumTest {

    public enum Size {
        SAMLL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

        private String abbreviation;

        private Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        @Override
        public String toString() {
            return "Size{" +
                    "abbreviation='" + abbreviation + '\'' + ", ordinal=" + ordinal() +
                    '}';
        }
    }

    public static void main(String... args) {
        System.out.println(Size.SAMLL);
        System.out.println(Size.SAMLL.name());
        System.out.println(Arrays.toString(Size.values()));

        Size l = Enum.valueOf(Size.class, Size.LARGE.name());
        System.out.println(l);
    }

}
