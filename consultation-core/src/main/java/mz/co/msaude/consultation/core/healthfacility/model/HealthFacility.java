/**
 *
 */
package mz.co.msaude.consultation.core.healthfacility.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import mz.co.msaude.boot.frameworks.model.GenericEntity;

/**
 * @author Stélio Moiane
 *
 */
@Entity
@Table(name = "HEALTH_FACILITIES")
public class HealthFacility extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "NAME", nullable = false, length = 30)
	private String name;

	@NotEmpty
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@NotEmpty
	@Column(name = "ADDRESS", nullable = false, length = 150)
	private String address;

	@NotEmpty
	@Column(name = "LOCALITY_UUID", nullable = false, length = 50)
	private String localityUuid;

	@Email
	@Column(name = "EMAIL", length = 50)
	private String email;

	@NotEmpty
	@Column(name = "PHONE_NUMBER", nullable = false, length = 20)
	private String phoneNumber;

	@Column(name = "PHONE_NUMBER_OPTIONAL", length = 20)
	private String phoneNumberOptional;

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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getLocalityUuid() {
		return this.localityUuid;
	}

	public void setLocalityUuid(final String localityUuid) {
		this.localityUuid = localityUuid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumberOptional() {
		return this.phoneNumberOptional;
	}

	public void setPhoneNumberOptional(final String phoneNumberOptional) {
		this.phoneNumberOptional = phoneNumberOptional;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(final String imagePath) {
		this.imagePath = imagePath;
	}
}
