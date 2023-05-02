package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import clases.Juguete;
import clases.Linea_De_Ropa;
import clases.Persona;
import clases.Producto;
import clases.Tarjeta;
import clases.Usuario;
import modelo.ControladorBdImplementacion;
import modelo.DBImplementacion;
import com.toedter.calendar.JDateChooser;

public class Registro extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFNombre, textFEmail, textFTelefono, textFContrasena, textFNumeroTar, textFcvv,
			textNombreUsuario, textFDireccion, textFapellido;
	private JButton btnRegistrarse, btnLimpiar;
	private JLabel lblNewLabel, lblNombre, lblEmail, lblTelefono, lblContrasea, lblNumeroTarjeta, lblCvv,
			lblNombredeUsuario, lblApellido, lblFechaNac, lblDireccion;
	private Persona pers;
	private JDateChooser fechaSelector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registro dialog = new Registro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registro() {
		setBounds(100, 100, 1920, 1080);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Jokerman", Font.PLAIN, 59));
		lblNewLabel.setBounds(855, 143, 306, 121);
		contentPanel.add(lblNewLabel);
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblNombre.setBounds(305, 447, 238, 54);
			contentPanel.add(lblNombre);
		}
		{
			lblEmail = new JLabel("Email");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblEmail.setBounds(305, 612, 126, 54);
			contentPanel.add(lblEmail);
		}
		{
			lblTelefono = new JLabel("Telefono");
			lblTelefono.setForeground(Color.WHITE);
			lblTelefono.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblTelefono.setBounds(1127, 359, 126, 54);
			contentPanel.add(lblTelefono);
		}
		{
			lblContrasea = new JLabel("Contraseña");
			lblContrasea.setForeground(Color.WHITE);
			lblContrasea.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblContrasea.setBounds(305, 693, 149, 54);
			contentPanel.add(lblContrasea);
		}
		{
			lblNumeroTarjeta = new JLabel("Numero Tarjeta");
			lblNumeroTarjeta.setForeground(Color.WHITE);
			lblNumeroTarjeta.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblNumeroTarjeta.setBounds(1127, 612, 208, 54);
			contentPanel.add(lblNumeroTarjeta);
		}
		{
			lblCvv = new JLabel("CVV");
			lblCvv.setForeground(Color.WHITE);
			lblCvv.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblCvv.setBounds(1127, 693, 64, 54);
			contentPanel.add(lblCvv);
		}

		btnRegistrarse = new JButton("REGISTRARSE ");
		btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarse.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnRegistrarse.setBackground(new Color(102, 255, 153));
		btnRegistrarse.setBounds(291, 838, 202, 44);
		btnRegistrarse.addActionListener(this);
		contentPanel.add(btnRegistrarse);
		{
			btnLimpiar = new JButton("LIMPIAR");
			btnLimpiar.setFont(new Font("Jokerman", Font.BOLD, 20));
			btnLimpiar.setBackground(new Color(102, 255, 153));
			btnLimpiar.setBounds(1127, 838, 183, 44);
			btnLimpiar.addActionListener(this);
			contentPanel.add(btnLimpiar);
		}

		textFNombre = new JTextField();
		textFNombre.setOpaque(false);
		textFNombre.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textFNombre.setForeground(new Color(255, 255, 255));
		textFNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFNombre.setBackground(new Color(102, 255, 102));
		textFNombre.setBounds(617, 463, 208, 34);
		contentPanel.add(textFNombre);
		textFNombre.setColumns(10);

		textFEmail = new JTextField();
		textFEmail.setOpaque(false);
		textFEmail.setForeground(Color.WHITE);
		textFEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFEmail.setColumns(10);
		textFEmail.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textFEmail.setBackground(new Color(102, 255, 102));
		textFEmail.setBounds(617, 628, 208, 34);
		contentPanel.add(textFEmail);

		textFTelefono = new JTextField();
		textFTelefono.setOpaque(false);
		textFTelefono.setForeground(Color.WHITE);
		textFTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFTelefono.setColumns(10);
		textFTelefono.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textFTelefono.setBackground(new Color(102, 255, 102));
		textFTelefono.setBounds(1384, 375, 208, 34);
		contentPanel.add(textFTelefono);

		textFContrasena = new JTextField();
		textFContrasena.setOpaque(false);
		textFContrasena.setForeground(Color.WHITE);
		textFContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFContrasena.setColumns(10);
		textFContrasena.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textFContrasena.setBackground(new Color(102, 255, 102));
		textFContrasena.setBounds(617, 709, 208, 34);
		contentPanel.add(textFContrasena);
		{
			textFNumeroTar = new JTextField();
			textFNumeroTar.setOpaque(false);
			textFNumeroTar.setForeground(Color.WHITE);
			textFNumeroTar.setFont(new Font("Tahoma", Font.BOLD, 14));
			textFNumeroTar.setColumns(10);
			textFNumeroTar.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
			textFNumeroTar.setBackground(new Color(102, 255, 102));
			textFNumeroTar.setBounds(1384, 628, 208, 34);
			contentPanel.add(textFNumeroTar);
		}
		{
			textFcvv = new JTextField();
			textFcvv.setOpaque(false);
			textFcvv.setForeground(Color.WHITE);
			textFcvv.setFont(new Font("Tahoma", Font.BOLD, 14));
			textFcvv.setColumns(10);
			textFcvv.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
			textFcvv.setBackground(new Color(102, 255, 102));
			textFcvv.setBounds(1384, 709, 208, 34);
			contentPanel.add(textFcvv);
		}

		lblNombredeUsuario = new JLabel("Nombre de usuario");
		lblNombredeUsuario.setForeground(Color.WHITE);
		lblNombredeUsuario.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblNombredeUsuario.setBounds(305, 359, 238, 54);
		contentPanel.add(lblNombredeUsuario);

		textNombreUsuario = new JTextField();
		textNombreUsuario.setOpaque(false);
		textNombreUsuario.setForeground(Color.WHITE);
		textNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNombreUsuario.setColumns(10);
		textNombreUsuario.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textNombreUsuario.setBackground(new Color(102, 255, 102));
		textNombreUsuario.setBounds(617, 375, 208, 34);
		contentPanel.add(textNombreUsuario);

		lblApellido = new JLabel("Apellido\r\n");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblApellido.setBounds(305, 529, 126, 54);
		contentPanel.add(lblApellido);

		lblFechaNac = new JLabel("Fecha nac.");
		lblFechaNac.setForeground(Color.WHITE);
		lblFechaNac.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblFechaNac.setBounds(1127, 447, 183, 54);
		contentPanel.add(lblFechaNac);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblDireccion.setBounds(1127, 529, 126, 54);
		contentPanel.add(lblDireccion);

		textFapellido = new JTextField();
		textFapellido.setOpaque(false);
		textFapellido.setForeground(Color.WHITE);
		textFapellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFapellido.setColumns(10);
		textFapellido.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textFapellido.setBackground(new Color(102, 255, 102));
		textFapellido.setBounds(617, 539, 208, 34);
		contentPanel.add(textFapellido);

		textFDireccion = new JTextField();
		textFDireccion.setOpaque(false);
		textFDireccion.setForeground(Color.WHITE);
		textFDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFDireccion.setColumns(10);
		textFDireccion.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textFDireccion.setBackground(new Color(102, 255, 102));
		textFDireccion.setBounds(1384, 546, 208, 34);
		contentPanel.add(textFDireccion);

		fechaSelector = new JDateChooser();
		fechaSelector.setBounds(1384, 463, 208, 24);
		contentPanel.add(fechaSelector);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegistrarse)) {
			registrarse(pers);
		} else if (e.getSource().equals(btnLimpiar)) {
			limpiar();
		}

	}

	private void limpiar() {
		textNombreUsuario.setText("");
		textFNombre.setText("");
		textFapellido.setText("");
		textFEmail.setText("");
		textFContrasena.setText("");
		textFTelefono.setText("");
		textFDireccion.setText("");
		textFNumeroTar.setText("");
		textFcvv.setText("");

	}

	public String generarCodigo(Persona pers) {
		DBImplementacion bd = new ControladorBdImplementacion();

		String codigo = "", num;
		int numero;
		numero = bd.numeroPersona(pers) + 1;
		if (pers instanceof Usuario) {
			codigo = "U" + String.format("%03d", numero);
		}

		return codigo;
	}

	private void registrarse(Persona pers) {
		Tarjeta tar = null;

		DBImplementacion bd = new ControladorBdImplementacion();
		if (textNombreUsuario.getText().equals("") || textFNombre.getText().equals("")
				|| textFapellido.getText().equals("") || textFEmail.getText().equals("")
				|| textFContrasena.getText().equals("") || textFTelefono.getText().equals("")
				|| textFDireccion.getText().equals("") || textFNumeroTar.getText().equals("")
				|| textFcvv.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "FALTAN CAMPOS POR RELLENAR!");
		} else {

			if (bd.existePersona(textNombreUsuario.getText()) == 0) {

				if (textFNumeroTar.getText().length() == 16) { 

					if (bd.esEmail(textFEmail.getText())) {

						if (bd.existeNumeroTarjeta(textFNumeroTar.getText().length()) == 0 ) {

							if (textFTelefono.getText().length() == 9) {

								if (textFcvv.getText().length() == 3) {

									tar = new Tarjeta();
									tar.setNumeroTarjeta(textFNumeroTar.getText());
									tar.setCVV(Integer.parseInt(textFcvv.getText()));

									bd.insertarTarjeta(tar);
									pers = new Usuario();
									pers.setCodigoPersona(generarCodigo(pers));
									pers.setNombre(textNombreUsuario.getText());
									;
									pers.setEmail(textFEmail.getText());
									pers.setNumTelefono(Integer.parseInt(textFTelefono.getText()));
									pers.setContrasea(textFContrasena.getText());
									((Usuario) pers).setNumeroTarjeta(Long.parseLong(textFNumeroTar.getText()));
									((Usuario) pers).setNombrePersonal(textFNombre.getText());
									((Usuario) pers).setApellido(textFapellido.getText());
									((Usuario) pers).setFecha_nacimiento(fechaSelector.getDate().toString());
									((Usuario) pers).setDireccion(textFDireccion.getText());
									bd.insertarPersona(pers);

									JOptionPane.showMessageDialog(btnLimpiar, "Te has registrado correctamente!");

								} else {
									JOptionPane.showMessageDialog(this, "EL CVV NO TIENE 3 NUMEROS");
								}
							} else {
								JOptionPane.showMessageDialog(this, "EL NUMERO DE TELEFONO NO TIENE 9 DIGITOS");
							}
						} else {
							JOptionPane.showMessageDialog(this, "EL NUMERO DE TARJETA YA EXISTE");
						}
					} else {
						JOptionPane.showMessageDialog(this, "ESTO NO ES UN EMAIL!");
					}
				} else {
					JOptionPane.showMessageDialog(this,"LA TARJETA NO TIENE 16 NUMEROS!!!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "EL USUARIO YA EXISTE!");
			}
		}

	}
}
