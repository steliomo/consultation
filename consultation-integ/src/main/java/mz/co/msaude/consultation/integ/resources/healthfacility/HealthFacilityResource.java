/**
 *
 */
package mz.co.msaude.consultation.integ.resources.healthfacility;

import static mz.co.msaude.consultation.integ.resources.healthfacility.HealthFacilityResource.NAME;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;
import mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityService;
import mz.co.msaude.consultation.integ.resources.AbstractResource;

/**
 * @author Stélio Moiane
 *
 */
@Path("health-facilities")
@Service(NAME)
public class HealthFacilityResource extends AbstractResource {

	public static final String NAME = "mz.co.msaude.consultation.integ.resources.healthfacility.HealthFacilityResource";

	@Inject
	private HealthFacilityService healthFacilityService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createHealthFacility(final HealthFacilityBean healthFacilityBean) throws BusinessException {

		final HealthFacility healthFacility = this.healthFacilityService.createHealthFacility(this.getContext(),
		        healthFacilityBean.getHealthFacility());

		return Response.ok(healthFacility).build();
	}
}
