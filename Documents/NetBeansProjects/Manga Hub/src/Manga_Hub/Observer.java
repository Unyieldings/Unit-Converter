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
public interface Observer {
    public void update(String tableRows, String reference, String newChapterLink, String newChapterText);
}
