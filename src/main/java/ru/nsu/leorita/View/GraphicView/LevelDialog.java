package ru.nsu.leorita.View.GraphicView;

import javax.swing.*;
import java.awt.*;

import ru.nsu.leorita.Controller.GraphicController;
import ru.nsu.leorita.GameSettings;
import ru.nsu.leorita.GameSettings;

public class LevelDialog extends JDialog {

    private GraphicController controller;
    private JRadioButton easyButton;
    private JRadioButton mediumButton;
    private JRadioButton hardButton;
    private JRadioButton customButton;
    private JTextField heightField;
    private JTextField widthField;
    private JTextField minesField;
    private JButton newGameButton;

    public LevelDialog(Frame parent, GraphicController controller) {
        super(parent, "Choose level", ModalityType.APPLICATION_MODAL);
        this.controller = controller;
        setSize(300, 400);
        setLocationRelativeTo(parent);
        setResizable(false);
        prepareGUI();
        addListeners();
        setVisible(true);
    }

    public void prepareGUI() {
        setLayout(new GridLayout(6, 1, 0, 0));
        createButtonGroup();
        createTextAreas();
        addPanel1();
        addPanel2();
        addPanel3();
        addPanel4();
        addPanel5();
        addPanel6();
    }

    private void createButtonGroup() {
        ButtonGroup radioGroup = new ButtonGroup();
        String[] names = {"easy", "medium", "hard", "custom"};
        easyButton = new JRadioButton(names[0]);
        easyButton.setSelected(true);
        mediumButton = new JRadioButton(names[1]);
        hardButton = new JRadioButton(names[2]);
        customButton = new JRadioButton(names[3]);
        radioGroup.add(easyButton);
        radioGroup.add(mediumButton);
        radioGroup.add(hardButton);
        radioGroup.add(customButton);
    }

    private void createTextAreas() {
        heightField = new JTextField();
        heightField.setEnabled(false);
        heightField.setMaximumSize(new Dimension(40, 30));
        widthField = new JTextField();
        widthField.setEnabled(false);
        widthField.setMaximumSize(new Dimension(40, 30));
        minesField = new JTextField();
        minesField.setEnabled(false);
        minesField.setMaximumSize(new Dimension(40, 30));
    }

    private void addPanel1() {
        JPanel p1 = new JPanel(new GridLayout(1, 5, 2, 2));
        JLabel gap = new JLabel("");
        JLabel height = new JLabel("height");
        JLabel width = new JLabel("width");
        JLabel mines = new JLabel("mines");
        p1.add(gap);
        p1.add(height);
        p1.add(width);
        p1.add(mines);
        add(p1);
    }

    private void addPanel2() {
        JPanel p2 = new JPanel(new GridLayout(1, 6, 2, 2));
        JLabel h1 = new JLabel("9");
        JLabel w1 = new JLabel("9");
        JLabel m1 = new JLabel("10");
        p2.add(easyButton);
        p2.add(h1);
        p2.add(w1);
        p2.add(m1);
        add(p2);
    }

    private void addPanel3() {
        JPanel p3 = new JPanel(new GridLayout(1, 6, 2, 2));
        JLabel h2 = new JLabel("16");
        JLabel w2 = new JLabel("16");
        JLabel m2 = new JLabel("40");
        p3.add(mediumButton);
        p3.add(h2);
        p3.add(w2);
        p3.add(m2);
        add(p3);
    }

    private void addPanel4() {
        JPanel p4 = new JPanel(new GridLayout(1, 6, 2, 2));
        JLabel h4 = new JLabel("16");
        JLabel w4 = new JLabel("30");
        JLabel m4 = new JLabel("99");
        p4.add(hardButton);
        p4.add(h4);
        p4.add(w4);
        p4.add(m4);
        add(p4);
    }

    private void addPanel5() {
        JPanel p5 = new JPanel();
        p5.setLayout(new BoxLayout(p5, BoxLayout.X_AXIS));
        p5.add(customButton);
        p5.add(heightField);
        p5.add(Box.createRigidArea(new Dimension(30, 0)));
        p5.add(widthField);
        p5.add(Box.createRigidArea(new Dimension(30, 0)));
        p5.add(minesField);
        add(p5);
    }

    private void addPanel6() {
        JPanel p6 = new JPanel();
        newGameButton = new JButton("New game");
        p6.add(newGameButton);
        add(p6);
    }

    private void addListeners() {
        customButton.addActionListener(e -> {
            heightField.setEnabled(true);
            widthField.setEnabled(true);
            minesField.setEnabled(true);
        });
        easyButton.addActionListener(e -> {
            heightField.setEnabled(false);
            widthField.setEnabled(false);
            minesField.setEnabled(false);
        });
        mediumButton.addActionListener(e -> {
            heightField.setEnabled(false);
            widthField.setEnabled(false);
            minesField.setEnabled(false);
        });
        hardButton.addActionListener(e -> {
            heightField.setEnabled(false);
            widthField.setEnabled(false);
            minesField.setEnabled(false);
        });
        widthField.addActionListener(e -> {
            customButton.setSelected(true);
        });
        minesField.addActionListener(e -> {
            customButton.setSelected(true);
        });
        newGameButton.addActionListener(e -> {
            if (easyButton.isSelected()) {
                controller.settings.setProperty(GameSettings.Stats.HEIGHT, "9");
                controller.settings.setProperty(GameSettings.Stats.WIDTH, "9");
                controller.settings.setProperty(GameSettings.Stats.MINES, "10");
            } else if (mediumButton.isSelected()) {
                controller.settings.setProperty(GameSettings.Stats.HEIGHT, "16");
                controller.settings.setProperty(GameSettings.Stats.WIDTH, "16");
                controller.settings.setProperty(GameSettings.Stats.MINES, "40");
            } else if (hardButton.isSelected()) {
                controller.settings.setProperty(GameSettings.Stats.HEIGHT, "16");
                controller.settings.setProperty(GameSettings.Stats.WIDTH, "30");
                controller.settings.setProperty(GameSettings.Stats.MINES, "99");
            } else if (customButton.isSelected()) {
                controller.settings.setProperty(GameSettings.Stats.HEIGHT, heightField.getText());
                controller.settings.setProperty(GameSettings.Stats.WIDTH, widthField.getText());
                controller.settings.setProperty(GameSettings.Stats.MINES, minesField.getText());
            }
            controller.newGame();
        });
    }
}
