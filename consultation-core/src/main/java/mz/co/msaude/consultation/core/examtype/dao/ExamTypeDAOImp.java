/**
 *
 */
package mz.co.msaude.consultation.core.examtype.dao;

import static mz.co.msaude.consultation.core.examtype.dao.ExamTypeDAOImp.NAME;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.consultation.core.examtype.model.ExamType;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class ExamTypeDAOImp extends GenericDAOImpl<ExamType, Long> implements ExamTypeDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.examtype.dao.ExamTypeDAOImp";

}
