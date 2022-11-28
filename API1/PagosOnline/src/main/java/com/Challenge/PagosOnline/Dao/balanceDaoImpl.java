package com.Challenge.PagosOnline.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.Challenge.PagosOnline.Models.balance;
import com.Challenge.PagosOnline.Models.organizacion;

@Repository
@Transactional
public class balanceDaoImpl implements balanceDao {
	
    @PersistenceContext
   private EntityManager entityManager;

	@Override
	public Boolean registroBalance(balance bl) {
		
		try {
			          	
            	entityManager.merge(bl);
    			
    			return true;
			
		}
		catch(Exception e) {
			System.out.println("Error al ingresar dinero");
			return false;
		}

	}

	@Override
	public List<balance> consultaBalance() {
		
		try {
			String query = "From balance";
			
			List<balance> result =  entityManager.createQuery(query).getResultList();

		       return result;

		}
		catch(Exception e) {
			System.out.println("Error al consultar balance");
			return null;
		}
		
	}

	@Override
	public List<Object> consultaBalanceDetalle() {
		
		try {
		/*	String query = "Select balance.amount,organizacion.cuit,organizacion.email From balance "
					+ "INNER JOIN organizacion on balance.id_organizacion = organizacion.id_organizacion"; */
			
			String query = "From balance bal inner join bal.id_organizacion";
			
			List<Object> result =  entityManager.createQuery(query).getResultList();

		       return result;

		}
		catch(Exception e) {
			System.out.println("Error al consultar balance con detalle");
			return null;
		}
	}

	@Override
	public organizacion Organizacion(int id) {
		
		
		try {
			
			organizacion oo  =  new organizacion();
			
			String query = "From organizacion where id_organizacion = " + id;
			
			oo =  (organizacion) entityManager.createQuery(query).getSingleResult();

		       return oo;

		}
		catch(Exception e) {
			System.out.println("Error al consultar balance");
			return null;
		}
		
	}

}
