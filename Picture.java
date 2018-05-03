//Tommy Hojnicki
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */


   public void gray()
   {
   int r,g,b;
   double ave,total;
   //!!!! again, copies all the pixels into the array !!!!!
   Pixel[] pixelArray = this.getPixels();
    double max=0,min=255;

            for(Pixel pixelObj: pixelArray){
                r=pixelObj.getRed();
                g=pixelObj.getGreen();
                b=pixelObj.getBlue();

                total= r+g+b;
                ave=total/3;

                pixelObj.setRed((int)ave);
                pixelObj.setGreen((int)ave);
                pixelObj.setBlue((int)ave);
            }
        }
public void copy(/*sourceFile*/)
{
    String sourceFile= ("images\\beach.jpg");
    Picture sourcePicture = new Picture(sourceFile);

    Pixel sourcePixel= null;
    Pixel targetPixel= null;

    for( int sourceX=0, targetX=0; 
    sourceX< sourcePicture.getWidth();
    sourceX++,targetX++)
{
        for( int sourceY=0, targetY=0; 
        sourceY< sourcePicture.getHeight();
        sourceY++,targetY++)
    {
        //set the target pixel colo to the source pixel color
        sourcePixel=sourcePicture.getPixel(sourceX,sourceY);
        targetPixel= this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
        }

}
}

  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  

 // this } is the end of class Picture, put all new methods before this
/**
 * Method to mirror around a vertical line in the middle of
 * the picture based on the width
 */
public void mirrorVert()
{
    int width= this.getWidth();
    int mirrorPoint= width/2;
    
    Pixel leftPixel=null;
    Pixel rightPixel=null;
    
    //loop through all the rows
    
    for(int y=0;y<getHeight();y++)
    {
        //loop from 0 to the mirror point
        for (int x = 0;x<mirrorPoint;x++)
        {
            leftPixel=getPixel(x,y);
            rightPixel=getPixel(width-1-x,y);
            rightPixel.setColor(leftPixel.getColor());
            
        }
    
}

}

public void mirrorHorz()
{
    int height= this.getHeight();
    int mirrorPoint= height/2;
    
    Pixel topPixel=null;
    Pixel bottomPixel=null;
    
    //loop through all the rows
    
    for(int y=0;y<mirrorPoint;y++)
    {
        //loop from 0 to the mirror point
        for (int x = 0;x<getWidth();x++)
        {
            topPixel=getPixel(x,y);
            bottomPixel=getPixel(x,height-1-y);
            bottomPixel.setColor(topPixel.getColor());
            
        }
    
    }
}
public void copySmaller(String file)
{
    Picture thePicture= new Picture(file);
    Picture original= new Picture (file);
 
    Pixel sourcePixel= null;
    Pixel targetPixel=null;
    for(int sourceY=0,targetY=0;sourceY<thePicture.getHeight();sourceY+=2,targetY++)
    {
     for (int sourceX=0,targetX=0;sourceX<thePicture.getWidth();sourceX+=2,targetX++)
     {
        sourcePixel=thePicture.getPixel(sourceX,sourceY);
        targetPixel= this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
        }
    
    }

}


public void Recursive(int multi)
{
    int num=(int)Math.pow(2,multi);
    int numberX=this.getWidth()/num;
    int numberY=this.getHeight()/num;
    Pixel oriPixel= null;
    Pixel finalPixel=null;
    if (numberX<=20||numberY<=15)
    {return;
    }
    else
    {

        for( int x=0,xt=0;x<numberX;x+=2,xt++)
        {
            for(int y=0,yt=0;y<numberY;y+=2,yt++)
            {
                oriPixel=this.getPixel(x,y);
                finalPixel=this.getPixel(xt,yt);
                finalPixel.setColor(oriPixel.getColor());
                
            }
        }
        Recursive(multi+1);
    }
    

}

public void flip()
{
    Pixel oriPixel=null;
    Pixel finalPixel= null;
   
    
    for(int x=0,xFin=this.getWidth()-1; x<this.getWidth();x++,xFin--)
    {
            for(int y=0,yFin=this.getHeight()-1;y<this.getHeight();y++,yFin--)
                {oriPixel=this.getPixel(x,y);
                finalPixel=this.getPixel(xFin,yFin);
                Color temp= oriPixel.getColor();
                finalPixel.setColor(oriPixel.getColor());
                oriPixel.setColor(temp);
                }
            }     
}
}





