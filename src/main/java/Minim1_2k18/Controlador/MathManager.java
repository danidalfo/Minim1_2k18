package Minim1_2k18.Controlador;


import Minim1_2k18.Model.Institut;
import Minim1_2k18.Model.Operacio;

import java.util.List;

public interface MathManager {

    // 1. Realizar una operación matemática basada en la notación polaca inversa (por
    //parte de un alumno que pertenece a un instituto). Esta operación se procesará
    //más adelante (ver operación procesar una operación matemática).

    boolean realitzarOp (int idAlumne ,int idInstitut);

    // 2. Procesar una operación matemática. Las operaciones se procesan en orden
    // de llegadas y se retorna la operación con su valor calculado.

    Operacio procesarOp ();

    // 3. Listado de operaciones matemáticas realizadas por un instituto

    List<Operacio> getOperacionsInstitut (int idInstitut);

    // 4. Listado de operaciones matemáticas realizadas por un alumno

    List<Operacio> getOperacionsAlumne (int idAlumne);

    // 5. Listado de institutos ordenado (descendentemente) por número de
    // operaciones matemáticas realizadas por sus alumnos

    List<Institut> getInstitutsSortedByOps();


}
