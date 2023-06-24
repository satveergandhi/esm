package com.user.employee;

import java.util.List;
import java.util.Optional;

import com.user.inn.employee.model.Bonus;

public interface IBonusService {

	public Bonus Add(Bonus bonus) throws Exception;

	public Bonus Update(Bonus bonus) throws Exception;
	
	public String DeleteBonus(Integer id) throws Exception;
	
	public Bonus getASingleBonus(Integer id) throws Exception;
	
	public List<Bonus> getAllEmployeeBonus();
}
