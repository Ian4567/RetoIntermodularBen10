package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import clases.Juguete;
import clases.Linea_De_Ropa;
import clases.Persona;
import clases.Producto;
import clases.Tarjeta;
import clases.Usuario;
import modelo.ControladorBdImplementacion;
import modelo.DAO;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;

public class Registro extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFNombre, textFEmail, textFTelefono, textFNumeroTar, textFcvv, textNombreUsuario,
			textFDireccion, textFapellido;
	private JButton btnRegistrarse, btnLimpiar;
	private JLabel lblNewLabel, lblNombre, lblEmail, lblTelefono, lblContrasea, lblNumeroTarjeta, lblCvv,
			lblNombredeUsuario, lblApellido, lblFechaNac, lblDireccion;
	public Persona pers;
	private JDateChooser fechaSelector;
	private JPasswordField textFContrasena;
	private JMenuItem iniciar, registro, borrado, btnCesta;
	private JButton btnCasa;
	private boolean entra = true;
	private Ventana_Principal principal;

	public Registro(Ventana_Principal principal, boolean modal) {
		super(principal);
		this.principal = principal;
		this.setModal(modal);

		setBounds(100, 100, 1920, 1080);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 255, 128));
		menuBar.setBounds(0, 0, 255, 64);
		contentPanel.add(menuBar);

		btnCasa = new JButton("");
		btnCasa.addActionListener(this);

		btnCasa.setBackground(new Color(128, 255, 128));
		btnCasa.setIcon(new ImageIcon("././imagenes/casa-removebg-preview.png"));
		menuBar.add(btnCasa);

		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon("././imagenes/Ben_10_Omnitrix-removebg-preview.png"));
		menuBar.add(mnNewMenu);

		iniciar = new JMenuItem("Iniciar sesion");
		iniciar.setForeground(Color.BLACK);
		iniciar.setBackground(new Color(128, 255, 128));
		iniciar.setFont(new Font("Jokerman", Font.PLAIN, 15));
		iniciar.addActionListener(this);
		iniciar.setEnabled(false);
		mnNewMenu.add(iniciar);

		registro = new JMenuItem("Registrarse");
		registro.setBackground(new Color(128, 255, 128));
		registro.setFont(new Font("Jokerman", Font.PLAIN, 15));
		registro.addActionListener(this);
		registro.setEnabled(false);
		mnNewMenu.add(registro);

		borrado = new JMenuItem("Borrar Cuenta");
		borrado.setBackground(new Color(128, 255, 128));
		borrado.setFont(new Font("Jokerman", Font.PLAIN, 15));
		borrado.addActionListener(this);
		borrado.setEnabled(false);
		mnNewMenu.add(borrado);

		JMenu mnNewMenu_1 = new JMenu("");
		mnNewMenu_1.setBackground(new Color(128, 255, 128));
		mnNewMenu_1.setIcon(new ImageIcon("././imagenes/carrito-removebg-preview (1).png"));
		menuBar.add(mnNewMenu_1);

		JLabel texto = new JLabel("Bienvenido  Alienigena a la tienda de");
		texto.setBounds(610, 46, 661, 81);
		contentPanel.add(texto);
		texto.setFont(new Font("Jokerman", Font.PLAIN, 30));
		texto.setForeground(new Color(128, 255, 128));
		texto.setHorizontalAlignment(SwingConstants.CENTER);

		btnCesta = new JMenuItem("COMPRAR");
		mnNewMenu_1.add(btnCesta);
		btnCesta.addActionListener(this);
		btnCesta.setEnabled(false);
		texto.setHorizontalAlignment(SwingConstants.CENTER);

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

		textFContrasena = new JPasswordField();
		textFContrasena.setOpaque(false);
		textFContrasena.setForeground(Color.WHITE);
		textFContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFContrasena.setColumns(10);
		textFContrasena.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textFContrasena.setBackground(new Color(102, 255, 102));
		textFContrasena.setBounds(617, 709, 208, 34);
		contentPanel.add(textFContrasena);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRegistrarse)) {
			registrarse();
		} else if (e.getSource().equals(btnLimpiar)) {
			limpiar();
		} else if (e.getSource().equals(btnCasa)) {
			this.dispose();
		} 

	}
	
	/**
	 * En este metodo se devuelve la persona
	 * 
	 * @return la persona que se ha registrado
	 */
	public Persona obtenerPersona() {
		
		return pers;
	}

	/**
	 * En este metodo se limpian todos los campos
	 */
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

	/**
	 * Este metodo genera un codigo autonumerico de cada person
	 * 
	 * @param pers es la persona a la que se le generara un codigo
	 * 
	 * @return el codigo de la persona que ha sido generado
	 */

	public String generarCodigo(Persona pers) {
		DAO bd = new ControladorBdImplementacion();

		String codigo = "", num;
		int numero;
		numero = bd.numeroPersona(pers) + 1;
		if (pers instanceof Usuario) {
			codigo = "U" + String.format("%03d", numero);
		}

		return codigo;
	}

	/**
	 * En este metodo se registra la persona con todos los datos con sus respectivas restricciones
	 * 
	 * @return la persona con todos los datos del registro
	 */
	
	public Persona registrarse() {
		Tarjeta tar = null;
		boolean registro = false;
		DAO bd = new ControladorBdImplementacion();
		boolean numeroTel = bd.validarInt(textFTelefono.getText()), cvv = bd.validarInt(textFcvv.getText()),
				numeroTar = bd.validarLong(textFNumeroTar.getText());
	
// MIRAMOS SI HAY CAMPOS SIN RELLENAR
		if (!textNombreUsuario.getText().equals("") || !textFNombre.getText().equals("")
				|| !textFapellido.getText().equals("") || !textFEmail.getText().equals("")
				|| !textFContrasena.getText().equals("") || !textFTelefono.getText().equals("")
				|| !textFDireccion.getText().equals("") || !textFNumeroTar.getText().equals("")
				|| !textFcvv.getText().equals("") || fechaSelector.getDate() != null) {
			// MIRAMOS SI EXISTE EL USUARIO
			if (bd.existePersona(textNombreUsuario.getText()) == 0) {
				// MIRAMOS LA LARGURA DEL TELEFONO Y SI ES DE TIPO INT
				if (textFTelefono.getText().length() == 9 && numeroTel) {
					// COMPROBAMOS SI EXISTE LA TARJETA
					if (bd.existeTelefono(Integer.parseInt(textFTelefono.getText())) == 0) {
						// MIRAMOS QUE NO DEJE LA FECHA SIN ELEGIR Y QUE LA FECHA ES ANTERIOR AL DIA
						// ACTUAL
						if (fechaSelector.getDate() != null
								&& fechaSelector.getDate().before(Date.valueOf(LocalDate.now()))) {
							// VERIFICAMOS NO SEA UN EMAIL
							if (bd.esEmail(textFEmail.getText())) {
								// MIRAMOS SI EL GMAIL EXISTE
								if (bd.existeEmail(textFEmail.getText()) == 0) {
									// MIRAMOS LA LARGURA DEL NUMERO DE TARJETA Y MIRAMOS SI ES LONG
									if (textFNumeroTar.getText().length() == 16 && numeroTar) {
										// COMPROBAMOS SI EXISTE LA TARJETA
										if (bd.existeNumeroTarjeta(Long.parseLong(textFNumeroTar.getText())) == 0) {
											// COMPROBAMOS LA LARGURA DEL CVV Y SI ES DE TIPO ENTERO
											if (textFcvv.getText().length() == 3 && cvv) {

												tar = new Tarjeta();
												tar.setNumeroTarjeta(textFNumeroTar.getText());
												tar.setCVV(Integer.parseInt(textFcvv.getText()));

												bd.insertarTarjeta(tar);
												pers = new Usuario();
												pers.setCodigoPersona(generarCodigo(pers));
												pers.setNombre(textNombreUsuario.getText());

												pers.setEmail(textFEmail.getText());
												pers.setNumTelefono(Integer.parseInt(textFTelefono.getText()));
												pers.setContrasena(textFContrasena.getText());
												((Usuario) pers)
														.setNumeroTarjeta(Long.parseLong(textFNumeroTar.getText()));
												((Usuario) pers).setNombrePersonal(textFNombre.getText());
												((Usuario) pers).setApellido(textFapellido.getText());
												((Usuario) pers)
														.setFecha_nacimiento(fechaSelector.getDate().toString());
												((Usuario) pers).setDireccion(textFDireccion.getText());
												bd.insertarPersona(pers);

												JOptionPane.showMessageDialog(btnLimpiar,
														"Te has registrado correctamente!");

												registro = true;
												this.dispose();

												if (pers != null) {
													
													pers = principal.logeo(pers);
													Finalizar_Compra fin = new Finalizar_Compra(pers, principal, numeroTar);
												}
												

											} else {
												JOptionPane.showMessageDialog(this,
														"EL CVV NO TIENE 3 NUMEROS O NO ES UN NUMERO");
											}
										} else {
											JOptionPane.showMessageDialog(this, "EL NUMERO DE TARJETA YA EXISTE ");
										}
									} else {
										JOptionPane.showMessageDialog(this,
												"LA TARJETA NO TIENE 16 NUMEROS O HAS INTRODUCIDO LETRAS");
									}
								} else {
									JOptionPane.showMessageDialog(this, "YA HAY UNA PERSONA CON ESE EMAIL");
								}
							} else {
								JOptionPane.showMessageDialog(this, "ESTO NO ES UN EMAIL!");
							}
						} else {
							JOptionPane.showMessageDialog(this,
									"NO HAS ELEGIDO UNA FECHA DE NACIMIENTO O LA FECHA INTRODUCIDA ES POSTERIOR A LA ACTUAL");
						}
					} else {
						JOptionPane.showMessageDialog(this, "YA HAY UN USUARIO CON ESE NUMERO DE TELEFONO");
					}
				} else {
					JOptionPane.showMessageDialog(this,
							"EL NUMERO DE TELEFONO NO TIENE 9 DIGITOS O HAS INTRODUCIDO LETRAS");
				}
			} else {
				JOptionPane.showMessageDialog(this, "EL USUARIO YA EXISTE!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "FALTAN CAMPOS POR RELLENAR!");
		}
		return pers;
	}

}