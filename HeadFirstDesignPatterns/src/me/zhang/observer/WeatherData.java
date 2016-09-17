package me.zhang.observer;

import java.util.ArrayList;

/**
 * Created by Zhang on 10/8/2015 10:51 下午.
 */
public class WeatherData implements Subject {

    private ArrayList<Observer> observers;

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        // 当从气象站得到更新观测值时，我们通知观察者
        notifyObservers();
    }

    /**
     * 使用你自己的气象站更新观测值，比如，从网站抓取
     *
     * @param temperature 温度
     * @param humidity    湿度
     * @param pressure    气压
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // WeatherData 的其他方法

}
