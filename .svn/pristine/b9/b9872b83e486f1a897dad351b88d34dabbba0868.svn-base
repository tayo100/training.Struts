/**
 * 
 */
package org.iita.trainingunit.service.impl;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.rpc.ServiceException;

import com.liferay.client.soap.portlet.blogs.service.http.BlogsEntryServiceSoap;
import com.liferay.client.soap.portlet.blogs.service.http.BlogsEntryServiceSoapService;
import com.liferay.client.soap.portlet.blogs.service.http.BlogsEntryServiceSoapServiceLocator;
import com.liferay.client.soap.portlet.journal.service.http.JournalArticleServiceSoap;
import com.liferay.client.soap.portlet.journal.service.http.JournalArticleServiceSoapService;
import com.liferay.client.soap.portlet.journal.service.http.JournalArticleServiceSoapServiceLocator;

/**
 * @author aafolayan
 * 
 */
public class LiferayServiceUtil {
	@SuppressWarnings("unused")
	private static String endpointStub;
	private static String authEndpointStub;

	/**
	 * @param endpointStub the endpointStub to set
	 */
	public void setEndpointStub(String endpointStub) {
		LiferayServiceUtil.endpointStub = endpointStub;
	}

	/**
	 * @param authEndpointStub the authEndpointStub to set
	 */
	public void setAuthEndpointStub(String authEndpointStub) {
		LiferayServiceUtil.authEndpointStub = authEndpointStub;
	}

	public static JournalArticleServiceSoap getJournalArticleService() throws MalformedURLException, ServiceException {
		JournalArticleServiceSoapService service = new JournalArticleServiceSoapServiceLocator();
		JournalArticleServiceSoap journalArticleService = service.getPortlet_Journal_JournalArticleService(new URL(LiferayServiceUtil.authEndpointStub
				+ "Portlet_Journal_JournalArticleService"));
		return journalArticleService;
	}

	public static BlogsEntryServiceSoap getBlogsEntryService() throws MalformedURLException, ServiceException {
		BlogsEntryServiceSoapService service = new BlogsEntryServiceSoapServiceLocator();
		BlogsEntryServiceSoap blogsEntryService = service.getPortlet_Blogs_BlogsEntryService(new URL(LiferayServiceUtil.authEndpointStub
				+ "Portlet_Blogs_BlogsEntryService"));
		return blogsEntryService;
	}
}
