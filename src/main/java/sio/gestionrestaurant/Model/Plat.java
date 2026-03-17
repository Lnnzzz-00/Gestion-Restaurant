package sio.gestionrestaurant.Model;

public class Plat
{
    private int idPlat;
    private String nomPlat;
    private int notePlat;
    private String imagePlat;

    public Plat(int idPlat, String nomPlat, int notePlat, String imagePlat) {
        this.idPlat = idPlat;
        this.nomPlat = nomPlat;
        this.notePlat = notePlat;
        this.imagePlat = imagePlat;
    }

    public int getIdPlat() {
        return idPlat;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public int getNotePlat() {
        return notePlat;
    }

    public String getImagePlat() {
        return imagePlat;
    }

    // Cette méthode permet d'additionner la note passée en paramètre
    // à la note du plat.
    public void calculerNotePlat(int uneNote)
    {
        this.notePlat += uneNote;
    }
}
