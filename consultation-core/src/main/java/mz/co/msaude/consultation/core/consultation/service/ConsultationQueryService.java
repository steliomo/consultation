/**
 *
 */
package mz.co.msaude.consultation.core.consultation.service;

import java.util.List;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.consultation.model.Consultation;
import mz.co.msaude.consultation.core.consultation.model.ConsultationStatus;

/**
 * @author Stélio Moiane
 *
 */
public interface ConsultationQueryService {
	List<Consultation> fetchConsultationsByUserAndStatus(final UserContext context,
	        final ConsultationStatus consultationStatus) throws BusinessException;
}
