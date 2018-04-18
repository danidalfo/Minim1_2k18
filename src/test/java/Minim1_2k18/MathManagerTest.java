package Minim1_2k18;


import Minim1_2k18.Controlador.MathManager;
import Minim1_2k18.Controlador.MathManagerImpl;
import Minim1_2k18.Model.Alumne;
import Minim1_2k18.Model.Institut;
import Minim1_2k18.Model.Operacio;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MathManagerTest {

    // Inicialitzo les Variables
    private final static Logger logger = Logger.getLogger(MathManagerTest.class);

    private Alumne alumne1;
    private Alumne alumne2;

    private List<Alumne> alumnes;


    private Institut ins1;
    private Institut ins2;

    private List<Institut> instituts;

    private Operacio op1;
    private Operacio op2;

    private List<Operacio> operacions;



    // SetUp
    @Before

    public void setUp() throws Exception {

        alumne1 = new Alumne (3);
        alumne2 = new Alumne (1);

        alumnes = new ArrayList<>();

        alumnes.add(alumne1);
        alumnes.add(alumne2);


        ins1 = new Institut(1,6,alumnes);
        ins2 = new Institut(1,6,alumnes);

        instituts = new ArrayList<>();

        instituts.add(ins1);
        instituts.add(ins2);

        op1 = new Operacio (1, 1, false, "operacio");
        op2 = new Operacio (2, 2, false, "operacio");


        operacions = new ArrayList<>();

        operacions.add(op1);
        operacions.add(op2);

        MathManagerImpl.getInstance().setInstituts(instituts);

    }

    @After
    public void tearDown()
    {
        MathManagerImpl.getInstance().reiniciarSingleton();
    }

    @Test
    public void makeOpTest(){

        logger.info("Realitzant una operacio...");
        Assert.assertTrue(MathManagerImpl.getInstance().realitzarOp(2,1));
        logger.info("Operacio realitzada...");
    }

   

}
