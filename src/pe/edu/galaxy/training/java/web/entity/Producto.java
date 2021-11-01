package pe.edu.galaxy.training.java.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NamedStoredProcedureQueries({
	
    @NamedStoredProcedureQuery(
        name = "producto.listar",
        procedureName = "PKG_PRODUCTO.SP_LISTAR",
        resultClasses=Producto.class,
        parameters = {
          @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="P_CURSOR", type=void.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE", type=String.class)
          
    }),
    
    @NamedStoredProcedureQuery(
            name = "producto.insertar",
            procedureName = "PKG_PRODUCTO.SP_INSERTAR",
            parameters = {
              @StoredProcedureParameter(mode=ParameterMode.OUT, name="P_ID_PRODUCTO", type=Long.class),
              @StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE", type=String.class),
              @StoredProcedureParameter(mode=ParameterMode.IN, name="P_STOCK", type=Integer.class),
              @StoredProcedureParameter(mode=ParameterMode.IN, name="P_PRECIO", type=Double.class)
              
        }),
    
    @NamedStoredProcedureQuery(
            name = "producto.actualizar",
            procedureName = "PKG_PRODUCTO.SP_ACTUALIZAR",
            parameters = {
              @StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_PRODUCTO", type=Long.class),
              @StoredProcedureParameter(mode=ParameterMode.IN, name="P_NOMBRE", type=String.class),
              @StoredProcedureParameter(mode=ParameterMode.IN, name="P_STOCK", type=Integer.class),
              @StoredProcedureParameter(mode=ParameterMode.IN, name="P_PRECIO", type=Double.class)
              
        }),
    
    @NamedStoredProcedureQuery(
            name = "producto.eliminar",
            procedureName = "PKG_PRODUCTO.SP_ELIMINAR",
            parameters = {
              @StoredProcedureParameter(mode=ParameterMode.IN, name="P_ID_PRODUCTO", type=Long.class)
              
        })
})

@Table(name="PRODUCTO")
@Entity(name="Producto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Producto {
	
	@Id
	@Column(name="ID_PRODUCTO")
	private long id;

	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="STOCK")
	private int stock;
	
	@Column(name="PRECIO")
	private double precio;
	
	@Column(name="ESTADO")
	private boolean estado;

}
