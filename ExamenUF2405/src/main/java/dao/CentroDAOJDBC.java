package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Centro;
import utilidades.ConexionBD;

public class CentroDAOJDBC implements CentroDAO {

	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	
	
	public CentroDAOJDBC() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Centro> getCentros() {
		List<Centro> listaCentros = new ArrayList<Centro>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from centros");
			while (resultado.next()) {
				int codCentro = resultado.getInt("cod_centro");
				String nombre = resultado.getString("nombre");
				String direccion = resultado.getString("direccion");
				
				Centro emp = new Centro(codCentro, nombre, direccion);
				

				listaCentros.add(emp);
			}
			System.out.println("Añadidos todos los centros: ");
			System.out.println(listaCentros);
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre centros: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}

		
		return listaCentros;
	}

	@Override
	public Centro getCentro(int codCentro) {
		Connection con = conexion.getConexion();
		Centro centro = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from centros"
					+ " where cod_centro = ?");
			consultaPreparada.setInt(1, codCentro);
			resultado=consultaPreparada.executeQuery();
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				
				String nombre = resultado.getString("nombre");
				String direccion = resultado.getString("direccion");
				
				centro = new Centro(codCentro, nombre, direccion);
				
				
				System.out.println("Centro encontrado: "+centro );
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre un Centro: "
		         +e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return centro;
	}

	@Override
	public int insertarCentro(Centro centro) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("INSERT INTO Centros "
					+ "VALUES (?,?,?)");
			
			consultaPreparada.setInt(1, centro.getCodCentro());
			consultaPreparada.setString(2, centro.getNombre());
			consultaPreparada.setString(3, centro.getDireccion());
			
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Centro insertado: ");
			System.out.println(centro);

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción del centro: " + centro+ "_"+consultaPreparada
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
	}

	@Override
	public int actualizarCentro(Centro centro) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("UPDATE Centros\r\n"
					+ "SET nombre=?,\r\n"
					+ "    direccion=? \r\n"
					+ "WHERE cod_centro=?");
			

			consultaPreparada.setString(1, centro.getNombre());
			consultaPreparada.setString(2, centro.getDireccion());
			consultaPreparada.setInt(3, centro.getCodCentro());
			resultado=consultaPreparada.executeUpdate();
			
			System.out.println("Centro actualizado: ");
			System.out.println(centro);

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion del Centro: "
					+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
	}

	@Override
	public int eliminarCentro(int codCentro) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM Centros\r\n"
					+ "WHERE cod_Centro = ?");
			
			consultaPreparada.setInt(1, codCentro);
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Centro borrado correctamente: "+codCentro+ "_"+consultaPreparada);

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de centro: "+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
	}
		

}
