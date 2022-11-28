package com.Challenge.PagosOnline.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Challenge.PagosOnline.Dao.balanceDao;
import com.Challenge.PagosOnline.Models.balance;
import com.Challenge.PagosOnline.Models.balanceRequest;
import com.Challenge.PagosOnline.Models.organizacion;


@RestController
public class balanceControllers {
	
	@Autowired
	private balanceDao BalanceDao;
	
	@RequestMapping(value = "api/balance/ingreso" , method = RequestMethod.POST)
    public Boolean ingresoDinero(@RequestBody balanceRequest  pl ){
		
		organizacion o =  new organizacion(); 
		
		o = BalanceDao.Organizacion(pl.getId_organizacion());
		
		balance bl = new balance();
		
		bl.setAmount(pl.getAmount());
		bl.setId_organizacion(o);
		
				
		return BalanceDao.registroBalance(bl);
	
	}
	
	
	@RequestMapping(value = "api/balance/egreso" , method = RequestMethod.POST)
    public Boolean egresoDinero(@RequestBody balanceRequest br ){
		
		
		organizacion o =  new organizacion(); 
		
		o = BalanceDao.Organizacion(br.getId_organizacion());
		
		balance bl = new balance();
		
		
		if(br.getAmount() > 0) {
			Double num;
			
			num = br.getAmount();
			num = num * (-1);
			
			br.setAmount(num);
		}
		
		bl.setAmount(br.getAmount());
		bl.setId_organizacion(o);
		
		
		
		return BalanceDao.registroBalance(bl);
	
	}
	
	
    @RequestMapping(value = "api/balance/consulta", method = RequestMethod.POST)
    public List<balance> consultaBalance(){
    		
		return BalanceDao.consultaBalance();
    }
    
    
    @RequestMapping(value = "api/balance/detalle", method = RequestMethod.POST)
    public List<Object> consultaBalanceDetalle(){
    		
		return BalanceDao.consultaBalanceDetalle();
    }
    

}
