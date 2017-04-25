package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;

/**
 * Website contact
 */
@Entity
@Indexed
public class WebsiteContact extends Contact {

	/** The Constant URL. */
	private static final String URL = "URL: ";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7067980057986149921L;

	/** The url. */
	private String url;

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	@Column(length = 200, nullable = false)
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url the new url
	 */
	public void setUrl(String url) {
		if (url == null || url.length() == 0)
			url = null;
		if (url != null && !url.contains("://"))
			url = "http://" + url;
		this.url = url;
	}

	/**
	 * To string.
	 * 
	 * @return the string
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return URL + this.url;
	}
}
