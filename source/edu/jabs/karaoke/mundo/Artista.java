package edu.jabs.karaoke.mundo;

import java.util.ArrayList;

/**
 * Artista int�rprete de las canciones del karaoke.
 */
public class Artista
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa la categor�a Rock.
     */
    public static final String ROCK = "Rock";

    /**
     * Representa la categor�a Pop.
     */
    public final static String POP = "Pop";

    /**
     * Representa la categor�a Fusi�n latina.
     */
    public final static String FUSION_LATINA = "Fusi�n latina";

    /**
     * Representa la categor�a Electro house.
     */
    public final static String ELECTRO_HOUSE = "Electro house";

    /**
     * Representa la categor�a Dubstep.
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
     * Categor�a del artista.
     */
    private String categoria;

    /**
     * Ruta del archivo con la imagen del artista.
     */
    private String imagen;

    /**
     * Lista de canciones del artista.
     */
    // TODO Parte2 PuntoA: Declare la asociaci�n canciones como una contenedora de tipo variable.
    private ArrayList<Cancion> canciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un artista. <br>
     * <b>post: </b> Se inicializaron los atributos nombre, categor�a e imagen con los valores dados por par�metro. <br>
     * Se inicializ� caNombre del artista. pNombre != null y pNombre != "".nciones como una lista vac�a.
     * @param pNombre Nombre del artista. pNombre != null y pNombre != "".
     * @param pCategoria Categor�a del artista. pCategoria pertenece a {Artista.ROCK, Artista.POP, Artista.FUSION_LATINA, Artista.ELECTRO_HOUSE}.
     * @param pImagen Ruta del archivo con la imagen del artista. pImagen != null y pImagen != "".
     */
    public Artista( String pNombre, String pCategoria, String pImagen )
    {
        nombre = pNombre;
        categoria = pCategoria;
        imagen = pImagen;

        // TODO Parte2 PuntoB: Inicialice la contenedora de canciones seg�n la documentaci�n dada.
        canciones = new ArrayList<Cancion>( );
    }

    // -----------------------------------------------------------------
    // M�todos
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
     * Retorna la categor�a del artista.
     * @return Categor�a del artista.
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
        // TODO Parte2 PuntoC: Complete el m�todo seg�n la documentaci�n dada.
        return canciones;
    }

    /**
     * Busca la canci�n con mayor dificultad. Si existen varias canciones con la misma dificultad retorna la primera canci�n encontrada.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.
     * @return La canci�n del artista con mayor dificultad. Si el artista no tiene ninguna canci�n se retorna null.
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
     * Busca la canci�n con menor dificultad. Si existen varias canciones con la misma dificultad retorna la primera canci�n encontrada.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.
     * @return La canci�n del artista con menor dificultad. Si el artista no tiene ninguna canci�n se retorna null.
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
     * Busca la canci�n con mayor duraci�n. Si existen varias canciones con la misma duraci�n retorna la primera canci�n encontrada.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.
     * @return La canci�n del artista con mayor duraci�n. Si el artista no tiene ninguna canci�n se retorna null.
     */
    public Cancion darCancionMasLarga( )
    {
        // TODO Parte2 PuntoD: Complete el m�todo seg�n la documentaci�n dada.
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
     * Busca la canci�n con menor duraci�n. Si existen varias canciones con la misma duraci�n retorna la primera canci�n encontrada.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.
     * @return La canci�n del artista con menor duraci�n. Si el artista no tiene ninguna canci�n se retorna null.
     */
    public Cancion darCancionMasCorta( )
    {
        // TODO Parte2 PuntoE: Complete el m�todo seg�n la documentaci�n dada.
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
     * Busca una canci�n con el nombre dado.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.
     * @param pNombre Nombre de la canci�n. pNombre != null y pNombre != "".
     * @return La canci�n con el nombre dado. Si no existe una canci�n con ese nombre se retorna null.
     */
    public Cancion buscarCancion( String pNombre )
    {
        // TODO Parte2 PuntoF: Complete el m�todo seg�n la documentaci�n dada.
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
     * Agrega una nueva canci�n a la lista de canciones del artista. Si ya existe una canci�n del artista con el mismo nombre, la canci�n no puede ser agregada.<br>
     * <b> pre: </b> La lista de canciones ha sido inicializada.<br>
     * <b> post: </b> Se ha agregado una nueva canci�n a la lista de canciones.
     * @param pNombre Nombre de la canci�n. pNombre != null y pNombre != "".
     * @param pDuracion Duraci�n en segundos de la canci�n. pDuracion > 0.
     * @param pLetra Letra de la canci�n. pLetra != null y pLetra != "".
     * @param pDificultad Dificultad de la canci�n. pDificultad >= 1 y pDificultad <= 10.
     * @param pRuta Ruta del archivo con la canci�n. pRuta != null y pRuta != "".
     * @return Verdadero si la canci�n fue agregada, falso de lo contrario.
     */
    public boolean agregarCancion( String pNombre, int pDuracion, String pLetra, int pDificultad, String pRuta )
    {
        // TODO Parte2 PuntoG: Complete el m�todo seg�n la documentaci�n dada.
        if( buscarCancion( pNombre ) == null )
        {
            canciones.add( new Cancion( pNombre, pDuracion, pLetra, pDificultad, pRuta ) );
            return true;
        }
        return false;
    }
    /**
     * Retorna una cadena de caracteres con la informaci�n del artista.
     * @return Cadena de caracteres con la informaci�n del artista: nombre.
     */
    @Override
    public String toString( )
    {
        return nombre;
    }
}