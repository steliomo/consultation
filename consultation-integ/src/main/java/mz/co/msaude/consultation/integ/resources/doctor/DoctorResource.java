/**
 *
 */
package mz.co.msaude.consultation.integ.resources.doctor;

import static mz.co.msaude.consultation.integ.resources.doctor.DoctorResource.NAME;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.consultation.core.doctor.model.Doctor;
import mz.co.msaude.consultation.core.doctor.service.DoctorQueryService;
import mz.co.msaude.consultation.core.doctor.service.DoctorService;
import mz.co.msaude.consultation.integ.resources.AbstractResource;

/**
 * @author Stélio Moiane
 *
 */
@Path("doctors")
@Service(NAME)
public class DoctorResource extends AbstractResource {

	public static final String NAME = "mz.co.msaude.consultation.integ.resources.doctor.DoctorResource";

	@Inject
	private DoctorService doctorService;

	@Inject
	private DoctorQueryService doctorQueryService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createDoctor(final Doctor doctor) throws BusinessException {

		this.doctorService.createDoctor(this.getContext(), doctor);

		return Response.ok(doctor).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllDoctors() throws BusinessException {

		final List<Doctor> doctors = this.doctorQueryService.findAllDoctors();

		return Response.ok(doctors).build();
	}
}
