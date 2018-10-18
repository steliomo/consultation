/**
 *
 */
package mz.co.msaude.consultation.core.healthfacility.dao;

import static mz.co.msaude.consultation.core.healthfacility.dao.HealthFacilityDAOImpl.NAME;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.util.ParamBuilder;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class HealthFacilityDAOImpl extends GenericDAOImpl<HealthFacility, Long> implements HealthFacilityDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.healthfacility.dao.HealthFacilityDAOImpl";

	@Override
	public List<HealthFacility> findByLocalityUuid(final String localityUuid, final EntityStatus entityStatus)
	        throws BusinessException {
		return this.findByNamedQuery(HealthFacilityDAO.QUERY_NAME.findByLocalityUuid,
		        new ParamBuilder().add("localityUuid", localityUuid).add("entityStatus", entityStatus).process());
	}

}
