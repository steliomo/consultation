/**
 *
 */
package mz.co.msaude.consultation.core.consultationtype.dao;

import java.util.List;

import mz.co.msaude.boot.frameworks.dao.GenericDAO;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;

/**
 * @author Stélio Moiane
 *
 */
public interface ConsultationTypeDAO extends GenericDAO<ConsultationType, Long> {

	public class QUERY {
		public static final String findAll = "SELECT ct FROM ConsultationType ct WHERE ct.entityStatus = :entityStatus";
	}

	public class QUERY_NAME {
		public static final String findAll = "ConsultationType.findAll";
	}

	List<ConsultationType> findAll(EntityStatus entityStatus) throws BusinessException;
}
