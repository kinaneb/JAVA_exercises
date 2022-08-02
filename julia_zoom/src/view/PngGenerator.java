package view;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.io.File;

import controller.FractalGenerator;
import model.*;


public class PngGenerator {

	static BufferedImage theImage;
	


	/*
	public void display(int definition) {
		theImage = new BufferedImage(definition+1, definition+1, BufferedImage.TYPE_INT_RGB);
		for(Point p : values) {
			//System.out.println(p.getValue()+"  "+colors[p.getValue()]);
			//int value = p.getValue()*10 << 16 | p.getValue()*5 << 8 | p.getValue()*2;

			//System.out.println(value);
			//theImage.setRGB(p.getA(), p.getB(), value);
			theImage.setRGB(p.getA(), p.getB(), colors[p.getValue()]);
		}
		System.out.println("before try");
		File outputfile = new File("saved.png");
	    try {
			//ImageIO.write(theImage, "png", outputfile);
			System.out.println(" in try in ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	static void createPng(double aMin, double aMax, double bMin, double bMax, int width, int height, double im, double re, boolean f_set) throws Exception{
		double stepX = 4.0/Double.valueOf(width);
		double stepY = 4.0/Double.valueOf(height);
		theImage = new BufferedImage(width+1, height+1, BufferedImage.TYPE_INT_RGB);
        /*this.aMin = aMin;
        this.aMax = aMax;
        this.bMin = bMin;
        this.bMax = bMax;
        this.stepX = stepX;
        this.stepY = stepY;*/
		int x = 0;
		int y = 0;
		Plan plan = new Plan(aMin,aMax,bMin,bMax);
		FractalGenerator fractal = new FractalGenerator(plan, 250);
		//fractal.calculateJulia(new Complex(0.285, i));
		//PngGenerator pngGen = new PngGenerator(plan.getValues(), colors);
		//pngGen.display(200);
		//FileInputStream inputstream = new FileInputStream("./saved.png");
		//Image image = new Image(inputstream);
		//Image imgToDisplay = new Image(inputstream);
		//iview.setImage(imgToDisplay);
		//double planLength = aMax - aMin;
		if(f_set) {
			for (double a = aMin; a <= aMax; a = a + stepX) {
				for (double b = bMax; b >= bMin; b = b - stepY) {
					int value = fractal.divergenceJulia(new Complex(a, b), new Complex(re, im), fractal.getMaxIteration());
					int color = value*10 << 16 | value*5 << 8 | value*2;
					theImage.setRGB(x, y, 256-color);
					y++;
				}
				x++;
				y = 0;
			}
		}
		else
		{
			for (double a = aMin; a < aMax; a = a + stepX) {
				for (double b = bMin; b < bMax; b = b + stepY) {
					int value = fractal.divergenceMandelbrot( new Complex(re, im), new Complex(a, b), fractal.getMaxIteration());
					int color = value*10 << 16 | value*5 << 8 | value*2;
					theImage.setRGB(x, y, 256-color);
					y++;
				}
				x++;
				y = 0;
			}
		}
		File file = new File("set.png");
		try {
			ImageIO.write(theImage, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}




