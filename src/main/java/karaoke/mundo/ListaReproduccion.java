package karaoke.mundo;

import java.util.ArrayList;

/**
 * Representa una lista de reproducción del karaoke.
 */
public class ListaReproduccion
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Lista de canciones incluidas en la lista de reproducción.
     */
	private ArrayList< Cancion > canciones;

    /**
     * Nombre de la lista de reproducción.
     */
    private String nombre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva lista de reproducción.<br>
     * <b>post: </b> Se inicializó el atributo nombre con el valor dado por parómetro.<br>
     * Se inicializó canciones como una lista vacóa.
     * @param pNombre Nombre de la lista de reproducción. pNombre != null && pNombre != "".
     */
    public ListaReproduccion( String pNombre )
    {
        nombre = pNombre;
        canciones = new ArrayList<>( );
    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la lista de reproducción.
     * @return Nombre de la lista de reproducción.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la lista de canciones incluidas en la lista de reproducción.
     * @return Lista de canciones incluidas en la lista de reproducción.
     */
	public ArrayList< Cancion > darCanciones( )
    {
        return canciones;
    }

    /**
     * Busca una canción con el nombre recibido por parómetro en la lista de canciones. <br>
     * <b>pre: </b> La lista de canciones estó inicializada.
     * @param pNombreCancion Nombre de la canción. pNombreCancion != null && pNombreCancion != "".
     * @return La canción con el nombre dado. Si no existe una canción con ese nombre se retorna null.
     */
    public Cancion buscarCancion( String pNombreCancion )
    {
        Cancion cancionActual = null;
        Cancion cancionBuscada = null;

        for ( Cancion cancione : canciones )
        {
            cancionActual = ( Cancion ) cancione;
            String nombreC = cancionActual.darNombre( );
            if ( nombreC.equalsIgnoreCase( pNombreCancion ) )
            {
                cancionBuscada = cancionActual;
            }
        }
        return cancionBuscada;
    }

    /**
     * Agrega una canción a la lista de canciones en la lista de reproducción. <br>
     * <b>pre: </b> La lista de canciones estó inicializada. <br>
     * No existe una canción con el nombre dado. <br>
     * <b> post: </b> Se agregó la canción a la lista de reproducción.
     * @param pCancion Canción que se va a agregar. pCancion != null.
     */
    public void agregarCancion( Cancion pCancion )
    {
        canciones.add( pCancion );
    }

    /**
     * Elimina la canción que tiene el nombre dado por parómetro.<br>
     * <b>pre: </b> La lista de canciones estó inicializada.<br>
     * La canción con el nombre dado existe. <br>
     * <b> post: </b> Se eliminó la canción con el nombre dado de la lista de canciones.
     * @param pNombreCancion Nombre de la canción a eliminar. pNombreCancion != null && pNombreCancion != "".
     */
    public void eliminarCancion( String pNombreCancion )
    {

        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion cancionActual = canciones.get( i );
            if( cancionActual.darNombre( ).equals( pNombreCancion ) )
            {
                canciones.remove( i );
            }
        }
    }

}
