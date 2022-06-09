import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testEnumSolution() {
        assertEquals(10, Solution.getResult("STWSWTPPTPTTPWPP", "Human", RulesType.FROM_ENUM));
        assertEquals(15, Solution.getResult("STWSWTPPTPTTPWPP", "Swamper", RulesType.FROM_ENUM));
        assertEquals(12, Solution.getResult("STWSWTPPTPTTPWPP", "Woodman", RulesType.FROM_ENUM));
    }

    @Test
    public void testEnumSolutionError() {
        assertThrows(IllegalArgumentException.class, () -> Solution.getResult(null, "Human", RulesType.FROM_ENUM));
        assertThrows(IllegalArgumentException.class, () -> Solution.getResult("STWSWTPPTPTTPWPP", null, RulesType.FROM_ENUM));
        assertThrows(IllegalArgumentException.class, () -> Solution.getResult(null, null, RulesType.FROM_ENUM));
        assertThrows(IllegalArgumentException.class, () -> Solution.getResult("SSSS", "SSSS", RulesType.FROM_ENUM));
        assertThrows(IllegalArgumentException.class, () -> Solution.getResult("1111", "1111", RulesType.FROM_ENUM));
    }

    @Test
    public void testFileSolution() {
        assertEquals(10, Solution.getResult("STWSWTPPTPTTPWPP", "Human", RulesType.FROM_FILE));
        assertEquals(15, Solution.getResult("STWSWTPPTPTTPWPP", "Swamper", RulesType.FROM_FILE));
        assertEquals(12, Solution.getResult("STWSWTPPTPTTPWPP", "Woodman", RulesType.FROM_FILE));
    }

    @Test
    public void testFileSolutionError() {
        assertThrows(IllegalArgumentException.class, () -> Solution.getResult(null, "Human", RulesType.FROM_FILE));
        assertThrows(IllegalArgumentException.class, () -> Solution.getResult("STWSWTPPTPTTPWPP", null, RulesType.FROM_FILE));
        assertThrows(IllegalArgumentException.class, () -> Solution.getResult(null, null, RulesType.FROM_FILE));
        assertThrows(IllegalArgumentException.class, () -> Solution.getResult("SSSS", "SSSS", RulesType.FROM_FILE));
        assertThrows(IllegalArgumentException.class, () -> Solution.getResult("1111", "1111", RulesType.FROM_FILE));
    }

    // todo test for crack rule, maybe)))
}
