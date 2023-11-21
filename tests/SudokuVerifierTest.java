import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
String tooLong = "4173698256321589479587243168254371697915864323469127582896435715732916841648752932";
String tooShort = "4173698256321589479587243168254371697915864323469127582896435715732916";
String emojis = "❤💔💌💕💞💓💗💖💘💝💟💜💛💚💙❤💔💌💕💞💓💗💖💘💝💟💜💛💚💙❤💔💌💕💞💓💖💘💟💜💛💙";
String breaksRule2 = "123456789156789123789123456214365897365897214897214365531642978642978531978531642";
String breaksRule3 = "417369825632158947958724316825437169791586432346912758289643571573291683164875294";
String breaksRule4 = "417369825632158947958724316825437169791586432346912758289643571573291684164875239";

SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
	}
		
	@Test
	public void testTooLong() {
		int result  = v.verify(tooLong);
		assertEquals("incorrect string", -1, result);
	}
	
	@Test 
	public void testTooShort() {
		int result = v.verify(tooShort);
		assertEquals("Incorrect string", -1, result);
	}
	
	@Test
   public void testRule2() {
		int result = v.verify(breaksRule2);
		assertEquals("Incorrect string", -2, result);
	}
	@Test
   public void testRule3() {
		int result = v.verify(breaksRule3);
		assertEquals("Incorrect string",-3, result);
	}
	
	@Test 
	public void testRule4() {
		int result = v.verify(breaksRule4);
		assertEquals("Incorrect string",-4, result);
	}
	
	@Test
	public void testEmojis() {
		 int result = v.verify(emojis);
	     assertEquals("String with non-numeric chars should return 1", 1, result);
	}
}
