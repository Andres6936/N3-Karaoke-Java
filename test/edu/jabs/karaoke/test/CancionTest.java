package edu.jabs.karaoke.test;

import edu.jabs.karaoke.mundo.Cancion;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los m�todos de la clase Cancion est�n correctamente implementados.
 */
public class CancionTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Cancion cancion;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea una nueva canci�n.
     * 
     */
    private void setupEscenario1( )
    {
        cancion = new Cancion( "nombre", 100, "letra", 5, "ruta" );
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * Cancion<br>
     * darNombre<br>
     * darDuracion<br>
     * darDificultad<br>
     * darLetra<br>
     * darRuta<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente la canci�n, cada uno de los valores corresponde al esperado.<br>
     */
    public void testCancion( )
    {
        setupEscenario1( );

        assertNotNull( "El nombre de la canci�n no fue inicializado.", cancion.darNombre( ) );
        assertEquals( "El nombre de la canci�n no es el esperado.", "nombre", cancion.darNombre( ) );
        assertEquals( "La duraci�n de la canci�n no es la esperada.", 100, cancion.darDuracion( ) );
        assertEquals( "La dificultad de la canci�n no es el esperada.", 5, cancion.darDificultad( ) );
        assertNotNull( "La letra de la canci�n no fue inicializada.", cancion.darLetra( ) );
        assertEquals( "La letra de la canci�n no es la esperada.", "letra", cancion.darLetra( ) );
        assertNotNull( "La ruta de la canci�n no fue inicializada.", cancion.darRuta( ) );
        assertEquals( "La ruta de la canci�n no es la esperada.", "ruta", cancion.darRuta( ) );
    }

}
