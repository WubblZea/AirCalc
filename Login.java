import java.io.*;
import java.util.Arrays;
import java.security.MessageDigest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.nio.charset.StandardCharsets;

public class Login
{
	private String sLogin = "invalid";
	private boolean bReturn = false;

	public Login()
	{
		if(!(new File("db/User.txt").exists()))
		{
			if(JOptionPane.showConfirmDialog(null, "No User Exists.\nPerform first time setup? \n Warning: This means that the database will be cleared. If you do not wish for this to occur, please get support", "First Time Launcher", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				clearDir(new File("db"));
				setPin();
				sLogin = "rw";
				bReturn = true;
				
			}
			else
			{
				System.exit(0);
				bReturn = true;
			}
		}
		else
		{
			if(checkPassword())
			{
				sLogin = "rw";
				bReturn = true;
			}
			else
			{
				bReturn = true;
			}
		}
	}

	private void clearDir(File dir) 
	{
		if(dir.exists())
		{
			for(File file: dir.listFiles()) 
			{
				if(file.isDirectory()) 
				{
					clearDir(file);
				}
			file.delete();
			}
		}
		else if(dir.getPath().equals("db"))
		{
			System.out.println("No database directory found. One will now be generated");
			if(dir.mkdir())
			{
				System.out.println("Success");
			}
			else
			{
				System.out.println("Error making directory - are you trying to run the system from a network drive?");
			}
		}
	}

	private void setPin()
	{
		String newPin;
		byte[] bytesNewPin = new byte[127];
		MessageDigest md;
		String hashedNewPin = new String();
		boolean bContinue = true;
		try
		{
			newPin = showPasswordDialog("Enter new pin/password:", "First time setup");
			if (newPin==null)
			{
				JOptionPane.showMessageDialog(null, "User clicked cancel. Program will now exit");
				System.exit(0);
			}
			bytesNewPin = newPin.getBytes(StandardCharsets.US_ASCII);
			md = MessageDigest.getInstance("MD5");
			hashedNewPin = (new HexBinaryAdapter()).marshal(md.digest(bytesNewPin));

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Warning: Files generated in this session will be lost on the next launch. Failed to hash pin.");
			e.printStackTrace();
			bContinue = false;
		}
		try
		{
			if (bContinue)
			{
				//(new File("db/User.txt")).delete();
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("db/User.txt"));
				bufferedWriter.write(hashedNewPin);
				bufferedWriter.close();
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Warning: Files generated in this session will be lost on the next launch. Failed to write hash to file.");
			bContinue = false;
		}
	}

	private boolean checkPassword()
	{
		byte[] hashedPin;
		try
		{
			BufferedReader bufferedReader = new BufferedReader(new FileReader("db/User.txt"));
			String sHashedPin = bufferedReader.readLine();
			hashedPin = (new HexBinaryAdapter()).unmarshal(sHashedPin);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "An error occured reading the stored passkey.");
			return false;
		}
		try
		{
			String pin = showPasswordDialog("Enter user pin/password:", "Login");
			if (pin==null)
			{
				JOptionPane.showMessageDialog(null, "User clicked cancel. Program will now exit");
				System.exit(0);
			}
			byte[] bytesPin = pin.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (Arrays.equals((md.digest(bytesPin)), hashedPin))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "An error occurred comparing pin with file");
			return false;
		}
	}

	private String showPasswordDialog(String text, String title)
	{
		JPanel panel = new JPanel();
		JLabel label = new JLabel(text);
		JPasswordField pass = new JPasswordField(10);
		panel.add(label);
		panel.add(pass);
		String[] options = new String[]{"OK", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, panel, title, JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, pass);
		if(option == 0)
		{
		    char[] password = pass.getPassword();
		    return new String(password);
		}
		return null;
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