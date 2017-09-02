package edu.ap.registraties;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class RegistratieApplication extends Application {

	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 */
	@Override
	public synchronized Restlet createInboundRoot() {

		Router router = new Router(getContext());

		router.attach("/registratie", RegistratiesResource.class);
		router.attach("/registratie/{registratie_id}", RegistratieResource.class);
		router.attach("/registratie/{registratie_id}/patient", RegistratiePatientResource.class);
		// router.attach("/race/{race_id}/runner/{runner_id}",
		// RaceRunnerResource.class);

		return router;
	}
}
