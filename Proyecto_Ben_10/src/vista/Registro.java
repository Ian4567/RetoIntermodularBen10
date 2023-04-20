package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

public class Registro extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		
		JLabel lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Jokerman", Font.PLAIN, 59));
		lblNewLabel.setBounds(854, 172, 306, 121);
		contentPanel.add(lblNewLabel);
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblNombre.setBounds(305, 372, 126, 54);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblEmail.setBounds(305, 485, 126, 54);
			contentPanel.add(lblEmail);
		}
		{
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setForeground(Color.WHITE);
			lblTelefono.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblTelefono.setBounds(305, 594, 126, 54);
			contentPanel.add(lblTelefono);
		}
		{
			JLabel lblContrasea = new JLabel("Contraseña");
			lblContrasea.setForeground(Color.WHITE);
			lblContrasea.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblContrasea.setBounds(305, 706, 149, 54);
			contentPanel.add(lblContrasea);
		}
		{
			JLabel lblNumeroTarjeta = new JLabel("Numero Tarjeta");
			lblNumeroTarjeta.setForeground(Color.WHITE);
			lblNumeroTarjeta.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblNumeroTarjeta.setBounds(1127, 372, 208, 54);
			contentPanel.add(lblNumeroTarjeta);
		}
		{
			JLabel lblCvv = new JLabel("CVV");
			lblCvv.setForeground(Color.WHITE);
			lblCvv.setFont(new Font("Jokerman", Font.PLAIN, 25));
			lblCvv.setBounds(1127, 485, 64, 54);
			contentPanel.add(lblCvv);
		}
		
		JButton btnNewButton = new JButton("REGISTRARSE ");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(102,255,153));
		btnNewButton.setBounds(291, 838, 183, 44);
		contentPanel.add(btnNewButton);
		{
			JButton btnLimpiar = new JButton("LIMPIAR");
			btnLimpiar.setFont(new Font("Jokerman", Font.BOLD, 20));
			btnLimpiar.setBackground(new Color(102, 255, 153));
			btnLimpiar.setBounds(1127, 838, 183, 44);
			contentPanel.add(btnLimpiar);
		}
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
}
