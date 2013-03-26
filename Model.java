//Evelyn Cordner, ecordner@mit.edu, R05 Pete Kruskall, Problem Set 7

public class Model {

	private double cubeHeight;
	private double cubeWidth;
	private double cubeDepth;
	private double cubeMCost = 0;
	private double cubeRCost = 1.5;

	private double cylRadius;
	private double cylHeight;
	private double cylMCost = .1;
	private double cylRCost = 1.5/ (Math.PI/4);


	public Model(double cubeH, double cubeW, double cubeD, double cylR, double cylH) {
		cubeHeight = cubeH;
		cubeWidth = cubeW;
		cubeDepth = cubeD;

		cylRadius = cylR;
		cylHeight = cylH;

	}
	//get Methods
	
	public double getBoxHeight() {
		return cubeHeight;
	}
	
	public double getBoxWidth() {
		return cubeWidth;
	}
	
	public double getBoxDepth() {
		return cubeDepth;
	}
	
	public double getCanRadius(){
		return cylRadius;
	}
	
	public double getCanHeight() {
		return cylHeight;
	}

	//Find volume of cylinder
	public double getVolumeCylinder() {
		double volume = Math.PI*Math.pow(cylRadius,2)*cylHeight;
		return volume;
	}

	//Find volume of cuboid
	public double getVolumeCuboid() {
		double volume = cubeWidth*cubeHeight*cubeDepth;
		return volume;
	}

	//Find surface area of cylinder
	public double getSurfaceAreaCylinder () {
		double surfaceArea = 2*Math.PI*Math.pow(cylRadius, 2) + 2*Math.PI*cylRadius*cylHeight;
		return surfaceArea;
	}

	//Find surface area of cuboid
	public double getSurfaceAreaCuboid () {
		double surfaceArea = 2*(cubeWidth*cubeHeight + cubeHeight*cubeDepth + cubeWidth*cubeDepth);
		return surfaceArea;
	}

	//Find optimal dimensions for cylinder
	public double getOptimalRadiusCyl() {
		double volume = this.getVolumeCylinder();
		double radius = Math.pow(volume/ (2* Math.PI), (1.0/3));
		return radius;
	}

	public double getOptimalHeightCyl() {
		double volume = this.getVolumeCylinder();
		double radius = this.getOptimalRadiusCyl();
		double height = volume / (Math.PI*Math.pow(radius, 2));
		return height;
	}
	
	public double getOptimalVolumeCyl () {
		double r = this.getOptimalRadiusCyl();
		double h = this.getOptimalHeightCyl();
		double volume = Math.PI*Math.pow(r,2)*h;
		return volume;
	}
	
	public double getOptimalSurfaceAreaCyl () {
		double r = this.getOptimalRadiusCyl();
		double h = this.getOptimalHeightCyl();
		double surfaceArea = 2*Math.PI*Math.pow(r, 2) + 2*Math.PI*r*h;
		return surfaceArea;
	}

	//Find optimal dimensions for cuboid
	public double getOptimalWidthCube() {
		double volume = this.getVolumeCuboid();
		double width = Math.pow(volume, (1.0/3));
		return width;
	}

	public double getOptimalHeightCube() {
		double height = this.getOptimalWidthCube();
		return height;
	}

	public double getOptimalDepthCube() {
		double depth = this.getOptimalWidthCube();
		return depth;
	}
	
	public double getOptimalVolumeCube() {
		double height = this.getOptimalHeightCube();
		double width = this.getOptimalWidthCube();
		double depth = this.getOptimalDepthCube();
		
		double volume = width*height*depth;
		return volume;
	}
	
	public double getOptimalSurfaceAreaCube () {
		double height = this.getOptimalHeightCube();
		double width = this.getOptimalWidthCube();
		double depth = this.getOptimalDepthCube();
		
		double surfaceArea = 2*(width*height + height*depth + width*depth);
		return surfaceArea;
	}
	

	//Find cost for cylinder
	public double getOptimalCostCylinder() {
		double surfaceArea = this.getSurfaceAreaCylinder();
		double cost = (cylMCost * surfaceArea + cylRCost/(Math.PI/4));
		return cost;
	}

	//Find cost cuboid
	public double getOptimalCostCuboid() {
		double surfaceArea = this.getSurfaceAreaCuboid();
		double costCube= (cubeMCost* surfaceArea + cubeRCost);
		return costCube;
	}

	public String findOptimalContainer() {
		double costCyl = this.getOptimalCostCylinder();
		double costCube = this.getOptimalCostCuboid();

		if (costCyl < costCube) {
			return "Cylinder";
		}
		else return "Cuboid";

	}

	public double getBreakevenRatio() {

		double cylR = this.getOptimalRadiusCyl();
		double cylH = this.getOptimalHeightCyl();
		double cubeW = this.getOptimalWidthCube();
		double cubeH = this.getOptimalHeightCube();
		double cubeD = this.getOptimalDepthCube();

		double ratio = (((cubeW*cubeH + cubeW*cubeD + cubeD+cubeH) - (2*Math.PI*Math.pow(cylR, 2) + 2*Math.PI*cylR*cylH))/((4.0/Math.PI)-1));
		return ratio;
	}	


}