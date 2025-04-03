package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserManager {









    public static String GetPassByEmail(String email) throws Exception {
        User u=DaoFactory.userDao().searchByEmail(email);

        return u.getPassword();
    }

    public static User GetUserByEmail(String email) throws Exception {

        return DaoFactory.userDao().searchByEmail(email);
    }




    public static boolean CkeckEmail(String email) {
        try{
            DaoFactory.userDao().searchByEmail(email);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }

    }




    public static void AddAcc(User newuser) throws Exception {

        DaoFactory.userDao().add(newuser);
    }


        public static List<User> getAllUsers() throws Exception{
            System.out.println(DaoFactory.userDao().getAll());
        return DaoFactory.userDao().getAll();
    }
    private static final String HASHING_ALGORITHM = "SHA-256";
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(HASHING_ALGORITHM);
        messageDigest.update(password.getBytes());

        byte[] hashedPassword = messageDigest.digest();

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hashedPassword) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }

}
