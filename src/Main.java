//copyright@2014 KenLee All right reversed
import imagereader.IImageIO;
import imagereader.IImageProcessor;
import imagereader.Runner;


public class Main {
	public static void main(String[] args){
		IImageIO iio=new MyIImageIO();
		IImageProcessor iip=new MyIImageProcessor();
		Runner.run(iio, iip);
	}
}
