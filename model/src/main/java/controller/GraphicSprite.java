package controller;


import contract.IGamebuilder;
import contract.IGraphicSprite;
import contract.Move;
import entity.*;
import model.*;
import view._Frame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  class GraphicSprite extends JPanel implements IGraphicSprite {

    private static  Sprite[][] M  ;
    private final IGamebuilder gamebuilder = (IGamebuilder) new Gamebuilder();
    private List<Image> state;

    private ISprite sprite ;
    private Sprite rok_ford=new Rambo(new Point());
    //private Graphics g;
    private Image im1;
    private int index=0;
    private  int map_x= 0;
    private  int map_y=0;
    private int map_anim_index =0;
   // private   _Map map;

    private final int velocity=32;
    private int idx=0;
    private int i;
    private int j;
    private int c;
    private int k;
    private int idxs=0;

    @Override
    public TransferHandler getTransferHandler() {
        return super.getTransferHandler();
    }

    //private final JLabel lab_sprite;
   // private List<BufferedImage>list_move;
    private List<Sprite [][]> map;

    public GraphicSprite() throws IOException {

        //System.out.println(_Frame.getMov());
        this.buildcomponment(sprite);
        this.M =gamebuilder.bUILDArea(new _Map(),1);

       // this.setLayout(null);
        this.setSize(2080,600);
        //this.setLocation(100,100);
        //
        this.setBackground(Color.black);
        this.M=gamebuilder.bUILDArea(new _Map(),1);

       // this.map_gen();

        //ImageIcon im = new ImageIcon(this.sprite.buildPanel());
        //this.im1= new BufferedImage(new File(this.sprite.getName()));



      //  this.lab_sprite=new JLabel(im);

        //this.sprite.scroll();
        //sthis.update();
    }


    @Override
    public JPanel getpanel() {
        return this ;
    }

    /**
     * @param sprite
     * @throws IOException
     */
    @Override
    public void buildcomponment(ISprite sprite) throws IOException {
        gamebuilder.buidmobile(rok_ford);

        this.sprite = gamebuilder.getSprite();




    }


    @Override
    public Gamebuilder getGamebuilder() throws IOException {
        return (Gamebuilder) this.gamebuilder;
    }

    public Sprite getcomponment(){
        return (Sprite) gamebuilder.getSprite();
    }





    @Override
    public void movGest(Graphics2D g) throws IOException, InterruptedException {


        // this.list_move= ;
        // System.out.println(_Frame.getMov());
        //BufferedImage[] state = new BufferedImage[this.getcomponment().animation(_Frame.getMov()).length];
        //this.getcomponment().setPosition(this.getcomponment().getPosition().x + 100, this.getcomponment().getPosition().y);


        if (_Frame.getMov() == entity.Move.LEFT) {
            if(M[this.getcomponment().getPosition().y][this.getcomponment().getPosition().x-32] instanceof stone||(M[this.getcomponment().getPosition().y][this.getcomponment().getPosition().x-32] instanceof Rock)){
                this.getcomponment().setMv(0);
            }else{
                this.getcomponment().setMv(1);
            }

            this.getcomponment().moveLeft();

        } else if (_Frame.getMov() == entity.Move.RIGHT) {
            if(M[this.getcomponment().getPosition().y][this.getcomponment().getPosition().x+32] instanceof stone || M[this.getcomponment().getPosition().y][this.getcomponment().getPosition().x+32] instanceof Rock){
                this.getcomponment().setMv(0);
            }else{
                this.getcomponment().setMv(1);
            }
            this.getcomponment().moveRight();
        } else if (_Frame.getMov() ==entity.Move.DOWN) {
            if(M[this.getcomponment().getPosition().y+32][this.getcomponment().getPosition().x] instanceof stone || (M[this.getcomponment().getPosition().y+32][this.getcomponment().getPosition().x] instanceof Rock)){
                this.getcomponment().setMv(0);
            }else{
                this.getcomponment().setMv(1);
            }
            this.getcomponment().moveDown();

        } else if (_Frame.getMov() == entity.Move.UP) {
            if(M[this.getcomponment().getPosition().y-32][this.getcomponment().getPosition().x] instanceof stone || M[this.getcomponment().getPosition().y-32][this.getcomponment().getPosition().x] instanceof Rock){
                this.getcomponment().setMv(0);
            }else{
                this.getcomponment().setMv(1);
            }
            this.getcomponment().moveUp();
        }
        this.state = new ArrayList<>(this.rok_ford.animation(_Frame.getMov()));
            index++;
            if (index >= this.state.size()) {
                //System.out.println(state.stream());
                this.index = 0;
                //this.im1=null;


            }
        this.idxs++;
            Thread.sleep(3);
        //System.out.println(c);
        if(c>500){
            this.c=0;
        }
        if(k>400){
            k=0;
        }
        if (this.idxs >= M[c][k].animation().size()-1) {

            idxs = 0;

            //this.im1=null;


        }
            //System.out.println(this.getcomponment().getPosition().x+" "+this.getcomponment().getPosition().y);


            //this.M =gamebuilder.bUILDArea(new _Map(),1);

           // this.idx++;


           //Thread.sleep(30);
        }
public  void map_drawing(Graphics g) throws IOException, InterruptedException {
int idx =0;

    for(int i =0; i<=_Frame.getWidth_()-1;i++){
         this.c = ((i + 1) * this.sprite.getHeight()) -this.sprite.getHeight();
        if(c >(_Frame.getWidth_()-this.sprite.getHeight()) || i>20 ){
            break;
        }

        for(int j=0;j<=_Frame.getHeigth_();j++){
            this.k = ((j + 1) * this.sprite.getHeight()) -this.sprite.getHeight();


            if(k >_Frame.getHeigth_()-this.sprite.getHeight()){
                continue;
            }

            //System.out.println(c + " " + this.M[c][k] + " nside " + k);
            if (this.M[c][k] instanceof Rambo){
                this.rok_ford.setPosition(c,k);
                this.M[c][k]=new Wall(new Point(c, k));
            }
            if(k+32<(_Frame.getHeigth_()-32)) {
                int y1=M[c][k].getPosition().y;
                int x1=M[c][k].getPosition().x;
                int y2=M[c][k+32].getPosition().y;
                int x2=M[c][k+32].getPosition().x;


                if ((M[y2][x2]!=null)){
                    if(!M[y1][x1].getRectangle().intersects(M[y2][x2].getRectangle()) &&M[y1][x1] instanceof Sprie_fall && M[y2][x2] instanceof Wall_empty){
                        //System.out.println("true");
                        if(this.rok_ford.getPosition().y!=M[y2][x2].getPosition().x ||this.rok_ford.getPosition().x !=M[y2][x2].getPosition().y) {
                            Sprite s=M[y1][x1];
                            M[y1][x1] = new Wall_empty(new Point(y1, x1));
                            Thread.sleep(2);
                            s.setPosition(y2,x2);
                            M[y2][x2] = s;
                            //System.out.println("rock "+ M[this.sprite.getPosition().y][this.sprite.getPosition().x]);
                            //System.out.println( M[y2][x2] );

                        }
                        //System.out.println( M[y2][x2] );
                        this.M=this.gamebuilder.Colision(this.getcomponment().getPosition().x,this.getcomponment().getPosition().y, M);

                    }
                    //System.out.println("rock"+ M[this.sprite.getPosition().y][this.sprite.getPosition().x]);
                    this.M=this.gamebuilder.Colision(this.getcomponment().getPosition().x,this.getcomponment().getPosition().y, M);
                }


            }


            g.drawImage(M[c][k].animation().get(idxs),M[c][k].getPosition().y,M[c][k].getPosition().x,null);
            this.M=this.gamebuilder.Colision(this.rok_ford.getPosition().x,this.rok_ford.getPosition().y, M);
            this.repaint();


        }

    }




}

    public  void paintChildren(Graphics g){
        Graphics2D g1 = (Graphics2D) g;


       //g.drawImage(this.im1,this.sprite.getPosition().x, this.sprite.getPosition().y,null);
        try {
            this.map_drawing(g);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
           // ((Graphics2D) g).setBackground(Color.black);

            this.movGest(g1);






            //this.repaint();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        g.drawImage( state.get(this.index), this.rok_ford.getPosition().x, this.rok_ford.getPosition().y, null);
        //System.out.println(M[0][0].getRectangle());
        this.repaint();

        //this.movGest(fr.getMov());
        //g.drawArc(-40, 10, 100, 100, 0, 90);

        //System.out.println(this.map.get(idx)[map_anim_index]);

    }




    public  void paintBorder(Graphics g){

    //this.setBackground(Color.orange);
}

}
