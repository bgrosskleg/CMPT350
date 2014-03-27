import model.GenericCardGamePlayer;
/**
 * contains:
 * 
 *  protected methods:
 *  GenericCardGameClientApplet()
 *
 */
public abstract class GenericCardGameClientApplet extends GenericMVCClientApplet
{
	private static final long serialVersionUID = 1L;
	
	GenericCardGamePlayer me;
	
	protected GenericCardGameClientApplet()
	{
		super();
	}
}
