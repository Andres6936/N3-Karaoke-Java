package karaoke.interfaz;

import java.awt.Color;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Panel con la imagen encabezado.
 */
public class PanelImagen extends JPanel
{

    /**
	 * Persistencia clase de Java.
	 */
	private static final long serialVersionUID = 103L;

	/**
     * Mótodo constructor por defecto. Coloca la imagen del encabezado de la
     * aplicación.
	 */
    public PanelImagen( )
    {
        // La agrega a la etiqueta
        JLabel imagen = new JLabel( "" );
        imagen.setIcon( load( "imagenes/karaoke.png" ) );
        add( imagen );

        setBackground( Color.WHITE );
        setBorder( new LineBorder( Color.BLACK ) );
    }

    private ImageIcon load( final String path )
    {
        InputStream file = getClass( ).getClassLoader( ).getResourceAsStream( path );
        return new ImageIcon( String.valueOf( file ) );
    }
}
