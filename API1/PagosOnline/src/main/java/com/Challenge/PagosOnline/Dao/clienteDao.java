package com.Challenge.PagosOnline.Dao;

import java.util.List;

import com.Challenge.PagosOnline.Models.usuario;

public interface clienteDao {
	
	usuario getCliente(int id); 
	
	List<usuario> getClientes();
	
	String addCliente(usuario us);
	
	void deleteCliente(int id);

}
