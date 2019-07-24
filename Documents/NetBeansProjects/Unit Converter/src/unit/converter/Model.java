/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.converter;

/**
 *
 * @author Mohamed
 */
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Model implements Observable {
    private double num;
    private double conversion;
    DecimalFormat df;
    ArrayList observers;
    
    public Model() {
        observers = new ArrayList();
        df = new DecimalFormat("#.###");
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0) {
            observers.remove(i);
        }
    }
    @Override
    public void notifyObserver() {
        for(int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(conversion);
        }
    }
    @Override
    public double millimeterToCentimeter(double num) {
        conversion = num / 10;
        notifyObserver();
        return conversion;
    }
    @Override
    public double centimeterToMillimeter(double num) {
        conversion = num * 10;
        notifyObserver();
        return conversion;
    }
    @Override
    public double centimeterToMeter(double num) {
        conversion = num / 100;
        notifyObserver();
        return conversion;
    }
    @Override
    public double meterToCentimeter(double num) {
        conversion = num * 100;
        notifyObserver();
        return conversion;
    }
    @Override
    public double meterToKilometer(double num) {
        conversion = num / 1000;
        notifyObserver();
        return conversion;
    }
    @Override
    public double kilometerToMeter(double num) {
        conversion = num * 1000;
        notifyObserver();
        return conversion;
    }
    @Override
    public double millimeterToMeter(double num) {
        conversion = num / 1000;
        notifyObserver();
        return conversion;
    }
    @Override
    public double meterToMillimeter(double num) {
        conversion = num * 1000;
        notifyObserver();
        return conversion;
    }
    @Override
    public double millimeterToKilometer(double num) {
        conversion = num / 1000000;
        notifyObserver();
        return conversion;
    }
    @Override
    public double kilometerToMillimeter(double num) {
        conversion = num * 1000000;
        notifyObserver();
        return conversion;
    }
    @Override
    public double centimeterToKilometer(double num) {
        conversion = num / 100000;
        notifyObserver();
        return conversion;
    }
    @Override
    public double kilometerToCentimeter(double num) {
        conversion = num * 100000;
        notifyObserver();
        return conversion;
    }
    @Override
    public double inchToMillimeter(double num) {
        conversion = num * 25.4;
        notifyObserver();
        return conversion;
    }
    @Override
    public double millimeterToInch(double num) {
        conversion = num / 25.4;
        notifyObserver();
        return conversion;
    }
    @Override
    public double inchToCentimeter(double num) {
        conversion = num * 2.54;
        notifyObserver();
        return conversion;
    }
    @Override
    public double centimeterToInch(double num) {
        conversion = num / 2.54;
        notifyObserver();
        return conversion;
    }
    @Override
    public double inchToMeter(double num) {
        conversion = num / 39.37;
        notifyObserver();
        return conversion;
    }
    @Override
    public double meterToInch(double num) {
        conversion = num * 39.37;
        notifyObserver();
        return conversion;
    }
    @Override
    public double inchToKilometer(double num) {
        conversion = num / 39370.079;
        notifyObserver();
        return conversion;
    }
    @Override
    public double kilometerToInch(double num) {
        conversion = num * 39370.079;
        notifyObserver();
        return conversion;
    }
    @Override
    public double footToMillimeter(double num) {
        conversion = num * 304.8;
        notifyObserver();
        return conversion;
    }
    @Override
    public double millimeterToFoot(double num) {
        conversion = num / 304.8;
        notifyObserver();
        return conversion;
    }
    @Override
    public double footToCentimeter(double num) {
        conversion = num * 30.48;
        notifyObserver();
        return conversion;
    }
    @Override
    public double centimeterToFoot(double num) {
        conversion = num / 30.48;
        notifyObserver();
        return conversion;
    }
    @Override
    public double footToMeter(double num) {
        conversion = num / 3.281;
        notifyObserver();
        return conversion;
    }
    @Override
    public double meterToFoot(double num) {
        conversion = num * 3.281;
        notifyObserver();
        return conversion;
    }
    @Override
    public double footToKilometer(double num) {
        conversion = num / 3280.84;
        notifyObserver();
        return conversion;
    }
    @Override
    public double kilometerToFoot(double num) {
        conversion = num * 3280.84;
        notifyObserver();
        return conversion;
    }
    @Override 
    public double inchToFoot(double num) {
        conversion = num / 12;
        notifyObserver();
        return conversion;
    }
    @Override
    public double footToInch(double num) {
        conversion = num * 12;
        notifyObserver();
        return conversion;
        
    }
}
