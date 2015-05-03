package com.toelle.muzikant.model;

import javafx.scene.image.Image;

public class Artwork {

    private Image image;
    public static Artwork MISSING = getMissingArtwork();

    public Artwork(Image image) {
        this.image = image;
    }

    public Image getArtwork() {
        return image;
    }

    private static Artwork getMissingArtwork() {
        Image img = new Image("./res/MissingArtwork.png");
        return new Artwork(img);
    }

}
