package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Katalog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KatalogDaoTest {
    @Test
    void GetterAndSetterTest() {
        Katalog k=new Katalog();
        k.setId(3);
        k.setTankName("tank");
        k.setTankClass("class");
        k.setPrice(99);
        k.setTankAmount(3);
        k.setDescription("funny description");
        k.setTankImage(null);

        assertEquals(k.getId(),3);
        assertEquals(k.getTankName(),"tank");
        assertEquals(k.getTankClass(),"class");
        assertEquals(k.getPrice(),99);
        assertEquals(k.getTankAmount(),3);
        assertEquals(k.getDescription(),"funny description");
        assertNull(k.getTankImage());
    }

    @Test
    void EqualsTest() {
        Katalog k1=new Katalog(0,"tank","class",123,"dis",null,4);
        Katalog k2=new Katalog(0,"tank","class",123,"dis",null,4);
        assertEquals(k1,k2);
    }

    @Test
    void ToStringTest() {
        Katalog k1=new Katalog(0,"tank","class",123,"dis",null,4);
        assertEquals(k1.toString(),"Katalog{tankid=0, tankname='tank', tankclass='class', price=123, description='dis', tankimage=null, tankamount=4}");
    }
}
