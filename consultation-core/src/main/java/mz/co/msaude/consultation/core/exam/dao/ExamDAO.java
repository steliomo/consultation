/**
 *
 */
package mz.co.msaude.consultation.core.exam.dao;

import java.util.List;

import mz.co.msaude.boot.frameworks.dao.GenericDAO;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.exam.model.Exam;
import mz.co.msaude.consultation.core.exam.model.ExamStatus;

/**
 * @author Stélio Moiane
 *
 */
public interface ExamDAO extends GenericDAO<Exam, Long> {

	class QUERY {
		public static final String fetchByUserAndStatus = "SELECT e FROM Exam e INNER JOIN FETCH e.medicalServiceType INNER JOIN FETCH e.healthFacility WHERE e.createdBy = :userUuid AND e.examStatus = :examStatus AND e.entityStatus = :entityStatus";
	}

	class QUERY_NAME {
		public static final String fetchByUserAndStatus = "Exam.fetchByUserAndStatus";
	}

	List<Exam> fetchByUserAndStatus(UserContext userContext, ExamStatus examStatus, EntityStatus entityStatus)
	        throws BusinessException;
}
