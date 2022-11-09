package entity;

import java.awt.*;
import java.io.*;
import java.util.List;

public class _Map extends Sprite {

    private int map1[]={0,1,0,1,0,0,1,0,1,0,1,0,0};
    private String fileName="C:\\Users\\Gfried\\Downloads\\projet\\JPU-BlankProject\\JPU-BlankProject\\model\\src\\main\\java\\model\\data\\map\\Map4";
    private FileInputStream is = new FileInputStream(fileName);
    private BufferedReader br = new BufferedReader(new InputStreamReader(is));

    public _Map() throws FileNotFoundException {
    }

    @Override
    public List<Image> animation(Move states) throws IOException {
        return null;
    }

    @Override
    public List<Image> animation() throws IOException {
        return null;
    }

    @Override
    public void setMv(int mv) {

    }

    @Override
    public String[] getState() {
        return new String[0];
    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }


    public int[] getMap1() {
        return map1;
    }

    public BufferedReader getBr() {
        return br;
    }
}
