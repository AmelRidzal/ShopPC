package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.domain.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;

public class MainControler {

    public static Scene scene;
    public static Stage stage1=new Stage();
    public static User currentUser;
    public static URL fxmlKatalog = AppFX.class.getResource("katalog.fxml");
    public static URL fxmlLogin = AppFX.class.getResource("login.fxml");
    public static URL fxmlProfile = AppFX.class.getResource("profile.fxml");
    public static URL fxmlArticle = AppFX.class.getResource("article.fxml");
    public static URL fxmlRegister = AppFX.class.getResource("register.fxml");
    public static URL fxmlAdmin = AppFX.class.getResource("admin.fxml");


    public static void MainChangeColor(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setTextFill(javafx.scene.paint.Color.RED);

    }

    public static void MainRevertColor(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setTextFill(Color.WHITE);
    }

    public static void MainArticleScene(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlArticle);
            ArticleControler articleController = new ArticleControler();
            fxmlLoader.setController(articleController);
            scene = new Scene(fxmlLoader.load());
            stage1.setTitle("Article");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();

            //badArticleLoader(null);
        }catch (Exception a){
            System.out.println(a);
        }
    }

    public static void MainProfileScreen(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlProfile);
            ProfileControler profileController = new ProfileControler();
            fxmlLoader.setController(profileController);
            scene = new Scene(fxmlLoader.load());
            stage1.setTitle("Profile");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        }catch (Exception a){
            System.out.println(a);
        }
    }

    public static void MainAdminScreen(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlAdmin);
            AdminControler AdminController = new AdminControler();
            fxmlLoader.setController(AdminController);
            scene = new Scene(fxmlLoader.load());
            stage1.setTitle("Admin");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        }catch (Exception a){
            System.out.println(a);
        }
    }

    public static void MainHomeScreen () {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlKatalog);
            KatalogControler katalogController = new KatalogControler();
            fxmlLoader.setController(katalogController);
            scene = new Scene(fxmlLoader.load());
            stage1.setTitle("MainCatalog");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();

        }catch (Exception a){
            System.out.println(a);
        }
    }

    public static void MainRegisterScreen() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlRegister);
            RegisterControler registerController = new RegisterControler();
            fxmlLoader.setController(registerController);
            scene = new Scene(fxmlLoader.load());
            stage1.setTitle("Register");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        }catch (Exception a){
            System.out.println(a);
        }
    }

    public static   void  MainLoginScreen() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(fxmlLogin);
            LoginControler loginController = new LoginControler();
            fxmlLoader.setController(loginController);
            scene = new Scene(fxmlLoader.load());
            stage1.setTitle("Login");
            stage1.setResizable(false);
            stage1.setScene(scene);
            stage1.show();


        }catch (Exception a){
            System.out.println(a);
        }

    }
}
