package org.fosforito.test;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;


public class DownloadImages {
	
	  public static void main(String a[]){
		  try{
			  DownloadImages.download("http://testwappas.sirv.com/Images/productos/168_2018/168_IN312_20180215221339136_Ref 312 Menta.jpg", "c:/temp/img1.jpg");
		  }catch(Exception ex){
			  ex.printStackTrace();
		  }
	  }
	  
	  private static void get(String search, String path) throws IOException{
		  URL url = new URL(search);
	        BufferedImage img = ImageIO.read(url);
	        File file = new File(path);
	        ImageIO.write(img, "jpg", file);
	  }
	
	   // Do you want to download an image?
	   // But are u denied access?
	   // well here is the solution.

	    public static void download(String search, String path) throws IOException {

	    // This will get input data from the server
			InputStream inputStream = null;

			// This will read the data from the server;
			OutputStream outputStream = null;

			try {
				// This will open a socket from client to server
				URL url = new URL(search);

			   // This user agent is for if the server wants real humans to visit
				String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";

			   // This socket type will allow to set user_agent
				URLConnection conn = url.openConnection();
				

				// Setting the user agent
				conn.setRequestProperty("User-Agent", USER_AGENT);
				conn.setRequestProperty("content-type", "image/jpeg");
				

				// Requesting input data from server
				inputStream = conn.getInputStream();

				// Open local file writer
				outputStream = new FileOutputStream(path);

				// Limiting byte written to file per loop
				byte[] buffer = new byte[2048];

				// Increments file size
				int length;

				// Looping until server finishes
				while ((length = inputStream.read(buffer)) != -1) {
					// Writing data
					outputStream.write(buffer, 0, length);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			 }

			 // closing used resources
			 // The computer will not be able to use the image
			 // This is a must
			if(outputStream!=null){
			 outputStream.close();
			 inputStream.close();
			}
		}
}
