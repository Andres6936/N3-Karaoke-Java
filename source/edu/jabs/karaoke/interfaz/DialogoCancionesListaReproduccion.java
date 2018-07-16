package edu.jabs.karaoke.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.jabs.karaoke.mundo.Cancion;

/**
 * Di�logo para agregar canciones a una lista de reproducci�n.
 *
 */
public class DialogoCancionesListaReproduccion extends JDialog implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Persistencia clase de Java.
	 */
	private static final long serialVersionUID = 106L;

	/**
	 * Representa el comando agregar una canci�n.
	 */
    private static final String AGREGAR = "Agregar";

    /**
     * Representa el comando eliminar una canci�n.
     */
    private static final String ELIMINAR = "Eliminar";

    /**
     * Representa el comando para cerrar el di�logo.
     */
    private static final String SALIR = "Salir";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazKaraoke principal;

    /**
     * Nombre de la lista de reproducci�n.
     */
    private String nombre;

    /**
     * Canciones incluidas en la lista de reproducci�n.
     */
	private Vector< String > cancionesIncluidas;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Lista donde se muestran las canciones existentes en el karaoke.
     */
	private JList< String > listaCanciones;

    /**
     * Bot�n para agregar una canci�n a la lista.
     */
    private JButton btnAgregar;

    /**
     * Bot�n para eliminar una canci�n de la lista.
     */
    private JButton btnEliminar;

    /**
     * Bot�n para cerrar el di�logo.
     */
    private JButton btnSalir;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el di�logo para la visualizaci�n de las canciones a�adidas a una lista de reproducci�n.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     * @param pNombre Nombre de la lista de reproducci�n. pNombre != null && pNombre != "".
     */
    public DialogoCancionesListaReproduccion( InterfazKaraoke pPrincipal, String pNombre )
    {
        principal = pPrincipal;
        nombre = pNombre;
		cancionesIncluidas = new Vector< String >( );

        setTitle( "Canciones seleccionadas" );
        setLayout( new BorderLayout( ) );

		listaCanciones = new JList< String >( );
        JScrollPane scroll = new JScrollPane( );
        scroll.setViewportView( listaCanciones );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scroll.setPreferredSize( new Dimension( 300, 160 ) );
        add( scroll, BorderLayout.CENTER );

        btnAgregar = new JButton( "Agregar" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        btnEliminar = new JButton( "Eliminar" );
        btnEliminar.setActionCommand( ELIMINAR );
        btnEliminar.addActionListener( this );

        btnSalir = new JButton( "Salir" );
        btnSalir.setActionCommand( SALIR );
        btnSalir.addActionListener( this );

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 1, 3 ) );
        panelSur.add( btnAgregar );
        panelSur.add( btnEliminar );
        panelSur.add( btnSalir );
        add( panelSur, BorderLayout.SOUTH );

        for( int i = 0; i < principal.darCancionesIncluidasListaReproduccion( nombre ).size( ); i++ )
        {
            Cancion actual = ( Cancion )principal.darCancionesIncluidasListaReproduccion( nombre ).get( i );
            cancionesIncluidas.add( actual.darNombre( ) );
        }
        listaCanciones.setListData( cancionesIncluidas );

        pack( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR ) )
        {

			ArrayList< Cancion > cancionesKaraoke = principal.darCancionesKaraoke( );
            Object[] possibilities = new Object[cancionesKaraoke.size( )];
            for( int i = 0; i < cancionesKaraoke.size( ); i++ )
            {
                possibilities[ i ] = ( ( Cancion )cancionesKaraoke.get( i ) ).darNombre( );
            }

            String nombreCancion = ( String )JOptionPane.showInputDialog( this, "Canciones disponibles:", "Canciones", JOptionPane.INFORMATION_MESSAGE, null, possibilities, possibilities[ 0 ] );
            if( nombreCancion != null )
            {
                principal.agregarCancionListaReproduccion( nombreCancion, nombre );
				cancionesIncluidas = new Vector< String >( );
                for( int i = 0; i < principal.darCancionesIncluidasListaReproduccion( nombre ).size( ); i++ )
                {
                    Cancion actual = ( Cancion )principal.darCancionesIncluidasListaReproduccion( nombre ).get( i );
                    cancionesIncluidas.add( actual.darNombre( ) );
                }
                listaCanciones.setListData( cancionesIncluidas );
            }

        }
        else if( comando.equals( ELIMINAR ) )
        {
            
            if(listaCanciones.getModel( ).getSize( )>1){
                if( listaCanciones.getSelectedValue( ) != null )
                {
                    String seleccionado = listaCanciones.getSelectedValue( ).toString( );
                    principal.eliminarCancionDeListaReproduccion( seleccionado, nombre );
                    cancionesIncluidas.remove( seleccionado );
                    listaCanciones.setListData( cancionesIncluidas );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Debe seleccionar una canci�n de la lista.", "Eliminar canci�n", JOptionPane.ERROR_MESSAGE );
                } 
            }else{
                JOptionPane.showMessageDialog( this, "La lista de reproducci�n debe tener al menos una canci�n.", "Eliminar canci�n", JOptionPane.ERROR_MESSAGE );
            }
            
        }
        else if( comando.equals( SALIR ) )
        {
            dispose( );
        }

    }
}
