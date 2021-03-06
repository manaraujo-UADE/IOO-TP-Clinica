package main.java.entity;

import java.util.Date;

import main.java.dto.UsuarioDTO;
import main.java.enumeration.UsuarioTipo;

public class Usuario extends Persona {

	private String codigo;
	private Credentials credentials;
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	private UsuarioTipo tipoUsuario;
	private Date fechaNacimiento;

	public Usuario(UsuarioDTO usuarioDto) {
		super(usuarioDto.getApellido(), usuarioDto.getNombre(), new Direccion(usuarioDto.getDireccion()), usuarioDto.getDni(),
				usuarioDto.getMail());
		this.codigo = usuarioDto.getCodigo();
		this.credentials = new Credentials(usuarioDto.getCredentialsDto());
		this.tipoUsuario = usuarioDto.getTipoUsuario();
		this.fechaNacimiento = usuarioDto.getFechaNacimiento();
	}
	
	public void update(UsuarioDTO usuarioDto) {
		this.setCredentials(new Credentials(usuarioDto.getCredentialsDto()));
		this.setApellido(usuarioDto.getApellido());
		this.setNombre(usuarioDto.getNombre());
		this.setDni(usuarioDto.getDni());
		this.setFechaNacimiento(usuarioDto.getFechaNacimiento());
		this.setMail(usuarioDto.getMail());
		this.setTipoUsuario(usuarioDto.getTipoUsuario());
		this.setDireccion(new Direccion(usuarioDto.getDireccion()));
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Credentials getCredentials() {
		return this.credentials;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public UsuarioTipo getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(UsuarioTipo tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public UsuarioDTO toDto() {
		return new UsuarioDTO(codigo, credentials.toDTO(), tipoUsuario, fechaNacimiento, this.getApellido(), this.getNombre(),
				this.getDireccion().toDTO(), this.getDni(), this.getMail());
	}
}
