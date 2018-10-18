/**
 *
 */
package mz.co.msaude.consultation.core.doctor.dao;

import static mz.co.msaude.consultation.core.doctor.dao.DoctorDAOImpl.NAME;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.util.ParamBuilder;
import mz.co.msaude.consultation.core.doctor.model.Doctor;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class DoctorDAOImpl extends GenericDAOImpl<Doctor, Long> implements DoctorDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.doctor.dao.DoctorDAOImpl";

	@Override
	public List<Doctor> findAll(final EntityStatus entityStatus) throws BusinessException {
		return this.findByNamedQuery(DoctorDAO.QUERY_NAME.findAll,
		        new ParamBuilder().add("entityStatus", entityStatus).process());
	}

}
