/**
 *
 */
package mz.co.msaude.consultation.integ.resources.consultationtype;

import static mz.co.msaude.consultation.integ.resources.consultationtype.ConsultationTypeResource.NAME;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;
import mz.co.msaude.consultation.core.consultationtype.service.ConsultationTypeQueryService;
import mz.co.msaude.consultation.core.consultationtype.service.ConsultationTypeService;
import mz.co.msaude.consultation.integ.resources.AbstractResource;

/**
 * @author Stélio Moiane
 *
 */
@Path("consultation-types")
@Service(NAME)
public class ConsultationTypeResource extends AbstractResource {

	public static final String NAME = "mz.co.msaude.consultation.integ.resources.consultationtype.ConsultationTypeResource";

	@Inject
	private ConsultationTypeService consultationTypeService;

	@Inject
	private ConsultationTypeQueryService consultationTypeQueryService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createConsultationType(final ConsultationType consultationType) throws BusinessException {

		this.consultationTypeService.createConsultationType(this.getContext(), consultationType);

		return Response.ok(consultationType).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response finaAllConsultationTypes() throws BusinessException {
		final List<ConsultationType> consultationTypes = this.consultationTypeQueryService.findAllConsultationTypes();
		return Response.ok(consultationTypes).build();
	}
}
