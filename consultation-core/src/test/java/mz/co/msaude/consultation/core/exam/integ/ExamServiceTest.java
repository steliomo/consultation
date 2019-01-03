/**
 *
 */
package mz.co.msaude.consultation.core.exam.integ;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.util.TestUtil;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.exam.model.Exam;
import mz.co.msaude.consultation.core.exam.service.ExamService;
import mz.co.msaude.consultation.core.fixturefactory.ExamTemplate;
import mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityService;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeService;

/**
 * @author Stélio Moiane
 *
 */
public class ExamServiceTest extends AbstractServiceTest {

	@Inject
	private MedicalServiceTypeService medicalServiceTypeService;

	@Inject
	private HealthFacilityService healthFacilityService;

	@Inject
	private ExamService examService;

	private Exam exam;

	@Before
	public void setup() throws BusinessException {
		this.exam = EntityFactory.gimme(Exam.class, ExamTemplate.VALID);
		this.medicalServiceTypeService.createMedicalServiceType(this.getUserContext(),
		        this.exam.getMedicalServiceType());
		this.healthFacilityService.createHealthFacility(this.getUserContext(), this.exam.getHealthFacility());
	}

	@Test
	public void shouldScheduleExam() throws BusinessException {
		this.examService.scheduleExam(this.getUserContext(), this.exam);
		TestUtil.assertCreation(this.exam);

		assertEquals(ServiceType.EXAM, this.exam.getMedicalServiceType().getServiceType());
	}

	@Test(expected = BusinessException.class)
	public void shouldNotScheduleExam() throws BusinessException {
		final Exam exam = EntityFactory.gimme(Exam.class, ExamTemplate.VALID);
		exam.getMedicalServiceType().setServiceType(ServiceType.CONSULTATION);

		this.examService.scheduleExam(this.getUserContext(), exam);
	}
}
