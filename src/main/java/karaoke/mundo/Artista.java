package karaoke.mundo;

import java.util.ArrayList;

/**
 * Artista intórprete de las canciones del karaoke.
 */
public class Artista
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa la categoróa Rock.
     */
    public static final String ROCK = "Rock";

    /**
     * Representa la categoróa Pop.
     */
    public final static String POP = "Pop";

    /**
     * Representa la categoróa Fusión latina.
     */
    public final static String FUSION_LATINA = "Fusión latina";

    /**
     * Representa la categoróa Electro house.
     */
    public final static String ELECTRO_HOUSE = "Electro house";

    /**
     * Representa la categoróa Dubstep.
     */
    public final static String DUBSTEP = "Dubstep";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del artista.
     */
    private String nombre;

    /**
     * Categoróa del artista.
     */
    private String categoria;

    /**
     * Ruta del archivo con la imagen del artista.
     */
    private String imagen;

    /**
     * Lista de canciones del artista.
     */
    // TODO Parte2 PuntoA: Declare la asociación canciones como una contenedora de tipo variable.
    private ArrayList<Cancion> canciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un artista. <br>
     * <b>post: </b> Se inicializaron los atributos nombre, categoróa e imagen con los valores dados por parómetro. <br>
     * Se inicializó caNombre del artista. pNombre != null y pNombre != "".nciones como una lista vacóa.
     * @param pNombre Nombre del artista. pNombre != null y pNombre != "".
     * @param pCategoria Categoróa del artista. pCategoria pertenece a {Artista.ROCK, Artista.POP, Artista.FUSION_LATINA, Artista.ELECTRO_HOUSE}.
     * @param pImagen Ruta del archivo con la imagen del artista. pImagen != null y pImagen != "".
     */
    public Artista( String pNombre, String pCategoria, String pImagen )
    {
        nombre = pNombre;
        categoria = pCategoria;
        imagen = pImagen;

        // TODO Parte2 PuntoB: Inicialice la contenedora de canciones segón la documentación dada.
        canciones = new ArrayList<Cancion>( );
    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del artista.
     * @return Nombre del artista.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la categoróa del artista.
     * @return Categoróa del artista.
     */
    public String darCategoria( )
    {
        return categoria;
    }

    /**
     * Retorna la ruta del archivo con la imagen del artista.
     * @return Ruta de la imagen.
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Retorna la lista de canciones del artista.
     * @return Lista de canciones.
     */
    public ArrayList<Cancion> darCanciones( )
    {
        // TODO Parte2 PuntoC: Complete el mótodo segón la documentación dada.
        return canciones;
    }

    /**
     * Busca la canción con mayor dificultad. Si existen varias canciones con la misma dificultad retorna la primera canción encontrada.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.
     * @return La canción del artista con mayor dificultad. Si el artista no tiene ninguna canción se retorna null.
     */
    public Cancion darCancionMasDificil( )
    {
        Cancion dificil = null;
        int dificultad = 0;

        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion cancion = canciones.get( i );
            int dificultadC = cancion.darDificultad( );
            if( dificultadC > dificultad )
            {
                dificil = cancion;
                dificultad = dificultadC;
            }
        }

        return dificil;
    }

    /**
     * Busca la canción con menor dificultad. Si existen varias canciones con la misma dificultad retorna la primera canción encontrada.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.
     * @return La canción del artista con menor dificultad. Si el artista no tiene ninguna canción se retorna null.
     */
    public Cancion darCancionMasFacil( )
    {
        Cancion facil = null;
        int dificultad = 11;

        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion cancion = canciones.get( i );
            int dificultadC = cancion.darDificultad( );
            if( dificultadC < dificultad )
            {
                facil = cancion;
                dificultad = dificultadC;
            }
        }

        return facil;
    }

    /**
     * Busca la canción con mayor duración. Si existen varias canciones con la misma duración retorna la primera canción encontrada.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.
     * @return La canción del artista con mayor duración. Si el artista no tiene ninguna canción se retorna null.
     */
    public Cancion darCancionMasLarga( )
    {
        // TODO Parte2 PuntoD: Complete el mótodo segón la documentación dada.
        Cancion masLarga = null;
        int larga = 0;

        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion cancion = canciones.get( i );
            int cancionLarga = cancion.darDuracion( );
            if( cancionLarga > larga )
            {
                masLarga = cancion;
                larga = cancionLarga;
            }
        }

        return masLarga;
    }

    /**
     * Busca la canción con menor duración. Si existen varias canciones con la misma duración retorna la primera canción encontrada.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.
     * @return La canción del artista con menor duración. Si el artista no tiene ninguna canción se retorna null.
     */
    public Cancion darCancionMasCorta( )
    {
        // TODO Parte2 PuntoE: Complete el mótodo segón la documentación dada.
        Cancion masCorta = null;
        int corta = 0;
        if( !canciones.isEmpty( ) )
        {
            Cancion cancion = canciones.get( 0 );
            corta = cancion.darDuracion( );
            for( int i = 1; i < canciones.size( ); i++ )
            {
                cancion = canciones.get( i );
                int cancionCorta = cancion.darDuracion( );
                if( cancionCorta < corta )
                {
                    masCorta = cancion;
                    corta = cancionCorta;
                }
            }
        }

        return masCorta;
    }

    /**
     * Busca una canción con el nombre dado.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.
     * @param pNombre Nombre de la canción. pNombre != null y pNombre != "".
     * @return La canción con el nombre dado. Si no existe una canción con ese nombre se retorna null.
     */
    public Cancion buscarCancion( String pNombre )
    {
        // TODO Parte2 PuntoF: Complete el mótodo segón la documentación dada.
        boolean encontrado = false;
        Cancion cancionEncontrada = null;
        for( int i = 0; i < canciones.size( ) && !encontrado; i++ )
        {
            if( ( canciones.get( i ) ).darNombre( ).equals( pNombre ) )
            {
                cancionEncontrada = canciones.get( i );
                encontrado = true;
            }
        }
        return cancionEncontrada;
    }

    /**
     * Agrega una nueva canción a la lista de canciones del artista. Si ya existe una canción del artista con el mismo nombre, la canción no puede ser agregada.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.<br>
     * <b> post: </b> Se ha agregado una nueva canción a la lista de canciones.
     * @param pNombre Nombre de la canción. pNombre != null y pNombre != "".
     * @param pDuracion Duración en segundos de la canción. pDuracion > 0.
     * @param pLetra Letra de la canción. pLetra != null y pLetra != "".
     * @param pDificultad Dificultad de la canción. pDificultad >= 1 y pDificultad <= 10.
     * @param pRuta Ruta del archivo con la canción. pRuta != null y pRuta != "".
     * @return Verdadero si la canción fue agregada, falso de lo contrario.
     */
    public boolean agregarCancion( String pNombre, int pDuracion, String pLetra, int pDificultad, String pRuta )
    {
        // TODO Parte2 PuntoG: Complete el mótodo segón la documentación dada.
        if( buscarCancion( pNombre ) == null )
        {
            canciones.add( new Cancion( pNombre, pDuracion, pLetra, pDificultad, pRuta ) );
            return true;
        }
        return false;
    }
    /**
     * Retorna una cadena de caracteres con la información del artista.
     * @return Cadena de caracteres con la información del artista: nombre.
     */
    @Override
    public String toString( )
    {
        return nombre;
    }
}