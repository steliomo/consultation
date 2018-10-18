/**
 *
 */
package mz.co.msaude.consultation.integ.resources.healthfacility;

import static mz.co.msaude.consultation.integ.resources.healthfacility.HealthFacilityResource.NAME;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;
import mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityQueryService;
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

	@Inject
	private HealthFacilityQueryService healthFacilityQueryService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createHealthFacility(final HealthFacility healthFacility) throws BusinessException {

		this.healthFacilityService.createHealthFacility(this.getContext(), healthFacility);

		return Response.ok(healthFacility).build();
	}

	@GET
	@Path("{localityUuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findHealhFacilityByLocalityUuid(final @PathParam("localityUuid") String localityUuid)
	        throws BusinessException {

		final List<HealthFacility> healthFacilities = this.healthFacilityQueryService
		        .findHealthFacilityByLocalitynUuid(localityUuid);

		return Response.ok(healthFacilities).build();
	}
}
