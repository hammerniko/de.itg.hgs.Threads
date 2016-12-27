package f01_DOS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SystemCommand {
	
	
	public PrintOutput getStreamWrapper(InputStream is, String type){
		return new PrintOutput(is, type);
	}
	
	
	public static void main(String[] args){
		Runtime rt = Runtime.getRuntime();
		SystemCommand sc = new SystemCommand();
		printOutput errorReported, 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	



private class PrintOutput extends Thread{
	InputStream is = null;
	
	public PrintOutput(InputStream is, String type) {
		this.is = is;
	}
	
	public void run(){
		String s = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			while ((s= br.readLine()) != null) {
				System.out.println(s);
				
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

}