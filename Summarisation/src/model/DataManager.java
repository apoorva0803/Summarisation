package model;

import java.util.*;
import bean.*;
import model.*;

public class DataManager {

	/**
	 * Returns a patient's diagnoses
	 * @param patient
	 * @return
	 */
	public static List<AdmissionDiagonsis> getPatientDiagnosis(Patient patient){
		List<AdmissionDiagonsis> diagnosisList = ConfigList.getDiagnosisList();
		
		List<AdmissionDiagonsis> patientDiagnosis = new ArrayList<AdmissionDiagonsis>();
		
		for (AdmissionDiagonsis diagnosis :diagnosisList){
			if (diagnosis.getPatientId() == patient.getPatientId())
				patientDiagnosis.add(diagnosis);
		}
		
		return patientDiagnosis;
	}
	
	/**
	 * Returns the lab results for specific patient in specific admission
	 * @param patient
	 * @param admissionId
	 * @return
	 */
	public static List<Lab> getPatientLabRsultsForAdmission(Patient patient, int admissionId){
		List<Lab> diagnosisList = ConfigList.getLabList();
		
		List<Lab> patientLabResults = new ArrayList<Lab>();
		
		for (Lab labResult :patientLabResults){
			if (labResult.getPatientId() == patient.getPatientId() && labResult.getAdmissionId() == admissionId)
				patientLabResults.add(labResult);
		}
		
		return patientLabResults;
	}
	
	/**
	 * Returns list of admissions for a patient 
	 * @param patient
	 * @return
	 */
	public static List<Admission> getPatientAdmissions(Patient patient){
		List<Admission> diagnosisList = ConfigList.getAdmissionList();
		
		List<Admission> patientAdmissions = new ArrayList<Admission>();
		
		for (Admission admission :patientAdmissions){
			if (admission.getPatientId() == patient.getPatientId())
				diagnosisList.add(admission);
		}
		
		return diagnosisList;
	}
}
