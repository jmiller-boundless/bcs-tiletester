package com.boundlessgeo.bcs.tiletester.utilities;

public class TileCoordConverter {
	private Integer tileSize = 256;
	private Double initialResolution= 2 * Math.PI * 6378137 /256;
	private Double originShift = 2 * Math.PI * 6378137 / 2.0;
	public TileCoordConverter(){
		
	}
	public Pixel metersToTileTMS(double x, double y, int zoomlevel){
		Pixel pixels = metersToPixelsTMS(x,y,zoomlevel);
		return pixelsToTileTMS(pixels.getX(),pixels.getY());
	}
	public Pixel metersToTileGoogle(double x, double y, int zoomlevel){
		Pixel pixels = metersToPixelsTMS(x,y,zoomlevel);
		Pixel tms = pixelsToTileTMS(pixels.getX(),pixels.getY());
		return tmsTileToGoogle(tms,zoomlevel);
	}
	
	public Pixel metersToPixelsTMS(double x, double y, int zoomlevel){
		Double res = resolution( zoomlevel );
		 Double px = (x + originShift) / res;
		 Double py = (y + originShift) / res;
		 return new Pixel(px, py);
	}
	
	public Pixel pixelsToTileTMS(double x, double y){
		Integer tx = (int) ( Math.ceil( x / tileSize ) - 1 );
		Integer ty = (int)( Math.ceil( y / tileSize ) - 1 );
		return new Pixel(tx, ty);
	}
	public Pixel tmsTileToGoogle(Pixel tmspixel, double z){
		Double tx = tmspixel.getX();
		Double ty = Math.pow(2, z) - tmspixel.getY() - 1;
		return new Pixel(tx,ty);
	}
	
	private Double resolution(Integer zoom){
		return initialResolution / (Math.pow(2, zoom));
	}
	public String getTMSTileAddressString(Integer z, Pixel tile) {
		return "/"+tile.getX().intValue()+"/" + tile.getY().intValue() + "/"+z+".png";
	}
	public String getGMapAddressString(Integer z, Pixel tile){
		return "?layers=osm:osm&format=image/png&zoom="+z+"&x="+tile.getX().intValue()+"&y="+tile.getY().intValue();
	}

}
