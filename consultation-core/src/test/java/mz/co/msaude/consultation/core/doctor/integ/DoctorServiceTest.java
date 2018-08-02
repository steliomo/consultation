/**
 *
 */
package mz.co.msaude.consultation.core.doctor.integ;

import javax.inject.Inject;

import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.util.TestUtil;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.doctor.model.Doctor;
import mz.co.msaude.consultation.core.doctor.service.DoctorService;
import mz.co.msaude.consultation.core.fixturefactory.DoctorTemplate;

/**
 * @author Stélio Moiane
 *
 */
public class DoctorServiceTest extends AbstractServiceTest {

	@Inject
	private DoctorService doctorService;

	@Test
	public void shouldCreateDoctor() throws BusinessException {
		final Doctor doctor = EntityFactory.gimme(Doctor.class, DoctorTemplate.VALID);

		this.doctorService.createDoctor(this.getUserContext(), doctor);

		TestUtil.assertCreation(doctor);
	}
}
