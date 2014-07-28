//copyright@2014 KenLee All right reversed
import imagereader.IImageProcessor;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;


public class MyIImageProcessor implements IImageProcessor {
	public Image showChanelR(Image sourceImage){
		int w = sourceImage.getWidth(null); 
        int h = sourceImage.getHeight(null);
        //new a buffered image
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
        //use graphics to draw Image into BufferedImage
        Graphics gr = bi .createGraphics();   
        gr.drawImage(sourceImage, 0, 0, null);   
        gr.dispose();
        for(int i=0;i<w;i++){
        	for(int j=0;j<h;j++){
        		int rgb = bi.getRGB(i, j);
        		// and op with 0xFF0000 ,choose only red and
        		//trun green and blue into 0
        		int r=(rgb & 16711680);
        		bi.setRGB(i, j, r);
        	}
        }
        return bi;
	}
	public Image showChanelG(Image sourceImage){
		int w = sourceImage.getWidth(null); 
        int h = sourceImage.getHeight(null);
      //i dont konw what the type is ,so i readom one
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        //use graphics to draw Image into BufferedImage
        Graphics gr = bi .createGraphics();   
        gr.drawImage(sourceImage, 0, 0, null);   
        gr.dispose();
        for(int i=0;i<w;i++){
        	for(int j=0;j<h;j++){
        		int rgb = bi.getRGB(i, j);
        		// and op with 0x00FF00 ,choose only green and
        		//trun red and blue into 0
        		int g=(rgb & 65280);
        		bi.setRGB(i, j, g);
        	}
        }
        return bi;
	}
	public Image showChanelB(Image sourceImage){
		int w = sourceImage.getWidth(null); 
        int h = sourceImage.getHeight(null);
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        Graphics gr = bi .createGraphics();   
        gr.drawImage(sourceImage, 0, 0, null);   
        gr.dispose();
        for(int i=0;i<w;i++){
        	for(int j=0;j<h;j++){
        		int rgb = bi.getRGB(i, j);
        		// and op with 0x0000FF ,choose only blue and
        		//trun red and green into 0
        		int b=(rgb & 255);
        		bi.setRGB(i, j, b);
        	}
        }
        return bi;
	}
	public Image showGray(Image sourceImage){
		int w = sourceImage.getWidth(null); 
        int h = sourceImage.getHeight(null);
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        //use graphics to draw Image into BufferedImage
        Graphics gr = bi .createGraphics();   
        gr.drawImage(sourceImage, 0, 0, null);   
        gr.dispose();
        for(int i=0;i<w;i++){
        	for(int j=0;j<h;j++){
        		int rgb = bi.getRGB(i, j);
        		//choose r g and b;
        		int r=(rgb & 16711680)>>16;
        		int g=(rgb & 65280)>>8;
        		int b=(rgb & 255);
        		int I=(int)(0.299 * r + 0.587 * g + 0.114 * b);
        		//use i to generate the final rgb value
        		// gray=I*0x010000 + I*0x000100 + I*0x000001
        		int gray=I*65536+I*256+I;
        		
        		bi.setRGB(i, j, gray);
        	}
        }
        return bi;
	}
}
