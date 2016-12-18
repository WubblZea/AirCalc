import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class EllipseButton extends JButton //area is xy
{
	private ImageIcon icon;
	public EllipseButton()
	{
		
		super.setOpaque(false);
		super.setContentAreaFilled(false);
		super.setBorderPainted(false);
	}

	@Override
	public void setIcon(Icon dummy)
	{

		icon = new ImageIcon(new ImageIcon("assets/crl.png").getImage().getScaledInstance(this.getWidth(), this.getHeight(),java.awt.Image.SCALE_SMOOTH));
		super.setIcon(icon);
	}


}