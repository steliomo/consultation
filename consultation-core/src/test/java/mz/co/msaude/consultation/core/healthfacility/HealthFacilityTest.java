/**
 *
 */
package mz.co.msaude.consultation.core.healthfacility;

import javax.inject.Inject;

import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.util.TestUtil;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.fixturefactory.HealthFacilityTemplate;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;
import mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityService;

/**
 * @author Stélio Moiane
 *
 */
public class HealthFacilityTest extends AbstractServiceTest {

	@Inject
	private HealthFacilityService healthFacvilityService;

	@Test
	public void shouldCreateHealthFacility() throws BusinessException {

		final HealthFacility heatlhFacility = EntityFactory.gimme(HealthFacility.class, HealthFacilityTemplate.VALID);

		this.healthFacvilityService.createHealthFacility(this.getUserContext(), heatlhFacility);

		TestUtil.assertCreation(heatlhFacility);
	}
}
