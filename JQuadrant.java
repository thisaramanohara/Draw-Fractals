import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;

class JQuadrant extends JPanel implements Runnable {
	
	 static Graphics g;	//g is common to all objects of JQuadrant
	 int qNum;	//quadrant number
	 double xGap,xMin,yGap,yMax,iter,constReal,constImag;	//definitions of these variables are same as before

	//static method to set Graphics
	public static void setGraphic(Graphics g) {
		JQuadrant.g= g;
	}
	
	//constructor with 8 parameters
	public JQuadrant(int qNum,double xGap,double xMin,double yGap,double yMax,double iter,double constReal,double constImag) {
		//getting values
		this.qNum = qNum;
		this.xGap = xGap;
		this.xMin = xMin;
		this.yGap = yGap;
		this.yMax = yMax;
		this.iter = iter;
		this.constReal = constReal;
		this.constImag = constImag;
	}
	
	//thread will execute this method
	public void run() {
		//initially setting zero
		double cRea=0;	//cRea is the x value of the point in the complex plane 
		double cImg=0;	//cImg is the y value of the point in the complex plane 
		double sel = 0;	//to get the value of cImg
		
		//initially setting zero
		//iStart is where x coordinate starts.	iEnd is where x coordinate ends
		//jStart is where y coordinate starts.	jEnd is where y coordinate ends
		int iStart=0,iEnd=0,jStart=0,jEnd=0;
		
		//switch case to find the specified quadrant
		switch (this.qNum) {
		//for the 1st quadrant
		case 1:
			cRea = 0;	cImg = this.yMax;	
			iStart = 400;	iEnd = 800;
			jStart = 0;		jEnd = 400;
			sel = this.yMax;
			break;
		
		//for the 2nd quadrant	
		case 2:
			cRea = this.xMin;	cImg = this.yMax;
			iStart = 0;	iEnd = 400;
			jStart = 0;		jEnd = 400;
			sel = this.yMax;
			break;
		//for the 3rd quadrant	
		case 3:
			cRea = this.xMin;	cImg = 0;
			iStart = 0;	iEnd = 400;
			jStart = 400;		jEnd = 800;
			sel = 0;
			break;
		//for the 4th quadrant	
		case 4:
			cRea = 0;	cImg = 0;
			iStart = 400;	iEnd = 800;
			jStart = 400;		jEnd = 800;
			sel = 0;
			break;
			
		default:
			break;
		}
		    
		 
		//painting the selected quadrant
	    for(int i=iStart;i<iEnd;i++) {
	    	cRea = cRea + this.xGap;	//adding xGap to current x value
	    	cImg = sel;
	    	
	    	for(int j=jStart;j<jEnd;j++) {
	    		double x=cRea;
	    		double y=cImg;		
	    		double iteration =0;	//initially set current iteration

	    		//checking the condition
	    		while(x*x+y*y <=4 && iteration<this.iter) {
	    			//calculating the real part of the right side of the formula
	    			double x_new = x*x - y*y + this.constReal;
	    			
	    			//calculating the imaginary part of the right side of the formula
	    			y = 2*x*y + this.constImag;
	    			
	    			x = x_new;	//update x with calculated real part	
	    			iteration++;	//incrementing the current iteration
	    			
	    		}
	    		
	    		//if it is in Julia set
	    		if(iteration==this.iter) {
	    			//setting color black and call printpoint method in Julia class to print the point 
	    			Julia.printPoint((Graphics2D)g, Color.BLACK, i,j);
	    		}
	    		//otherwise setting different color to the point
	    		else {
	    			Color color = Color.getHSBColor((float)iteration/(float)iter, 1.0f, 1.0f);
	    			Julia.printPoint((Graphics2D)g, color, i, j);
	    		}
	    		
	    		
	    		
	    		
	    		cImg -= this.yGap;	//go to the next coordinate of the imaginary axis
	    		
	    	}
	    }
	    


	}
	
}
