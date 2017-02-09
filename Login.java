import java.io.*;
import javax.swing.JOptionPane;

public class Login
{
	private String sLogin = "invalid";
	private boolean bReturn = false;

	public Login()
	{
		if(!(new File("db/Users.txt").exists()))
		{
			if(JOptionPane.showConfirmDialog(null, "No User Exists.\nPerform first time setup?", "First Time Launcher", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				System.out.println("Setup ignored. Will return admin user.");
				sLogin = "admin";
				bReturn = true;
				
			}
			else
			{
				bReturn = true;
			}
		}
		else
		{
			bReturn = true;
		}
	}

	public String toString()
	{

		return sLogin;
	}
	public boolean hasReturned()
	{
		return bReturn;
	}
}