package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Katalog;
import ba.unsa.etf.rpr.domain.Recite;
import ba.unsa.etf.rpr.domain.User;
import org.apache.commons.cli.*;

import java.util.List;

public class AppCLI {
    public static void main(String[] args) throws Exception {
        Options options = new Options();
        options.addOption("h", "help", false, "Print this message");

        options.addOption("uu", "username", true, "Username");
        options.addOption("up", "password", true, "Password");
        options.addOption("ue", "email", true, "Email");
        options.addOption("ua", "useradd", false, "Add new user");
        options.addOption("ud", "userdelete", true, "Delete user");
        options.addOption("ul", "userlist", false, "List all users");
        options.addOption("us", "usersearch", true, "Search user");

        options.addOption("kn","katalogname",true,"katalog name");
        options.addOption("kc","katalogclass",true,"katalog class");
        options.addOption("kam","katalogamount",true,"katalog amount");
        options.addOption("kp","katalogprice",true,"katalog price");
        options.addOption("kdi","katalogdiscription",true,"katalog discription");
        options.addOption("ka", "katalogadd", false, "Add new katalog item");
        options.addOption("kd", "katalogdelete", true, "Delete katalog item");
        options.addOption("kl", "kataloglist", false, "List katalog");

        options.addOption("rl", "recitelist", false, "List recites");

        options.addOption("v", "version", false, "Print version");




        CommandLineParser parser = new DefaultParser();
        CommandLine cl = parser.parse(options, args);
        if (cl.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("AppCLI", options);
        }


        if (cl.hasOption("us")){
            User user= DaoFactory.userDao().searchByEmail(cl.getOptionValue("ue"));
            if (user != null) {
                System.out.println((user.getId()));
                System.out.println(user.getUsername());
                System.out.println(user.getEmail());
                System.out.println(user.getPassword());
            } else {
                System.out.println("User not found");
            }
        }
        if(cl.hasOption("ul")){
            List<User> users=DaoFactory.userDao().getAll();
            for(User x: users)
            {
                System.out.println(x.toString());
            }
        }
        if(cl.hasOption("ua")){
            User user = new User();
            try
            {
                user.setUsername(cl.getOptionValue("uu"));
                user.setPassword(cl.getOptionValue("up"));
                user.setEmail(cl.getOptionValue("ue"));
                DaoFactory.userDao().add(user);
                System.out.println(user);
            }
            catch (Exception e)
            {
                System.out.println("Error");
            }
        }
        if(cl.hasOption("ud")){
            User user = DaoFactory.userDao().searchByEmail(cl.getOptionValue("ud"));
            if(user != null)
            {
                DaoFactory.userDao().delete(user.getId());
                System.out.println("User deleted");
            }
            else
            {
                System.out.println("User not found");
            }
        }



        if(cl.hasOption("kl")){
            List<Katalog> kat=DaoFactory.katalogDao().getAll();
            for(Katalog x: kat)
            {
                System.out.println(x.toString());
            }
        }
        if(cl.hasOption("ka")){
            Katalog kat =new Katalog();
            try
            {
                kat.setTankName(cl.getOptionValue("kn"));
                kat.setTankClass(cl.getOptionValue("kc"));
                kat.setDescription(cl.getOptionValue("kdi"));
                kat.setTankAmount(Integer.parseInt(cl.getOptionValue("kam")));
                kat.setPrice(Integer.parseInt(cl.getOptionValue("kp")));
                DaoFactory.katalogDao().add(kat);
            }
            catch (Exception e)
            {
                System.out.println("Error");
            }
        }
        if(cl.hasOption("kd")){
            Katalog kat = DaoFactory.katalogDao().getByTankName(cl.getOptionValue("kd"));
            if(kat != null)
            {
                DaoFactory.katalogDao().delete(kat.getId());
                System.out.println("Katalog item deleted");
            }
            else
            {
                System.out.println("Katalog item not found");
            }
        }



        if(cl.hasOption("rl")){
            List<Recite> rec=DaoFactory.reciteDao().getAll();
            for(Recite r: rec)
            {
                System.out.println(r.toString());
            }
        }

        if(cl.hasOption("v"))
        {
            System.out.println("Version 1.0");
        }

    }
}