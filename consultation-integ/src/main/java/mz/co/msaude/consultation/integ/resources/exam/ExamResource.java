/**
 *
 */
package mz.co.msaude.consultation.integ.resources.exam;

import static mz.co.msaude.consultation.integ.resources.exam.ExamResource.NAME;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.examtype.model.ExamType;
import mz.co.msaude.consultation.core.examtype.service.ExamTypeService;
import mz.co.msaude.consultation.integ.resources.AbstractResource;

/**
 * @author Stélio Moiane
 *
 */
@Path("exams")
@Service(NAME)
public class ExamResource extends AbstractResource {

	public static final String NAME = "mz.co.msaude.consultation.integ.resources.exam.ExamResource";

	@Inject
	private ExamTypeService examTypeService;

	@POST
	@Path("types")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createExamType(final ExamType examType) throws BusinessException {

		this.examTypeService.createExamType(this.getContext(), examType);

		return Response.ok(examType).build();
	}

}
