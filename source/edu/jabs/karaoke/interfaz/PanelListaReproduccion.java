package edu.jabs.karaoke.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import edu.jabs.karaoke.mundo.ListaReproduccion;

/**
 * Panel con la información de las listas de reproducción.
 *
 */
public class PanelListaReproduccion extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Persistencia clase de Java.
	 */
	private static final long serialVersionUID = 104L;

	/**
	 * Representa el comando agregar.
	 */
    private final static String AGREGAR = "Agregar nueva lista";

    /**
     * Representa el comando eliminar.
     */
    private final static String ELIMINAR = "Eliminar lista";

    /**
     * Representa el comando modificar canciones.
     */
    private final static String CANCIONES = "Modificar canciones";

    /**
     * Constante con los nombres de las columnas de la tabla.
     */
    public static final String[] NOMBRE_COLUMNAS = { "Nombre", "No. Canciones" };

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazKaraoke principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Tabla para mostrar la información de las listas de reproducción.
     */
    private JTable tablaListasReproduccion;

    /**
     * Modelo para visualizar la información en la tabla de las listas de reproducción.
     */
    private DefaultTableModel model;

    /**
     * Botón para agregar una lista de reproducción.
     */
    private JButton btnAgregar;

    /**
     * Botón para eliminar una lista de reproducción.
     */
    private JButton btnEliminar;

    /**
     * Botón para modificar las canciones de una lista de reproducción.
     */
    private JButton btnModificarCanciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel para la visualización de las listas de reproducción.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelListaReproduccion( InterfazKaraoke pPrincipal )
    {
        principal = pPrincipal;

        TitledBorder borde = new TitledBorder( "Listas de reproducción" );
        setBorder( borde );
        setLayout( new BorderLayout( ) );

        model = new DefaultTableModel( NOMBRE_COLUMNAS, 0 );
        tablaListasReproduccion = new JTable( model );
        tablaListasReproduccion.setColumnSelectionAllowed( false );
        tablaListasReproduccion.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tablaListasReproduccion.setFont( new Font( "Arial", Font.BOLD, 12 ) );

        tablaListasReproduccion.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
        tablaListasReproduccion.getTableHeader( ).setReorderingAllowed( false );

        JScrollPane scroll = new JScrollPane( );

        scroll.setViewportView( tablaListasReproduccion );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scroll.setPreferredSize( new Dimension( 700, 100 ) );
        add( scroll, BorderLayout.WEST );

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 1, 2 ) );

        JPanel panelOpcionesListaReproduccion = new JPanel( );
        panelOpcionesListaReproduccion.setLayout( new GridLayout( 3, 1 ) );
        panelOpcionesListaReproduccion.setBorder( new TitledBorder( "Opciones lista de reproducción" ) );

        btnAgregar = new JButton( "Agregar nueva lista" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );
        panelOpcionesListaReproduccion.add( btnAgregar );

        btnEliminar = new JButton( "Eliminar lista" );
        btnEliminar.setActionCommand( ELIMINAR );
        btnEliminar.addActionListener( this );
        panelOpcionesListaReproduccion.add( btnEliminar );

        btnModificarCanciones = new JButton( "Modificar lista" );
        btnModificarCanciones.setActionCommand( CANCIONES );
        btnModificarCanciones.addActionListener( this );
        panelOpcionesListaReproduccion.add( btnModificarCanciones );

        panelSur.add( panelOpcionesListaReproduccion );

        add( panelSur, BorderLayout.CENTER );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la lista de reproducción seleccionada en la tabla.
     * @return Nombre de la lista de reproducción seleccionada en la tabla.
     */
    public String darNombreListaReproduccionSeleccionada( )
    {
        String rta = "";

        try
        {
            String numPedido = ( String )model.getValueAt( tablaListasReproduccion.getSelectedRow( ), 0 );
            if( numPedido != null )
            {
                rta = numPedido;
            }
        }
        catch( ArrayIndexOutOfBoundsException e )
        {
            rta = "";
        }

        return rta;
    }

    /**
     * Actualiza la información de la tabla para mostrar las listas de reproducción que recibe por parámetro.
     * @param pListasReproduccion Lista de listas de reproducción que se deben mostrar en la tabla. pListasReproduccion != null.
     */
	public void actualizarListaReproduccion( ArrayList< ListaReproduccion > pListasReproduccion )
    {
        model = new DefaultTableModel( NOMBRE_COLUMNAS, 0 );
        tablaListasReproduccion.setModel( model );
        String[] columna;

        for( int i = 0; i < pListasReproduccion.size( ); i++ )
        {
            columna = new String[2];
            ListaReproduccion listaReproduccionActual = ( ListaReproduccion )pListasReproduccion.get( i );
            columna[ 0 ] = listaReproduccionActual.darNombre( );
            columna[ 1 ] = listaReproduccionActual.darCanciones( ).size( ) + "";
            model.addRow( columna );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento que se realizó. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( AGREGAR ) )
        {
            principal.mostrarDialogoAgregarListaReproduccion( );
        }
        else if( comando.equals( ELIMINAR ) )
        {
            principal.eliminarListaReproduccion( );
        }

        else if( comando.equals( CANCIONES ) )
        {
            principal.modificarCancionesListaReproduccion( );
        }
    }
}
