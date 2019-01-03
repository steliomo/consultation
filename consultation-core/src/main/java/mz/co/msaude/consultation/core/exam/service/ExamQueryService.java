/**
 *
 */
package mz.co.msaude.consultation.core.exam.service;

import java.util.List;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.exam.model.Exam;
import mz.co.msaude.consultation.core.exam.model.ExamStatus;

/**
 * @author Stélio Moiane
 *
 */
public interface ExamQueryService {

	List<Exam> fecthExamByUserAndStatus(UserContext userContext, ExamStatus examStatus) throws BusinessException;

}
