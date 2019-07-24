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
import java.io.IOException;  

public interface Observable {
    
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
    public String parseHTML(String mangaURL) throws IOException;
    public void setFile(String fileName) throws IOException;
    public String readFile();
    public void updateFile(String fileName) throws IOException;
}
