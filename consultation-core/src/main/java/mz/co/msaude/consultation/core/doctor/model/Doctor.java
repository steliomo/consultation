/**
 *
 */
package mz.co.msaude.consultation.core.doctor.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import mz.co.msaude.boot.frameworks.model.GenericEntity;
import mz.co.msaude.consultation.core.consultationtype.model.ConsultationType;
import mz.co.msaude.consultation.core.doctor.dao.DoctorDAO;

/**
 * @author Stélio Moiane
 *
 */
@NamedQueries({ @NamedQuery(name = DoctorDAO.QUERY_NAME.findAll, query = DoctorDAO.QUERY.findAll) })
@Entity
@Table(name = "DOCTORS")
public class Doctor extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@NotEmpty
	@Column(name = "SURNAME", nullable = false, length = 50)
	private String surname;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER", nullable = false, length = 15)
	private Gender gender;

	@XmlTransient
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "DOCTOR_CONSULTATION_TYPE", joinColumns = @JoinColumn(name = "DOCTOR_ID"), inverseJoinColumns = @JoinColumn(name = "CONSULTATION_TYPE_ID"))
	private Set<ConsultationType> consultationTypes;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	public Set<ConsultationType> getConsultationTypes() {
		return this.consultationTypes;
	}
}
