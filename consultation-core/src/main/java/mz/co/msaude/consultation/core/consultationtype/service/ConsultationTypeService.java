/**
 *
 */
package mz.co.msaude.consultation.core.consultationtype.service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;

/**
 * @author Stélio Moiane
 *
 */
public interface ConsultationTypeService {

	ConsultationType createConsultationType(final UserContext userContext, final ConsultationType consultationType)
	        throws BusinessException;

}
