package com.user.employee;

import static net.logstash.logback.argument.StructuredArguments.kv;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.inn.employee.model.EmployeeDetails;
import com.user.inn.employee.model.Salary;
import com.user.inn.mail.service.MailService;
import com.user.mail.model.Mail;

@Service("SalaryServiceImpl")
public class SalaryServiceImpl implements ISalaryService {

	@Autowired
	ISalaryRepository salaryRepository;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	MailService mailservice;
	
	  private Logger log = LoggerFactory.getLogger(SalaryServiceImpl.class);


	public Salary Add(Salary salary) {
		salary.setDate(new Date());
 		EmployeeDetails e=employeeRepo.findempById(salary.getEmployee().getEmployeeId());
 		salary.setEmployee(e);
 		Mail mail=new Mail();
 		mail.setEmail("shivani.raghuvanshi@innoeye.com");
 		mail.setSalary(salary.getSalary());
 		mail.setName(e.getFirstName());
 		mailservice.SendMail(mail);
    	return salaryRepository.save(salary);
	}
	

	public Salary Update(Salary salary) throws Exception {
		try {
			salary.setDate(new Date());
			Salary sl = salaryRepository.findSalaryById(salary.getId());
			if (!Objects.isNull(sl)) {
				return salaryRepository.save(salary);
			} else {
				throw new Exception("Not Found");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String DeleteSalary(Integer id) throws Exception {
		try {
			log.info("inside method DeleteSalary ",kv("id", id));
			Salary sl  = salaryRepository.findSalaryById(id);
			log.info("inside method DeleteSalary ",kv("sl", sl));
			if (!Objects.isNull(sl)) {
				salaryRepository.deleteById(id);
				return "Salary Deleted";
			} else {
				throw new Exception("Not Found");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Salary getASingleSalary(Integer id) throws Exception {
		try {
            Salary sl = salaryRepository.findSalaryById(id);
			if (!Objects.isNull(sl)) {
				return sl;
			} else {
				throw new Exception("Not Found");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Salary> getAllEmployeeSalary() {
		return salaryRepository.findAll();
	}
	}

