package edu.jabs.karaoke.interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Diálogo con la lista de canciones de una categoría del karaoke.
 */
public class DialogoCanciones extends JDialog
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
	 * Persistencia clase de Java.
	 */
	private static final long serialVersionUID = 107L;

	/**
	 * Constructor del diálogo con la lista de canciones.
	 * 
	 * @param pCategoria Nombre de la categoría.
	 * @param pCanciones Lista de canciones. pCanciones != null
	 */
	public DialogoCanciones( String pCategoria, ArrayList pCanciones )
    {
        setLayout( new BorderLayout( ) );
        setSize( 200, 200 );
        setTitle( " Canciones - " + pCategoria );
        setModal( true );
        setLocationRelativeTo( null );

        JScrollPane scrollDesplazamiento = new JScrollPane( );
		JList lista = new JList( );
        lista.setEnabled( false );
        lista.setListData( pCanciones.toArray( ) );

        scrollDesplazamiento.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scrollDesplazamiento.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scrollDesplazamiento.setViewportView( lista );
        add( scrollDesplazamiento, BorderLayout.CENTER );
    }
}