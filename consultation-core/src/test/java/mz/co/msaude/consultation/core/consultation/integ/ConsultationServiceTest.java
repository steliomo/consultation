/**
 *
 */
package mz.co.msaude.consultation.core.consultation.integ;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.util.TestUtil;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.consultation.model.Consultation;
import mz.co.msaude.consultation.core.consultation.model.ConsultationStatus;
import mz.co.msaude.consultation.core.consultation.service.ConsultationService;
import mz.co.msaude.consultation.core.consultationtype.service.ConsultationTypeService;
import mz.co.msaude.consultation.core.doctor.service.DoctorService;
import mz.co.msaude.consultation.core.fixturefactory.ConsultationTemplate;
import mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityService;

/**
 * @author Stélio Moiane
 *
 */
public class ConsultationServiceTest extends AbstractServiceTest {

	@Inject
	private ConsultationService consultationService;

	@Inject
	private ConsultationTypeService consultationTypeService;

	@Inject
	private HealthFacilityService healthFacilityService;

	@Inject
	private DoctorService doctorService;

	private Consultation consultation;

	@Before
	public void setup() throws BusinessException {
		this.consultation = EntityFactory.gimme(Consultation.class, ConsultationTemplate.VALID);

		this.consultationTypeService.createConsultationType(this.getUserContext(),
		        this.consultation.getConsultationType());
		this.healthFacilityService.createHealthFacility(this.getUserContext(), this.consultation.getHealthFacility());
		this.doctorService.createDoctor(this.getUserContext(), this.consultation.getDoctor());
	}

	@Test
	public void shouldCreatePendingConsultation() throws BusinessException {

		this.consultationService.createConsultation(this.getUserContext(), this.consultation);

		TestUtil.assertCreation(this.consultation);
		assertEquals(ConsultationStatus.PENDING, this.consultation.getConsultationStatus());
	}
}
