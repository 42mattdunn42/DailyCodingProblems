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
public class Problem1Tester{


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

    private void _testTwoSumMem(int[] arr, int target, boolean expected){
        boolean result;
        try {
			result = Problem1.twoSum_Mem(arr, target);
		} catch (ExitException e) {
			assertTrue("Program crashed", false);
            result = false;
            System.exit(300);
		}
        assertEquals("Expected " + Boolean.toString(expected) + " but got " + Boolean.toString(result) + ".", expected, result);
    }
    private void _testTwoSumPass(int[] arr, int target, boolean expected){
        boolean result = false;
        try {
			result = Problem1.twoSum_Pass(arr, target);
		} catch (ExitException e) {
			assertTrue("Program crashed", false);
		}
        assertEquals("Expected " + Boolean.toString(expected) + " but got " + Boolean.toString(result) + ".", expected, result);
    }

    @Test
    public void test0_GivenMem(){
        _testTwoSumMem(new int[] {10, 15, 3, 7}, 17, true);
    }

    @Test
    public void test1_EmptyMem(){
        _testTwoSumMem(new int[] {}, 5, false);
    }

    @Test
    public void test2_LongMem(){
        _testTwoSumMem(new int[] {1,2,3,4,5,6,7,8,9,0,0,0,0,0,20,60}, 400, false);
        _testTwoSumMem(new int[] {1,2,3,4,5,6,7,8,9,0,0,0,0,0,20,60}, 80, true);
        _testTwoSumMem(new int[] {-1,1,17,36,420,69,12,34,56,78,90}, -6, false);
        _testTwoSumMem(new int[] {-1,1,17,36,420,69,12,34,56,78,90}, 510, true);
        _testTwoSumMem(new int[] {-5,-4,-3,-2,0,6,5,3}, 1, true);
    }

    @Test
    public void test3_GivenPass(){
        _testTwoSumPass(new int[] {10, 15, 3, 7}, 17, true);
    }

    @Test
    public void test4_EmptyPass(){
        _testTwoSumPass(new int[] {}, 5, false);
    }

    @Test
    public void test5_LongPass(){
        _testTwoSumPass(new int[] {1,2,3,4,5,6,7,8,9,0,0,0,0,0,20,60}, 400, false);
        _testTwoSumPass(new int[] {1,2,3,4,5,6,7,8,9,0,0,0,0,0,20,60}, 80, true);
        _testTwoSumPass(new int[] {-1,1,17,36,420,69,12,34,56,78,90}, -6, false);
        _testTwoSumPass(new int[] {-1,1,17,36,420,69,12,34,56,78,90}, 510, true);
        _testTwoSumPass(new int[] {-5,-4,-3,-2,0,6,5,3}, 1, true);
    }
}
