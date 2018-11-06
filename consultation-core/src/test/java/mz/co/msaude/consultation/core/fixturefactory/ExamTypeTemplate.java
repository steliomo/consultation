/**
 *
 */
package mz.co.msaude.consultation.core.fixturefactory;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import mz.co.msaude.consultation.core.examtype.model.ExamType;

/**
 * @author Stélio Moiane
 *
 */
public class ExamTypeTemplate implements TemplateLoader {

	public static final String VALID = "VALID";

	@Override
	public void load() {
		Fixture.of(ExamType.class).addTemplate(VALID, new Rule() {
			{
				this.add("name", this.random("Hemograma", "Endoscopia digestiva alta"));
				this.add("description", "NA");
			}
		});
	}
}
