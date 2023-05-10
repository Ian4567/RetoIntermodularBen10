package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import clases.Persona;
import clases.Usuario;
import modelo.ControladorBdImplementacion;
import modelo.DAO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Inicio_Sesion extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField textEmail;
	private JPasswordField passContrasena;
	private JButton btnIniciarSesion;

	public Inicio_Sesion(Ventana_Principal principal, boolean modal) {
		super(principal);
		this.setModal(modal);
		setBounds(100, 100, 450, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textEmail = new JTextField();
		textEmail.setBounds(90, 221, 268, 20);
		textEmail.setOpaque(false);
		textEmail.setForeground(Color.WHITE);
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textEmail.setColumns(10);
		textEmail.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textEmail.setBackground(new Color(102, 255, 102));
		contentPane.add(textEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblEmail.setBounds(173, 144, 77, 54);
		contentPane.add(lblEmail);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblContrasea.setBounds(140, 277, 232, 54);
		contentPane.add(lblContrasea);

		passContrasena = new JPasswordField();
		passContrasena.setOpaque(false);
		passContrasena.setForeground(Color.WHITE);
		passContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		passContrasena.setColumns(10);
		passContrasena.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		passContrasena.setBackground(new Color(102, 255, 102));
		passContrasena.setBounds(90, 356, 268, 34);
		contentPane.add(passContrasena);

		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnIniciarSesion.setBackground(new Color(102, 255, 153));
		btnIniciarSesion.setBounds(120, 452, 202, 44);
		btnIniciarSesion.addActionListener(this);
		contentPane.add(btnIniciarSesion);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnIniciarSesion)) {
			iniciar();
		}

	}

	public Persona iniciar() {
		Persona pers, existe = null;
		pers = new Persona();
		pers.setEmail(textEmail.getText());
		pers.setContrasena(new String(passContrasena.getPassword()));
		// RECOGER EMAIL Y CONTRASEÑA
		pers.setEmail(textEmail.getText());
		pers.setContrasena(new String(passContrasena.getPassword()));

		DAO db = new ControladorBdImplementacion();

		pers = db.login(pers);

		// SI FALTA ALGUN CAMPO VACIO
		if (textEmail.getText().equals("") || passContrasena.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "FALTA CAMPOS POR RELLENAR!");
		} else {
			// COMPROBAR QUE EL USUARIO ES CORRECTO
			if (textEmail.getText().equals(pers.getEmail()) && passContrasena.getText().equals(pers.getContrasena())) {
				// SI EL TIPO ES IGUAL A ADMIN
				if (pers.getCodigoPersona() != null) {
					existe = pers;
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "ERROR! EMAIL O CONTRASEÑA INCORRECTOS");
				}
			} else {
				JOptionPane.showMessageDialog(this, "USUARIO O CONTRASEÑA INCORRECTOS!");
			}
		}
		return existe;
	}


}
