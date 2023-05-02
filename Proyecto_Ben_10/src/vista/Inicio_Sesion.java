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
import modelo.DBImplementacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Inicio_Sesion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textEmail;
	private JPasswordField passContrasena;
	private JButton btnIniciarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio_Sesion frame = new Inicio_Sesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio_Sesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textEmail = new JTextField();
		textEmail.setBounds(786, 425, 356, 20);
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
		lblEmail.setBounds(909, 327, 77, 54);
		contentPane.add(lblEmail);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblContrasea.setBounds(881, 532, 232, 54);
		contentPane.add(lblContrasea);

		passContrasena = new JPasswordField();
		passContrasena.setOpaque(false);
		passContrasena.setForeground(Color.WHITE);
		passContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		passContrasena.setColumns(10);
		passContrasena.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		passContrasena.setBackground(new Color(102, 255, 102));
		passContrasena.setBounds(786, 640, 356, 34);
		contentPane.add(passContrasena);

		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnIniciarSesion.setBackground(new Color(102, 255, 153));
		btnIniciarSesion.setBounds(862, 768, 202, 44);
		btnIniciarSesion.addActionListener(this);
		contentPane.add(btnIniciarSesion);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnIniciarSesion)) {
			inicarSesion();
		}

	}

	private void inicarSesion() {
		Persona pers = new Usuario();
		// RECOGER EMAIL Y CONTRASEÑA
		pers.setEmail(textEmail.getText());
		pers.setContrasena(new String(passContrasena.getPassword()));

		DBImplementacion db = new ControladorBdImplementacion();

		pers = db.login(pers);

		// SI FALTA ALGUN CAMPO VACIO
		if (textEmail.getText().equals("") || passContrasena.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "FALTA CAMPOS POR RELLENAR!");
		} else {
			// COMPROBAR QUE EL USUARIO ES CORRECTO
			if (textEmail.getText().equals(pers.getEmail()) && passContrasena.getText().equals(pers.getContrasena())) {
				// SI EL TIPO ES IGUAL A ADMIN
				if (pers.getCodigoPersona().charAt(0) == ('U')) {
					this.dispose();
					Ventana_Principal ven = new Ventana_Principal(null, null);
					ven.setVisible(true);

					// SI EL TIPO ES IGUAL A CLIENTE
				} else if (pers.getCodigoPersona().charAt(0) == ('A')) {
					this.dispose();
					Ventana_Principal ven = new Ventana_Principal(null, null);
					ven.setVisible(true);

					// SI EL EMAIL O CONTRASEÑA NO COINCIDEN
				} else {
					JOptionPane.showMessageDialog(this, "ERROR! EMAIL O CONTRASEÑA INCORRECTOS");
				}
			} else {
				JOptionPane.showMessageDialog(this, "USUARIO O CONTRASEÑA INCORRECTOS!");
			}
		}

	}
}
