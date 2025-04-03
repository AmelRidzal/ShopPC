package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Katalog;
import com.mysql.cj.jdbc.Blob;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;


public class KatalogDaoSQLImpl extends AbstractDao<Katalog> implements KatalogDao {

    public KatalogDaoSQLImpl() {
        super("tenk_katalog");
    }

    @Override
    public Katalog row2object(ResultSet rs) throws Exception{
        try {
            Katalog q = new Katalog();
            q.setId(rs.getInt("id"));
            q.setTankName(rs.getString("tank_name"));
            q.setTankClass(rs.getString("tank_class"));
            q.setPrice(rs.getInt("tank_price"));
            q.setDescription(rs.getString("tank_discription"));
            q.setTankImage((Blob) rs.getBlob("tenk_image"));
            q.setTankAmount(rs.getInt("amount"));
            return q;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * @param object - object to be mapped
     * @return map representation of object
     */
    @Override
    public Map<String, Object> object2row(Katalog object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("tank_name", object.getTankName());
        item.put("tank_class", object.getTankClass());
        item.put("tank_price", object.getPrice());
        item.put("tank_discription", object.getDescription());
        item.put("tenk_image", object.getTankImage());
        item.put("amount",object.getTankAmount());
        return item;
    }






    public int getNextTankId() throws Exception {
        Katalog k =executeQueryUnique("SELECT * FROM tenk_katalog where id = (SELECT coalesce(max(id)) AS ID FROM tenk_katalog LIMIT 0, 1000)",null);
        return  k.getId()+1;
    }

    public void updateTankId(int old,int neww) throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE tenk_katalog SET `id` = '").append(neww).append("' WHERE (`id` = '").append(old).append("');");

        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString());
            stmt.executeUpdate();

        }catch (SQLException e){
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public Katalog getByTankName(String s) throws Exception {
        return executeQueryUnique("SELECT * FROM tenk_katalog WHERE tank_name = ?", new Object[]{s});
    }

}
