package agh.ics.oop;

import agh.ics.oop.Vector2d;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Vector2dTest {

    Vector2d vector = new Vector2d(4,5);
    @Test
    public void isEquals(){

        Assert.assertTrue(vector.equals(new Vector2d(3,6)));
        Assert.assertTrue(vector.equals(new Vector2d(4,5)));
        Assert.assertTrue(vector.equals(vector));
        Assert.assertFalse(vector.equals("Hi"));
    }

    @Test
    public void isStringTest(){
        Assert.assertEquals(vector.toString(),"(4,5)");
    }

    @Test
    public void isPreceses(){
        Assert.assertTrue(vector.precedes(new Vector2d(1,3)));
        Assert.assertFalse(vector.precedes(new Vector2d(1,6)));
        Assert.assertFalse(vector.precedes(new Vector2d(6,6)));
    }

    @Test
    public void followsTest(){
        Assert.assertTrue(vector.follows(new Vector2d(6,5)));
        Assert.assertTrue(vector.follows(new Vector2d(4,5)));
        Assert.assertFalse(vector.follows(new Vector2d(2,5)));
    }

    @Test
    public void upperRightTest(){
        Assert.assertEquals(vector.upperRight(new Vector2d(3,8)),"(4,8)");
    }
    @Test
    public void lowerLeftTest(){
        Assert.assertEquals(vector.lowerLeft(new Vector2d(3,8)),"(3,5)");
    }

    @Test
    public void addTest(){
        Assert.assertEquals(vector.add(new Vector2d(3,8)), new Vector2d(7,13));
    }

    @Test
    public void subtractTest(){
        Assert.assertEquals(vector.subtract(new Vector2d(3,8)), new Vector2d(1,-3));
    }

    @Test
    public void opositeTest(){
        Assert.assertEquals(vector.opposite(), new Vector2d(5,4));
    }
}

