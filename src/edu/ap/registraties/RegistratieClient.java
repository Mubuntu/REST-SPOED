package edu.ap.registraties;

import org.restlet.resource.ClientResource;

public class RegistratieClient {

	public RegistratieClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		  try {
          	ClientResource resource = new ClientResource("http://localhost:8282/registratie");
          	// Post a new race
          	String registratie = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
          	registratie += "  <registratie interventie=\"25/04/2011 23:45:02\" diagnose=\"is van de trap gevallen.\" id=\"25\">";
          	registratie +="<uri>registratie/25</uri>";
          	registratie += "<patient first_name=\"chris\" last_name=\"christenes\" geboortedatum=\"1965/11/14\" id=\"12\" verpleegkundige=\"mubuntu\"></patient>";
          	registratie += "</registratie>";
          	resource.post(registratie);
      		//resource.post(race);
      		// get the response
          	System.out.println(resource.getResponseEntity().getText());
          }
          catch (Exception e) {
              System.out.println("In main : " + e.getMessage());
          }
	}

}
