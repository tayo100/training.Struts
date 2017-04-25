/**
 * 
 */
package org.iita.trainingunit.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Bean managing selected entities
 * 
 * @author koraegbunam
 * 
 */
public class Selection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6017681691644644620L;

	private String name = null;
	private String owner = null;
	private Date dateCreated = new Date();
	private List<Long> selectedTrainees = new ArrayList<Long>();
	private List<Long> selectedTrainingPrograms = new ArrayList<Long>();
	private boolean canDelete = true;

	/**
	 * @return the canDelete
	 */
	public boolean isCanDelete() {
		return this.canDelete;
	}

	/**
	 * @param canDelete the canDelete to set
	 */
	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	public Selection() {

	}

	/**
	 * @return the selectedTrainess
	 */
	public List<Long> getSelectedTrainees() {
		return this.selectedTrainees;
	}
	
	/**
	 * @return the selectedTrainingPrograms
	 */
	public List<Long> getSelectedTrainingPrograms() {
		return this.selectedTrainingPrograms;
	}

	/**
	 * @param selectedTrainees the selectedTrainees to set
	 */
	public void setSelectedTrainees(List<Long> selectedTrainees) {
		this.selectedTrainees = selectedTrainees;
	}
	
	/**
	 * @param selectedTrainingPrograms the selectedTrainingPrograms to set
	 */
	public void setSelectedTrainingPrograms(List<Long> selectedTrainingPrograms) {
		this.selectedTrainingPrograms = selectedTrainingPrograms;
	}

	public void clearTraineeSelection() {
		this.selectedTrainees = new ArrayList<Long>();
	}
	
	public void clearTrainingProgramSelection() {
		this.selectedTrainingPrograms = new ArrayList<Long>();
	}

	/**
	 * Add trainee identifier to selection if not present.
	 * 
	 * @param traineeId
	 */
	public void addTraineeSelection(long traineeId) {
		if (!this.selectedTrainees.contains(new Long(traineeId)))
			this.selectedTrainees.add(traineeId);
	}

	/**
	 * Add trainee identifier to selection if not present.
	 * 
	 * @param traineeId
	 */
	public void addTraineeSelection(List<Trainee> selections) {
		System.out.println("addSelection +" + selections.size());

		for (Trainee l : selections) {
			if (!this.selectedTrainees.contains(new Long(l.getId())))
				this.selectedTrainees.add(l.getId());
		}
	}

	/**
	 * Remove trainee identifier from selection. No change if specified entity not in the list.
	 * 
	 * @param traineeId
	 */
	public void removeTraineeSelection(long traineeId) {
		if (this.selectedTrainees.contains(new Long(traineeId)))
			this.selectedTrainees.remove(new Long(traineeId));
	}
	
	
	/**
	 * Add trainingProgram identifier to selection if not present.
	 * 
	 * @param trainingProgramId
	 */
	public void addTrainingProgramSelection(long trainingProgramId) {
		if (!this.selectedTrainingPrograms.contains(new Long(trainingProgramId)))
			this.selectedTrainingPrograms.add(trainingProgramId);
	}

	/**
	 * Add trainingProgram identifier to selection if not present.
	 * 
	 * @param trainingProgramId
	 */
	public void addTrainingProgramSelection(List<TrainingProgram> selections) {
		System.out.println("addSelection +" + selections.size());

		for (TrainingProgram l : selections) {
			if (!this.selectedTrainingPrograms.contains(new Long(l.getId())))
				this.selectedTrainingPrograms.add(l.getId());
		}
	}

	/**
	 * Remove entity identifier from selection. No change if specified entity not in the list.
	 * 
	 * @param entityId
	 */
	public void removeTrainingProgramSelection(long entityId) {
		if (this.selectedTrainingPrograms.contains(new Long(entityId)))
			this.selectedTrainingPrograms.remove(new Long(entityId));
	}

	/**
	 * Number of selected items.
	 * 
	 * @return number of items in selection
	 */
	public int getTraineeSize() {
		return this.selectedTrainees.size();
	}
	
	/**
	 * Number of selected items.
	 * 
	 * @return number of items in selection
	 */
	public int getTrainingProgramSize() {
		return this.selectedTrainingPrograms.size();
	}

	/**
	 * Check if selection list contains the given entity identifier.
	 * 
	 * @param traineeId trainee identifier
	 * @return <code>true</code> if the selection contains the given identifier, <code>false</code> otherwise
	 */
	public boolean traineeContains(Long traineeId) {
		return this.selectedTrainees.contains(traineeId);
	}
	
	/**
	 * Check if selection list contains the given entity identifier.
	 * 
	 * @param trainingProgramId trainingProgram identifier
	 * @return <code>true</code> if the selection contains the given identifier, <code>false</code> otherwise
	 */
	public boolean trainingProgramContains(Long entityId) {
		return this.selectedTrainingPrograms.contains(entityId);
	}

	/**
	 * Get selection list name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return this.dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Replace current selection list with provided entity list
	 * 
	 * @param Selections Selections to be placed on selection list
	 */
	public void replaceTraineeSelection(List<Trainee> selections) {
		this.clearTraineeSelection();
		this.addTraineeSelection(selections);
	}
	
	/**
	 * Replace current selection list with provided entity list
	 * 
	 * @param TrainingProgram Selections to be placed on selection list
	 */
	public void replaceTrainingProgramSelection(List<TrainingProgram> selections) {
		this.clearTrainingProgramSelection();
		this.addTrainingProgramSelection(selections);
	}
}
