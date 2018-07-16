package edu.jabs.karaoke.interfaz;

import java.awt.Color;

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
	 * Método constructor por defecto. Coloca la imagen del encabezado de la
	 * aplicación.
	 */
    public PanelImagen( )
    {
        JLabel imagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "data/imagenes/karaoke.png" );
        // La agrega a la etiqueta
        imagen = new JLabel( "" );
        imagen.setIcon( icono );
        add( imagen );

        setBackground( Color.WHITE );
        setBorder( new LineBorder( Color.BLACK ) );
    }

}
