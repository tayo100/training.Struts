/**
 * training.Struts Feb 8, 2010
 */
package org.iita.trainingunit.service;


/**
 * @author mobreza
 *
 */
public class TrainingUnitDataException extends Exception {
	/**
	 * @param string
	 */
	public TrainingUnitDataException(String msg) {
		super(msg);
	}

	/**
	 * @param string
	 * @param e
	 */
	public TrainingUnitDataException(String string, Throwable e) {
		super(string, e);
	}

	private static final long serialVersionUID = 2059520939719476114L;

}
