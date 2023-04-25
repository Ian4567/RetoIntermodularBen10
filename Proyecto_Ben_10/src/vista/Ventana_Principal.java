package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Map;

import com.toedter.calendar.JDayChooser;

import clases.Linea_De_Ropa;
import clases.Producto;
import modelo.ControladorBdImplementacion;
import modelo.DBImplementacion;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Ventana_Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable tablaProducto;
	private DBImplementacion info;
	private Map<String, Producto> productos;

	public Ventana_Principal(Producto producto, DBImplementacion info) {
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

		JLabel texto = new JLabel("BIenvenido  Alienigena a la tienda de");
		texto.setBounds(610, 46, 661, 81);
		main.add(texto);
		texto.setFont(new Font("Jokerman", Font.PLAIN, 30));
		texto.setForeground(new Color(128, 255, 128));
		texto.setHorizontalAlignment(SwingConstants.CENTER);

		btnNewButton = new JButton("Agregar Articulo");
		btnNewButton.setFont(new Font("Jokerman", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(1314, 212, 151, 64);
		main.add(btnNewButton);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 255, 128));
		menuBar.setBounds(0, 0, 255, 64);
		main.add(menuBar);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(128, 255, 128));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\casa-removebg-preview.png"));
		menuBar.add(btnNewButton_1);

		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\Ben_10_Omnitrix-removebg-preview.png"));
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
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\carrito-removebg-preview (1).png"));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		JScrollPane linea = new JScrollPane();
		linea.setBounds(368, 344, 1037, 149);
		main.add(linea);
		linea.setViewportView(tablaProducto);

		JPanel usuario = new JPanel();
		usuario.setForeground(new Color(128, 255, 128));
		usuario.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Cuenta", null, usuario, null);
		usuario.setLayout(null);

		JLabel User = new JLabel("Usuario:");
		User.setFont(new Font("Jokerman", Font.PLAIN, 30));
		User.setForeground(new Color(128, 255, 128));
		User.setBounds(966, 30, 247, 55);
		usuario.add(User);

		textField = new JTextField();
		textField.setOpaque(false);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textField.setBackground(new Color(102, 255, 102));
		textField.setBounds(934, 96, 174, 18);
		usuario.add(textField);

		JLabel lblNewLabel = new JLabel("Tus Datos:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblNewLabel.setBounds(966, 125, 152, 86);
		usuario.add(lblNewLabel);

		JLabel lblArticulo = new JLabel("Nombre");
		lblArticulo.setForeground(Color.WHITE);
		lblArticulo.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblArticulo.setBounds(429, 231, 163, 68);
		usuario.add(lblArticulo);

		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textField_1.setBackground(new Color(102, 255, 102));
		textField_1.setBounds(602, 262, 174, 18);
		usuario.add(textField_1);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblApellido.setBounds(1282, 231, 163, 68);
		usuario.add(lblApellido);

		textField_2 = new JTextField();
		textField_2.setOpaque(false);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textField_2.setBackground(new Color(102, 255, 102));
		textField_2.setBounds(1455, 262, 174, 18);
		usuario.add(textField_2);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblDireccion.setBounds(429, 424, 163, 68);
		usuario.add(lblDireccion);

		textField_3 = new JTextField();
		textField_3.setOpaque(false);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textField_3.setBackground(new Color(102, 255, 102));
		textField_3.setBounds(602, 455, 174, 18);
		usuario.add(textField_3);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblTelefono.setBounds(1282, 424, 163, 68);
		usuario.add(lblTelefono);

		textField_4 = new JTextField();
		textField_4.setOpaque(false);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textField_4.setBackground(new Color(102, 255, 102));
		textField_4.setBounds(1455, 455, 174, 18);
		usuario.add(textField_4);

		JLabel lblComprasRealizadas = new JLabel("Compras Realizadas:");
		lblComprasRealizadas.setForeground(Color.WHITE);
		lblComprasRealizadas.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblComprasRealizadas.setBounds(906, 555, 311, 86);
		usuario.add(lblComprasRealizadas);
		tabbedPane.setBackgroundAt(1, Color.DARK_GRAY);
		tabbedPane.setForegroundAt(1, new Color(128, 255, 128));

		this.presentarTablaRopa(producto, info);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void presentarTablaRopa(Producto producto, DBImplementacion info) {
		JScrollPane linea = new JScrollPane();
		tablaProducto = this.cargarTablaRopa(producto, info);
		linea.setViewportView(tablaProducto);

		contentPanel.add(linea);
		linea.setBounds(368, 344, 1037, 149);

	}

	private JTable cargarTablaRopa(Producto producto, DBImplementacion info) {
		info = new ControladorBdImplementacion();
		String[] columnas = { "Codigo_Producto", "NOMBRE", "Precio", "Stock", "Dimensiones", "talla", "Tejido", "Color",
				"Fabricante" };
		String[] registros = new String[9];

		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		modelo.setRowCount(0);

		productos = info.listarProducto();

		for (Producto prod : productos.values()) {
			if (prod instanceof Linea_De_Ropa) {
				registros[0] = prod.getCodigoProducto();
				registros[1] = prod.getNombre();
				registros[2] = Float.toString(prod.getPrecio());
				registros[3] = Integer.toString(prod.getNumExistencias());
				registros[4] = prod.getDimensiones();
				registros[5] = ((Linea_De_Ropa) prod).getTalla();
				registros[6] = ((Linea_De_Ropa) prod).getTejido();
				registros[7] = ((Linea_De_Ropa) prod).getColor();
				registros[8] = ((Linea_De_Ropa) prod).getFabricante();

				modelo.addRow(registros);
			}
		}
		return new JTable(modelo);
	}
}
