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
        LoaderResource loader = new LoaderResource( );

        // La agrega a la etiqueta
        JLabel imagen = new JLabel( "" );
        imagen.setIcon( loader.load( "imagenes/karaoke.png" ) );
        add( imagen );

        setBackground( Color.WHITE );
        setBorder( new LineBorder( Color.BLACK ) );
    }
}
