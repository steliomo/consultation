/**
 *
 */
package mz.co.msaude.consultation.core.consultation.service;

import static mz.co.msaude.consultation.core.consultation.service.ConsultationQueryServiceImpl.NAME;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.consultation.dao.ConsultationDAO;
import mz.co.msaude.consultation.core.consultation.model.Consultation;
import mz.co.msaude.consultation.core.consultation.model.ConsultationStatus;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class ConsultationQueryServiceImpl implements ConsultationQueryService {

	public static final String NAME = "mz.co.msaude.consultation.core.consultation.service.ConsultationQueryServiceImpl";

	@Inject
	private ConsultationDAO consultationDAO;

	@Override
	public List<Consultation> fetchConsultationsByUserAndStatus(final UserContext context,
	        final ConsultationStatus consultationStatus) throws BusinessException {
		return this.consultationDAO.fetchByUserAndStatus(context, consultationStatus, EntityStatus.ACTIVE);
	}

}
