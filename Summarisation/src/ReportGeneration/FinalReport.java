package ReportGeneration;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;

import java.util.ArrayList;
import java.util.List;

import bean.AdmissionDiagonsis;
import simplenlg.features.*;

public class FinalReport {
	//private PatientReportContent reportContent;
	
	public String getPatientReport(String patientId, List<AdmissionDiagonsis> diagnoses){
		String report = "";
		
		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory nlgFactory = new NLGFactory(lexicon);
		Realiser realiser = new Realiser(lexicon);
		
		SPhraseSpec p = nlgFactory.createClause();
		
		List<NPPhraseSpec> objects = new ArrayList<NPPhraseSpec>();
		CoordinatedPhraseElement obj = nlgFactory.createCoordinatedPhrase();
		
		for(AdmissionDiagonsis diagnosis : diagnoses){
			NPPhraseSpec object = nlgFactory.createNounPhrase(diagnoses);
			obj.addCoordinate(object);
		}
		
	     

		
		VPPhraseSpec verb = nlgFactory.createVerbPhrase("diagnose as");
	    
	    p.setFeature(Feature.TENSE, Tense.PAST);
	    p.setSubject("This patient");
	    p.setObject(obj);
	    p.setVerb(verb);
	    
	    String output2 = realiser.realiseSentence(p);
	    
	    report = output2;
		return report;
	}
}
