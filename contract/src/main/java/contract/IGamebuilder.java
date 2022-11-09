package contract;

import entity.ISprite;
import entity.Sprite;
import entity._Map;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public interface IGamebuilder {

    public Sprite[][] bUILDArea(_Map map, int lvl) throws IOException;

   // void bUILDArea(java.util.Map map);

    public void buidmobile(ISprite sprite);



    public ArrayList<Sprite> setArraysptite();

    public void buildArraysptite(ISprite sprite);

    public Image getImage();


    public ISprite getSprite();

    //public  boolean Colision();

    public Point getPOSITION();






    void Move(Move m);

    Sprite[][] Colision(int x, int y,Sprite[][]m) throws IOException;
}
