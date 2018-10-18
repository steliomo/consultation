/**
 *
 */
package mz.co.msaude.consultation.core.healthfacility.service;

import java.util.List;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;

/**
 * @author Stélio Moiane
 *
 */
public interface HealthFacilityQueryService {

	List<HealthFacility> findHealthFacilityByLocalitynUuid(final String localityUuid) throws BusinessException;
}
