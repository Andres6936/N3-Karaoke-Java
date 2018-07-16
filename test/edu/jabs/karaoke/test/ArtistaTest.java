package edu.jabs.karaoke.test;

import edu.jabs.karaoke.mundo.Artista;
import edu.jabs.karaoke.mundo.Cancion;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los m�todos de la clase Artista est�n correctamente implementados.
 */
public class ArtistaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Artista artista;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo artista.
     */
    private void setupEscenario1( )
    {
        artista = new Artista( "Nombre", "Categor�a", "Ruta" );
    }

    /**
     * Escenario 2: Crea un nuevo artista con cinco canciones.
     */
    private void setupEscenario2( )
    {
        artista = new Artista( "Nombre", "Categor�a", "Ruta" );
        artista.agregarCancion( "Cancion1", 100, "Letra1", 2, "Ruta1" );
        artista.agregarCancion( "Cancion2", 150, "Letra2", 3, "Ruta2" );
        artista.agregarCancion( "Cancion3", 80, "Letra3", 7, "Ruta3" );
        artista.agregarCancion( "Cancion4", 87, "Letra4", 4, "Ruta4" );
        artista.agregarCancion( "Cancion5", 80, "Letra5", 5, "Ruta5" );
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * Artista<br>
     * darNombre<br>
     * darCategoria<br>
     * darImagen<br>
     * darCanciones<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente el artista, cada uno de los valores corresponde al esperado.
     */
    public void testArtista( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del artista no fue inicializado correctamente.", "Nombre", artista.darNombre( ) );
        assertEquals( "La categor�a del artista no fue inicializada correctamente.", "Categor�a", artista.darCategoria( ) );
        assertEquals( "La imagen del artista no fue inicializada correctamente.", "Ruta", artista.darImagen( ) );
        assertNotNull( "La lista de canciones no fue inicializada.", artista.darCanciones( ) );
        assertEquals( "La lista de canciones no fue inicializada correctamente.", 0, artista.darCanciones( ).size( ) );
    }

    /**
     * Prueba 2: Verifica que la lista de canciones se inicialice correctamente.<br>
     * <b> M�todos a probar: </b> <br>
     * Artista<br>
     * darCanciones<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente el artista con la lista de canciones esperadas.
     */
    public void testDarCanciones( )
    {
        setupEscenario2( );

        assertNotNull( "La lista de canciones del artista no ha sido inicializada.", artista.darCanciones( ) );
        assertEquals( "La lista de canciones no fue inicializada correctamente.", 5, artista.darCanciones( ).size( ) );

    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo agregarCancion.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarCancion<br>
     * buscarCancion<br>
     * darCanciones<br>
     * <b> Casos de prueba:</b><br>
     * 1. El artista no tiene canciones.<br>
     * 2. El artista tiene 6 canciones.<br>
     * 3. La canci�n no se puede agregar.<br>
     */
    public void testAgregarCancion( )
    {

        // 1
        setupEscenario1( );
        artista.agregarCancion( "cancion1", 100, "letra", 5, "ruta" );
        assertEquals( "El artista deber�a tener 1 canci�n.", 1, artista.darCanciones( ).size( ) );
        assertEquals( "El nombre de la canci�n no corresponde.", "cancion1", artista.buscarCancion( "cancion1" ).darNombre( ) );
        assertEquals( "La duraci�n de la canci�n  no corresponde.", 100, artista.buscarCancion( "cancion1" ).darDuracion( ) );
        assertEquals( "La letra de la canci�n no corresponde.", "letra", artista.buscarCancion( "cancion1" ).darLetra( ) );

        // 2
        setupEscenario2( );
        artista.agregarCancion( "Cancion6", 100, "letra", 5, "ruta" );
        assertEquals( "El artista deber�a tener 6 canciones.", 6, artista.darCanciones( ).size( ) );
        assertEquals( "El nombre de la canci�n no corresponde.", "Cancion6", artista.buscarCancion( "Cancion6" ).darNombre( ) );
        assertEquals( "La duraci�n de la canci�n  no corresponde.", 100, artista.buscarCancion( "Cancion6" ).darDuracion( ) );
        assertEquals( "La letra de la canci�n no corresponde.", "letra", artista.buscarCancion( "Cancion6" ).darLetra( ) );

        // 3
        setupEscenario2( );
        boolean agregada = artista.agregarCancion( "Cancion1", 100, "letra", 5, "ruta" );
        assertFalse( "No se deber�a agregar la canci�n a la lista de canciones del artista.", agregada );
        assertEquals( "La canci�n fue agregada a la lista de canciones.", 5, artista.darCanciones( ).size( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo buscarCancion.<br>
     * <b> M�todos a probar: </b> buscarCancion</b> darNombre<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canci�n es encontrada en la lista de canciones del artista.<br>
     * 2. La canci�n no es encontrada en la lista de canciones del artista.<br>
     */
    public void testBuscarCancion( )
    {
        // 1
        setupEscenario2( );
        Cancion cancion = artista.buscarCancion( "Cancion1" );
        assertNotNull( "La canci�n no deber�a ser nula.", cancion );
        assertEquals( "La canci�n encontrada no es correcta.", "Cancion1", cancion.darNombre( ) );

        // 2
        setupEscenario2( );
        Cancion cancion2 = artista.buscarCancion( "Cancion6" );
        assertNull( "La canci�n deber�a ser nula.", cancion2 );

    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo darCancionMasDificil.<br>
     * <b> M�todos a probar: </b> darCancionMasDificil<br>
     * darNombre<br>
     * darDificultad<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canci�n m�s dif�cil es encontrada.<br>
     */
    public void testDarCancionMasDificil( )
    {
        setupEscenario2( );

        Cancion dificil = artista.darCancionMasDificil( );
        assertNotNull( "La canci�n no deber�a ser nula.", dificil );
        assertEquals( "La canci�n retornada no es la m�s dif�cil.", "Cancion3", dificil.darNombre( ) );
        assertEquals( "La canci�n retornada no es la m�s dif�cil.", 7, dificil.darDificultad( ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el m�todo darCancionMasFacil.<br>
     * <b> M�todos a probar: </b> darCancionMasFacil<br>
     * darNombre<br>
     * darDificultad<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canci�n m�s f�cil es encontrada.<br>
     */
    public void testDarCancionMasFacil( )
    {
        setupEscenario2( );

        Cancion facil = artista.darCancionMasFacil( );
        assertNotNull( "La canci�n no deber�a ser nula.", facil );
        assertEquals( "La canci�n retornada no es la m�s f�cil.", "Cancion1", facil.darNombre( ) );
        assertEquals( "La canci�n retornada no es la m�s f�cil.", 2, facil.darDificultad( ) );

    }

    /**
     * Prueba 7: Se encarga de verificar el m�todo darCancionMasLarga.<br>
     * <b> M�todos a probar: </b> darCancionMasLarga<br>
     * darNombre<br>
     * darDuracion<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canci�n m�s larga es encontrada.<br>
     */
    public void testDarCancionMasLarga( )
    {
        setupEscenario2( );

        Cancion larga = artista.darCancionMasLarga( );
        assertNotNull( "La canci�n no deber�a ser nula.", larga );
        assertEquals( "La canci�n retornada no es la m�s larga.", "Cancion2", larga.darNombre( ) );
        assertEquals( "La canci�n retornada no es la m�s larga.", 150, larga.darDuracion( ) );
    }

    /**
     * Prueba 8: Se encarga de verificar el m�todo darCancionMasCorta.<br>
     * <b> M�todos a probar: </b> darCancionMasCorta<br>
     * darNombre<br>
     * darDuracion<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canci�n m�s corta es encontrada.<br>
     */
    public void testDarCancionMasCorta( )
    {
        setupEscenario2( );

        Cancion corta = artista.darCancionMasCorta( );
        assertNotNull( "La canci�n no deber�a ser nula.", corta );
        assertEquals( "La canci�n retornada no es la m�s corta.", "Cancion3", corta.darNombre( ) );
        assertEquals( "La canci�n retornada no es la m�s corta.", 80, corta.darDuracion( ) );
    }
}