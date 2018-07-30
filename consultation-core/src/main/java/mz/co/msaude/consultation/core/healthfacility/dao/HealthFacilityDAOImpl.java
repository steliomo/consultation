/**
 *
 */
package mz.co.msaude.consultation.core.healthfacility.dao;

import static mz.co.msaude.consultation.core.healthfacility.dao.HealthFacilityDAOImpl.NAME;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class HealthFacilityDAOImpl extends GenericDAOImpl<HealthFacility, Long> implements HealthFacilityDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.healthfacility.dao.HealthFacilityDAOImpl";

}
