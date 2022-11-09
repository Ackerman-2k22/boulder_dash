package view;

import contract.IGamebuilder;
import contract.IGraphicSprite;
import contract.Move;
import contract.Windows;
import controller.GraphicSprite;
import model.Gamebuilder;
//zimport model.Model.*;

import javax.swing.*;
import java.io.IOException;

public class _Frame   extends JFrame implements Runnable{

    IGamebuilder gamebuilder =(IGamebuilder) new Gamebuilder();

   
    JPanel pan =new JPanel(null);
    private  static int  heigth;

   // private posobserver road_pos= new posobserver(200,0);
    //private posobserver car_pos= new posobserver(10,50);
    public static entity.Move  mov =entity.Move.NORMAL;

    private static  int width;


    public _Frame() throws IOException {

    }


    public void _frame() throws IOException, InterruptedException {
        this.setTitle("Crazy car");
        this.setSize(833, 800);
        this.heigth= this.getHeight();
        this.width= this.getWidth();
        this.setLayout(null);
        pan.setLayout(new OverlayLayout(pan));
        IGraphicSprite iGraphicSprite = new GraphicSprite();

        //game_car.setBackground(Color.BLACK);
        //this.setBackground(Color.black);
//this.setBackground(Color.black);


        this.setContentPane(iGraphicSprite.getpanel());
//System.out.println(this.getHeight());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.addKeyListener(new Keygest());
        //his.pack();

        //this.getContentPane().add(new Controler(new Rambo(new Point(10,10))));
        this.setVisible(true);
       // pan.add(game_Rambo.getPan_map());


        //game_Rambo.setBackground(Color.red);
        //this.setBackground(Color.red);
        //Thread.sleep(1000);d
        //game_Rambo.setLocation(10,10);

        //game_car.repaint();
        //this.getContentPane().add(game_car);
        //this.repaint();
        //((Controler) game_road).update();
        //game_car.update();

        //pan.add(game_car);

        //pan.setVisible(true);

       // game_car.getMouve();
        //game_car.getcomponment().animation(Move.LEFT);

        //game_car.getMouve();

        }







    public static entity.Move getMov() {
        return mov;
    }

    public static void setMov(entity.Move movs) {
        mov = movs;
    }



    public static  int getWidth_() {
        return width;
    }

    public static int getHeigth_() {
        return heigth;
    }

    @Override
    public void run() {


    }

    }

