/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkacademyswingproject;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author adib
 */
public class LinkAcademySwingProject {
    static JFrame mainPage;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                mainPage = new JFrame("Options Menu");
                mainPage.setLayout(new FlowLayout());
                mainPage.setSize(new Dimension(300, 300));
                MainDisplay optionsPanel = new MainDisplay();
                mainPage.add(optionsPanel);
                mainPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                PopupMenu trayMenu = new PopupMenu();
                MenuItem optMenuItem = new MenuItem("Setings");
                MenuItem closeMenuItem = new MenuItem("Close");
                optMenuItem.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainPage.setVisible(true);
                    }
                });
                closeMenuItem.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                trayMenu.add(optMenuItem);
                trayMenu.add(closeMenuItem);
                if(SystemTray.isSupported()){
                    SystemTray sysTray = SystemTray.getSystemTray();
                    try {
                        Image img = ImageIO.read(new File("img/tray-icon.png"));
                        TrayIcon ico = new TrayIcon(img);
                        ico.setPopupMenu(trayMenu);
                        sysTray.add(ico);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } 
                }else{
                    JOptionPane.showMessageDialog(null, "Sorry your system doesn't support tray icons");
                    mainPage.setVisible(true);
                }               
                
            }
        });

    }
    
}
