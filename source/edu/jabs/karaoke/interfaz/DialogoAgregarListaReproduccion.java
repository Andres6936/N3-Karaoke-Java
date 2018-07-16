package edu.jabs.karaoke.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.jabs.karaoke.mundo.Cancion;

/**
 * Di�logo para agregar una lista de reproducci�n.
 *
 */
public class DialogoAgregarListaReproduccion extends JDialog implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Persistencia clase de Java.
	 */
	private static final long serialVersionUID = 108L;

	/**
	 * Representa el comando que acepta la creaci�n de una lista de reproducci�n.
	 */
    private static final String ACEPTAR = "Aceptar";

    /**
     * Representa el comando que cancela la creaci�n de una lista de reproducci�n.
     */
    private static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazKaraoke principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta del nombre.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta de la canci�n.
     */
    private JLabel lblCancion;

    /**
     * Campo de texto para el nombre.
     */
    private JTextField txtNombre;

    /**
     * Lista desplegable para las canciones.
     */
	private JComboBox< String > cbCanciones;

    /**
     * Bot�n para aceptar la creaci�n de una lista de reproducci�n.
     */
    private JButton btnAceptar;

    /**
     * Bot�n para cancelar la creaci�n de una lista de reproducci�n.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea el di�logo para agregar una lista de reproducci�n.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public DialogoAgregarListaReproduccion( InterfazKaraoke pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setTitle( "Agregar lista de reproducci�n" );

        JPanel panelNorte = new JPanel( );
        panelNorte.setPreferredSize( new Dimension( 10, 10 ) );
        add( panelNorte, BorderLayout.NORTH );

        JPanel panelSur = new JPanel( );
        panelSur.setPreferredSize( new Dimension( 10, 10 ) );
        add( panelSur, BorderLayout.SOUTH );

        JPanel panelEste = new JPanel( );
        panelEste.setPreferredSize( new Dimension( 20, 20 ) );
        add( panelEste, BorderLayout.EAST );

        JPanel panelOeste = new JPanel( );
        panelOeste.setPreferredSize( new Dimension( 20, 20 ) );
        add( panelOeste, BorderLayout.WEST );

        JPanel panelCentral = new JPanel( );
        panelCentral.setLayout( new BorderLayout( ) );
        panelCentral.setPreferredSize( new Dimension( 250, 120 ) );

        JPanel panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 3, 2 ) );

        lblNombre = new JLabel( "Nombre:" );
        lblCancion = new JLabel( "Primera canci�n:" );
        txtNombre = new JTextField( );
		cbCanciones = new JComboBox< String >( );

		ArrayList< Cancion > cancionesKaraoke = principal.darCancionesKaraoke( );
        for( int i = 0; i < cancionesKaraoke.size( ); i++ )
        {
            String c = ( ( Cancion )cancionesKaraoke.get( i ) ).darNombre( );
            cbCanciones.addItem( c );

        }

        panelDatos.add( lblNombre );
        panelDatos.add( txtNombre );
        panelDatos.add( lblCancion );
        panelDatos.add( cbCanciones );
        panelCentral.add( panelDatos, BorderLayout.CENTER );

        JPanel panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 1, 2 ) );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelBotones.add( btnAceptar );
        panelBotones.add( btnCancelar );
        panelCentral.add( panelBotones, BorderLayout.SOUTH );

        add( panelCentral, BorderLayout.CENTER );
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
        if( comando.equals( ACEPTAR ) )
        {
            String nombre = txtNombre.getText( );
            if( nombre.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "El nombre no puede estar vac�o.", "Agregar lista de reproducci�n", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                String nombreCancion = ( String )cbCanciones.getSelectedItem( );
                principal.agregarListaReproduccion( nombre, nombreCancion );
                dispose( );

            }

        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }
}
