package com.example.gcit;

public abstract class Widget {
	private int xcor;
	private int ycor;
	
	public abstract void doAction();

	public int getXcor() {
		return xcor;
	}

	public void setXcor(int xcor) {
		this.xcor = xcor;
	}

	public int getYcor() {
		return ycor;
	}

	public void setYcor(int ycor) {
		this.ycor = ycor;
	}

}
