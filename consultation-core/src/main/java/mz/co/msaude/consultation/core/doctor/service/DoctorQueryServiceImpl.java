/**
 *
 */
package mz.co.msaude.consultation.core.doctor.service;

import static mz.co.msaude.consultation.core.doctor.service.DoctorQueryServiceImpl.NAME;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.consultation.core.doctor.dao.DoctorDAO;
import mz.co.msaude.consultation.core.doctor.model.Doctor;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class DoctorQueryServiceImpl implements DoctorQueryService {

	public static final String NAME = "mz.co.msaude.consultation.core.doctor.service.DoctorQueryServiceImpl";

	@Inject
	private DoctorDAO doctorDAO;

	@Override
	public List<Doctor> findAllDoctors() throws BusinessException {
		return this.doctorDAO.findAll(EntityStatus.ACTIVE);
	}

}
