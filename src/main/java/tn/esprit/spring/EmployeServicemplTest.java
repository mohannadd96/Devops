package tn.esprit.spring;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServicemplTest {
	
	@Autowired
	IEmployeService us;
	
	private static final Logger l = LogManager.getLogger(EmployeServicemplTest.class);
	@Test
	public void testRetrieveUser() {
	List<Employe> employe = us.getAllEmployes();
	l.info("retrieveEmployer : "+ employe);
	}
	
	@After("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint)
	{
	String name = joinPoint.getSignature().getName();
	l.info("Out of method : " + name );
	}

}
