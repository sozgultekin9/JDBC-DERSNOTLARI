import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Junittest {

    // test geçti yada kaldı diyebilmek için esortion  (doğrulama)yapmamız gerekir
// assertion türleri:




    @Test
    public void test01() {
//Test geçti veya kaldı gibi dönüt alabilmek için doğrulama(assertion) yapmamız gerekir.
        //Assertion türleri:
        int expectedData = 5;
        int actualData = 56;


        System.out.println(1<2);

        assertEquals(expectedData,actualData);//assertEquals() --> parantez içindeki paramtereler eşit ise test geçer
        Assert.assertTrue(actualData<4);

        // negetif test
        Assert.assertNotEquals(2,5);
        Assert.assertFalse(actualData>100);






    }

    @Test
    public void test02() {


    }

    @Test
    public void test03() {


    }
}