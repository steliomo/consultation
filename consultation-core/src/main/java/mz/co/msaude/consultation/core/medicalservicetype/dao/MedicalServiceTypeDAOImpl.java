/**
 *
 */
package mz.co.msaude.consultation.core.medicalservicetype.dao;

import static mz.co.msaude.consultation.core.medicalservicetype.dao.MedicalServiceTypeDAOImpl.NAME;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.util.ParamBuilder;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class MedicalServiceTypeDAOImpl extends GenericDAOImpl<MedicalServiceType, Long>
        implements MedicalServiceTypeDAO {

	public static final String NAME = "mz.co.msaude.consultation.core.medicalservicetype.dao.MedicalServiceTypeDAOImpl";

	@Override
	public List<MedicalServiceType> findByServiceType(final ServiceType serviceType, final EntityStatus entityStatus)
	        throws BusinessException {
		return this.findByNamedQuery(MedicalServiceTypeDAO.QUERY_NAME.findByServiceType,
		        new ParamBuilder().add("serviceType", serviceType).add("entityStatus", entityStatus).process());
	}
}
