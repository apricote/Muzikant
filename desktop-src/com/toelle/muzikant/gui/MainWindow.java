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

import java.io.IOException;

public class MainWindow extends Application {

    private Deejay deejay;
    private MusicLibrary library;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

   private void initializeCore() {
        deejay = new Deejay(getPlattenspieler());
       try {
           library = new MusicLibrary(getIOHandler());
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    private IOHandler getIOHandler() {
        IOHandler result = null;
        try {
            result = new DesktopIOHandler();
        } catch (PreferenceNotSetException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    private Plattenspieler getPlattenspieler() {
        return new DesktopPlattenspieler();
    }
}
