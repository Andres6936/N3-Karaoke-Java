package edu.jabs.karaoke.test;

import edu.jabs.karaoke.mundo.Cancion;
import edu.jabs.karaoke.mundo.ListaReproduccion;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los m�todos de la clase ListaReproduccion est�n correctamente implementados.
 */
public class ListaReproduccionTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private ListaReproduccion listaDeReproduccion;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva lista de reproducci�n sin canciones.
     */
    private void setupEscenario1( )
    {
        listaDeReproduccion = new ListaReproduccion( "Lista para viajar" );
    }

    /**
     * Escenario 2: Construye una nueva lista de reproducci�n con 2 canciones.
     */
    private void setupEscenario2( )
    {
        listaDeReproduccion = new ListaReproduccion( "Lista para viajar" );

        listaDeReproduccion.agregarCancion( new Cancion( "cancion1", 45, "letra15", 2, "ruta15" ) );
        listaDeReproduccion.agregarCancion( new Cancion( "cancion2", 45, "letra15", 2, "ruta15" ) );

    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * ListaReproduccion<br>
     * darNombre<br>
     * darCanciones<br>
     * <b> Caso de prueba:</b><br>
     * 1. Construye correctamente la lista de reproducci�n, cada uno de los valores corresponde al esperado.<br>
     */
    public void testListaReproduccion( )
    {
        setupEscenario1( );
        assertEquals( "Error al inicializar el nombre de la lista de reproducci�n.", "Lista para viajar", listaDeReproduccion.darNombre( ) );
        assertNotNull( "La lista de canciones no deber�a ser nula.", listaDeReproduccion.darCanciones( ) );
        assertEquals( "La lista de canciones no deber�a tener canciones.", 0, listaDeReproduccion.darCanciones( ).size( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo existeCancion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * existeCancion<br>
     * <b> Casos de prueba:</b><br>
     * 1. La lista de reproducci�n tiene una canci�n con el nombre dado. <br>
     * 2. La lista de reproducci�n no tiene una canci�n con el nombre dado.
     */
    public void testExisteCancion( )
    {
        setupEscenario2( );
        // 1
        assertNotNull( "La canci�n no deber�a ser nula.", listaDeReproduccion.buscarCancion( "cancion1" ) );

        // 2
        assertNull( "La canci�n deber�a ser nula.", listaDeReproduccion.buscarCancion( "cancion5" ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo agregarCancion.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarCancion<br>
     * darCanciones<br>
     * <b> Caso de prueba :</b><br>
     * 1. La lista de reproducci�n no tiene canciones y se agregan varias canciones.
     */
    public void testAgregarCancion( )
    {
        setupEscenario1( );

        listaDeReproduccion.agregarCancion( new Cancion( "cancion1", 45, "letra15", 2, "ruta15" ) );
        assertEquals( "La lista de canciones deber�a tener 1 canci�n.", 1, listaDeReproduccion.darCanciones( ).size( ) );
        listaDeReproduccion.agregarCancion( new Cancion( "cancion2", 45, "letra15", 2, "ruta15" ) );
        assertEquals( "La lista de canciones deber�a tener 2 canciones.", 2, listaDeReproduccion.darCanciones( ).size( ) );
        listaDeReproduccion.agregarCancion( new Cancion( "cancion3", 45, "letra15", 2, "ruta15" ) );
        assertEquals( "La lista de canciones deber�a tener 3 canciones.", 3, listaDeReproduccion.darCanciones( ).size( ) );

    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo eliminarCancion.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarCancion<br>
     * darCanciones<br>
     * <b> Caso de prueba:</b><br>
     * 1. La canci�n que se desea eliminar est� en la lista de canciones.
     */
    public void testEliminarCancion( )
    {
        setupEscenario2( );

        listaDeReproduccion.eliminarCancion( "cancion2" );
        assertEquals( "La lista de canciones deber�a tener 1 canci�n.", 1, listaDeReproduccion.darCanciones( ).size( ) );
    }

}
