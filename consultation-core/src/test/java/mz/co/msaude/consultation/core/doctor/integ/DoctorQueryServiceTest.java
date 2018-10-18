/**
 *
 */
package mz.co.msaude.consultation.core.doctor.integ;

import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.consultation.core.config.AbstractServiceTest;
import mz.co.msaude.consultation.core.doctor.model.Doctor;
import mz.co.msaude.consultation.core.doctor.service.DoctorQueryService;
import mz.co.msaude.consultation.core.doctor.service.DoctorService;
import mz.co.msaude.consultation.core.fixturefactory.DoctorTemplate;

/**
 * @author Stélio Moiane
 *
 */
public class DoctorQueryServiceTest extends AbstractServiceTest {

	@Inject
	private DoctorService doctorService;

	@Inject
	private DoctorQueryService doctorQueryService;

	@Before
	public void setup() throws BusinessException {
		final Doctor doctor = EntityFactory.gimme(Doctor.class, DoctorTemplate.VALID);
		this.doctorService.createDoctor(this.getUserContext(), doctor);
	}

	@Test
	public void shouldFindAllDoctors() throws BusinessException {
		final List<Doctor> doctors = this.doctorQueryService.findAllDoctors();
		assertFalse(doctors.isEmpty());
	}
}