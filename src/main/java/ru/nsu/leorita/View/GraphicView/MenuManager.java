package ru.nsu.leorita.View.GraphicView;

import javax.swing.*;

public class MenuManager {

    private JMenu optionsMenu;
    private JMenuItem exitItem;
    private JMenuItem aboutItem;
   // private JMenuItem scoresItem;
    private JMenuItem levelItem;

    public MenuManager() {
        this.optionsMenu = createOptionsMenu();
    }

    public JMenuItem getLevelItem() {
        return levelItem;
    }

    public JMenu getOptionsMenu() {
        return optionsMenu;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }

    public JMenuItem getAboutItem() {
        return aboutItem;
    }

   // public JMenuItem getScoresItem() {
   //     return scoresItem;
   // }

    private JMenu createOptionsMenu() {

        JMenu menu = new JMenu("Options");
        this.aboutItem = new JMenuItem("About");
        this.exitItem = new JMenuItem("Exit");
      //  this.scoresItem = new JMenuItem("High scores");
        this.levelItem = new JMenuItem("Level");
        menu.add(levelItem);
        menu.addSeparator();
     //   menu.add(scoresItem);
     //   menu.addSeparator();
        menu.add(aboutItem);
        menu.addSeparator();
        menu.add(exitItem);
        return menu;
    }
}


