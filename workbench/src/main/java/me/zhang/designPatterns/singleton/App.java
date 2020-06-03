package me.zhang.designPatterns.singleton;

/**
 * Created by Zhang on 7/29/2017 10:15 AM.
 */
public class App {

    private static final Singleton<FrenchPresident> FRENCH_PRESIDENT_SINGLETON =
            new Singleton<FrenchPresident>() {
                @Override
                protected FrenchPresident create() {
                    return new FrenchPresident();
                }
            };

    private static final Singleton<AmericanPresident> AMERICAN_PRESIDENT_SINGLETON =
            new Singleton<AmericanPresident>() {
                @Override
                protected AmericanPresident create() {
                    return new AmericanPresident();
                }
            };

    public static void main(String[] args) {
        FrenchPresident frenchPresident = FRENCH_PRESIDENT_SINGLETON.get();
        System.out.println(frenchPresident);
        frenchPresident = FRENCH_PRESIDENT_SINGLETON.get();
        System.out.println(frenchPresident);

        AmericanPresident americanPresident = AMERICAN_PRESIDENT_SINGLETON.get();
        System.out.println(americanPresident);
        americanPresident = AMERICAN_PRESIDENT_SINGLETON.get();
        System.out.println(americanPresident);
    }

}
