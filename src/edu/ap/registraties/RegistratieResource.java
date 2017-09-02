package edu.ap.registraties;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.ap.xml.XMLParser;

public class RegistratieResource extends ServerResource {

	@Get("html")
	public String getRace() {
		String registratie_id = getAttribute("registratie_id");
		XMLParser parser = new XMLParser();
		return parser.getRegistratie(registratie_id);
	}

	@Post("txt")
	public String addRegistratie(String registratie) {
		// String registratie_id = getAttribute("registratie_id");
		XMLParser parser = new XMLParser();
		return parser.addRegistratie(registratie);

	}
}
