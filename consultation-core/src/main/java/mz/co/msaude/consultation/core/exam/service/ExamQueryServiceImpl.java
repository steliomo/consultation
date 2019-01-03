/**
 *
 */
package mz.co.msaude.consultation.core.exam.service;

import static mz.co.msaude.consultation.core.exam.service.ExamQueryServiceImpl.NAME;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.exam.dao.ExamDAO;
import mz.co.msaude.consultation.core.exam.model.Exam;
import mz.co.msaude.consultation.core.exam.model.ExamStatus;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class ExamQueryServiceImpl implements ExamQueryService {

	public static final String NAME = "mz.co.msaude.consultation.core.exam.service.ExamQueryServiceImpl";

	@Inject
	private ExamDAO examDAO;

	@Override
	public List<Exam> fecthExamByUserAndStatus(final UserContext userContext, final ExamStatus examStatus)
	        throws BusinessException {
		return this.examDAO.fetchByUserAndStatus(userContext, examStatus, EntityStatus.ACTIVE);
	}
}
