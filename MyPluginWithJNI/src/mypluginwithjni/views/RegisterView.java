package mypluginwithjni.views;


import mypluginwithjni.actions.SampleAction;

import org.eclipse.swt.widgets.TableColumn;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class RegisterView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "mypluginwithjni.views.RegisterView";

	private Table viewer;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	private TableItem[] items=new TableItem[4];

	private Table reg_table;

	private char content='a';

	/**
	 * The constructor.
	 */
	public RegisterView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
//		GridLayout gridLayout = new GridLayout();
//	    gridLayout.numColumns = 4;
//	    gridLayout.makeColumnsEqualWidth=true;
//	    gridLayout.horizontalSpacing=20;
//	    parent.setLayout(gridLayout);
//	    for (int loopIndex = 0; loopIndex < 28; loopIndex++) {
//	    	Label label = new Label(parent, SWT.SHADOW_NONE);
//	        label.setText("Label " + loopIndex);
//	    }

		
		reg_table=new Table(parent, SWT.VIRTUAL|SWT.BORDER|SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		new TableColumn(reg_table,SWT.NONE).setWidth(40);
		new TableColumn(reg_table,SWT.NONE).setWidth(40);
		
		items[0] = new TableItem(reg_table, SWT.NONE);
		populateItem();
	}
	

public void populateItem() {
    String stringContent = String.valueOf(content);
    items[0].setText(new String[] { "R0:", Integer.toString(SampleAction.getNativeint(3))});
    content++;
    if (content > 'z')
      content = 'a';
		
	}
	
	public void setFocus() {
		//viewer.getControl().setFocus();
	}
	public TableItem[] getItems() {
		return items;
	}

	public void setItems(TableItem[] items) {
		this.items = items;
	}

	
	
}