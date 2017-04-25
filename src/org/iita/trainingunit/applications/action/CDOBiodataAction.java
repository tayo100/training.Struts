/**
 * 
 */
package org.iita.trainingunit.applications.action;

import org.iita.trainingunit.applications.service.CDOApplicationService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * @author ken
 *
 */
public class CDOBiodataAction extends BaseBIOAction implements Preparable {
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CDOBiodataAction(CDOApplicationService cdoApplicationService) {
		super(cdoApplicationService);
	}
	
	public String getOldPassword() {
		return oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String execute(){
		return Action.INPUT;
	}
	
	public String update(){
		try{
			if(this.cdoBioData!=null){
				if(this.cdoBioData.getId()!=null){
					this.cdoApplicationService.save(cdoBioData);
					addActionMessage("Personal information updated successfully!");
				}else
					addActionError("No update action performed on personal information!");
			}else
				addActionError("No update action performed on personal information!");
			return Action.SUCCESS;
		}
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
			addActionError("Error occurred updating personal information!");
			return Action.ERROR;
		}
	}
	
	@Validations(requiredStrings = { 
			@RequiredStringValidator(fieldName = "oldPassword", trim = true, message = "Specify your existing password"), 
			@RequiredStringValidator(fieldName = "newPassword", trim = true, message = "Specify your chosen new password") 
	})
	public String updatePassword(){
		//Validate current user object
		if (getUser() == null){
			addActionError("Invalid current User session!");
			return Action.ERROR;
		}
		
		//Validate entered passwords
		if (this.newPassword == null || this.newPassword.length() == 0) {
			addActionError("Please provide the new password.");
			return Action.INPUT;
		}
		if (!this.newPassword.equals(this.confirmPassword)) {
			addActionError("Passwords do not match.");
			return Action.INPUT;
		}
	
		if(cdoApplicationService.confirmExistingPassword(getUser(), this.oldPassword)){
			cdoApplicationService.updatePassword(getUser(), this.newPassword);
			addActionMessage("Your password updated successfully!");
		}else{
			addActionError("Supplied existing password does not match any account in the system!");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}	
}
