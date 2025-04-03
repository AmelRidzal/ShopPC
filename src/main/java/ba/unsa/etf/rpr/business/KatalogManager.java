package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Katalog;
import ba.unsa.etf.rpr.domain.Recite;
import ba.unsa.etf.rpr.domain.User;



public class KatalogManager {




    public static void  purchaseArticle(Recite r) throws Exception {
        ReciteManager.addRecite(r);
        Katalog k=DaoFactory.katalogDao().getById(r.getTankId());
        k.setTankAmount(k.getTankAmount()-r.getAmount());
        DaoFactory.katalogDao().update(k);
    }



}
