package org.homelinux.moonserver;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class MeinPanel extends Panel {

	
	public MeinPanel(String id, IModel<String> aString) {
	    super(id, aString);
	
	    add(new Label("label", aString));
    }
	
}
