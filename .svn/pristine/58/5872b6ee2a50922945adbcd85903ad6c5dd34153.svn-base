/**
 * training.Struts Feb 4, 2010
 */
package org.iita.crm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Person;
import org.iita.crm.service.CoreCRMService;
import org.iita.security.model.User;
import org.iita.service.SearchException;
import org.iita.trainingunit.announcements.model.TrainingProposal;

import com.google.gson.Gson;
import com.googlecode.jsonplugin.annotations.SMDMethod;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author mobreza/koraegbunam
 * 
 */
public class PublicAjaxAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CoreCRMService service;
	private String title;
	private LinkedHashMap<String, String> jsonData;

	/**
	 * @param personService
	 * @param coreCrmService 
	 * 
	 */
	public PublicAjaxAction(CoreCRMService coreCrmService) {
		this.service = coreCrmService;
	}
	
	/**
	 * @return the values
	 * @throws IOException 
	 */
	@SMDMethod
	@SuppressWarnings({"unchecked"})
	public String relatedProposals() throws SearchException, IOException {
		ArrayList<TrainingProposal> tps = (ArrayList<TrainingProposal>)  this.service.lookupTrainingProposal(title, 10);
		
		ArrayList listTP = new ArrayList(); 
		System.out.println("TESTING THE OUTPUT: " + tps);
		System.out.println("LOOKING FOR: " + title);
		if(tps!=null){
			for(TrainingProposal req : tps){
					//start = dfto.parse(req.getStartDate().toString());
					//end = dfto.parse(req.getEndDate().toString());
					//st = dfto.format(start);
					//et = dfto.format(end);
					jsonData = new LinkedHashMap<String, String>();
					
					jsonData.put("id",req.getId().toString());
					jsonData.put("title", req.getTitle());
					jsonData.put("status", req.getStatus().toString());
					//jsonData.put("end", et);
					//jsonData.put("url", "trainingproposal.jspx?id="+req.getId());
					//jsonData.put("description", st + " - " + et);
					
					if(req.getId().intValue()%2==0)
						jsonData.put("classname", "even");
					else{
						boolean prime = isPrime(req.getId().intValue());
						//id=req.getId().intValue();
						if(prime==false)
							jsonData.put("classname", "odd");
						else
							jsonData.put("classname", "prime");
					}
					listTP.add(jsonData);
			}
		}else{
			listTP.add(null);
		}
		Gson g = new Gson();
		String json = g.toJson(listTP);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset = utf-8");
		response.setHeader("Cache-Control", "no-cache");
	
		PrintWriter pw = response.getWriter();
		pw.print (json);
		pw.flush ();
		pw.close ();
		return Action.SUCCESS;
	}
	
	/*
     * Prime number is not divisible by any number other than 1 and itself
     * @return true if number is prime
     */
	public static boolean isPrime(int number){
        for(int i=2; i<number; i++){
           if(number%i == 0){
               return false; //number is divisible so its not prime
           }
        }
        return true; //number is prime now
    }
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String execute() {
		return Action.SUCCESS;
	}

	@SMDMethod
	public Person getPerson(Long id) {
		return this.service.loadPerson(id);
	}

	@SMDMethod
	public List<Person> autocompletePerson(String text) throws SearchException {
		return this.service.autocompletePerson(text, 10);
	}

	@SMDMethod
	public List<User> autocompleteUser(String text) throws SearchException {
		return this.service.autocompleteUser(text, 10);
	}
	
	@SMDMethod
	public List<Organization> autocompleteOrganization(String text) throws SearchException {
		return this.service.autocompleteOrganization(text, 10);
	}
	

	@SMDMethod
	public List<String> autocompleteTag(String text) {
		return this.service.autocompleteTag(text, 10);
	}
}
