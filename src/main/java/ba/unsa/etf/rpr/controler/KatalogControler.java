package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Katalog;
import com.mysql.cj.jdbc.Blob;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import static ba.unsa.etf.rpr.controler.MainControler.*;

public class KatalogControler {
    



    @FXML
    private Button homeButton, myCatalogButton, profileButton, openArticle,adminButton;

    @FXML
    public Label tankName1, tankClass1, tankPrice1, tankName2, tankClass2, tankPrice2, tankName3, tankClass3, tankPrice3;
    @FXML
    public Label tankName4, tankClass4, tankPrice4, tankName5, tankClass5, tankPrice5, tankName6, tankClass6, tankPrice6;
    @FXML
    public Label tankName7, tankClass7, tankPrice7, tankName8, tankClass8, tankPrice8, tankName9, tankClass9, tankPrice9;

    @FXML
    public ImageView tankImage1, tankImage2, tankImage3, tankImage4, tankImage5, tankImage6, tankImage7, tankImage8, tankImage9;
    @FXML
    public Label usernameLabel, noMoreLoad;
    @FXML
    public Button  openArticle1,openArticle2,openArticle3,openArticle4,openArticle5,openArticle6,openArticle7,openArticle8,openArticle9;
    public Vector<Integer> loadedTanksId = new Vector<>();
    public static int  articleID = 0,loadedTankId=0;
    public static boolean moreLoad = true, PreviusLoad = false;
    static boolean Sold;

    @FXML
    public void initialize() {
        try {
            if(currentUser.getId()!=12){
                adminButton.setDisable(true);
                adminButton.setOpacity(0);
            }
            loadedTankId=0;
            usernameLabel.setText(currentUser.getUsername());
            fixTankId();
            badHomeLoader();
        } catch (Exception e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }


    public void ChangeColor(MouseEvent mouseEvent) {
        MainChangeColor(mouseEvent);

    }

    public void RevertColor(MouseEvent mouseEvent) {
        MainRevertColor(mouseEvent);
    }





    public void openHome(ActionEvent actionEvent) throws Exception {
        loadedTankId=0;
        setSold(false);
        noMoreLoad.setText("");
        badHomeLoader();
    }

    public void openSold(ActionEvent actionEvent) throws Exception {
        loadedTankId=0;
        setSold(true);
        noMoreLoad.setText("");
        badHomeLoader();

    }

    public void openAdmin(ActionEvent actionEvent) {
        MainAdminScreen();

    }



    public static void setSold(boolean sold){
        Sold=sold;
    }
    public void loadeHomeArticle(Label Name, Label Class, Label Price, ImageView Image, Button artButton) throws Exception {


        if(loadedTankId+1<DaoFactory.katalogDao().getNextTankId()) {
            loadedTankId+=1;
            int i=1;
            Katalog tankToLoad = DaoFactory.katalogDao().getById(loadedTankId);
            while((tankToLoad.getTankAmount()==0)!=Sold){
                if(loadedTankId+i<DaoFactory.katalogDao().getNextTankId()) {
                    loadedTankId += 1;
                    tankToLoad = DaoFactory.katalogDao().getById(loadedTankId);
                }else {
                    moreLoad=false;
                    noMoreLoad.setText("No more tanks to load");
                    Name.setText(null);
                    Class.setText(null);
                    Price.setText(null);
                    Image.setImage(null);
                    artButton.setText(null);
                    break;
                }
            }
            Name.setText(tankToLoad.getTankName());
            Class.setText(tankToLoad.getTankClass());
            Price.setText(String.valueOf(tankToLoad.getPrice()));
            Image.setImage(BlobToImage(tankToLoad.getTankImage()));
            artButton.setText(String.valueOf(tankToLoad.getId()));
        }     else {
            moreLoad=false;
            noMoreLoad.setText("No more tanks to load");
            Name.setText(null);
            Class.setText(null);
            Price.setText(null);
            Image.setImage(null);
            artButton.setText(null);
        }


    }


    public void badHomeLoader() throws Exception {
        if(loadedTankId==0)
            moreLoad=true;
        if(moreLoad) {
            loadeHomeArticle(tankName1, tankClass1, tankPrice1, tankImage1, openArticle1);
            loadeHomeArticle(tankName2, tankClass2, tankPrice2, tankImage2, openArticle2);
            loadeHomeArticle(tankName3, tankClass3, tankPrice3, tankImage3, openArticle3);
            loadeHomeArticle(tankName4, tankClass4, tankPrice4, tankImage4, openArticle4);
            loadeHomeArticle(tankName5, tankClass5, tankPrice5, tankImage5, openArticle5);
            loadeHomeArticle(tankName6, tankClass6, tankPrice6, tankImage6, openArticle6);
            loadeHomeArticle(tankName7, tankClass7, tankPrice7, tankImage7, openArticle7);
            loadeHomeArticle(tankName8, tankClass8, tankPrice8, tankImage8, openArticle8);
            loadeHomeArticle(tankName9, tankClass9, tankPrice9, tankImage9, openArticle9);
        }

    }

    public void loadNextKatalog() throws Exception {
        if(moreLoad) {
            noMoreLoad.setText("");
        }
            badHomeLoader();
    }

    public void loadPreviusKatalog(ActionEvent actionEvent) throws Exception {
        loadedTankId-=17;
        if(loadedTankId==-8) {
            noMoreLoad.setText("No previous tanks to load");
            moreLoad=false;
        }
        else {
            noMoreLoad.setText("");
            moreLoad=true;
        }
        if(loadedTankId<0) {
            loadedTankId = 0;
        }
        badHomeLoader();
    }



    public void OpenArticle(ActionEvent actionEvent) {
        Button obj = (Button) actionEvent.getSource();
        String s = obj.getText();
        articleID = Integer.parseInt(s);
        MainArticleScene();
    }

    public static int getarticleID() {
        return articleID;
    }


    public void openProfile(ActionEvent actionEvent) {
        MainProfileScreen();
    }




    public static Image BlobToImage(@NotNull Blob blob) throws SQLException, IOException {
        InputStream in = blob.getBinaryStream();
        BufferedImage imagen = ImageIO.read(in);
        return SwingFXUtils.toFXImage(imagen,null);
    }


    public static void fixTankId() throws Exception {
        List<Katalog> k=DaoFactory.katalogDao().getAll();
        for(int i=1;i<=k.size();i++){
            if(k.get(i-1).getId()!=i){
                DaoFactory.katalogDao().updateTankId(k.get(k.size()-1).getId(), i);
                k=DaoFactory.katalogDao().getAll();
                i=0;
            }
        }
    }


}
