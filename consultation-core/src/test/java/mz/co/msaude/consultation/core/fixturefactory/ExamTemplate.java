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
import mz.co.msaude.consultation.core.exam.model.Exam;
import mz.co.msaude.consultation.core.exam.model.ExamStatus;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;

/**
 * @author Stélio Moiane
 *
 */
public class ExamTemplate implements TemplateLoader {

	public static final String VALID = "VALID";

	@Override
	public void load() {

		Fixture.of(Exam.class).addTemplate(VALID, new Rule() {
			{
				this.add("medicalServiceType", this.one(MedicalServiceType.class, MedicalServiceTypeTemplate.EXAM));
				this.add("healthFacility", this.one(HealthFacility.class, HealthFacilityTemplate.VALID));
				this.add("examDate", LocalDate.now());
				this.add("examTime", LocalTime.now());
				this.add("patient", UuidFactory.generate());
				this.add("examStatus", ExamStatus.PENDING);
			}
		});
	}
}
