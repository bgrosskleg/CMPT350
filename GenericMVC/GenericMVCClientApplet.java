
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
                	
                	socketWorker = createSocketWorker(model);
                	
                	view = createView(model, socketWorker.getConnectionNumber());
                	
                	controller = createController(model, view);
                	
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
	protected abstract GenericMVCView createView(GenericMVCModel model, int connectionNumber);
	protected abstract GenericMVCController createController(GenericMVCModel model, GenericMVCView view);
	protected abstract GenericMVCSocketWorker createSocketWorker(GenericMVCModel model);
}
