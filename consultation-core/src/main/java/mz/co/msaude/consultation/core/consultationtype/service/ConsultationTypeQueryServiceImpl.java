/**
 *
 */
package mz.co.msaude.consultation.core.consultationtype.service;

import static mz.co.msaude.consultation.core.consultationtype.service.ConsultationTypeQueryServiceImpl.NAME;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.consultation.core.consultationtype.dao.ConsultationTypeDAO;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class ConsultationTypeQueryServiceImpl implements ConsultationTypeQueryService {

	public static final String NAME = "mz.co.msaude.consultation.core.consultationtype.integ.ConsultationTypeQueryServiceImpl";

	@Inject
	private ConsultationTypeDAO consultationTypeDAO;

	@Override
	public List<ConsultationType> findAllConsultationTypes() throws BusinessException {
		return this.consultationTypeDAO.findAll(EntityStatus.ACTIVE);
	}
}
