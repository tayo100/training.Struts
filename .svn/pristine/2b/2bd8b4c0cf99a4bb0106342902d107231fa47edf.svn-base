package org.iita.trainingunit.announcements.service;

import java.util.Date;
import java.util.List;

import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.model.Announcement.STATUS;
import org.iita.util.PagedResult;

public interface AnnouncementService {
	void save(Announcement announcement) throws Exception;

	void delete(Announcement announcement);

	PagedResult<Announcement> list(int startAt, int maxResults);

	Announcement find(Long id);

	List<Announcement> list(String type);
	
	List<Announcement> listAll();

	int totalApplicants(Announcement announcement);
	
	PagedResult<Announcement> search(String details, Date fromDate, Date toDate, int startAt, int maxResults);
	
	List<Announcement> search(String details, Date fromDate, Date toDate);

	Announcement createNew(User user) throws AnnouncementException;

	Announcement lookUp(String title, STATUS status);
}