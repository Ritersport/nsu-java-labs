package ru.nsu.leorita;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GameSettings {
    private Properties settings;
    private int fWidth;
    private int fHeight;
    private int minesCount;

    public enum Stats {
        HEIGHT,
        WIDTH,
        MINES
    }

    public GameSettings() {
        try {
            FileReader reader = new FileReader("build/resources/main/settings.properties");
            settings = new Properties();
            settings.load(reader);
        }
        catch (IOException e) {
            setDefaultStats();
        }

    }

    public void setProperty(Stats type, String value) {
        switch (type) {
            case MINES -> settings.setProperty("m", value);
            case WIDTH -> settings.setProperty("w", value);
            case HEIGHT -> settings.setProperty("h", value);
        }
    }

    public int getfWidth() {
        return fWidth;
    }

    public int getfHeight() {
        return fHeight;
    }

    public int getMinesCount() {
        return minesCount;
    }


    public void updateStats() {
        try {
            fWidth = Integer.parseInt(settings.getProperty("w"));
            fHeight = Integer.parseInt(settings.getProperty("h"));
            minesCount = Integer.parseInt(settings.getProperty("m"));
            checkStats();
        } catch (NumberFormatException e) {
           setDefaultStats();
        }
    }

    private void setDefaultStats() {
        fWidth = 9;
        fHeight = 9;
        minesCount = 10;
    }

    private void checkStats() {
       if (fHeight < 1) {
           fHeight = 9;
       }
       if (fWidth < 1) {
           fWidth = 9;
       }
       if (minesCount < 1) {
           minesCount = 1;
       }
       if (fHeight > 25) {
           fHeight = 25;
       }
       if (fWidth > 40) {
           fWidth = 40;
       }
       if (minesCount > fWidth * fHeight) {
           minesCount = fWidth * fHeight - 1;
       }
    }

}
