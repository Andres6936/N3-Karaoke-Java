package karaoke.interfaz;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Panel con la imagen encabezado.
 */
class PanelImagen extends JPanel
{

    /**
	 * Persistencia clase de Java.
	 */
	private static final long serialVersionUID = 103L;

	/**
     * Mótodo constructor por defecto. Coloca la imagen del encabezado de la
     * aplicación.
	 */
    PanelImagen( )
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

        assert file != null;

        try
        {
            return new ImageIcon( ImageIO.read( file ) );
        }
        catch ( Exception e )
        {
            System.err.println( "Not is possible load the image with path: " + path );
            return new ImageIcon( new byte[ 0 ] );
        }
    }
}
