package agh.ics.oop;
import org.testng.Assert;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.Direction.*;

public class OptionsParserTest {
    @Test
    public void parseTest(){
        OptionsParser obj = new OptionsParser();
        List<Direction> tab = Arrays.asList(FORWARD, BACKWARD, FORWARD);
        Assert.assertEquals(obj.parse(new String[]{"f", "b", "x", "forward"}), tab );
        List<Direction> tab1 = List.of(FORWARD, LEFT, RIGHT);
        Assert.assertEquals(obj.parse(new String[]{"f", "left", "x", "right"}),tab1);
    }
}
