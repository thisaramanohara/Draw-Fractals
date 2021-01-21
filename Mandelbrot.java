import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;

class Mandelbrot extends JPanel{
	
	private int width = 800;	//width of the canvas
	private int height = 800;	//height of the canvas
	double xGap;	//distance between 2 points in the x axis
	double yGap;	//distance between 2 points in the y axis
	double yMax;	//maximum value of y
	double xMin;	//minimum value of x
	double iter = 1000;		//default iteration size
	
	
	//0 arguments for Mandelbrot set
	public Mandelbrot() {
		//setting width and height of the canvas
		setPreferredSize(new Dimension(width,height)); 

		double xRange = 2;	//by default range of x axis is = 1-(-1)=2
		double yRange = 2;	//by default range of y axis is = 1-(-1)=2
		
		this.yMax = 1;	//by default max of y is 1
		this.xMin = -1;	//by default min of x is -1
		
		this.xGap = xRange / 800;	//getting the gap between 2 points in the x axis
		this.yGap = yRange / 800;	//getting the gap between 2 points in the y axis
		
	}
	
	
	//4 arguments for Mandelbrot set
	public Mandelbrot(double startRealRange,double endRealRange,double startImgRange,double endImgRange) {
		//setting width and height of the canvas
		setPreferredSize(new Dimension(width,height)); 

		double xRange = endRealRange - startRealRange;	//getting the range of x axis
		double yRange = endImgRange - startImgRange;	//getting the range of y axis
		
		this.yMax = endImgRange;	//getting the max of y
		this.xMin = startRealRange;	//getting the min of x
		
		this.xGap = xRange / 800;	//getting the gap between 2 points in the x axis
		this.yGap = yRange / 800;	//getting the gap between 2 points in the y axis
		
	}
	
	
	//5 arguments for Mandelbrot set
	public Mandelbrot(double startRealRange,double endRealRange,double startImgRange,double endImgRange,double iter) {
		
		this.iter = iter;	//getting the iteration size
		//setting width and height of the canvas
		setPreferredSize(new Dimension(width,height)); 

		double xRange = endRealRange - startRealRange;	//getting the range of x axis
		double yRange = endImgRange - startImgRange;	//getting the range of y axis
		
		this.yMax = endImgRange;	//getting the max of y
		this.xMin = startRealRange;	//getting the min of x
		
		this.xGap = xRange / 800;	//getting the gap between 2 points in the x axis
		this.yGap = yRange / 800;	//getting the gap between 2 points in the y axis
		
	}
	
	//to print a point (this method is synchronized)
	synchronized public static void printPoint(Graphics2D frame, Color c, double x,double y) {
		frame.setColor(c); //setting the color
		frame.draw(new Line2D.Double(x, y,x, y));	//get coordinates and draw the point
		
	}
	
	//paint component method
	public void paintComponent(Graphics g) { 
		//call paintComponent from parent class 
		super.paintComponent(g); 
		//setting graphics in the MQuadrant class
		MQuadrant.setGraphic(g);
		
		//creating 4 objects from the MQuadrant class
		MQuadrant quadrant [] = new MQuadrant[4];
		
		//creating 4 threads
		//one thread fills only one quadrant of the graph 
		Thread thread[] = new Thread[4];
		
		//setting values to those 4 objects
		quadrant [0] = new MQuadrant(1, xGap, xMin, yGap, yMax, iter);	//for the 1st quadrant
		quadrant [1] = new MQuadrant(2, xGap, xMin, yGap, yMax, iter);	//for the 2nd quadrant
		quadrant [2] = new MQuadrant(3, xGap, xMin, yGap, yMax, iter);	//for the 3rd quadrant
		quadrant [3] = new MQuadrant(4, xGap, xMin, yGap, yMax, iter);	//for the 4th quadrant
		
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
