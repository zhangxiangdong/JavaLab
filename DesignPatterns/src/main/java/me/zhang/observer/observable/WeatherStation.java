package me.zhang.observer.observable;

/**
 * Created by Zhang on 10/19/2015 9:34 下午.
 */
public class WeatherStation {

    public static void main(String[] args) {
        // Observable
        WeatherData weatherData = new WeatherData();

        // Observers
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        // Add observers
        weatherData.addObserver(currentConditionsDisplay);
        weatherData.addObserver(forecastDisplay);

        // Update
        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println("*************************************");
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println("*************************************");
        weatherData.setMeasurements(78, 90, 29.2f);
    }

}
