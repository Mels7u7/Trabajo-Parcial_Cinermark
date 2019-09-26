package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.UsuarioR;
import pe.edu.upc.service.ITipoUsuarioService;

@Named
@ViewScoped
public class CentroController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITipoUsuarioService tS;

	public void verificarSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Usuario u = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

			if (u == null) {
				context.getExternalContext().redirect("index.xhtml");
			} else {

				String viewId = context.getViewRoot().getViewId();
				boolean rpta = this.verificarMenu(viewId);

				if (!rpta) {
					context.getExternalContext().redirect("./Error.xhtml");
				}
			}
		} catch (Exception e) {

		}
	}

	public boolean verificarMenu(String viewId) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

		List<UsuarioR> uR = tS.findUserRolesByUser(us);

		String rol = "";
		switch (viewId) {
		case "/part.xhtml":
			rol = "USER,ADMIN";
			break;
		case "/listPart.xhtml":
			rol = "ADMIN";
			break;
		case "/motor.xhtml":
			rol = "USER,ADMIN";
			break;
		case "/listMotor.xhtml":
			rol = "ADMIN,USER";
			break;
		case "/panel.xhtml":
			rol = "ADMIN,USER";
			break;

		default:
			break;
		}

		String arreglo[] = rol.split(",");

		int[] iarr = { 0 };
		uR.forEach(r -> {
			for (String x : arreglo) {
				if (r.getTipo().getTipoUsuario().equals(x)) {
					iarr[0]++;
				}
			}
		});

		if (iarr[0] == 0) {
			return false;
		}
		return true;
	}

	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
