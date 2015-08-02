package com.toelle.muzikant.gui;

import com.toelle.muzikant.database.DesktopIOHandler;
import com.toelle.muzikant.database.IOHandler;
import com.toelle.muzikant.exception.PreferenceNotSetException;
import com.toelle.muzikant.manager.MusicLibrary;
import com.toelle.muzikant.playback.Deejay;
import com.toelle.muzikant.playback.DesktopPlattenspieler;
import com.toelle.muzikant.playback.Plattenspieler;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;

public class MainWindow extends Application {

    private Deejay deejay;
    private MusicLibrary library;

    private final String[] CFG_LOCATION = {System.getProperty("user.home"), ".muzikant"};
    private final String[][] STANDARD_CFG = {{"music.location", Paths.get(System.getProperty("user.home"), "Music").toString()}};

    private Properties props;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        getProperties();
        initCore();

    }

   private void initCore() {
        deejay = new Deejay(getPlattenspieler());
       try {
           library = new MusicLibrary(getIOHandler());
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    private IOHandler getIOHandler() {
        return new DesktopIOHandler(Paths.get(props.getProperty("music.location")));
    }

    private Plattenspieler getPlattenspieler() {
        return new DesktopPlattenspieler();
    }

    private void getProperties() {
        Path configPath = Paths.get(CFG_LOCATION[0], Arrays.copyOfRange(CFG_LOCATION, 1, CFG_LOCATION.length));
        // Ugly because of the one required parameter and varargs after that

        props = new Properties();

        try {
            props.load(new FileInputStream(configPath.toFile()));
        } catch (IOException e) {
            //TODO Log

            //Setting standard properties because no config file exists
            Arrays.stream(STANDARD_CFG).forEach(cfg -> props.setProperty(cfg[0], cfg[1]));

            //Saving to file
            try {
                configPath.toFile().createNewFile();
                props.store(new FileOutputStream(configPath.toFile()), "Muzikant Player Preferences");
            } catch (IOException e1) {
                //TODO Log
                e1.printStackTrace();
            }
            //TODO Log
            e.printStackTrace();
        }
    }
}
