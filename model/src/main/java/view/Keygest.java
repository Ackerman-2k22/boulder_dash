package view;

import contract.Move;
import model.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Keygest implements KeyListener {
    //public  _Frame fr=new _Frame() ;

    public Keygest() throws IOException, InterruptedException {

            }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       System.out.println("ok");
        switch (e.getKeyCode()){
            case KeyEvent.VK_W -> _Frame.setMov(entity.Move.UP);


            case KeyEvent.VK_S -> _Frame.setMov(entity.Move.DOWN);
            case KeyEvent.VK_D -> _Frame.setMov(entity.Move.RIGHT);
            case KeyEvent.VK_A -> _Frame.setMov(entity.Move.LEFT);



        }
        //_Frame.game_car.getcomponment().animation(_Frame.getMov());
        //_Frame.game_car.movGest(_Frame.getMov());


    }

    @Override
    public void keyReleased(KeyEvent e) {
_Frame.setMov(entity.Move.NORMAL);
    }


}
