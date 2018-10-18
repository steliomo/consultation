/**
 *
 */
package mz.co.msaude.consultation.core.consultation.dao;

import java.util.List;

import mz.co.msaude.boot.frameworks.dao.GenericDAO;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.consultation.model.Consultation;
import mz.co.msaude.consultation.core.consultation.model.ConsultationStatus;

/**
 * @author Stélio Moiane
 *
 */
public interface ConsultationDAO extends GenericDAO<Consultation, Long> {

	class QUERY {
		public static final String fetchByPatientAndStatus = "SELECT c FROM Consultation c "
		        + "INNER JOIN FETCH c.consultationType INNER JOIN FETCH c.healthFacility "
		        + "INNER JOIN FETCH c.doctor "
		        + "WHERE c.createdBy = :userUuid AND c.consultationStatus = :consultationStatus "
		        + "AND c.entityStatus = :entityStatus ORDER BY c.consultationDate DESC";
	}

	class QUERY_NAME {
		public static final String fetchByPatientAndStatus = "ConsultationType.fetchByPatientAndStatus";
	}

	List<Consultation> fetchByUserAndStatus(final UserContext context, final ConsultationStatus consultationStatus,
	        final EntityStatus entityStatus) throws BusinessException;
}
