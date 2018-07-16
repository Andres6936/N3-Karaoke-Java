package edu.jabs.karaoke.test;

import edu.jabs.karaoke.mundo.Cancion;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los métodos de la clase Cancion estén correctamente implementados.
 */
public class CancionTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Cancion cancion;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea una nueva canción.
     * 
     */
    private void setupEscenario1( )
    {
        cancion = new Cancion( "nombre", 100, "letra", 5, "ruta" );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * Cancion<br>
     * darNombre<br>
     * darDuracion<br>
     * darDificultad<br>
     * darLetra<br>
     * darRuta<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente la canción, cada uno de los valores corresponde al esperado.<br>
     */
    public void testCancion( )
    {
        setupEscenario1( );

        assertNotNull( "El nombre de la canción no fue inicializado.", cancion.darNombre( ) );
        assertEquals( "El nombre de la canción no es el esperado.", "nombre", cancion.darNombre( ) );
        assertEquals( "La duración de la canción no es la esperada.", 100, cancion.darDuracion( ) );
        assertEquals( "La dificultad de la canción no es el esperada.", 5, cancion.darDificultad( ) );
        assertNotNull( "La letra de la canción no fue inicializada.", cancion.darLetra( ) );
        assertEquals( "La letra de la canción no es la esperada.", "letra", cancion.darLetra( ) );
        assertNotNull( "La ruta de la canción no fue inicializada.", cancion.darRuta( ) );
        assertEquals( "La ruta de la canción no es la esperada.", "ruta", cancion.darRuta( ) );
    }

}
