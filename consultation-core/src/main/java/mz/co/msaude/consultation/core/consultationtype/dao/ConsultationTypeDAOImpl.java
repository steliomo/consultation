/**
 *
 */
package mz.co.msaude.consultation.core.consultationtype.dao;

import static mz.co.msaude.consultation.core.consultationtype.dao.ConsultationTypeDAOImpl.NAME;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class ConsultationTypeDAOImpl extends GenericDAOImpl<ConsultationType, Long> implements ConsultationTypeDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.consultationtype.dao.ConsultationTypeDAOImpl";

}
