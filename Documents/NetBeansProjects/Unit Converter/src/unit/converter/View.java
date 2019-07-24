/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.converter;

import java.awt.Image;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Mohamed
 */
public class View implements Observer, ActionListener{
    Observable model;
    ControllerInterface controller;
    double conversion;
    double num;
    JFrame frame;
    JLabel from;
    JLabel to;
    JTextField input;
    JTextField answer;
    JComboBox inputPull;
    JComboBox answerPull;
    JButton convert;
    DecimalFormat df;
    
    public View(Observable model, ControllerInterface controller) {
        this.model = model;
        this.controller = controller;
        model.registerObserver(this);
        df = new DecimalFormat("#.##");
    }
    @Override
    public void update(double conversion) {
        this.conversion = conversion;
    }
    
    public void createViews() {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        frame = new JFrame("Unit Converter");
        frame.setBounds(800, 200, 300, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       ImageIcon iconImg = new ImageIcon(View.class.getResource("images/icon.png"));
       Image iconImgFinal = iconImg.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
       iconImg = new ImageIcon(iconImgFinal);
       frame.setIconImage(iconImg.getImage());
        
        from = new JLabel("From:");
        from.setBounds(20, 10, 50, 20);
        
        to = new JLabel("To:");
        to.setBounds(20, 70, 50, 20);
        
        input = new JTextField();
        input.setBounds(20, 30, 90, 30);
       
        answer = new JTextField();
        answer.setBounds(20, 90, 90, 30);
    
        String[] units = new String[] {"mm", "cm", "m", "km", "inch", "foot"};
        inputPull = new JComboBox(units);
        inputPull.setBounds(108, 30, 50, 29);
        inputPull.addActionListener(this);
          
        answerPull = new JComboBox(units);
        answerPull.setBounds(108, 90, 50, 29);
        answerPull.addActionListener(this);
        
        convert = new JButton("Convert");
        convert.setBounds(170, 60, 90, 30);
        convert.addActionListener(this);
        
        frame.add(from);
        frame.add(to);
        frame.add(input);
        frame.add(answer);
        frame.add(inputPull);
        frame.add(answerPull);
        frame.add(convert);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        
        if(event.getSource() == convert) {
            if(inputPull.getSelectedItem().equals("mm") && answerPull.getSelectedItem().equals("cm")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_mmToCm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("cm") && answerPull.getSelectedItem().equals("mm")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_cmToMm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("cm") && answerPull.getSelectedItem().equals("m")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_cmToM(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("m") && answerPull.getSelectedItem().equals("cm")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_mToCm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("m") && answerPull.getSelectedItem().equals("km")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_mToKm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("km") && answerPull.getSelectedItem().equals("m")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_kmToM(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("mm") && answerPull.getSelectedItem().equals("m")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_mmToM(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("m") && answerPull.getSelectedItem().equals("mm")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_mToMm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("mm") && answerPull.getSelectedItem().equals("km")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_mmToKm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("km") && answerPull.getSelectedItem().equals("mm")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_kmToMm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("cm") && answerPull.getSelectedItem().equals("km")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_cmToKm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("km") && answerPull.getSelectedItem().equals("cm")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_kmToCm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("inch") && answerPull.getSelectedItem().equals("mm")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_inchToMm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("mm") && answerPull.getSelectedItem().equals("inch")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_mmToInch(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("inch") && answerPull.getSelectedItem().equals("cm")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_inchToCm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("cm") && answerPull.getSelectedItem().equals("inch")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_cmToInch(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("inch") && answerPull.getSelectedItem().equals("m")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_inchToM(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("m") && answerPull.getSelectedItem().equals("inch")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_mToInch(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("inch") && answerPull.getSelectedItem().equals("km")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_inchToKm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("km") && answerPull.getSelectedItem().equals("inch")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_kmToInch(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("foot") && answerPull.getSelectedItem().equals("mm")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_footToMm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("mm") && answerPull.getSelectedItem().equals("foot")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_mmToFoot(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("foot") && answerPull.getSelectedItem().equals("cm")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_footToCm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("cm") && answerPull.getSelectedItem().equals("foot")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_cmToFoot(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("foot") && answerPull.getSelectedItem().equals("m")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_footToM(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("m") && answerPull.getSelectedItem().equals("foot")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_mToFoot(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("foot") && answerPull.getSelectedItem().equals("km")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_footToKm(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("km") && answerPull.getSelectedItem().equals("foot")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_kmToFoot(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("inch") && answerPull.getSelectedItem().equals("foot")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_inchToFoot(num);
                answer.setText(df.format(conversion));
            }
            else if(inputPull.getSelectedItem().equals("foot") && answerPull.getSelectedItem().equals("inch")) {
                num = Double.parseDouble(input.getText());
                conversion = controller.convert_footToInch(num);
                answer.setText(df.format(conversion));
            }
                
        }
  
    
    }
}
