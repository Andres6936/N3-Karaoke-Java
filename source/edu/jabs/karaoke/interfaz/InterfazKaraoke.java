package edu.jabs.karaoke.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.jabs.karaoke.mundo.Artista;
import edu.jabs.karaoke.mundo.Cancion;
import edu.jabs.karaoke.mundo.Karaoke;
import edu.jabs.karaoke.mundo.ListaReproduccion;

/**
 * Ventana principal de la aplicaci�n.
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
	 * Ruta del archivo con la configuraci�n inicial del karaoke.
	 */
    private final static String RUTA_ARCHIVO = "./data/karaoke.properties";

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
     * Panel con la informaci�n de una canci�n.
     */
    private PanelCancion panelCancion;

    /**
     * Panel con las opciones de b�squeda y extensi�n.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con la informaci�n de las listas de reproducci�n.
     */
    private PanelListaReproduccion panelListaReproduccion;

    /**
     * Panel con la informaci�n del artista.
     */
    private PanelArtista panelArtista;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana de la aplicaci�n. <br>
     * <b>post: </b> Se inicializaron los p�neles con la informaci�n del sistema.
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

        // Creaci�n de los p�neles
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
    // M�todos
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
     * Retorna los artistas de una categor�a.
     * @param pCategoria Categor�a de los artistas. pCategoria != null y pCategoria != "".
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
     * Retorna la categor�a seleccionada en el panel de artista.
     * @return Categor�a seleccionada.
     */
    public String darCategoriaSeleccionada( )
    {
        return panelArtista.darCategoriaSeleccionada( );
    }

    /**
     * Retorna las canciones incluidas en una lista de reproducci�n dado el nombre de la lista de reproducci�n.
     * @param pNombre Nombre de la lista de reproducci�n. pNombre != null y pNombre != "".
     * @return Lista de canciones de la lista de reproducci�n con el nombre dado.
     */
	public ArrayList< Cancion > darCancionesIncluidasListaReproduccion( String pNombre )
    {
        int indiceLista= karaoke.buscarListaReproduccion( pNombre );
        return ((ListaReproduccion)karaoke.darListasDeReproduccion( ).get( indiceLista  )).darCanciones( );
    }

    /**
     * Retorna la lista de canciones del karaoke dada una categor�a.
     * @param pCategoria Categor�a de las canciones. pCategor�a != null && pCategor�a != "".
     * @return Lista de canciones de la categor�a dada.
     */
	public ArrayList< Cancion > darCancionesCategoria( String pCategoria )
    {
        return karaoke.darCancionesCategoria( pCategoria );
    }

    /**
     * Retorna la lista de listas de reproducci�n del karaoke.
     * @return Lista de listas de reproducci�n.
     */
	public ArrayList< ListaReproduccion > darListasReproduccionKaraoke( )
    {
        return karaoke.darListasDeReproduccion( );
    }

    /**
     * Carga la informaci�n inicial del karaoke.
     */
    private void cargarKaraoke( )
    {
        try
        {
            Properties datos = new Properties( );
            FileInputStream in = new FileInputStream( RUTA_ARCHIVO );
            datos.load( in );
            in.close( );

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
            JOptionPane.showMessageDialog( this, "No fue posible cargar la informaci�n inicial del karaoke. " + e.getMessage( ), "Cargar karaoke", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega una nueva canci�n a un artista del karaoke.
     * @param pArtista Nombre del artista int�rprete de la canci�n. pArtista != null y pArtista != "".
     * @param pNombre Nombre de la canci�n. pNombre != null y pNombre != "".
     * @param pDuracion Duraci�n en segundos de la canci�n. pDuracion > 0.
     * @param pLetra Letra de la canci�n. pLetra != null y pLetra != "".
     * @param pDificultad Dificultad de la canci�n. pDificultad >= 1 y pDificultad <= 10.
     * @param pRuta Ruta del archivo con la canci�n. pRuta != null y pRuta != "".
     */
    public void agregarCancion( String pArtista, String pNombre, int pDuracion, String pLetra, int pDificultad, String pRuta )
    {
        boolean agregada = karaoke.agregarCancion( pArtista, pNombre, pDuracion, pLetra, pDificultad, pRuta );
        if( agregada )
        {
            panelArtista.actualizarArtista( );
            JOptionPane.showMessageDialog( this, "Canci�n agregada exitosamente.", "Agregar canci�n", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No fue posible agregar la canci�n: " + pNombre, "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega una lista de reproducci�n al karaoke.<br>
     * <b>pre:</b> La lista de listas de reproducci�n est� inicializada.<br>
     * <b>post:</b> La lista tiene una lista de reproducci�n nueva.
     * @param pNombre Nombre de la lista de reproducci�n. pNombre != null y pNombre != "".
     * @param pCancionInicial Nombre de la primera canci�n de la lista de reproducci�n. pCancionInicial != null y pCancionInicial != "".
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
            JOptionPane.showMessageDialog( this, "Existe una lista de reproducci�n con el mismo nombre.", "Agregar lista de reproducci�n", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Agrega una canci�n a la lista de reproducci�n dada.
     * @param pNombreCancion Nombre de la canci�n. pNombreCancion != null && pNombreCancion != null.
     * @param pNombreListaReproduccion Nombre de la lista de reproducci�n. pNombreListaReproduccion != null && pNombreListaReproduccion != null.
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
            JOptionPane.showMessageDialog( this, "La lista de reproducci�n ya tiene esa canci�n.", "Agregar canci�n a lista de reproducci�n", JOptionPane.ERROR_MESSAGE );

        }

    }

    /**
     * Actualiza la interfaz con la lista de artistas de una categor�a.
     * @param pCategoria Categor�a seleccionada del karaoke. pCategoria != null.
     */
    public void actualizarArtistas( String pCategoria )
    {
		ArrayList< Artista > artistas = karaoke.darArtistasCategoria( pCategoria );
        panelArtista.actualizarArtistas( artistas );
    }

    /**
     * Actualiza la interfaz con la informaci�n de una canci�n.
     * @param pCancion Canci�n que se debe mostrar. pCancion != null.
     */
    public void actualizarCancion( Cancion pCancion )
    {
        panelCancion.actualizar( pCancion );
    }

    /**
     * Muestra el di�logo para modificar canciones de la lista de reproducci�n seleccionada.
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
            JOptionPane.showMessageDialog( this, "Debe seleccionar una lista de reproducci�n de la lista.", "Modificar canciones de lista de reproducci�n", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Elimina la canci�n de la lista de reproducci�n.
     * @param pNombreCancion Nombre de la canci�n. pNombreCancion != null && pNombreAtpNombreCancionraccion != null.
     * @param pNombreListaReproduccion Nombre de la lista de reproducci�n. pNombreListaReproduccion != null && pNombreListaReproduccion != null.
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
            JOptionPane.showMessageDialog( this, "No existe una canci�n con el nombre dado.", "Eliminar canci�n de lista de reproducci�n", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Elimina una lista de reproducci�n del karaoke.<br>
     * <b>pre:</b> La lista de listas de reproducci�n est� inicializada.<br>
     * <b>post:</b> La lista tiene un lista de reproducci�n menos.
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
            String nombreListaReproduccion = ( String )JOptionPane.showInputDialog( this, "Listas de reproducci�n disponibles:", "Listas de reproducci�n", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[ 0 ] );
            if( nombreListaReproduccion != null )
            {
                if( karaoke.buscarListaReproduccion( nombreListaReproduccion ) != -1 )
                {
                    karaoke.eliminarListaReproduccion( nombreListaReproduccion );
                    JOptionPane.showMessageDialog( this, "Se elimin� la lista de reproducci�n correctamente.", "Eliminar lista de reproducci�n", JOptionPane.INFORMATION_MESSAGE );
                    mostrarListasDeReproduccion( );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "No existe una lista de reproducci�n con el nombre dado.", "Eliminar lista de reproducci�n", JOptionPane.ERROR_MESSAGE );

                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay listas de reproducci�n.", "Eliminar lista de reproducci�n", JOptionPane.ERROR_MESSAGE );

        }

    }

    /**
     * Muestra la canci�n con mayor dificultad.
     */
    public void mostrarCancionMasDificil( )
    {
        Cancion cancion = karaoke.darCancionMasDificil( );
        if( cancion != null )
        {
            JOptionPane.showMessageDialog( this, "La canci�n m�s dif�cil es " + cancion.darNombre( ), "M�s dif�cil", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen canciones en el karaoke.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra la canci�n con menor dificultad.
     */
    public void mostrarCancionMasFacil( )
    {
        Cancion cancion = karaoke.darCancionMasFacil( );
        if( cancion != null )
        {
            JOptionPane.showMessageDialog( this, "La canci�n m�s f�cil es " + cancion.darNombre( ), "M�s f�cil", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen canciones en el karaoke.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra la canci�n con mayor duraci�n.
     */
    public void mostrarCancionMasLarga( )
    {
        Cancion cancion = karaoke.darCancionMasLarga( );
        if( cancion != null )
        {
            JOptionPane.showMessageDialog( this, "La canci�n m�s larga es " + cancion.darNombre( ), "M�s larga", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen canciones en el karaoke.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra la canci�n con menor duraci�n.
     */
    public void mostrarCancionMasCorta( )
    {
        Cancion cancion = karaoke.darCancionMasCorta( );
        if( cancion != null )
        {
            JOptionPane.showMessageDialog( this, "La canci�n m�s corta es " + cancion.darNombre( ), "M�s corta", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen canciones en el karaoke.", "Error", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Muestra el artista con mayor n�mero de canciones.
     */
    public void mostrarArtistaMasCanciones( )
    {
        Artista artista = karaoke.darArtistaMasCanciones( );
        if( artista != null )
        {
            JOptionPane.showMessageDialog( this, "El artista con m�s canciones es " + artista.darNombre( ), "Artista con m�s canciones", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen artistas en el karaoke.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra una lista con todas las canciones de una categor�a del karaoke.
     * @param pCategoria Nombre de la categor�a.
     */
    public void mostrarCanciones( String pCategoria )
    {
		ArrayList< Cancion > canciones = karaoke.darCancionesCategoria( pCategoria );
        DialogoCanciones dialogo = new DialogoCanciones( pCategoria, canciones );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el di�logo que permite agregar una lista de reproducci�n.
     */
    public void mostrarDialogoAgregarListaReproduccion( )
    {
        DialogoAgregarListaReproduccion dialogo = new DialogoAgregarListaReproduccion( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el di�logo para agregar o eliminar canciones de una lista de reproducci�n.
     * @param pNombre Nombre del ListaReproduccion. pNombre != null y pNombre != "".
     */
    public void mostrarDialogoCancionesListaReproduccion( String pNombre )
    {
        DialogoCancionesListaReproduccion dialogo = new DialogoCancionesListaReproduccion( this, pNombre );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra todas las listas de reproducci�n del karaoke en PanelListaReproduccion.
     */
    public void mostrarListasDeReproduccion( )
    {
        panelListaReproduccion.repaint( );
        panelListaReproduccion.actualizarListaReproduccion( karaoke.darListasDeReproduccion( ) );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = karaoke.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
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
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz.
     * @param pArgs Argumentos para la ejecuci�n de la aplicaci�n. En este caso no son necesarios.
     */
    public static void main( String[] pArgs )
    {

        InterfazKaraoke interfaz = new InterfazKaraoke( );
        interfaz.setVisible( true );
    }
}