/**
 *
 */
package mz.co.msaude.consultation.integ.resources.medicalservicetype;

import static mz.co.msaude.consultation.integ.resources.medicalservicetype.MedicalServiceTypeResource.NAME;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeQueryService;
import mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeService;
import mz.co.msaude.consultation.integ.resources.AbstractResource;

/**
 * @author Stélio Moiane
 *
 */
@Path("medical-service-types")
@Service(NAME)
public class MedicalServiceTypeResource extends AbstractResource {

	public static final String NAME = "mz.co.msaude.consultation.integ.resources.medicalservicetype.MedicalServiceTypeResource";

	@Inject
	private MedicalServiceTypeService medicalServiceTypeService;

	@Inject
	private MedicalServiceTypeQueryService medicalServiceTypeQueryService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMedicalServiceType(final MedicalServiceType medicalServiceType) throws BusinessException {

		this.medicalServiceTypeService.createMedicalServiceType(this.getContext(), medicalServiceType);

		return Response.ok(medicalServiceType).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findMedicalServiceTypes(@QueryParam("serviceType") final ServiceType serviceType)
	        throws BusinessException {

		final List<MedicalServiceType> medicalServiceTypes = this.medicalServiceTypeQueryService
		        .findMedicalServiceTypesByServiceType(serviceType);

		return Response.ok(medicalServiceTypes).build();
	}
}
