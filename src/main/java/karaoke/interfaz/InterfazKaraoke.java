package karaoke.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import karaoke.mundo.Artista;
import karaoke.mundo.Cancion;
import karaoke.mundo.Karaoke;
import karaoke.mundo.ListaReproduccion;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazKaraoke extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Persistencia en clase Java.
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Ruta del archivo con la configuración inicial del karaoke.
	 */
    private final static String RUTA_ARCHIVO = "karaoke.properties";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Karaoke karaoke;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con la información de una canción.
     */
    private PanelCancion panelCancion;

    /**
     * Panel con las opciones de bósqueda y extensión.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con la información de las listas de reproducción.
     */
    private PanelListaReproduccion panelListaReproduccion;

    /**
     * Panel con la información del artista.
     */
    private PanelArtista panelArtista;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana de la aplicación. <br>
     * <b>post: </b> Se inicializaron los póneles con la información del sistema.
     */
    public InterfazKaraoke( )
    {
        // Crea la clase principal
        karaoke = new Karaoke( );
        cargarKaraoke( );

        // Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 1000, 750 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( " CupiKaraoke " );

        // Creación de los póneles
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelOpciones = new PanelOpciones( this );
        panelCancion = new PanelCancion( );
        panelListaReproduccion = new PanelListaReproduccion( this );
        panelArtista = new PanelArtista( this );

        JPanel aux = new JPanel( );
        aux.setLayout( new GridLayout( 1, 1 ) );
        aux.add( panelOpciones );
        add( aux, BorderLayout.SOUTH );

        JPanel aux2 = new JPanel( );
        aux2.setLayout( new BorderLayout( ) );
        aux2.add( panelArtista, BorderLayout.WEST );
        aux2.add( panelCancion, BorderLayout.CENTER );
        aux2.add( panelListaReproduccion, BorderLayout.SOUTH );
        add( aux2, BorderLayout.CENTER );

        // Centrar la ventana
        setLocationRelativeTo( null );

        String c = panelArtista.darCategoriaSeleccionada( );
        actualizarArtistas( c );
    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Retorna las canciones de un artista.
     * @param pNombre Nombre del artista. pNombre != null y pNombre != "".
     * @return Lista de canciones del artista dado.
     */
	public ArrayList< Cancion > darCancionesArtista( String pNombre )
    {
        return karaoke.darCancionesArtista( pNombre );
    }

    /**
     * Retorna los artistas de una categoróa.
     * @param pCategoria Categoróa de los artistas. pCategoria != null y pCategoria != "".
     * @return Lista de artistas.
     */
	public ArrayList< Artista > darArtistaCategoria( String pCategoria )
    {
        return karaoke.darArtistasCategoria( pCategoria );
    }

    /**
     * Retorna todas las canciones del karaoke.
     * @return Lista de canciones.
     */
	public ArrayList< Cancion > darCancionesKaraoke( )
    {
        return karaoke.darCancionesKaraoke( );
    }

    /**
     * Retorna el artista seleccionado en el panel de artista.
     * @return Artista seleccionado.
     */
    public String darArtistaSeleccionado( )
    {
        return panelArtista.darArtistaSeleccionado( );
    }

    /**
     * Retorna la categoróa seleccionada en el panel de artista.
     * @return Categoróa seleccionada.
     */
    public String darCategoriaSeleccionada( )
    {
        return panelArtista.darCategoriaSeleccionada( );
    }

    /**
     * Retorna las canciones incluidas en una lista de reproducción dado el nombre de la lista de reproducción.
     * @param pNombre Nombre de la lista de reproducción. pNombre != null y pNombre != "".
     * @return Lista de canciones de la lista de reproducción con el nombre dado.
     */
	public ArrayList< Cancion > darCancionesIncluidasListaReproduccion( String pNombre )
    {
        int indiceLista= karaoke.buscarListaReproduccion( pNombre );
        return ((ListaReproduccion)karaoke.darListasDeReproduccion( ).get( indiceLista  )).darCanciones( );
    }

    /**
     * Retorna la lista de canciones del karaoke dada una categoróa.
     * @param pCategoria Categoróa de las canciones. pCategoróa != null && pCategoróa != "".
     * @return Lista de canciones de la categoróa dada.
     */
	public ArrayList< Cancion > darCancionesCategoria( String pCategoria )
    {
        return karaoke.darCancionesCategoria( pCategoria );
    }

    /**
     * Retorna la lista de listas de reproducción del karaoke.
     * @return Lista de listas de reproducción.
     */
	public ArrayList< ListaReproduccion > darListasReproduccionKaraoke( )
    {
        return karaoke.darListasDeReproduccion( );
    }

    /**
     * Carga la información inicial del karaoke.
     */
    private void cargarKaraoke( )
    {
        try
        {
            Properties datos = new Properties( );
            InputStream file = getClass( ).getClassLoader( ).getResourceAsStream( RUTA_ARCHIVO );

            assert file != null;
            datos.load( file );

            int numArtistas = Integer.parseInt( datos.getProperty( "total.artistas" ) );
            for( int i = 1; i <= numArtistas; i++ )
            {
                String nombre = datos.getProperty( "artista" + i + ".nombre" );

                int numCanciones = Integer.parseInt( datos.getProperty( "artista" + i + ".total.canciones" ) );
                for( int j = 1; j <= numCanciones; j++ )
                {
                    String cancion = datos.getProperty( "artista" + i + ".cancion" + j + ".nombre" );
                    int duracion = Integer.parseInt( datos.getProperty( "artista" + i + ".cancion" + j + ".duracion" ) );
                    String letra = datos.getProperty( "artista" + i + ".cancion" + j + ".letra" );
                    int dificultad = Integer.parseInt( datos.getProperty( "artista" + i + ".cancion" + j + ".dificultad" ) );
                    String ruta = datos.getProperty( "artista" + i + ".cancion" + j + ".ruta" );

                    karaoke.agregarCancion( nombre, cancion, duracion, letra, dificultad, ruta );
                }
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "No fue posible cargar la información inicial del karaoke. " + e.getMessage( ), "Cargar karaoke", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega una nueva canción a un artista del karaoke.
     * @param pArtista Nombre del artista intórprete de la canción. pArtista != null y pArtista != "".
     * @param pNombre Nombre de la canción. pNombre != null y pNombre != "".
     * @param pDuracion Duración en segundos de la canción. pDuracion > 0.
     * @param pLetra Letra de la canción. pLetra != null y pLetra != "".
     * @param pDificultad Dificultad de la canción. pDificultad >= 1 y pDificultad <= 10.
     * @param pRuta Ruta del archivo con la canción. pRuta != null y pRuta != "".
     */
    public void agregarCancion( String pArtista, String pNombre, int pDuracion, String pLetra, int pDificultad, String pRuta )
    {
        boolean agregada = karaoke.agregarCancion( pArtista, pNombre, pDuracion, pLetra, pDificultad, pRuta );
        if( agregada )
        {
            panelArtista.actualizarArtista( );
            JOptionPane.showMessageDialog( this, "Canción agregada exitosamente.", "Agregar canción", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No fue posible agregar la canción: " + pNombre, "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega una lista de reproducción al karaoke.<br>
     * <b>pre:</b> La lista de listas de reproducción estó inicializada.<br>
     * <b>post:</b> La lista tiene una lista de reproducción nueva.
     * @param pNombre Nombre de la lista de reproducción. pNombre != null y pNombre != "".
     * @param pCancionInicial Nombre de la primera canción de la lista de reproducción. pCancionInicial != null y pCancionInicial != "".
     */
    public void agregarListaReproduccion( String pNombre, String pCancionInicial )
    {
        if( karaoke.buscarListaReproduccion( pNombre ) == -1 )
        {
            karaoke.agregarListaReproduccion( pNombre );
            karaoke.agregarCancionAListaReproduccion( pCancionInicial, pNombre );
            mostrarListasDeReproduccion( );
            mostrarDialogoCancionesListaReproduccion( pNombre );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Existe una lista de reproducción con el mismo nombre.", "Agregar lista de reproducción", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Agrega una canción a la lista de reproducción dada.
     * @param pNombreCancion Nombre de la canción. pNombreCancion != null && pNombreCancion != null.
     * @param pNombreListaReproduccion Nombre de la lista de reproducción. pNombreListaReproduccion != null && pNombreListaReproduccion != null.
     */
    public void agregarCancionListaReproduccion( String pNombreCancion, String pNombreListaReproduccion )
    {
        int indiceLista = karaoke.buscarListaReproduccion( pNombreListaReproduccion );
        ListaReproduccion listaReproduccionBuscada = (ListaReproduccion) karaoke.darListasDeReproduccion( ).get( indiceLista );

        

        if( listaReproduccionBuscada.buscarCancion( pNombreCancion )== null )
        {

            karaoke.agregarCancionAListaReproduccion( pNombreCancion, pNombreListaReproduccion );
            mostrarListasDeReproduccion( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "La lista de reproducción ya tiene esa canción.", "Agregar canción a lista de reproducción", JOptionPane.ERROR_MESSAGE );

        }

    }

    /**
     * Actualiza la interfaz con la lista de artistas de una categoróa.
     * @param pCategoria Categoróa seleccionada del karaoke. pCategoria != null.
     */
    public void actualizarArtistas( String pCategoria )
    {
		ArrayList< Artista > artistas = karaoke.darArtistasCategoria( pCategoria );
        panelArtista.actualizarArtistas( artistas );
    }

    /**
     * Actualiza la interfaz con la información de una canción.
     * @param pCancion Canción que se debe mostrar. pCancion != null.
     */
    public void actualizarCancion( Cancion pCancion )
    {
        panelCancion.actualizar( pCancion );
    }

    /**
     * Muestra el diólogo para modificar canciones de la lista de reproducción seleccionada.
     */
    public void modificarCancionesListaReproduccion( )
    {
        String seleccionada = panelListaReproduccion.darNombreListaReproduccionSeleccionada( );
        if( seleccionada != "" )
        {
            mostrarDialogoCancionesListaReproduccion( seleccionada );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar una lista de reproducción de la lista.", "Modificar canciones de lista de reproducción", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Elimina la canción de la lista de reproducción.
     * @param pNombreCancion Nombre de la canción. pNombreCancion != null && pNombreAtpNombreCancionraccion != null.
     * @param pNombreListaReproduccion Nombre de la lista de reproducción. pNombreListaReproduccion != null && pNombreListaReproduccion != null.
     */
    public void eliminarCancionDeListaReproduccion( String pNombreCancion, String pNombreListaReproduccion )
    {
        int indiceLista= karaoke.buscarListaReproduccion( pNombreListaReproduccion );
        ListaReproduccion listaReproduccion= (ListaReproduccion)karaoke.darListasDeReproduccion( ).get( indiceLista );

        if( listaReproduccion.buscarCancion( pNombreCancion )!= null )
        {
            karaoke.eliminarCancionDeListaReproduccion( pNombreCancion, pNombreListaReproduccion );
            mostrarListasDeReproduccion( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existe una canción con el nombre dado.", "Eliminar canción de lista de reproducción", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Elimina una lista de reproducción del karaoke.<br>
     * <b>pre:</b> La lista de listas de reproducción estó inicializada.<br>
     * <b>post:</b> La lista tiene un lista de reproducción menos.
     */
    public void eliminarListaReproduccion( )
    {
		ArrayList< ListaReproduccion > listasReproduccion = darListasReproduccionKaraoke( );
        Object[] opciones = new Object[listasReproduccion.size( )];
        if( listasReproduccion.size( ) > 0 )
        {
            for( int i = 0; i < listasReproduccion.size( ); i++ )
            {
                opciones[ i ] = ( ( ListaReproduccion )listasReproduccion.get( i ) ).darNombre( );
            }
            String nombreListaReproduccion = ( String ) JOptionPane.showInputDialog( this, "Listas de reproducción disponibles:", "Listas de reproducción", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[ 0 ] );
            if( nombreListaReproduccion != null )
            {
                if( karaoke.buscarListaReproduccion( nombreListaReproduccion ) != -1 )
                {
                    karaoke.eliminarListaReproduccion( nombreListaReproduccion );
                    JOptionPane.showMessageDialog( this, "Se eliminó la lista de reproducción correctamente.", "Eliminar lista de reproducción", JOptionPane.INFORMATION_MESSAGE );
                    mostrarListasDeReproduccion( );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "No existe una lista de reproducción con el nombre dado.", "Eliminar lista de reproducción", JOptionPane.ERROR_MESSAGE );

                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay listas de reproducción.", "Eliminar lista de reproducción", JOptionPane.ERROR_MESSAGE );

        }

    }

    /**
     * Muestra la canción con mayor dificultad.
     */
    public void mostrarCancionMasDificil( )
    {
        Cancion cancion = karaoke.darCancionMasDificil( );
        if( cancion != null )
        {
            JOptionPane.showMessageDialog( this, "La canción mós difócil es " + cancion.darNombre( ), "Mós difócil", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen canciones en el karaoke.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra la canción con menor dificultad.
     */
    public void mostrarCancionMasFacil( )
    {
        Cancion cancion = karaoke.darCancionMasFacil( );
        if( cancion != null )
        {
            JOptionPane.showMessageDialog( this, "La canción mós fócil es " + cancion.darNombre( ), "Mós fócil", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen canciones en el karaoke.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra la canción con mayor duración.
     */
    public void mostrarCancionMasLarga( )
    {
        Cancion cancion = karaoke.darCancionMasLarga( );
        if( cancion != null )
        {
            JOptionPane.showMessageDialog( this, "La canción mós larga es " + cancion.darNombre( ), "Mós larga", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen canciones en el karaoke.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra la canción con menor duración.
     */
    public void mostrarCancionMasCorta( )
    {
        Cancion cancion = karaoke.darCancionMasCorta( );
        if( cancion != null )
        {
            JOptionPane.showMessageDialog( this, "La canción mós corta es " + cancion.darNombre( ), "Mós corta", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen canciones en el karaoke.", "Error", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Muestra el artista con mayor nómero de canciones.
     */
    public void mostrarArtistaMasCanciones( )
    {
        Artista artista = karaoke.darArtistaMasCanciones( );
        if( artista != null )
        {
            JOptionPane.showMessageDialog( this, "El artista con mós canciones es " + artista.darNombre( ), "Artista con mós canciones", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen artistas en el karaoke.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra una lista con todas las canciones de una categoróa del karaoke.
     * @param pCategoria Nombre de la categoróa.
     */
    public void mostrarCanciones( String pCategoria )
    {
		ArrayList< Cancion > canciones = karaoke.darCancionesCategoria( pCategoria );
        DialogoCanciones dialogo = new DialogoCanciones( pCategoria, canciones );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el diólogo que permite agregar una lista de reproducción.
     */
    public void mostrarDialogoAgregarListaReproduccion( )
    {
        DialogoAgregarListaReproduccion dialogo = new DialogoAgregarListaReproduccion( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el diólogo para agregar o eliminar canciones de una lista de reproducción.
     * @param pNombre Nombre del ListaReproduccion. pNombre != null y pNombre != "".
     */
    public void mostrarDialogoCancionesListaReproduccion( String pNombre )
    {
        DialogoCancionesListaReproduccion dialogo = new DialogoCancionesListaReproduccion( this, pNombre );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra todas las listas de reproducción del karaoke en PanelListaReproduccion.
     */
    public void mostrarListasDeReproduccion( )
    {
        panelListaReproduccion.repaint( );
        panelListaReproduccion.actualizarListaReproduccion( karaoke.darListasDeReproduccion( ) );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Mótodo para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = karaoke.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Mótodo para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = karaoke.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este mótodo ejecuta la aplicación, creando una nueva interfaz.
     * @param pArgs Argumentos para la ejecución de la aplicación. En este caso no son necesarios.
     */
    public static void main( String[] pArgs )
    {
        InterfazKaraoke interfaz = new InterfazKaraoke( );
        interfaz.setVisible( true );
    }
}