package ImageToText;
import java.io.PrintWriter;
	public class Main {
		public static void main(String[] args) {
			String input_file="E:\\TesseractOCR\\Input\\sample.png";
			String output_file="E:\\TesseractOCR\\Output\\out";	
			String tesseract_install_path="E:\\TesseractOCR\\Tesseract-OCR\\tesseract";
			String[] command =
		    {
		        "cmd",
		    };
		    Process p;
			try {
				p = Runtime.getRuntime().exec(command);
			        new Thread(new ImageFormat(p.getErrorStream(), System.err)).start();
		                new Thread(new ImageFormat(p.getInputStream(), System.out)).start();
		                PrintWriter stdin = new PrintWriter(p.getOutputStream());
		                stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
		        	    stdin.close();
		                p.waitFor();
		                System.out.println();
		                System.out.println();
		                System.out.println();
		                System.out.println();
		                System.out.println(ImageReader.read_a_file(output_file+".txt"));
		    	} catch (Exception e) {
		 		e.printStackTrace();
			}
		}	
	}	