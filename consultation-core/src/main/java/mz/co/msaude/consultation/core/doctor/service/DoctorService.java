/**
 *
 */
package mz.co.msaude.consultation.core.doctor.service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.consultation.core.doctor.model.Doctor;

/**
 * @author Stélio Moiane
 *
 */
public interface DoctorService {

	Doctor createDoctor(final UserContext userContext, final Doctor doctor) throws BusinessException;

}
