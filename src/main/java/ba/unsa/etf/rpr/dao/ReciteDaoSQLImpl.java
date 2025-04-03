package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Recite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class ReciteDaoSQLImpl extends AbstractDao<Recite> implements ReciteDao{

    public ReciteDaoSQLImpl() {
        super("recites");
    }

    @Override
    public Recite row2object(ResultSet rs) throws Exception {
        try{
            Recite history = new Recite();
            history.setId(rs.getInt("id"));
            history.setUserId(rs.getInt("user_id"));
            history.setTankId(rs.getInt("tank_id"));
            history.setAmount(rs.getInt("amount"));
            history.setTotal(rs.getInt("total"));
            history.setTankName(rs.getString("tank_name"));
            return history;
        }catch (SQLException e){
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Recite object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("user_id", object.getUserId());
        item.put("tank_id", object.getTankId());
        item.put("amount", object.getAmount());
        item.put("total", object.getTotal());
        item.put("tank_name", object.getTankName());
        return item;
    }




    public int getNextReciteId() throws Exception {
        Recite k =executeQueryUnique("SELECT * FROM recites where id = (SELECT coalesce(max(id)) AS ID FROM recites LIMIT 0, 1000)",null);
        return  k.getId()+1;
    }

    @Override
    public List<Recite> getUserRecite(int userID) throws Exception {
        return  executeQuery("SELECT * FROM recites WHERE user_id = ?", new Object[]{userID});
    }
}
