package karaoke.interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;

final class LoaderResource
{

    /**
     * For project with the format of struct of Gradle [or Maven],
     * the load of resources is realized from the carpet {resources},
     * generally the load of resources is realized of this form,
     * for avoid the code duplicate through of project is better dispose
     * of a class that do the work of load resources from there [carpet resources].
     *
     * @param path Path of resource to load. Path != null
     * @return ImageIcon that represent the resource loaded.
     */
    ImageIcon load( final String path )
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
