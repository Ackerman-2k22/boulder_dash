package contract;


import entity.ISprite;
//import model.Gamebuilder;
//import model.ISprite;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public interface IGraphicSprite {

    /**
     * @throws IOException
     */
    public JPanel getpanel();

    /**
     * @param sprite
     * @throws IOException
     */
    public void buildcomponment(ISprite sprite) throws IOException;

   // void buildcomponment(ISprite sprite) throws IOException;

    public IGamebuilder getGamebuilder() throws IOException;
   // public JLabel getlabel() throws IOException;
   // public Sprite getcomponment();
    //public  void update();


    /**
     * @param g
     * @throws IOException
     * @throws InterruptedException
     */
    void movGest(Graphics2D g) throws IOException, InterruptedException;

    //void renew(int a, int b);
}
