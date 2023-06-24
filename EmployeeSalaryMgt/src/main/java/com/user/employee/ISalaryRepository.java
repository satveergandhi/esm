package com.user.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.inn.employee.model.Bonus;
import com.user.inn.employee.model.Salary;

@Repository
public interface ISalaryRepository extends JpaRepository<Salary, Integer> {

	@Query(value = "SELECT sl FROM Salary sl WHERE sl.id = ?1 ")
	public Salary findSalaryById(Integer id);

}
