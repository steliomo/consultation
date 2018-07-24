/**
 *
 */
package mz.co.msaude.consultation.integ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Stélio Moiane
 *
 */
@SpringBootApplication
@ComponentScan({ "mz.co.msaude.consultation.core", "mz.co.msaude.consultation.integ" })
public class ConsultationIntegApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ConsultationIntegApplication.class, args);
	}
}
