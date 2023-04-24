package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import clases.Tarjeta;
import clases.Usuario;

public class Registro extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFNombre;
	private JTextField textFEmail;
	private JTextField textFTelefono;
	private JTextField textFContrasena;
	private JTextField textFNumeroTar;
	private JTextField textFcvv;
	private JTextField textNombreUsuario;
	private JButton btnRegistrarse,btnLimpiar;
	private JLabel lblNewLabel, lblNombre, lblEmail,lblTelefono,lblContrasea,lblNumeroTarjeta,lblCvv, lblNombredeUsuario;

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
		lblNewLabel.setBounds(854, 172, 306, 121);
		contentPanel.add(lblNewLabel);
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblNombre.setBounds(305, 497, 238, 54);
			contentPanel.add(lblNombre);
		}
		{
		    lblEmail = new JLabel("Email");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblEmail.setBounds(305, 594, 126, 54);
			contentPanel.add(lblEmail);
		}
		{
			lblTelefono = new JLabel("Telefono");
			lblTelefono.setForeground(Color.WHITE);
			lblTelefono.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblTelefono.setBounds(1127, 394, 126, 54);
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
			lblNumeroTarjeta.setBounds(1127, 497, 208, 54);
			contentPanel.add(lblNumeroTarjeta);
		}
		{
			lblCvv = new JLabel("CVV");
			lblCvv.setForeground(Color.WHITE);
			lblCvv.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblCvv.setBounds(1127, 594, 64, 54);
			contentPanel.add(lblCvv);
		}
		
		btnRegistrarse = new JButton("REGISTRARSE ");
		btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarse.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnRegistrarse.setBackground(new Color(102,255,153));
		btnRegistrarse.setBounds(291, 838, 183, 44);
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
		textFNombre.setBounds(617, 513, 208, 34);
		contentPanel.add(textFNombre);
		textFNombre.setColumns(10);
		
		textFEmail = new JTextField();
		textFEmail.setOpaque(false);
		textFEmail.setForeground(Color.WHITE);
		textFEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFEmail.setColumns(10);
		textFEmail.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textFEmail.setBackground(new Color(102, 255, 102));
		textFEmail.setBounds(617, 610, 208, 34);
		contentPanel.add(textFEmail);
		
		textFTelefono = new JTextField();
		textFTelefono.setOpaque(false);
		textFTelefono.setForeground(Color.WHITE);
		textFTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFTelefono.setColumns(10);
		textFTelefono.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textFTelefono.setBackground(new Color(102, 255, 102));
		textFTelefono.setBounds(1384, 410, 208, 34);
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
			textFNumeroTar.setBounds(1384, 513, 208, 34);
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
			textFcvv.setBounds(1384, 598, 208, 34);
			contentPanel.add(textFcvv);
		}
		
		lblNombredeUsuario = new JLabel("Nombre de usuario");
		lblNombredeUsuario.setForeground(Color.WHITE);
		lblNombredeUsuario.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblNombredeUsuario.setBounds(301, 394, 238, 54);
		contentPanel.add(lblNombredeUsuario);
		
		textNombreUsuario = new JTextField();
		textNombreUsuario.setOpaque(false);
		textNombreUsuario.setForeground(Color.WHITE);
		textNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNombreUsuario.setColumns(10);
		textNombreUsuario.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textNombreUsuario.setBackground(new Color(102, 255, 102));
		textNombreUsuario.setBounds(617, 410, 208, 34);
		contentPanel.add(textNombreUsuario);
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
		if(e.getSource().equals(btnRegistrarse)) {
			registrarse();
		}
		else if(e.getSource().equals(btnLimpiar)){
			limpiar();
		}
		
	}

	private void limpiar() {
		// TODO Auto-generated method stub
		
	}

	private void registrarse() {
		Usuario us;
		Tarjeta tar = null;
		
		us = new Usuario();
		us.setNombre(textNombreUsuario.getText());;
		us.setNombrePersonal(textFNombre.getText());
		us.setEmail(textFEmail.getText());
		us.setContrasea(textFContrasena.getText());
		us.setNumTelefono(Integer.parseInt(textFTelefono.getText()));
		tar = new Tarjeta();
		tar.setNumeroTarjeta(textFNumeroTar.getText());
		tar.setCVV(textFcvv.getText());
		
		dao.registro(us, tar);
		
	}
}
