/**
 *
 */
package mz.co.msaude.consultation.core.consultationtype.integ;

import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;
import mz.co.msaude.consultation.core.consultationtype.service.ConsultationTypeQueryService;
import mz.co.msaude.consultation.core.consultationtype.service.ConsultationTypeService;
import mz.co.msaude.consultation.core.fixturefactory.ConsultationTypeTemplate;

/**
 * @author Stélio Moiane
 *
 */
public class ConsultationTypeQueryServiceTest extends AbstractServiceTest {

	@Inject
	private ConsultationTypeService consultationTypeService;

	@Inject
	private ConsultationTypeQueryService consultationTypeQueryService;

	@Before
	public void setup() throws BusinessException {

		final ConsultationType consultationType = EntityFactory.gimme(ConsultationType.class,
		        ConsultationTypeTemplate.VALID);

		this.consultationTypeService.createConsultationType(this.getUserContext(), consultationType);
	}

	@Test
	public void shouldFindAllconsultationTypes() throws BusinessException {
		final List<ConsultationType> consultationTypes = this.consultationTypeQueryService.findAllConsultationTypes();
		assertFalse(consultationTypes.isEmpty());
	}
}
