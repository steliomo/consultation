/**
 *
 */
package mz.co.msaude.consultation.core.medicalservicetype.service;

import java.util.List;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;

/**
 * @author Stélio Moiane
 *
 */
public interface MedicalServiceTypeQueryService {
	List<MedicalServiceType> findMedicalServiceTypesByServiceType(ServiceType serviceType) throws BusinessException;
}
