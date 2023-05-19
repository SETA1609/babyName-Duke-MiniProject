package Honors;

import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class GrayScaleConverter {


    // Started with a given image
    public ImageResource makeGray(ImageResource img) {
        // Making a img/canvas of the same size as the given img
        ImageResource outImg = new ImageResource (img.getWidth (), img.getHeight ());
        // Now we iterate through all out px in the image
        for (Pixel px:outImg.pixels ()) {
            //look at the actual pixel of the img
            Pixel tmp =img.getPixel (px.getX (), px.getY ());
            //compute the average of the rgb values of the pixel
            int red = tmp.getRed ();
            int green= tmp.getGreen ();
            int blue= tmp.getBlue ();
            int average= (red+green+blue)/3;
            // set all the values in current px for the outImg to the average
            px.setRed (average);
            px.setGreen (average);
            px.setBlue (average);


        }

        return outImg;
    }

    public void testGray(){
        ImageResource ir = new ImageResource ();
        ImageResource gray= makeGray (ir);
        gray.draw ();
    }

    public void selectAndConvert(){
        DirectoryResource dr =new DirectoryResource ();
        for (File f:dr.selectedFiles ()) {
            ImageResource inFile= new ImageResource (f);
            ImageResource gray=makeGray (inFile);
            gray.draw ();
        }
        
    }

    //would save the new images in the root folder
    public void doSave(){
        DirectoryResource dr =new DirectoryResource ();
        for (File f:dr.selectedFiles ()) {
            ImageResource inFile= new ImageResource (f);
            String name=f.getName ();
            String newName="Gray-"+name;
            ImageResource gray=makeGray (inFile);
            gray.setFileName (newName);
            gray.draw ();
            gray.save ();
        }

    }

}
