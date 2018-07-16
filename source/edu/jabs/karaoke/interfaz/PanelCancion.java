package edu.jabs.karaoke.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import edu.jabs.karaoke.mundo.Cancion;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 * Panel con la informaci�n de una canci�n.
 */
public class PanelCancion extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Persitencia clase de Java.
	 */
	private static final long serialVersionUID = 101L;

	/**
	 * Representa el comando reproducir.
	 */
    public final static String REPRODUCIR = "Reproducir";

    /**
     * Representa el comando pausar.
     */
    public final static String PAUSAR = "Pausar";

    /**
     * Representar el comando parar.
     */
    public final static String PARAR = "Parar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ruta del archivo con la canci�n.
     */
    private String ruta;

    /**
     * Player de la canci�n.
     */
    private BasicPlayer player;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

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
     * Bot�n para reproducir una canci�n.
     */
    private JButton btnReproducir;

    /**
     * Bot�n para pausar una canci�n.
     */
    private JButton btnPausar;

    /**
     * Bot�n para parar una canci�n.
     */
    private JButton btnParar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel con la informaci�n de una canci�n.
     */
    public PanelCancion( )
    {
        ruta = null;

        setBorder( new CompoundBorder( new TitledBorder( " Canci�n: " ), new EmptyBorder( 0, 0, 0, 5 ) ) );
        setPreferredSize( new Dimension( 250, 0 ) );
        setLayout( new BorderLayout( ) );

        JPanel info = new JPanel( );
        info.setLayout( new BorderLayout( ) );

        JPanel info1 = new JPanel( );
        info1.setLayout( new GridLayout( 3, 1 ) );

        JPanel info2 = new JPanel( );
        info2.setLayout( new GridLayout( 3, 1 ) );

        info1.add( new JLabel( " Nombre: " ) );
        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        info2.add( txtNombre );

        info1.add( new JLabel( " Duraci�n: " ) );
        txtDuracion = new JTextField( );
        txtDuracion.setEditable( false );
        info2.add( txtDuracion );

        info1.add( new JLabel( " Dificultad: " ) );
        txtDificultad = new JTextField( );
        txtDificultad.setEditable( false );
        info2.add( txtDificultad );

        info.add( info1, BorderLayout.WEST );
        info.add( info2, BorderLayout.CENTER );

        add( info, BorderLayout.NORTH );

        JPanel letra = new JPanel( );
        letra.setLayout( new BorderLayout( ) );

        letra.add( new JLabel( " Letra: " ), BorderLayout.NORTH );

        txtLetra = new JTextArea( );
        txtLetra.setEditable( false );
        JScrollPane scrollLetra = new JScrollPane( txtLetra );
        scrollLetra.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scrollLetra.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        letra.add( scrollLetra, BorderLayout.CENTER );

        add( letra, BorderLayout.CENTER );

        JPanel botones = new JPanel( );
        botones.setLayout( new GridLayout( 1, 3 ) );
        botones.setBorder( new EmptyBorder( 2, 60, 0, 60 ) );
        botones.setPreferredSize( new Dimension( 0, 35 ) );

        btnReproducir = new JButton( new ImageIcon( "./data/imagenes/reproducir.gif" ) );
        btnReproducir.setActionCommand( REPRODUCIR );
        btnReproducir.addActionListener( this );
        botones.add( btnReproducir );

        btnPausar = new JButton( new ImageIcon( "./data/imagenes/pausar.gif" ) );
        btnPausar.setActionCommand( PAUSAR );
        btnPausar.addActionListener( this );
        botones.add( btnPausar );

        btnParar = new JButton( new ImageIcon( "./data/imagenes/parar.gif" ) );
        btnParar.setActionCommand( PARAR );
        btnParar.addActionListener( this );
        botones.add( btnParar );

        add( botones, BorderLayout.SOUTH );
        player = new BasicPlayer( );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la informaci�n de la canci�n.
     * @param pCancion Canci�n cuya informaci�n va a ser mostrada. pCancion != null.
     */
    public void actualizar( Cancion pCancion )
    {
        if( pCancion != null )
        {
            txtDificultad.setText( "" + pCancion.darDificultad( ) );
            txtDuracion.setText( pCancion.darDuracion( ) + " seg." );
            txtLetra.setText( pCancion.darLetra( ) );
            txtLetra.setCaretPosition( 0 );
            txtNombre.setText( pCancion.darNombre( ) );
            ruta = pCancion.darRuta( );
        }
        else
        {
            txtDificultad.setText( "" );
            txtDuracion.setText( "" );
            txtLetra.setText( "" );
            txtNombre.setText( "" );
            ruta = null;
        }

        if( player != null )
        {
            try
            {
                player.stop( );
            }
            catch( BasicPlayerException pExcepcion )
            {
                JOptionPane.showMessageDialog( this, "No fue posible parar la canci�n " + pExcepcion.getMessage( ), "Parar canci�n", JOptionPane.ERROR_MESSAGE );
            }

        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( REPRODUCIR ) )
        {
            if( ruta != null )
            {
                try
                {
                    if( player.getStatus( ) != 1 )
                    {
                        File file = new File( ruta );
                        player.open( file );
                        player.play( );
                    }
                    else
                    {
                        player.resume( );
                    }
                }
                catch( Exception pExcepcion )
                {
                    JOptionPane.showMessageDialog( this, "No fue posible reproducir la canci�n " + pExcepcion.getMessage( ), "Reproducir canci�n", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else if( comando.equals( PARAR ) )
        {
            try
            {
                player.stop( );
            }
            catch( BasicPlayerException pExcepcion )
            {
                JOptionPane.showMessageDialog( this, "No fue posible parar la canci�n " + pExcepcion.getMessage( ), "Parar canci�n", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( PAUSAR ) )
        {
            try
            {
                player.pause( );
            }
            catch( BasicPlayerException pExcepcion )
            {
                JOptionPane.showMessageDialog( this, "No fue posible pausar la canci�n " + pExcepcion.getMessage( ), "Pausar canci�n", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}
