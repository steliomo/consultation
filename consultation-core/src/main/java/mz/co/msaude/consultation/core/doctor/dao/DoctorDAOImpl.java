/**
 *
 */
package mz.co.msaude.consultation.core.doctor.dao;

import static mz.co.msaude.consultation.core.doctor.dao.DoctorDAOImpl.NAME;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.consultation.core.doctor.model.Doctor;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class DoctorDAOImpl extends GenericDAOImpl<Doctor, Long> implements DoctorDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.doctor.dao.DoctorDAOImpl";

}
