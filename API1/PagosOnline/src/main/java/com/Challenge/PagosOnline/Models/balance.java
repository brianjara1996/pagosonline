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
@Table(name="balance")

public class balance {
	
    @Getter @Setter @Column(name= "id_balance")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
	private int id_balance;
    
    @Getter @Setter @JoinColumn(name = "id_organizacion") @JsonIgnore @ManyToOne(fetch = FetchType.LAZY)
    private organizacion id_organizacion;
    
    
    @Getter @Setter @Column(name= "amount")
    private double amount;


	public int getId_balance() {
		return id_balance;
	}


	public organizacion getId_organizacion() {
		return id_organizacion;
	}


	public double getAmount() {
		return amount;
	}


	public void setId_balance(int id_balance) {
		this.id_balance = id_balance;
	}


	public void setId_organizacion(organizacion id_organizacion) {
		this.id_organizacion = id_organizacion;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


    

}
