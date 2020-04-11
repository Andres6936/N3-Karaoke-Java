package edu.jabs.karaoke.test;

import java.util.ArrayList;

import karaoke.mundo.Artista;
import karaoke.mundo.Cancion;
import karaoke.mundo.Karaoke;
import karaoke.mundo.ListaReproduccion;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los mótodos de la clase Karaoke estón correctamente implementados.
 */
public class KaraokeTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harón las pruebas.
     */
    private Karaoke karaoke;

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo Karaoke sin canciones.
     * 
     */
    private void setupEscenario1( )
    {
        karaoke = new Karaoke( );
    }

    /**
     * Construye un Karaoke con 15 canciones.
     */
    private void setUpEscenario2( )
    {
        karaoke = new Karaoke( );

        karaoke.agregarCancion( "Adele", "cancion1", 75, "letra3", 7, "ruta3" );
        karaoke.agregarCancion( "Michael Jackson", "cancion2", 20, "letra9", 6, "ruta9" );
        karaoke.agregarCancion( "Michael Jackson", "cancion3", 450, "letra10", 5, "ruta10" );
        karaoke.agregarCancion( "Rihanna", "cancion4", 50, "letra1", 8, "ruta1" );
        karaoke.agregarCancion( "Rihanna", "cancion5", 80, "letra2", 6, "ruta2" );
        karaoke.agregarCancion( "Bon Jovi", "cancion6", 150, "letra4", 9, "ruta4" );
        karaoke.agregarCancion( "Green Day", "cancion7", 120, "letra5", 1, "ruta5" );
        karaoke.agregarCancion( "Green Day", "cancion8", 80, "letra6", 3, "ruta6" );
        karaoke.agregarCancion( "AC/DC", "cancion9", 39, "letra7", 1, "ruta7" );
        karaoke.agregarCancion( "AC/DC", "cancion10", 68, "letra8", 7, "ruta8" );
        karaoke.agregarCancion( "Calvin Harris", "cancion11", 75, "letra11", 4, "ruta11" );
        karaoke.agregarCancion( "Calvin Harris", "cancion12", 20, "letra12", 9, "ruta12" );
        karaoke.agregarCancion( "Bomba Estóreo", "cancion13", 345, "letra13", 3, "ruta13" );
        karaoke.agregarCancion( "ChocQuibTown", "cancion14", 90, "letra14", 2, "ruta14" );
        karaoke.agregarCancion( "ChocQuibTown", "cancion15", 45, "letra15", 2, "ruta15" );

    }

    /**
     * Construye un Karaoke con 2 listas de reproducción y 5 canciones en cada una.
     */
    private void setupEscenario3( )
    {
        setUpEscenario2( );

        karaoke.agregarListaReproduccion( "Lista para viajar" );
        karaoke.agregarListaReproduccion( "Lista para ejercicio" );

        karaoke.agregarCancionAListaReproduccion( "cancion1", "Lista para viajar" );
        karaoke.agregarCancionAListaReproduccion( "cancion2", "Lista para viajar" );
        karaoke.agregarCancionAListaReproduccion( "cancion3", "Lista para viajar" );
        karaoke.agregarCancionAListaReproduccion( "cancion4", "Lista para viajar" );
        karaoke.agregarCancionAListaReproduccion( "cancion5", "Lista para viajar" );

        karaoke.agregarCancionAListaReproduccion( "cancion6", "Lista para ejercicio" );
        karaoke.agregarCancionAListaReproduccion( "cancion7", "Lista para ejercicio" );
        karaoke.agregarCancionAListaReproduccion( "cancion8", "Lista para ejercicio" );
        karaoke.agregarCancionAListaReproduccion( "cancion9", "Lista para ejercicio" );
        karaoke.agregarCancionAListaReproduccion( "cancion10", "Lista para ejercicio" );

    }

    /**
     * Prueba 1: Se encarga de verificar el mótodo constructor de la clase.<br>
     * <b> Mótodos a probar: </b> <br>
     * Karaoke <br>
     * darArtistas <br>
     * darNombre <br>
     * darListasDeReproduccion <br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente el karaoke, cada uno de los valores corresponde al esperado.
     */
    public void testKaraoke( )
    {
        setupEscenario1( );

        Artista[] artistas = karaoke.darArtistas( );
        assertNotNull( "El arreglo de artistas no fue inicializado.", artistas );

        for( int i = 0; i < Karaoke.CANTIDAD_ARTISTAS; i++ )
        {
            assertNotNull( "No inicializa el artista " + ( i + 1 ), artistas[ i ] );
        }

        assertEquals( "Artista 1 incorrecto.", "Adele", artistas[ 0 ].darNombre( ) );
        assertEquals( "Artista 2 incorrecto.", "AC/DC", artistas[ 1 ].darNombre( ) );
        assertEquals( "Artista 3 incorrecto.", "Calvin Harris", artistas[ 2 ].darNombre( ) );
        assertEquals( "Artista 4 incorrecto.", "ChocQuibTown", artistas[ 3 ].darNombre( ) );
        assertEquals( "Artista 5 incorrecto.", "Michael Jackson", artistas[ 4 ].darNombre( ) );
        assertEquals( "Artista 6 incorrecto.", "Rihanna", artistas[ 5 ].darNombre( ) );
        assertEquals( "Artista 7 incorrecto.", "Bomba Estóreo", artistas[ 6 ].darNombre( ) );
        assertEquals( "Artista 8 incorrecto.", "Green Day", artistas[ 7 ].darNombre( ) );
        assertEquals( "Artista 9 incorrecto.", "Bon Jovi", artistas[ 8 ].darNombre( ) );

		ArrayList< ListaReproduccion > listasReproduccion = karaoke.darListasDeReproduccion( );
        assertNotNull( "La lista que contiene las listas de reproducción no fue inicializada", listasReproduccion );

    }

    /**
     * Prueba 2: Se encarga de verificar el mótodo buscarArtista.<br>
     * <b> Mótodos a probar: </b> <br>
     * buscarArtista <br>
     * darNombre <br>
     * <b> Casos de prueba:</b><br>
     * 1. El artista es encontrado en el karaoke. <br>
     * 2. El artista no es encontrado en el karaoke.
     */
    public void testBuscarArtista( )
    {
        setupEscenario1( );

        // 1
        Artista artista = karaoke.buscarArtista( "Adele" );
        assertNotNull( "El artista no deberóa ser nulo.", artista );
        assertEquals( "El artista encontrado no es correcto.", "Adele", artista.darNombre( ) );

        // 2
        Artista artista2 = karaoke.buscarArtista( "artista4" );
        assertNull( "El artista deberóa ser nulo.", artista2 );
    }

    /**
     * Prueba 3: Se encarga de verificar el mótodo agregarCancion.<br>
     * <b> Mótodos a probar: </b> <br>
     * agregarCancion <br>
     * buscarArtista <br>
     * darCanciones <br>
     * <b> Casos de prueba:</b><br>
     * 1. La canción es agregada a un artista. <br>
     * 2. La canción no es agregada a un artista.
     */
    public void testAgregarCancion( )
    {
        setupEscenario1( );

        // 1
        boolean agregada = karaoke.agregarCancion( "Adele", "canción", 100, "letra", 5, "ruta" );
        assertTrue( "Se deberóa agregar la canción al karaoke.", agregada );

        Artista a = karaoke.buscarArtista( "Adele" );
        assertEquals( "El canción no fue agregada al artista.", 1, a.darCanciones( ).size( ) );
        // 2
        boolean agregada2 = karaoke.agregarCancion( "Adele", "canción", 100, "letra", 5, "ruta" );
        assertFalse( "No se deberóa agregar la canción al karaoke.", agregada2 );
        assertEquals( "El  nómero de canciones del artista no deberóa cambiar.", 1, a.darCanciones( ).size( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el mótodo darCancionMasDificil.<br>
     * <b> Mótodos a probar: </b> <br>
     * darCancionMasDificil <br>
     * darNombre <br>
     * darDificultad <br>
     * <b> Casos de prueba:</b><br>
     * 1. Se encuentra la canción mós difócil.
     */
    public void testDarCancionMasDificil( )
    {
        setUpEscenario2( );

        Cancion dificil = karaoke.darCancionMasDificil( );
        assertNotNull( "La canción no deberóa ser nula.", dificil );
        assertEquals( "La canción retornada no es la mós difócil.", "cancion12", dificil.darNombre( ) );
        assertEquals( "La canción retornada no es la mós difócil.", 9, dificil.darDificultad( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el mótodo darCancionMasFacil.<br>
     * <b> Mótodos a probar: </b> <br>
     * darCancionMasFacil <br>
     * darNombre <br>
     * darDificultad <br>
     * <b> Casos de prueba:</b><br>
     * 1. Se encuentra la canción mós fócil.
     */
    public void testDarCancionMasFacil( )
    {
        setUpEscenario2( );

        Cancion facil = karaoke.darCancionMasFacil( );
        assertNotNull( "La canción no deberóa ser nula.", facil );
        assertEquals( "La canción retornada no es la mós fócil.", "cancion9", facil.darNombre( ) );
        assertEquals( "La canción retornada no es la mós fócil.", 1, facil.darDificultad( ) );

    }

    /**
     * Prueba 6: Se encarga de verificar el mótodo darCancionMasLarga.<br>
     * <b> Mótodos a probar: </b> <br>
     * darCancionMasLarga <br>
     * darNombre <br>
     * darDuracion <br>
     * <b> Casos de prueba:</b><br>
     * 1. Se encuentra la canción mós larga.
     */
    public void testDarCancionMasLarga( )
    {
        setUpEscenario2( );

        Cancion larga = karaoke.darCancionMasLarga( );
        assertNotNull( "La canción no deberóa ser nula.", larga );
        assertEquals( "La canción retornada no es la mós larga.", "cancion3", larga.darNombre( ) );
        assertEquals( "La canción retornada no es la mós larga.", 450, larga.darDuracion( ) );
    }

    /**
     * Prueba 7: Se encarga de verificar el mótodo darCancionMasCorta.<br>
     * <b> Mótodos a probar: </b> <br>
     * darCancionMasCorta <br>
     * darNombre <br>
     * darDuracion <br>
     * <b> Casos de prueba:</b><br>
     * 1. Se encuentra la canción mós corta.
     */
    public void testDarCancionMasCorta( )
    {
        setUpEscenario2( );

        Cancion corta = karaoke.darCancionMasCorta( );
        assertNotNull( "La canción no deberóa ser nula.", corta );
        assertEquals( "La canción retornada no es la mós corta.", "cancion12", corta.darNombre( ) );
        assertEquals( "La canción retornada no es la mós corta.", 20, corta.darDuracion( ) );
    }

    /**
     * Prueba 8: Se encarga de verificar el mótodo darArtistaMasCanciones.<br>
     * <b> Mótodos a probar: </b> <br>
     * darArtistaMasCanciones <br>
     * darNombre <br>
     * <b> Casos de prueba:</b><br>
     * 1. Se encuentra el artista con mós canciones.
     */
    public void testDarArtistaMasCanciones( )
    {
        setUpEscenario2( );

        Artista artista = karaoke.darArtistaMasCanciones( );
        assertNotNull( "El artista no deberóa ser nulo", artista );
        assertEquals( "El artista retornado no es el artista con mayor nómero de canciones.", "AC/DC", artista.darNombre( ) );
    }

    /**
     * Prueba 9: Se encarga de verificar el mótodo darCancionesCategoria.<br>
     * <b> Mótodos a probar: </b> <br>
     * darCancionesCategoria <br>
     * darNombre <br>
     * <b> Casos de prueba:</b><br>
     * 1. Se encuentran las canciones para una cateogróa.
     */
    public void testDarCancionesCategoria( )
    {

        setUpEscenario2( );

		ArrayList< Cancion > canciones = karaoke.darCancionesCategoria( Artista.POP );
        assertNotNull( "La lista de canciones no deberóa ser nula.", canciones );
        assertEquals( "No se han incluido todas las canciones de la categoróa en la lista.", 5, canciones.size( ) );

        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c = ( Cancion )canciones.get( i );
            int numCancion = i + 1;
            assertEquals( "La canción en la lista no es correcta.", "cancion" + numCancion, c.darNombre( ) );
        }

    }

    /**
     * Prueba 9: Se encarga de verificar el mótodo buscarCancionEnKaraoke.<br>
     * <b> Mótodos a probar: </b> <br>
     * buscarCancionEnKaraoke <br>
     * darNombre <br>
     * <b> Casos de prueba:</b><br>
     * 1. Se encuentra la canción en el karaoke. <br>
     * 2. No se encuentra la canción en el karaoke.
     */
    public void testBuscarCancionEnKaraoke( )
    {
        setupEscenario3( );
        Cancion c = karaoke.buscarCancionEnKaraoke( "cancion1" );
        // 1
        assertNotNull( "La canción no deberóa ser nula.", c );
        assertEquals( "La canción retornada no es la correcta.", "cancion1", c.darNombre( ) );
        // 2
        Cancion c2 = karaoke.buscarCancionEnKaraoke( "cancion17" );
        assertNull( "La canción deberóa ser nula.", c2 );
    }

    /**
     * Prueba 10: Se encarga de verificar el mótodo buscarListaReproduccion.<br>
     * <b> Mótodos a probar: </b> <br>
     * buscarListaReproduccion <br>
     * <b> Casos de prueba:</b><br>
     * 1. Se encuentra la lista de reproducción.<br>
     * 2. No existe la lista de reproducción buscada.
     */
    public void testBuscarListaReproduccion( )
    {
        setupEscenario3( );
        // 1
        int lista = karaoke.buscarListaReproduccion( "Lista para viajar" );
        assertNotNull( "La lista de reproducción no deberóa ser nula.", lista );
        assertEquals( "La lista de reproducción retornada no es la correcta.", 0, lista );

        // 2
        int lista2 = karaoke.buscarListaReproduccion( "Lista1" );
        assertEquals( "La lista de reproducción deberóa ser nula.", - 1, lista2 );
    }

    /**
     * Prueba 11: Se encarga de verificar el mótodo agregarListaReproduccion.<br>
     * <b> Mótodos a probar: </b> <br>
     * agregarListaReproduccion<br>
     * darListasDeReproduccion<br>
     * <b> Casos de prueba:</b><br>
     * 1. La lista de reproducción es agregada.
     */
    public void testAgregarListaReproduccion( )
    {
        setupEscenario3( );

        // 1
        karaoke.agregarListaReproduccion( "Lista1" );
        assertEquals( "El nómero de listas de reproducción del karaoke deberóa cambiar.", 3, karaoke.darListasDeReproduccion( ).size( ) );

    }
    /**
     * Prueba 12: Se encarga de verificar el mótodo eliminarListaReproduccion.<br>
     * <b> Mótodos a probar: </b> <br>
     * eliminarListaReproduccion<br>
     * darListasDeReproduccion<br>
     * <b> Casos de prueba:</b><br>
     * 1. La lista de reproducción es eliminada.
     */
    public void testEliminarListaReproduccion( )
    {
        setupEscenario3( );
        // 1
        karaoke.eliminarListaReproduccion( "Lista para viajar" );
        assertEquals( "El nómero de listas de reproducción del karaoke deberóa cambiar.", 1, karaoke.darListasDeReproduccion( ).size( ) );

    }

    /**
     * Prueba 13: Se encarga de verificar el mótodo darCancionesArtista, para un karaoke con canciones.<br>
     * <b> Mótodos a probar: </b> <br>
     * darCancionesArtista<br>
     * <b> Casos de prueba:</b><br>
     * 1. Un artista tiene varias canciones y corresponden. <br>
     * 2. Un artista tiene una ónica canción y corresponde.
     */
    public void testDarCancionesArtista1( )
    {
        setUpEscenario2( );

		ArrayList< Cancion > canciones = karaoke.darCancionesArtista( "Michael Jackson" );
        assertEquals( "La cantidad de canciones no corresponde.", 2, canciones.size( ) );

        Cancion c1 = ( Cancion )canciones.get( 0 );
        Cancion c2 = ( Cancion )canciones.get( 1 );
        assertEquals( "El nombre de la canción no corresponde.", c1.darNombre( ), "cancion2" );
        assertEquals( "El nombre de la canción no corresponde.", c2.darNombre( ), "cancion3" );

        // 2
        canciones = karaoke.darCancionesArtista( "Adele" );
        c1 = ( Cancion )canciones.get( 0 );
        assertEquals( "La cantidad de canciones no corresponde.", 1, canciones.size( ) );
        assertEquals( "El nombre de la canción no corresponde.", c1.darNombre( ), "cancion1" );
    }

    /**
     * Prueba 14: Se encarga de verificar el mótodo darCancionesArtista, para un karakoe sin canciones.<br>
     * <b> Mótodos a probar: </b> <br>
     * darCancionesArtista<br>
     * <b> Casos de prueba:</b><br>
     * 1. La cantidad de canciones retornada es correcta. <br>
     */
    public void testDarCancionesArtista2( )
    {
        setupEscenario1( );

		ArrayList< Cancion > canciones = karaoke.darCancionesArtista( "Michael Jackson" );
        assertEquals( "La cantidad de canciones no corresponde.", 0, canciones.size( ) );
    }

    /**
     * Prueba 15: Se encarga de verificar el mótodo eliminarCancionDeListaReproduccion.<br>
     * <b> Mótodos a probar: </b> <br>
     * eliminarCancionDeListaReproduccion<br>
     * buscarListaReproduccion<br>
     * darListasDeReproduccion<br>
     * <b> Casos de prueba:</b><br>
     * 1. La canción es eliminada de la lista de reproducción. <br>
     */
    public void testEliminarCancionDeListaReproduccion( )
    {
        setupEscenario3( );
        // 1
        karaoke.eliminarCancionDeListaReproduccion( "cancion1", "Lista para viajar" );
        int indiceLista = karaoke.buscarListaReproduccion( "Lista para viajar" );
        ListaReproduccion lista = ( ListaReproduccion )karaoke.darListasDeReproduccion( ).get( indiceLista );
        assertEquals( "La cantidad de canciones no corresponde.", 4, lista.darCanciones( ).size( ) );
    }

}