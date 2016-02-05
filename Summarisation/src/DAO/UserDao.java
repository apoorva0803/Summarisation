package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import model.ConfigList;
import bean.Admission;
import bean.AdmissionDiagonsis;
import bean.Lab;
import bean.Patient;
import util.H2Constants;
import DAOFactory.H2DAOFactory;

public class UserDao {

	private Connection con = null;
	private PreparedStatement pStmt = null;
	private ResultSet resultSet = null;
	private Logger logger = Logger.getLogger("User DAO");

	/**
	 * Synchronise with the database for fast performance
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void preProcess() throws ClassNotFoundException, SQLException{
		createPatientInfo();
		createAdmissionInfo();
		createLabInfo();
		createDiagnosisInfo();

	}

	/**
	 * Persist patient information 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createPatientInfo() throws ClassNotFoundException, SQLException{
		logger.info("Starting of Patient Method");
		
		List<Patient> arrListPatient = new ArrayList<Patient>();
		try
		{
			con = H2DAOFactory.createH2Connection();
			pStmt = con.prepareStatement(H2Constants.H2_SELECT_PATIENT);
			resultSet = pStmt.executeQuery();

			while(resultSet.next())
			{
				Patient patient = new Patient();
				patient.setPatientId(resultSet.getString(1));
				patient.setPatientGender(resultSet.getString(2));
				patient.setPatientDateOfBirth(resultSet.getString(3));
				patient.setPatientRace(resultSet.getString(4));
				patient.setPatientMaritalStatus(resultSet.getString(5));
				patient.setPatientLanguage(resultSet.getString(6));
				patient.setPopulationBelowPoverty(resultSet.getFloat(7));
				arrListPatient.add(patient);
			}
			ConfigList.getInstance().setPatientList(arrListPatient);
			con.commit();
		}
		catch(ClassNotFoundException e)
		{
			throw e;
		}
		catch (SQLException e) 
		{
			try 
			{
				con.rollback();
			}
			catch (SQLException e1) 
			{
				throw e1;
			}
			throw e;
		}
		catch(NullPointerException e)
		{
			throw e;
		}
		finally
		{
			if(pStmt!=null)	pStmt.close();			
			if(resultSet!=null)	resultSet.close();
			if(con!=null) con.close();
			logger.info("End of create_Label_Cluster_Map Method");
		}

	}

	/**
	 * Persist admission info
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createAdmissionInfo() throws ClassNotFoundException, SQLException{
		logger.info("Starting of Admission Method");

		List<Admission> arrListAdmission = new ArrayList<Admission>();
		try
		{
			con = H2DAOFactory.createH2Connection();
			pStmt = con.prepareStatement(H2Constants.H2_SELECT_ADMISSION);
			resultSet = pStmt.executeQuery();

			while(resultSet.next())
			{
				Admission admission = new Admission();
				admission.setPatientId(resultSet.getString(1));
				admission.setAdmissionId(resultSet.getInt(2));
				//				admission.setAdmissionStartDate(resultSet.getDate(3));
				//				admission.setAdmissionEndDate(resultSet.getDate(4));
				arrListAdmission.add(admission);
			}
			ConfigList.getInstance().setAdmissionList(arrListAdmission);
			con.commit();
		}
		catch(ClassNotFoundException e)
		{
			throw e;
		}
		catch (SQLException e) 
		{
			try 
			{
				con.rollback();
			}
			catch (SQLException e1) 
			{
				throw e1;
			}
			throw e;
		}
		catch(NullPointerException e)
		{
			throw e;
		}
		finally
		{
			if(pStmt!=null)	pStmt.close();			
			if(resultSet!=null)	resultSet.close();
			if(con!=null) con.close();
			logger.info("End of Admission Method");
		}

	}


	/**
	 * Persist lab info
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createLabInfo() throws ClassNotFoundException, SQLException{
		logger.info("Starting of Lab Method");

		List<Lab> arrListLab = new ArrayList<Lab>();
		try
		{
			con = H2DAOFactory.createH2Connection();
			pStmt = con.prepareStatement(H2Constants.H2_SELECT_LAB);
			resultSet = pStmt.executeQuery();

			while(resultSet.next())
			{
				Lab lab = new Lab();
				lab.setPatientId(resultSet.getString(1));
				lab.setAdmissionId(resultSet.getInt(2));
				lab.setLabName(resultSet.getString(3));
				lab.setLabValue(resultSet.getString(4));
				lab.setLabUnits(resultSet.getString(5));
				//lab.setLabDate(resultSet.getString(6));
				arrListLab.add(lab);
			}
			con.commit();
			ConfigList.getInstance().setLabList(arrListLab);
		}
		catch(ClassNotFoundException e)
		{
			throw e;
		}
		catch (SQLException e) 
		{
			try 
			{
				con.rollback();
			}
			catch (SQLException e1) 
			{
				throw e1;
			}
			throw e;
		}
		catch(NullPointerException e)
		{
			throw e;
		}
		finally
		{
			if(pStmt!=null)	pStmt.close();			
			if(resultSet!=null)	resultSet.close();
			if(con!=null) con.close();
			logger.info("End of Lab Method");
		}

	}

	/**
	 * Persist diagnosis info
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createDiagnosisInfo() throws ClassNotFoundException, SQLException{
		logger.info("Starting of Diagnosis Method");

		List<AdmissionDiagonsis> arrListDiagnosis = new ArrayList<AdmissionDiagonsis>();
		try
		{
			con = H2DAOFactory.createH2Connection();
			pStmt = con.prepareStatement(H2Constants.H2_SELECT_DIAGNOSIS);
			resultSet = pStmt.executeQuery();

			while(resultSet.next())
			{
				AdmissionDiagonsis diagnosis = new AdmissionDiagonsis();
				diagnosis.setPatientId(resultSet.getString(1));
				diagnosis.setAdmissionId(resultSet.getInt(2));
				diagnosis.setPrimaryDiagonsisCode(resultSet.getString(3));
				diagnosis.setPrimaryDiagonsisDesc(resultSet.getString(4));
				arrListDiagnosis.add(diagnosis);
			}
			con.commit();
			ConfigList.getInstance().setDiagnosisList(arrListDiagnosis);
		}
		catch(ClassNotFoundException e)
		{
			throw e;
		}
		catch (SQLException e) 
		{
			try 
			{
				con.rollback();
			}
			catch (SQLException e1) 
			{
				throw e1;
			}
			throw e;
		}
		catch(NullPointerException e)
		{
			throw e;
		}
		finally
		{
			if(pStmt!=null)	pStmt.close();			
			if(resultSet!=null)	resultSet.close();
			if(con!=null) con.close();
			logger.info("End of create Diagnosis Method");
		}

	}


}

