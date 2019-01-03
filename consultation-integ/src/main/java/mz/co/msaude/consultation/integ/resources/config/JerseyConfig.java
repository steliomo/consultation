/**
 *
 */
package mz.co.msaude.consultation.integ.resources.config;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Service;

import mz.co.msaude.consultation.integ.resources.consultation.ConsultationResource;
import mz.co.msaude.consultation.integ.resources.doctor.DoctorResource;
import mz.co.msaude.consultation.integ.resources.exam.ExamResource;
import mz.co.msaude.consultation.integ.resources.healthfacility.HealthFacilityResource;
import mz.co.msaude.consultation.integ.resources.medicalservicetype.MedicalServiceTypeResource;
import mz.co.msaude.consultation.integ.resources.util.FilesResource;

/**
 * @author Stélio Moiane
 *
 */
@Service
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		this.register(MedicalServiceTypeResource.class);
		this.register(HealthFacilityResource.class);
		this.register(DoctorResource.class);
		this.register(ConsultationResource.class);
		this.register(MultiPartFeature.class);
		this.register(FilesResource.class);
		this.register(ExamResource.class);
	}
}
