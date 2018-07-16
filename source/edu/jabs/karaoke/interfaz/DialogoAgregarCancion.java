package edu.jabs.karaoke.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Di�logo que permite agregar una nueva canci�n al karaoke.
 */
public class DialogoAgregarCancion extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Persistencia clase de Java.
	 */
	private static final long serialVersionUID = 109L;

	/**
	 * Representa el comando agregar.
	 */
    private static final String AGREGAR = "Agregar";

    /**
     * Representa el comando seleccionar.
     */
    private final static String SELECCIONAR = "...";

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
     * Campo de texto con la categor�a de la canci�n.
     */
    private JTextField txtCategoria;

    /**
     * Campo de texto con el artista de la canci�n.
     */
    private JTextField txtArtistas;

    /**
     * Campo de texto con el nombre de la canci�n.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto con la duraci�n de la canci�n.
     */
    private JTextField txtDuracion;

    /**
     * Campo de texto con la dificultad de la canci�n.
     */
    private JTextField txtDificultad;

    /**
     * �rea de texto con la letra de la canci�n.
     */
    private JTextArea txtLetra;

    /**
     * Campo de texto con la ruta del archivo con la canci�n.
     */
    private JTextField txtRuta;

    /**
     * Bot�n para agregar una nueva canci�n.
     */
    private JButton btnAgregar;

    /**
     * Bot�n para seleccionar la ruta del archivo de la canci�n.
     */
    private JButton btnSeleccionar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del di�logo.
     * @param pVentana Ventana principal.
     */
    public DialogoAgregarCancion( InterfazKaraoke pVentana )
    {
        principal = pVentana;

        setLayout( new BorderLayout( ) );
        setSize( 335, 400 );
        setModal( true );
        setLocationRelativeTo( null );
        setTitle( "Agregar canci�n" );

        JPanel panelInfo1 = new JPanel( );
        panelInfo1.setLayout( new GridLayout( 6, 2 ) );

        panelInfo1.add( new JLabel( " Categor�a: " ) );
        txtCategoria = new JTextField( principal.darCategoriaSeleccionada( ) );
        txtCategoria.setEnabled( false );
        panelInfo1.add( txtCategoria );

        panelInfo1.add( new JLabel( " Artista: " ) );
        txtArtistas = new JTextField( principal.darArtistaSeleccionado( ) );
        txtArtistas.setEnabled( false );
        panelInfo1.add( txtArtistas );

        panelInfo1.add( new JLabel( " Nombre: " ) );
        txtNombre = new JTextField( );
        panelInfo1.add( txtNombre );

        panelInfo1.add( new JLabel( " Duraci�n (seg): " ) );
        txtDuracion = new JTextField( );
        panelInfo1.add( txtDuracion );

        panelInfo1.add( new JLabel( " Dificultad: " ) );
        txtDificultad = new JTextField( );
        panelInfo1.add( txtDificultad );

        JPanel aux = new JPanel( );
        aux.setLayout( new BorderLayout( ) );

        panelInfo1.add( new JLabel( " Archivo: " ) );
        txtRuta = new JTextField( );
        txtRuta.setEditable( false );
        aux.add( txtRuta, BorderLayout.CENTER );
        btnSeleccionar = new JButton( SELECCIONAR );
        btnSeleccionar.setActionCommand( SELECCIONAR );
        btnSeleccionar.addActionListener( this );
        btnSeleccionar.setPreferredSize( new Dimension( 50, 0 ) );
        aux.add( btnSeleccionar, BorderLayout.EAST );

        panelInfo1.add( aux );
        add( panelInfo1, BorderLayout.NORTH );

        JPanel panelInfo2 = new JPanel( );
        panelInfo2.setLayout( new BorderLayout( ) );

        txtLetra = new JTextArea( );
        txtLetra.setLineWrap( true );

        JScrollPane scrollLetra = new JScrollPane( txtLetra );
        scrollLetra.setPreferredSize( new Dimension( 0, 80 ) );
        scrollLetra.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scrollLetra.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scrollLetra.setBorder( new TitledBorder( " Letra: " ) );
        panelInfo2.add( scrollLetra, BorderLayout.CENTER );

        add( panelInfo2, BorderLayout.CENTER );

        btnAgregar = new JButton( AGREGAR );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        add( btnAgregar, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR ) )
        {
            String artista = txtArtistas.getText( );
            String nombre = txtNombre.getText( );
            String dificultadS = txtDificultad.getText( );
            String duracionS = txtDuracion.getText( );
            String ruta = txtRuta.getText( );
            String letra = txtLetra.getText( );

            if( nombre != null && !nombre.isEmpty( ) && dificultadS != null && !dificultadS.isEmpty( ) && duracionS != null && !duracionS.isEmpty( ) && ruta != null && !ruta.isEmpty( ) && letra != null && !letra.isEmpty( ) && artista != null )
            {
                try
                {
                    int dificultad = Integer.parseInt( dificultadS );
                    int duracion = Integer.parseInt( duracionS );

                    if( duracion > 0 )
                    {
                        if( dificultad > 0 && dificultad <= 10 )
                        {
                            principal.agregarCancion( artista, nombre, duracion, letra, dificultad, ruta );
                            this.dispose( );
                        }
                        else
                        {
                            JOptionPane.showMessageDialog( this, "La dificultad debe estar entre 1 y 10.", "Agregar canci�n", JOptionPane.ERROR_MESSAGE );
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "La duraci�n debe ser mayor a cero.", "Agregar canci�n", JOptionPane.ERROR_MESSAGE );
                    }
                }
                catch( NumberFormatException ex )
                {
                    JOptionPane.showMessageDialog( this, "La duraci�n y la dificultad de la canci�n deben ser valores num�ricos.", "Agregar canci�n", JOptionPane.ERROR_MESSAGE );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Por favor ingrese la informaci�n completa de la canci�n.", "Agregar canci�n", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( SELECCIONAR ) )
        {
            JFileChooser fileChooser = new JFileChooser( "./data/canciones" );
            if( fileChooser.showOpenDialog( principal ) == JFileChooser.APPROVE_OPTION )
            {
                txtRuta.setText( fileChooser.getSelectedFile( ).getAbsolutePath( ) );
            }
        }
    }
}