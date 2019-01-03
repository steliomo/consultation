/**
 *
 */
package mz.co.msaude.consultation.core.medicalservicetype.dao;

import java.util.List;

import mz.co.msaude.boot.frameworks.dao.GenericDAO;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;

/**
 * @author Stélio Moiane
 *
 */
public interface MedicalServiceTypeDAO extends GenericDAO<MedicalServiceType, Long> {

	public class QUERY {
		public static final String findByServiceType = "SELECT mst FROM MedicalServiceType mst WHERE mst.serviceType = :serviceType AND mst.entityStatus = :entityStatus";
	}

	public class QUERY_NAME {
		public static final String findByServiceType = "MedicalServiceType.findByServiceType";
	}

	List<MedicalServiceType> findByServiceType(ServiceType serviceType, EntityStatus entityStatus)
	        throws BusinessException;
}
