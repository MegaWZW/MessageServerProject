package com.mycompany.app.message_server.core.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class RegisteredUserDTO {
	private UserDTO dto;
	private LocalDateTime registrationDate;
	private boolean idAdmin;

	public RegisteredUserDTO(UserDTO dto, LocalDateTime registrationDate, boolean idAdmin) {
		this.dto = dto;
		this.registrationDate = registrationDate;
		this.idAdmin = idAdmin;
	}

	public RegisteredUserDTO (UserDTO dto, boolean isAdmin){
		this.dto = dto;
		this.registrationDate = LocalDateTime.now();
		this.idAdmin = isAdmin;
	}

	public UserDTO getDto() {
		return dto;
	}

	public void setDto(UserDTO dto) {
		this.dto = dto;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public boolean isIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(boolean idAdmin) {
		this.idAdmin = idAdmin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RegisteredUserDTO that = (RegisteredUserDTO) o;
		return idAdmin == that.idAdmin &&
				Objects.equals(dto, that.dto) && Objects.equals(registrationDate, that.registrationDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dto, registrationDate,idAdmin);
	}

	@Override
	public String toString() {
		return "RegisteredUserDTO{" +
				"dto=" + dto.toString() +
				", registrationDate=" + registrationDate +
				", idAdmin=" + idAdmin +
				'}';
	}
}
