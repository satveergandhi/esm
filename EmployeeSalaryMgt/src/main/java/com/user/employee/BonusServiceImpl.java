package com.user.employee;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.inn.employee.model.Bonus;
import com.user.inn.employee.model.EmployeeDetails;
import com.user.inn.employee.model.Salary;

@Service("BonusServiceImpl")
public class BonusServiceImpl implements IBonusService {

	@Autowired
	private IBonusRepository bonusRepository;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	

	@Override
//	public Bonus Add(Bonus bonus) {
//		Bonus bonusNew = new Bonus();
//		bonusNew.setDate(new Date());
//		bonusNew.setBonus(bonus.getBonus());
//	    bonusNew.setEmployee(bonus.getEmployee());
//		return bonusRepository.save(bonusNew);
//	}
	
	public Bonus Add(Bonus bonus) throws Exception {
		try {
			bonus.setDate(new Date());
			EmployeeDetails e=employeeRepo.findempById(bonus.getEmployee().getEmployeeId());
	 		bonus.setEmployee(e);
		return bonusRepository.save(bonus);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public Bonus Update(Bonus bonus) throws Exception {
		try {
			bonus.setDate(new Date());
			Bonus bn = bonusRepository.findBonusById(bonus.getId());
			if (!Objects.isNull(bn)) {
				return bonusRepository.save(bonus);
			} else {
				throw new Exception("Not Found");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String DeleteBonus(Integer id) throws Exception {
		try {
			Bonus bn = bonusRepository.findBonusById(id);
			if (!Objects.isNull(bn)) {
				bonusRepository.deleteById(id);
				return "Bonus Deleted";
			} else {
				throw new Exception("Not Found");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Bonus getASingleBonus(Integer id) throws Exception {
		try {
			Bonus bn = bonusRepository.findBonusById(id);
			if (!Objects.isNull(bn))  {
				return bonusRepository.findById(id).get();
			} else {
				throw new Exception("Not Found");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Bonus> getAllEmployeeBonus() {
		return bonusRepository.findAll();
	}
}
