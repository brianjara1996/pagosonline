package com.Challenge.PagosOnline.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.Challenge.PagosOnline.Models.usuario;

@Repository
@Transactional

public class clienteDaoImpl implements clienteDao {
	
	
    @PersistenceContext
   private EntityManager entityManager;
	

	@Override
	public usuario getCliente(int id) {
		
		usuario us = new usuario();
		
		try {
			String query = "From usuario where id_usuario = '"+ id + "'";
			
			List<Object> result =  entityManager.createQuery(query).getResultList();
			
			us = (usuario) result ;
			
			return us;
			
		}
		catch(Exception e) {
			System.out.println("Error al consultar Cliente: " + id);
			return us;
		}
	}


	@Override
	public List<usuario> getClientes() {
		
		
		try {
			String query = "From usuario";
			
			List<usuario> result =  entityManager.createQuery(query).getResultList();

		       return result;

		}
		catch(Exception e) {
			System.out.println("Error al consultar todos los Clientes");
			return null;
		}
		
	}


	@Override
	public String addCliente(usuario us) {
		
		try {
			
            entityManager.merge(us);
			
			return "Cliente Registrado";
			
		}
		catch(Exception e) {
			System.out.println("Error al registrar el Cliente");
			return "Usuario no Registrado";
		}
		
	}


	@Override
	public void deleteCliente(int id) {
		
		 usuario user =  entityManager.find(usuario.class, id);
		 
		 entityManager.remove(user);
	
	}

}
