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

public interface ControllerInterface {
    
    public String checkForUpdates(String mangaURL) throws IOException;
    public void selectFile(String fileName) throws IOException;
    public String readReference();
    public void updateReference(String fileName) throws IOException;
}
