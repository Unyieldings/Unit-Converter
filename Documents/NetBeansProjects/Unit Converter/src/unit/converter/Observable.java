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
public interface Observable {
    
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
    public double millimeterToCentimeter(double num);
    public double centimeterToMillimeter(double num);
    public double centimeterToMeter(double num);
    public double meterToCentimeter(double num);
    public double meterToKilometer(double num);
    public double kilometerToMeter(double num);
    public double millimeterToMeter(double num);
    public double meterToMillimeter(double num);
    public double millimeterToKilometer(double num);
    public double kilometerToMillimeter(double num);
    public double centimeterToKilometer(double num);
    public double kilometerToCentimeter(double num);
    public double inchToMillimeter(double num);
    public double millimeterToInch(double num);
    public double inchToCentimeter(double num);
    public double centimeterToInch(double num);
    public double inchToMeter(double num);
    public double meterToInch(double num);
    public double inchToKilometer(double num);
    public double kilometerToInch(double num);
    public double footToMillimeter(double num);
    public double millimeterToFoot(double num);
    public double footToCentimeter(double num);
    public double centimeterToFoot(double num);
    public double footToMeter(double num);
    public double meterToFoot(double num);
    public double footToKilometer(double num);
    public double kilometerToFoot(double num);
    public double inchToFoot(double num);
    public double footToInch(double num);
}
