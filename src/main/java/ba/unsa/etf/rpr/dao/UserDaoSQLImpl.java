package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;


public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    public UserDaoSQLImpl() {
        super("user_info");
    }


    public User row2object(ResultSet rs) throws Exception {
        try {
            User useruser = new User();
            useruser.setId(rs.getInt("id"));
            useruser.setUsername(rs.getString("username"));
            useruser.setEmail(rs.getString("email"));
            useruser.setPassword(rs.getString("password"));
            return useruser;
        } catch (SQLException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("username", object.getUsername());
        row.put("email", object.getEmail());
        row.put("password", object.getPassword());
        return row;
    }



    @Override
    public User searchByEmail(String s) throws Exception {
        return executeQueryUnique("SELECT * FROM user_info WHERE email = ?", new Object[]{s});
    }



}