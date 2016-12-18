import javax.swing.*;
import java.awt.*;

public class RectangleButton extends JButton //area is xy
{
	private ImageIcon icon;
	public RectangleButton()
	{
		
		super.setOpaque(false);
		super.setContentAreaFilled(false);
		super.setBorderPainted(false);
	}

	public void setIcon(Icon dummy)
	{
		icon = new ImageIcon(((new ImageIcon("assets/rect.png").getImage().getScaledInstance(this.getWidth(), this.getHeight(),java.awt.Image.SCALE_SMOOTH))));
		super.setIcon(icon);
	}


}