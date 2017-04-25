/**
 * 
 */
package org.iita.trainingunit.iya.action;

import org.iita.trainingunit.iya.model.Language;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
/**
 * @author ken
 *
 */
public class RadioButtonAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4658505947475824319L;
	private List<String> genders;
	private List<String> languages ;
	
	private String yourGender;
	private String yourAnswer;
	private String yourLanguage;
	
	private static final String MALE = "male";
	private static final String FEMALE = "female";
	private static final String UNKNOWN = "unknown";
	
	public RadioButtonAction(){
		
		genders = new ArrayList<String>();
		genders.add(MALE);
		genders.add(FEMALE);
		genders.add(UNKNOWN);
		
		languages = new ArrayList<String>();
		languages.add( new String ("English") );
		languages.add( new String ("France") );
		languages.add( new String ( "Chinese") );
		languages.add( new String ("German") );
		
	}
	
	//return default gender value
	public String getDefaultGenderValue(){
		return UNKNOWN;
	}

	//return default language value
	public String getDefaultLanguageValue(){
		return "CN_ZH";
	}
	
	public String execute() {
		return SUCCESS;
	}
	public String display() {
		return NONE;
	}

	/**
	 * @param yourGender the yourGender to set
	 */
	public void setYourGender(String yourGender) {
		this.yourGender = yourGender;
	}

	/**
	 * @return the yourGender
	 */
	public String getYourGender() {
		return yourGender;
	}

	/**
	 * @param yourAnswer the yourAnswer to set
	 */
	public void setYourAnswer(String yourAnswer) {
		this.yourAnswer = yourAnswer;
	}

	/**
	 * @return the yourAnswer
	 */
	public String getYourAnswer() {
		return yourAnswer;
	}

	/**
	 * @param yourLanguage the yourLanguage to set
	 */
	public void setYourLanguage(String yourLanguage) {
		this.yourLanguage = yourLanguage;
	}

	/**
	 * @return the yourLanguage
	 */
	public String getYourLanguage() {
		return yourLanguage;
	}

	/**
	 * @return the genders
	 */
	public List<String> getGenders() {
		return genders;
	}

	/**
	 * @return the languages
	 */
	public List<String> getLanguages() {
		return languages;
	}

//getter ad setter methods
}
