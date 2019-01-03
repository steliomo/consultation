/**
 *
 */
package mz.co.msaude.consultation.core.exam.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.GenericEntity;
import mz.co.msaude.boot.frameworks.util.LocalDateAdapter;
import mz.co.msaude.boot.frameworks.util.LocalTimeAdapter;
import mz.co.msaude.consultation.core.exam.dao.ExamDAO;
import mz.co.msaude.consultation.core.healthfacility.model.HealthFacility;
import mz.co.msaude.consultation.core.medicalservicetype.model.MedicalServiceType;
import mz.co.msaude.consultation.core.medicalservicetype.model.ServiceType;

/**
 * @author Stélio Moiane
 *
 */
@NamedQueries({
        @NamedQuery(name = ExamDAO.QUERY_NAME.fetchByUserAndStatus, query = ExamDAO.QUERY.fetchByUserAndStatus) })
@Entity
@Table(name = "EXAMS")
public class Exam extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEDICAL_SERVICE_TYPE_ID", nullable = false)
	private MedicalServiceType medicalServiceType;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FACILITY_ID", nullable = false)
	private HealthFacility healthFacility;

	@NotNull
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@Column(name = "EXAM_DATE", nullable = false)
	private LocalDate examDate;

	@XmlJavaTypeAdapter(LocalTimeAdapter.class)
	@Column(name = "EXAM_TIME")
	private LocalTime examTime;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "EXAM_STATUS", nullable = false, length = 30)
	private ExamStatus examStatus;

	@NotNull
	@Column(name = "PATIENT_UUID", nullable = false, length = 50)
	private String patient;

	public MedicalServiceType getMedicalServiceType() {
		return this.medicalServiceType;
	}

	public void setMedicalServiceType(final MedicalServiceType medicalServiceType) throws BusinessException {

		if (!ServiceType.EXAM.equals(medicalServiceType.getServiceType())) {
			throw new BusinessException("The service type is invalid for the exam....");
		}

		this.medicalServiceType = medicalServiceType;
	}

	public HealthFacility getHealthFacility() {
		return this.healthFacility;
	}

	public void setHealthFacility(final HealthFacility healthFacility) {
		this.healthFacility = healthFacility;
	}

	public LocalDate getExamDate() {
		return this.examDate;
	}

	public void setExamDate(final LocalDate examDate) {
		this.examDate = examDate;
	}

	public LocalTime getExamTime() {
		return this.examTime;
	}

	public void setExamTime(final LocalTime examTime) {
		this.examTime = examTime;
	}

	public ExamStatus getExamStatus() {
		return this.examStatus;
	}

	public void setExamStatus(final ExamStatus examStatus) {
		this.examStatus = examStatus;
	}

	public String getPatient() {
		return this.patient;
	}

	public void setPatient(final String patient) {
		this.patient = patient;
	}
}
