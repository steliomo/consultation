/**
 *
 */
package mz.co.msaude.consultation.core.healthfacility.service;

import static mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.consultation.core.healthfacility.dao.HealthFacilityDAO;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class HealthFacilityServiceImpl extends AbstractService implements HealthFacilityService {

	public static final String NAME = "mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityServiceImpl";

	@Inject
	private HealthFacilityDAO healthFacilityDAO;

	@Override
	public HealthFacility createHealthFacility(final UserContext userContext, final HealthFacility heatlhFacility)
	        throws BusinessException {
		return this.healthFacilityDAO.create(userContext, heatlhFacility);
	}
}
