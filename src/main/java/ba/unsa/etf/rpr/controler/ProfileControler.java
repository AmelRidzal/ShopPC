package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Recite;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.List;

import static ba.unsa.etf.rpr.business.UserManager.CkeckEmail;
import static ba.unsa.etf.rpr.controler.MainControler.*;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;

public class ProfileControler {


    @FXML
    public Label usernameLabel;
    @FXML
    public Button adminButton;
    public ListView<String> reciteList;

    public TextField newEmail,newUsername,newPassword;
    public Label ChangeErrorSuccses;
    @FXML
    public void initialize() {
        if(currentUser.getId()!=12){
            adminButton.setDisable(true);
            adminButton.setOpacity(0);
        }
        try {
            usernameLabel.setText(currentUser.getUsername());
           loadRecite();
        } catch (Exception e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }}

    public void loadRecite() throws Exception {
        List<Recite> rec= DaoFactory.reciteDao().getUserRecite(currentUser.getId());
        for(Recite recite:rec){
                reciteList.getItems().add(recite.toString());

        }
    }
    public void openHome(ActionEvent actionEvent) {
        KatalogControler.setSold(false);
            MainHomeScreen();
        }

    public void openSold() {
        KatalogControler.setSold(true);
        MainHomeScreen();

    }
    public void openProfile(){
        MainProfileScreen();
    }
    public void openAdmin(){
        MainAdminScreen();
    }

    public void ChangeColor(MouseEvent mouseEvent) {
        MainChangeColor(mouseEvent);

    }

    public void RevertColor(MouseEvent mouseEvent) {
        MainRevertColor(mouseEvent);
    }





    public void changeEmail(ActionEvent actionEvent) throws Exception {
        String s=newEmail.getText();
        if(s.isEmpty()){
            ChangeErrorSuccses.setTextFill(RED);
            ChangeErrorSuccses.setText("Field cant be empty");
        }else  if(CkeckEmail(s)){
            ChangeErrorSuccses.setTextFill(RED);
            ChangeErrorSuccses.setText("Email already registerd");
        }else{
            currentUser.setEmail(s);
            DaoFactory.userDao().update(currentUser);

            ChangeErrorSuccses.setTextFill(GREEN);
            ChangeErrorSuccses.setText("Email successfully changed");
            newEmail.clear();
        }

    }

    public void changeUsername(ActionEvent actionEvent) throws Exception {
        String s=newUsername.getText();
        if(s.isEmpty()) {
            ChangeErrorSuccses.setTextFill(RED);
            ChangeErrorSuccses.setText("Field cant be empty");
        }
        else {
            currentUser.setUsername(s);
            DaoFactory.userDao().update(currentUser);
            ChangeErrorSuccses.setTextFill(GREEN);
            ChangeErrorSuccses.setText("Username successfully changed");
            usernameLabel.setText(currentUser.getUsername());
            newUsername.clear();
        }
    }

    public void changePassword(ActionEvent actionEvent) throws Exception {
        String s=newPassword.getText();
        if(s.isEmpty()) {
            ChangeErrorSuccses.setTextFill(RED);
            ChangeErrorSuccses.setText("Field cant be empty");
        }
        else {
            currentUser.setPassword(s);
            DaoFactory.userDao().update(currentUser);
            ChangeErrorSuccses.setTextFill(GREEN);
            ChangeErrorSuccses.setText("Password successfully changed");
            newPassword.clear();
        }
    }

}
