/**
 *
 */
package mz.co.msaude.consultation.core.medicalservicetype.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import mz.co.msaude.boot.frameworks.model.GenericEntity;
import mz.co.msaude.consultation.core.medicalservicetype.dao.MedicalServiceTypeDAO;

/**
 * @author Stélio Moiane
 *
 */
@NamedQueries({
        @NamedQuery(name = MedicalServiceTypeDAO.QUERY_NAME.findByServiceType, query = MedicalServiceTypeDAO.QUERY.findByServiceType) })
@Entity
@Table(name = "MEDICAL_SERVICE_TYPES")
public class MedicalServiceType extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "NAME", nullable = false, length = 30)
	private String name;

	@NotEmpty
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@NotEmpty
	@Column(name = "IMAGE_PATH", nullable = false, length = 50)
	private String imagePath;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "SERVICE_TYPE", nullable = false, length = 30)
	private ServiceType serviceType;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(final String imagePath) {
		this.imagePath = imagePath;
	}

	public ServiceType getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(final ServiceType serviceType) {
		this.serviceType = serviceType;
	}
}
