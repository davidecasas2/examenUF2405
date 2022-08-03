/**
 * 
 */
package modelo;

/**
 * @author David
 *
 */
import java.util.Objects;

/** 
 * Clase que modela un objeto de tipo Centro para trabajar con las tablas de la 
 * base de datos
 * @author David
 *
 */
public class Centro {

	private int codCentro;
	private String nombre;
	private String direccion;
	
	
	/**
	 * Constructor sin par�metros. S�lo incializa las variables de tipo String
	 * a la cadena vac�a
	 */
	public Centro() {
		this.nombre="";
		this.direccion="";
	}
	
	/**
	 * Constructor parametrizado para crear un objeto de la clase
	 * @param cod_centro int con el codigo del centro 
	 * @param nombre String el nombre del centro de trabajo
	 * @param direccion String el domicilio donde se encuentra el centro
	 */
	public Centro(int codCentro, String nombre, String direccion) {
		this.codCentro = codCentro;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	/**
	 * M�todo que obtiene el el c�digo del centro
	 * @return int con el c�digo del centro
	 */
	public int getCodCentro() {
		return codCentro;
	}

	/**
	 * M�todo que establece el valor para el c�digo del centro
	 * @param cod_centro int con el c�digo del centro
	 */
	public void setCodCentro(int codCentro) {
		this.codCentro = codCentro;
	}

	/**
	 * M�todo para obtener el String que almacena el nombre del centro
	 * @return String con el nombre del centro
	 */
	public String getNombre() {
		return nombre;
	}

	/** 
	 * M�todo que establece el nombre del centro
	 * @param nombre String con el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** 
	 * M�todo que devuelve la direcci�n del centro
	 * @return String con la direcci�n del centro
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * M�todo que devuelve la direcci�n del centro 
	 * @param String direccion La direcci�n del centro a devolver
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCentro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centro other = (Centro) obj;
		return codCentro == other.codCentro;
	}

	@Override
	public String toString() {
		return codCentro+" - "+nombre;
	}
	
	
}
