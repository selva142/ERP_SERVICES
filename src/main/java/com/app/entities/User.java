package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

@Table(name="COMMAUTHENTICATION")
public class User {
	@Id
	@Column(name="MAUTUSERNAME")
	private String username;
	@Column(name="MAUTPASSWORD")
	private String password;
	@Column(name="MAUTROLEID")
	private String roleid;
	@Column(name="MAUTSTATUS")
	private String status;

}
