package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Recite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReciteDaoTest {
    @Test
    void GetterAndSetterTest() {
        Recite r=new Recite();
        r.setId(5);
        r.setTankId(5);
        r.setUserId(5);
        r.setAmount(5);
        r.setTotal(5);
        r.setTankName("5");

        assertEquals(r.getId(),5);
        assertEquals(r.getTankId(),5);
        assertEquals(r.getUserId(),5);
        assertEquals(r.getAmount(),5);
        assertEquals(r.getTotal(),5);
        assertEquals(r.getTankName(),"5");
    }

    @Test
    void EqualsTest() throws Exception {
        Recite r1 = new Recite(5,5,5,5,5,"5");
        Recite r2 = new Recite(5,5,5,5,5,"5");
        assertEquals(r1,r2);
    }

    @Test
    void ToStringTest() throws Exception {
        Recite r = new Recite(5,5,5,5,5,"5");
        assertEquals(r.toString(),"Recite{reciteid=5, userid=5, tankid=5, amount=5, total=5, tankname='5'}");
    }
}
