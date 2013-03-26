//Evelyn Cordner, ecordner@mit.edu, R05 Pete Kruskall, Problem Set 7

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class ContainerView extends JPanel {

	private Model model;

	private String mode = "default";
	private double scaleFactor = 1;
	private double q;

	private double boxHeight;
	private double boxWidth;
	private double boxDepth;

	private double canRadius;
	private double canHeight;

	private double boxHeightOpt;
	private double boxWidthOpt;
	private double boxDepthOpt;

	private double canRadiusOpt;
	private double canHeightOpt;

	public ContainerView(Model m){
		this.model = m;
	}

	public void setMode(String s){
		mode = s;
	}


	public void paintComponent(Graphics g) {
		super.paintComponent (g);
		Graphics2D g2 = (Graphics2D) g;

		scaleFactor = 50;

		boxHeight = model.getBoxHeight() * scaleFactor;
		boxWidth = model.getBoxWidth() * scaleFactor;
		boxDepth = model.getBoxDepth() * scaleFactor;

		canRadius = model.getCanRadius() * scaleFactor;
		canHeight = model.getCanHeight() * scaleFactor;

		boxHeightOpt = model.getOptimalHeightCube() * scaleFactor;
		boxWidthOpt = model.getOptimalWidthCube() * scaleFactor;
		boxDepthOpt = model.getOptimalDepthCube() * scaleFactor;

		canRadiusOpt = model.getOptimalRadiusCyl() * scaleFactor;
		canHeightOpt = model.getOptimalHeightCyl() * scaleFactor;
		
		q = Math.pow(.5, .5) * boxDepth;

		if (mode.equals ("optCan")) {
			

			//original cylinder
			Shape top = new Ellipse2D.Double (50, 100, 2*canRadius, .25*canRadius);
			Shape side1 = new Line2D.Double(50, .125*canRadius + 100, 50, .125*canRadius + canHeight + 100);
			Shape side2 = new Line2D.Double(50 + 2*canRadius, .125*canRadius + 100, 50 + 2*canRadius, .125*canRadius + canHeight + 100);
			Shape bottom = new Ellipse2D.Double(50, 100+canHeight, 2*canRadius, .25*canRadius);
			g2.draw(top);
			g2.draw(side1);
			g2.draw(side2);
			g2.draw(bottom);

			//optimal cylinder
			Shape topOpt = new Ellipse2D.Double (300, 100 +canHeight - canHeightOpt, 2*canRadiusOpt, .25*canRadiusOpt);
			Shape side1Opt = new Line2D.Double(300, .125*canRadiusOpt + 100 + canHeight - canHeightOpt, 300, .125*canRadiusOpt + canHeight + 100);
			Shape side2Opt = new Line2D.Double(300 + 2*canRadiusOpt, .125*canRadiusOpt + 100 + canHeight - canHeightOpt, 300 + 2*canRadiusOpt, .125*canRadiusOpt + canHeight + 100);
			Shape bottomOpt = new Ellipse2D.Double(300, 100+canHeight , 2*canRadiusOpt, .25*canRadiusOpt);
			g2.draw(topOpt);
			g2.draw(side1Opt);
			g2.draw(side2Opt);
			g2.draw(bottomOpt);

			System.out.println("PAINT");

		}

		else if (mode.equals("optBox")) {
			
			//original cuboid
			Shape front = new Rectangle2D.Double(100, 100, boxWidth, boxHeight);
			Shape back = new Rectangle2D.Double(100 + q, 100 - q, boxWidth, boxHeight);
			Shape corner1 = new Line2D.Double(100, 100, 100 + q, 100 - q);
			Shape corner2 = new Line2D.Double(100 + boxWidth, 100, 100 + boxWidth + q, 100- q);
			Shape corner3 = new Line2D.Double(100, 100 + boxHeight, 100 + q, 100 + boxHeight - q);
			Shape corner4 = new Line2D.Double(100 + boxWidth, 100 + boxHeight, 100 + boxWidth + q, 100 + boxHeight - q);
			g2.draw(front);
			g2.draw(back);
			g2.draw(corner1);
			g2.draw(corner2);
			g2.draw(corner3);
			g2.draw(corner4);
			
			//optimal cuboid
			Shape frontOpt = new Rectangle2D.Double(350, 100 + boxHeight - boxHeightOpt, boxWidthOpt, boxHeightOpt);
			Shape backOpt = new Rectangle2D.Double(350 + q, 100 - q + boxHeight - boxHeightOpt, boxWidthOpt, boxHeightOpt);
			Shape corner1Opt = new Line2D.Double(350, 100 + boxHeight - boxHeightOpt, 350 + q, 100 - q + boxHeight - boxHeightOpt);
			Shape corner2Opt = new Line2D.Double(350 + boxWidthOpt, 100 + boxHeight - boxHeightOpt, 350 + boxWidthOpt + q, 100- q + boxHeight - boxHeightOpt);
			Shape corner3Opt = new Line2D.Double(350, 100 + boxHeight, 350 + q, 100 - q + boxHeight);
			Shape corner4Opt = new Line2D.Double(350 + boxWidthOpt, 100 + boxHeight, 350 + boxWidthOpt + q, 100 - q + boxHeight);
			g2.draw(frontOpt);
			g2.draw(backOpt);
			g2.draw(corner1Opt);
			g2.draw(corner2Opt);
			g2.draw(corner3Opt);
			g2.draw(corner4Opt);



		}
		
		else if (mode.equals("optCont")) {
			
			//Optimal Can (Right)
			Shape top = new Ellipse2D.Double (50, 100, 2*canRadiusOpt, .25*canRadiusOpt);
			Shape side1 = new Line2D.Double(50, .125*canRadiusOpt + 100, 50, .125*canRadiusOpt + canHeightOpt + 100);
			Shape side2 = new Line2D.Double(50 + 2*canRadiusOpt, .125*canRadiusOpt + 100, 50 + 2*canRadiusOpt, .125*canRadiusOpt + canHeightOpt + 100);
			Shape bottom = new Ellipse2D.Double(50, 100+canHeightOpt, 2*canRadiusOpt, .25*canRadiusOpt);
			g2.draw(top);
			g2.draw(side1);
			g2.draw(side2);
			g2.draw(bottom);
			
			//Optimal Box (Left)
			Shape frontOpt = new Rectangle2D.Double(350, 100 + canHeightOpt - boxHeightOpt, boxWidthOpt, boxHeightOpt);
			Shape backOpt = new Rectangle2D.Double(350 + q, 100 - q + canHeightOpt - boxHeightOpt, boxWidthOpt, boxHeightOpt);
			Shape corner1Opt = new Line2D.Double(350, 100 + canHeightOpt - boxHeightOpt, 350 + q, 100 - q + canHeightOpt - boxHeightOpt);
			Shape corner2Opt = new Line2D.Double(350 + boxWidthOpt, 100 + canHeightOpt - boxHeightOpt, 350 + boxWidthOpt + q, 100- q + canHeightOpt - boxHeightOpt);
			Shape corner3Opt = new Line2D.Double(350, 100 + canHeightOpt, 350 + q, 100 - q + canHeightOpt);
			Shape corner4Opt = new Line2D.Double(350 + boxWidthOpt, 100 + canHeightOpt, 350 + boxWidthOpt + q, 100 - q + canHeightOpt);
			g2.draw(frontOpt);
			g2.draw(backOpt);
			g2.draw(corner1Opt);
			g2.draw(corner2Opt);
			g2.draw(corner3Opt);
			g2.draw(corner4Opt);
		}


	}
}
