/**
 *
 */
package mz.co.msaude.consultation.core.healthfacility.integ;

import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.fixturefactory.HealthFacilityTemplate;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;
import mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityQueryService;
import mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityService;

/**
 * @author Stélio Moiane
 *
 */
public class HealthFacilityQueryTest extends AbstractServiceTest {

	@Inject
	private HealthFacilityService healthFacvilityService;

	@Inject
	private HealthFacilityQueryService healthFacilityQueryService;

	private HealthFacility heatlhFacility;

	@Before
	public void setup() throws BusinessException {
		this.heatlhFacility = EntityFactory.gimme(HealthFacility.class, HealthFacilityTemplate.VALID);
		this.healthFacvilityService.createHealthFacility(this.getUserContext(), this.heatlhFacility);
	}

	@Test
	public void shouldFindHealthFacilityByLocality() throws BusinessException {

		final List<HealthFacility> healthFacilities = this.healthFacilityQueryService
		        .findHealthFacilityByLocalitynUuid(this.heatlhFacility.getLocalityUuid());

		assertFalse(healthFacilities.isEmpty());
	}

}
