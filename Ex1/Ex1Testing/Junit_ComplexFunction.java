package Ex1.Ex1Testing;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import myMath.*;

public class Junit_ComplexFunction {
	static ArrayList<function> Init() {
		ArrayList<function> funcList = new ArrayList<function>();

		Monom m1 = new Monom(0,4);
		Monom m2 = new Monom(1,7);
		Monom m3 = new Monom("5x^6");
		Monom m4 = new Monom("8");
		Monom m5 = new Monom(30,2);

		Polynom p1 = new Polynom("x^2+4x");
		Polynom p2 = new Polynom("x");
		Polynom p3 = new Polynom("9x");
		Polynom p4 = new Polynom();
		Polynom p5 = new Polynom("6x^9+5x^6+4x^3+2");

		ComplexFunction cf1 = new ComplexFunction("mul",p2,p1);
		ComplexFunction cf2 = new ComplexFunction("mul",new Monom("4"),p1);
		ComplexFunction cf3 = new ComplexFunction("divid",p1,p2);
		ComplexFunction cf4 = new ComplexFunction();
		ComplexFunction cf5 = new ComplexFunction(Operation.Plus,p5,p1);

		ComplexFunction ccf1 = new ComplexFunction("mul",p2,cf2);
		ComplexFunction ccf2 = new ComplexFunction("none",ccf1,m5);
		ComplexFunction ccf3 = new ComplexFunction(Operation.Max,ccf1,m5);
		ComplexFunction ccf4 = new ComplexFunction(Operation.Times,ccf3,p4);
		ComplexFunction ccf5 = new ComplexFunction(Operation.Times,ccf1,p5);

		funcList.add(m1);
		funcList.add(m2);
		funcList.add(m3);
		funcList.add(m4);
		funcList.add(m5);
		funcList.add(p1);
		funcList.add(p2);
		funcList.add(p3);
		funcList.add(p4);
		funcList.add(p5);
		funcList.add(cf1);
		funcList.add(cf2);
		funcList.add(cf3);
		funcList.add(cf4);
		funcList.add(cf5);
		funcList.add(ccf1);
		funcList.add(ccf2);
		funcList.add(ccf3);
		funcList.add(ccf4);
		funcList.add(ccf5);

		return funcList;
	}

	@Test
	public void ComplexConstructor1(){ 
		ArrayList<function> functions = Init();
		Random rand = new Random();
		int randomNum = rand.nextInt((functions.size()-1) + 1);
		int randomNum2 = rand.nextInt((functions.size()-1) + 1);
		ComplexFunction CFtest = new ComplexFunction("div",functions.get(randomNum),functions.get(randomNum2));
		assertTrue(CFtest.getOp() == Operation.Divid);

	}		

	@Test
	void FailComplexConstructor1() {
		ArrayList<function> functions = Init();
		Random rand = new Random();
		int randomNum = rand.nextInt((functions.size()-1) + 1);
		int randomNum2 = rand.nextInt((functions.size()-1) + 1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ComplexFunction CFtest = new ComplexFunction("dsiv",functions.get(randomNum),functions.get(randomNum2));
		});
	}

	@Test
	public void ComplexConstructor2(){ 
		ArrayList<function> functions = Init();
		Random rand = new Random();
		int randomNum = rand.nextInt((functions.size()-1) + 1);
		int randomNum2 = rand.nextInt((functions.size()-1) + 1);
		ComplexFunction CFtest = new ComplexFunction(Operation.Times,functions.get(randomNum),functions.get(randomNum2));
		assertTrue(CFtest.getOp() == Operation.Times);
	}		

	@Test
	public void CopyandtoStringTest(){ 
		ArrayList<function> functions = Init();
		Functions_GUI ans = new Functions_GUI();
		Functions_GUI ans1 = new Functions_GUI();
		Random rand = new Random();
		int randomNum = rand.nextInt((functions.size()) + 1);
		int randomNum2 = rand.nextInt((functions.size()) + 1);
		ComplexFunction CFtest = new ComplexFunction("div",functions.get(randomNum),functions.get(randomNum2));
		ans.add(CFtest.copy());
		ans1.add(CFtest);
		assertTrue(ans.toString().equals(ans1.toString()));

	}		

	@Test
	public void ComplexConstructor3(){ 
		ArrayList<function> functions = Init();
		Random rand = new Random();
		int randomNum = rand.nextInt((functions.size()-1) + 1);
		int randomNum2 = rand.nextInt((functions.size()-1) + 1);
		ComplexFunction CFtest = new ComplexFunction("div",functions.get(randomNum),functions.get(randomNum2));
		

	}	
}
