package service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dao.impl.HibernateDataDAO;
import dao.impl.HibernateGameDAO;
import dao.impl.HibernateStudyDAO;
import dao.interf.DataDAO;
import dao.interf.GameDAO;
import dao.interf.StudyDAO;
import model.Game;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.DataServiceImpl;
import service.impl.GameServiceImpl;
import service.impl.ServiceStudy;
import service.interf.DataService;
import service.interf.JuegoService;

import java.util.List;

public class TestGames {
    private DataDAO dataDAO;
    private DataService dataService;
    //Servicio juego
    private GameDAO gameDAO;
    private JuegoService juegoService;
    //Service estudio
    private StudyDAO studyDAO;
    private ServiceStudy serviceStudy;


    @Before
    public void setUp(){
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        gameDAO = new HibernateGameDAO();
        juegoService = new GameServiceImpl(gameDAO);
        studyDAO = new HibernateStudyDAO();
        serviceStudy = new ServiceStudy(studyDAO);
        dataService.crearDatosIniciales();


    }
    @Test
    public void crear_datos(){
        Game mario = juegoService.buscarJuego("Mario Bros");
        Assert.assertEquals("Mario Bros",mario.getNombre());
        Game sonic = juegoService.buscarJuego("Sonic");
        Assert.assertEquals("Sonic",sonic.getNombre());
        Game fifa = juegoService.buscarJuego("FiFA 2019");
        Assert.assertEquals("FiFA 2019",fifa.getNombre());
        Game sonicMania = juegoService.buscarJuego("Sonic Mania");
        Assert.assertEquals("Sonic Mania",sonicMania.getNombre());
        Game lengendOfZelda = juegoService.buscarJuego("Lengend Of Zelda");
        Assert.assertEquals("Lengend Of Zelda",lengendOfZelda.getNombre());
        Game luigiMansion = juegoService.buscarJuego("Luigi Mansion");
        Assert.assertEquals("Luigi Mansion",luigiMansion.getNombre());
        Game tetris = juegoService.buscarJuego("Tetris");
        Assert.assertEquals("Tetris",tetris.getNombre());
    }
    @Test
    public void juegos_de_nintendo(){
        List<Game> juegosDeNintendo = serviceStudy.gamesOfStudy("Nintendo");
        Assert.assertEquals(7,juegosDeNintendo.size());
        Game mario = juegosDeNintendo.get(0);
        Assert.assertEquals("Mario Bros",mario.getNombre());
        Game sonic = juegosDeNintendo.get(1);
        Assert.assertEquals("Sonic",sonic.getNombre());
        Game fifa = juegosDeNintendo.get(2);
        Assert.assertEquals("FiFA 2019",fifa.getNombre());
        Game sonicMania = juegosDeNintendo.get(3);
        Assert.assertEquals("Sonic Mania",sonicMania.getNombre());
        Game lengendOfZelda = juegosDeNintendo.get(4);;
        Assert.assertEquals("Lengend Of Zelda",lengendOfZelda.getNombre());
        Game luigiMansion = juegosDeNintendo.get(5);
        Assert.assertEquals("Luigi Mansion",luigiMansion.getNombre());
        Game tetris = juegosDeNintendo.get(6);
        Assert.assertEquals("Tetris",tetris.getNombre());


    }

    @Test
    public void juegos_de_red_Barrels(){
        List<Game> juegosDeredBarrels = serviceStudy.gamesOfStudy("Red Barrels");
        Assert.assertEquals(3,juegosDeredBarrels.size());
        Game outlast = juegosDeredBarrels.get(0);
        Assert.assertEquals("Outlast",outlast.getNombre());
        Game outlast2 = juegosDeredBarrels.get(1);
        Assert.assertEquals("Outlast 2",outlast2.getNombre());
        Game outlastWhistleblawer = juegosDeredBarrels.get(2);
        Assert.assertEquals("Outlast Whistleblower",outlastWhistleblawer.getNombre());

    }
    @Test
    public void juegos_de_activision(){
        List<Game> juegosDeActivision = serviceStudy.gamesOfStudy("Activision");
        Assert.assertEquals(4,juegosDeActivision.size());
        Game callofdutyblackops = juegosDeActivision.get(0);
        Assert.assertEquals("Call of duty black ops",callofdutyblackops.getNombre());
        Game callofdutyblackops2 = juegosDeActivision.get(1);
        Assert.assertEquals("Call of duty black ops 2",callofdutyblackops2.getNombre());
        Game callofdutyblackops3 = juegosDeActivision.get(2);
        Assert.assertEquals("Call of duty black ops 3",callofdutyblackops3.getNombre());
        Game callofdutyblackops4 = juegosDeActivision.get(3);
        Assert.assertEquals("Call of duty black ops 4",callofdutyblackops4.getNombre());


    }
    @Test
    public void juegos_de_valve(){
        List<Game>juegosDeValve = serviceStudy.gamesOfStudy("Valve");
        Assert.assertEquals(4,juegosDeValve.size());
        Game leftOfDead = juegosDeValve.get(0);
        Assert.assertEquals("Left of dead",leftOfDead.getNombre());
        Game leftOfDead2 = juegosDeValve.get(1);
        Assert.assertEquals("Left of dead 2",leftOfDead2.getNombre());
        Game halfLife = juegosDeValve.get(2);
        Assert.assertEquals("Half life",halfLife.getNombre());
        Game halfLife2 = juegosDeValve.get(3);
        Assert.assertEquals("Half life 2",halfLife2.getNombre());

    }
    @Test
    public void juegos_de_eaDigitalIllusionsCe(){
        List<Game>juegosdeeaDigitalIllusionsCe= serviceStudy.gamesOfStudy("EaDigitalIllusionsCe");
        Assert.assertEquals(5,juegosdeeaDigitalIllusionsCe.size());
    }

    @Test
    public void juegos_de_capcom(){
        List<Game>juegosDeCapcom = serviceStudy.gamesOfStudy("Capcom");
        Assert.assertEquals(10,juegosDeCapcom.size());
    }
    @Test
    public void juegos_de_sCESantaMonicaStudio(){
        List<Game>juegossCESantaMonicaStudio = serviceStudy.gamesOfStudy("SCE Santa Monica Studio");
        Assert.assertEquals(4,juegossCESantaMonicaStudio.size());
    }
    @Test
    public void juegos_de_generation(){
        List<Game>juegosdeGeneration = serviceStudy.gamesOfStudy("Generation");
        Assert.assertEquals(18,juegosdeGeneration.size());
    }

    @After
    public void eliminarDatos(){
        dataService.eliminarDatos();
    }




}
