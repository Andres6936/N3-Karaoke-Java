package karaoke.mundo;

public class Cancion {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre de la canción.
     */
    private String nombre;
    
    /**
     * Duración de la canción.
     */
    private int duracion;
    
    /**
     * Letra de la canción.
     */
    private String letra;
    
    /**
     * Dificultad de la canción.
     */
    private int dificultad;
    
    /**
     * Ruta de la canción.
     */
    private String ruta;
    
    
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Crea una canción. <br>
     * <b>post: </b> Se inicializaron los atributos nombre, duración, letra, dificultad y ruta con los valores dados por parómetro. <br>
     * @param pNombre Nombre de la canción. pNombre != null y pNombre != "".
     * @param pDuracion Duración de la canción. pDuracion > 0
     * @param pLetra Letra de la canción. pLetra != null y pLetra != "".
     * @param pDificultad Dificultad de la canción. pDificultad > 0
     * @param pRuta Ruta de la canción. pRuta != null y pRuta != "".
     */
    public Cancion (String pNombre, int pDuracion, String pLetra, int pDificultad, String pRuta)
    {
    	nombre = pNombre;
    	duracion = pDuracion;
    	letra = pLetra;
    	dificultad = pDificultad;
    	ruta = pRuta;
    }
    
    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la canción.
     * @return Nombre de la canción.
     */
    public String darNombre( )
    {
        return nombre;
    }
    
    /**
     * Retorna la duración de la canción.
     * @return Duración de la canción.
     */
    public int darDuracion( )
    {
        return duracion;
    }
    
    /**
     * Retorna la letra de la canción.
     * @return Letra de la canción.
     */
    public String darLetra( )
    {
        return letra;
    }
    
    /**
     * Retorna la dificultar de la canción.
     * @return Dificultad de la duración.
     */
    public int darDificultad( )
    {
        return dificultad;
    }
    
    /**
     * Retorna la ruta de la canción.
     * @return Ruta de la canción.
     */
    public String darRuta( )
    {
        return ruta;
    }
	
    /**
     * Retorna una cadena de caracteres con la información de la canción.
     * @return Cadena de caracteres con la información de la canción: nombre.
     */
    public String toString()
    {
    	return nombre;
    }
}
