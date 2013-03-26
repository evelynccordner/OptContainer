import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



//Evelyn Cordner, ecordner@mit.edu, R05 Pete Kruskall, Problem Set 6

public class ContaineControler extends JFrame {

	private Container canvas;
	private JButton optimalCan, optimalBox, optimalContainer, breakEven, quit;
	private JLabel boxHeight, boxWidth, boxDepth, canRadius, canHeight, output1, output2, output3, output4, output5, output6, output7, output8, output9, output10, output11, space1, space2, space3;
	private JPanel buttonPanel, dataPanel, bottomPanel, picturePanel, outputPanel;
	private JTextField bHeight, bWidth, bDepth, cRadius, cHeight;
	private ContainerView view;
	private Model model;

	public ContaineControler() {

		canvas = getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		canvas.setLayout(new BorderLayout());
		setSize(1000, 600);
		setTitle("Container");

		buttonPanel = new JPanel();

		optimalCan = new JButton("Optimal can");
		optimalBox = new JButton("Optimal box");
		optimalContainer = new JButton("Optimal container");
		breakEven = new JButton("Breakeven");
		quit = new JButton("Quit");

		buttonPanel.add(optimalCan);
		buttonPanel.add(optimalBox);
		buttonPanel.add(optimalContainer);
		buttonPanel.add(breakEven);
		buttonPanel.add(quit);

		dataPanel = new JPanel();

		boxHeight = new JLabel("Box height");
		bHeight = new JTextField(6);
		boxWidth = new JLabel("Box width");
		bWidth = new JTextField(6);
		boxDepth = new JLabel("Box Depth");
		bDepth = new JTextField(6);
		canRadius = new JLabel("Can Radius");
		cRadius = new JTextField(6);
		canHeight = new JLabel("Can Height");
		cHeight = new JTextField(6);

		dataPanel.add(boxHeight);
		dataPanel.add(bHeight);
		dataPanel.add(boxWidth);
		dataPanel.add(bWidth);
		dataPanel.add(boxDepth);
		dataPanel.add(bDepth);
		dataPanel.add(canRadius);
		dataPanel.add(cRadius);
		dataPanel.add(canHeight);
		dataPanel.add(cHeight);

		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(dataPanel, BorderLayout.NORTH);
		bottomPanel.add(buttonPanel, BorderLayout.SOUTH);


		canvas.add(bottomPanel, BorderLayout.SOUTH);

		picturePanel = new JPanel();
		picturePanel.setLayout(new BorderLayout());

		outputPanel = new JPanel();
		outputPanel.setLayout(new BoxLayout(outputPanel, 1));
		outputPanel.setPreferredSize(new Dimension (333, 600));
		
		space1 = new JLabel(" ");
		space2 = new JLabel(" ");
		space3 = new JLabel(" ");
		
		output1 = new JLabel(" ");
		output2 = new JLabel(" ");
		output3 = new JLabel(" ");
		output4 = new JLabel(" ");
		output5 = new JLabel(" ");
		output6 = new JLabel(" ");
		output7 = new JLabel(" ");
		output8 = new JLabel(" ");
		output9 = new JLabel(" ");
		output10 = new JLabel(" ");
		output11 = new JLabel(" ");
		
		outputPanel.add(space1);
		outputPanel.add(space2);
		outputPanel.add(space3);

		outputPanel.add(output1);
		outputPanel.add(output2);
		outputPanel.add(output3);
		outputPanel.add(output4);
		outputPanel.add(output5);
		outputPanel.add(output6);
		outputPanel.add(output7);
		outputPanel.add(output8);
		outputPanel.add(output9);
		outputPanel.add(output10);
		outputPanel.add(output11);



		canvas.add(picturePanel, BorderLayout.WEST);
		canvas.add(outputPanel, BorderLayout.EAST);


		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});

		optimalCan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				double r = Double.parseDouble(cRadius.getText());
				double h = Double.parseDouble(cHeight.getText());

				if (r > 0 && h > 0) {

					Model optCan = new Model (0, 0, 0, r, h);

					output1.setText("Can optimal / current surface area ratio: " + optCan.getOptimalSurfaceAreaCyl() / optCan.getSurfaceAreaCylinder());
					output2.setText(" ");

					output3.setText("Current can (left)");
					output4.setText("r = " + r + ", h = " + h);
					output5.setText("Volume = " + optCan.getVolumeCylinder());
					output6.setText("Surface area = " + optCan.getSurfaceAreaCylinder());
					output7.setText(" ");

					output8.setText("Optimal can (right)");
					output9.setText("r = " + optCan.getOptimalRadiusCyl() + ", h = " + optCan.getOptimalHeightCyl());
					output10.setText("Volume = " + optCan.getOptimalVolumeCyl());
					output11.setText("Surface area = " + optCan.getOptimalSurfaceAreaCyl());
					
					view = new ContainerView(optCan);
					view.setPreferredSize(new Dimension(800,800));
					view.setMode("optCan");
					view.repaint();
					canvas.add(view, BorderLayout.CENTER);

				}
				else {
					output1.setText(" ");
					output2.setText(" ");
					output3.setText(" ");
					output4.setText(" ");
					output5.setText("Error! Dimensions must be positive!");
					output6.setText(" ");
					output7.setText(" ");
					output8.setText(" ");
					output9.setText(" ");
					output10.setText(" ");
					output11.setText(" ");
				}



			}
		});

		optimalBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				double h = Double.parseDouble(bHeight.getText());
				double w = Double.parseDouble(bWidth.getText());
				double d = Double.parseDouble(bDepth.getText());

				if (h > 0 && w > 0 && d > 0) {

					Model optBox = new Model (h, w, d, 0, 0);

					output1.setText("Box optimal / current surface area ratio: " + optBox.getOptimalSurfaceAreaCube() / optBox.getSurfaceAreaCuboid());
					output2.setText(" ");

					output3.setText("Current box (left)");
					output4.setText("h = " + h + ", w = " + w + ", d = " + d);
					output5.setText("Volume = " + optBox.getVolumeCuboid());
					output6.setText("Surface area = " + optBox.getSurfaceAreaCuboid());
					output7.setText(" ");

					output8.setText("Optimal box (right)");
					output9.setText("h = " + optBox.getOptimalHeightCube() + ", w = " + optBox.getOptimalWidthCube() + ", d = " + optBox.getOptimalDepthCube());
					output10.setText("Volume = " + optBox.getOptimalVolumeCube());
					output11.setText("Surface area = " + optBox.getOptimalSurfaceAreaCube());
					
					view = new ContainerView(optBox);
					view.setPreferredSize(new Dimension(800,800));
					view.setMode("optBox");
					view.repaint();
					canvas.add(view, BorderLayout.CENTER);

				}
				else {
					output1.setText(" ");
					output2.setText(" ");
					output3.setText(" ");
					output4.setText(" ");
					output5.setText("Error! Dimensions must be positive!");
					output6.setText(" ");
					output7.setText(" ");
					output8.setText(" ");
					output9.setText(" ");
					output10.setText(" ");
					output11.setText(" ");
				}



			}
		});
		
		optimalContainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				double boxH = Double.parseDouble(bHeight.getText());
				double boxW = Double.parseDouble(bWidth.getText());
				double boxD = Double.parseDouble(bDepth.getText());
				double canR = Double.parseDouble(cRadius.getText());
				double canH = Double.parseDouble(cHeight.getText());
				
				if( boxH > 0 && boxW > 0 && boxD > 0 && canR > 0 && canH > 0) {
					
					Model optCont = new Model(boxH, boxW, boxD, canR, canH);
					
					output1.setText("Optimal container: " + optCont.findOptimalContainer());
					output2.setText(" ");
					
					output3.setText("Optimal Can (left) ");
					output4.setText("r = " + optCont.getOptimalRadiusCyl() + ", h = " + optCont.getOptimalHeightCyl());
					output5.setText("Volume = " + optCont.getOptimalVolumeCyl());
					output6.setText("Surface area = " + optCont.getOptimalSurfaceAreaCyl());
					output7.setText(" ");
					
					output8.setText("Optimal Box (right) ");
					output9.setText("h = " + optCont.getOptimalHeightCube() + ", w = " + optCont.getOptimalWidthCube() + ", d = " + optCont.getOptimalDepthCube());
					output10.setText("Volume = " + optCont.getOptimalVolumeCube());
					output11.setText("Surface area = " + optCont.getOptimalSurfaceAreaCube());
					
					view = new ContainerView(optCont);
					view.setPreferredSize(new Dimension(800,800));
					view.setMode("optCont");
					view.repaint();
					canvas.add(view, BorderLayout.CENTER);
					
					
				}
				else {
					output1.setText(" ");
					output2.setText(" ");
					output3.setText(" ");
					output4.setText(" ");
					output5.setText("Error! Dimensions must be positive!");
					output6.setText(" ");
					output7.setText(" ");
					output8.setText(" ");
					output9.setText(" ");
					output10.setText(" ");
					output11.setText(" ");
				}

				
			}
		});
		
		breakEven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				double boxH = Double.parseDouble(bHeight.getText());
				double boxW = Double.parseDouble(bWidth.getText());
				double boxD = Double.parseDouble(bDepth.getText());
				double canR = Double.parseDouble(cRadius.getText());
				double canH = Double.parseDouble(cHeight.getText());
				
				if( boxH > 0 && boxW > 0 && boxD > 0 && canR > 0 && canH > 0) {
					
					Model optCont = new Model(boxH, boxW, boxD, canR, canH);
					
					output1.setText("Optimal container: " + optCont.findOptimalContainer());
					output2.setText("Breakeven Ratio: " + optCont.getBreakevenRatio());
					
					output3.setText("Optimal Can (left) ");
					output4.setText("r = " + optCont.getOptimalRadiusCyl() + ", h = " + optCont.getOptimalHeightCyl());
					output5.setText("Volume = " + optCont.getOptimalVolumeCyl());
					output6.setText("Surface area = " + optCont.getOptimalSurfaceAreaCyl());
					output7.setText(" ");
					
					output8.setText("Optimal Box (right) ");
					output9.setText("h = " + optCont.getOptimalHeightCube() + ", w = " + optCont.getOptimalWidthCube() + ", d = " + optCont.getOptimalDepthCube());
					output10.setText("Volume = " + optCont.getOptimalVolumeCube());
					output11.setText("Surface area = " + optCont.getOptimalSurfaceAreaCube());
					
					view = new ContainerView(optCont);
					view.setPreferredSize(new Dimension(800,800));
					view.setMode("optCont");
					view.repaint();
					canvas.add(view, BorderLayout.CENTER);
					
					
				}
				else {
					output1.setText(" ");
					output2.setText(" ");
					output3.setText(" ");
					output4.setText(" ");
					output5.setText("Error! Dimensions must be positive!");
					output6.setText(" ");
					output7.setText(" ");
					output8.setText(" ");
					output9.setText(" ");
					output10.setText(" ");
					output11.setText(" ");
				}

				
			}
		});
		



	}

	public static void main(String[] args) {

		ContaineControler controller = new ContaineControler();
		controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		controller.setVisible(true);


	}
	


}
