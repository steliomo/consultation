/**
 *
 */
package mz.co.msaude.consultation.core.healthfacility.service;

import static mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityQueryServiceImpl.NAME;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.consultation.core.healthfacility.dao.HealthFacilityDAO;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class HealthFacilityQueryServiceImpl implements HealthFacilityQueryService {

	public static final String NAME = "mz.co.msaude.consultation.core.healthfacility.service.HealthFacilityQueryServiceImpl";

	@Inject
	private HealthFacilityDAO healthFacilityDAO;

	@Override
	public List<HealthFacility> findHealthFacilityByLocalitynUuid(final String localityUuid) throws BusinessException {
		return this.healthFacilityDAO.findByLocalityUuid(localityUuid, EntityStatus.ACTIVE);
	}

}
