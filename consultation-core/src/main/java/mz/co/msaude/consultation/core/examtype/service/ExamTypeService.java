/**
 *
 */
package mz.co.msaude.consultation.core.examtype.service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.examtype.model.ExamType;

/**
 * @author Stélio Moiane
 *
 */
public interface ExamTypeService {

	ExamType createExamType(final UserContext userContext, final ExamType examType) throws BusinessException;

}
