/**
 *
 */
package mz.co.msaude.consultation.core.examtype.integ;

import javax.inject.Inject;

import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.util.TestUtil;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.examtype.model.ExamType;
import mz.co.msaude.consultation.core.examtype.service.ExamTypeService;
import mz.co.msaude.consultation.core.fixturefactory.ExamTypeTemplate;

/**
 * @author Stélio Moiane
 *
 */
public class ExamTypeServiceTest extends AbstractServiceTest {

	@Inject
	private ExamTypeService examTypeService;

	@Test
	public void shouldCreateExamType() throws BusinessException {
		final ExamType examType = EntityFactory.gimme(ExamType.class, ExamTypeTemplate.VALID);

		this.examTypeService.createExamType(this.getUserContext(), examType);

		TestUtil.assertCreation(examType);
	}
}
