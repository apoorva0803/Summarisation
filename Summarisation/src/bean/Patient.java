package bean;

import java.util.Date;

public class Patient extends PatientBase {

	String patientGender;
	Date patientDateOfBirth;
	String patientRace;
	String patientMaritalStatus;
	String patientLanguage;
	float populationBelowPoverty;

	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public Date getPatientDateOfBirth() {
		return patientDateOfBirth;
	}
	public void setPatientDateOfBirth(Date patientDateOfBirth) {
		this.patientDateOfBirth = patientDateOfBirth;
	}
	public String getPatientRace() {
		return patientRace;
	}
	public void setPatientRace(String patientRace) {
		this.patientRace = patientRace;
	}
	public String getPatientMaritalStatus() {
		return patientMaritalStatus;
	}
	public void setPatientMaritalStatus(String patientMaritalStatus) {
		this.patientMaritalStatus = patientMaritalStatus;
	}
	public String getPatientLanguage() {
		return patientLanguage;
	}
	public void setPatientLanguage(String patientLanguage) {
		this.patientLanguage = patientLanguage;
	}
	public float getPopulationBelowPoverty() {
		return populationBelowPoverty;
	}
	public void setPopulationBelowPoverty(float populationBelowPoverty) {
		this.populationBelowPoverty = populationBelowPoverty;
	}
}
