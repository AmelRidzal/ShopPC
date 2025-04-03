package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.business.KatalogManager;
import ba.unsa.etf.rpr.dao.AbstractDao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Katalog;
import ba.unsa.etf.rpr.domain.Recite;
import ba.unsa.etf.rpr.domain.User;
import com.mysql.cj.jdbc.Blob;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

import static ba.unsa.etf.rpr.controler.KatalogControler.BlobToImage;
import static ba.unsa.etf.rpr.controler.MainControler.*;

public class AdminControler {

    private FileChooser fileChooser;
    @FXML
    public Label usernameLabel;
    @FXML
    private Button browseButton;
    @FXML
    private TextField browseTextArea,nameTankField,idTankField,priceTankField,classTankField,amountTankField;
    @FXML
    private TextArea descriptionTankField;
    @FXML
    private TextField idReciteField,userIdReciteField,tankIdReciteField,amountReciteField,totalReciteField,tankNameReciteField;
    @FXML
    private TextField idUserField,usernameUserField,emailUserField,passwordUserField;
    @FXML
    private ImageView browseImageView;
    private Image browseImage;
    private File file;
    private FileInputStream fis=new FileInputStream("src/main/resources/ba/unsa/etf/rpr/default.jpg");

    public AdminControler() throws FileNotFoundException {
    }

    @FXML
    public void initialize() throws IOException {
        usernameLabel.setText(currentUser.getUsername());
        fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files","*.jpg","*.png")
        );

        BufferedImage imagen = ImageIO.read(fis);
        browseImage = SwingFXUtils.toFXImage(imagen,null);
        browseImageView.setImage(browseImage);
    }

    public void onBrowserButtonClick() throws Exception {
        file=fileChooser.showOpenDialog(stage1);
        if(file != null){
            browseTextArea.setText(file.getAbsolutePath());
            fis=new FileInputStream(file);
            BufferedImage imagen = ImageIO.read(fis);
            browseImage = SwingFXUtils.toFXImage(imagen,null);
            browseImageView.setImage(browseImage);
        }
    }




     public static Blob ImageToBlob(Image image) throws IOException, SQLException {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            byte[] byteArray = baos.toByteArray();
            SerialBlob blob = new SerialBlob(byteArray);
//            String username="projekt";
//            String password="!154TrE?Cf154!";
//            String URL="jdbc:mysql://localhost/freedb_wotdatamain";
//            Connection connection= DriverManager.getConnection(URL,username,password);

            return  convertToBlob(blob, AbstractDao.connection);
        }

    public static Blob convertToBlob(SerialBlob serialBlob, Connection connection) throws SQLException, IOException {
        InputStream inputStream = serialBlob.getBinaryStream();
        PreparedStatement statement = connection.prepareStatement("SELECT ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.setBlob(1, inputStream);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        Blob blob = (Blob) resultSet.getBlob(1);
        resultSet.close();
        statement.close();
        inputStream.close();
        return blob;
    }



    public void setUpadeNewTank(Katalog k) throws SQLException, IOException {
        idTankField.setText(String.valueOf(k.getId()));
        nameTankField.setText(k.getTankName());
        classTankField.setText((k.getTankClass()));
        amountTankField.setText(String.valueOf(k.getTankAmount()));
        priceTankField.setText(String.valueOf((k.getPrice())));
        descriptionTankField.setText(k.getDescription());
        browseImageView.setImage(BlobToImage(k.getTankImage()));
    }
    public Katalog getUpdateNewTank(boolean b) throws IOException, SQLException {

        Katalog k=new Katalog();
        if(b) {
            k.setId(Integer.parseInt(idTankField.getText()));
        }else {
            k.setId(0);
        }
        k.setTankName(nameTankField.getText());
        k.setTankClass(classTankField.getText());
        k.setTankAmount(Integer.parseInt(amountTankField.getText()));
        k.setPrice(Integer.parseInt(priceTankField.getText()));
        k.setDescription(descriptionTankField.getText());
        k.setTankImage(ImageToBlob(browseImageView.getImage()));
        return k;
    }
    public void onLoadTankByIdClick() throws Exception {
        Katalog k=DaoFactory.katalogDao().getById(Integer.parseInt(idTankField.getText()));
        setUpadeNewTank(k);
    }
    public void onUpdateTankClick() throws Exception {
        DaoFactory.katalogDao().update(getUpdateNewTank(true));
    }

    public void onAddNewTankClick() throws Exception {
        DaoFactory.katalogDao().add(getUpdateNewTank(false));
    }

    public void onRemoveTankClick() throws Exception {
        DaoFactory.katalogDao().delete(getUpdateNewTank(true).getId());
    }




    public void setUpdateNewRecite(Recite r){
        idReciteField.setText(String.valueOf(r.getId()));
        userIdReciteField.setText(String.valueOf(r.getUserId()));
        tankIdReciteField.setText(String.valueOf(r.getTankId()));
        amountReciteField.setText(String.valueOf(r.getAmount()));
        totalReciteField.setText(String.valueOf(r.getTotal()));
        tankNameReciteField.setText(r.getTankName());
    }
    public Recite getUpdateNewRecite(boolean b){
        Recite r=new Recite();
        if(b) {
            r.setId(Integer.parseInt(idReciteField.getText()));
        }else {
            r.setId(0);
        }
        r.setUserId(Integer.parseInt(userIdReciteField.getText()));
        r.setTankId(Integer.parseInt(tankIdReciteField.getText()));
        r.setAmount(Integer.parseInt(amountReciteField.getText()));
        r.setTotal(Integer.parseInt(totalReciteField.getText()));
        r.setTankName(tankNameReciteField.getText());
        return r;
    }
    public void onLoadReciteByIdClick() throws Exception {
        Recite r=DaoFactory.reciteDao().getById(Integer.parseInt(idReciteField.getText()));
        setUpdateNewRecite(r);
    }
    public void onUpdateReciteClick() throws Exception {
        DaoFactory.reciteDao().update(getUpdateNewRecite(true));
    }

    public void onAddNewReciteClick() throws Exception {
        DaoFactory.reciteDao().add(getUpdateNewRecite(false));
    }

    public void onRemoveReciteClick() throws Exception {
        DaoFactory.reciteDao().delete(getUpdateNewRecite(true).getId());
    }





    public void setUpdateNewUser(User r){
        idUserField.setText(String.valueOf(r.getId()));
        usernameUserField.setText(r.getUsername());
        emailUserField.setText(r.getEmail());
        passwordUserField.setText(r.getPassword());
    }
    public User getUpdateNewUser(Boolean b){
        User u=new User();
            if(b) {
                u.setId(Integer.parseInt(idUserField.getText()));
            }else {
                u.setId(0);
            }
        u.setUsername(usernameUserField.getText());
        u.setEmail(emailUserField.getText());
        u.setPassword(passwordUserField.getText());
        return u;
    }
    public void onLoadUserByIdClick() throws Exception {
        User r=DaoFactory.userDao().getById(Integer.parseInt(idUserField.getText()));
        setUpdateNewUser(r);
    }
    public void onUpdateUserClick() throws Exception {
       DaoFactory.userDao().update(getUpdateNewUser(true));
    }

    public void onAddNewUserClick() throws Exception {
        DaoFactory.userDao().add(getUpdateNewUser(false));
    }

    public void onRemoveUserClick() throws Exception {
        DaoFactory.userDao().delete(getUpdateNewUser(true).getId());
    }




    public void openHome(){
        KatalogControler.setSold(false);
        MainHomeScreen();
    }
    public void openSold(){
        KatalogControler.setSold(false);
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
}
