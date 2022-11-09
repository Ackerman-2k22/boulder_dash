package entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rambo   extends Sprite {
    private static String NAME = "";
    private static int Widht = 32;
    private static int HEIGHT = 32;
    private JLabel lab;
    private File[] liste;
    private List<Image> im;

    private JPanel panel;
    private  int velocity =32;
    private int mv=0;
    // private File[] liste;

    private  String[] state = {"C:\\Users\\Gfried\\Downloads\\projet\\JPU-BlankProject\\JPU-BlankProject\\model\\src\\main\\java\\model\\data\\rambo\\droite\\","C:\\Users\\Gfried\\Downloads\\projet\\JPU-BlankProject\\JPU-BlankProject\\model\\src\\main\\java\\model\\data\\rambo\\normal\\","C:\\Users\\Gfried\\Downloads\\projet\\JPU-BlankProject\\JPU-BlankProject\\model\\src\\main\\java\\model\\data\\rambo\\gauche\\","C:\\Users\\Gfried\\Downloads\\projet\\JPU-BlankProject\\JPU-BlankProject\\model\\src\\main\\java\\model\\data\\rambo\\down\\","C:\\Users\\Gfried\\Downloads\\projet\\JPU-BlankProject\\JPU-BlankProject\\model\\src\\main\\java\\model\\data\\rambo\\up\\"};
    private String path;

    public Rambo(Point point) throws IOException {
        super(NAME, Widht, HEIGHT, point, null);
    }





    @Override
    public List<Image> animation() throws IOException {
        return null;
    }

    @Override
    public String[] getState() {
        return this.state;
    }

    @Override
    public void moveRight() {
        setPosition(this.getPosition().x + velocity*mv, this.getPosition().y);
    }

    @Override
    public void moveDown() {
        setPosition(this.getPosition().x , this.getPosition().y+velocity*mv);
    }

    @Override
    public void moveUp() {
        setPosition(this.getPosition().x, this.getPosition().y-velocity*mv);
    }

    public void setMv(int mv) {
        this.mv=mv;
    }

    @Override
    public void moveLeft() {
        setPosition(this.getPosition().x - velocity*mv, this.getPosition().y);

    }

    public List<Image> animation(Move states) throws IOException {
        switch (states) {
            case LEFT:
                this.path =this.state[0];
                File dir = new File(this.state[0]);
                this.liste = dir.listFiles();
                //System.out.println(liste);

                break;

            case NORMAL:
                this.path =state[1];
                dir = new File(state[1]);
                this.liste = dir.listFiles();
                break;
            case RIGHT:
                this.path =state[2];
                dir = new File(state[2]);
                this.liste = dir.listFiles();
                break;
            case DOWN:
                this.path =state[3];
                dir = new File(state[3]);
                this.liste = dir.listFiles();
                break;

            case UP:
                this.path =state[4];
                dir = new File(state[4]);
                this.liste = dir.listFiles();
                break;



        }
        assert liste != null;


        this.im =new ArrayList<Image>();
        for (File item : liste) {

            //  System.out.println(item.getName());

            //this.buildcomponment(sprite);
            //System.out.println(getClass().getResourceAsStream(this.path+item.getName()));
            //this.im.add(ImageIO.read(new File(state[0]+item.getName())));


            this.im.add(ImageIO.read(new File(this.path + item.getName())).getScaledInstance(Widht,HEIGHT,1));




            // System.out.println(im.size());
        }


        //System.out.println(this.im.length);
        return im;
    }


}







