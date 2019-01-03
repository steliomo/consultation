/**
 *
 */
package mz.co.msaude.consultation.core.exam.integ;

import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.exam.model.Exam;
import mz.co.msaude.consultation.core.exam.service.ExamQueryService;
import mz.co.msaude.consultation.core.exam.service.ExamService;
import mz.co.msaude.consultation.core.fixturefactory.ExamTemplate;
import mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityService;
import mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeService;

/**
 * @author Stélio Moiane
 *
 */
public class ExamQueryServiceTest extends AbstractServiceTest {

	@Inject
	private MedicalServiceTypeService medicalServiceTypeService;

	@Inject
	private HealthFacilityService healthFacilityService;

	@Inject
	private ExamService examService;

	@Inject
	private ExamQueryService examQueryService;

	private Exam exam;

	private UserContext context;

	@Before
	public void setup() throws BusinessException {

		this.context = this.getUserContext();

		this.exam = EntityFactory.gimme(Exam.class, ExamTemplate.VALID);
		this.medicalServiceTypeService.createMedicalServiceType(this.context, this.exam.getMedicalServiceType());
		this.healthFacilityService.createHealthFacility(this.context, this.exam.getHealthFacility());
		this.examService.scheduleExam(this.context, this.exam);
	}

	@Test
	public void shouldFecthExamByUserAndStatus() throws BusinessException {
		final List<Exam> exams = this.examQueryService.fecthExamByUserAndStatus(this.context,
		        this.exam.getExamStatus());

		assertFalse(exams.isEmpty());
	}
}
