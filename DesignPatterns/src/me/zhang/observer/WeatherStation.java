package me.zhang.observer;

/**
 * Created by Zhang on 10/8/2015 11:15 下午.
 */
public class WeatherStation {

    public static void main(String[] args) {
        // Subject
        WeatherData weatherData = new WeatherData();

        // Observers
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay();

        // Register
        weatherData.registerObserver(currentConditionsDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);
        weatherData.registerObserver(heatIndexDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println("*************************************");
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println("*************************************");
        weatherData.setMeasurements(78, 90, 29.2f);

    }

}
