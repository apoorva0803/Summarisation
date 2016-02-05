package bean;

import java.util.Date;

public class Admission extends AdmissionBase {

	Date admissionStartDate;
	Date admissionEndDate;
	
	public Date getAdmissionStartDate() {
		return admissionStartDate;
	}
	public void setAdmissionStartDate(Date admissionStartDate) {
		this.admissionStartDate = admissionStartDate;
	}
	public Date getAdmissionEndDate() {
		return admissionEndDate;
	}
	public void setAdmissionEndDate(Date admissionEndDate) {
		this.admissionEndDate = admissionEndDate;
	}
	
}
