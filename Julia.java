import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;

class Julia extends JPanel{
	
	private int width = 800;	//width of the canvas
	private int height = 800;	//height of the canvas
	double xGap;	//distance between 2 points in the x axis
	double yGap;	//distance between 2 points in the y axis
	double yMax;	//maximum value of y
	double xMin;	//minimum value of x
	double iter = 1000;	//default iteration size
	double constReal;	//real part of the Constant complex number
	double constImag;	//imaginary part of the Constant complex number
	
	
	//0 arguments for julia set
	public Julia() {
		//setting width and height of the canvas
		setPreferredSize(new Dimension(width,height)); 
		
		//setting default complex number (C)
		this.constReal = -0.4;	//real part of C
		this.constImag = 0.6;	//imaginary part of C
		
		double xRange = 2;	//by default range of x axis is = 1-(-1)=2
		double yRange = 2;	//by default range of y axis is = 1-(-1)=2
		
		this.yMax = 1;	//by default max of y is 1
		this.xMin = -1;	//by default min of x is -1
		
		this.xGap = xRange / 800;	//getting the gap between 2 points in the x axis
		this.yGap = yRange / 800;	//getting the gap between 2 points in the y axis
		
	}
		
	//3 arguments for julia set
		public Julia(double cReal,double cImag,double iter) {
			//setting width and height of the canvas
			setPreferredSize(new Dimension(width,height)); 
			
			this.iter = iter;	//setting iteration size
			this.constReal = cReal;	//setting real part of C
			this.constImag = cImag;	//setting imaginary part of C
			
			double xRange = 2;	//by default range of x axis is = 1-(-1)=2
			double yRange = 2;	//by default range of y axis is = 1-(-1)=2
			
			this.yMax = 1;	//by default max of y is 1
			this.xMin = -1;	//by default min of x is -1
			
			this.xGap = xRange / 800;	//getting the gap between 2 points in the x axis
			this.yGap = yRange / 800;	//getting the gap between 2 points in the y axis
			
		}
	
	
	//to print a point (this method is synchronized)
	synchronized public static void printPoint(Graphics2D frame, Color c, double x,double y) {
		frame.setColor(c);	//setting the color
		frame.draw(new Line2D.Double(x, y,x, y));	//get coordinates and draw the point
	}
	
	//paint component method
	public void paintComponent(Graphics g) { 
		//call paintComponent from parent class 
		super.paintComponent(g); 
		//setting graphics in the JQuadrant class
		JQuadrant.setGraphic(g);
		
		//creating 4 objects from the JQuadrant class
		JQuadrant quadrant [] = new JQuadrant[4];
		
		//creating 4 threads
		//one thread fills only one quadrant of the graph 
		Thread thread[] = new Thread[4];
		
		//setting values to those 4 objects
		quadrant [0] = new JQuadrant(1, xGap, xMin, yGap, yMax, iter,constReal,constImag);	//for the 1st quadrant
		quadrant [1] = new JQuadrant(2, xGap, xMin, yGap, yMax, iter,constReal,constImag);	//for the 2nd quadrant
		quadrant [2] = new JQuadrant(3, xGap, xMin, yGap, yMax, iter,constReal,constImag);	//for the 3rd quadrant
		quadrant [3] = new JQuadrant(4, xGap, xMin, yGap, yMax, iter,constReal,constImag);	//for the 4th quadrant
		
		thread[0] = new Thread(quadrant[0]);	//this thread fills the 1st quadrant
		thread[1] = new Thread(quadrant[1]);	//this thread fills the 2nd quadrant
		thread[2] = new Thread(quadrant[2]);	//this thread fills the 3rd quadrant
		thread[3] = new Thread(quadrant[3]);	//this thread fills the 4th quadrant
		
		//starting all 4 threads
		for(int i=0;i<4;i++) {
			thread[i].start();
		}
		
		//wait until all threads are finished
		for(int i=0;i<4;i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		    

	    }
	
	
}
