/**
 *
 */
package mz.co.msaude.consultation.core.doctor.service;

import java.util.List;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.doctor.model.Doctor;

/**
 * @author Stélio Moiane
 *
 */
public interface DoctorQueryService {
	List<Doctor> findAllDoctors() throws BusinessException;
}
