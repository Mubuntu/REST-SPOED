package edu.ap.registraties;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.ap.xml.XMLParser;

public class RegistratiesResource extends ServerResource {

	@Get("html")
	public String getRaces() {
		XMLParser parser = new XMLParser();
		return parser.getRegistraties();
	}
	
	@Post("txt")
	public String addRace(String registratie) {
		XMLParser parser = new XMLParser();
		return parser.addRegistratie(registratie);
	}
}
