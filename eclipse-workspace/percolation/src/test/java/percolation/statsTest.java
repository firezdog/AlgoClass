package percolation;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class statsTest {
	
	private PercolationStats stat;
	
	@Before
	public void setup() {
		stat = new PercolationStats(4,2);
	}
	
//	@Test
//	public void test_openRandom() {
//		int[] opened = stat.openRandom();
//		assertTrue(stat.perc.isOpen(opened[0], opened[1]));
//		assertEquals(stat.openSites,1);
//	}
	
	@Test
	public void test_experiment_flow() {
		stat.printTrialRatios();
	}

}
