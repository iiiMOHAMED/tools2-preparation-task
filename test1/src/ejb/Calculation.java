package ejb;


import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Stateless
@Entity
public class Calculation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 int id;
	 int num1;
	 int num2;
	 char opp;
	 double result;
	
	public Calculation(){}
	
	//operand 1
 	public void setNum1(int num) {
		this.num1=num;
	}
	public int getNum1() {
		return num1;
	}
	//operand 2
	
	public void setNum2(int num) {
		this.num2=num;
	}
	public int getNum2() {
		return num2;
	}
	//Operator sign
	public void setOpp(char ops) {
		this.opp=ops;
	}
	public char getOpp() {
		return opp;
	}
	//Result
	public void setResult (double res) {
		this.result=res;
	}
	public double getResult() {
		return result;
	} 
	public double calculate(int n1, int n2, char op) {
	    double res=0;
	    
	    switch(op) {
	        case '+':
	        	res = n1 + n2;
	            break;
	        case '-':
	        	res = n1 - n2;
	            break;
	        case '*':
	        	res = n1 * n2;
	            break;
	        case '/':
	            if (n2 != 0) {
	            	res = (double) n1 / n2;
	            } else {
	            		throw new IllegalArgumentException("Division by zero is not allowed.");//res =69; //Double.POSITIVE_INFINITY;
	            }
	            break;
	        default:
	        	throw new IllegalArgumentException("Invalid operation: " + op);//res =420; //Double.NaN; 
	    }
	    return res;
	}
	}
		

