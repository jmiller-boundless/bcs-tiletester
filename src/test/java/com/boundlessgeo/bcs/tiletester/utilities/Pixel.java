package com.boundlessgeo.bcs.tiletester.utilities;

public class Pixel {
	private Double x;
	private Double y;
	public Pixel(Double px, Double py) {
		x=px;
		y=py;
	}
	public Pixel(Integer px, Integer py) {
		x=Double.valueOf(px);
		y=Double.valueOf(py);
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	

}
