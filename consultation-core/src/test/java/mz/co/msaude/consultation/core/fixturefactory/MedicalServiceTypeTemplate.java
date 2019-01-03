/**
 *
 */
package mz.co.msaude.consultation.core.fixturefactory;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;

/**
 * @author Stélio Moiane
 *
 */
public class MedicalServiceTypeTemplate implements TemplateLoader {

	public static final String CONSULTATION = "CONSULTATION";

	public static final String EXAM = "EXAM";

	@Override
	public void load() {
		Fixture.of(MedicalServiceType.class).addTemplate(CONSULTATION, new Rule() {
			{
				this.add("name", this.random("Clinica Geral", "Dermatologia", "Genecogia", "Psiquiatria"));
				this.add("description", "Esta consulta é dedica a....");
				this.add("serviceType", ServiceType.CONSULTATION);
				this.add("imagePath", "/opt/url.png");
			}
		});

		Fixture.of(MedicalServiceType.class).addTemplate(EXAM, new Rule() {
			{
				this.add("name", this.random("Hemograma", "Endoscopia digestiva alta"));
				this.add("description", "NA");
				this.add("serviceType", ServiceType.EXAM);
				this.add("imagePath", "/opt/url.png");
			}
		});
	}
}
