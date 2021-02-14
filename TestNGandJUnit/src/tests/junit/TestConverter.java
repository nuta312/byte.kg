package tests.junit;

import methods.Converter;
import org.junit.Assert;
import org.junit.Test;

public class TestConverter {


    @Test
    public void test1(){

        Converter convert = new Converter();
         int f =  (int)convert.converterCtoF(30);
         // first put expected result , second actual result from the method.
        Assert.assertEquals(86,f);
    }

    @Test
    public void testKilometersToMiles (){
        Converter converter = new Converter();
        int km = (int)converter.convertMileToKm(100);

        Assert.assertEquals(160,km);

    }
}
