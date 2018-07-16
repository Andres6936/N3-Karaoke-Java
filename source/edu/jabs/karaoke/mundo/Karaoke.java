package edu.jabs.karaoke.mundo;

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
    // TODO Parte3 PuntoA: Agregue la constante CANTIDAD_ARTISTAS que determina el n�mero de artistas en el karaoke.
    // En el modelo del mundo (ModeloConceptual.jpg) se encuentra el tipo y valor exacto de la constante.
    public final static int CANTIDAD_ARTISTAS = 10;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista que contiene las listas de reproducci�n del karaoke.
     */
    // TODO Parte3 PuntoB: Declare la asociaci�n listasDeReproduccion como una contenedora de tipo variable.
    private ArrayList<ListaReproduccion> listasDeReproduccion;

    /**
     * Lista de artistas del karaoke.
     */
    // TODO Parte3 PuntoC: Declare la asociaci�n artistas como una contenedora de tama�o fijo.
    private Artista artistas[];

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del karaoke. <br>
     * La lista de artistas qued� inicializada con los siguientes valores:<br>
     * Artista posici�n 0 - Nombre: Adele, Categor�a: Pop, Ruta de la imagen:"Adele.jpg". <br>
     * Artista posici�n 1 - Nombre: AC/DC, Categor�a: Rock, Ruta de la imagen:"AC_DC.jpg". <br>
     * Artista posici�n 2 - Nombre: Calvin Harris, Categor�a: Electro house, Ruta de la imagen:"CalvinHarris.jpg". <br>
     * Artista posici�n 3 - Nombre: ChocQuibTown, Categor�a: Fusi�n latina, Ruta de la imagen:"Chocquibtown.jpg". <br>
     * Artista posici�n 4 - Nombre: Michael Jackson, Categor�a: Pop, Ruta de la imagen:"MichaelJackson.jpg". <br>
     * Artista posici�n 5 - Nombre: Rihanna, Categor�a: Pop, Ruta de la imagen:"Rihanna.jpg". <br>
     * Artista posici�n 6 - Nombre: Bomba Est�reo, Categor�a: Fusi�n latina, Ruta de la imagen:"BombaEstereo.jpg". <br>
     * Artista posici�n 7 - Nombre: Green Day, Categor�a: Rock, Ruta de la imagen:"GreenDay.jpg". <br>
     * Artista posici�n 8 - Nombre: Bon Jovi, Categor�a: Rock, Ruta de la imagen:"BonJovi.jpg". <br>
     * Se inicializ� la lista que contiene las listas de reproducci�n.
     */
    public Karaoke( )
    {
        artistas = new Artista[CANTIDAD_ARTISTAS];

        artistas[ 0 ] = new Artista( "Adele", Artista.POP, "./data/imagenes/Adele.jpg" );
        artistas[ 1 ] = new Artista( "AC/DC", Artista.ROCK, "./data/imagenes/AC_DC.jpg" );
        artistas[ 2 ] = new Artista( "Calvin Harris", Artista.ELECTRO_HOUSE, "./data/imagenes/CalvinHarris.jpg" );
        artistas[ 3 ] = new Artista( "ChocQuibTown", Artista.FUSION_LATINA, "./data/imagenes/Chocquibtown.jpg" );
        artistas[ 4 ] = new Artista( "Michael Jackson", Artista.POP, "./data/imagenes/MichaelJackson.jpg" );
        // TODO Parte3 PuntoD: Asigne las posiciones 5, 6, 7, 8 seg�n la documentaci�n dada.
        artistas[ 5 ] = new Artista( "Rihanna", Artista.POP, "./data/imagenes/Rihanna.jpg" );
        artistas[ 6 ] = new Artista( "Bomba Est�reo", Artista.FUSION_LATINA, "./data/imagenes/BombaEstereo.jpg" );
        artistas[ 7 ] = new Artista( "Green Day", Artista.ROCK, "./data/imagenes/GreenDay.jpg" );
        artistas[ 8 ] = new Artista( "Bon Jovi", Artista.ROCK, "./data/imagenes/BonJovi.jpg" );

        artistas[ 9 ] = new Artista( "Sia", Artista.POP, "./data/imagenes/Sia.jpg" );

        // TODO Parte2 PuntoE: Inicialice la contenedora de listasDeReproduccion seg�n la documentaci�n dada.
        listasDeReproduccion = new ArrayList<ListaReproduccion>( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna los artistas del karaoke. <br>
     * <b> pre: </b> El arreglo de artistas se ha inicializado.
     * @return Arreglo con los artistas del karaoke.
     */
    public Artista[] darArtistas( )
    {
        // TODO Parte3 PuntoF: Complete el m�todo seg�n la documentaci�n dada.
        return artistas;
    }

    /**
     * Retorna las listas de reproducci�n del karaoke. <br>
     * <b> pre: </b> El vector de listas de reproducci�n se ha inicializado.
     * @return Lista que contiene las listas de reproducci�n del karaoke.
     */
	public ArrayList< ListaReproduccion > darListasDeReproduccion( )
    {
        // TODO Parte3 PuntoG: Complete el m�todo seg�n la documentaci�n dada.
        return listasDeReproduccion;
    }

    /**
     * Retorna los artistas de una categor�a dada. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas creados.
     * @param pNombre Nombre de la categor�a. pNombre pertenece a {Artista.ROCK, Artista.POP, Artista.FUSION_LATINA, Artista.ELECTRO_HOUSE}.
     * @return Lista con los artistas de la categor�a dada.
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
     * Retorna una lista con todas las canciones de la categor�a con el nombre dado. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas creados.
     * @param pNombre Nombre de la categor�a. pNombre pertenece a {Artista.ROCK, Artista.POP, Artista.FUSION_LATINA, Artista.ELECTRO_HOUSE}.
     * @return Lista con todas las canciones de una categor�a.
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
     * Retorna la lista de canciones de un artista con el nombre recibido por par�metro. <br>
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
     * Busca la canci�n con mayor dificultad. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas han sido creados.
     * @return La canci�n con mayor dificultad. <br>
     *         Si ning�n artista tiene canciones se retorna null.<br>
     *         Si existen varias canciones con la misma dificultad retorna la primera canci�n encontrada.
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
     * Busca la canci�n con menor dificultad. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas han sido creados.
     * @return La canci�n con menor dificultad. <br>
     *         Si ning�n artista tiene canciones se retorna null. <br>
     *         Si existen varias canciones con la misma dificultad retorna la primera canci�n encontrada.
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
     * Busca la canci�n con mayor duraci�n. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas han sido creados.
     * @return La canci�n con mayor duraci�n. <br>
     *         Si ning�n artista tiene canciones se retorna null. <br>
     *         Si existen varias canciones con la misma duraci�n retorna la primera canci�n encontrada.
     */
    public Cancion darCancionMasLarga( )
    {
        // TODO Parte3 PuntoK: Complete el m�todo seg�n la documentaci�n dada.
        Cancion masLarga = null;
        int larga = 0;
        Cancion cancionL = null;
        for( int i = 0; i < artistas.length; i++ )
        {
            cancionL = artistas[ i ].darCancionMasLarga( );
            if( cancionL != null && cancionL.darDuracion( ) > larga )
            {
                masLarga = cancionL;
                larga = cancionL.darDuracion( );
            }
        }
        return masLarga;
    }

    /**
     * Busca la canci�n con menor duraci�n. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas han sido creados.
     * @return La canci�n con menor duraci�n. <br>
     *         Si ning�n artista tiene canciones se retorna null. <br>
     *         Si existen varias canciones con la misma duraci�n retorna la primera canci�n encontrada.
     */
    public Cancion darCancionMasCorta( )
    {
        // TODO Parte3 PuntoK: Complete el m�todo seg�n la documentaci�n dada.
        Cancion masCorta = null;
        int corta = 0;
        Cancion cancionC = null;
        if( darCancionMasLarga( ) != null )
            corta = darCancionMasLarga( ).darDuracion( );

        for( int i = 0; i < artistas.length; i++ )
        {
            cancionC = artistas[ i ].darCancionMasCorta( );
            if( cancionC != null && cancionC.darDuracion( ) < corta )
            {
                masCorta = cancionC;
                corta = cancionC.darDuracion( );
            }
        }
        return masCorta;
    }

    /**
     * Busca el artista con mayor n�mero de canciones. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y los artistas han sido creados.
     * @return El artista con mayor n�mero de canciones. <br>
     *         Si no existen artistas se retorna null. <br>
     *         Si existen varios artistas con el mismo n�mero de canciones retorna el primer artista encontrado.
     */
    public Artista darArtistaMasCanciones( )
    {
        // TODO Parte3 PuntoK: Complete el m�todo seg�n la documentaci�n dada.
        Artista artistaMayorNumeroCanciones = null;
        int mayorNumeroCanciones = 0;
        for( int i = 0; i < artistas.length; i++ )
        {
            if( artistas[ i ].darCanciones( ).size( ) > mayorNumeroCanciones )
            {
                artistaMayorNumeroCanciones = artistas[ i ];
                mayorNumeroCanciones = artistas[ i ].darCanciones( ).size( );
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
        // TODO Parte3 PuntoF: Complete el m�todo seg�n la documentaci�n dada.
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
     * Retorna una canci�n con el nombre dado.
     * @param pNombreCancion Nombre de la canci�n. pNombreCancion != "" && pNombreCancion != null.
     * @return La canci�n con el nombre dado. Si la canci�n no se encuentra se retorna null.
     */
    public Cancion buscarCancionEnKaraoke( String pNombreCancion )
    {
        // TODO Parte3 PuntoK: Complete el m�todo seg�n la documentaci�n dada.
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
     * Retorna el �ndice de la lista de reproducci�n que tiene el nombre dado por par�metro. <br>
     * <b>pre:</b> La lista que contiene las listas de reproducci�n est� inicializada. <br>
     * @param pNombre Nombre de la lista de reproducci�n que se est� buscando. pNombre != null && pNombre != "".
     * @return �ndice de la lista de reproducci�n que se est� buscando, -1 en caso de no encontrarla.
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
     * Agrega una nueva canci�n a un artista del karaoke. <br>
     * <b> pre: </b> El arreglo de artistas ha sido inicializado y el artista existe. <br>
     * <b> post: </b> Se ha agregado una nueva canci�n a un artista del karaoke.
     * @param pArtista Nombre del artista int�rprete de la canci�n. pArtista != null y pArtista != ""
     * @param pNombre Nombre de la canci�n. pNombre != null y pNombre != ""
     * @param pDuracion Duraci�n en segundos de la canci�n. pDuracion > 0
     * @param pLetra Letra de la canci�n. pLetra != null y pLetra != ""
     * @param pDificultad Dificultad de la canci�n. pDificultad >= 1 y pDificultad <= 10
     * @param pRuta Ruta del archivo con la canci�n. pRuta != null y pRuta != ""
     * @return Verdadero si la canci�n fue agregada, falso de lo contrario.
     */
    public boolean agregarCancion( String pArtista, String pNombre, int pDuracion, String pLetra, int pDificultad, String pRuta )
    {
        // TODO Parte3 PuntoH: Complete el m�todo seg�n la documentaci�n dada.
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
     * Agrega una nueva lista de reproducci�n a la lista de listas de reproducci�n del karaoke. <br>
     * <b> pre: </b> La lista que contiene las listas de reproducci�n ha sido inicializada. <br>
     * No existe una lista de reproducci�n con el mismo nombre. <br>
     * <b> post: </b> Se ha agregado una nueva lista de reproducci�n a la lista que contiene las listas de reproducci�n.
     * @param pNombreListaReproduccion Nombre de la lista de reproducci�n. pNombreListaReproduccion != null y pNombreListaReproduccion != "".
     */
    public void agregarListaReproduccion( String pNombreListaReproduccion )
    {
        // TODO Parte3 PuntoI: Complete el m�todo seg�n la documentaci�n dada.
        if( buscarListaReproduccion( pNombreListaReproduccion ) == -1 )
        {
            listasDeReproduccion.add( new ListaReproduccion( pNombreListaReproduccion ) );
        }
    }

    /**
     * Agregar una canci�n a una lista de reproducci�n.<br>
     * <b>pre:</b> La lista que contiene las listas de reproducci�n est� inicializada. <br>
     * La lista de canciones est� inicializada. <br>
     * No existe una canci�n con el nombre dado. <br>
     * Existe una lista de reproducci�n con el nombre dado. <br>
     * <b> post: </b> La lista de reproducci�n tiene una canci�n adicional.
     * @param pNombreCancion Nombre de la canci�n a agregar. pNombreCancion != null && pNombreCancion != null.
     * @param pNombreListaReproduccion Nombre de la lista de reproducci�n. pNombreListaReproduccion != null && pNombreListaReproduccion != null.
     */
    public void agregarCancionAListaReproduccion( String pNombreCancion, String pNombreListaReproduccion )
    {

        // TODO Parte3 PuntoJ: Complete el m�todo seg�n la documentaci�n dada.
        ListaReproduccion lista = null;
        if( buscarListaReproduccion( pNombreListaReproduccion ) != -1 )
        {
            lista = listasDeReproduccion.get( buscarListaReproduccion( pNombreListaReproduccion ) );
            if( lista.buscarCancion( pNombreCancion ) == null )
                lista.agregarCancion( buscarCancionEnKaraoke( pNombreCancion ) );
        }
    }

    /**
     * Elimina una lista de reproducci�n de la lista de listas de reproducci�n del karaoke. <br>
     * <b> pre: </b> La lista que contiene las listas de reproducci�n ha sido inicializada. <br>
     * Existe una lista de reproduccion con el nombre dado. <br>
     * <b> post: </b> Se ha eliminado una lista de reproducci�n de la lista que contiene las listas de reproducci�n.
     * @param pNombreListaReproduccion Nombre de la lista de reproducci�n. pNombreListaReproduccion != null y pNombreListaReproduccion != ""
     */
    public void eliminarListaReproduccion( String pNombreListaReproduccion )
    {
        // TODO Parte3 PuntoK: Complete el m�todo seg�n la documentaci�n dada.
        if( buscarListaReproduccion( pNombreListaReproduccion ) != -1 )
            listasDeReproduccion.remove( buscarListaReproduccion( pNombreListaReproduccion ) );

    }

    /**
     * Elimina una canci�n de una lista de reproducci�n.<br>
     * <b>pre:</b> La lista que contiene las listas de reproducci�n est� inicializada. <br>
     * La lista de canciones est� inicializada. <br>
     * Existe una canci�n con el nombre dado. <br>
     * Existe una lista de reproducci�n con el nombre dado. <br>
     * <b> post: </b> Se elimin� una canci�n de la lista de reproducci�n.
     * @param pNombreCancion Nombre de la canci�n a eliminar. pNombreCancion != null && pNombreCancion != null.
     * @param pNombreListaReproduccion Nombre de la lista de reproducci�n. pNombreListaReproduccion != null && pNombreListaReproduccion != null.
     */
    public void eliminarCancionDeListaReproduccion( String pNombreCancion, String pNombreListaReproduccion )
    {

        // TODO Parte3 PuntoL: Complete el m�todo seg�n la documentaci�n dada.
        ListaReproduccion lista = null;
        if( buscarListaReproduccion( pNombreListaReproduccion ) != -1 )
        {
            lista = listasDeReproduccion.get( buscarListaReproduccion( pNombreListaReproduccion ) );
            if( lista.buscarCancion( pNombreCancion ) != null )
                lista.eliminarCancion( pNombreCancion );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * 
     * @return Respuesta 1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n 2.
     * 
     * @return Respuesta 2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}