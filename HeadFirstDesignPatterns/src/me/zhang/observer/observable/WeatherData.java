package me.zhang.observer.observable;

import java.util.Observable;

/**
 * Created by Zhang on 10/8/2015 10:51 下午.
 */
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {

    }

    public void measurementsChanged() {
        setChanged();
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

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
