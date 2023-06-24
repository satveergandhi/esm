package com.user.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.employee.controller.IBonusConroller;
import com.user.inn.employee.model.Bonus;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Bonus")
@Slf4j
public class BonusController implements IBonusConroller {

	@Autowired
	private IBonusService bonusService;

	@Override
	public Bonus Add(Bonus bonus) throws Exception {
		return bonusService.Add(bonus);
	}

	@Override
	public Bonus Update(Bonus bonus) throws Exception {
		try {
			return bonusService.Update(bonus);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String DeleteSalary(Integer id) throws Exception {
		return bonusService.DeleteBonus(id);
	}

	@Override
	public Bonus getASingleBonus(Integer id) throws Exception {
		return bonusService.getASingleBonus(id);
	}

	@Override
	public List<Bonus> getAllEmployeeBonus() {
		return bonusService.getAllEmployeeBonus();
	}

}
