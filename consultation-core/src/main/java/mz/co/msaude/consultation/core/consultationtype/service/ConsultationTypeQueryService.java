/**
 *
 */
package mz.co.msaude.consultation.core.consultationtype.service;

import java.util.List;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;

/**
 * @author Stélio Moiane
 *
 */
public interface ConsultationTypeQueryService {
	List<ConsultationType> findAllConsultationTypes() throws BusinessException;
}
