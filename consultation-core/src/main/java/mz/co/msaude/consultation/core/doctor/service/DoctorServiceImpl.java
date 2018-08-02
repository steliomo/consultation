/**
 *
 */
package mz.co.msaude.consultation.core.doctor.service;

import static mz.co.msaude.consultation.core.doctor.service.DoctorServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.consultation.core.doctor.dao.DoctorDAO;
import mz.co.msaude.consultation.core.doctor.model.Doctor;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class DoctorServiceImpl extends AbstractService implements DoctorService {

	public static final String NAME = "mz.co.msaude.consultation.core.doctor.service.DoctorServiceImpl";

	@Inject
	private DoctorDAO doctorDAO;

	@Override
	public Doctor createDoctor(final UserContext userContext, final Doctor doctor) throws BusinessException {
		return this.doctorDAO.create(userContext, doctor);
	}
}
