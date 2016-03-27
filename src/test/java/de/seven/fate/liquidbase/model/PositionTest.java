package de.seven.fate.liquidbase.model;

import de.seven.fate.liquidbase.dao.IdAble;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mario on 26.03.2016.
 */
public class PositionTest {

    IdAble sut = new Position();

    @Test
    public void testImplementation() throws Exception {

        assertTrue(IdAble.class.isAssignableFrom(sut.getClass()));
    }
}