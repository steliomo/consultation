/**
 *
 */
package mz.co.msaude.consultation.core.medicalservicetype.service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;

/**
 * @author Stélio Moiane
 *
 */
public interface MedicalServiceTypeService {

	MedicalServiceType createMedicalServiceType(final UserContext userContext,
	        final MedicalServiceType medicalServiceType) throws BusinessException;

}
