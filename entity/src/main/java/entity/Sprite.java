package entity;

//import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class Sprite  implements ISprite {
    private Rectangle rectangle;
    private String name;
    private int whidht;
    private int height;

    private Position position;

    private JPanel panel;

    String[] state;
    private Move states;
    private String path;
    private File[] liste;
    private List<Image> im;

    public Sprite() {

    }

    public Sprite(String name,  int whidht,  int height,  Point point, String state[]) throws IOException {

        this.name = name;
        this.whidht = whidht;
        this.height = height;
        this.position = new Position((int) point.getX(), (int) point.getY());
        rectangle = new Rectangle( position.getY(), position.getX(), whidht, height);
        this.state = state;
        //System.out.println("i am a live"+getRectangle().width);
        //this.buildPanel();
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public String getName() {
        return name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWhidht(int whidht) {
        this.whidht = whidht;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getWhidht() {
        return whidht;
    }


    public abstract List<Image> animation(Move states) throws IOException ;

    public  abstract  List<Image> animation() throws IOException ;

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }


    public Point getPosition() {
        return new Point(position.getX(), position.getY());
    }
    public abstract void setMv(int mv);
    @Override
    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    @Override
    public abstract  String[] getState() ;

    public void moveUp() {
    }

    public void moveDown() {
    }



    //public abstract int[] getMap1();
}

