package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;

/**
 * @author tayo
 *
 */
@Entity
@Indexed
public class RssContact extends Contact {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5326404661759319285L;
	
	private String rss;

	private String rssComment;

	/**
	 * @return the rss
	 */
	@Column(length = 255)
	public String getRss() {
		return rss;
	}

	/**
	 * @param rss the rss to set
	 */
	public void setRss(String rss) {
		this.rss = rss;
	}

	/**
	 * @return the rssComment
	 */
	@Column(length = 255)
	public String getRssComment() {
		return rssComment;
	}

	/**
	 * @param rssComment the rssComment to set
	 */
	public void setRssComment(String rssComment) {
		this.rssComment = rssComment;
	} 
}
