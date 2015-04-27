package com.toelle.muzikant.gui;

import com.toelle.muzikant.database.IOHandler;
import com.toelle.muzikant.manager.MusicLibrary;
import com.toelle.muzikant.playback.Deejay;
import com.toelle.muzikant.playback.DesktopPlattenspieler;
import com.toelle.muzikant.playback.Plattenspieler;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainWindow extends Application {

    private Deejay deejay;
    private MusicLibrary library;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

   /*private void initializeCore() {
        deejay = new Deejay(getPlattenspieler());
        library = new MusicLibrary(getIOHandler());
    }

    private IOHandler getIOHandler() {
        return new DesktopIOHandler();
    }

    private Plattenspieler getPlattenspieler() {
        return new DesktopPlattenspieler();
    }*/
}
