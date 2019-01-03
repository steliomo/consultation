/**
 *
 */
package mz.co.msaude.consultation.core.medicalservicetype.service;

import static mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeTypeServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.consultation.core.medicalservicetype.dao.MedicalServiceTypeDAO;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class MedicalServiceTypeTypeServiceImpl extends AbstractService implements MedicalServiceTypeService {

	public static final String NAME = "mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeTypeServiceImpl";

	@Inject
	private MedicalServiceTypeDAO medicalServiceTypeDAO;

	@Override
	public MedicalServiceType createMedicalServiceType(final UserContext userContext,
	        final MedicalServiceType medicalServiceType) throws BusinessException {
		return this.medicalServiceTypeDAO.create(userContext, medicalServiceType);
	}
}
