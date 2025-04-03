package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Katalog;
import ba.unsa.etf.rpr.domain.Recite;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import static ba.unsa.etf.rpr.business.KatalogManager.purchaseArticle;
import static ba.unsa.etf.rpr.controler.KatalogControler.BlobToImage;
import static ba.unsa.etf.rpr.controler.KatalogControler.getarticleID;
import static ba.unsa.etf.rpr.controler.MainControler.*;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;

public class ArticleControler {


    @FXML
    public Text articleName, articleClass, articlePrice, articleDiscription,purchaseErrorSucsses,articleAmount;
    @FXML
    public ImageView articleImage;
    @FXML
    public TextField purchaseAmount;
    @FXML
    public Label usernameLabel;
    private Katalog art;
    @FXML
    public void initialize() throws Exception {
        usernameLabel.setText(currentUser.getUsername());
        ArticleLoader();
    }
    public void ArticleLoader() throws Exception {
        art=DaoFactory.katalogDao().getById(getarticleID());
        articleName.setText(art.getTankName());
        articleClass.setText(art.getTankClass());
        articlePrice.setText(String.valueOf(art.getPrice()));
        articleImage.setImage(BlobToImage(art.getTankImage()));
        articleDiscription.setText((art.getDescription()));
        articleAmount.setText(art.getTankAmount() +" left in stock");
    }


    public void ChangeColor(MouseEvent mouseEvent) {
        MainChangeColor(mouseEvent);

    }

    public void RevertColor(MouseEvent mouseEvent) {
        MainRevertColor(mouseEvent);
    }





    public void articlePurchase() throws Exception {
        try {
            int amount= getAmount();
            if(amount>art.getTankAmount()){
                purchaseErrorSucsses.setFill(RED);
                purchaseErrorSucsses.setText("amount greater than stock");

            }else if(amount!=0) {
                Recite r =new Recite(currentUser.getId(), art.getId(),amount,amount*art.getPrice(),art.getTankName());
                purchaseArticle(r);
                purchaseErrorSucsses.setFill(GREEN);
                purchaseErrorSucsses.setText("purchase successful");
                setArticleAmount();
            }else {
                purchaseErrorSucsses.setFill(RED);
                purchaseErrorSucsses.setText("incorrect amount input");

            }
        }catch (Exception e){
            purchaseErrorSucsses.setFill(RED);
            purchaseErrorSucsses.setText("purchase failed");
            throw e;

        }
    }

    public void setArticleAmount() throws Exception {
        if(DaoFactory.katalogDao.getById(getarticleID()).getTankAmount()!=0) {
            articleAmount.setText(DaoFactory.katalogDao.getById(getarticleID()).getTankAmount() + " left in stock");
        }else{
            articleAmount.setFill(RED);
            articleAmount.setText("out of stock");
        }
    }

    public int getAmount(){
        String s=purchaseAmount.getText();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9' ){
                //throwError
                return 0;
            }

        }
        return Integer.parseInt(s);
    }



    public void openProfile(ActionEvent actionEvent) {
        MainProfileScreen();
    }




        public void openSold() {
        KatalogControler.setSold(true);
            MainHomeScreen();

    }

    public void openHome(ActionEvent actionEvent) {
        KatalogControler.setSold(false);
        MainHomeScreen();
    }
}
