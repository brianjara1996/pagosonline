package com.Challenge.PagosOnline.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Challenge.PagosOnline.Dao.clienteDao;
import com.Challenge.PagosOnline.Models.usuario;

@RestController
public class clienteController {
	
	@Autowired
	private clienteDao ClienteDao;
	
	
    @RequestMapping(value = "api/cliente/{id}", method = RequestMethod.GET)
    public Object getCliente(@PathVariable int id){
    	
		return ClienteDao.getCliente(id);
    }
    
    
    @RequestMapping(value = "api/cliente/listado", method = RequestMethod.POST)
    public List<usuario> getClientes(){
    		
		return ClienteDao.getClientes();
    }
    
    
    @RequestMapping(value = "api/cliente/add" , method = RequestMethod.POST)
    public String addCliente(@RequestBody usuario us ){

    	return ClienteDao.addCliente(us);
    	
    }
    
    
    
    @RequestMapping(value = "api/cliente/delete/{id}" , method = RequestMethod.GET)
    public void deleteCliente(@PathVariable int id){
    	
    	ClienteDao.deleteCliente(id);
    	
    }
   	
    	
    
    
    

}
