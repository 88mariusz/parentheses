package parentheses;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CheckerTest {

	@Test
	public void testNoneParenteses(){
		//given
		String calc = "1+2-3";		
		Checker checker = new Checker();
		
		//when
		boolean result = checker.check(calc);
		
		//then		
		assertTrue(result);
	}
	
	@Test
	public void testParentheses(){
		//given
		String calc = "1+(2-3)";		
		Checker checker = new Checker();
		
		//when
		boolean result = checker.check(calc);
		
		//then		
		assertTrue(result);
	}	

	@Test
	public void testBrackets(){
		//given
		String calc = "1+[2-3]";		
		Checker checker = new Checker();
		
		//when
		boolean result = checker.check(calc);
		
		//then		
		assertTrue(result);
	}

	@Test
	public void testParenthesesNestedInBrackets(){
		//given
		String calc = "[1+(2)-3]";		
		Checker checker = new Checker();
		
		//when
		boolean result = checker.check(calc);
		
		//then		
		assertTrue(result);
	}
	
	@Test
	public void testParenthesesNestedInParentheses(){
		//given
		String calc = "1+(2-(3*4))";		
		Checker checker = new Checker();
		
		//when
		boolean result = checker.check(calc);
		
		//then		
		assertTrue(result);
	}

	@Test
	public void testComplex(){
		//given
		String calc = "[[1+(2-(3*4))]*(3-{3+2*{2}}+3)+([3])]-1";		
		Checker checker = new Checker();
		
		//when
		boolean result = checker.check(calc);
		
		//then		
		assertTrue(result);
	}

	@Test
	public void testWrongOrder(){
		//given
		String calc = "[1+(2]-3)";		
		Checker checker = new Checker();
		
		//when
		boolean result = checker.check(calc);
		
		//then		
		assertFalse(result);
	}

	@Test
	public void testWrongOrder2(){
		//given
		String calc = "(1+[2)-3]";		
		Checker checker = new Checker();
		
		//when
		boolean result = checker.check(calc);
		
		//then		
		assertFalse(result);
	}

	@Test
	public void testNonMatchingCloseBracket(){
		//given
		String calc = "[1+2]]";		
		Checker checker = new Checker();
		
		//when
		boolean result = checker.check(calc);
		
		//then		
		assertFalse(result);
	}

	@Test
	public void testNonMatchingOpenBracket(){
		//given
		String calc = "[1+2][";		
		Checker checker = new Checker();
		
		//when
		boolean result = checker.check(calc);
		
		//then		
		assertFalse(result);
	}
}
