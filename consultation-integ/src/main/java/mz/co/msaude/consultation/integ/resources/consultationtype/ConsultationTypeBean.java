/**
 *
 */
package mz.co.msaude.consultation.integ.resources.consultationtype;

import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;
import mz.co.msaude.consultation.integ.resources.BeanResource;

/**
 * @author Stélio Moiane
 *
 */
public class ConsultationTypeBean extends BeanResource {

	private static final long serialVersionUID = 1L;

	private ConsultationType consultationType;

	public ConsultationType getConsultationType() {
		return this.consultationType;
	}
}
