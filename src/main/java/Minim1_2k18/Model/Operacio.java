package Minim1_2k18.Model;

public class Operacio {

    // Atributs privats

    private int idAlumne;
    private int idInstitut;
    private String operacio;

    // Constructors

    public Operacio (int idAlumne, int idInstitut, boolean resolta, String operacio) {
        this.idAlumne = idAlumne;
        this.idInstitut = idInstitut;
        this.operacio=operacio;
    }

    public Operacio () {}

    // Getters i Setters

    public int getIdAlumne() {
        return idAlumne;
    }

    public void setIdAlumne(int idAlumne) {
        this.idAlumne = idAlumne;
    }

    public int getIdInstitut() {
        return idInstitut;
    }

    public void setIdInstitut(int idInstitut) {
        this.idInstitut = idInstitut;
    }

    public String getOperacio() {
        return operacio;
    }

    public void setOperacio(String operacio) {
        this.operacio = operacio;
    }
}
