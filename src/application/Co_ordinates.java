package application;

public interface Co_ordinates {
 public enum coOrdinates{
	 Dublin("latitude=53.33&longitude=-6.25"),
	 Rome("latitude=41.89&longitude=12.51"),
	 London("latitude=51.51&longitude=-0.13"),
	 Madrid("latitude=40.42&longitude=-3.70"),
	 Paris("latitude=48.85&longitude=2.35"),
	 Aughrim("latitude=52.85&longitude=-6.33"), 
	 Armento("latitude=40.31&longitude=16.07");

	coOrdinates(String string) {
		// TODO Auto-generated constructor stub
		this.string = string;
	}
	public String string;
	public String getString() {
		return string;
	}
 }
}
