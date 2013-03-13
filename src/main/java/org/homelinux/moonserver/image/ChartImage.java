package org.homelinux.moonserver.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.apache.wicket.markup.html.image.NonCachingImage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.util.time.Duration;

public class ChartImage extends NonCachingImage {

	public ChartImage(String id, IModel<IndexScala> scala) {
		super(id, scala);
		setOutputMarkupId(true);
	}

	@Override
	protected IResource getImageResource() {

		DynamicImageResource dynamicImageResource = new DynamicImageResource() {

			@Override
			protected byte[] getImageData(Attributes attributes) {
				IndexScala scala = (IndexScala) getDefaultModelObject();
				// IndexChart chart = new BixChartFactory().render(scala.getLaufzeit()*12, scala.getZeitraum());
				// return toImageData(chart.asBufferedImage());

				int w = 200;
				int h = 90;
				BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
				Graphics g = img.getGraphics();
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, w, h);
				g.setColor(Color.WHITE);
				g.fillRect(1, 1, w - 2, h - 2);
				g.setColor(Color.RED);
				g.drawLine(1, 10, w - 2, h - 10);
				return this.toImageData(img);
			}

			@Override
			protected void setResponseHeaders(final ResourceResponse response, final Attributes attributes) {
				//				 if (this.isCacheable()) {
				//           super.setResponseHeaders(response, attributes);
				//       }
				//				else {
				// response.setHeader("Pragma", "no-cache");
				// response.setHeader("Cache-Control", "no-cache");
				//	response.setDateHeader("Expires", 0);
				response.setCacheDuration(Duration.NONE);
				//       }
			}

		};

		// dynamicImageResource.setCacheable(false);
		return dynamicImageResource;
	}

}
