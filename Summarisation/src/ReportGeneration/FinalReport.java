package ReportGeneration;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

public class FinalReport {
	private PatientReportContent reportContent;
	
	public String getPatientReport(PatientReportContent patientContent){
		String report = "";
		
		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory nlgFactory = new NLGFactory(lexicon);
		Realiser realiser = new Realiser(lexicon);
		
		SPhraseSpec p = nlgFactory.createClause();
		
		NPPhraseSpec object = nlgFactory.createNounPhrase(patientContent.getDiagnosis()[0]);
	    VPPhraseSpec verb = nlgFactory.createVerbPhrase("diagnose as");
	    
	    p.setFeature(Feature.TENSE, Tense.PAST);
	    p.setSubject("This patient");
	    p.setObject(object);
	    p.setVerb(verb);
	    
	    String output2 = realiser.realiseSentence(p);
	    
	    report = output2;
		return report;
	}
}
