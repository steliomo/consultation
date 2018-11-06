/**
 *
 */
package mz.co.msaude.consultation.core.examtype.service;

import static mz.co.msaude.consultation.core.examtype.service.ExamTypeServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.consultation.core.examtype.dao.ExamTypeDAO;
import mz.co.msaude.consultation.core.examtype.model.ExamType;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class ExamTypeServiceImpl extends AbstractService implements ExamTypeService {

	public static final String NAME = "mz.co.msaude.consultation.core.examtype.service.ExamTypeServiceImpl";

	@Inject
	private ExamTypeDAO examTypeDAO;

	@Override
	public ExamType createExamType(final UserContext userContext, final ExamType examType) throws BusinessException {
		return this.examTypeDAO.create(userContext, examType);
	}
}
