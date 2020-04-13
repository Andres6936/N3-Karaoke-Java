package karaoke.mundo;

import java.util.ArrayList;

/**
 * Representa un Karaoke.
 */
public class Karaoke
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Cantidad de artistas del karaoke
     */
    // En el modelo del mundo (ModeloConceptual.jpg) se encuentra el tipo y valor exacto de la constante.
    public final static int CANTIDAD_ARTISTAS = 10;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista que contiene las listas de reproducción del karaoke.
     */
    private ArrayList<ListaReproduccion> listasDeReproduccion;

    /**
     * Lista de artistas del karaoke.
     */
    private Artista[] artistas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del karaoke. <br>
     * La lista de artistas quedó inicializada con los siguientes valores:<br>
     * Artista posición 0 - Nombre: Adele, Categoróa: Pop, Ruta de la imagen:"Adele.jpg". <br>
     * Artista posición 1 - Nombre: AC/DC, Categoróa: Rock, Ruta de la imagen:"AC_DC.jpg". <br>
     * Artista posición 2 - Nombre: Calvin Harris, Categoróa: Electro house, Ruta de la imagen:"CalvinHarris.jpg". <br>
     * Artista posición 3 - Nombre: ChocQuibTown, Categoróa: Fusión latina, Ruta de la imagen:"Chocquibtown.jpg". <br>
     * Artista posición 4 - Nombre: Michael Jackson, Categoróa: Pop, Ruta de la imagen:"MichaelJackson.jpg". <br>
     * Artista posición 5 - Nombre: Rihanna, Categoróa: Pop, Ruta de la imagen:"Rihanna.jpg". <br>
     * Artista posición 6 - Nombre: Bomba Estóreo, Categoróa: Fusión latina, Ruta de la imagen:"BombaEstereo.jpg". <br>
     * Artista posición 7 - Nombre: Green Day, Categoróa: Rock, Ruta de la imagen:"GreenDay.jpg". <br>
     * Artista posición 8 - Nombre: Bon Jovi, Categoróa: Rock, Ruta de la imagen:"BonJovi.jpg". <br>
     * Se inicializó la lista que contiene las listas de reproducción.
     */
    public Karaoke( )
    {
        artistas = new Artista[CANTIDAD_ARTISTAS];

        artistas[ 0 ] = new Artista( "Adele", Artista.POP, "./data/imagenes/Adele.jpg" );
        artistas[ 1 ] = new Artista( "AC/DC", Artista.ROCK, "./data/imagenes/AC_DC.jpg" );
        artistas[ 2 ] = new Artista( "Calvin Harris", Artista.ELECTRO_HOUSE, "./data/imagenes/CalvinHarris.jpg" );
        artistas[ 3 ] = new Artista( "ChocQuibTown", Artista.FUSION_LATINA, "./data/imagenes/Chocquibtown.jpg" );
        artistas[ 4 ] = new Artista( "Michael Jackson", Artista.POP, "./data/imagenes/MichaelJackson.jpg" );
        artistas[ 5 ] = new Artista( "Rihanna", Artista.POP, "./data/imagenes/Rihanna.jpg" );
        artistas[ 6 ] = new Artista( "Bomba Estóreo", Artista.FUSION_LATINA, "./data/imagenes/BombaEstereo.jpg" );
        artistas[ 7 ] = new Artista( "Green Day", Artista.ROCK, "./data/imagenes/GreenDay.jpg" );
        artistas[ 8 ] = new Artista( "Bon Jovi", Artista.ROCK, "./data/imagenes/BonJovi.jpg" );
        artistas[ 9 ] = new Artista( "Sia", Artista.POP, "./data/imagenes/Sia.jpg" );

        listasDeReproduccion = new ArrayList<>( );
    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Retorna los artistas del karaoke. <br>
     * <b> pre: </b> El arreglo de artistas se ha inicializado.
     * @return Arreglo con los artistas del karaoke.
     */
    public Artista[] darArtistas( )
    {
        return artistas;
    }

    /**
     * Retorna las listas de reproducción del karaoke. <br>
     * <b> pre: </b> El vector de listas de reproducción se ha inicializado.
     * @return Lista que contiene las listas de reproducción del karaoke.
     */
	public ArrayList< ListaReproduccion > darListasDeReproduccion( )
    {
        return listasDeReproduccion;
    }

    /**
     * Retorna los artistas de una categoróa dada. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas creados.
     * @param pNombre Nombre de la categoróa. pNombre pertenece a {Artista.ROCK, Artista.POP, Artista.FUSION_LATINA, Artista.ELECTRO_HOUSE}.
     * @return Lista con los artistas de la categoróa dada.
     */
	public ArrayList< Artista > darArtistasCategoria( String pNombre )
    {

		ArrayList< Artista > artistasCategoria = new ArrayList< Artista >( );

        for( int i = 0; i < CANTIDAD_ARTISTAS; i++ )
        {
            Artista artista = artistas[ i ];
            if( artista.darCategoria( ).equals( pNombre ) )
            {
                artistasCategoria.add( artista );
            }
        }

        return artistasCategoria;
    }

    /**
     * Retorna una lista con todas las canciones de la categoróa con el nombre dado. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas creados.
     * @param pNombre Nombre de la categoróa. pNombre pertenece a {Artista.ROCK, Artista.POP, Artista.FUSION_LATINA, Artista.ELECTRO_HOUSE}.
     * @return Lista con todas las canciones de una categoróa.
     */
	public ArrayList< Cancion > darCancionesCategoria( String pNombre )
    {
		ArrayList< Cancion > canciones = new ArrayList< Cancion >( );

        for( int i = 0; i < CANTIDAD_ARTISTAS; i++ )
        {
            Artista artista = artistas[ i ];
            if( artista.darCategoria( ).equals( pNombre ) )
            {
                canciones.addAll( artista.darCanciones( ) );
            }
        }

        return canciones;
    }

    /**
     * Retorna la lista de canciones de un artista con el nombre recibido por parómetro. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y el artista existe.
     * @param pNombre Nombre del artista. pNombre != null y pNombre != "".
     * @return La lista de canciones del artista.
     */
	public ArrayList< Cancion > darCancionesArtista( String pNombre )
    {
		ArrayList< Cancion > cancionesArtista = new ArrayList< Cancion >( );
        if( buscarArtista( pNombre ) != null )
            cancionesArtista = buscarArtista( pNombre ).darCanciones( );
        return cancionesArtista;
    }

    /**
     * Busca la canción con mayor dificultad. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas han sido creados.
     * @return La canción con mayor dificultad. <br>
     *         Si ningón artista tiene canciones se retorna null.<br>
     *         Si existen varias canciones con la misma dificultad retorna la primera canción encontrada.
     */
    public Cancion darCancionMasDificil( )
    {
        Cancion dificil = null;
        int dificultad = 0;

        for( int i = 0; i < CANTIDAD_ARTISTAS; i++ )
        {
            Artista artista = artistas[ i ];
            Cancion cancion = artista.darCancionMasDificil( );
            if( cancion != null )
            {
                int dificultadC = cancion.darDificultad( );
                if( dificultadC > dificultad )
                {
                    dificil = cancion;
                    dificultad = dificultadC;
                }
            }
        }

        return dificil;
    }

    /**
     * Busca la canción con menor dificultad. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas han sido creados.
     * @return La canción con menor dificultad. <br>
     *         Si ningón artista tiene canciones se retorna null. <br>
     *         Si existen varias canciones con la misma dificultad retorna la primera canción encontrada.
     */
    public Cancion darCancionMasFacil( )
    {
        Cancion facil = null;
        int dificultad = 11;

        for( int i = 0; i < CANTIDAD_ARTISTAS; i++ )
        {
            Artista artista = artistas[ i ];
            Cancion cancion = artista.darCancionMasFacil( );
            if( cancion != null )
            {
                int dificultadC = cancion.darDificultad( );
                if( dificultadC < dificultad )
                {
                    facil = cancion;
                    dificultad = dificultadC;
                }
            }
        }

        return facil;
    }

    /**
     * Busca la canción con mayor duración. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas han sido creados.
     * @return La canción con mayor duración. <br>
     *         Si ningón artista tiene canciones se retorna null. <br>
     *         Si existen varias canciones con la misma duración retorna la primera canción encontrada.
     */
    public Cancion darCancionMasLarga( )
    {
        // TODO Parte3 PuntoK: Complete el mótodo segón la documentación dada.
        Cancion masLarga = null;
        int larga = 0;
        Cancion cancionL = null;
        for ( Artista artista : artistas )
        {
            cancionL = artista.darCancionMasLarga( );
            if ( cancionL != null && cancionL.darDuracion( ) > larga )
            {
                masLarga = cancionL;
                larga = cancionL.darDuracion( );
            }
        }
        return masLarga;
    }

    /**
     * Busca la canción con menor duración. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas han sido creados.
     * @return La canción con menor duración. <br>
     *         Si ningón artista tiene canciones se retorna null. <br>
     *         Si existen varias canciones con la misma duración retorna la primera canción encontrada.
     */
    public Cancion darCancionMasCorta( )
    {
        // TODO Parte3 PuntoK: Complete el mótodo segón la documentación dada.
        Cancion masCorta = null;
        int corta = 0;
        Cancion cancionC = null;
        if( darCancionMasLarga( ) != null )
            corta = darCancionMasLarga( ).darDuracion( );

        for ( Artista artista : artistas )
        {
            cancionC = artista.darCancionMasCorta( );
            if ( cancionC != null && cancionC.darDuracion( ) < corta )
            {
                masCorta = cancionC;
                corta = cancionC.darDuracion( );
            }
        }
        return masCorta;
    }

    /**
     * Busca el artista con mayor nómero de canciones. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas han sido creados.
     * @return El artista con mayor nómero de canciones. <br>
     *         Si no existen artistas se retorna null. <br>
     *         Si existen varios artistas con el mismo nómero de canciones retorna el primer artista encontrado.
     */
    public Artista darArtistaMasCanciones( )
    {
        // TODO Parte3 PuntoK: Complete el mótodo segón la documentación dada.
        Artista artistaMayorNumeroCanciones = null;
        int mayorNumeroCanciones = 0;
        for ( Artista artista : artistas )
        {
            if ( artista.darCanciones( ).size( ) > mayorNumeroCanciones )
            {
                artistaMayorNumeroCanciones = artista;
                mayorNumeroCanciones = artista.darCanciones( ).size( );
            }
        }
        return artistaMayorNumeroCanciones;
    }

    /**
     * Retorna la lista completa de canciones del karaoke.
     * @return Lista con todas las canciones existentes en el karaoke.
     */
	public ArrayList< Cancion > darCancionesKaraoke( )
    {

		ArrayList< Cancion > canciones = new ArrayList< Cancion >( );

        for( int i = 0; i < CANTIDAD_ARTISTAS; i++ )
        {
            Artista artista = artistas[ i ];

            canciones.addAll( artista.darCanciones( ) );

        }

        return canciones;
    }

    /**
     * Busca un artista con el nombre dado. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas creados.
     * @param pNombre Nombre del artista. pNombre != null y pNombre != "".
     * @return El artista con el nombre dado. Si no existe un artista con ese nombre se retorna null.
     */
    public Artista buscarArtista( String pNombre )
    {
        // TODO Parte3 PuntoF: Complete el mótodo segón la documentación dada.
        boolean encontrado = false;
        Artista artistaEncontrado = null;
        for( int i = 0; i < artistas.length && !encontrado; i++ )
        {
            if( artistas[ i ].darNombre( ).equals( pNombre ) )
            {
                artistaEncontrado = artistas[ i ];
                encontrado = true;
            }
        }
        return artistaEncontrado;
    }

    /**
     * Retorna una canción con el nombre dado.
     * @param pNombreCancion Nombre de la canción. pNombreCancion != "" && pNombreCancion != null.
     * @return La canción con el nombre dado. Si la canción no se encuentra se retorna null.
     */
    public Cancion buscarCancionEnKaraoke( String pNombreCancion )
    {
        // TODO Parte3 PuntoK: Complete el mótodo segón la documentación dada.
        boolean encontrado = false;
        Cancion cancionEncontrada = null;
        for( int i = 0; i < artistas.length && !encontrado; i++ )
        {
            if( artistas[ i ].buscarCancion( pNombreCancion ) != null )
            {
                cancionEncontrada = artistas[ i ].buscarCancion( pNombreCancion );
                encontrado = true;
            }
        }
        return cancionEncontrada;
    }

    /**
     * Retorna el óndice de la lista de reproducción que tiene el nombre dado por parómetro. <br>
     * <b>pre:</b> La lista que contiene las listas de reproducción estó inicializada. <br>
     * @param pNombre Nombre de la lista de reproducción que se estó buscando. pNombre != null && pNombre != "".
     * @return óndice de la lista de reproducción que se estó buscando, -1 en caso de no encontrarla.
     */
    public int buscarListaReproduccion( String pNombre )
    {
        int indiceBuscado = -1;
        boolean encontrado = false;

        for( int i = 0; i < listasDeReproduccion.size( ) && !encontrado; i++ )
        {
            ListaReproduccion listaReproduccionActual = listasDeReproduccion.get( i );
            if( listaReproduccionActual.darNombre( ).equals( pNombre ) )
            {
                indiceBuscado = i;
                encontrado = true;
            }
        }
        return indiceBuscado;
    }

    /**
     * Agrega una nueva canción a un artista del karaoke. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y el artista existe. <br>
     * <b> post: </b> Se ha agregado una nueva canción a un artista del karaoke.
     * @param pArtista Nombre del artista intórprete de la canción. pArtista != null y pArtista != ""
     * @param pNombre Nombre de la canción. pNombre != null y pNombre != ""
     * @param pDuracion Duración en segundos de la canción. pDuracion > 0
     * @param pLetra Letra de la canción. pLetra != null y pLetra != ""
     * @param pDificultad Dificultad de la canción. pDificultad >= 1 y pDificultad <= 10
     * @param pRuta Ruta del archivo con la canción. pRuta != null y pRuta != ""
     * @return Verdadero si la canción fue agregada, falso de lo contrario.
     */
    public boolean agregarCancion( String pArtista, String pNombre, int pDuracion, String pLetra, int pDificultad, String pRuta )
    {
        // TODO Parte3 PuntoH: Complete el mótodo segón la documentación dada.
        boolean agregado = false;
        if( buscarArtista( pArtista ) != null )
        {
            if( buscarArtista( pArtista ).buscarCancion( pNombre ) == null )
            {
                buscarArtista( pArtista ).agregarCancion( pNombre, pDuracion, pLetra, pDificultad, pRuta );
                agregado = true;
            }
        }
        return agregado;
    }

    /**
     * Agrega una nueva lista de reproducción a la lista de listas de reproducción del karaoke. <br>
     * <b> pre: </b> La lista que contiene las listas de reproducción ha sido inicializada. <br>
     * No existe una lista de reproducción con el mismo nombre. <br>
     * <b> post: </b> Se ha agregado una nueva lista de reproducción a la lista que contiene las listas de reproducción.
     * @param pNombreListaReproduccion Nombre de la lista de reproducción. pNombreListaReproduccion != null y pNombreListaReproduccion != "".
     */
    public void agregarListaReproduccion( String pNombreListaReproduccion )
    {
        // TODO Parte3 PuntoI: Complete el mótodo segón la documentación dada.
        if( buscarListaReproduccion( pNombreListaReproduccion ) == -1 )
        {
            listasDeReproduccion.add( new ListaReproduccion( pNombreListaReproduccion ) );
        }
    }

    /**
     * Agregar una canción a una lista de reproducción.<br>
     * <b>pre:</b> La lista que contiene las listas de reproducción estó inicializada. <br>
     * La lista de canciones estó inicializada. <br>
     * No existe una canción con el nombre dado. <br>
     * Existe una lista de reproducción con el nombre dado. <br>
     * <b> post: </b> La lista de reproducción tiene una canción adicional.
     * @param pNombreCancion Nombre de la canción a agregar. pNombreCancion != null && pNombreCancion != null.
     * @param pNombreListaReproduccion Nombre de la lista de reproducción. pNombreListaReproduccion != null && pNombreListaReproduccion != null.
     */
    public void agregarCancionAListaReproduccion( String pNombreCancion, String pNombreListaReproduccion )
    {

        // TODO Parte3 PuntoJ: Complete el mótodo segón la documentación dada.
        ListaReproduccion lista = null;
        if( buscarListaReproduccion( pNombreListaReproduccion ) != -1 )
        {
            lista = listasDeReproduccion.get( buscarListaReproduccion( pNombreListaReproduccion ) );
            if( lista.buscarCancion( pNombreCancion ) == null )
                lista.agregarCancion( buscarCancionEnKaraoke( pNombreCancion ) );
        }
    }

    /**
     * Elimina una lista de reproducción de la lista de listas de reproducción del karaoke. <br>
     * <b> pre: </b> La lista que contiene las listas de reproducción ha sido inicializada. <br>
     * Existe una lista de reproduccion con el nombre dado. <br>
     * <b> post: </b> Se ha eliminado una lista de reproducción de la lista que contiene las listas de reproducción.
     * @param pNombreListaReproduccion Nombre de la lista de reproducción. pNombreListaReproduccion != null y pNombreListaReproduccion != ""
     */
    public void eliminarListaReproduccion( String pNombreListaReproduccion )
    {
        // TODO Parte3 PuntoK: Complete el mótodo segón la documentación dada.
        if( buscarListaReproduccion( pNombreListaReproduccion ) != -1 )
            listasDeReproduccion.remove( buscarListaReproduccion( pNombreListaReproduccion ) );

    }

    /**
     * Elimina una canción de una lista de reproducción.<br>
     * <b>pre:</b> La lista que contiene las listas de reproducción estó inicializada. <br>
     * La lista de canciones estó inicializada. <br>
     * Existe una canción con el nombre dado. <br>
     * Existe una lista de reproducción con el nombre dado. <br>
     * <b> post: </b> Se eliminó una canción de la lista de reproducción.
     * @param pNombreCancion Nombre de la canción a eliminar. pNombreCancion != null && pNombreCancion != null.
     * @param pNombreListaReproduccion Nombre de la lista de reproducción. pNombreListaReproduccion != null && pNombreListaReproduccion != null.
     */
    public void eliminarCancionDeListaReproduccion( String pNombreCancion, String pNombreListaReproduccion )
    {

        // TODO Parte3 PuntoL: Complete el mótodo segón la documentación dada.
        ListaReproduccion lista = null;
        if( buscarListaReproduccion( pNombreListaReproduccion ) != -1 )
        {
            lista = listasDeReproduccion.get( buscarListaReproduccion( pNombreListaReproduccion ) );
            if( lista.buscarCancion( pNombreCancion ) != null )
                lista.eliminarCancion( pNombreCancion );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Mótodo para la extensión 1.
     * 
     * @return Respuesta 1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Mótodo para la extensión 2.
     * 
     * @return Respuesta 2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}