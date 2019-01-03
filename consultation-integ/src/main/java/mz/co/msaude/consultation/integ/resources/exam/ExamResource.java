/**
 *
 */
package mz.co.msaude.consultation.integ.resources.exam;

import static mz.co.msaude.consultation.integ.resources.exam.ExamResource.NAME;

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
import mz.co.msaude.consultation.core.exam.model.Exam;
import mz.co.msaude.consultation.core.exam.model.ExamStatus;
import mz.co.msaude.consultation.core.exam.service.ExamQueryService;
import mz.co.msaude.consultation.core.exam.service.ExamService;
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
	private ExamService examService;

	@Inject
	private ExamQueryService examQueryService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response scheduleExam(final Exam exam) throws BusinessException {

		this.examService.scheduleExam(this.getContext(), exam);

		return Response.ok(exam).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetchExamByUserAndStatus(@QueryParam("examStatus") final ExamStatus examStatus)
	        throws BusinessException {

		final List<Exam> exams = this.examQueryService.fecthExamByUserAndStatus(this.getContext(), examStatus);

		return Response.ok(exams).build();
	}
}
