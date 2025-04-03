package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.business.KatalogManager;
import ba.unsa.etf.rpr.exceptions.EmailException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static ba.unsa.etf.rpr.business.UserManager.GetPassByEmail;
import static ba.unsa.etf.rpr.business.UserManager.GetUserByEmail;
import static ba.unsa.etf.rpr.controler.MainControler.MainHomeScreen;
import static ba.unsa.etf.rpr.controler.MainControler.MainRegisterScreen;
import static ba.unsa.etf.rpr.controler.MainControler.*;

public class LoginControler {





    @FXML
    private Text LoginError, RegisterError;
    @FXML
    private TextField EmailField, PassField, EmailReg, PassReg, UsernameReg;


    @FXML
    public void onLoginButtonClick() throws Exception {
        String Email = EmailField.getText();
        String Pass = PassField.getText();
        String PassProv;
        try {
            PassProv = GetPassByEmail(Email);

        }catch (Exception e){

            LoginError.setText("Login not successful");
            throw new EmailException("email doesnt exist");
        }
        System.out.println(PassProv);
        if (PassProv.equals(Pass)) {
            currentUser=GetUserByEmail(Email);
            MainHomeScreen();
        } else {
            LoginError.setText("Login not successful");
        }
    }

    public void onSignUpButtonClick(ActionEvent actionEvent) {
        MainRegisterScreen();
    }
















}
