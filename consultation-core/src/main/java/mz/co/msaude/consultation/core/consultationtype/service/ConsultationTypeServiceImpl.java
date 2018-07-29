/**
 *
 */
package mz.co.msaude.consultation.core.consultationtype.service;

import static mz.co.msaude.consultation.core.consultationtype.service.ConsultationTypeServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.consultation.core.consultationtype.dao.ConsultationTypeDAO;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class ConsultationTypeServiceImpl extends AbstractService implements ConsultationTypeService {

	public static final String NAME = "mz.co.msaude.consultation.core.consultationtype.service.ConsultationTypeServiceImpl";

	@Inject
	private ConsultationTypeDAO consultationTypeDAO;

	@Override
	public ConsultationType createConsultationType(final UserContext userContext,
	        final ConsultationType consultationType) throws BusinessException {
		return this.consultationTypeDAO.create(userContext, consultationType);
	}
}
