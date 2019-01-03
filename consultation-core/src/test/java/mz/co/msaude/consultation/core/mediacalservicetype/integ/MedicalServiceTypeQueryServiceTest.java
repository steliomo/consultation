/**
 *
 */
package mz.co.msaude.consultation.core.mediacalservicetype.integ;

import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.fixturefactory.MedicalServiceTypeTemplate;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeQueryService;
import mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeService;

/**
 * @author Stélio Moiane
 *
 */
public class MedicalServiceTypeQueryServiceTest extends AbstractServiceTest {

	@Inject
	private MedicalServiceTypeService consultationTypeService;

	@Inject
	private MedicalServiceTypeQueryService medicalServiceTypeQueryService;

	@Before
	public void setup() throws BusinessException {

		final MedicalServiceType medicalServiceType = EntityFactory.gimme(MedicalServiceType.class,
		        MedicalServiceTypeTemplate.CONSULTATION);

		this.consultationTypeService.createMedicalServiceType(this.getUserContext(), medicalServiceType);
	}

	@Test
	public void shouldFindAllConsultationTypes() throws BusinessException {
		final List<MedicalServiceType> medicalServiceTypes = this.medicalServiceTypeQueryService
		        .findMedicalServiceTypesByServiceType(ServiceType.CONSULTATION);
		assertFalse(medicalServiceTypes.isEmpty());
	}
}
