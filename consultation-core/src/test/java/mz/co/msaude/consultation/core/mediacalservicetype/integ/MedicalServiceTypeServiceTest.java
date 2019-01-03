/**
 *
 */
package mz.co.msaude.consultation.core.mediacalservicetype.integ;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.util.TestUtil;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.fixturefactory.MedicalServiceTypeTemplate;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeService;

/**
 * @author Stélio Moiane
 *
 */
public class MedicalServiceTypeServiceTest extends AbstractServiceTest {

	@Inject
	private MedicalServiceTypeService consultationTypeService;

	@Test
	public void shouldCreateConsultationType() throws BusinessException {

		final MedicalServiceType medicalServiceType = EntityFactory.gimme(MedicalServiceType.class,
		        MedicalServiceTypeTemplate.CONSULTATION);

		this.consultationTypeService.createMedicalServiceType(this.getUserContext(), medicalServiceType);

		TestUtil.assertCreation(medicalServiceType);
		assertEquals(ServiceType.CONSULTATION, medicalServiceType.getServiceType());
	}

	@Test
	public void shouldCreateExamType() throws BusinessException {

		final MedicalServiceType medicalServiceType = EntityFactory.gimme(MedicalServiceType.class,
		        MedicalServiceTypeTemplate.EXAM);

		this.consultationTypeService.createMedicalServiceType(this.getUserContext(), medicalServiceType);

		TestUtil.assertCreation(medicalServiceType);
		assertEquals(ServiceType.EXAM, medicalServiceType.getServiceType());
	}
}
