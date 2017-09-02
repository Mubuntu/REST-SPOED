package edu.ap.registraties;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.ap.xml.XMLParser;

public class RegistratiePatientResource extends ServerResource{
	@Get("html")
	public String getPatient() {
		String registratie_id = getAttribute("registratie_id");
		XMLParser parser = new XMLParser();
		return parser.getPatients(registratie_id);
	}

}
