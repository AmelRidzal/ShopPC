package ba.unsa.etf.rpr.domain;

import ba.unsa.etf.rpr.dao.DaoFactory;

import java.util.Objects;


public class Recite implements Idable{
    private int reciteid;
    private int userid;
    private int tankid;
    private int amount;
    private int total;
    private String tankname;

    public Recite( int userID, int articleID, int amo, int tot,String tName) throws Exception {
        this.reciteid= DaoFactory.reciteDao().getNextReciteId();
        this.userid=userID;
        this.tankid=articleID;
        this.amount=amo;
        this.total=tot;
        this.tankname=tName;
    }

    public Recite(int reciteid, int userid, int tankid, int amount, int total, String tankname) {
        this.reciteid = reciteid;
        this.userid = userid;
        this.tankid = tankid;
        this.amount = amount;
        this.total = total;
        this.tankname = tankname;
    }

    public Recite() {
    }

    public int getId() {
        return reciteid;
    }

    public void setId(int reciteid) {
        this.reciteid = reciteid;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    public int getTankId() {
        return tankid;
    }

    public void setTankId(int tankid) {
        this.tankid = tankid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTankName() {
        return tankname;
    }

    public void setTankName(String tankname) {
        this.tankname = tankname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recite recite = (Recite) o;
        return reciteid == recite.reciteid && userid == recite.userid && tankid == recite.tankid && amount == recite.amount && total == recite.total && Objects.equals(tankname, recite.tankname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reciteid, userid, tankid, amount, total, tankname);
    }

    @Override
    public String toString() {
        return "Recite{" +
                "reciteid=" + reciteid +
                ", userid=" + userid +
                ", tankid=" + tankid +
                ", amount=" + amount +
                ", total=" + total +
                ", tankname='" + tankname + '\'' +
                '}';
    }


}
