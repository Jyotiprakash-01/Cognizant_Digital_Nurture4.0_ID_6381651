import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestCalculator {
	private Calculator calculator=new Calculator();
	@Test
	void testAddition() {
		assertEquals(5,calculator.add(2, 3));
		assertEquals(-3,calculator.add(-7, 4));
		assertEquals(0,calculator.add(0, 0));
		assertEquals(Integer.MIN_VALUE,calculator.add(Integer.MAX_VALUE, 1));
	}
	@Test
	void testSubtraction() {
		assertEquals(4,calculator.subtract(9, 5));
		assertEquals(-1,calculator.subtract(3, 4));
		assertEquals(0,calculator.subtract(0, 0));
		assertEquals(Integer.MAX_VALUE,calculator.subtract(Integer.MIN_VALUE, 1));
	}
	@Test
	void testMultiplication() {
		assertEquals(12,calculator.multiply(3, 4));
		assertEquals(0,calculator.multiply(0, 0));
		assertEquals(-8,calculator.multiply(-2, 4));
		assertEquals(10,calculator.multiply(-2, -5));
		assertEquals(0,calculator.multiply(50,0));
	}
	@Test
	void testDivision() {
		assertEquals(-1,calculator.divide(9, 0));
		assertEquals(-1,calculator.divide(0, 0));
		assertEquals(0,calculator.divide(0,5));
		assertEquals(12,calculator.divide(25, 2));
		assertEquals(0,calculator.divide(15, 30));
		assertEquals(2,calculator.divide(30, 15));
	}
	
}
