package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.controler.LoginControler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static ba.unsa.etf.rpr.controler.MainControler.*;


public class AppFX extends Application {





    public void start(Stage stage) {


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




    public static void main(String[] args) {
        launch();
    }

}