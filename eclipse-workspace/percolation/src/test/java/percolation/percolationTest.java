package percolation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class percolationTest {

	private Percolation perc;
	
	@Before
	public void setUp() {
		perc = new Percolation(3);
	}
	
	@Test
	public void testIsOpen(){
		perc.open(0, 0);
		assertTrue(perc.isOpen(0,0));		
	}
	
	@Test
	public void directionalCheckTest() {
		//check left
		assertFalse(perc.checkLeft(0,1));
		perc.open(0, 0);
		assertTrue(perc.checkLeft(0, 1));
		//left edge case
		assertFalse(perc.checkLeft(0, 0));
		
		//check right
		assertFalse(perc.checkRight(0, 1));
		perc.open(0, 2);
		assertTrue(perc.checkRight(0, 1));
		//right edge case
		assertFalse(perc.checkRight(0, 2));
		
		//check up
		assertFalse(perc.checkUp(1, 1));
		perc.open(0, 1);
		assertTrue(perc.checkUp(1, 1));
		//up edge case
		assertFalse(perc.checkUp(0, 0));
		
		//check down
		assertFalse(perc.checkDown(1, 1));
		perc.open(2, 1);
		assertTrue(perc.checkDown(1, 1));
		//down edge case
		assertFalse(perc.checkDown(2, 1));
		
		perc.printGrid();
		
	}
	
	@Test
	public void checkConversionMath() {
		int conversionResult = perc.entryToInt(2, 2);
		assertEquals(8,conversionResult);
	}
	
	@Test
	public void checkTopAndBottomRowsAreUnited() {
		assertTrue(perc.isConnected(0, 0, 0, 2));
		assertTrue(perc.isConnected(2, 0, 2, 2));
		assertFalse(perc.isConnected(0, 0, 1, 0));
		assertFalse(perc.isConnected(1, 2, 2, 0));
	}

}
