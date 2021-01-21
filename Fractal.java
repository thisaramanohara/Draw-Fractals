import java.awt.*;
import javax.swing.*;

public class Fractal extends JPanel {

	public static void main(String[] args) {
		
		
		//if selects Mandelbrot
		if(args[0].equals("Mandelbrot")) {
			
			// create a frame
			JFrame frame = new JFrame("Mandelbrot"); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//if number of arguments is 1
			if(args.length==1) {
				//operation is done with default values
				frame.setContentPane(new Mandelbrot());
			}
			
			//if number of arguments is 5
			else if(args.length==5) {
				double realStart = Double.parseDouble(args[1]);	//setting the left boundary of the real axis
				double realEnd = Double.parseDouble(args[2]);	//setting the right boundary of the real axis
				double imgStart = Double.parseDouble(args[3]);	//setting the lower boundary of the imaginary axis
				double imgEnd = Double.parseDouble(args[4]);	//setting the upper boundary of the imaginary axis
				
				//operation is done with given region of interest and default no.Of iterations
				frame.setContentPane(new Mandelbrot(realStart,realEnd,imgStart,imgEnd)); 
					
			}
			//if number of arguments is 6
			else if(args.length==6) {
				double realStart = Double.parseDouble(args[1]);	//setting the left boundary of the real axis
				double realEnd = Double.parseDouble(args[2]);	//setting the right boundary of the real axis
				double imgStart = Double.parseDouble(args[3]);	//setting the lower boundary of the imaginary axis
				double imgEnd = Double.parseDouble(args[4]);	//setting the upper boundary of the imaginary axis
				double iter = Double.parseDouble(args[5]);		//setting the number of iterations
				
				//operation is done with giver region of interest and given no.Of iterations
				frame.setContentPane(new Mandelbrot(realStart,realEnd,imgStart,imgEnd,iter)); 

			}
			else {
				System.out.println("Incorrect Inputs");
				System.exit(0);
			}
			
			//setting the frame
			frame.pack(); 
			frame.setLocationRelativeTo(null); 
			frame.setVisible(true); 
			
		}
		else if(args[0].equals("Julia")) {
			
			// create a frame
			JFrame frame = new JFrame("Julia"); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//if number of arguments is 1
			if(args.length==1) {
				//operation is done with default values
				frame.setContentPane(new Julia());
			}
			//if number of arguments is 3
			else if(args.length==3) {
				//getting the constant complex number
				double real = Double.parseDouble(args[1]);
				double imaginary = Double.parseDouble(args[2]);
				
				//operation is done with default number of iterations
				frame.setContentPane(new Julia(real,imaginary,1000));
				
			}
			//if number of arguments is 4
			else if(args.length==4) {
				//getting the constant complex number
				double real = Double.parseDouble(args[1]);
				double imaginary = Double.parseDouble(args[2]);
				double iter = Double.parseDouble(args[3]);
				
				//operation is done with given values
				frame.setContentPane(new Julia(real,imaginary,iter));
			}
			else {
				System.out.println("Incorrect inputs");
				System.exit(0);
			}
			
			//setting the frame
			frame.pack(); 
			frame.setLocationRelativeTo(null); 
			frame.setVisible(true); 
			
		}
		else {
				System.out.println("Incorrect inputs");
				System.exit(0);
		}
		
		
			
	}
		
		
		 

	}

