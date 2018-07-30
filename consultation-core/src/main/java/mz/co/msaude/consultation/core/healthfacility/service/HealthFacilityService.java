/**
 *
 */
package mz.co.msaude.consultation.core.healthfacility.service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;

/**
 * @author Stélio Moiane
 *
 */
public interface HealthFacilityService {

	HealthFacility createHealthFacility(final UserContext userContext, final HealthFacility heatlhFacility)
	        throws BusinessException;

}
