/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manga_Hub;

import java.util.*;
import java.io.*;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document; 
import org.jsoup.nodes.Element;
import java.io.FileWriter;

/**
 *
 * @author Mohamed
 */
public class Model implements Observable{
    ArrayList observers;
    Document doc;
    Element listing;
    String tableRows;
    Element lastRow;
    String newChapterLink;
    String newChapterText;
    private String reference;
    FileWriter writer;
    FileReader reader;
    String mangaURL;
    Scanner fileReader;
    
    
    
    
    public Model() {
        this.tableRows = tableRows;
        observers = new ArrayList();  
        
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
            observer.update(tableRows, reference, newChapterLink, newChapterText);
        }
    }
    @Override
    public String parseHTML(String mangaURL) throws IOException {
        doc = Jsoup.connect(mangaURL).get();
        listing = doc.getElementById("listing");
        tableRows = listing.getElementsByTag("a").toString();
        lastRow = listing.getElementsByTag("a").last();
        newChapterLink = lastRow.attr("href");
        newChapterText = lastRow.text();
        notifyObserver();
        return tableRows;
       
    }
    @Override
    public void setFile(String fileName) throws IOException {
        fileReader = new Scanner(new File(fileName));
    }
    @Override
    public String readFile() {
        reference = fileReader.useDelimiter("\\A").next();
        notifyObserver();
        fileReader.close();
        return reference;
    }
    @Override
    public void updateFile(String fileName) throws IOException {
         writer = new FileWriter(fileName);
         writer.write(tableRows);
         writer.close();
         
    }
}
