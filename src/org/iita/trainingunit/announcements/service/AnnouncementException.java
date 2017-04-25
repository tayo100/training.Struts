package org.iita.trainingunit.announcements.service;

public class AnnouncementException extends Exception {
	private static final long serialVersionUID = 8902764000403799665L;
	
	public AnnouncementException(String msg) {
		super(msg);
	}
	
	public AnnouncementException(String msg, Throwable e) {
		super(msg, e);
	}
}