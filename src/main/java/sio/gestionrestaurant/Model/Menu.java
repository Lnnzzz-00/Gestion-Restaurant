package sio.gestionrestaurant.Model;
import java.util.ArrayList;
public class Menu
{
    private int idMenu;
    private String nomMenu;
    private ArrayList<Plat> lesPlats;

    public Menu(int idMenu, String nomMenu) {
        this.idMenu = idMenu;
        this.nomMenu = nomMenu;
        this.lesPlats = new ArrayList<>();
    }

    public int getIdMenu() {
        return idMenu;
    }

    public String getNomMenu() {
        return nomMenu;
    }

    public ArrayList<Plat> getLesPlats() {
        return lesPlats;
    }

    // Cette méthode permet d'ajouter le plat passé
    // en paramètre à la liste des plats
    public void ajouterPlat(Plat nouveauPlat)
    {
        lesPlats.add(nouveauPlat);
    }

    // Cette méthode permet de calculer la note d'un menu
    // En cumulant chaque note de tous les plats du menu
    public int calculerNote()
    {
        // A vous de jouer
        int noteTotale = 0;
        for (Plat plat : lesPlats) {
            noteTotale += plat.getNotePlat();
        }
        return noteTotale;
    }

    // Cette méthode permet de récupérer le plat le mieux noté du menu
    public Plat getBestNomPlat()
    {
        Plat meilleurPlat = null;
        for (Plat plat : lesPlats) {
            if (meilleurPlat == null || plat.getNotePlat() > meilleurPlat.getNotePlat()) {
                meilleurPlat = plat;
            }
        }
        return meilleurPlat;
    }
}
