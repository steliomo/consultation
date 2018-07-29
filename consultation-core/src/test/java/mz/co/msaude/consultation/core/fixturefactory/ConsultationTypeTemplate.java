/**
 *
 */
package mz.co.msaude.consultation.core.fixturefactory;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;

/**
 * @author Stélio Moiane
 *
 */
public class ConsultationTypeTemplate implements TemplateLoader {

	public static final String VALID = "VALID";

	@Override
	public void load() {
		Fixture.of(ConsultationType.class).addTemplate(VALID, new Rule() {
			{
				this.add("name", this.random("Clinica Geral", "Dermatologia", "Genecogia", "Psiquiatria"));
				this.add("description", "Esta consulta é dedica a....");
				this.add("imagePath", "/opt/url.png");
			}
		});
	}
}
