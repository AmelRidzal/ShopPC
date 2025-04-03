package ba.unsa.etf.rpr.domain;

import java.util.Objects;


public class User implements Idable{

    private int userid;
    private String username;
    private String email;
    private String password;

    public User(int userid, String username, String email, String password) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String Username, String Pass, String Email) {
        this.email=Email;
        this.username=Username;
        this.password=Pass;
    }

    public User(int Userid) {
        this.userid=Userid;

    }

    public User() {

    }


    public int getId() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User category = (User) o;
        return userid == category.userid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, email, password);
    }


}
