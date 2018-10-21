/**
 *
 */
package mz.co.msaude.consultation.core.consultation.service;

import static mz.co.msaude.consultation.core.consultation.service.ConsultationServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.consultation.core.consultation.dao.ConsultationDAO;
import mz.co.msaude.consultation.core.consultation.model.Consultation;
import mz.co.msaude.consultation.core.consultation.model.ConsultationStatus;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class ConsultationServiceImpl extends AbstractService implements ConsultationService {

	public static final String NAME = "mz.co.msaude.consultation.core.consultation.service.ConsultationServiceImpl";

	@Inject
	private ConsultationDAO consultationDAO;

	@Override
	public Consultation createConsultation(final UserContext userContext, final Consultation consultation)
	        throws BusinessException {

		consultation.setConsultationStatus(ConsultationStatus.PENDING);
		return this.consultationDAO.create(userContext, consultation);
	}

	@Override
	public Consultation updateConsultation(final UserContext userContext, final Consultation consultation)
	        throws BusinessException {

		return this.consultationDAO.update(userContext, consultation);
	}
}
