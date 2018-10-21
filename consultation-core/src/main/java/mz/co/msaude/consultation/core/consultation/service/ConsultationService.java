/**
 *
 */
package mz.co.msaude.consultation.core.consultation.service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.consultation.model.Consultation;

/**
 * @author Stélio Moiane
 *
 */
public interface ConsultationService {

	Consultation createConsultation(final UserContext userContext, final Consultation consultation)
	        throws BusinessException;

	Consultation updateConsultation(final UserContext userContext, final Consultation consultation)
	        throws BusinessException;
}
