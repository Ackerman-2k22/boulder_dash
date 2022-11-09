package entity;

import java.awt.*;
import java.io.IOException;

public abstract  class Sprie_fall extends Sprite{
    public Sprie_fall(String name, int widht, int height, Point point, String[] state) throws IOException {
        super(name, widht, height, point,state);
    }

    public Sprie_fall() {

    }
}
