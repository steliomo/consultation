/**
 *
 */
package mz.co.msaude.consultation.core.consultationtype.integ;

import javax.inject.Inject;

import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.util.TestUtil;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;
import mz.co.msaude.consultation.core.consultationtype.service.ConsultationTypeService;
import mz.co.msaude.consultation.core.fixturefactory.ConsultationTypeTemplate;

/**
 * @author Stélio Moiane
 *
 */
public class ConsultationTypeServiceTest extends AbstractServiceTest {

	@Inject
	private ConsultationTypeService consultationTypeService;

	@Test
	public void shouldCreateConsultationType() throws BusinessException {

		final ConsultationType consultationType = EntityFactory.gimme(ConsultationType.class,
		        ConsultationTypeTemplate.VALID);

		this.consultationTypeService.createConsultationType(this.getUserContext(), consultationType);

		TestUtil.assertCreation(consultationType);
	}
}
