package edu.jabs.karaoke.mundo;

public class Cancion {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre de la canci�n.
     */
    private String nombre;
    
    /**
     * Duraci�n de la canci�n.
     */
    private int duracion;
    
    /**
     * Letra de la canci�n.
     */
    private String letra;
    
    /**
     * Dificultad de la canci�n.
     */
    private int dificultad;
    
    /**
     * Ruta de la canci�n.
     */
    private String ruta;
    
    
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Crea una canci�n. <br>
     * <b>post: </b> Se inicializaron los atributos nombre, duraci�n, letra, dificultad y ruta con los valores dados por par�metro. <br>
     * @param pNombre Nombre de la canci�n. pNombre != null y pNombre != "".
     * @param pDuracion Duraci�n de la canci�n. pDuracion > 0 
     * @param pLetra Letra de la canci�n. pLetra != null y pLetra != "".
     * @param pDificultad Dificultad de la canci�n. pDificultad > 0 
     * @param pRuta Ruta de la canci�n. pRuta != null y pRuta != "".
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
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la canci�n.
     * @return Nombre de la canci�n.
     */
    public String darNombre( )
    {
        return nombre;
    }
    
    /**
     * Retorna la duraci�n de la canci�n.
     * @return Duraci�n de la canci�n.
     */
    public int darDuracion( )
    {
        return duracion;
    }
    
    /**
     * Retorna la letra de la canci�n.
     * @return Letra de la canci�n.
     */
    public String darLetra( )
    {
        return letra;
    }
    
    /**
     * Retorna la dificultar de la canci�n.
     * @return Dificultad de la duraci�n.
     */
    public int darDificultad( )
    {
        return dificultad;
    }
    
    /**
     * Retorna la ruta de la canci�n.
     * @return Ruta de la canci�n.
     */
    public String darRuta( )
    {
        return ruta;
    }
	
    /**
     * Retorna una cadena de caracteres con la informaci�n de la canci�n.
     * @return Cadena de caracteres con la informaci�n de la canci�n: nombre.
     */
    public String toString()
    {
    	return nombre;
    }
}
