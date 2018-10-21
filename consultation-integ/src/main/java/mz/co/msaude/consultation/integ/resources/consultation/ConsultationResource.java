/**
 *
 */
package mz.co.msaude.consultation.integ.resources.consultation;

import static mz.co.msaude.consultation.integ.resources.consultation.ConsultationResource.NAME;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.consultation.model.Consultation;
import mz.co.msaude.consultation.core.consultation.model.ConsultationStatus;
import mz.co.msaude.consultation.core.consultation.service.ConsultationQueryService;
import mz.co.msaude.consultation.core.consultation.service.ConsultationService;
import mz.co.msaude.consultation.integ.resources.AbstractResource;

/**
 * @author Stélio Moiane
 *
 */
@Path("consultations")
@Service(NAME)
public class ConsultationResource extends AbstractResource {

	public static final String NAME = "mz.co.msaude.consultation.integ.resources.consultation.ConsultationResource";

	@Inject
	private ConsultationService consultationService;

	@Inject
	private ConsultationQueryService consultationQueryService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createConsultation(final Consultation consultation) throws BusinessException {

		this.consultationService.createConsultation(this.getContext(), consultation);

		return Response.ok(consultation).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetchConsultationsByUserAndStatus(
	        @QueryParam("consultationStatus") final ConsultationStatus consultationStatus) throws BusinessException {

		final List<Consultation> consultations = this.consultationQueryService
		        .fetchConsultationsByUserAndStatus(this.getContext(), consultationStatus);

		return Response.ok(consultations).build();
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateConsultation(@PathParam("id") final Long id, final Consultation consultation)
	        throws BusinessException {

		final Consultation foundConsultation = this.consultationQueryService.findConsultationById(id);
		foundConsultation.setConsultationStatus(consultation.getConsultationStatus());

		this.consultationService.updateConsultation(this.getContext(), foundConsultation);

		return Response.ok(consultation).build();
	}
}
