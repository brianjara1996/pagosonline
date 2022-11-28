package com.Challenge.PagosOnline.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="organizacion")

public class organizacion {
	
    @Getter @Setter @Column(name= "id_organizacion")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
	private int id_organizacion;
    
    
    @Getter @Setter @Column(name= "name")
    private String name;
    
    
    @Getter @Setter @Column(name= "cuit")
    private String cuit;
    
    
    @Getter @Setter @Column(name= "email")
    private String email;


	public int getId_organizacion() {
		return id_organizacion;
	}


	public String getName() {
		return name;
	}


	public String getCuit() {
		return cuit;
	}


	public String getEmail() {
		return email;
	}


	public void setId_organizacion(int id_organizacion) {
		this.id_organizacion = id_organizacion;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}


	public void setEmail(String email) {
		this.email = email;
	}
    

}
