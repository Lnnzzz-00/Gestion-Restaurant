package sio.gestionrestaurant;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sio.gestionrestaurant.Model.Carte;
import sio.gestionrestaurant.Model.Menu;
import sio.gestionrestaurant.Model.Plat;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GestionRestaurantController implements Initializable
{
    ArrayList<Carte> mesCartes;
    Alert alert = new Alert(Alert.AlertType.WARNING);

    @FXML
    private TableView tvCartes;
    @FXML
    private TableColumn tcNumeroCarte;
    @FXML
    private TableColumn tcNomCarte;
    @FXML
    private TableView tvPlats;
    @FXML
    private TableColumn tcNumeroPlat;
    @FXML
    private TableColumn tcNomPlat;
    @FXML
    private TableColumn tcNotePlat;
    @FXML
    private TableView tvMenus;
    @FXML
    private TableColumn tcNumeroMenu;
    @FXML
    private TableColumn tcNomMenu;
    @FXML
    private ImageView imgPlat;
    @FXML
    private TextField txtMeilleurPlat;
    @FXML
    private TextField txtMeilleurNote;
    @FXML
    private Button btnNoter;
    @FXML
    private Label lblNoteMenu;
    @FXML
    private Slider sldNote;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        mesCartes = new ArrayList<>();
        initDatas();

        // A vous de jouer
        tcNumeroCarte.setCellValueFactory(new PropertyValueFactory<>("idCarte"));
        tcNomCarte.setCellValueFactory(new PropertyValueFactory<>("nomCarte"));
        tvCartes.setItems(FXCollections.observableArrayList(mesCartes));
    }


    // NE PAS MODIFIER LE CODE DE CETTE METHODE
    public void initDatas()
    {
        Carte cartePrintemps = new Carte(1, "Carte de printemps");
        Carte carteHiver = new Carte(2, "Carte d'hiver");

        Menu menuBio = new Menu(1, "Menu Bio");
        Menu menuVIP = new Menu(2, "Menu VIP");
        Menu menuGourmand = new Menu(3, "Menu gourmand");

        Plat entree1 = new Plat(1, "Avocado toast oeuf poché", 0, "/Images/Avocado.jpg");
        Plat entree2 = new Plat(2, "Burrata à la tomate", 0, "/Images/Burrata.jpg");
        Plat entree3 = new Plat(3, "Shakshouka", 0, "/Images/Shakshouka.jpg");
        Plat entree4 = new Plat(4, "Avocado toast oeuf poché", 0, "/Images/Avocado.jpg");
        Plat plat1 = new Plat(5, "Ballottine de volaille", 0, "/Images/Ballottine.jpg");
        Plat plat2 = new Plat(6, "Cabillaud en croûte", 0, "/Images/Cabillaud.jpg");
        Plat plat3 = new Plat(7, "Brochettes de crevettes", 0, "/Images/Brochettes.jpg");
        Plat dessert1 = new Plat(8, "Pancake", 0, "/Images/Pancake.jpg");
        Plat dessert2 = new Plat(9, "Fromage Blanc", 0, "/Images/FromageBlanc.jpg");
        Plat dessert3 = new Plat(10, "Brownie", 0, "/Images/Brownie.jpg");
        Plat dessert4 = new Plat(11, "Gauffre", 0, "/Images/Gauffre.jpg");

        menuBio.ajouterPlat(entree1); menuBio.ajouterPlat(plat2); menuBio.ajouterPlat(dessert2);

        menuVIP.ajouterPlat(entree4); menuVIP.ajouterPlat(entree2); menuVIP.ajouterPlat(plat1);
        menuVIP.ajouterPlat(dessert1); menuVIP.ajouterPlat(dessert4);

        menuGourmand.ajouterPlat(entree3); menuGourmand.ajouterPlat(plat3); menuGourmand.ajouterPlat(dessert3);

        carteHiver.ajouterMenu(menuGourmand); carteHiver.ajouterMenu(menuVIP);
        cartePrintemps.ajouterMenu(menuBio);

        mesCartes.add(cartePrintemps);
        mesCartes.add(carteHiver);
    }

    @FXML
    public void tvCartesClicked(Event event)
    {
        tcNumeroMenu.setCellValueFactory(new PropertyValueFactory<>("idMenu"));
        tcNomMenu.setCellValueFactory(new PropertyValueFactory<>("nomMenu"));

        Carte carteSelectionnee = (Carte) tvCartes.getSelectionModel().getSelectedItem();
        tvMenus.setItems(FXCollections.observableArrayList(carteSelectionnee.getLesMenus()));

        // BONUS : Efface le meilleur plat, sa note et la note totale du menu quand on reclique sur une autre carte
        txtMeilleurPlat.setText("");
        txtMeilleurNote.setText("");
        lblNoteMenu.setText("");
    }

    @FXML
    public void tvPlatsClicked(Event event)
    {
        // A vous de jouer
        // on ne fait pas les images

    }

    @FXML
    public void tvMenusClicked(Event event)
    {
        // A vous de jouer
        tcNumeroPlat.setCellValueFactory(new PropertyValueFactory<>("idPlat"));
        tcNomPlat.setCellValueFactory(new PropertyValueFactory<>("nomPlat"));
        tcNotePlat.setCellValueFactory(new PropertyValueFactory<>("notePlat"));

        Menu menuSelectionne = (Menu) tvMenus.getSelectionModel().getSelectedItem();

        // affiche les plats du menu sélectionné
        tvPlats.setItems(FXCollections.observableArrayList(menuSelectionne.getLesPlats()));
        lblNoteMenu.setText(String.valueOf(menuSelectionne.calculerNote()));

        // affiche le meilleur plat du menu sélectionné
        Plat meilleurPlat = menuSelectionne.getBestNomPlat();
        txtMeilleurPlat.setText(meilleurPlat.getNomPlat());
        txtMeilleurNote.setText(String.valueOf(meilleurPlat.getNotePlat()));
    }

    @FXML
    public void btnNoterClicked(Event event)
    {
        // A vous de jouer
        Plat platSelectionne = (Plat) tvPlats.getSelectionModel().getSelectedItem();
        
        // Vérification de la sélection sinon alert
        if (platSelectionne == null) {
            alert.setContentText("Veuillez sélectionner un plat avant de le noter.");
            alert.showAndWait();
        } else {
            // met à jour la note du plat sélectionné
            int note = (int) sldNote.getValue();
            platSelectionne.calculerNotePlat(note);

            // met à jour le TableView des plats
            tvPlats.refresh();

            // met à jour la note globale du menu
            Menu menuSelectionne = (Menu) tvMenus.getSelectionModel().getSelectedItem();
            lblNoteMenu.setText(String.valueOf(menuSelectionne.calculerNote()));

            // met à jour l'affichage du plat le mieux noté de ce menu
            Plat meilleurPlat = menuSelectionne.getBestNomPlat();
            txtMeilleurPlat.setText(meilleurPlat.getNomPlat());
            txtMeilleurNote.setText(String.valueOf(meilleurPlat.getNotePlat()));

            // BONUS : jai envoyé la vue a une I.A. (GEMINI) pour l'ameliorer en lui ajoutant un CSS
        }
    }
}