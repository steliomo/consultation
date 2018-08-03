/**
 *
 */
package mz.co.msaude.consultation.core.consultation.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import mz.co.msaude.boot.frameworks.model.GenericEntity;
import mz.co.msaude.boot.frameworks.util.LocalDateAdapter;
import mz.co.msaude.boot.frameworks.util.LocalTimeAdapter;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;
import mz.co.msaude.consultation.core.doctor.model.Doctor;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;

/**
 * @author Stélio Moiane
 *
 */
@Entity
@Table(name = "CONSULTATIONS")
public class Consultation extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONSULTATION_TYPE_ID", nullable = false)
	private ConsultationType consultationType;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FACILITY_ID", nullable = false)
	private HealthFacility healthFacility;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_ID", nullable = false)
	private Doctor doctor;

	@NotNull
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@Column(name = "CONSULTATION_DATE", nullable = false)
	private LocalDate consultationDate;

	@XmlJavaTypeAdapter(LocalTimeAdapter.class)
	@Column(name = "CONSULTATION_TIME")
	private LocalTime consultationTime;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "CONSULTATION_STATUS", nullable = false)
	private ConsultationStatus consultationStatus;

	@NotNull
	@Column(name = "PATIENT_UUID", nullable = false, length = 50)
	private String patient;

	public ConsultationType getConsultationType() {
		return this.consultationType;
	}

	public void setConsultationType(final ConsultationType consultationType) {
		this.consultationType = consultationType;
	}

	public HealthFacility getHealthFacility() {
		return this.healthFacility;
	}

	public void setHealthFacility(final HealthFacility healthFacility) {
		this.healthFacility = healthFacility;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(final Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDate getConsultationDate() {
		return this.consultationDate;
	}

	public void setConsultationDate(final LocalDate consultationDate) {
		this.consultationDate = consultationDate;
	}

	public LocalTime getConsultationTime() {
		return this.consultationTime;
	}

	public void setConsultationTime(final LocalTime consultationTime) {
		this.consultationTime = consultationTime;
	}

	public ConsultationStatus getConsultationStatus() {
		return this.consultationStatus;
	}

	public void setConsultationStatus(final ConsultationStatus consultationStatus) {
		this.consultationStatus = consultationStatus;
	}

	public String getPatient() {
		return this.patient;
	}

	public void setPatient(final String patient) {
		this.patient = patient;
	}
}
