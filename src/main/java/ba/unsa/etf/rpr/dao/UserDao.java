package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;


public interface UserDao extends Dao<User> {

    User getById(int id) throws Exception;
    User searchByEmail(String s)throws  Exception;
}
