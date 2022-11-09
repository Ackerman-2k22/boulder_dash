package entity;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public interface ISprite {

    public String getName() ;

    public void setHeight(int height) ;

    public void setName(String name) ;

    /**
     * @param whidht
     */
    public void setWhidht(int whidht) ;

    public int getHeight() ;

    /**
     * @return
     */
    public int getWhidht() ;



    //Image buildPanel() throws IOException;

    JPanel getPanel();

    public Point getPosition();
    //public Point setPosition(Point P);

    void setPosition(int x, int y);
    public  String [] getState();

    void moveRight();

    void moveLeft();

    void moveUp();

    void moveDown();
}
