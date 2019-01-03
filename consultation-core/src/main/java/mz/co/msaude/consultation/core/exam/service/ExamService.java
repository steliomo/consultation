/**
 *
 */
package mz.co.msaude.consultation.core.exam.service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.exam.model.Exam;

/**
 * @author Stélio Moiane
 *
 */
public interface ExamService {

	Exam scheduleExam(UserContext userContext, Exam exam) throws BusinessException;
}
