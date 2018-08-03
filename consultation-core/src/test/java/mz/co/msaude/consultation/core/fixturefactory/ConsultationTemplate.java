/**
 *
 */
package mz.co.msaude.consultation.core.fixturefactory;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import mz.co.msaude.boot.frameworks.util.UuidFactory;
import mz.co.msaude.consultation.core.consultation.model.Consultation;
import mz.co.msaude.consultation.core.consultation.model.ConsultationStatus;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;
import mz.co.msaude.consultation.core.doctor.model.Doctor;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;

/**
 * @author Stélio Moiane
 *
 */
public class ConsultationTemplate implements TemplateLoader {

	public static final String VALID = "VALID";

	@Override
	public void load() {
		Fixture.of(Consultation.class).addTemplate("VALID", new Rule() {
			{
				this.add("consultationType", this.one(ConsultationType.class, ConsultationTypeTemplate.VALID));
				this.add("healthFacility", this.one(HealthFacility.class, HealthFacilityTemplate.VALID));
				this.add("doctor", this.one(Doctor.class, DoctorTemplate.VALID));
				this.add("consultationDate", LocalDate.now());
				this.add("consultationTime", LocalTime.now());
				this.add("patient", UuidFactory.generate());
				this.add("consultationStatus", ConsultationStatus.PENDING);
			}
		});
	}
}
