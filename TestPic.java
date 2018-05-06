public class TestPic
{
   public static void main(String[] args)
   {
     Picture myPic= new Picture("images/largecanvas.jpg");
       //Picture myPic= new Picture("images/intensity21big.jpg"); 
     //myPic.blend("images/Hellcat2.jpg");
     myPic.copy("images/recursive.jpg");
     
     myPic.write("images/largecanvas.jpg");
     
    }

}
