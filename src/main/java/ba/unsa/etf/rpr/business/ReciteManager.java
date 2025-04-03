package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Recite;

import java.util.List;

public class ReciteManager {


    public static List<Recite> getAllRecites() throws Exception{
        return DaoFactory.reciteDao().getAll();
    }
    public static void addRecite(Recite r) throws Exception {

        DaoFactory.reciteDao().add(r);
    }
}
