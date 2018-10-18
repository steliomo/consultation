/**
 *
 */
package mz.co.msaude.consultation.core.consultationtype.dao;

import static mz.co.msaude.consultation.core.consultationtype.dao.ConsultationTypeDAOImpl.NAME;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.util.ParamBuilder;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class ConsultationTypeDAOImpl extends GenericDAOImpl<ConsultationType, Long> implements ConsultationTypeDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.consultationtype.dao.ConsultationTypeDAOImpl";

	@Override
	public List<ConsultationType> findAll(final EntityStatus entityStatus) throws BusinessException {
		return this.findByNamedQuery(ConsultationTypeDAO.QUERY_NAME.findAll,
		        new ParamBuilder().add("entityStatus", entityStatus).process());
	}

}
