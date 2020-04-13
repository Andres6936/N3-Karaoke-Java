package karaoke.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import karaoke.mundo.Artista;

/**
 * Panel con operaciones de bósqueda y extensión.
 */
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Persistencia clase de Java.
	 */
	private static final long serialVersionUID = 105L;

	/**
	 * Representa el comando buscar.
	 */
    private static final String BUSCAR = "Buscar";

    /**
     * Representa el comando todas las canciones.
     */
    private static final String TODAS = "Lista de canciones";

    /**
     * Representa el comando buscar canción mós fócil.
     */
    private static final String MAS_FACIL = "Canción mós fócil";

    /**
     * Representa el comando buscar canción mós difócil.
     */
    private static final String MAS_DIFICIL = "Canción mós difócil";

    /**
     * Representa el comando buscar canción mós larga.
     */
    private static final String MAS_LARGA = "Canción mós larga";

    /**
     * Representa el comando buscar canción mós corta.
     */
    private static final String MAS_CORTA = "Canción mós corta";

    /**
     * Representa el comando buscar artista con mós canciones.
     */
    private static final String MAS_CANCIONES = "Artista con mós canciones";

    /**
     * Representa el comando opción 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Representa el comando opción 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazKaraoke principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pVentana Ventana principal. pVentana != null.
     */
    PanelOpciones( InterfazKaraoke pVentana )
    {
        principal = pVentana;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 4 ) );

        // Botón opción buscar

        // Botón para realizar bósquedas.
        JButton btnBuscar = new JButton( BUSCAR );
        btnBuscar.setActionCommand( BUSCAR );
        btnBuscar.addActionListener( this );
        add( btnBuscar );

        // Botón opción todas

        // Botón para mostrar todas las canciones del karaoke.
        JButton btnTodas = new JButton( TODAS );
        btnTodas.setActionCommand( TODAS );
        btnTodas.addActionListener( this );
        add( btnTodas );

        // Botón opción 1

        // Botón para la opción 1.
        JButton btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        // Botón opción 2

        // Botón para la opción 2.
        JButton btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( BUSCAR ) )
        {
            String[] opciones = new String[]{ MAS_FACIL, MAS_DIFICIL, MAS_CORTA, MAS_LARGA, MAS_CANCIONES };
            String busqueda = ( String )JOptionPane.showInputDialog( null, "Buscar: ", BUSCAR, JOptionPane.QUESTION_MESSAGE, null, opciones, MAS_FACIL );

            if( busqueda != null )
            {
                switch ( busqueda )
                {
                    case MAS_FACIL:
                        principal.mostrarCancionMasFacil( );
                        break;
                    case MAS_DIFICIL:
                        principal.mostrarCancionMasDificil( );
                        break;
                    case MAS_CORTA:
                        principal.mostrarCancionMasCorta( );
                        break;
                    case MAS_LARGA:
                        principal.mostrarCancionMasLarga( );
                        break;
                    default:
                        principal.mostrarArtistaMasCanciones( );
                        break;
                }
            }
        }
        else if( comando.equals( TODAS ) )
        {
            String[] categorias = { Artista.ROCK, Artista.POP, Artista.FUSION_LATINA, Artista.ELECTRO_HOUSE };
            String c = ( String ) JOptionPane.showInputDialog( null, "Categoróa: ", TODAS, JOptionPane.QUESTION_MESSAGE, null, categorias, Artista.ROCK );
            if( c != null )
            {
                principal.mostrarCanciones( c );
            }
        }
        else if( OPCION_1.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion2( );
        }
    }

}
