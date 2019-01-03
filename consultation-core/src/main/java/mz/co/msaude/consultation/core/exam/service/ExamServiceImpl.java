/**
 *
 */
package mz.co.msaude.consultation.core.exam.service;

import static mz.co.msaude.consultation.core.exam.service.ExamServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.consultation.core.exam.dao.ExamDAO;
import mz.co.msaude.consultation.core.exam.model.Exam;
import mz.co.msaude.consultation.core.exam.model.ExamStatus;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class ExamServiceImpl extends AbstractService implements ExamService {

	public static final String NAME = "mz.co.msaude.consultation.core.exam.service.ExamServiceImpl";

	@Inject
	private ExamDAO examDAO;

	@Override
	public Exam scheduleExam(final UserContext userContext, final Exam exam) throws BusinessException {

		if (!ServiceType.EXAM.equals(exam.getMedicalServiceType().getServiceType())) {
			throw new BusinessException("medical.service.type.invalid");
		}

		exam.setExamStatus(ExamStatus.PENDING);

		return this.examDAO.create(userContext, exam);
	}
}
