package ru.nsu.leorita.View.GraphicView;

import ru.nsu.leorita.Controller.GraphicController;
import ru.nsu.leorita.Listener;
import ru.nsu.leorita.Model.Events;
import ru.nsu.leorita.Model.Model;
import ru.nsu.leorita.View.View;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class MainGameFrame extends JFrame implements View, Listener {

    private GraphicController controller;
    private Model model;
    private int fWidth;
    private int fHeight;
    private int mineCount;
    private int left;
    private CellPanel[][] cellPanel;
    private boolean firstMove = true;
    private boolean endOfGame = false;
    MenuManager manager;
    LevelDialog levelDialog;
    private JMenuBar menuBar;
    private JMenu optionsMenu;
    private JMenuItem exit;
    private JMenuItem about;
  //  private JMenuItem scores;
    private JMenuItem level;
    private JButton smileButton;
    private JPanel mainPanel;
    private JPanel infoPanel;
    private JPanel fieldPanel;
    private JLabel time;
    private JLabel mines;


    public MainGameFrame(Model model, GraphicController controller, int fWidth, int fHeight, int mineCount) {
        super("Minesweeper");
        this.controller = controller;
        this.model = model;
        this.fWidth = fWidth;
        this.fHeight = fHeight;
        this.mineCount = mineCount;
        this.left = mineCount;
        this.cellPanel = new CellPanel[fWidth][fHeight];
        model.events.subscribeAll(this);
        prepareGUI();
    }

    public void prepareGUI() {

        setResizable(false);
        setSize(fWidth * 30 + 10, fHeight * 30 + 120);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200, 300));
        setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuBar = createMenuBar();
        setJMenuBar(menuBar);
        mainPanel = createMainPanel();
        infoPanel = createInfoPanel();
        mainPanel.add(infoPanel);
        fieldPanel = createFieldPanel();
        mainPanel.add(fieldPanel);
        add(mainPanel);
        addMenuListeners();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        manager = new MenuManager();
        optionsMenu = manager.getOptionsMenu();
        menuBar.add(optionsMenu);
        about = manager.getAboutItem();
        exit = manager.getExitItem();
       // scores = manager.getScoresItem();
        level = manager.getLevelItem();
        return menuBar;
    }

    public void addMenuListeners() {
        exit.addActionListener(e -> {
            this.dispose();
        });
        about.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    MainGameFrame.this,
                    "<html><h2>This is Minesweeper Game<br>",
                    "About",
                    JOptionPane.PLAIN_MESSAGE);
        });
        level.addActionListener(e -> {
            createLevelDialog();
        });
    }

    public void setTime(int seconds) {
        String timeString = Integer.toString(seconds / 100) + Integer.toString(seconds % 100 / 10) + Integer.toString(seconds % 10);
        time.setText("<html><body bgcolor=black><font size=100 color=red><b>" + timeString + "</b>");
    }

    public void endGame() {
        if (levelDialog != null) {
            levelDialog.dispose();
        }
        model.events.unsubscribeAll(this);
        this.dispose();
    }

    public void init() {
        smileButton.addActionListener(e -> controller.newGame());
        for (int i = 0; i < fWidth; i++) {
            for (int j = 0; j < fHeight; j++) {
                int finalI = i;
                int finalJ = j;
                cellPanel[i][j].addMouseListener(new MouseAdapter() {

                    public void mouseClicked(MouseEvent e) {
                        if (!endOfGame) {
                            if (e.getButton() == MouseEvent.BUTTON1) {
                                if (firstMove) {
                                    firstMove = false;
                                    controller.firstMove(finalI, finalJ);
                                } else {
                                    controller.cellPressedLeft(finalI, finalJ);
                                }
                            }
                            if (e.getButton() == MouseEvent.BUTTON3) {
                                if (!firstMove)
                                    controller.cellPressedRight(finalI, finalJ);
                            }
                        }
                    }

                    public void mousePressed(MouseEvent e) {
                        if (!endOfGame)
                            smileButton.setIcon(new ImageIcon("build/resources/main/pictures/smile_scared.png"));
                    }

                    public void mouseReleased(MouseEvent e) {
                        if (!endOfGame)
                            smileButton.setIcon(new ImageIcon("build/resources/main/pictures/smile.png"));
                    }
                });

            }
        }
    }

    public void setMines() {
        for (int i = 0; i < fHeight; i++) {
            for (int j = 0; j < fWidth; j++) {
                cellPanel[j][i].setMines(controller.getNumOfMines(j, i));
            }
        }
    }


    private void createLevelDialog() {
        if (levelDialog == null) {
            levelDialog = new LevelDialog(this, controller);

        } else {
            levelDialog.setVisible(true);
        }
    }


    private JPanel createMainPanel() {
        JPanel p = new JPanel();
        p.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new BevelBorder(BevelBorder.LOWERED)));
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        return p;
    }

    private JPanel createFieldPanel() {
        JPanel p = new JPanel();
        p.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new EtchedBorder()));
        p.setLayout(new GridLayout(fHeight, fWidth));
        EtchedBorder border = new EtchedBorder(EtchedBorder.LOWERED);
        for (int i = 0; i < fHeight; i++) {
            for (int j = 0; j < fWidth; j++) {
                cellPanel[j][i] = new CellPanel(j, i);
                cellPanel[j][i].setBorder(border);
                p.add(cellPanel[j][i]);
            }
        }
        return p;
    }

    private JPanel createInfoPanel() {
        JPanel p = new JPanel();
        smileButton = new JButton();
        smileButton.setPreferredSize(new Dimension(33, 33));
        smileButton.setIcon(new ImageIcon("build/resources/main/pictures/smile.png"));
        time = new JLabel("<html><body bgcolor=black><font size=100 color=red><b>000</b>");
        String minesString = Integer.toString(mineCount / 100) + Integer.toString(mineCount % 100 / 10) + Integer.toString(mineCount % 10);
        mines = new JLabel("<html><body bgcolor=black><font size=100 color=red><b>" + minesString + "</b>");
        p.setLayout(new GridBagLayout());
        p.setMaximumSize(new Dimension(300, 100));
        p.add(time);
        p.add(smileButton);
        p.add(mines);
        p.setBorder(new CompoundBorder(new EmptyBorder(1, 2, 2, 2), new EtchedBorder()));
        return p;
    }

    @Override
    public void update(Events eventType, int x, int y) {
        switch (eventType) {
            case WIN -> {
                endOfGame = true;
                smileButton.setIcon(new ImageIcon("build/resources/main/pictures/smile_win.png"));
                break;
            }
            case GAMEOVER -> {
                endOfGame = true;
                smileButton.setIcon(new ImageIcon("build/resources/main/pictures/smile_killed.png"));
                cellPanel[x][y].setBackground(Color.RED);
                for (int i = 0; i < fHeight; i++) {
                    for (int j = 0; j < fWidth; j++) {
                        for (MouseListener ml : cellPanel[j][i].getMouseListeners()) {
                            cellPanel[j][i].removeMouseListener(ml);
                        }

                    }
                    break;
                }
            }
            case PUT_FLAG -> {
                left--;
                String minesString = Integer.toString(left / 100) + Integer.toString(left % 100 / 10) + Integer.toString(left % 10);
                mines.setText("<html><body bgcolor=black><font size=100 color=red><b>" + minesString + "</b>");
                cellPanel[x][y].setBackground(Color.BLUE);
                break;
            }
            case OPEN_CELL -> {
                cellPanel[x][y].drawNumber();
            }
            case CLOSE_CELL -> {
               left++;
                String minesString = Integer.toString(left / 100) + Integer.toString(left % 100 / 10) + Integer.toString(left % 10);
                mines.setText("<html><body bgcolor=black><font size=100 color=red><b>" + minesString + "</b>");
                cellPanel[x][y].setBackground(null);
            }
        }

    }
}

