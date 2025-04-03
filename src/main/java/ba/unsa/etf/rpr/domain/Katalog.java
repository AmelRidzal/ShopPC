package ba.unsa.etf.rpr.domain;

import com.mysql.cj.jdbc.Blob;

import java.util.Objects;


public class Katalog implements Idable{

    private Integer tankid;
    private String tankname;
    private String tankclass;
    private Integer price;
    private String description;
    private Blob tankimage;
    private int tankamount;


    public Katalog(Integer tankid, String tankname, String tankclass, Integer price, String description, Blob tankimage, int tankamount) {
        this.tankid = tankid;
        this.tankname = tankname;
        this.tankclass = tankclass;
        this.price = price;
        this.description = description;
        this.tankimage = tankimage;
        this.tankamount = tankamount;
    }

    public Katalog() {
    }

    public int getId() {
        return tankid;
    }

    public void setId(int tankid) {
        this.tankid = tankid;
    }

    public String getTankName() {
        return tankname;
    }

    public void setTankName(String tankname) {
        this.tankname = tankname;
    }
    public String getTankClass() {
        return tankclass;
    }

    public void setTankClass(String tankclass) {
        this.tankclass = tankclass;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getTankImage() {
        return tankimage;
    }

    public void setTankImage(Blob tankimage) {
        this.tankimage = tankimage;
    }

    public int getTankAmount() {
        return tankamount;
    }

    public void setTankAmount(int tankamount) {
        this.tankamount = tankamount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Katalog katalog = (Katalog) o;
        return tankamount == katalog.tankamount && Objects.equals(tankid, katalog.tankid) && Objects.equals(tankname, katalog.tankname) && Objects.equals(tankclass, katalog.tankclass) && Objects.equals(price, katalog.price) && Objects.equals(description, katalog.description) && Objects.equals(tankimage, katalog.tankimage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tankid, tankname, tankclass, price, description, tankimage, tankamount);
    }

    @Override
    public String toString() {
        return "Katalog{" +
                "tankid=" + tankid +
                ", tankname='" + tankname + '\'' +
                ", tankclass='" + tankclass + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", tankimage=" + tankimage +
                ", tankamount=" + tankamount +
                '}';
    }
}
