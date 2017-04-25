/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Tag;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 *
 */
@SuppressWarnings("serial")
public class TagAction extends BaseAction {
	protected Long id;
	protected CoreCRMService crmService;
	protected Tag tag;
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @param crmService 
	 * 
	 */
	public TagAction(CoreCRMService crmService) {
		this.crmService=crmService;
	}
	
	/**
	 * @return the tag
	 */
	public Tag getTag() {
		LOG.error("Returning tag " + this.tag + " of type " + this.tag.getClass());
		return this.tag;
	}
	
	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		
	}
	
	public String update() {
		this.crmService.update(this.tag);
		return Action.SUCCESS;
	}
	
	public String remove() {
		this.crmService.remove(this.tag);
		return Action.SUCCESS;
	}
}
