/**
 * promisCRM.Struts Apr 7, 2010
 */
package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.iita.entity.VersionedEntity;

/**
 * A Document entity contains meta information on files uploaded to CRM system. The file is identified by its filePath, which should be unique throughout the
 * system (no two descriptions should share the same filePath!).
 * 
 * @author mobreza
 */
@Entity
public class Document extends VersionedEntity {
	private static final long serialVersionUID = -989979072429776281L;
	private String title;
	private String filePath;
	private String file;
	private String type;
	private boolean allowPublic = true;
	private String authors;
	private String pubYear;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the filePath
	 */
	@Column(nullable = false, length=500, columnDefinition="varchar(500)")
	public String getFilePath() {
		return this.filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Used for indexing, should be set by uploading service
	 * 
	 * @return
	 */
	@Column(length=500, columnDefinition="varchar(500)")
	public String getFile() {
		return this.file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @return the type
	 */
	@Column(length = 200, nullable = true)
	public String getType() {
		return this.type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public void setAllowPublic(boolean allowPublic) {
		this.allowPublic = allowPublic;
	}

	public boolean isAllowPublic() {
		return allowPublic;
	}
	
	/**
	 * @return the authors
	 */
	@Column(length = 255, nullable = true)
	public String getAuthors() {
		return this.authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	/**
	 * @return the pubYear
	 */
	@Column(length = 255, nullable = true)
	public String getPubYear() {
		return this.pubYear;
	}

	/**
	 * @param pubYear the pubYear to set
	 */
	public void setPubYear(String pubYear) {
		this.pubYear = pubYear;
	}
	
}
