package bean;

import java.util.Date;

public class Lab extends AdmissionBase{

	String labName;
	String labUnits;
	String labValue;
	Date labDate;
	
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public String getLabUnits() {
		return labUnits;
	}
	public void setLabUnits(String labUnits) {
		this.labUnits = labUnits;
	}
	public String getLabValue() {
		return labValue;
	}
	public void setLabValue(String labValue) {
		this.labValue = labValue;
	}
	public Date getLabDate() {
		return labDate;
	}
	public void setLabDate(Date date) {
		this.labDate = date;
	}
	
	
}
