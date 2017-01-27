import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;

public class BuilderFrame extends JFrame implements ActionListener
{
	private final double PI = 3.141592653589793;
	private final String sLAF = "nimbus";

	private JTabbedPane tpBuilder = new JTabbedPane();

	private JPanel pnlBuild = new JPanel(null); //layout

 	private JPanel pnlWorkspace = new JPanel();
 	private JScrollPane scrlWorkspace = new JScrollPane(pnlWorkspace);
	
	private JButton btnSave = new JButton();
	private JButton btnLoad = new JButton();

	private JLabel lblRectShape = new JLabel();
	private JButton btnRectUp = new JButton();
	private JButton btnRectDown = new JButton();
	private JButton btnRectLeft = new JButton();
	private JButton btnRectRight = new JButton();

	private JLabel lblCrlShape = new JLabel();
	private JButton btnCrlUp = new JButton();
	private JButton btnCrlDown = new JButton();
	private JButton btnCrlRight = new JButton();
	private JButton btnCrlLeft = new JButton();

	private JLabel lblFoundArea = new JLabel();

	private int iShapeCount = 0;
	private JButton[] shpOnWorkspace = new JButton[255];

	private double dArea = 0;
	private double dLongestSide = 0;
	private double dWidth = 0;
	private PricingPanel pnlPricingPanel;


 public void startGUI()
 {
 
	this.setLayout(new GridLayout(1,1));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

	initBuildPanel();

	tpBuilder.add(pnlBuild, "Room Builder");

	pnlPricingPanel = new PricingPanel(); 

	tpBuilder.add(pnlPricingPanel, "Pricing");
	this.add(tpBuilder);


	this.setTitle("Room Builder $(BuildNumber)");
	this.setSize(840,640);
	this.setVisible(true);
	this.setResizable(false);
 }


 
 public void initBuildPanel()
 {
 
 	btnSave.setText("Save");
 	btnSave.setLocation(0,0);
	btnSave.setSize(80,32);
	pnlBuild.add(btnSave);
	
	btnLoad.setText("Load");
	btnLoad.setLocation(0,32);
	btnLoad.setSize(80,32);
	pnlBuild.add(btnLoad);

	scrlWorkspace.setLocation(16,100);
	scrlWorkspace.setSize(640,480);
	scrlWorkspace.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

	scrlWorkspace.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrlWorkspace.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 

	pnlWorkspace.setPreferredSize(new Dimension(1280, 960));
	pnlWorkspace.setLayout(null);

	
	scrlWorkspace.setViewportView(pnlWorkspace);
	pnlBuild.add(scrlWorkspace, pnlWorkspace);


	String[] strBtnFont = {"<html><font size=\"4\">", "<\\font><\\html>"};

	lblRectShape.setLocation(665,100);
	lblRectShape.setSize(175,32);
	lblRectShape.setOpaque(true);
	lblRectShape.setText("Add a rectangular shape:");
	pnlBuild.add(lblRectShape);

	lblCrlShape.setLocation(665,224);
	lblCrlShape.setSize(150,32);
	lblCrlShape.setOpaque(true);
	lblCrlShape.setText("Add a circular shape:");
	pnlBuild.add(lblCrlShape);

	btnRectUp.setLocation(725,133);
	btnRectUp.setSize(25,25);
	btnRectUp.addActionListener(this);
	btnRectUp.setText(strBtnFont[0] + "\u21E7" + strBtnFont[1]);
	btnRectUp.setMargin(new Insets(0, 0, 0, 0));
	pnlBuild.add(btnRectUp);

	btnRectDown.setLocation(725,181);
	btnRectDown.setSize(25,25);
	btnRectDown.addActionListener(this);
	btnRectDown.setText(strBtnFont[0] + "\u21E9" + strBtnFont[1]);
	btnRectDown.setMargin(new Insets(0, 0, 0, 0));
	pnlBuild.add(btnRectDown);

	btnRectLeft.setLocation(701,157);
	btnRectLeft.setSize(25,25);
	btnRectLeft.addActionListener(this);
	btnRectLeft.setText(strBtnFont[0] + "\u21E6" + strBtnFont[1]);
	btnRectLeft.setMargin(new Insets(0, 0, 0, 0));
	pnlBuild.add(btnRectLeft);

	btnRectRight.setLocation(749,157);
	btnRectRight.setSize(25,25);
	btnRectRight.addActionListener(this);
	btnRectRight.setText(strBtnFont[0] + "\u21E8" + strBtnFont[1]);
	btnRectRight.setMargin(new Insets(0, 0, 0, 0));
	pnlBuild.add(btnRectRight);

	btnCrlUp.setLocation(725,265);
	btnCrlUp.setSize(25,25);
	btnCrlUp.addActionListener(this);
	btnCrlUp.setText(strBtnFont[0] + "\u21E7" + strBtnFont[1]);
	btnCrlUp.setMargin(new Insets(0, 0, 0, 0));
	pnlBuild.add(btnCrlUp);

	btnCrlDown.setLocation(725,313);
	btnCrlDown.setSize(25,25);
	btnCrlDown.addActionListener(this);
	btnCrlDown.setText(strBtnFont[0] + "\u21E9" + strBtnFont[1]);
	btnCrlDown.setMargin(new Insets(0, 0, 0, 0));
	pnlBuild.add(btnCrlDown);

	btnCrlLeft.setLocation(701,289);
	btnCrlLeft.setSize(25,25);
	btnCrlLeft.addActionListener(this);
	btnCrlLeft.setText(strBtnFont[0] + "\u21E6" + strBtnFont[1]);
	btnCrlLeft.setMargin(new Insets(0, 0, 0, 0));
	pnlBuild.add(btnCrlLeft);

	btnCrlRight.setLocation(749,289);
	btnCrlRight.setSize(25,25);
	btnCrlRight.addActionListener(this);
	btnCrlRight.setText(strBtnFont[0] + "\u21E8" + strBtnFont[1]);
	btnCrlRight.setMargin(new Insets(0, 0, 0, 0));
	pnlBuild.add(btnCrlRight);

	lblFoundArea.setLocation(700, 500);
	lblFoundArea.setSize(100,24);
	lblFoundArea.setText("Area: 10000m\u00B2");

 }
 
 public void setLaf()
 {
 	try
	{
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
		{
			if (sLAF.equals("sys"))
			{
				//Set Windows Look and feel if it is available (for Windows)
				if ("Windows".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
				//Set GTK2,3,4 Look and feel if it is available (for Linux)
				if ("GTK+".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
				

			}
			else if (sLAF.equals("nimbus")) 
			{
				if ("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			
		}

	}
	catch (Exception e)
	{
		System.out.println("Failed to set LAF");
	}
	
 }

 public void actionPerformed(ActionEvent e)
 {
 	String input0,input1,input2 = new String();
 	input0 = "";
 	input1 = "";
 	input2 = "";


	if(e.getSource()==btnRectUp)
	{
		input0 = "rect";
		input1 = JOptionPane.showInputDialog("Generate a rectangle above the selected object\nWidth(m):");
		input2 = JOptionPane.showInputDialog("Generate a rectangle above the selected object\nLength(m):");

	}
	if(e.getSource()==btnRectDown)
	{
		input0 = "rect";
		input1 = JOptionPane.showInputDialog("Generate a rectangle below the selected object\nWidth(m):");
		input2 = JOptionPane.showInputDialog("Generate a rectangle below the selected object\nLength(m):");
	}
	if(e.getSource()==btnRectLeft)
	{
		input0 = "rect";
		input1 = JOptionPane.showInputDialog("Generate a rectangle left of the selected object\nWidth(m):");
		input2 = JOptionPane.showInputDialog("Generate a rectangle left of the selected object\nLength(m):");
	}
	if(e.getSource()==btnRectRight)
	{
		input0 = "rect";
		input1 = JOptionPane.showInputDialog("Generate a rectangle right of the selected object\nWidth(m):");
		input2 = JOptionPane.showInputDialog("Generate a rectangle right of the selected object\nLength(m):");
	}
	if(e.getSource()==btnCrlUp)
	{
		input0 = "crl";
		input1 = JOptionPane.showInputDialog("Generate a circular shape above the selected object\nRadius x(m):");
		input2 = JOptionPane.showInputDialog("Generate a circular shape above the selected object\nRadius y(m):");
	}
	if(e.getSource()==btnCrlDown)
	{
		input0 = "crl";
		input1 = JOptionPane.showInputDialog("Generate a circular shape below the selected object\nRadius x(m):");
		input2 = JOptionPane.showInputDialog("Generate a circular shape below the selected object\nRadius y(m):");
	}
	if(e.getSource()==btnCrlLeft)
	{
		input0 = "crl";
		input1 = JOptionPane.showInputDialog("Generate a circular shape left of the selected object\nRadius x(m):");
		input2 = JOptionPane.showInputDialog("Generate a circular shape left of the selected object\nRadius y(m):");
	}
	if(e.getSource()==btnCrlRight)
	{
		input0 = "crl";
		input1 = JOptionPane.showInputDialog("Generate a circular shape right of the selected object\nRadius x(m):");
		input2 = JOptionPane.showInputDialog("Generate a circular shape right of the selected object\nRadius y(m):");
	}
	if(e.getSource()==btnRectUp||e.getSource()==btnRectDown||e.getSource()==btnRectLeft||e.getSource()==btnRectRight||
			e.getSource()==btnCrlUp||e.getSource()==btnCrlDown||e.getSource()==btnCrlLeft||e.getSource()==btnRectRight)
	{
		if(iShapeCount==0)
		{
			if(input0.equals("rect"))
			{
				int iInput1 = Integer.parseInt(java.lang.Math.round(Double.parseDouble(input1)) +"");
				int iInput2 = Integer.parseInt(java.lang.Math.round(Double.parseDouble(input2)) +"");
				shpOnWorkspace[iShapeCount] = new RectangleButton();
				shpOnWorkspace[iShapeCount].setLocation(32,32);
				shpOnWorkspace[iShapeCount].setSize(iInput1*10,iInput2*10);
				shpOnWorkspace[iShapeCount].setIcon(null);
				pnlWorkspace.add(shpOnWorkspace[iShapeCount]);
				pnlWorkspace.repaint();
				dArea = Math.round(Double.parseDouble(input1) * Double.parseDouble(input2) * 10000.0)/10000.0;
				iShapeCount++;
			}
			if(input0.equals("crl"))
			{
				int iInput1 = Integer.parseInt(java.lang.Math.round(Double.parseDouble(input1))+"");
				int iInput2 = Integer.parseInt(java.lang.Math.round(Double.parseDouble(input2))+"");
				shpOnWorkspace[iShapeCount] = new EllipseButton();
				shpOnWorkspace[iShapeCount].setLocation(32,32);
				shpOnWorkspace[iShapeCount].setSize(iInput1*5,iInput2*5);
				shpOnWorkspace[iShapeCount].setIcon(null);
				pnlWorkspace.add(shpOnWorkspace[iShapeCount]);
				pnlWorkspace.repaint();
				dArea = Math.round(PI * Double.parseDouble(input1) * Double.parseDouble(input2) * 10000.0)/10000.0;
				iShapeCount++;
			}
		}
		else
		{
			/*
			if(input0.equals("rect"))
			{

				iShapeCount++;
			}
			if(input0.equals("crl"))
			{
				
				iShapeCount++;
			}
			*/
			JOptionPane.showMessageDialog(null, "This still needs fixing:\n\n Shape count was not increased as system was unable to locate initial shape");
		}
	}


	/*
	int tmpIntTabCount = tpBuilder.getTabCount();
	if(dArea!=0)
	{		
		if(tmpIntTabCount>2)
		{
			System.out.println("Too many tabs");
		}
		if(tmpIntTabCount<2)
		{
			pnlPricingPanel = new PricingPanel(dLongestSide, dWidth, dArea); //Pass through (double dLongestSide, double dWidth, double dArea)
			tpBuilder.add(pnlPricingPanel, "Pricing");
		}
	}
	else
	{
		pnlPricingPanel = null;
		if(tmpIntTabCount>1)
		{
			tpBuilder.remove(1);
		}
	}
	*/
	
 }
 
 public static void main(String[] args )
 {
	BuilderFrame objBuilderFrame = new BuilderFrame();
	objBuilderFrame.setLaf();
	objBuilderFrame = new BuilderFrame();
	objBuilderFrame.startGUI();
 }
 
 
}  
