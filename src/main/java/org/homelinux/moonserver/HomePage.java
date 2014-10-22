package org.homelinux.moonserver;

import java.util.Date;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends WebPage {

	private final static Logger logger = LoggerFactory.getLogger(HomePage.class);

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("serial")
	public HomePage(final PageParameters parameters) {
		super(parameters);

		logger.debug("HomePage of DateViewer");

		IModel<String> textToView = new LoadableDetachableModel<String>() {

			@Override
			protected String load() {
				final String textToString = "Heute ist " + new Date();
				logger.debug("Zu zeigender Text: " + textToString);
				return textToString;
			}

		};

		final Label label = new Label("label", textToView);
		label.setOutputMarkupId(true);
		// label.add(new AjaxSelfUpdatingTimerBehavior(Duration.ONE_SECOND));
		label.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(5)));
		add(label);

		add(new Link<Void>("doNothing") {

			@Override
			public void onClick() {
				// Hint: Es ist zwar leer hier, aber es wird ein Page reload ausgelöst.
				logger.debug("Button pressed");
			}
		});
		
		add(new Label("label2", "Hello World."));
		
		add(new MeinPanel("meinpanel", Model.of("Mein Label.")));
	}
}
