package agh.ics.oop;

import agh.ics.oop.MapDirection;
import org.testng.Assert;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    public void isNext() {
        MapDirection south = MapDirection.SOUTH;
        Assert.assertEquals(south.next(), MapDirection.WEST);
        MapDirection north = MapDirection.NORTH;
        Assert.assertEquals(north.next(), MapDirection.EAST);
        MapDirection west = MapDirection.WEST;
        Assert.assertEquals(west.next(), MapDirection.NORTH);
        MapDirection east = MapDirection.EAST;
        Assert.assertEquals(east.next(), MapDirection.SOUTH);
    }

    @Test
    public void isPrevious() {
        MapDirection south = MapDirection.SOUTH;
        Assert.assertEquals(south.previous(), MapDirection.EAST);
        MapDirection north = MapDirection.NORTH;
        Assert.assertEquals(north.previous(), MapDirection.WEST);
        MapDirection west = MapDirection.WEST;
        Assert.assertEquals(west.previous(), MapDirection.SOUTH);
        MapDirection east = MapDirection.EAST;
        Assert.assertEquals(east.previous(), MapDirection.NORTH);
    }
}

