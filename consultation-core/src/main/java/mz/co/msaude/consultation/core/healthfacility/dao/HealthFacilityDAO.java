/**
 *
 */
package mz.co.msaude.consultation.core.healthfacility.dao;

import java.util.List;

import mz.co.msaude.boot.frameworks.dao.GenericDAO;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;

/**
 * @author Stélio Moiane
 *
 */
public interface HealthFacilityDAO extends GenericDAO<HealthFacility, Long> {

	public class QUERY {
		public static final String findByLocalityUuid = "SELECT hf FROM HealthFacility hf WHERE hf.localityUuid = :localityUuid AND hf.entityStatus = :entityStatus";
	}

	public class QUERY_NAME {
		public static final String findByLocalityUuid = "HealthFacility.findByLocalityUuid";
	}

	List<HealthFacility> findByLocalityUuid(final String localityUuid, EntityStatus entityStatus)
	        throws BusinessException;
}
