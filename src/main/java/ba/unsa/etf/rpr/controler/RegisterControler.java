package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static ba.unsa.etf.rpr.business.UserManager.AddAcc;
import static ba.unsa.etf.rpr.business.UserManager.CkeckEmail;
import static ba.unsa.etf.rpr.controler.MainControler.MainLoginScreen;

public class RegisterControler {

    @FXML
    TextField EmailReg,PassReg,UsernameReg;
    @FXML
    Text RegisterError;
    public void onRegisterButtonClick() {
        String Email = EmailReg.getText();
        String Pass = PassReg.getText();
        String Username = UsernameReg.getText();
        User newuser =new User(Username,Pass,Email);

        if (CkeckEmail(Email)) {
            RegisterError.setText("email already registerd");
        } else {
            try {
                AddAcc(newuser);
                MainLoginScreen();
            } catch (Exception a) {
                System.out.println(a);
            }
        }

    }

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        MainLoginScreen();
    }


}
