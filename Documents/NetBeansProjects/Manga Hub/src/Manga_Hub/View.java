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

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Image;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;


public class View implements Observer, ActionListener, ItemListener, MouseListener, MouseMotionListener {
    Observable model;
    ControllerInterface controller;
    String fileName;
    private String tableRows;
    private String reference;
    private String newChapterLink;
    private String newChapterText;
    private ArrayList<JCheckBox> checkboxList;
    String mangaURL;
    JFrame frame;
    JFrame introFrame;
    JFrame searchFrame;
    JScrollPane scrollpane;
    JTextArea introText;
    JFrame newChapterWindow;
    JFrame noChapterWindow;
    JButton closebtn;
    JLabel chapterTextLabel;
    JButton updateButton1; JButton updateButton2; JButton updateButton3; JButton updateButton4; JButton updateButton5; 
    JButton updateButton6; JButton updateButton7; JButton updateButton8; JButton updateButton9; JButton updateButton10;
    JButton updateButton11; JButton updateButton12; JButton updateButton13; JButton updateButton14; JButton updateButton15;
    JButton updateButton16; JButton updateButton17; JButton updateButton18;
    JButton introButton;
    JLabel notification;
    JLabel checkItOut;
    JButton goToNewChapter;
    JButton cancel;
    JLabel noChapterMessage;
    Image onePieceImg;
    JPanel container;
    JPanel panelOP; JPanel panelHA; JPanel panelOPM; JPanel panelAOT; JPanel panelSDS;
    JPanel panelPM; JPanel panelHai; JPanel panelFW; JPanel panelRein; JPanel panelBL;
    JPanel panelHaj; JPanel panelBor; JPanel panelHXH; JPanel panelGin; JPanel panelStone;
    JPanel panelKing; JPanel panelSuper; JPanel panelAce;
    JLabel onePieceLabel; JLabel academiaLabel; JLabel onePunchLabel; JLabel AOTlabel; JLabel SDSLabel;
    JLabel neverlandLabel; JLabel haikyuuLabel; JLabel foodWarsLabel; JLabel reincarnatedLabel; JLabel blackCloverLabel;
    JLabel hajimeLabel; JLabel borutoLabel; JLabel HXHLabel; JLabel gintamaLabel; JLabel stoneLabel; JLabel kingLabel;
    JLabel superLabel; JLabel aceLabel;
    JLabel header;
    JPanel navbar;
    JComboBox searchBar;
    JPanel containerMain;
    JPanel searchContainer;
    JLabel searchLabel;
    JPanel containerGrid;
    JPanel favoriteContainer;
    JLabel onePiece; JLabel heroAca; JLabel onePunch; JLabel AOT; JLabel SDS; 
    JLabel Neverland; JLabel haikyuu; JLabel foodWars; JLabel reincarnated; JLabel reincarnated2; JLabel blackClover;
    JLabel hajime; JLabel boruto; JLabel HXH; JLabel gintama; JLabel stone; JLabel kingdom; JLabel DBSuper; JLabel ace;
    JCheckBox OPCheck; JCheckBox HACheck; JCheckBox OPMCheck; JCheckBox AOTCheck; JCheckBox SDSCheck;
    JCheckBox PMCheck; JCheckBox haiCheck; JCheckBox FWCheck; JCheckBox reinCheck; JCheckBox BLCheck;
    JCheckBox hajCheck; JCheckBox borCheck; JCheckBox HXHCheck; JCheckBox ginCheck; JCheckBox stoneCheck;
    JCheckBox kingCheck; JCheckBox superCheck; JCheckBox aceCheck;
    int OPFlag; int HAFlag; int OPMFlag; int AOTFlag; int SDSFlag; int PMFlag; int haiFlag; int FWFlag; int reinFlag; int BLFlag;
    int hajFlag; int borFlag; int HXHFlag; int ginFlag; int stoneFlag; int kingFlag; int superFlag; int aceFlag;
    ImageIcon opPic;
    JPanel border;
    Font font;
    Float size; Float sizeHeader; Float sizeNotify;
    
    public View(Observable model, ControllerInterface controller) {
        this.model = model;
        this.controller = controller;
        model.registerObserver(this);
    }
    
    @Override
    public void update(String tableRows, String reference, String newChapterLink, String newChapterText) {
        this.tableRows = tableRows;
        this.reference = reference;
        this.newChapterLink = newChapterLink;
        this.newChapterText = newChapterText;
    }
    
    public void createViews() throws IOException {
        
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
        
       frame = new JFrame("Manga Hub");
       
       sizeHeader = new Float(13.0);
       header = new JLabel("Manga Hub - One stop location to check for newly released chapters");
       header.setFont(header.getFont().deriveFont(sizeHeader));
       searchLabel = new JLabel("Search:");
       searchBar = new JComboBox(new String[] {"All", "Custom", "One Piece", "My Hero Academia", "One-Punch Man", "Attack On Titan", "Seven Deadly Sins",
                          "Promised Neverland", "Haikyuu!!", "Shokugeki no Soma", "That Time I Got Reincarnated as a Slime", "Black Clover",
                           "Hajime no Ippo", "Boruto", "Hunter X Hunter", "Gintama", "Dr. Stone", "Kingdom", "Dragon Ball Super", "Diamond no Ace Act II"});
       introButton = new JButton("Instructions");
       introButton.addActionListener(this);
       
       Font fontType = new Font(Font.SERIF, Font.PLAIN,  17);
       
       String text = new String("Welcome to Manga Hub! A one-stop location to check for newly released chapters from your favourite manga titles. Simply click on the 'Check for updates' button under the manga title of your choice to see if there are any new chapter releases. Manga Hub is connected to Manga Panda (www.mangapanda.com), so new chapter notifications will be coming from Manga Panda's updates. \n \n" +
"All first-time clicking attempts will generate a new chapter notification pointing at the latest chapter. All other subsequent attempts will wait for a true releasement of a new chapter before notifying you of the release. \n \nThe manga titles of your choice can be 'favourited' to create your own customizable panel when going to the 'Custom' option in the dropdown menu. Your customizations will be saved when closing the app and will be available again on startup. \n \nEnjoy a more efficient and dynamic experience when checking for newly released chapters with Manga Hub. \n \n-Mahim");
      
       introText = new JTextArea(text);
       introText.setFont(fontType);
       introText.setSize(500, 600);
       introText.setLineWrap(true);
       introText.setWrapStyleWord(true);
       introText.setEditable(false);
       
       JPanel introContainer = new JPanel();
       introContainer.add(introText);
       introFrame = new JFrame("Instructions");
       introFrame.setResizable(false);
       introFrame.add(introContainer);
       introFrame.pack();
       introFrame.setVisible(false);
        
       searchBar.addActionListener(this);
       navbar = new JPanel();
       navbar.add(introButton);
       navbar.add(searchLabel);
       navbar.add(searchBar);
      
       panelOP = new JPanel();
       panelOP.setLayout(new BoxLayout(panelOP, BoxLayout.Y_AXIS));
       panelHA = new JPanel();
       panelHA.setLayout(new BoxLayout(panelHA, BoxLayout.Y_AXIS));
       panelOPM = new JPanel();
       panelOPM.setLayout(new BoxLayout(panelOPM, BoxLayout.Y_AXIS));     
       panelAOT = new JPanel();
       panelAOT.setLayout(new BoxLayout(panelAOT, BoxLayout.Y_AXIS));
       panelSDS = new JPanel();
       panelSDS.setLayout(new BoxLayout(panelSDS, BoxLayout.Y_AXIS));
       panelPM = new JPanel();
       panelPM.setLayout(new BoxLayout(panelPM, BoxLayout.Y_AXIS));
       panelHai = new JPanel();
       panelHai.setLayout(new BoxLayout(panelHai, BoxLayout.Y_AXIS));
       panelFW = new JPanel();
       panelFW.setLayout(new BoxLayout(panelFW, BoxLayout.Y_AXIS));
       panelRein = new JPanel();
       panelRein.setLayout(new BoxLayout(panelRein, BoxLayout.Y_AXIS));
       panelBL = new JPanel();
       panelBL.setLayout(new BoxLayout(panelBL, BoxLayout.Y_AXIS));
       panelHaj = new JPanel();
       panelHaj.setLayout(new BoxLayout(panelHaj, BoxLayout.Y_AXIS));
       panelBor = new JPanel();
       panelBor.setLayout(new BoxLayout(panelBor, BoxLayout.Y_AXIS));
       panelHXH = new JPanel();
       panelHXH.setLayout(new BoxLayout(panelHXH, BoxLayout.Y_AXIS));
       panelGin = new JPanel();
       panelGin.setLayout(new BoxLayout(panelGin, BoxLayout.Y_AXIS));
       panelStone = new JPanel();
       panelStone.setLayout(new BoxLayout(panelStone, BoxLayout.Y_AXIS));
       panelKing = new JPanel();
       panelKing.setLayout(new BoxLayout(panelKing, BoxLayout.Y_AXIS));
       panelSuper = new JPanel();
       panelSuper.setLayout(new BoxLayout(panelSuper, BoxLayout.Y_AXIS));
       panelAce = new JPanel();
       panelAce.setLayout(new BoxLayout(panelAce, BoxLayout.Y_AXIS));
       
       
       updateButton1 = new JButton("Check for updates");
       updateButton1.addActionListener(this);
       updateButton2 = new JButton("Check for updates");
       updateButton2.addActionListener(this);
       updateButton3 = new JButton("Check for updates");
       updateButton3.addActionListener(this);
       updateButton4 = new JButton("Check for updates");
       updateButton4.addActionListener(this);
       updateButton5 = new JButton("Check for updates");
       updateButton5.addActionListener(this);
       updateButton6 = new JButton("Check for updates");
       updateButton6.addActionListener(this);
       updateButton7 = new JButton("Check for updates");
       updateButton7.addActionListener(this);
       updateButton8 = new JButton("Check for updates");
       updateButton8.addActionListener(this);
       updateButton9 = new JButton("Check for updates");
       updateButton9.addActionListener(this);
       updateButton10 = new JButton("Check for updates");
       updateButton10.addActionListener(this);
       updateButton11 = new JButton("Check for updates");
       updateButton11.addActionListener(this);
       updateButton12 = new JButton("Check for updates");
       updateButton12.addActionListener(this);
       updateButton13 = new JButton("Check for updates");
       updateButton13.addActionListener(this);
       updateButton14 = new JButton("Check for updates");
       updateButton14.addActionListener(this);
       updateButton15 = new JButton("Check for updates");
       updateButton15.addActionListener(this);
       updateButton16 = new JButton("Check for updates");
       updateButton16.addActionListener(this);
       updateButton17 = new JButton("Check for updates");
       updateButton17.addActionListener(this);
       updateButton18 = new JButton("Check for updates");
       updateButton18.addActionListener(this);
       
       onePiece = new JLabel("One Piece");
       onePiece.addMouseListener(this);
       onePiece.addMouseMotionListener(this);
       heroAca = new JLabel("My Hero Academia");
       heroAca.addMouseListener(this);
       heroAca.addMouseMotionListener(this);
       onePunch = new JLabel("One-Punch Man");
       onePunch.addMouseListener(this);
       onePunch.addMouseMotionListener(this);
       AOT = new JLabel("Attack On Titan");
       AOT.addMouseListener(this);
       AOT.addMouseMotionListener(this);
       SDS = new JLabel("Seven Deadly Sins");
       SDS.addMouseListener(this);
       SDS.addMouseMotionListener(this);
       Neverland = new JLabel("Promised Neverland");
       Neverland.addMouseListener(this);
       Neverland.addMouseMotionListener(this);
       haikyuu = new JLabel("Haikyuu!!");
       haikyuu.addMouseListener(this);
       haikyuu.addMouseMotionListener(this);
       foodWars = new JLabel("Shokugeki no Soma");
       foodWars.addMouseListener(this);
       foodWars.addMouseMotionListener(this);
       reincarnated = new JLabel("That Time I Got");
       reincarnated.addMouseListener(this);
       reincarnated.addMouseMotionListener(this);
       reincarnated2 = new JLabel("Reincarnated as a Slime");
       reincarnated2.addMouseListener(this);
       reincarnated2.addMouseMotionListener(this);
       blackClover = new JLabel("Black Clover");
       blackClover.addMouseListener(this);
       blackClover.addMouseMotionListener(this);
       hajime = new JLabel("Hajime no ippo");
       hajime.addMouseListener(this);
       hajime.addMouseMotionListener(this);
       boruto = new JLabel("Boruto");
       boruto.addMouseListener(this);
       boruto.addMouseMotionListener(this);
       HXH = new JLabel("Hunter X Hunter");
       HXH.addMouseListener(this);
       HXH.addMouseMotionListener(this);
       gintama = new JLabel("Gintama");
       gintama.addMouseListener(this);
       gintama.addMouseMotionListener(this);
       stone = new JLabel("Dr. Stone");
       stone.addMouseListener(this);
       stone.addMouseMotionListener(this);
       kingdom = new JLabel("Kingdom");
       kingdom.addMouseListener(this);
       kingdom.addMouseMotionListener(this);
       DBSuper = new JLabel("Dragon Ball Super");
       DBSuper.addMouseListener(this);
       DBSuper.addMouseMotionListener(this);
       ace = new JLabel("Diamond no Ace ActII");
       ace.addMouseListener(this);
       ace.addMouseMotionListener(this);
       
       size = new Float(15.0);
       
       onePiece.setFont(onePiece.getFont().deriveFont(size));
       heroAca.setFont(heroAca.getFont().deriveFont(size));
       onePunch.setFont(onePunch.getFont().deriveFont(size));
       AOT.setFont(AOT.getFont().deriveFont(size));
       SDS.setFont(SDS.getFont().deriveFont(size));
       Neverland.setFont(Neverland.getFont().deriveFont(size));
       haikyuu.setFont(haikyuu.getFont().deriveFont(size));
       foodWars.setFont(foodWars.getFont().deriveFont(size));
       reincarnated.setFont(reincarnated.getFont().deriveFont(sizeHeader));
       reincarnated2.setFont(reincarnated2.getFont().deriveFont(sizeHeader));
       blackClover.setFont(blackClover.getFont().deriveFont(size));
       hajime.setFont(hajime.getFont().deriveFont(size));
       boruto.setFont(boruto.getFont().deriveFont(size));
       HXH.setFont(HXH.getFont().deriveFont(size));
       gintama.setFont(gintama.getFont().deriveFont(size));
       stone.setFont(stone.getFont().deriveFont(size));
       kingdom.setFont(kingdom.getFont().deriveFont(size));
       DBSuper.setFont(DBSuper.getFont().deriveFont(size));
       ace.setFont(ace.getFont().deriveFont(size));
       
       OPCheck = new JCheckBox("Favourite");
       OPCheck.addItemListener(this);
       HACheck = new JCheckBox("Favourite");
       HACheck.addItemListener(this);
       OPMCheck = new JCheckBox("Favourite");
       OPMCheck.addItemListener(this);
       AOTCheck = new JCheckBox("Favourite");
       AOTCheck.addItemListener(this);
       SDSCheck = new JCheckBox("Favourite");
       SDSCheck.addItemListener(this);
       PMCheck = new JCheckBox("Favourite");
       PMCheck.addItemListener(this);
       haiCheck = new JCheckBox("Favourite");
       haiCheck.addItemListener(this);
       FWCheck = new JCheckBox("Favourite");
       FWCheck.addItemListener(this);
       reinCheck = new JCheckBox("Favourite");
       reinCheck.addItemListener(this);
       BLCheck = new JCheckBox("Favourite");
       BLCheck.addItemListener(this);
       hajCheck = new JCheckBox("Favourite");
       hajCheck.addItemListener(this);
       borCheck = new JCheckBox("Favourite");
       borCheck.addItemListener(this);
       HXHCheck = new JCheckBox("Favourite");
       HXHCheck.addItemListener(this);
       ginCheck = new JCheckBox("Favourite");
       ginCheck.addItemListener(this);
       stoneCheck = new JCheckBox("Favourite");
       stoneCheck.addItemListener(this);
       kingCheck = new JCheckBox("Favourite");
       kingCheck.addItemListener(this);
       superCheck = new JCheckBox("Favourite");
       superCheck.addItemListener(this);
       aceCheck = new JCheckBox("Favourite");
       aceCheck.addItemListener(this);
       
       
       checkboxList = new ArrayList<JCheckBox>();
       checkboxList.add(OPCheck);
       checkboxList.add(HACheck);
       checkboxList.add(OPMCheck);
       checkboxList.add(AOTCheck);
       checkboxList.add(SDSCheck);
       checkboxList.add(PMCheck);
       checkboxList.add(haiCheck);
       checkboxList.add(FWCheck);
       checkboxList.add(reinCheck);
       checkboxList.add(BLCheck);
       checkboxList.add(hajCheck);
       checkboxList.add(borCheck);
       checkboxList.add(HXHCheck);
       checkboxList.add(ginCheck);
       checkboxList.add(stoneCheck);
       checkboxList.add(kingCheck);
       checkboxList.add(superCheck);
       checkboxList.add(aceCheck);
       
       BufferedReader reader = new BufferedReader(new FileReader("savedData.txt"));
       OPCheck.setSelected(Boolean.parseBoolean(reader.readLine())); 
       HACheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       OPMCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       AOTCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       SDSCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       PMCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       haiCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       FWCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       reinCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       BLCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       hajCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       borCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       HXHCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       ginCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       stoneCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       kingCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       superCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       aceCheck.setSelected(Boolean.parseBoolean(reader.readLine()));
       
       opPic = new ImageIcon(View.class.getResource("images/onePieceImg.png"));
       Image opPicFinal = opPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       opPic = new ImageIcon(opPicFinal);
       onePieceLabel = new JLabel(opPic);
       panelOP.add(onePieceLabel);
       panelOP.add(onePiece);
       panelOP.add(OPCheck);
       panelOP.add(updateButton1);
     
       ImageIcon bhaPic = new ImageIcon(View.class.getResource("images/heroAcademiaImg.png"));
       Image bhaPicFinal = bhaPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       bhaPic = new ImageIcon(bhaPicFinal);
       academiaLabel = new JLabel(bhaPic);
       panelHA.add(academiaLabel);
       panelHA.add(heroAca);
       panelHA.add(HACheck);
       panelHA.add(updateButton2);
       
       ImageIcon opmPic = new ImageIcon(View.class.getResource("images/onePunchManImg.png"));
       Image opmPicFinal = opmPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       opmPic = new ImageIcon(opmPicFinal);
       onePunchLabel = new JLabel(opmPic);
       panelOPM.add(onePunchLabel);
       panelOPM.add(onePunch);
       panelOPM.add(OPMCheck);
       panelOPM.add(updateButton3);
       
       ImageIcon AOTPic = new ImageIcon(View.class.getResource("images/AOTImg.jpg"));
       Image AOTPicFinal = AOTPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       AOTPic = new ImageIcon(AOTPicFinal);
       AOTlabel = new JLabel(AOTPic);
       panelAOT.add(AOTlabel);
       panelAOT.add(AOT);
       panelAOT.add(AOTCheck);
       panelAOT.add(updateButton4);
       
       ImageIcon SDSPic = new ImageIcon(View.class.getResource("images/SDSImg.png"));
       Image SDSPicFinal = SDSPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       SDSPic = new ImageIcon(SDSPicFinal);
       SDSLabel = new JLabel(SDSPic);
       panelSDS.add(SDSLabel);
       panelSDS.add(SDS);
       panelSDS.add(SDSCheck);
       panelSDS.add(updateButton5);
       
       ImageIcon neverlandPic = new ImageIcon(View.class.getResource("images/NeverlandImg.jpg"));
       Image neverlandPicFinal = neverlandPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       neverlandPic = new ImageIcon(neverlandPicFinal);
       neverlandLabel = new JLabel(neverlandPic);
       panelPM.add(neverlandLabel);
       panelPM.add(Neverland);
       panelPM.add(PMCheck);
       panelPM.add(updateButton6);
       
       ImageIcon haikyuuPic = new ImageIcon(View.class.getResource("images/haikyuuImg.jpg"));
       Image haikyuuPicFinal = haikyuuPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       haikyuuPic = new ImageIcon(haikyuuPicFinal);
       haikyuuLabel = new JLabel(haikyuuPic);
       panelHai.add(haikyuuLabel);
       panelHai.add(haikyuu);
       panelHai.add(haiCheck);
       panelHai.add(updateButton7);
       
       ImageIcon foodWarsPic = new ImageIcon(View.class.getResource("images/foodWarsImg.jpg")); 
       Image foodWarsPicFinal = foodWarsPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       foodWarsPic = new ImageIcon(foodWarsPicFinal);
       foodWarsLabel = new JLabel(foodWarsPic);
       panelFW.add(foodWarsLabel);
       panelFW.add(foodWars);
       panelFW.add(FWCheck);
       panelFW.add(updateButton8);
       
       ImageIcon reincarnatedPic = new ImageIcon(View.class.getResource("images/reincarnatedAsASlimeImg.jpg")); 
       Image reincarnatedPicFinal = reincarnatedPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       reincarnatedPic = new ImageIcon(reincarnatedPicFinal);
       reincarnatedLabel = new JLabel(reincarnatedPic);
       panelRein.add(reincarnatedLabel);
       panelRein.add(reincarnated);
       panelRein.add(reincarnated2);
       panelRein.add(reinCheck);
       panelRein.add(updateButton9);
       
       ImageIcon blackCloverPic = new ImageIcon(View.class.getResource("images/blackCloverImg.png"));
       Image blackCloverPicFinal = blackCloverPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       blackCloverPic = new ImageIcon(blackCloverPicFinal);
       blackCloverLabel = new JLabel(blackCloverPic);
       panelBL.add(blackCloverLabel);
       panelBL.add(blackClover);
       panelBL.add(BLCheck);
       panelBL.add(updateButton10);
       
       ImageIcon hajimePic = new ImageIcon(View.class.getResource("images/hajimeImg.jpg"));
       Image hajimePicFinal = hajimePic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       hajimePic = new ImageIcon(hajimePicFinal);
       hajimeLabel = new JLabel(hajimePic);
       panelHaj.add(hajimeLabel);
       panelHaj.add(hajime);
       panelHaj.add(hajCheck);
       panelHaj.add(updateButton11);
       
       ImageIcon borutoPic = new ImageIcon(View.class.getResource("images/borutoImg.png")); 
       Image borutoPicFinal = borutoPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       borutoPic = new ImageIcon(borutoPicFinal);
       borutoLabel = new JLabel(borutoPic);
       panelBor.add(borutoLabel);
       panelBor.add(boruto);
       panelBor.add(borCheck);
       panelBor.add(updateButton12);
       
       ImageIcon HXHPic = new ImageIcon(View.class.getResource("images/HXHImg.png")); 
       Image HXHPicFinal = HXHPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       HXHPic = new ImageIcon(HXHPicFinal);
       HXHLabel = new JLabel(HXHPic);
       panelHXH.add(HXHLabel);
       panelHXH.add(HXH);
       panelHXH.add(HXHCheck);
       panelHXH.add(updateButton13);
       
       ImageIcon ginPic = new ImageIcon(View.class.getResource("images/gintamaImg.jpg"));
       Image ginPicFinal = ginPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       ginPic = new ImageIcon(ginPicFinal);
       gintamaLabel = new JLabel(ginPic);
       panelGin.add(gintamaLabel);
       panelGin.add(gintama);
       panelGin.add(ginCheck);
       panelGin.add(updateButton14);
       
       ImageIcon stonePic = new ImageIcon(View.class.getResource("images/stoneImg.jpg"));
       Image stonePicFinal = stonePic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       stonePic = new ImageIcon(stonePicFinal);
       stoneLabel = new JLabel(stonePic);
       panelStone.add(stoneLabel);
       panelStone.add(stone);
       panelStone.add(stoneCheck);
       panelStone.add(updateButton15);
       
       ImageIcon kingPic = new ImageIcon(View.class.getResource("images/kingdomImg.png"));
       Image kingPicFinal = kingPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       kingPic = new ImageIcon(kingPicFinal);
       kingLabel = new JLabel(kingPic);
       panelKing.add(kingLabel);
       panelKing.add(kingdom);
       panelKing.add(kingCheck);
       panelKing.add(updateButton16);
       
       ImageIcon superPic = new ImageIcon(View.class.getResource("images/superImg.jpg"));
       Image superPicFinal = superPic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       superPic = new ImageIcon(superPicFinal);
       superLabel = new JLabel(superPic);
       panelSuper.add(superLabel);
       panelSuper.add(DBSuper);
       panelSuper.add(superCheck);
       panelSuper.add(updateButton17);
       
       ImageIcon acePic = new ImageIcon(View.class.getResource("images/aceImg.png"));
       Image acePicFinal = acePic.getImage().getScaledInstance(138, 138, Image.SCALE_SMOOTH);
       acePic = new ImageIcon(acePicFinal);
       aceLabel = new JLabel(acePic);
       panelAce.add(aceLabel);
       panelAce.add(ace);
       panelAce.add(aceCheck);
       panelAce.add(updateButton18);
       
       container = new JPanel(new GridLayout(6, 3, 10 , 20));
       container.setSize(200, 200);
       
       container.add(panelOP); container.add(panelHA); container.add(panelOPM); container.add(panelAOT); container.add(panelSDS); 
       container.add(panelPM); container.add(panelHai); container.add(panelFW); container.add(panelRein); container.add(panelBL);
       container.add(panelHaj); container.add(panelBor); container.add(panelHXH); container.add(panelGin); container.add(panelStone);
       container.add(panelKing); container.add(panelSuper); container.add(panelAce);
       
       containerGrid = new JPanel();
       containerGrid.add(container);
       searchContainer = new JPanel();
       searchContainer.setLayout(new FlowLayout());
       searchContainer.setVisible(false);
       searchContainer.setBorder(new EmptyBorder(30, 10, 10, 10));
       searchContainer.setVisible(false);
       favoriteContainer = new JPanel();
       favoriteContainer.setVisible(false);
      
       containerMain = new JPanel();
       containerMain.setLayout(new FlowLayout());
       containerMain.add(navbar);
       containerMain.add(searchContainer);
       containerMain.add(favoriteContainer);
       containerMain.add(containerGrid);
       
       containerMain.setLayout(new BoxLayout(containerMain, BoxLayout.Y_AXIS));
       scrollpane = new JScrollPane(containerMain, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     
       ImageIcon iconImg = new ImageIcon(View.class.getResource("images/IconImg.png"));
       Image iconImgFinal = iconImg.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
       iconImg = new ImageIcon(iconImgFinal);
       frame.setIconImage(iconImg.getImage());
       introFrame.setIconImage(iconImg.getImage());
       frame.add(header, BorderLayout.NORTH);
       frame.add(scrollpane);
       
       frame.setResizable(false);
       frame.pack();
       frame.setBounds(700, 5, 530, 600);
       frame.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        PrintWriter fw;
            try {
                fw = new PrintWriter("savedData.txt", "UTF-8");
                for(int i=0; i < checkboxList.size(); i++) {
                    fw.println(checkboxList.get(i).isSelected()); 
                }
                fw.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
    }
});
       frame.setVisible(true);
       
       sizeNotify = new Float(13.0);
       
       newChapterWindow = new JFrame();
       newChapterWindow.setBounds(500, 125, 250, 200);
       noChapterWindow = new JFrame();
       noChapterWindow.setBounds(500, 125, 250, 200);
       noChapterWindow.setIconImage(iconImg.getImage());
       noChapterMessage = new JLabel("Sorry, no new chapter");
       noChapterMessage.setFont(noChapterMessage.getFont().deriveFont(sizeNotify));
       noChapterMessage.setBounds(30, 20, 150, 50);
       closebtn = new JButton("Close");
       closebtn.setBounds(30, 90, 70, 20);
       closebtn.addActionListener(this);
       noChapterWindow.add(noChapterMessage);
       noChapterWindow.add(closebtn);
       noChapterWindow.setLayout(null);
       
       notification = new JLabel("New chapter!");
       notification.setBounds(30, 0, 150, 50);
       notification.setFont(notification.getFont().deriveFont(sizeNotify));
       chapterTextLabel = new JLabel("");
       checkItOut = new JLabel("Check it out?");
       checkItOut.setBounds(30, 40, 150, 50);
       checkItOut.setFont(checkItOut.getFont().deriveFont(sizeNotify));
       goToNewChapter = new JButton("Yes");
       goToNewChapter.setBounds(30, 100, 60, 20);
       goToNewChapter.addActionListener(this);
       cancel = new JButton("No");
       cancel.setBounds(100, 100, 60, 20);
       cancel.addActionListener(this);
       newChapterWindow.setIconImage(iconImg.getImage());
       newChapterWindow.add(notification);
       newChapterWindow.add(chapterTextLabel);
       newChapterWindow.add(checkItOut);
       newChapterWindow.add(goToNewChapter);
       newChapterWindow.add(cancel);
       newChapterWindow.setLayout(null);
       
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == onePiece) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/one-piece").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}  
        }
        if(e.getSource() == heroAca) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/boku-no-hero-academia").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == onePunch) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/onepunch-man").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == AOT) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/shingeki-no-kyojin").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == SDS) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/nanatsu-no-taizai").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == Neverland) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/the-promised-neverland").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == haikyuu) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/haikyu").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == foodWars) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/shokugeki-no-soma").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == reincarnated) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/tensei-shitara-slime-datta-ken").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == reincarnated2) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/tensei-shitara-slime-datta-ken").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == blackClover) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/black-clover").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == hajime) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/hajime-no-ippo").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == boruto) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/boruto").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == HXH) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/hunter-x-hunter").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == gintama) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/gintama").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == stone) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/dr-stone").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == kingdom) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/kingdom").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == DBSuper) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/dragon-ball-super").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        }
        if(e.getSource() == ace) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com/diamond-no-ace-act-ii").toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
        } 
    }
    @Override
    public void mousePressed(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}
    @Override
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mouseMoved(MouseEvent e) {
        onePiece.setCursor(new Cursor(Cursor.HAND_CURSOR));
        heroAca.setCursor(new Cursor(Cursor.HAND_CURSOR));
        onePunch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AOT.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SDS.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Neverland.setCursor(new Cursor(Cursor.HAND_CURSOR));
        haikyuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        foodWars.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reincarnated.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reincarnated2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        blackClover.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hajime.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boruto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        HXH.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gintama.setCursor(new Cursor(Cursor.HAND_CURSOR));
        stone.setCursor(new Cursor(Cursor.HAND_CURSOR));
        kingdom.setCursor(new Cursor(Cursor.HAND_CURSOR));
        DBSuper.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ace.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource() == introButton) {
            introFrame.setVisible(true);
        }
        if(e.getSource() == updateButton1){
            mangaURL = "https://www.mangapanda.com/one-piece";
            try {
                controller.selectFile("onePieceData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("onePieceData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setFont(chapterTextLabel.getFont().deriveFont(sizeNotify));
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true); 
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton2) {
            mangaURL = "https://www.mangapanda.com/boku-no-hero-academia";
            try {
                controller.selectFile("heroAcademiaData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("heroAcademiaData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);  
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton3) {
            mangaURL = "https://www.mangapanda.com/onepunch-man";
            try {
                controller.selectFile("onePunchManData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    System.out.println("New Chapter!!!");
                    controller.updateReference("onePunchManData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton4) {
            mangaURL = "https://www.mangapanda.com/shingeki-no-kyojin";
            try {
                controller.selectFile("AOTData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    System.out.println("New Chapter!!!");
                    controller.updateReference("AOTData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton5) {
            mangaURL = "https://www.mangapanda.com/nanatsu-no-taizai";
            try {
                controller.selectFile("sevenDeadlySinsData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    System.out.println("New Chapter!!!");
                    controller.updateReference("sevenDeadlySinsData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton6) {
            mangaURL = "https://www.mangapanda.com/the-promised-neverland";
            try {
                controller.selectFile("neverlandData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    System.out.println("New Chapter!!!");
                    controller.updateReference("neverlandData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton7) {
            mangaURL = "https://www.mangapanda.com/haikyu";
            try {
                controller.selectFile("haikyuuData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    System.out.println("New Chapter!!!");
                    controller.updateReference("haikyuuData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton8) {
            mangaURL = "https://www.mangapanda.com/shokugeki-no-soma";
            try {
                controller.selectFile("foodWarsData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    System.out.println("New Chapter!!!");
                    controller.updateReference("foodWarsData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton9) {
            mangaURL = "https://www.mangapanda.com/tensei-shitara-slime-datta-ken";
            try {
                controller.selectFile("reincarnatedData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    System.out.println("New Chapter!!!");
                    controller.updateReference("reincarnatedData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton10) {
            mangaURL = "https://www.mangapanda.com/black-clover";
            try {
                controller.selectFile("blackCloverData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("blackCloverData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton11) {
            mangaURL = "https://www.mangapanda.com/hajime-no-ippo";
            try {
                controller.selectFile("hajimeData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("hajimeData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton12) {
            mangaURL = "https://www.mangapanda.com/boruto";
            try {
                controller.selectFile("borutoData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("borutoData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton13) {
            mangaURL = "https://www.mangapanda.com/hunter-x-hunter";
            try {
                controller.selectFile("HXHData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("HXHData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton14) {
            mangaURL = "https://www.mangapanda.com/gintama";
            try {
                controller.selectFile("gintamaData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("gintamaData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton15) {
            mangaURL = "https://www.mangapanda.com/dr-stone";
            try {
                controller.selectFile("stoneData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("stoneData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton16) {
            mangaURL = "https://www.mangapanda.com/kingdom";
            try {
                controller.selectFile("kingdomData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("kingdomData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton17) {
            mangaURL = "https://www.mangapanda.com/dragon-ball-super";
            try {
                controller.selectFile("superData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("superData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == updateButton18) {
            mangaURL = "https://www.mangapanda.com/diamond-no-ace-act-ii";
            try {
                controller.selectFile("aceData.txt");
                reference = controller.readReference();
                tableRows = controller.checkForUpdates(mangaURL);
          
                if(reference.equals(tableRows)) {
                    noChapterWindow.setVisible(true);
                } else {
                    controller.updateReference("aceData.txt");
                    newChapterWindow.remove(chapterTextLabel);
                    chapterTextLabel = new JLabel("Chapter: " + newChapterText);
                    chapterTextLabel.setBounds(30, 15, 300, 50);
                    newChapterWindow.add(chapterTextLabel);
                    newChapterWindow.setVisible(true);
                }
            }     
            catch (IOException err) {
                System.err.println("Scripting error...");
           }
        }
        if(e.getSource() == searchBar) {
            frame.setSize(450, 350);
            searchContainer.setVisible(true);
            favoriteContainer.setVisible(false);
            containerGrid.setVisible(false);
            
            if(searchBar.getSelectedItem().equals("One Piece")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelOP);
                searchContainer.setVisible(true);
                containerMain.revalidate(); 
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("My Hero Academia")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelHA);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("One-Punch Man")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelOPM);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Attack On Titan")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelAOT);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Seven Deadly Sins")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelSDS);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Promised Neverland")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelPM);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Haikyuu!!")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelHai);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Shokugeki no Soma")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelFW);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("That Time I Got Reincarnated as a Slime")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelRein);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Black Clover")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelBL);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Hajime no Ippo")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelHaj);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Boruto")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelBor);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Hunter X Hunter")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelHXH);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Gintama")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelGin);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Dr. Stone")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelStone);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Kingdom")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelKing);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Dragon Ball Super")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelSuper);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("Diamond no Ace Act II")) {
                searchContainer.removeAll(); 
                searchContainer.add(panelAce);
                searchContainer.setVisible(true);
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if (searchBar.getSelectedItem().equals("Custom")) {
                searchContainer.setVisible(false);
                favoriteContainer.setVisible(true);
                if(OPFlag == 1) {
                    favoriteContainer.add(panelOP);
                }
                if(HAFlag == 1) {
                    favoriteContainer.add(panelHA);
                }
                if(OPMFlag == 1) {
                    favoriteContainer.add(panelOPM);
                }
                if(AOTFlag == 1) {
                    favoriteContainer.add(panelAOT);
                }
                if(SDSFlag == 1) {
                    favoriteContainer.add(panelSDS);
                }
                if(PMFlag == 1) {
                    favoriteContainer.add(panelPM);
                }
                if(haiFlag == 1) {
                    favoriteContainer.add(panelHai);
                }
                if(FWFlag == 1) {
                    favoriteContainer.add(panelFW);
                }
                if(reinFlag == 1) {
                    favoriteContainer.add(panelRein);
                }
                if(BLFlag == 1) {
                    favoriteContainer.add(panelBL);
                }
                if(hajFlag == 1) {
                    favoriteContainer.add(panelHaj);
                }
                if(borFlag == 1) {
                    favoriteContainer.add(panelBor);
                }
                if(HXHFlag == 1) {
                    favoriteContainer.add(panelHXH);
                }
                if(ginFlag == 1) {
                    favoriteContainer.add(panelGin);
                }
                if(stoneFlag == 1) {
                    favoriteContainer.add(panelStone);
                }
                if(kingFlag == 1){
                    favoriteContainer.add(panelKing);
                }
                if(superFlag == 1) {
                    favoriteContainer.add(panelSuper);
                }
                if(aceFlag == 1) {
                    favoriteContainer.add(panelAce);
                }
                containerMain.revalidate();
                containerMain.repaint();
            }
            else if(searchBar.getSelectedItem().equals("All")) {
                searchContainer.setVisible(false);
                favoriteContainer.setVisible(false);
                frame.setSize(530, 600);
                containerGrid.setVisible(true);
                container.add(panelOP); container.add(panelHA); container.add(panelOPM); container.add(panelAOT); container.add(panelSDS); 
                container.add(panelPM); container.add(panelHai); container.add(panelFW); container.add(panelRein); container.add(panelBL);
                container.add(panelHaj); container.add(panelBor); container.add(panelHXH); container.add(panelGin); container.add(panelStone);
                container.add(panelKing); container.add(panelSuper); container.add(panelAce);
                containerMain.revalidate();
            } 
        }  
        
        if(e.getSource() == goToNewChapter) {
            try {
                Desktop.getDesktop().browse(new URL("https://www.mangapanda.com" + newChapterLink).toURI());
                    } 
                catch (IOException | URISyntaxException error) {}
            newChapterWindow.dispose();
            }
            
        if(e.getSource() == closebtn) {
            noChapterWindow.dispose();
        }
        if(e.getSource() == cancel) {
            newChapterWindow.dispose();
        } 
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == OPCheck) {
           if(OPCheck.isSelected()) {
               OPFlag = 1;
           }else{
                OPFlag = 0;
            }    
        }
        if(e.getSource() == HACheck) {
            if(HACheck.isSelected()) {
                HAFlag = 1;
            }else{
                HAFlag = 0;
            }  
        }
        if(e.getSource() == OPMCheck) {
            if(OPMCheck.isSelected()) {
                OPMFlag = 1;
            }else{
                OPMFlag = 0;
            }    
        }
        if(e.getSource() == AOTCheck) {
            if(AOTCheck.isSelected()) {
                AOTFlag = 1;
            }else{
                AOTFlag = 0;
            }
        }
        if(e.getSource() == SDSCheck) {
            if(SDSCheck.isSelected()) {
                SDSFlag = 1;
            }else{
                SDSFlag = 0;
            }
        }
        if(e.getSource() == PMCheck) {
            if(PMCheck.isSelected()) {
                PMFlag = 1;
            }else{
                PMFlag = 0;
            }
        }
        if(e.getSource() == haiCheck) {
            if(haiCheck.isSelected()) {
                haiFlag = 1;
            }else{
                haiFlag = 0;
            }
        }
        if(e.getSource() == FWCheck) {
            if(FWCheck.isSelected()) {
                FWFlag = 1;
            }else{
                FWFlag = 0;
            }
        }
        if(e.getSource() == reinCheck) {
            if(reinCheck.isSelected()) {
                reinFlag = 1;
            }else{
                reinFlag = 0;
            }
        }
        if(e.getSource() == BLCheck) {
            if(BLCheck.isSelected()) {
                BLFlag = 1;
            }else{
                BLFlag = 0;
            }
        }
        if(e.getSource() == hajCheck) {
            if(hajCheck.isSelected()) {
                hajFlag = 1;
            }else{
                hajFlag = 0;
            }
        }
        if(e.getSource() == borCheck) {
            if(borCheck.isSelected()) {
                borFlag = 1;
            }else{
                borFlag = 0;
            }
        }
        if(e.getSource() == HXHCheck) {
            if(HXHCheck.isSelected()) {
                HXHFlag = 1;
            }else{
                HXHFlag = 0;
            }
        }
        if(e.getSource() == ginCheck) {
            if(ginCheck.isSelected()) {
                ginFlag = 1;
            }else{
                ginFlag = 0;
            }
        }
        if(e.getSource() == stoneCheck) {
            if(stoneCheck.isSelected()) {
                stoneFlag = 1;
            }else{
                stoneFlag = 0;
            }
        }
        if(e.getSource() == kingCheck) {
            if(kingCheck.isSelected()) {
                kingFlag = 1;
            }else{
                kingFlag = 0;
            }
        }
        if(e.getSource() == superCheck) {
            if(superCheck.isSelected()) {
                superFlag = 1;
            }else{
                superFlag = 0;
            }
        }
        if(e.getSource() == aceCheck) {
            if(aceCheck.isSelected()) {
                aceFlag = 1;
            }else{
                aceFlag = 0;
            }
        }
         
    }
    
}
