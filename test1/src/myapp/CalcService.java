package myapp;



import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.Calculation;


@Stateless
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalcService {

@PersistenceContext(unitName="mo")	
private EntityManager em;	

@POST
@Path("calc")
public double createCalculation(Calculation y) {
	int num1=y.getNum1(); 
	int num2=y.getNum2();
	char op=y.getOpp();
	double res=y.calculate(num1,num2,op);
	y.setResult(res);
	em.persist(y);
	return y.getResult();
} 

@GET
@Path("calculations")
public List<Calculation> getCalculation() {
	
	return em.createQuery("SELECT c from Calculation c",Calculation.class).getResultList();
	  
}


}
