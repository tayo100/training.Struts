package org.iita.appmail.model;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.util.SharedByteArrayInputStream;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.iita.entity.VersionedEntity;

/**
 * Mail messages can be stored in DB
 * 
 * @author mobreza
 */
@Entity
@MappedSuperclass
public class MailMessage extends VersionedEntity {
	private static final long serialVersionUID = -6376137988252738420L;
	private String messageId;
	private byte[] data;
	private MimeMessage message;
	private MailMessage inReplyTo;
	private List<MailMessage> replies;

	@Column(length = 400, columnDefinition = "varchar(400)")
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Lob
	public byte[] getData() {
		return data;
	}

	/**
	 * Get {@link MimeMessage} JavaMail object
	 * 
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	@Transient
	public MimeMessage getMessage() throws MessagingException, IOException {
		synchronized (this) {
			if (this.message == null) {
				SharedByteArrayInputStream bis = new SharedByteArrayInputStream(this.data);
				this.message = new MimeMessage((Session) null, bis);
				bis.close();
			}
		}
		return this.message;
	}

	/**
     * @param originalMessage
     */
    public void setInReplyTo(MailMessage originalMessage) {
	    this.inReplyTo=originalMessage;
    }
    
    /**
     * @return the inReplyTo
     */
    @ManyToOne(cascade={}, optional=true)
    public MailMessage getInReplyTo() {
	    return this.inReplyTo;
    }

    /**
     * 
     * @return
     */
    @OneToMany(cascade={}, mappedBy="inReplyTo")
    public List<MailMessage> getReplies() {
    	return this.replies;
    }
    
    /**
     * @param replies the replies to set
     */
    public void setReplies(List<MailMessage> replies) {
	    this.replies = replies;
    }
}
