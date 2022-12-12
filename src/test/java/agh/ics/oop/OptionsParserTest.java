package agh.ics.oop;
import org.testng.Assert;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.Direction.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.testng.Assert.assertThrows;

public class OptionsParserTest {
    @Test
    public void parseTest(){;
        List<Direction> tab = Arrays.asList(FORWARD, BACKWARD, FORWARD);
        Assert.assertEquals(OptionsParser.parse(new String[]{"f", "b","forward"}), tab );
        assertDoesNotThrow(() -> OptionsParser.parse((new String[]{"f", "b", "forward"})));
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse((new String[]{"f", "b","x", "forward"})));
    }
}
