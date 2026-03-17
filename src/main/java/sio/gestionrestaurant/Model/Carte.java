package sio.gestionrestaurant.Model;

import java.util.ArrayList;

public class Carte
{
    private int idCarte;
    private String nomCarte;
    private ArrayList<Menu> lesMenus;

    public Carte(int idCarte, String nomCarte) {
        this.idCarte = idCarte;
        this.nomCarte = nomCarte;
        this.lesMenus = new ArrayList<>();
    }

    public int getIdCarte() {
        return idCarte;
    }

    public String getNomCarte() {
        return nomCarte;
    }

    public ArrayList<Menu> getLesMenus() {
        return lesMenus;
    }

    // Cette méthode permet d'ajouter le menu passé
    // en paramètre à la liste des menus
    public void ajouterMenu(Menu nouveauMenu)
    {
        lesMenus.add(nouveauMenu);

    }

    // Cette méthode permet de récupérer le plat le mieux noté
    // C'est à dire celui qui a la note la plus grande
    public Plat getBestNomPlat()
    {
        Plat meilleurPlat = null;
        for (Menu menu : lesMenus) {
            for (Plat plat : menu.getLesPlats()) {
                if (meilleurPlat == null || plat.getNotePlat() > meilleurPlat.getNotePlat()) {
                    meilleurPlat = plat;
                }
            }
        }
        return meilleurPlat;
    }
}
