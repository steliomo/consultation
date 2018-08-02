/**
 *
 */
package mz.co.msaude.consultation.core.fixturefactory;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import mz.co.msaude.consultation.core.doctor.model.Doctor;
import mz.co.msaude.consultation.core.doctor.model.Gender;

/**
 * @author Stélio Moiane
 *
 */
public class DoctorTemplate implements TemplateLoader {

	public static final String VALID = "VALID";

	@Override
	public void load() {

		Fixture.of(Doctor.class).addTemplate(VALID, new Rule() {
			{
				this.add("name", this.random("Nailah", "Kamilah", "Alima"));
				this.add("surname", "Moiane");
				this.add("gender", Gender.FEMALE);
			}
		});

	}
}
