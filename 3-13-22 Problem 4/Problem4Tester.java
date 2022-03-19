import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.Permission;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;



@FixMethodOrder(org.junit.runners.MethodSorters.NAME_ASCENDING)
public class Problem4Tester{


	@Rule
	public Timeout globalTimeout = Timeout.seconds(15);

	@SuppressWarnings("serial")
	private static class ExitException extends SecurityException {}

	private static class NoExitSecurityManager extends SecurityManager 
	{
		@Override
		public void checkPermission(Permission perm) {}

		@Override
		public void checkPermission(Permission perm, Object context) {}

		@Override
		public void checkExit(int status) { super.checkExit(status); throw new ExitException(); }
	}

	@Before
	public void setUp() throws Exception 
	{
		System.setSecurityManager(new NoExitSecurityManager());
	}

	@After
	public void tearDown() throws Exception 
	{
		System.setSecurityManager(null);
	}

    private void _testNextInt(int[] arr, int expected){
        int result = -1;
        try {
			result = Problem4.nextInt(arr);
		} catch (ExitException e) {
			assertTrue("Program crashed", false);
            System.exit(300);
		}
        assertEquals("Expected " + Integer.toString(result) + " but got " + Integer.toString(result) + ".", expected, result);
    }

    @Test
    public void test0_Given(){
        _testNextInt(new int[] {3, 4, -1, 1}, 2);
        _testNextInt(new int[] {1, 2, 0}, 3);
    }

    @Test
    public void test1_Simple(){
        _testNextInt(new int[] {6,8,5,2,1,3,4}, 7);
        _testNextInt(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}, 20);    
    }

    @Test
    public void test2_Negatives(){
        _testNextInt(new int[] {-3,-200,-1,0,5,3,2,1,-4}, 4);
    }

    @Test
    public void test3_Duplicates(){
        _testNextInt(new int[] {6,8,5,2,1,3,4,4,3,2,2}, 7);
    }
}