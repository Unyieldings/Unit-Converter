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
import javax.swing.UnsupportedLookAndFeelException;

public class Manga_Hub {
    
    

    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException {
        Model model = new Model();
        ControllerInterface controller = new Controller(model);
    }
}
