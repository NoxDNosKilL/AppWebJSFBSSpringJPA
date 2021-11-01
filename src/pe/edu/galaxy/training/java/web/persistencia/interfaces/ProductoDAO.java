package pe.edu.galaxy.training.java.web.persistencia.interfaces;


import java.util.List;

import pe.edu.galaxy.training.java.web.entity.Producto;
import pe.edu.galaxy.training.java.web.persistencia.exception.DAOException;

public interface ProductoDAO {

	List<Producto> listar() throws DAOException;
	
	List<Producto> listar(String nombre) throws DAOException;
	
	boolean agregar(Producto producto) throws DAOException;
	
	boolean modificar(Producto producto) throws DAOException;
	
	boolean eliminar(Producto producto) throws DAOException;
	
	
}
