//copyright@2014 KenLee All right reversed
import imagereader.IImageIO;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class MyIImageIO implements IImageIO{
	private static final int IMGSIZE=10000;
	public Image myRead(String filePath) throws IOException{
//		//first i finish it without using binary I/O
//		FileInputStream is;
//		try {
//			is = new FileInputStream(filePath);
//			BufferedImage img=ImageIO.read(is);
//			return img;
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return null;
		try{
			InputStream in = new FileInputStream(filePath);
	      	byte imageData[] = new byte[IMGSIZE*IMGSIZE]; 
	      	while(in.read(imageData)!= -1 ){ 
	      		//do nothing ,wait for read
	        }
	      	in.close();
	      	ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
	      	BufferedImage bi =ImageIO.read(bais);
	      	return bi;
		}
		catch(IOException e){
			System.out.println("read imgae file io error!");
			e.printStackTrace(); 
		}
		return null;
	}
	public Image myWrite(Image image,String filePath){
		int w = image.getWidth(null);
        int h = image.getHeight(null);
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
        Graphics gr = bi.getGraphics(); 
        try { 
            gr.drawImage(image, 0, 0, null);
            ImageIO.write(bi,"bmp",new File(filePath)); 
        } catch (IOException e) { 
        	System.out.println("write imgae file io error!");
            e.printStackTrace(); 
        } 
		return image;
	}
}
