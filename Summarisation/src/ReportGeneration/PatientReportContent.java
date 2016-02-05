package ReportGeneration;

import bean.*;

public class PatientReportContent {
	Lab[] relevantLabData;
	String[] diagnosis;
	Patient patient;
	
	
	public Lab[] getLab() {
		return relevantLabData;
	}
	public void setLab(Lab[] relevantLabData) {
		this.relevantLabData = relevantLabData;
	}
	public String[] getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String[] diagnosis) {
		this.diagnosis = diagnosis;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}
