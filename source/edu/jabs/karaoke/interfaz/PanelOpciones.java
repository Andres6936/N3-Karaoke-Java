package edu.jabs.karaoke.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import edu.jabs.karaoke.mundo.Artista;

/**
 * Panel con operaciones de b�squeda y extensi�n.
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
     * Representa el comando buscar canci�n m�s f�cil.
     */
    private static final String MAS_FACIL = "Canci�n m�s f�cil";

    /**
     * Representa el comando buscar canci�n m�s dif�cil.
     */
    private static final String MAS_DIFICIL = "Canci�n m�s dif�cil";

    /**
     * Representa el comando buscar canci�n m�s larga.
     */
    private static final String MAS_LARGA = "Canci�n m�s larga";

    /**
     * Representa el comando buscar canci�n m�s corta.
     */
    private static final String MAS_CORTA = "Canci�n m�s corta";

    /**
     * Representa el comando buscar artista con m�s canciones.
     */
    private static final String MAS_CANCIONES = "Artista con m�s canciones";

    /**
     * Representa el comando opci�n 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Representa el comando opci�n 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazKaraoke principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para realizar b�squedas.
     */
    private JButton btnBuscar;

    /**
     * Bot�n para mostrar todas las canciones del karaoke.
     */
    private JButton btnTodas;

    /**
     * Bot�n para la opci�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n para la opci�n 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pVentana Ventana principal. pVentana != null.
     */
    public PanelOpciones( InterfazKaraoke pVentana )
    {
        principal = pVentana;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 4 ) );

        // Bot�n opci�n buscar
        btnBuscar = new JButton( BUSCAR );
        btnBuscar.setActionCommand( BUSCAR );
        btnBuscar.addActionListener( this );
        add( btnBuscar );

        // Bot�n opci�n todas
        btnTodas = new JButton( TODAS );
        btnTodas.setActionCommand( TODAS );
        btnTodas.addActionListener( this );
        add( btnTodas );

        // Bot�n opci�n 1
        btnOpcion1 = new JButton( "Opci�n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        // Bot�n opci�n 2
        btnOpcion2 = new JButton( "Opci�n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
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

        if( comando.equals( BUSCAR ) )
        {
            String[] opciones = new String[]{ MAS_FACIL, MAS_DIFICIL, MAS_CORTA, MAS_LARGA, MAS_CANCIONES };
            String busqueda = ( String )JOptionPane.showInputDialog( null, "Buscar: ", BUSCAR, JOptionPane.QUESTION_MESSAGE, null, opciones, MAS_FACIL );

            if( busqueda != null )
            {
                if( busqueda.equals( MAS_FACIL ) )
                {
                    principal.mostrarCancionMasFacil( );
                }
                else if( busqueda.equals( MAS_DIFICIL ) )
                {
                    principal.mostrarCancionMasDificil( );
                }
                else if( busqueda.equals( MAS_CORTA ) )
                {
                    principal.mostrarCancionMasCorta( );
                }
                else if( busqueda.equals( MAS_LARGA ) )
                {
                    principal.mostrarCancionMasLarga( );
                }
                else
                {
                    principal.mostrarArtistaMasCanciones( );
                }
            }
        }
        else if( comando.equals( TODAS ) )
        {
            String[] categorias = { Artista.ROCK, Artista.POP, Artista.FUSION_LATINA, Artista.ELECTRO_HOUSE };
            String c = ( String )JOptionPane.showInputDialog( null, "Categor�a: ", TODAS, JOptionPane.QUESTION_MESSAGE, null, categorias, Artista.ROCK );
            if( c != null )
            {
                String categoria = c;
                principal.mostrarCanciones( categoria );
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
