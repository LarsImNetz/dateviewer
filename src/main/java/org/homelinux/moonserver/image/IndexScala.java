package org.homelinux.moonserver.image;

import java.io.Serializable;

public class IndexScala implements Serializable {

	private int laufzeit = 12;
	private int zeitraum = 12 * 5;

	public IndexScala() {
	}

	public Integer getLaufzeit() {
		return laufzeit;
	}

	public void setLaufzeit(Integer laufzeit) {
		if (laufzeit == null) {
			this.laufzeit = 0;
		} else {
			this.laufzeit = laufzeit;
		}
	}

	public int getZeitraum() {
		return zeitraum;
	}

	public void setZeitraum(Integer zeitraum) {
		if (zeitraum == null) {
			this.zeitraum = 0;
		} else {
			this.zeitraum = zeitraum;
		}
	}

}
