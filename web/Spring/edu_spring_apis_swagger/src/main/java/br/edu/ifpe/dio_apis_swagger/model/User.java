package br.edu.ifpe.dio_apis_swagger.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	
	private String id;
	private String login;
	private String password;
	
	public User() {
		super();
	}
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
}
