package com.boundlessgeo.bcs.tiletester.utilities;

public class TileCoordConverter {
	private Integer tileSize = 256;
	private Double initialResolution= 2 * Math.PI * 6378137 /256;
	private Double originShift = 2 * Math.PI * 6378137 / 2.0;
	public TileCoordConverter(){
		
	}
	public Pixel metersToTile(double x, double y, int zoomlevel){
		Pixel pixels = metersToPixels(x,y,zoomlevel);
		return pixelsToTile(pixels.getX(),pixels.getY());
	}
	
	public Pixel metersToPixels(double x, double y, int zoomlevel){
		Double res = resolution( zoomlevel );
		 Double px = (x + originShift) / res;
		 Double py = (y + originShift) / res;
		 return new Pixel(px, py);
	}
	
	public Pixel pixelsToTile(double x, double y){
		Integer tx = (int) ( Math.ceil( x / tileSize ) - 1 );
		Integer ty = (int)( Math.ceil( y / tileSize ) - 1 );
		return new Pixel(tx, ty);
	}
	
	private Double resolution(Integer zoom){
		return initialResolution / (Math.pow(2, zoom));
	}
	

}
