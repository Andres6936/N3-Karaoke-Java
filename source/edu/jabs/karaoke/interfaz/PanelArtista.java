package edu.jabs.karaoke.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import edu.jabs.karaoke.mundo.Artista;
import edu.jabs.karaoke.mundo.Cancion;

/**
 * Panel con la información de un artista.
 *
 */
public class PanelArtista extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Persistencia clase de Java.
	 */
	private static final long serialVersionUID = 100L;

	/**
	 * Representa la comando de cambio de categoría.
	 */
    private final static String CAMBIO_CATEGORIA = "Cambio categoría";

    /**
     * Representa el comando para cambiar de artista.
     */
    private final static String CAMBIO_ARTISTA = "Cambio artista";

    /**
     * Representa el comando para cambiar de canción.
     */
    private final static String CAMBIO_CANCION = "Cambio canción";

    /**
     * Representa el comando agregar canción.
     */
    private static final String AGREGAR_CANCION = "Agregar canción";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazKaraoke principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto con el nombre del artista.
     */
    private JTextField txtNombre;

    /**
     * Etiqueta con la imagen del artista.
     */
    private JLabel lblImagen;

    /**
     * Etiqueta de la categoría.
     */
    private JLabel lblCategoria;

    /**
     * Etiqueta del artista.
     */
    private JLabel lblArtistas;

    /**
     * Botón para agregar una canción.
     */
    private JButton btnAgregarCancion;

    /**
     * Combo box con las categorías del karaoke.
     */
	private JComboBox< String > cbCategoria;

    /**
     * Combo box con las canciones de un artista.
     */
	private JComboBox< Cancion > cbCanciones;

    /**
     * Combo box con los artistas de una categoría.
     */
	private JComboBox< Artista > cbArtistas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel con la información del artista.
     * @param pVentana Ventana principal de la aplicación. pVentana != null.
     */
    public PanelArtista( InterfazKaraoke pVentana )
    {
        principal = pVentana;

        setBorder( new CompoundBorder( new TitledBorder( " Artistas: " ), new EmptyBorder( 0, 5, 0, 10 ) ) );
        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 400, 0 ) );

        JPanel informacion = new JPanel( );
        informacion.setLayout( new GridLayout( 1, 4 ) );

        lblCategoria = new JLabel( "Categorías:" );
        lblArtistas = new JLabel( "Artistas" );

        String[] categorias = { Artista.ROCK, Artista.POP, Artista.FUSION_LATINA, Artista.ELECTRO_HOUSE, Artista.DUBSTEP };
		cbCategoria = new JComboBox< String >( categorias );
        cbCategoria.setActionCommand( CAMBIO_CATEGORIA );
        cbCategoria.addActionListener( this );

		cbArtistas = new JComboBox< Artista >( );
        cbArtistas.setActionCommand( CAMBIO_ARTISTA );
        cbArtistas.addActionListener( this );

        informacion.add( lblCategoria );
        informacion.add( cbCategoria );
        informacion.add( lblArtistas );
        informacion.add( cbArtistas );

        JPanel artista = new JPanel( );

        artista.setBorder( new TitledBorder( "" ) );
        artista.setBorder( new EmptyBorder( 10, 5, 10, 10 ) );
        artista.setLayout( new BorderLayout( ) );

        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        txtNombre.setFont( new Font( "Arial", Font.BOLD, 16 ) );
        txtNombre.setForeground( Color.DARK_GRAY );
        txtNombre.setHorizontalAlignment( JTextField.CENTER );
        artista.add( txtNombre, BorderLayout.NORTH );

        lblImagen = new JLabel( );
        lblImagen.setPreferredSize( new Dimension( 0, 100 ) );
        lblImagen.setHorizontalAlignment( JLabel.CENTER );
        artista.add( lblImagen, BorderLayout.CENTER );

        btnAgregarCancion = new JButton( AGREGAR_CANCION );
        btnAgregarCancion.setActionCommand( AGREGAR_CANCION );
        btnAgregarCancion.addActionListener( this );

		cbCanciones = new JComboBox< Cancion >( );
        cbCanciones.setActionCommand( CAMBIO_CANCION );
        cbCanciones.addActionListener( this );

        JPanel canciones = new JPanel( );
        canciones.setLayout( new GridLayout( 1, 2 ) );
        canciones.add( cbCanciones );
        canciones.add( btnAgregarCancion );

        artista.add( canciones, BorderLayout.SOUTH );
        add( informacion, BorderLayout.NORTH );
        add( artista, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Actualiza el combo box de artistas.
     * @param pArtistas Lista de artistas. pArtistas != null.
     */
	public void actualizarArtistas( ArrayList< Artista > pArtistas )
    {
        cbArtistas.removeAllItems( );
        for( int i = 0; i < pArtistas.size( ); i++ )
        {
            Artista a = ( Artista )pArtistas.get( i );
            cbArtistas.addItem( a );
        }
    }

    /**
     * Actualiza la información del artista seleccionado.
     */
    public void actualizarArtista( )
    {
        Artista a = ( Artista )cbArtistas.getSelectedItem( );
        cbCanciones.removeAllItems( );

        if( a != null )
        {
            txtNombre.setText( a.darNombre( ) );
            lblImagen.setIcon( new ImageIcon( a.darImagen( ) ) );

			ArrayList< Cancion > canciones = principal.darCancionesArtista( a.darNombre( ) );
            for( int i = 0; i < canciones.size( ); i++ )
            {
                Cancion c = ( Cancion )canciones.get( i );
                cbCanciones.addItem( c );
            }
        }
        else
        {
            txtNombre.setText( "" );
            lblImagen.setIcon( null );
        }
    }

    /**
     * Retorna la categoría seleccionada.
     * @return Categoría seleccionada.
     */
    public String darCategoriaSeleccionada( )
    {
        String categoria = ( String )cbCategoria.getSelectedItem( );
        return categoria;
    }

    /**
     * Retorna el artista seleccionado.
     * @return Artista seleccionado.
     */
    public String darArtistaSeleccionado( )
    {
        String artista = ( ( Artista )cbArtistas.getSelectedItem( ) ).darNombre( );
        return artista;
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    @Override
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( CAMBIO_CATEGORIA ) )
        {
            String categoria = ( String )cbCategoria.getSelectedItem( );
            principal.actualizarArtistas( categoria );
        }
        else if( comando.equals( CAMBIO_ARTISTA ) )
        {
            actualizarArtista( );
        }
        else if( comando.equals( CAMBIO_CANCION ) )
        {
            Cancion c = ( Cancion )cbCanciones.getSelectedItem( );
            principal.actualizarCancion( c );
        }
        else if( comando.equals( AGREGAR_CANCION ) )
        {
            DialogoAgregarCancion dialogo = new DialogoAgregarCancion( principal );
            dialogo.setVisible( true );
        }
    }

}
