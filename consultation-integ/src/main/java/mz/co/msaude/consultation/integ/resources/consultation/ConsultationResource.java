/**
 *
 */
package mz.co.msaude.consultation.integ.resources.consultation;

import static mz.co.msaude.consultation.integ.resources.consultation.ConsultationResource.NAME;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.consultation.model.Consultation;
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

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createConsultation(final Consultation consultation) throws BusinessException {

		this.consultationService.createConsultation(this.getContext(), consultation);

		return Response.ok(consultation).build();
	}
}
