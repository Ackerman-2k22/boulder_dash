package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class stone extends Sprite{
    private static String NAME = "src/model/Model/data/wall_empty/rock.png";
    private static int Widht = 32;
    private static int HEIGHT =32;

    private static  String []state={"C:\\Users\\Gfried\\Downloads\\projet\\JPU-BlankProject\\JPU-BlankProject\\model\\src\\main\\java\\model\\data\\stone\\"};
    private List<Image> im;
    private File[] liste;
    private String path;

    public stone( Point point) throws IOException {
        super(NAME, Widht, HEIGHT, point,state);
    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveUp() {

    }

    @Override
    public List<Image> animation(Move state) throws IOException {


        return  null;
    }

    @Override
    public List<Image> animation() throws IOException {
        this.path =state[0];
        File dir = new File(state[0]);
        this.liste = dir.listFiles();
        assert liste != null;


        this.im =new ArrayList<>();
        for (File item : liste) {

            //System.out.println(item.getName());
            this.im.add(ImageIO.read(new File(this.path + item.getName())).getScaledInstance(Widht,HEIGHT,1));




            //System.out.println(im.size());
        }
        return this.im;
    }

    @Override
    public void setMv(int mv) {

    }

    public stone() {

    }
    @Override
    public String[] getState() {
        return this.state;
    }


}


