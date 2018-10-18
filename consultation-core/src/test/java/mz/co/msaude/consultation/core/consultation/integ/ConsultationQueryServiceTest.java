/**
 *
 */
package mz.co.msaude.consultation.core.consultation.integ;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.consultation.model.Consultation;
import mz.co.msaude.consultation.core.consultation.service.ConsultationQueryService;
import mz.co.msaude.consultation.core.consultation.service.ConsultationService;
import mz.co.msaude.consultation.core.consultationtype.service.ConsultationTypeService;
import mz.co.msaude.consultation.core.doctor.service.DoctorService;
import mz.co.msaude.consultation.core.fixturefactory.ConsultationTemplate;
import mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityService;

/**
 * @author Stélio Moiane
 *
 */
public class ConsultationQueryServiceTest extends AbstractServiceTest {

	@Inject
	private ConsultationService consultationService;

	@Inject
	private ConsultationTypeService consultationTypeService;

	@Inject
	private HealthFacilityService healthFacilityService;

	@Inject
	private DoctorService doctorService;

	@Inject
	private ConsultationQueryService consultationQueryService;

	private Consultation consultation;

	private UserContext context;

	@Before
	public void setup() throws BusinessException {

		this.consultation = EntityFactory.gimme(Consultation.class, ConsultationTemplate.VALID);

		this.context = this.getUserContext();
		this.consultationTypeService.createConsultationType(this.context, this.consultation.getConsultationType());
		this.healthFacilityService.createHealthFacility(this.context, this.consultation.getHealthFacility());
		this.doctorService.createDoctor(this.context, this.consultation.getDoctor());

		this.consultationService.createConsultation(this.context, this.consultation);
	}

	@Test
	public void shouldFetchConsultationsByUserAndStatus() throws BusinessException {
		final List<Consultation> consultations = this.consultationQueryService
		        .fetchConsultationsByUserAndStatus(this.context, this.consultation.getConsultationStatus());

		assertFalse(consultations.isEmpty());

		consultations.forEach(consultation -> {
			assertNotNull(consultation.getConsultationType());
			assertNotNull(consultation.getHealthFacility());
			assertNotNull(consultation.getDoctor());
		});
	}

}
