/**
 *
 */
package mz.co.msaude.consultation.core.consultation.dao;

import static mz.co.msaude.consultation.core.consultation.dao.ConsultationDAOImpl.NAME;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.util.ParamBuilder;
import mz.co.msaude.consultation.core.consultation.model.Consultation;
import mz.co.msaude.consultation.core.consultation.model.ConsultationStatus;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class ConsultationDAOImpl extends GenericDAOImpl<Consultation, Long> implements ConsultationDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.consultation.dao.ConsultationDAOImpl";

	@Override
	public List<Consultation> fetchByUserAndStatus(final UserContext context,
	        final ConsultationStatus consultationStatus, final EntityStatus entityStatus) throws BusinessException {

		return this.findByNamedQuery(ConsultationDAO.QUERY_NAME.fetchByPatientAndStatus,
		        new ParamBuilder().add("userUuid", context.getUuid()).add("consultationStatus", consultationStatus)
		                .add("entityStatus", entityStatus).process());
	}

}
