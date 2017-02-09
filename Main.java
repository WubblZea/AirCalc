
public class Main
{
	public static void main(String[] args)
	{
		Login objLogin = new Login();
		while(!objLogin.hasReturned()){}
		BuilderFrame objBuilderFrame = new BuilderFrame();
		objBuilderFrame.setLaf();
		objBuilderFrame = new BuilderFrame(objLogin.toString());
		objBuilderFrame.startGUI();
		objLogin = null;
	}
}