package edu.jabs.karaoke.test;

import karaoke.mundo.Cancion;
import karaoke.mundo.ListaReproduccion;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los mótodos de la clase ListaReproduccion estón correctamente implementados.
 */
public class ListaReproduccionTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harón las pruebas.
     */
    private ListaReproduccion listaDeReproduccion;

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva lista de reproducción sin canciones.
     */
    private void setupEscenario1( )
    {
        listaDeReproduccion = new ListaReproduccion( "Lista para viajar" );
    }

    /**
     * Escenario 2: Construye una nueva lista de reproducción con 2 canciones.
     */
    private void setupEscenario2( )
    {
        listaDeReproduccion = new ListaReproduccion( "Lista para viajar" );

        listaDeReproduccion.agregarCancion( new Cancion( "cancion1", 45, "letra15", 2, "ruta15" ) );
        listaDeReproduccion.agregarCancion( new Cancion( "cancion2", 45, "letra15", 2, "ruta15" ) );

    }

    /**
     * Prueba 1: Se encarga de verificar el mótodo constructor de la clase.<br>
     * <b> Mótodos a probar: </b> <br>
     * ListaReproduccion<br>
     * darNombre<br>
     * darCanciones<br>
     * <b> Caso de prueba:</b><br>
     * 1. Construye correctamente la lista de reproducción, cada uno de los valores corresponde al esperado.<br>
     */
    public void testListaReproduccion( )
    {
        setupEscenario1( );
        assertEquals( "Error al inicializar el nombre de la lista de reproducción.", "Lista para viajar", listaDeReproduccion.darNombre( ) );
        assertNotNull( "La lista de canciones no deberóa ser nula.", listaDeReproduccion.darCanciones( ) );
        assertEquals( "La lista de canciones no deberóa tener canciones.", 0, listaDeReproduccion.darCanciones( ).size( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el mótodo existeCancion de la clase.<br>
     * <b> Mótodos a probar: </b> <br>
     * existeCancion<br>
     * <b> Casos de prueba:</b><br>
     * 1. La lista de reproducción tiene una canción con el nombre dado. <br>
     * 2. La lista de reproducción no tiene una canción con el nombre dado.
     */
    public void testExisteCancion( )
    {
        setupEscenario2( );
        // 1
        assertNotNull( "La canción no deberóa ser nula.", listaDeReproduccion.buscarCancion( "cancion1" ) );

        // 2
        assertNull( "La canción deberóa ser nula.", listaDeReproduccion.buscarCancion( "cancion5" ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el mótodo agregarCancion.<br>
     * <b> Mótodos a probar: </b> <br>
     * agregarCancion<br>
     * darCanciones<br>
     * <b> Caso de prueba :</b><br>
     * 1. La lista de reproducción no tiene canciones y se agregan varias canciones.
     */
    public void testAgregarCancion( )
    {
        setupEscenario1( );

        listaDeReproduccion.agregarCancion( new Cancion( "cancion1", 45, "letra15", 2, "ruta15" ) );
        assertEquals( "La lista de canciones deberóa tener 1 canción.", 1, listaDeReproduccion.darCanciones( ).size( ) );
        listaDeReproduccion.agregarCancion( new Cancion( "cancion2", 45, "letra15", 2, "ruta15" ) );
        assertEquals( "La lista de canciones deberóa tener 2 canciones.", 2, listaDeReproduccion.darCanciones( ).size( ) );
        listaDeReproduccion.agregarCancion( new Cancion( "cancion3", 45, "letra15", 2, "ruta15" ) );
        assertEquals( "La lista de canciones deberóa tener 3 canciones.", 3, listaDeReproduccion.darCanciones( ).size( ) );

    }

    /**
     * Prueba 4: Se encarga de verificar el mótodo eliminarCancion.<br>
     * <b> Mótodos a probar: </b> <br>
     * eliminarCancion<br>
     * darCanciones<br>
     * <b> Caso de prueba:</b><br>
     * 1. La canción que se desea eliminar estó en la lista de canciones.
     */
    public void testEliminarCancion( )
    {
        setupEscenario2( );

        listaDeReproduccion.eliminarCancion( "cancion2" );
        assertEquals( "La lista de canciones deberóa tener 1 canción.", 1, listaDeReproduccion.darCanciones( ).size( ) );
    }

}
