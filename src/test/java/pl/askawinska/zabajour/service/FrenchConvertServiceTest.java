package pl.askawinska.zabajour.service;

import org.junit.Assert;
import org.junit.Test;

import pl.askawinska.zabajour.converter.Converter;
import pl.askawinska.zabajour.converter.FrenchConverter;

public class FrenchConvertServiceTest {

    private Converter c = new FrenchConverter();

    @Test
    public void zabaTest() {
        Assert.assertEquals("jaroi jaba jour", c.convert("żarła żaba żur"));
    }

    @Test
    public void lidlTest() {
        Assert.assertEquals("charai blouzé v lidlou joutchili", c.convert("szare bluzy w lidlu rzucili"));
    }

    @Test
    public void betonTest() {
        Assert.assertEquals("douppont train eau baiton", c.convert("dupą trę o beton"));
    }

    @Test
    public void nullTest() {
        Assert.assertEquals("", c.convert(null));
    }

    @Test
    public void emptyTest() {
        Assert.assertEquals("", c.convert(""));
    }

    @Test
    public void neutralTest() {
        Assert.assertEquals("frt", c.convert("frt"));
    }

}
