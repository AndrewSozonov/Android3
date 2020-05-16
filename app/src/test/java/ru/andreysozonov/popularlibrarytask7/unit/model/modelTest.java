package ru.andreysozonov.popularlibrarytask7.unit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.andreysozonov.popularlibrarytask7.unit.Model;

public class modelTest {

    private Model model;

    @Before
    public void before() {
        model = new Model();
    }

    @Test
    public void calculateSum_whenSome_isCorrect() {
        int x = 2;
        int y = 3;
        int result = model.calculateSum(x, y);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void calculateSum_whenSome_isInCorrect() {
        int x = 10;
        int y = 20;
        int result = model.calculateSum(x, y);
        Assert.assertNotEquals(result, 25);
    }
}
