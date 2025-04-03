package ba.unsa.etf.rpr.dao;


public class DaoFactory {

    private static final UserDao userDao = new UserDaoSQLImpl();
    public static final KatalogDao katalogDao = new KatalogDaoSQLImpl();
    private static final ReciteDao reciteDao = new ReciteDaoSQLImpl();

    private DaoFactory(){
    }

    public static UserDao userDao(){
        return userDao;
    }

    public static KatalogDao katalogDao(){
        return katalogDao;
    }

    public static ReciteDao reciteDao(){
        return reciteDao;
    }

}


