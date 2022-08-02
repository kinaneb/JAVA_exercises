package controller;

import model.*;
//import model.Complex;

public class FractalGenerator {
	private Plan plan;
	private int maxIteration;
	public double step;


	/** private fucntion */
	public FractalGenerator(Plan plan, int maxIteration) {
		this.plan = plan;
		this.maxIteration = maxIteration;
		//this.step = 0.02;
	}
	public int getMaxIteration(){
		return this.maxIteration;
	}



	// public void calculate2(Complex x0) {
	// 	for (int i = plan.getaMin()*scale; i<=plan.getaMax()*scale; i++) {
	// 		for (int j=plan.getbMin()*scale; j<=plan.getbMax()*scale; j++) {
	// 			Point p = new Point(i-plan.getaMin()*scale,j-plan.getbMin()*scale);
	// 			Complex c = new Complex((double) i/scale, (double) j/scale);
	// 			p.setValue(divergenceIndex(x0, c, this.maxIteration)/2);
	// 			plan.addValue(p);
	// 		}
	// 	} 

	// }

	public void calculateJulia (Complex c) {
		int xPoint=0;
		int yPoint=0;
		System.out.println("befor caculate ");
		for (double i = plan.getaMin(); i<=plan.getaMax(); i=i+step) {
			//System.out.println(step+ " step for i : " + i);
			for (double j=plan.getbMax(); j>=plan.getbMin(); j=j-step) {
				//System.out.println(step+ " step for j : " + j);
				Point p = new Point(xPoint,yPoint);
				p.setValue(divergenceJulia(new Complex(i, j), c, this.maxIteration));
				plan.addValue(p);
				//System.out.println(p);
				yPoint++;
			}
			xPoint++;
			yPoint=0;
		}
		System.out.println("after caculate ");



	}

	 public int divergenceMandelbrot(Complex x0, Complex c, int maxIteration) {
	 	int ite = 0;
	 	Complex xn = x0;
	 	// sortie de boucle si divergence
	 	while (ite++ < maxIteration && xn.abs() <= 2.)
	 		xn = c.plus(xn.times(xn));
	 	return ite;
	 }

	public int divergenceJulia(Complex x0, Complex c, int maxIteration) {
		int ite = 0;
		Complex xn = x0;
		// sortie de boucle si divergence
		while (ite++ < maxIteration && xn.abs() <= 2.)
			xn = c.plus(xn.times(xn));
		return ite;
	}

}
