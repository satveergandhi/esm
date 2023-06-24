package com.user.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.inn.employee.model.Bonus;
import com.user.inn.employee.model.Salary;

@Repository
public interface IBonusRepository extends JpaRepository<Bonus, Integer>{


	@Query(value = "SELECT bn FROM Bonus bn WHERE bn.id = ?1 ")
	public Bonus findBonusById(Integer id);
}
