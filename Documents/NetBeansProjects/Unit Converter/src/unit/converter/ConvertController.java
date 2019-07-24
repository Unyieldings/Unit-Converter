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
public class ConvertController implements ControllerInterface {
    Observable model;
    double num;
    View view;
    
    public ConvertController(Observable model) {
        this.model = model;
        view = new View(model, this);
        view.createViews();
    }
    
    @Override
    public double convert_mmToCm(double num) {
        return model.millimeterToCentimeter(num);
    }
    @Override
    public double convert_cmToMm(double num) {
        return model.centimeterToMillimeter(num);
    }
    @Override
    public double convert_cmToM(double num) {
        return model.centimeterToMeter(num);
    }
    @Override
    public double convert_mToCm(double num) {
        return model.meterToCentimeter(num);
    }
    @Override
    public double convert_mToKm(double num) {
        return model.meterToKilometer(num);
    }
    @Override
    public double convert_kmToM(double num) {
        return model.kilometerToMeter(num);
    }
    @Override
    public double convert_mmToM(double num) {
        return model.millimeterToMeter(num);
    }
    @Override
    public double convert_mToMm(double num) {
        return model.meterToMillimeter(num);
    }
    @Override
    public double convert_mmToKm(double num) {
        return model.millimeterToKilometer(num);
    }
    @Override
    public double convert_kmToMm(double num) {
        return model.kilometerToMillimeter(num);
    }
    @Override
    public double convert_cmToKm(double num) {
        return model.centimeterToKilometer(num);
    }
    @Override
    public double convert_kmToCm(double num) {
        return model.kilometerToCentimeter(num);
    }
    @Override
    public double convert_inchToMm(double num) {
        return model.inchToMillimeter(num);
    }
    @Override
    public double convert_mmToInch(double num) {
        return model.millimeterToInch(num);
    }
    @Override
    public double convert_inchToCm(double num) {
        return model.inchToCentimeter(num);
    }
    @Override
    public double convert_cmToInch(double num) {
        return model.centimeterToInch(num);
    }
    @Override
    public double convert_inchToM(double num) {
        return model.inchToMeter(num);
    }
    @Override
    public double convert_mToInch(double num) {
        return model.meterToInch(num);
    }
    @Override
    public double convert_inchToKm(double num) {
        return model.inchToKilometer(num);
    }
    @Override
    public double convert_kmToInch(double num) {
        return model.kilometerToInch(num);
    }
    @Override
    public double convert_footToMm(double num) {
        return model.footToMillimeter(num);
    }
    @Override
    public double convert_mmToFoot(double num) {
        return model.millimeterToFoot(num);
    }
    @Override
    public double convert_footToCm(double num) {
        return model.footToCentimeter(num);
    }
    @Override
    public double convert_cmToFoot(double num) {
        return model.centimeterToFoot(num);
    }
    @Override
    public double convert_footToM(double num) {
        return model.footToMeter(num);
    }
    @Override
    public double convert_mToFoot(double num) {
        return model.meterToFoot(num);
    }
    @Override
    public double convert_footToKm(double num) {
        return model.footToKilometer(num);
    }
    @Override
    public double convert_kmToFoot(double num) {
        return model.kilometerToFoot(num);
    }
    @Override
    public double convert_inchToFoot(double num) {
        return model.inchToFoot(num);
    }
    @Override
    public double convert_footToInch(double num) {
        return model.footToInch(num);
    }
}
