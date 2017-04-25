package org.iita.trainingunit.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.iita.service.impl.XLSImportException;
import org.iita.trainingunit.model.Attendance;
import org.iita.trainingunit.model.TrainingProgram;

public interface XLSService {
	/**
	 * Generate XLS template file based on list of Attendance
	 * 
	 * @param allAttendance
	 * @return
	 * @throws IOException 
	 */
	InputStream getXLSTemplateStream(TrainingProgram group) throws IOException;

	/**
	 * @param list
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws XLSImportException 
	 */
	void importXLSAttendance(List<Attendance> list);

	/**
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws XLSImportException
	 */
	List<Attendance> previewXLSAttendance(TrainingProgram trainingProgram, File file) throws FileNotFoundException, IOException, XLSImportException;
}
