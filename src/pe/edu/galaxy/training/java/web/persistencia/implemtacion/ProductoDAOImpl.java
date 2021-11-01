package pe.edu.galaxy.training.java.web.persistencia.implemtacion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.galaxy.training.java.web.entity.Producto;
import pe.edu.galaxy.training.java.web.persistencia.exception.DAOException;
import pe.edu.galaxy.training.java.web.persistencia.interfaces.ProductoDAO;

@Repository
@Transactional
public class ProductoDAOImpl implements ProductoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Producto> listar() throws DAOException {
		/*
		 * List<Producto> productos= new ArrayList<>(); try { StoredProcedureQuery spq =
		 * em.createNamedStoredProcedureQuery("producto.listar");
		 * 
		 * spq.setParameter("P_NOMBRE", "");
		 * 
		 * if(spq.execute()) {
		 * 
		 * Object ret= spq.getOutputParameterValue("P_CURSOR");
		 * 
		 * if (ret!=null) { productos=(List<Producto>)ret; } }
		 * 
		 * } catch (Exception e) { System.err.println("Error de consulta " +
		 * e.getMessage()); throw new DAOException(e); }
		 */

		return this.listar("");
	}

	@Override
	public List<Producto> listar(String nombre) throws DAOException {

		List<Producto> productos = new ArrayList<>();
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("producto.listar");

			spq.setParameter("P_NOMBRE", (nombre == null ? "" : nombre));

			if (spq.execute()) {

				Object ret = spq.getOutputParameterValue("P_CURSOR");

				if (ret != null) {
					productos = (List<Producto>) ret;
				}
			}

		} catch (Exception e) {
			System.err.println("Error de consulta " + e.getMessage());
			throw new DAOException(e);
		}

		return productos;
	}

	@Override
	public boolean agregar(Producto producto) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("producto.insertar");

			spq.setParameter("P_NOMBRE", producto.getNombre());
			spq.setParameter("P_STOCK", producto.getStock());
			spq.setParameter("P_PRECIO", producto.getPrecio());

			spq.execute();
			
			Object ret = spq.getOutputParameterValue(1); // P_ID_PRODUCTO

			if (ret != null) {
				producto.setId(Long.valueOf(ret.toString()));
				sw = true;
			}

		} catch (Exception e) {
			System.err.println("Error al agregar " + e.getMessage());
			throw new DAOException(e);
		}

		return sw;

	}

	@Override
	public boolean modificar(Producto producto) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("producto.actualizar");

			spq.setParameter("P_ID_PRODUCTO", producto.getId());
			spq.setParameter("P_NOMBRE", producto.getNombre());
			spq.setParameter("P_STOCK", producto.getStock());
			spq.setParameter("P_PRECIO", producto.getPrecio());

			spq.execute();
			
			sw = true;
			
		} catch (Exception e) {
			System.err.println("Error al modificar " + e.getMessage());
			throw new DAOException(e);
		}

		return sw;

	}

	@Override
	public boolean eliminar(Producto producto) throws DAOException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("producto.eliminar");

			spq.setParameter("P_ID_PRODUCTO", producto.getId());

			spq.execute();
			
			sw = true;
			
		} catch (Exception e) {
			System.err.println("Error al eliminar " + e.getMessage());
			throw new DAOException(e);
		}

		return sw;

	}

}
