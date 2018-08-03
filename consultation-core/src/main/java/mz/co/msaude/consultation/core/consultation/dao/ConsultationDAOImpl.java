/**
 *
 */
package mz.co.msaude.consultation.core.consultation.dao;

import static mz.co.msaude.consultation.core.consultation.dao.ConsultationDAOImpl.NAME;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.consultation.core.consultation.model.Consultation;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class ConsultationDAOImpl extends GenericDAOImpl<Consultation, Long> implements ConsultationDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.consultation.dao.ConsultationDAOImpl";

}
