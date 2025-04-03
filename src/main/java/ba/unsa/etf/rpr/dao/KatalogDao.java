package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Katalog;



public interface KatalogDao extends Dao<Katalog>{


    Katalog getById(int id) throws Exception;
    int getNextTankId() throws Exception;
    void updateTankId(int old,int neww) throws Exception;


    Katalog getByTankName(String s) throws Exception;
}
