
import javax.swing.JApplet;
import javax.swing.SwingUtilities;

import controller.GenericMVCController;
import controller.GenericMVCSocketWorker;
import view.GenericMVCView;
import model.GenericMVCModel;


public abstract class GenericMVCClientApplet extends JApplet 
{
	private static final long serialVersionUID = 1L;
	
	protected GenericMVCModel model;
	protected GenericMVCView view;
	protected GenericMVCController controller;
	protected GenericMVCSocketWorker socketWorker;
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
                	(new Thread(socketWorker)).start();
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
		
	protected abstract GenericMVCModel createModel();
	protected abstract GenericMVCView createView();
	protected abstract GenericMVCController createController();
	protected abstract GenericMVCSocketWorker createSocketWorker();
}
