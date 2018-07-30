/**
 *
 */
package mz.co.msaude.consultation.integ.resources.consultationtype;

import static mz.co.msaude.consultation.integ.resources.consultationtype.ConsultationTypeResource.NAME;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;
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

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createConsultationType(final ConsultationTypeBean consultationTypeBean) throws BusinessException {

		final ConsultationType consultationType = this.consultationTypeService.createConsultationType(this.getContext(),
		        consultationTypeBean.getConsultationType());

		return Response.ok(consultationType).build();
	}
}
