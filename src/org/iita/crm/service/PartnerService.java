/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.service;

import java.util.List;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerCategory;
import org.iita.crm.model.PartnerClassification;
import org.iita.crm.model.PartnerCoreBusiness;
import org.iita.crm.model.PartnerCoreBusinessCategory;
import org.iita.crm.model.PartnerIITAHub;
import org.iita.crm.model.PartnerMandateCrop;
import org.iita.crm.model.PartnerPersonContact;
import org.iita.crm.model.PartnerScale;
import org.iita.crm.model.PartnerSector;
import org.iita.crm.model.PartnerSubsector;
import org.iita.service.SearchException;
import org.iita.trainingunit.service.TrainingUnitDataException;
import org.iita.util.PagedResult;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * @author KOraegbunam
 * 
 */
public interface PartnerService {
	Partner loadPartner(Long id);

	void update(Partner partner);

	void update(PartnerPersonContact partnerContact);

	/**
	 * @param affiliation
	 */
	void remove(PartnerPersonContact partnerContact);
	
	/**
	 * @param id
	 * @return
	 */
	PartnerPersonContact loadPartnerContact(Long id);
	
	/**
	 * @param profile
	 * @throws DataIntegrityViolationException 
	 */
	void delete(Partner partner) throws org.springframework.dao.DataIntegrityViolationException;
	
	/**
	 * @param title
	 * @return
	 * @throws TrainingUnitDataException 
	 */
	Partner registerPartner(String title) throws CRMException;
	

	/**
	 * @param text
	 * @param i
	 * @return
	 * @throws SearchException 
	 */
	List<Partner> autocompletePartner(String text, int maxRecords) throws SearchException;


	/**
	 * Gets the similar partners.
	 * 
	 * @param entity the entity
	 * @param i the i
	 * 
	 * @return the similar partners
	 */
	List<Partner> getSimilarPartners(Partner entity, int i);
	

	/**
	 * @param partner
	 * @param startAt
	 * @param maxResults
	 * @return
	 */
	PagedResult<PartnerPersonContact> listPartnerContacts(Partner partner, int startAt, int maxResults);
	
	List<PartnerClassification> loadClassifications(Partner partner);
	PartnerClassification loadClassification(Long id);
	void updateClassification(PartnerClassification classification);
	void removeClassification(PartnerClassification classification);
	
	List<PartnerSector> loadSectors(Partner partner);
	PartnerSector loadSector(Long id);
	void updateSector(PartnerSector sector);
	void removeSector(PartnerSector sector);
	
	List<PartnerSubsector> loadSubsectors(Partner partner);
	PartnerSubsector loadSubsector(Long id);
	void updateSubsector(PartnerSubsector sector);
	void removeSubsector(PartnerSubsector sector);
	
	List<PartnerCategory> loadCategories(Partner partner);
	PartnerCategory loadCategory(Long id);
	void updateCategory(PartnerCategory category);
	void removeCategory(PartnerCategory category);
	
	List<PartnerScale> loadScales(Partner partner);
	PartnerScale loadScale(Long id);
	void updateScale(PartnerScale sector);
	void removeScale(PartnerScale sector);
	
	List<PartnerCoreBusiness> loadCoreBusinesses(Partner partner);
	PartnerCoreBusiness loadCoreBusiness(Long id);
	void updateCoreBusiness(PartnerCoreBusiness coreBusiness);
	void removeCoreBusiness(PartnerCoreBusiness coreBusiness);
	
	List<PartnerCoreBusinessCategory> loadCoreBusinessCategories(Partner partner);
	PartnerCoreBusinessCategory loadCoreBusinessCategory(Long id);
	void updateCoreBusinessCategory(PartnerCoreBusinessCategory coreBusinessCategory);
	void removeCoreBusinessCategory(PartnerCoreBusinessCategory coreBusinessCategory);
	
	List<PartnerMandateCrop> loadMandateCrops(Partner partner);
	PartnerMandateCrop loadMandateCrop(Long id);
	void updateMandateCrop(PartnerMandateCrop mandateCrop);
	void removeMandateCrop(PartnerMandateCrop mandateCrop);
	
	List<PartnerIITAHub> loadIitahubs(Partner partner);
	
	PartnerIITAHub loadIitahub(Long id);
	
	void updateIitahub(PartnerIITAHub iitahub);

	void removeIitahub(PartnerIITAHub iitahub);
}
