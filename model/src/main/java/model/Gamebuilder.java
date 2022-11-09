package model;

//import View._Frame;
import contract.IGamebuilder;
import contract.Move;
import entity.*;
import view._Frame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Gamebuilder extends Observable implements IGamebuilder {

    protected  Sprite  sprite;
    protected ArrayList<Sprite> array_sprite;
    private List<Sprite[][]> map_=new ArrayList<>();
    private  Sprite[][] map_array=new Sprite[_Frame.getWidth_()][_Frame.getHeigth_()];
    private  Wall wall=new Wall();
    private  Wall_empty wall_empty=new Wall_empty();



    @Override
    public Sprite[][] bUILDArea(_Map map, int lvl) throws IOException {
        BufferedReader br = map.getBr();
        String line;
        String number;
        int c=0;
        int k =0;


        for (int i = 0; i <_Frame.getWidth_(); i++) {
            // System.out.println("ligne" + i);
            c=((i+1)*this.sprite.getHeight())-this.sprite.getHeight();
            if(c >(_Frame.getWidth_()-this.sprite.getHeight())|| i >20){
               break;
            }



            line = br.readLine();
            for (int j = 0; j < _Frame.getHeigth_(); j++) {

                k=((j+1)*this.sprite.getHeight())-this.sprite.getHeight();
                if(k >_Frame.getHeigth_()-this.sprite.getHeight()){
                    continue;
                }

                    String numbers[] = line.split(" ");
                    //System.out.println("ligne "+i+"  "+line);
                    int num = Integer.parseInt(numbers[j]);
                    if (num==0 ) {
                        this.map_array[c][k] = new Wall(new Point(c, k)) ;

                    }else if (num==5){
                        this.map_array[c][k] = new Diamond(new Point(c, k));
                    } else if (num ==2) {
                        this.map_array[c][k] = new stone(new Point(c, k));
                    } else if (num==9) {
                        this.map_array[c][k] = new Rambo(new Point(c, k));

                    }

            else{
                        this.map_array[c][k] = new Rock(new Point(c, k));
                    }
              //  System.out.println(c + " " + this.map_array[c][k] + " " + k);





                //System.out.println((int) ' ');




            }


        }
       // System.out.println("le" + map_array.length);
        br.close();

        map_.add(map_array);
        return map_array;
    }







    @Override
    public void buidmobile(ISprite sprite) {

            this.sprite= (Sprite) sprite;

    }

    @Override
    public ArrayList<Sprite> setArraysptite() {
        return this.array_sprite;
    }

    @Override
    public void buildArraysptite(ISprite sprite) {

        this.array_sprite.add((Sprite) sprite);
    }


    @Override
    public Image getImage() {
        String image =this.sprite.getName();

        return (Image) ImageIO.getImageReaders(new File(image));



    }



    @Override
    public ISprite getSprite() {
        return this.sprite;

    }

    @Override
    public Sprite[][] Colision(int x, int y,Sprite[][] m) throws IOException {
        boolean test = false;
        this.sprite.setRectangle( new Rectangle( x, y, this.sprite.getWhidht(),this.sprite.getHeight()));
        //this.map_array = this.bUILDArea(new _Map(), 1);

           // System.out.println(this.map_array[0][0].getRectangle().height);
        //System.out.println("wall : "+this.map_array[x][y]);
        //System.out.println("wall : "+this.map_array[y][x].getRectangle());
        //System.out.println("player : x "+x+" y "+y);
        //System.out.println("player :"+this.sprite.getRectangle());
        if (sprite.getRectangle().intersects(m[y][x].getRectangle())) {
                //System.out.println("colision");
            if (m[y][x] instanceof Wall ||m[y][x] instanceof Diamond) {
                //map_array[y][x] =null;
                m[y][x]= new Wall_empty(new Point(y,x));
                //this.sprite=null;
            }

        }




        return m;



    }





    @Override
    public Point getPOSITION() {
        return this.sprite.getPosition();
    }

    @Override
    public void Move(Move m) {

        switch (m) {
            case DOWN -> this.sprite.moveDown();
            case LEFT -> this.sprite.moveLeft();
            case RIGHT -> this.sprite.moveRight();
            case UP -> this.sprite.moveUp();
        }
        this.setChanged();
        this.notifyObservers();

    }


}
