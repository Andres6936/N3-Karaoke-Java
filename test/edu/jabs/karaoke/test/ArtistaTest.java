package edu.jabs.karaoke.test;

import edu.jabs.karaoke.mundo.Artista;
import edu.jabs.karaoke.mundo.Cancion;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los métodos de la clase Artista estén correctamente implementados.
 */
public class ArtistaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Artista artista;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo artista.
     */
    private void setupEscenario1( )
    {
        artista = new Artista( "Nombre", "Categoría", "Ruta" );
    }

    /**
     * Escenario 2: Crea un nuevo artista con cinco canciones.
     */
    private void setupEscenario2( )
    {
        artista = new Artista( "Nombre", "Categoría", "Ruta" );
        artista.agregarCancion( "Cancion1", 100, "Letra1", 2, "Ruta1" );
        artista.agregarCancion( "Cancion2", 150, "Letra2", 3, "Ruta2" );
        artista.agregarCancion( "Cancion3", 80, "Letra3", 7, "Ruta3" );
        artista.agregarCancion( "Cancion4", 87, "Letra4", 4, "Ruta4" );
        artista.agregarCancion( "Cancion5", 80, "Letra5", 5, "Ruta5" );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
        assertEquals( "La categoría del artista no fue inicializada correctamente.", "Categoría", artista.darCategoria( ) );
        assertEquals( "La imagen del artista no fue inicializada correctamente.", "Ruta", artista.darImagen( ) );
        assertNotNull( "La lista de canciones no fue inicializada.", artista.darCanciones( ) );
        assertEquals( "La lista de canciones no fue inicializada correctamente.", 0, artista.darCanciones( ).size( ) );
    }

    /**
     * Prueba 2: Verifica que la lista de canciones se inicialice correctamente.<br>
     * <b> Métodos a probar: </b> <br>
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
     * Prueba 3: Se encarga de verificar el método agregarCancion.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarCancion<br>
     * buscarCancion<br>
     * darCanciones<br>
     * <b> Casos de prueba:</b><br>
     * 1. El artista no tiene canciones.<br>
     * 2. El artista tiene 6 canciones.<br>
     * 3. La canción no se puede agregar.<br>
     */
    public void testAgregarCancion( )
    {

        // 1
        setupEscenario1( );
        artista.agregarCancion( "cancion1", 100, "letra", 5, "ruta" );
        assertEquals( "El artista debería tener 1 canción.", 1, artista.darCanciones( ).size( ) );
        assertEquals( "El nombre de la canción no corresponde.", "cancion1", artista.buscarCancion( "cancion1" ).darNombre( ) );
        assertEquals( "La duración de la canción  no corresponde.", 100, artista.buscarCancion( "cancion1" ).darDuracion( ) );
        assertEquals( "La letra de la canción no corresponde.", "letra", artista.buscarCancion( "cancion1" ).darLetra( ) );

        // 2
        setupEscenario2( );
        artista.agregarCancion( "Cancion6", 100, "letra", 5, "ruta" );
        assertEquals( "El artista debería tener 6 canciones.", 6, artista.darCanciones( ).size( ) );
        assertEquals( "El nombre de la canción no corresponde.", "Cancion6", artista.buscarCancion( "Cancion6" ).darNombre( ) );
        assertEquals( "La duración de la canción  no corresponde.", 100, artista.buscarCancion( "Cancion6" ).darDuracion( ) );
        assertEquals( "La letra de la canción no corresponde.", "letra", artista.buscarCancion( "Cancion6" ).darLetra( ) );

        // 3
        setupEscenario2( );
        boolean agregada = artista.agregarCancion( "Cancion1", 100, "letra", 5, "ruta" );
        assertFalse( "No se debería agregar la canción a la lista de canciones del artista.", agregada );
        assertEquals( "La canción fue agregada a la lista de canciones.", 5, artista.darCanciones( ).size( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el método buscarCancion.<br>
     * <b> Métodos a probar: </b> buscarCancion</b> darNombre<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canción es encontrada en la lista de canciones del artista.<br>
     * 2. La canción no es encontrada en la lista de canciones del artista.<br>
     */
    public void testBuscarCancion( )
    {
        // 1
        setupEscenario2( );
        Cancion cancion = artista.buscarCancion( "Cancion1" );
        assertNotNull( "La canción no debería ser nula.", cancion );
        assertEquals( "La canción encontrada no es correcta.", "Cancion1", cancion.darNombre( ) );

        // 2
        setupEscenario2( );
        Cancion cancion2 = artista.buscarCancion( "Cancion6" );
        assertNull( "La canción debería ser nula.", cancion2 );

    }

    /**
     * Prueba 5: Se encarga de verificar el método darCancionMasDificil.<br>
     * <b> Métodos a probar: </b> darCancionMasDificil<br>
     * darNombre<br>
     * darDificultad<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canción más difícil es encontrada.<br>
     */
    public void testDarCancionMasDificil( )
    {
        setupEscenario2( );

        Cancion dificil = artista.darCancionMasDificil( );
        assertNotNull( "La canción no debería ser nula.", dificil );
        assertEquals( "La canción retornada no es la más difícil.", "Cancion3", dificil.darNombre( ) );
        assertEquals( "La canción retornada no es la más difícil.", 7, dificil.darDificultad( ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el método darCancionMasFacil.<br>
     * <b> Métodos a probar: </b> darCancionMasFacil<br>
     * darNombre<br>
     * darDificultad<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canción más fácil es encontrada.<br>
     */
    public void testDarCancionMasFacil( )
    {
        setupEscenario2( );

        Cancion facil = artista.darCancionMasFacil( );
        assertNotNull( "La canción no debería ser nula.", facil );
        assertEquals( "La canción retornada no es la más fácil.", "Cancion1", facil.darNombre( ) );
        assertEquals( "La canción retornada no es la más fácil.", 2, facil.darDificultad( ) );

    }

    /**
     * Prueba 7: Se encarga de verificar el método darCancionMasLarga.<br>
     * <b> Métodos a probar: </b> darCancionMasLarga<br>
     * darNombre<br>
     * darDuracion<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canción más larga es encontrada.<br>
     */
    public void testDarCancionMasLarga( )
    {
        setupEscenario2( );

        Cancion larga = artista.darCancionMasLarga( );
        assertNotNull( "La canción no debería ser nula.", larga );
        assertEquals( "La canción retornada no es la más larga.", "Cancion2", larga.darNombre( ) );
        assertEquals( "La canción retornada no es la más larga.", 150, larga.darDuracion( ) );
    }

    /**
     * Prueba 8: Se encarga de verificar el método darCancionMasCorta.<br>
     * <b> Métodos a probar: </b> darCancionMasCorta<br>
     * darNombre<br>
     * darDuracion<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canción más corta es encontrada.<br>
     */
    public void testDarCancionMasCorta( )
    {
        setupEscenario2( );

        Cancion corta = artista.darCancionMasCorta( );
        assertNotNull( "La canción no debería ser nula.", corta );
        assertEquals( "La canción retornada no es la más corta.", "Cancion3", corta.darNombre( ) );
        assertEquals( "La canción retornada no es la más corta.", 80, corta.darDuracion( ) );
    }
}