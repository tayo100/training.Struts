/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.service.CRMException;
import org.iita.crm.service.PartnerService;
import org.iita.struts.BaseAction;

import com.opensymphony.xwork2.Action;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class AddPartnerAction extends BaseAction {
	private String title;
	private Partner partner;
	private PartnerService service;

	/**
	 * 
	 */
	public AddPartnerAction(PartnerService partnerService) {
		this.service = partnerService;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the partner
	 */
	public Partner getPartner() {
		return this.partner;
	}

	/**
	 * @throws TrainingUnitDataException 
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		try {
			this.partner = this.service.registerPartner(this.title);
		} catch (javax.persistence.PersistenceException e) {
			addActionError("Partner with the same name already exists.");
			return Action.ERROR;
		} catch (CRMException e) {
			addActionError("Partner with the same name already exists.");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
}
