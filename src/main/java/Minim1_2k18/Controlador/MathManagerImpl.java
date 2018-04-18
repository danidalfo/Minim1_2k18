package Minim1_2k18.Controlador;

import Minim1_2k18.Model.Institut;
import Minim1_2k18.Model.Operacio;
import org.apache.log4j.Logger;

import java.util.*;

public class MathManagerImpl implements MathManager {

    //Variables

    private static MathManagerImpl instance = null;
    final static Logger logger = Logger.getLogger(MathManagerImpl.class);

    private Queue<Operacio> operacions;
    private List<Operacio> operacionsResoltes;
    private Operacio ultimaOp;
    private List<Institut> instituts;

    //Singleton

    public static MathManagerImpl getInstance() {
        if (instance == null) instance = new MathManagerImpl();
        return instance;
    }

    public void reiniciarSingleton()
    {
        instance = null;
    }

    //Constructors

    public MathManagerImpl() {
        this.operacions = new ArrayDeque<>();
        this.operacionsResoltes = new ArrayList<>();
        this.instituts = new ArrayList<>();
    }

    //Getters

    public Queue<Operacio> getOrders() {
        return operacions;
    }

    public List<Operacio> getServedOrders() {
        return operacionsResoltes;
    }

    public List<Institut> getInstituts() {return instituts;}

    // Setters

    public void setInstituts(List<Institut> instituts) {
        this.instituts = instituts;
    }


    // Public functions

    // 1.

    public boolean realitzarOp (int idAlumne ,int idInstitut){

        logger.info("realitzarOp: Realitzant l'operacio...");

        this.operacions.add(new Operacio(idAlumne,idInstitut,false));

        logger.info("realitzarOp: Operacio realitzada");
        return true;
    }

    // 2.

    public Operacio procesarOp (){

        logger.info("procesarOp: Calculant..");

        if(!operacions.isEmpty()) {
            this.operacionsResoltes.add(this.operacions.element());
            ultimaOp=this.operacions.element();
            this.operacions.remove();

            logger.info("procesarOp: Calculada amb exit");

            return ultimaOp;
        }

        else {

            logger.warn("procesarOp: No hi ha operacions per resoldre");
            return new Operacio();
        }

    }

    // 3.

    public List<Operacio> getOperacionsInstitut (int idInstitut){

        List<Operacio> temp = new ArrayList<>();

        if (isInstitutOnQueue(idInstitut)) {

            logger.info("getOperacionsIntstitut: Getting all operacions products from Institut: "+idInstitut);

            for(Operacio o : this.operacionsResoltes) {
                if (o.getIdInstitut() == idInstitut)
                    temp.add(o);
            }
            logger.info("getOperacionsInstitut: Historic from Institut: "+idInstitut+" retreived");
            return temp;
        }
        else {
            logger.warn("getOperacionsInstitut: There is no historic from id: "+idInstitut);
            return temp;
        }
    }

    // 4.

    public List<Operacio> getOperacionsAlumne (int idAlumne){

        List<Operacio> temp = new ArrayList<>();

        if (isAlumneOnQueue(idAlumne)) {

            logger.info("getOperacionsAlumne: Getting all operacions products from alumne: "+idAlumne);

            for(Operacio o : this.operacionsResoltes) {
                if (o.getIdAlumne() == idAlumne)
                    temp.add(o);
            }
            logger.info("getOperacionsAlumne: Historic from Alumne: "+idAlumne+" retreived");
            return temp;
        }
        else {
            logger.warn("getOperacionsAlumne: There is no historic from id: "+idAlumne);
            return temp;
        }
    }

    // 5.

    public List<Institut> getInstitutsSortedByOps(){

        if (!operacionsResoltes.isEmpty()) {
            logger.info("getInstitutsSortedByOps: Sorting all instituts by no. ops, if no null It's okay");


          //  return sortInstitutsByOps(instituts);
            return instituts;
    }

        else {
            logger.warn("getInstitutsSortedByOps: There are no instituts yet");
            return null;
        }
    }




    // Private functions

    private boolean isInstitutOnQueue (int idInstitut) {
        for(Operacio o : operacionsResoltes) {
            if(o.getIdInstitut() == idInstitut)
                return true;
        }
        return false;
    }

    private boolean isAlumneOnQueue (int idAlumne) {
        for(Operacio o : operacionsResoltes) {
            if(o.getIdAlumne() == idAlumne)
                return true;
        }
        return false;
    }

   // private List<Institut> sortInstitutsByOps(List<Institut> instituts) {
       // instituts.sort(Comparator.comparing(Institut::getNumOperacions));
  //      return instituts;
 //   }



}
