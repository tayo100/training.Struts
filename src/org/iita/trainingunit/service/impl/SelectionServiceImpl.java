/**
 * 
 */
package org.iita.trainingunit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.iita.trainingunit.model.Selection;
import org.iita.trainingunit.service.SelectionService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author koraegbunam
 * 
 */
public class SelectionServiceImpl extends ActionSupport implements SelectionService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SESSIONLISTS = "selection.all";
	private static final Object SELECTEDLIST = "selection.my";
	private List<Selection> lists = null;

	public SelectionServiceImpl() {

	}

	/**
	 * Check the lists exist in user session.
	 */
	private void ensureLists() {
		// System.out.println("ensureLists null?=" + (this.lists==null) +
		// "  size=" + (this.lists==null ? "null" : ""+this.lists.size()));
		if (this.lists == null)
			initializeSession();
	}

	/**
	 * Get SelectionLists object from session or ensure one is created in session.
	 */
	@SuppressWarnings("unchecked")
	private void initializeSession() {
		// get lotselection Session values
		this.lists = (List<Selection>) ActionContext.getContext().getSession().get(SESSIONLISTS);

		if (this.lists == null) {
			ActionContext.getContext().getSession().put(SESSIONLISTS, this.lists = new ArrayList<Selection>());

			// add default list
			Selection defaultList = new Selection();
			defaultList.setName("My list");
			this.lists.add(defaultList);
			selectList(defaultList);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.inventory.service.impl.SelectionService#getLists()
	 */
	public List<Selection> getLists() {
		return this.lists;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.inventory.service.impl.SelectionService#getListNames()
	 */
	public List<String> getListNames() {
		List<String> names = new ArrayList<String>();

		// return empty list
		if (this.lists == null)
			return names;

		// generate list of names
		for (Selection ls : this.lists)
			names.add(ls.getName());

		return names;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.inventory.service.impl.SelectionService#createList(java.lang .String)
	 */
	public String createList(String name) {
		ensureLists();

		// create new lot selection list
		Selection newList = new Selection();
		newList.setName(name);
		this.lists.add(newList);
		selectList(newList);
		return Action.SUCCESS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.inventory.service.impl.SelectionService#selectList(java.lang .String)
	 */
	public String selectList(String name) {
		Selection selectedList = getListByName(name);
		if (selectedList == null)
			return Action.ERROR;
		selectList(selectedList);
		return Action.SUCCESS;
	}

	/**
	 * Add reference to selected list to session
	 * 
	 * @param selectedList
	 */
	@SuppressWarnings("unchecked")
	private void selectList(Selection selectedList) {
		ActionContext.getContext().getSession().put(SELECTEDLIST, selectedList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.inventory.service.impl.SelectionService#getSelectedList()
	 */
	public Selection getSelectedList() {
		// System.out.println("getSelectedList");
		ensureLists();
		// System.out.println("should hacve list in session now");
		Selection selectedList = (Selection) ActionContext.getContext().getSession().get(SELECTEDLIST);
		// System.out.println("returning " + selectedList);
		return selectedList;
	}

	/**
	 * @param name
	 * @return
	 */
	private Selection getListByName(String name) {
		if (this.lists != null)
			for (Selection ls : this.lists)
				if (ls.getName().equals(name))
					return ls;
		return null;
	}
}
