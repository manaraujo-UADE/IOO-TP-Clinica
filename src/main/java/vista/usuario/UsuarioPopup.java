package main.java.vista.usuario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import main.java.dto.CredentialsDTO;
import main.java.dto.DireccionDTO;
import main.java.dto.UsuarioDTO;
import main.java.enumeration.UsuarioTipo;
import main.java.util.DateUtil;
import main.java.vista.IPopup;
import main.java.vista.util.DatePicker;
import main.java.vista.util.ModalResult;


public class UsuarioPopup extends IPopup {
	
	private JTextField txtNombreUsuario;
	private JPasswordField txtPassword;
	private JComboBox<UsuarioTipo> txtTipo;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JFormattedTextField txtDNI;
	private JDatePickerImpl txtFechaNacimiento;
	private JTextField txtMail;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtLocalidad;
		
	public UsuarioPopup(JFrame frame) {
		super(frame, "Usuario", 450, 450);
		setLocationRelativeTo(frame);
		inicializarControles();
	}
	
	protected void inicializarControles() {
	
		JLabel lblNombreUsuario = new JLabel("Nombre usuario");
		txtNombreUsuario = new JFormattedTextField();
		txtNombreUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña");
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		txtDNI = new JFormattedTextField();
		txtDNI.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		txtTipo = new JComboBox<UsuarioTipo>();
		txtTipo.setModel(new DefaultComboBoxModel<UsuarioTipo>(UsuarioTipo.values()));
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
	    txtFechaNacimiento = DatePicker.INSTANCE.getDatePicker();
	    		
		JLabel lblMail = new JLabel("Mail");
		txtMail = new JTextField();
		txtMail.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle");
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		txtLocalidad = new JTextField();
		txtLocalidad.setColumns(10);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombreUsuario)
						.addComponent(lblPassword)
						.addComponent(lblTipo)
						.addComponent(lblApellido)
						.addComponent(lblNombre)
						.addComponent(lblDni)
						.addComponent(lblFechaNac)
						.addComponent(lblMail)
						.addComponent(lblCalle)
						.addComponent(lblNumero)
						.addComponent(lblLocalidad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNombreUsuario, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFechaNacimiento, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCalle, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLocalidad, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNombreUsuario)
							.addComponent(txtNombreUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPassword)
							.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTipo)
							.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDni)
							.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)	
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaNac)
						.addComponent(txtFechaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMail)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCalle)
						.addComponent(txtCalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)						
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumero)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)	
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalidad)
						.addComponent(txtLocalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)						

					.addContainerGap(60, Short.MAX_VALUE))
		);
		
		contentPanel.setLayout(gl_contentPanel);
		
	}
	
	public UsuarioDTO getUsuario() {
		return (UsuarioDTO) dto;
	}
	
	public void setUsuario(UsuarioDTO usuarioDto) {
		this.dto = usuarioDto;
		asignarDatosForm();
	}

	protected boolean asignarDatosEntidad() {
		try {
			checkFields();
			UsuarioDTO usuarioDto = (UsuarioDTO) dto;
			dto = new UsuarioDTO(usuarioDto != null ? usuarioDto.getCodigo() : null, 
									   new CredentialsDTO(txtNombreUsuario.getText(), txtPassword.getText()),
									   UsuarioTipo.valueOf(String.valueOf(txtTipo.getSelectedItem())), 
									   DateUtil.getDateFormat().parse(txtFechaNacimiento.getJFormattedTextField().getText()), 
									   txtApellido.getText(), 
									   txtNombre.getText(), 
									   new DireccionDTO(txtCalle.getText(), Integer.valueOf(txtNumero.getText()), txtLocalidad.getText()), 
									   Long.valueOf(txtDNI.getText()), 
									   txtMail.getText());
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "DATOS INCORRECTOS", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	protected void asignarDatosForm(){
		UsuarioDTO usuarioDto = (UsuarioDTO) dto;
		txtNombreUsuario.setText(String.valueOf(usuarioDto.getCredentialsDto().getUsername()));
		txtPassword.setText(String.valueOf(usuarioDto.getCredentialsDto().getPassword()));
		txtTipo.setToolTipText(usuarioDto.getTipoUsuario().name());
		txtApellido.setText(usuarioDto.getApellido());
		txtNombre.setText(usuarioDto.getNombre());
		txtDNI.setText(String.valueOf(usuarioDto.getDni()));
		txtFechaNacimiento.getJFormattedTextField().setText(DateUtil.getDateFormat().format(usuarioDto.getFechaNacimiento()));
		txtMail.setText(usuarioDto.getMail());
		txtCalle.setText(usuarioDto.getDireccion().getCalle());
		txtNumero.setText(String.valueOf(usuarioDto.getDireccion().getNumero()));
		txtLocalidad.setText(usuarioDto.getDireccion().getLocalidad());
	}

	@Override
	protected void checkFields() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
