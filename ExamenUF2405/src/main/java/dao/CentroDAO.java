package dao;

import java.util.List;

import modelo.Centro;

public interface CentroDAO {

	List<Centro> getCentros();
	Centro getCentro(int codCentro);
	int insertarCentro(Centro centro);
	int actualizarCentro(Centro centro);
	public int eliminarCentro(int codCentro);
	
}
