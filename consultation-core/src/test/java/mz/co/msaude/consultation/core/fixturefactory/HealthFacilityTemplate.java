/**
 *
 */
package mz.co.msaude.consultation.core.fixturefactory;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import mz.co.msaude.boot.frameworks.util.UuidFactory;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;

/**
 * @author Stélio Moiane
 *
 */
public class HealthFacilityTemplate implements TemplateLoader {

	public static final String VALID = "VALID";

	@Override
	public void load() {
		Fixture.of(HealthFacility.class).addTemplate(VALID, new Rule() {
			{
				this.add("name", this.random("Hospital Privado de Maputp", "Clinicare", "Clinica Mbilo"));
				this.add("description",
				        "O Hospital é o lugar onde todos os doentes de dirigem a procura de tratamento");
				this.add("address", "Bairro da manga, Rua 324 - Matola");
				this.add("localityUuid", UuidFactory.generate());
				this.add("email", "steliomo@gmail.com");
				this.add("phoneNumber", "+258822546100");
				this.add("phoneNumberOptional", "+258840546824");
				this.add("imagePath", "/opt/image.png");
			}
		});
	}
}
