package edu.jabs.karaoke.mundo;

import java.util.ArrayList;

/**
 * Representa una lista de reproducci�n del karaoke.
 */
public class ListaReproduccion
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Lista de canciones incluidas en la lista de reproducci�n.
     */
	private ArrayList< Cancion > canciones;

    /**
     * Nombre de la lista de reproducci�n.
     */
    private String nombre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva lista de reproducci�n.<br>
     * <b>post: </b> Se inicializ� el atributo nombre con el valor dado por par�metro.<br>
     * Se inicializ� canciones como una lista vac�a.
     * @param pNombre Nombre de la lista de reproducci�n. pNombre != null && pNombre != "".
     */
    public ListaReproduccion( String pNombre )
    {
        nombre = pNombre;
		canciones = new ArrayList< Cancion >( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la lista de reproducci�n.
     * @return Nombre de la lista de reproducci�n.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la lista de canciones incluidas en la lista de reproducci�n.
     * @return Lista de canciones incluidas en la lista de reproducci�n.
     */
	public ArrayList< Cancion > darCanciones( )
    {
        return canciones;
    }

    /**
     * Busca una canci�n con el nombre recibido por par�metro en la lista de canciones. <br>
     * <b>pre: </b> La lista de canciones est� inicializada.
     * @param pNombreCancion Nombre de la canci�n. pNombreCancion != null && pNombreCancion != "".
     * @return La canci�n con el nombre dado. Si no existe una canci�n con ese nombre se retorna null.
     */
    public Cancion buscarCancion( String pNombreCancion )
    {
        Cancion cancionActual = null;
        Cancion cancionBuscada = null;

        for( int i = 0; i < canciones.size( ); i++ )
        {
            cancionActual = ( Cancion )canciones.get( i );
            String nombreC = cancionActual.darNombre( );
            if( nombreC.equalsIgnoreCase( pNombreCancion ) )
            {
                cancionBuscada = cancionActual;
            }
        }
        return cancionBuscada;
    }

    /**
     * Agrega una canci�n a la lista de canciones en la lista de reproducci�n. <br>
     * <b>pre: </b> La lista de canciones est� inicializada. <br>
     * No existe una canci�n con el nombre dado. <br>
     * <b> post: </b> Se agreg� la canci�n a la lista de reproducci�n.
     * @param pCancion Canci�n que se va a agregar. pCancion != null.
     */
    public void agregarCancion( Cancion pCancion )
    {
        canciones.add( pCancion );
    }

    /**
     * Elimina la canci�n que tiene el nombre dado por par�metro.<br>
     * <b>pre: </b> La lista de canciones est� inicializada.<br>
     * La canci�n con el nombre dado existe. <br>
     * <b> post: </b> Se elimin� la canci�n con el nombre dado de la lista de canciones.
     * @param pNombreCancion Nombre de la canci�n a eliminar. pNombreCancion != null && pNombreCancion != "".
     */
    public void eliminarCancion( String pNombreCancion )
    {

        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion cancionActual = ( Cancion )canciones.get( i );
            if( cancionActual.darNombre( ).equals( pNombreCancion ) )
            {
                canciones.remove( i );
            }
        }
    }

}
