/**
 *
 */
package mz.co.msaude.consultation.core.consultationtype.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import mz.co.msaude.boot.frameworks.model.GenericEntity;

/**
 * @author Stélio Moiane
 *
 */
@Entity
@Table(name = "CONSULTATION_TYPES")
public class ConsultationType extends GenericEntity {

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
}
