package edu.ap.registraties;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class RegistratieServer {
	public static void main(String[] args) {
		try {
			// Create a new Component.
		    Component component = new Component();
	
		    // Add a new HTTP server listening on port 8181.
		    component.getServers().add(Protocol.HTTP, 8282);
	
		    // Attach the sample application.
		    component.getDefaultHost().attach("/registratie", RegistratiesResource.class);
		    component.getDefaultHost().attach("registratie/{registratie_id}", RegistratieResource.class);
		    component.getDefaultHost().attach("/registratie/{registratie_id}/patient", RegistratiePatientResource.class);
		    //component.getDefaultHost().attach("/race/{race_id}/runner/{runner_id}", RaceRunnerResource.class);
		    
			component.start();
		} 
	    catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
