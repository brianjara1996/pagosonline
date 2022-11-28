package com.Challenge.PagosOnline.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuario")

public class usuario {
	
    @Getter @Setter @Column(name= "id_usuario")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
	private int id_usuario;
    
    @Getter @Setter @Column(name= "firstName")
    private String firstName;
    
    @Getter @Setter @Column(name= "lastName")
    private String lastName;
    
    @Getter @Setter @Column(name= "email")
    private String email;
    
    @Getter @Setter @JoinColumn(name = "id_organizacion") @JsonIgnore @ManyToOne(fetch = FetchType.LAZY)
    private organizacion id_organizacion;
    
    

	public int getid_usuario() {
		return id_usuario;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public organizacion getId_organizacion() {
		return id_organizacion;
	}

	public void setid_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId_organizacion(organizacion id_organizacion) {
		this.id_organizacion = id_organizacion;
	}
}
