package pe.edu.galaxy.training.java.web.presentacion;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import pe.edu.galaxy.training.java.web.presentacion.constantes.Mensajes;
import pe.edu.galaxy.training.java.web.presentacion.enums.CrudEnum;

public class GenericoMB {

	protected void msgAlerta(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", msg));
	}

	protected void msgAlerta(String titulo, String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, msg));
	}

	protected void msgInfo(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", msg));
	}

	protected void msgInfo(String titulo, String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, msg));
	}

	protected void msgError(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg));
	}

	protected void msgError(String titulo, String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, msg));
	}

	protected void msgCRUDExito(CrudEnum opc) {
		switch (opc) {
			case REGISTRO:
				this.msgInfo(Mensajes.MSG_MAN_EXITO_REG);
				break;
			case ACTUALIZACION:
				this.msgInfo(Mensajes.MSG_MAN_EXITO_ACT);
				break;
			case ELIMINACION:
				this.msgInfo(Mensajes.MSG_MAN_EXITO_ELI);
				break;
			default:
				break;
		}
	}
	
	protected void msgCRUDError(CrudEnum opc) {
		switch (opc) {
		case REGISTRO:
			this.msgInfo(Mensajes.MSG_MAN_ERROR_REG);
			break;
		case ACTUALIZACION:
			this.msgInfo(Mensajes.MSG_MAN_ERROR_ACT);
			break;
		case ELIMINACION:
			this.msgInfo(Mensajes.MSG_MAN_ERROR_ELI);
			break;
		case LISTADO:
			this.msgInfo(Mensajes.MSG_MAN_ERROR_LIS);
			break;
		default:
			break;
		}
	}
}
