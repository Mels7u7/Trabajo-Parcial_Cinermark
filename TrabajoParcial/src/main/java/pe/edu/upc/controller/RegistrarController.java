package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.entity.TipoUsuario;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.service.ITipoUsuarioService;

@Named
@ViewScoped
public class RegistrarController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITipoUsuarioService tS;

	private Usuario usu;

	@PostConstruct
	public void init() {
		this.usu = new Usuario();
	}

	public String registerUser() {
		String redirect = null;
		try {
			String contraseña = this.usu.getContraseña();
			String cotraseñaH = BCrypt.hashpw(contraseña, BCrypt.gensalt());
			this.usu.setContraseña(cotraseñaH);
			this.usu.setEstado("A");

			List<TipoUsuario> tU = new ArrayList<TipoUsuario>();
			int TIPO_USUARIO = 1;
			TipoUsuario r = new TipoUsuario();
			r.setId(TIPO_USUARIO);
			tU.add(r);
			tS.assignRolesToUser(usu, tU);
			redirect = "index?faces-redirect=true";
		} catch (Exception e) {

		}

		return redirect;
	}

	public Usuario getUser() {
		return usu;
	}

	public void setUsuario(Usuario usu) {
		this.usu = usu;
	}

}
