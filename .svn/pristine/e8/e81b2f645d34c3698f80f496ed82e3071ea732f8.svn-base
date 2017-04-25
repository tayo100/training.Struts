package org.iita.trainingunit.service;

import java.util.List;

import org.iita.trainingunit.model.Selection;

public interface SelectionService {
	
	/**
	 * Get references to selection lists
	 * 
	 * @return the lists
	 */
	public abstract List<Selection> getLists();

	/**
	 * Get Trainees list names
	 * 
	 * @return List of names of Trainees
	 */
	public abstract List<String> getListNames();

	/**
	 * Create a new list with specified name. The name should be unique?
	 * 
	 * @param name Name of the list
	 */
	public abstract String createList(String name);

	public abstract String selectList(String name);

	/**
	 * Get currently selected list from session.
	 * 
	 * @return Selected list or <c>null</c>.
	 */
	public abstract Selection getSelectedList();
}
