/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manga_Hub;

/**
 *
 * @author Mohamed
 */
import java.io.*;
import javax.swing.UnsupportedLookAndFeelException;
public class Controller implements ControllerInterface {
    Observable model;
    View view;
    String mangaURL;
    String fileName;
    
    public Controller(Observable model) throws IOException, UnsupportedLookAndFeelException {
        this.model = model;
        view = new View(model, this);
        view.createViews();
    }
    
    @Override
    public String checkForUpdates(String mangaURL) throws IOException{
        return model.parseHTML(mangaURL);
    }
    @Override
    public void selectFile(String fileName) throws IOException {
        model.setFile(fileName);
    }
    @Override
    public String readReference() {
        return model.readFile();
    }
    @Override
    public void updateReference(String fileName) throws IOException {
        model.updateFile(fileName);
    }
}
