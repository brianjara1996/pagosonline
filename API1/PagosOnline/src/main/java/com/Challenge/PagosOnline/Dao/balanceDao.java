package com.Challenge.PagosOnline.Dao;

import java.util.List;

import com.Challenge.PagosOnline.Models.balance;
import com.Challenge.PagosOnline.Models.organizacion;

public interface balanceDao {

	Boolean registroBalance(balance bl);
	
	List<balance> consultaBalance();
	
	List<Object> consultaBalanceDetalle();
	
	organizacion Organizacion(int id);
	
	
	
}
