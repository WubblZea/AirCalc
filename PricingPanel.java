import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;

public class PricingPanel extends JPanel implements ActionListener
{
	JPanel pnlCarpet = new JPanel(null);
	JLabel lblCarpet = new JLabel();
	JLabel lblPricePerMetre = new JLabel();
	JTextField tfPricePerMetre = new JTextField();
	JLabel lblCarpetWidth = new JLabel();
	JTextField tfCarpetWidth = new JTextField();
	JLabel lblLengthRequired = new JLabel();
	JTextField tfLengthRequired = new JTextField();
	JLabel lblCarpetCost = new JLabel();
	JTextField tfCarpetCost = new JTextField();
	JButton btnCarpet = new JButton();

	JPanel pnlTiles = new JPanel(null);
	JLabel lblTiles = new JLabel();
	JLabel lblPricePerMetreSquare = new JLabel();
	JTextField tfPricePerMetreSquare = new JTextField();
	JLabel lblTileWidth = new JLabel();
	JTextField tfTileWidth = new JTextField();
	JLabel lblTileLength = new JLabel();
	JTextField tfTileLength = new JTextField();
	JLabel lblTilesRequired = new JLabel();
	JTextField tfTilesRequired = new JTextField();
	JLabel lblTileCost = new JLabel();
	JTextField tfTileCost = new JTextField();
	JButton btnTiles = new JButton();

	JLabel lblArea = new JLabel();
	JLabel lblLongestSide = new JLabel();
	JLabel lblWidth = new JLabel();

	JButton btnSetAttr = new JButton();

	double dArea;
	double dLongestSide;
	double dWidth;

	public PricingPanel(double TempDLongestSide, double TempDWidth, double TempDArea)
	{
		dArea = TempDArea;
		dLongestSide = TempDLongestSide;
		dWidth = TempDWidth;

		this.setLayout(null);
		initPanel(false);
	} //For use alongside BuilderFrame

	public PricingPanel()
	{
		dArea = 100;
		dLongestSide = 10;
		dWidth = 10;

		this.setLayout(null);
		initPanel(true);
	} //For testing purposes

	public void initCarpetPanel()
	{
		lblCarpet.setLocation(2,2);
		lblCarpet.setSize(200,42);
		lblCarpet.setOpaque(true);
		lblCarpet.setText("<html><h1>Carpet etc.</h1></html>");
		pnlCarpet.add(lblCarpet);

		lblPricePerMetre.setLocation(5,48);
		lblPricePerMetre.setSize(125,24);
		lblPricePerMetre.setOpaque(true);
		lblPricePerMetre.setText("Price Per Metre/£:");
		pnlCarpet.add(lblPricePerMetre);

		tfPricePerMetre.setLocation(132,48);
		tfPricePerMetre.setSize(150,24);
		tfPricePerMetre.setText("");
		tfPricePerMetre.setColumns(10);
		pnlCarpet.add(tfPricePerMetre);

		lblCarpetWidth.setLocation(5,78);
		lblCarpetWidth.setSize(125,24);
		lblCarpetWidth.setOpaque(true);
		lblCarpetWidth.setText("Roll Width/m:");
		pnlCarpet.add(lblCarpetWidth);

		tfCarpetWidth.setLocation(132,78);
		tfCarpetWidth.setSize(150,24);
		tfCarpetWidth.setText("");
		tfCarpetWidth.setColumns(10);
		pnlCarpet.add(tfCarpetWidth);

		lblLengthRequired.setLocation(5,128);
		lblLengthRequired.setSize(125,24);
		lblLengthRequired.setOpaque(true);
		lblLengthRequired.setText("Length Required/m:");
		pnlCarpet.add(lblLengthRequired);

		tfLengthRequired.setLocation(132,128);
		tfLengthRequired.setSize(150,24);
		tfLengthRequired.setText("");
		tfLengthRequired.setColumns(10);
		tfLengthRequired.setEnabled(false);
		pnlCarpet.add(tfLengthRequired);

		lblCarpetCost.setLocation(5,158);
		lblCarpetCost.setSize(125,24);
		lblCarpetCost.setOpaque(true);
		lblCarpetCost.setText("Cost/£:");
		pnlCarpet.add(lblCarpetCost);

		tfCarpetCost.setLocation(132,158);
		tfCarpetCost.setSize(150,24);
		tfCarpetCost.setText("");
		tfCarpetCost.setColumns(10);
		tfCarpetCost.setEnabled(false);
		pnlCarpet.add(tfCarpetCost);
	}

	public void initTilePanel()
	{
		lblTiles.setLocation(2,2);
		lblTiles.setSize(200,42);
		lblTiles.setOpaque(true);
		lblTiles.setText("<html><h1>Tiles etc.</h1></html>");
		pnlTiles.add(lblTiles);

		lblPricePerMetreSquare.setLocation(5,48);
		lblPricePerMetreSquare.setSize(125,24);
		lblPricePerMetreSquare.setOpaque(true);
		lblPricePerMetreSquare.setText("Price Per Metre\u00B2/£:");
		pnlTiles.add(lblPricePerMetreSquare);

		tfPricePerMetreSquare.setLocation(132,48);
		tfPricePerMetreSquare.setSize(150,24);
		tfPricePerMetreSquare.setText("");
		tfPricePerMetreSquare.setColumns(10);
		pnlTiles.add(tfPricePerMetreSquare);

		lblTileWidth.setLocation(5,78);
		lblTileWidth.setSize(125,24);
		lblTileWidth.setOpaque(true);
		lblTileWidth.setText("Tile Width/m:");
		pnlTiles.add(lblTileWidth);

		tfTileWidth.setLocation(132,78);
		tfTileWidth.setSize(150,24);
		tfTileWidth.setText("");
		tfTileWidth.setColumns(10);
		pnlTiles.add(tfTileWidth);

		lblTileLength.setLocation(5,108);
		lblTileLength.setSize(125,24);
		lblTileLength.setOpaque(true);
		lblTileLength.setText("Tile Length/m:");
		pnlTiles.add(lblTileLength);

		tfTileLength.setLocation(132,108);
		tfTileLength.setSize(150,24);
		tfTileLength.setText("");
		tfTileLength.setColumns(10);
		pnlTiles.add(tfTileLength);

		lblTilesRequired.setLocation(5,158);
		lblTilesRequired.setSize(125,24);
		lblTilesRequired.setOpaque(true);
		lblTilesRequired.setText("Tiles Required/m:");
		pnlTiles.add(lblTilesRequired);

		tfTilesRequired.setLocation(132,158);
		tfTilesRequired.setSize(150,24);
		tfTilesRequired.setText("");
		tfTilesRequired.setColumns(10);
		tfTilesRequired.setEnabled(false);
		pnlTiles.add(tfTilesRequired);

		lblTileCost.setLocation(5,188);
		lblTileCost.setSize(125,24);
		lblTileCost.setOpaque(true);
		lblTileCost.setText("Cost/£:");
		pnlTiles.add(lblTileCost);

		tfTileCost.setLocation(132,188);
		tfTileCost.setSize(150,24);
		tfTileCost.setText("");
		tfTileCost.setColumns(10);
		tfTileCost.setEnabled(false);
		pnlTiles.add(tfTileCost);
	}

	public void initPanel(boolean bDebugging)
	{

		lblArea.setLocation(0,100);
		lblArea.setSize(148,24);
		lblArea.setOpaque(true);
		lblArea.setText("Area: " + dArea + "m\u00B2");
		this.add(lblArea);

		lblLongestSide.setLocation(0,128);
		lblLongestSide.setSize(148,24);
		lblLongestSide.setOpaque(true);
		lblLongestSide.setText("Longest Side: " + dLongestSide + "m");
		this.add(lblLongestSide);

		lblWidth.setLocation(0,156);
		lblWidth.setSize(148,24);
		lblWidth.setOpaque(true);
		lblWidth.setText("Parallel Width: " + dWidth + "m");
		this.add(lblWidth);

		btnSetAttr.setLocation(0,0);
		btnSetAttr.setSize(100,50);
		btnSetAttr.addActionListener(this);
		btnSetAttr.setText("Set Values");
		if (bDebugging) {this.add(btnSetAttr);}

		pnlCarpet.setLocation(150,100);
		pnlCarpet.setSize(300,400);
		pnlCarpet.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		initCarpetPanel();
		this.add(pnlCarpet);

		pnlTiles.setLocation(474,100);
		pnlTiles.setSize(300,400);
		pnlTiles.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		initTilePanel();
		this.add(pnlTiles);
	}
	public void setLaf()
	{
	 	try
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
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
		}
		catch (Exception e)
		{
			System.out.println("Failed to set LAF");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnSetAttr)
		{


			boolean result=true;
			String sArea = JOptionPane.showInputDialog("Enter Area(m\u00B2):");
			if (!(sArea==null))
			{
				for (int i = 0 ; i<sArea.length() ; i++)
				{
					if ((!(Character.isDigit(sArea.charAt(i))||sArea.charAt(i)=='.'))||(sArea.charAt(i)=='d')||(sArea.charAt(i)=='f'))
					{
						JOptionPane.showMessageDialog(null, "Error: input of Area was NaN - Set to 0");
						result=false;
						break;
						
					}
					else
					{
						result=true;
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error: Nothing was entered for Area");
				result=false;
			}
			


			if (result)
			{
				dArea = Double.parseDouble(sArea);
			}
			else
			{
				dArea = 0;
			}

			result=true;
			String sLongestSide = JOptionPane.showInputDialog("Enter Longest Side(m):");
			if (!(sLongestSide==null))
			{
				for (int i = 0 ; i<sLongestSide.length() ; i++)
				{
					if ((!(Character.isDigit(sLongestSide.charAt(i))||sLongestSide.charAt(i)=='.'))||(sLongestSide.charAt(i)=='d')||(sLongestSide.charAt(i)=='f'))
					{
						JOptionPane.showMessageDialog(null, "Error: input of Longest Side was NaN - Set to 0");
						result=false;
						break;
						
					}
					else
					{
						result=true;
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error: Nothing was entered for Longest Side");
				result=false;
			}

			if (result)
			{
				dLongestSide = Double.parseDouble(sLongestSide);
			}
			else
			{
				dLongestSide = 0;
			}
			
			result=true;
			String sWidth = JOptionPane.showInputDialog("Enter Parallel Width(m):");
			if (!(sWidth==null))
			{
				for (int i = 0 ; i<sWidth.length() ; i++)
				{
					if ((!(Character.isDigit(sWidth.charAt(i))||sWidth.charAt(i)=='.'))||(sWidth.charAt(i)=='d')||(sWidth.charAt(i)=='f'))
					{
						JOptionPane.showMessageDialog(null, "Error: input of Width was NaN");
						result=false;
						break;
					}
					else
					{
						result=true;
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error: Nothing was entered for Width.");
				result=false;
			}


			if (result)
			{
				dWidth = Double.parseDouble(sWidth);
			}
			else
			{
				dWidth = 0;
			}

			lblArea.setText("Area: " + dArea + "m\u00B2");

			lblLongestSide.setText("Longest Side: " + dLongestSide + "m");

			lblWidth.setText("Parallel Width:" + dWidth + "m");

		}
	}

	public static void main(String[] args)
	{
		PricingPanel objPricingPanel = new PricingPanel();
		objPricingPanel.setLaf();
		objPricingPanel = new PricingPanel();
		JFrame frmPricingPanel = new JFrame();

		frmPricingPanel.setLayout(new GridLayout(1,1));
		frmPricingPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		objPricingPanel.setLocation(0,16);
		frmPricingPanel.setSize(840, 640);
		frmPricingPanel.add(objPricingPanel);
		frmPricingPanel.setVisible(true);
	}
}