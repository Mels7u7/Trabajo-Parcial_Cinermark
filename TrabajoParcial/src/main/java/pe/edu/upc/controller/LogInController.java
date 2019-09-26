package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Usuario;
import pe.edu.upc.serviceImpl.UsuarioServiceImpl;

@Named
@ViewScoped
public class LogInController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioServiceImpl uS;

	private Usuario us;

	@PostConstruct
	public void init() {
		this.us = new Usuario();
	}

	public String autenticacion() {
		String redirect = null;

		try {
			Optional<Usuario> usuE = this.uS.autenticacion(us);

			if (usuE.isPresent() && usuE.get().getEstado().equalsIgnoreCase("A")) {

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuE.get());
				redirect = "/panel?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return redirect;
	}

	public Usuario getUser() {
		return us;
	}

	public void setUser(Usuario usu) {
		this.us = usu;
	}

}
