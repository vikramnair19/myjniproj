package mypluginwithjni.actions;

import mypluginwithjni.views.RegisterView;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.IWorkbenchGraphicConstants;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class SampleAction implements IWorkbenchWindowActionDelegate {
	
	private int [] countval;
	public static native String getNativeMessage(); 
	public static native int getNativeint(int n); 
	
	
    static {
        System.loadLibrary("sampleaction");
    }
	
	
	private IWorkbenchWindow window;
	private String view_instance;
	private RegisterView myview;
	/**
	 * The constructor.
	 */
	public SampleAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		String message;
		int i=0;
		
//		try {
//			message = getNativeMessage();
//		} catch (Throwable e) {
//			message = e.toString();
//		}
//		MessageDialog.openInformation(
//			window.getShell(),
//			"MyProjectWithJNI Plug-in",
//			message);
		i=getNativeint(i);
		System.out.println(i);
		try {
			myview = (RegisterView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("mypluginwithjni.views.RegisterView");
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		myview.populateItem();
		
		
		
		
		
		
	}
//	public void run(IAction action) {
//		MessageDialog.openInformation(
//			window.getShell(),
//			"MyPluginWithJNI",
//			"Hello, Eclipse world");
//	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}