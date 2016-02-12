package ReportGeneration;

import java.sql.SQLException;
import java.util.List;

import DAO.UserDao;
import bean.*;
import model.*;
import java.sql.SQLException;


public class TestMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PatientReportContent patient = new PatientReportContent();

		UserDao ud = new UserDao();
		try {
			ud.preProcess();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Patient> ps = ConfigList.getPatientList();

		Patient p = ps.get(7);

		List<AdmissionDiagonsis> diags = DataManager.getPatientDiagnosis(p);
		
		FinalReport reportGen = new FinalReport();
		
		String report = reportGen.getPatientAdmissionSummary(p.getPatientId(), diags);
		
		System.out.println(report);
	}

}
