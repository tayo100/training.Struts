/**
 * 
 */
package org.iita.trainingunit.service.impl;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.service.TemplatingException;
import org.iita.service.TemplatingService;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.LiferayService;
import org.iita.trainingunit.service.TrainingUnitDataException;

import com.liferay.client.soap.portal.service.ServiceContext;
import com.liferay.client.soap.portlet.journal.model.JournalArticleSoap;
import com.liferay.client.soap.portlet.journal.service.http.JournalArticleServiceSoap;

/**
 * @author aafolayan
 * 
 */
public class LiferayServiceImpl implements LiferayService {

	/** The LOG. */
	private Log LOG = LogFactory.getLog(LiferayService.class);
	/** Templating service */
	private TemplatingService templatingService;
	/** Utility class for obtaining liferay services */
	private LiferayServiceUtil liferayServiceUtil;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.trainingunit.service.LiferayService#addArticle(org.iita.trainingunit.model.TrainingProgram)
	 */

	@SuppressWarnings("static-access")
	@Override
	public void addArticle(TrainingProgram program) throws TrainingUnitDataException {

		Map<String, Object> data = new Hashtable<String, Object>();
		data.put("program", program);
		try {
			String content = this.templatingService.fillTemplate("programliferay", data);
			Calendar calendar = GregorianCalendar.getInstance();
			ServiceContext context = new ServiceContext();
			context.setScopeGroupId(10319);
			JournalArticleServiceSoap journalArticleService = liferayServiceUtil.getJournalArticleService();
			JournalArticleSoap article = journalArticleService.addArticle(10319, "76532", true, program.getTitle(), program.getDescription(), content,
					"general", null, null, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.YEAR), calendar
							.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), -1, -1, -1, -1, -1, true, -1, -1, -1, -1, -1, true, true, null, context);

			journalArticleService.approveArticle(10319, article.getArticleId(), article.getVersion(), null, context);

			System.out.println(article.getTitle() + " article successfully posted to liferay!");
		} catch (RemoteException e) {
			LOG.error(e.getMessage());
			throw new TrainingUnitDataException("Could not post to liferay: " + e.getMessage(), e);
		} catch (TemplatingException e) {
			LOG.error(e.getMessage());
			throw new TrainingUnitDataException("Could not post to liferay: " + e.getMessage(), e);
		} catch (MalformedURLException e) {
			LOG.error(e.getMessage());
			throw new TrainingUnitDataException("Could not post to liferay: " + e.getMessage(), e);
		} catch (ServiceException e) {
			LOG.error(e.getMessage());
			throw new TrainingUnitDataException("Could not post to liferay: " + e.getMessage(), e);
		}
	}

	/**
	 * @param templatingService the templatingService to set
	 */
	public void setTemplatingService(TemplatingService templatingService) {
		this.templatingService = templatingService;
	}

	/**
	 * @param liferayServiceUtil the liferayServiceUtil to set
	 */
	public void setLiferayServiceUtil(LiferayServiceUtil liferayServiceUtil) {
		this.liferayServiceUtil = liferayServiceUtil;
	}

}
