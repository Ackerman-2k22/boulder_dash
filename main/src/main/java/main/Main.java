/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import view._Frame;

import java.io.IOException;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {



        public  static  void main(String[] arg) throws IOException, InterruptedException {

            _Frame frame= new _Frame();

            frame._frame();
            System.out.println(_Frame.getMov());


        }
    }

