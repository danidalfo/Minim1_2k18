package Minim1_2k18.Model;

import java.util.ArrayList;
import java.util.List;

public class Institut {

    // Atributs privats

   private int idInstitut;
   private int numOperacions;
   private List<Alumne> alumnes;

   // Constructors

    public Institut(int idInstitut, int numOperacions, List<Alumne> alumnes) {
        this.idInstitut = idInstitut;
        this.numOperacions = numOperacions;
        this.alumnes = alumnes;
    }

    public Institut() {this.alumnes = new ArrayList<>();}

    // Getters i Setters

    public int getIdInstitut() {
        return idInstitut;
    }

    public void setIdInstitut(int idInstitut) {
        this.idInstitut = idInstitut;
    }

    public int getNumOperacions() {
        return numOperacions;
    }

    public void setNumOperacions(int numOperacions) {
        this.numOperacions = numOperacions;
    }

    public List<Alumne> getAlumnes() {
        return alumnes;
    }

    public void setAlumnes(List<Alumne> alumnes) {
        this.alumnes = alumnes;
    }
}
