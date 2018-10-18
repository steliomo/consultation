/**
 *
 */
package mz.co.msaude.consultation.core.doctor.dao;

import java.util.List;

import mz.co.msaude.boot.frameworks.dao.GenericDAO;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.consultation.core.doctor.model.Doctor;

/**
 * @author Stélio Moiane
 *
 */
public interface DoctorDAO extends GenericDAO<Doctor, Long> {

	class QUERY {
		public static final String findAll = "SELECT d FROM Doctor d WHERE d.entityStatus = :entityStatus";
	}

	class QUERY_NAME {
		public static final String findAll = "Doctor.findAll";
	}

	List<Doctor> findAll(final EntityStatus entityStatus) throws BusinessException;

}
