/**
 *
 */
package mz.co.msaude.consultation.core.medicalservicetype.service;

import static mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeTypeQueryServiceImpl.NAME;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.consultation.core.medicalservicetype.dao.MedicalServiceTypeDAO;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class MedicalServiceTypeTypeQueryServiceImpl implements MedicalServiceTypeQueryService {

	public static final String NAME = "mz.co.msaude.consultation.core.medicalservicetype.service.MedicalServiceTypeTypeQueryServiceImpl";

	@Inject
	private MedicalServiceTypeDAO medicalServiceTypeDAO;

	@Override
	public List<MedicalServiceType> findMedicalServiceTypesByServiceType(final ServiceType serviceType)
	        throws BusinessException {
		return this.medicalServiceTypeDAO.findByServiceType(serviceType, EntityStatus.ACTIVE);
	}
}