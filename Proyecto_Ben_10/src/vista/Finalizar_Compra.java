package vista;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import clases.Cesta_Compra;
import clases.Producto;
import modelo.ControladorBdImplementacion;
import modelo.DBImplementacion;
import javax.swing.table.DefaultTableModel;

public class Finalizar_Compra extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaProducto;
	private JTextField textEmail;
	private JTextField textTelefono;
	private JTextField textNombre;
	private JTextField texCvv;
	private JTextField textCVV;
	private Map<String, Cesta_Compra> listaCompra;
	private DBImplementacion db = new ControladorBdImplementacion();
	private Cesta_Compra compra;
	private JPanel main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Finalizar_Compra dialog = new Finalizar_Compra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Finalizar_Compra() {
		setBounds(100, 100, 1920, 1080);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(0, 0, 0));
		tabbedPane.setBounds(0, 0, 1999, 1008);
		contentPanel.add(tabbedPane);

		JPanel main = new JPanel();
		main.setForeground(new Color(128, 255, 128));
		main.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Main", null, main, null);
		tabbedPane.setBackgroundAt(0, Color.DARK_GRAY);
		tabbedPane.setForegroundAt(0, new Color(128, 255, 128));
		main.setLayout(null);

		JLabel texto = new JLabel("FINALIZAR COMPRA");
		texto.setBounds(610, 46, 661, 81);
		main.add(texto);
		texto.setFont(new Font("Jokerman", Font.PLAIN, 30));
		texto.setForeground(new Color(128, 255, 128));
		texto.setHorizontalAlignment(SwingConstants.CENTER);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 255, 128));
		menuBar.setBounds(0, 0, 255, 64);
		main.add(menuBar);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(128, 255, 128));
		btnNewButton_1.setIcon(new ImageIcon("././imagenes/casa-removebg-preview.png"));
		menuBar.add(btnNewButton_1);

		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon("././imagenes/Ben_10_Omnitrix-removebg-preview.png"));
		menuBar.add(mnNewMenu);

		JMenuItem iniciar = new JMenuItem("Iniciar sesion");
		iniciar.setForeground(Color.BLACK);
		iniciar.setBackground(new Color(128, 255, 128));
		iniciar.setFont(new Font("Jokerman", Font.PLAIN, 15));
		mnNewMenu.add(iniciar);

		JMenuItem mntmNewMenuItem = new JMenuItem("Registrarse");
		mntmNewMenuItem.setBackground(new Color(128, 255, 128));
		mntmNewMenuItem.setFont(new Font("Jokerman", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Borrar Cuenta");
		mntmNewMenuItem_1.setBackground(new Color(128, 255, 128));
		mntmNewMenuItem_1.setFont(new Font("Jokerman", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("");
		mnNewMenu_1.setBackground(new Color(128, 255, 128));
		mnNewMenu_1.setIcon(new ImageIcon("././imagenes/carrito-removebg-preview (1).png"));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		texto.setHorizontalAlignment(SwingConstants.CENTER);

		textEmail = new JTextField();
		textEmail.setOpaque(false);
		textEmail.setForeground(Color.WHITE);
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textEmail.setColumns(10);
		textEmail.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textEmail.setBackground(new Color(102, 255, 102));
		textEmail.setBounds(622, 291, 174, 18);
		main.add(textEmail);

		textTelefono = new JTextField();
		textTelefono.setOpaque(false);
		textTelefono.setForeground(Color.WHITE);
		textTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTelefono.setColumns(10);
		textTelefono.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textTelefono.setBackground(new Color(102, 255, 102));
		textTelefono.setBounds(622, 419, 174, 18);
		main.add(textTelefono);

		textNombre = new JTextField();
		textNombre.setOpaque(false);
		textNombre.setForeground(Color.WHITE);
		textNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNombre.setColumns(10);
		textNombre.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textNombre.setBackground(new Color(102, 255, 102));
		textNombre.setBounds(622, 169, 174, 18);
		main.add(textNombre);

		texCvv = new JTextField();
		texCvv.setOpaque(false);
		texCvv.setForeground(Color.WHITE);
		texCvv.setFont(new Font("Tahoma", Font.BOLD, 14));
		texCvv.setColumns(10);
		texCvv.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		texCvv.setBackground(new Color(102, 255, 102));
		texCvv.setBounds(1259, 168, 174, 18);
		main.add(texCvv);

		textCVV = new JTextField();
		textCVV.setOpaque(false);
		textCVV.setForeground(Color.WHITE);
		textCVV.setFont(new Font("Tahoma", Font.BOLD, 14));
		textCVV.setColumns(10);
		textCVV.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textCVV.setBackground(new Color(102, 255, 102));
		textCVV.setBounds(1259, 290, 174, 18);
		main.add(textCVV);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblNombre.setBounds(469, 142, 163, 68);
		main.add(lblNombre);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblEmail.setBounds(469, 272, 163, 68);
		main.add(lblEmail);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblTelefono.setBounds(469, 388, 163, 68);
		main.add(lblTelefono);

		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setForeground(Color.WHITE);
		lblCvv.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblCvv.setBounds(1122, 272, 163, 68);
		main.add(lblCvv);

		JLabel lblNumeroDeTarjeta = new JLabel("Numero de tarjeta");
		lblNumeroDeTarjeta.setForeground(Color.WHITE);
		lblNumeroDeTarjeta.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblNumeroDeTarjeta.setBounds(1007, 138, 229, 68);
		main.add(lblNumeroDeTarjeta);

		JLabel lblDatosDeLa = new JLabel("DATOS DE LA COMPRA");
		lblDatosDeLa.setForeground(Color.WHITE);
		lblDatosDeLa.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblDatosDeLa.setBounds(778, 467, 527, 58);
		main.add(lblDatosDeLa);

		JButton btnFinalizarCompra = new JButton("FINALIZAR COMPRA");
		btnFinalizarCompra.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnFinalizarCompra.setBackground(new Color(102, 255, 153));
		btnFinalizarCompra.setBounds(525, 897, 313, 50);
		main.add(btnFinalizarCompra);

		JButton btnCancelarCompra = new JButton("CANCELAR COMPRA");
		btnCancelarCompra.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnCancelarCompra.setBackground(new Color(102, 255, 153));
		btnCancelarCompra.setBounds(1109, 897, 339, 50);
		main.add(btnCancelarCompra);

		this.presentarTabla(compra, db, main);

	}

	private void presentarTabla(Cesta_Compra compra, DBImplementacion db, JPanel main) {

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(360, 551, 1177, 286);
		main.add(scroll);

		tablaProducto = this.cargarTabla(compra, db);
		tablaProducto.setGridColor(Color.green);
		scroll.setViewportView(tablaProducto);

	}

	private JTable cargarTabla(Cesta_Compra comprar, DBImplementacion db) {
		
		String[] nombreColumnas = { "NUMREFERENCIA", "FECHA_INICIO", "FECHA_FIN", "PESO_TOTAL", "PRECIO_TOTAL" };
		String[] registros = new String[5];

		DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);
		modelo.setRowCount(0);

		listaCompra = db.listarCompra();

		for (Cesta_Compra compra : listaCompra.values()) {
			registros[0] = compra.getNumReferencia();
			registros[1] = compra.getFecha_Inicio().toString();
			registros[2] = compra.getFecha_fin().toString();
			registros[3] = Float.toString(compra.getPeso_total());
			registros[4] = Float.toString(compra.getPrecio_total());

			modelo.addRow(registros);
		}

		return new JTable(modelo);

	}

}
