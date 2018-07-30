/**
 *
 */
package mz.co.msaude.consultation.integ.resources.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Service;

import mz.co.msaude.consultation.integ.resources.consultationtype.ConsultationTypeResource;
import mz.co.msaude.consultation.integ.resources.healthfacility.HealthFacilityResource;

/**
 * @author Stélio Moiane
 *
 */
@Service
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		this.register(ConsultationTypeResource.class);
		this.register(HealthFacilityResource.class);
	}
}
