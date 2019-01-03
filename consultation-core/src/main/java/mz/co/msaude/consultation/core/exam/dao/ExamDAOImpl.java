/**
 *
 */
package mz.co.msaude.consultation.core.exam.dao;

import static mz.co.msaude.consultation.core.exam.dao.ExamDAOImpl.NAME;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.util.ParamBuilder;
import mz.co.msaude.consultation.core.exam.model.Exam;
import mz.co.msaude.consultation.core.exam.model.ExamStatus;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class ExamDAOImpl extends GenericDAOImpl<Exam, Long> implements ExamDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.exam.dao.ExamDAOImpl";

	@Override
	public List<Exam> fetchByUserAndStatus(final UserContext userContext, final ExamStatus examStatus,
	        final EntityStatus entityStatus) throws BusinessException {

		return this.findByNamedQuery(ExamDAO.QUERY_NAME.fetchByUserAndStatus,
		        new ParamBuilder().add("userUuid", userContext.getUuid()).add("examStatus", examStatus)
		                .add("entityStatus", entityStatus).process());
	}
}
