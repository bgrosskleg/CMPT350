
import javax.swing.JApplet;
import javax.swing.SwingUtilities;

import controller.GenericController;
import controller.GenericSocketWorker;
import view.GenericView;
import model.GenericModel;


public abstract class GenericMVCClientApplet extends JApplet 
{
	private static final long serialVersionUID = 1L;
	
	protected GenericModel model;
	protected GenericView view;
	protected GenericController controller;
	protected GenericSocketWorker socketWorker;
	protected int port;
	
	public void init()
	{
		try 
        {
            SwingUtilities.invokeAndWait(new Runnable() 
            {
                public void run() 
                {
                	model = createModel();
                	view = createView();
                	controller = createController();
                	socketWorker = createSocketWorker();
                }
            });
            
            this.add(view);
        }
        catch (Exception e) 
        {
            System.err.println("createGUI didn't successfully complete");
            e.printStackTrace();
        } 		
	}
		
	protected abstract GenericModel createModel();
	protected abstract GenericView createView();
	protected abstract GenericController createController();
	protected abstract GenericSocketWorker createSocketWorker();
}
