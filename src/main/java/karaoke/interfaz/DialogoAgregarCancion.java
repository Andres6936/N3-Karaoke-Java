package karaoke.interfaz;

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
 * Diólogo que permite agregar una nueva canción al karaoke.
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
     * Ventana principal de la aplicación.
     */
    private InterfazKaraoke principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto con la categoróa de la canción.
     */
    private JTextField txtCategoria;

    /**
     * Campo de texto con el artista de la canción.
     */
    private JTextField txtArtistas;

    /**
     * Campo de texto con el nombre de la canción.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto con la duración de la canción.
     */
    private JTextField txtDuracion;

    /**
     * Campo de texto con la dificultad de la canción.
     */
    private JTextField txtDificultad;

    /**
     * órea de texto con la letra de la canción.
     */
    private JTextArea txtLetra;

    /**
     * Campo de texto con la ruta del archivo con la canción.
     */
    private JTextField txtRuta;

    /**
     * Botón para agregar una nueva canción.
     */
    private JButton btnAgregar;

    /**
     * Botón para seleccionar la ruta del archivo de la canción.
     */
    private JButton btnSeleccionar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del diólogo.
     * @param pVentana Ventana principal.
     */
    public DialogoAgregarCancion( InterfazKaraoke pVentana )
    {
        principal = pVentana;

        setLayout( new BorderLayout( ) );
        setSize( 335, 400 );
        setModal( true );
        setLocationRelativeTo( null );
        setTitle( "Agregar canción" );

        JPanel panelInfo1 = new JPanel( );
        panelInfo1.setLayout( new GridLayout( 6, 2 ) );

        panelInfo1.add( new JLabel( " Categoróa: " ) );
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

        panelInfo1.add( new JLabel( " Duración (seg): " ) );
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
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento.
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
                            JOptionPane.showMessageDialog( this, "La dificultad debe estar entre 1 y 10.", "Agregar canción", JOptionPane.ERROR_MESSAGE );
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "La duración debe ser mayor a cero.", "Agregar canción", JOptionPane.ERROR_MESSAGE );
                    }
                }
                catch( NumberFormatException ex )
                {
                    JOptionPane.showMessageDialog( this, "La duración y la dificultad de la canción deben ser valores numóricos.", "Agregar canción", JOptionPane.ERROR_MESSAGE );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Por favor ingrese la información completa de la canción.", "Agregar canción", JOptionPane.ERROR_MESSAGE );
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