package com.mycompany.app.message_server.core.dto;

import java.util.GregorianCalendar;
import java.util.Objects;

public class UserDTO {
	private String login;
	private String password;
	private String fio;
	private GregorianCalendar birthDate;

	public UserDTO(String login, String password, String fio, GregorianCalendar birthDate) {
		this.login = login;
		this.password = password;
		this.fio = fio;
		this.birthDate = birthDate;
	}

	public UserDTO(){};

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public GregorianCalendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserDTO userDTO = (UserDTO) o;
		return Objects.equals(login, userDTO.login) &&
				Objects.equals(fio, userDTO.fio) && Objects.equals(birthDate, userDTO.birthDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, fio, birthDate);
	}

	@Override
	public String toString() {
		return "UserDTO{" +
				"login='" + login + '\'' +
				", password='" + password + '\'' +
				", fio='" + fio + '\'' +
				", birthDate=" + birthDate.getTime() +
				'}';
	}
}
