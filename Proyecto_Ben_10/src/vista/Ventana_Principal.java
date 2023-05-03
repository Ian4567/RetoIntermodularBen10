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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import com.toedter.calendar.JDayChooser;

import clases.Cesta_Compra;
import clases.Juguete;
import clases.Linea_De_Ropa;
import clases.Pelicula_Serie;
import clases.Producto;
import modelo.ControladorBdImplementacion;
import modelo.DBImplementacion;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Ventana_Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
///jmdk,reo,e
	private final JPanel contentPanel = new JPanel();
	private JTextField textField, textField_1, textField_2, textField_3, textField_4;
	private JTable tablaProducto;
	private DBImplementacion db = new ControladorBdImplementacion();
	private Map<String, Producto> productos;
	private JButton btnPeli, btnJuguete, btnRopa;
	private JComboBox comboCodigoRopa, comboCodigoJuguete, comboCodigoPeli;
	private JButton btnCasa;
	private JMenuItem iniciar, registro, borrado, btnCesta;
	private JPanel usuario, main;
	private JMenuBar menuBar;
	private JButton btnNewButton;
	JTabbedPane tabbedPane;

	public Ventana_Principal(Producto producto) {
		setBounds(100, 100, 1920, 1080);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(0, 0, 0));
		tabbedPane.setBounds(0, 0, 1999, 1008);
		contentPanel.add(tabbedPane);

		main = new JPanel();
		main.setForeground(new Color(128, 255, 128));
		main.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Main", null, main, null);
		tabbedPane.setBackgroundAt(0, Color.DARK_GRAY);
		tabbedPane.setForegroundAt(0, new Color(128, 255, 128));
		main.setLayout(null);

		JLabel texto = new JLabel("Bienvenido  Alienigena a la tienda de");
		texto.setBounds(610, 46, 661, 81);
		main.add(texto);
		texto.setFont(new Font("Jokerman", Font.PLAIN, 30));
		texto.setForeground(new Color(128, 255, 128));
		texto.setHorizontalAlignment(SwingConstants.CENTER);

		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 255, 128));
		menuBar.setBounds(0, 0, 255, 64);
		main.add(menuBar);

		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(128, 255, 128));
		btnNewButton.setIcon(new ImageIcon("././imagenes/casa-removebg-preview.png"));
		menuBar.add(btnNewButton);

		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon("././imagenes/Ben_10_Omnitrix-removebg-preview.png"));
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("");
		mnNewMenu_1.setBackground(new Color(128, 255, 128));
		mnNewMenu_1.setIcon(new ImageIcon("././imagenes/carrito-removebg-preview (1).png"));
		menuBar.add(mnNewMenu_1);
		btnCasa = new JButton("");
		btnCasa.addActionListener(this);

		btnCasa.setBackground(new Color(128, 255, 128));
		btnCasa.setIcon(new ImageIcon("././imagenes/casa-removebg-preview.png"));
		menuBar.add(btnCasa);

		iniciar = new JMenuItem("Iniciar sesion");
		iniciar.setForeground(Color.BLACK);
		iniciar.setBackground(new Color(128, 255, 128));
		iniciar.setFont(new Font("Jokerman", Font.PLAIN, 15));
		iniciar.addActionListener(this);
		mnNewMenu.add(iniciar);

		registro = new JMenuItem("Registrarse");
		registro.setBackground(new Color(128, 255, 128));
		registro.setFont(new Font("Jokerman", Font.PLAIN, 15));
		registro.addActionListener(this);
		mnNewMenu.add(registro);

		borrado = new JMenuItem("Borrar Cuenta");
		borrado.setBackground(new Color(128, 255, 128));
		borrado.setFont(new Font("Jokerman", Font.PLAIN, 15));
		borrado.addActionListener(this);
		mnNewMenu.add(borrado);

		btnCesta = new JMenuItem("COMPRAR");
		mnNewMenu_1.add(btnCesta);
		btnCesta.addActionListener(this);
		texto.setHorizontalAlignment(SwingConstants.CENTER);

		usuario = new JPanel();
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

		this.presentarTablaRopa(producto, db, main);
		this.presentarTablaJuguete(producto, db, main);
		this.presentarTablaPeli(producto, db, main);

		btnJuguete = new JButton("Agregar Articulo");
		btnJuguete.setForeground(Color.GREEN);
		btnJuguete.setFont(new Font("Jokerman", Font.PLAIN, 13));
		btnJuguete.setBackground(Color.DARK_GRAY);
		btnJuguete.setBounds(1521, 532, 151, 64);
		main.add(btnJuguete);

		btnPeli = new JButton("Agregar Articulo");
		btnPeli.setForeground(Color.GREEN);
		btnPeli.setFont(new Font("Jokerman", Font.PLAIN, 13));
		btnPeli.setBackground(Color.DARK_GRAY);
		btnPeli.setBounds(1521, 794, 151, 64);
		main.add(btnPeli);

		btnRopa = new JButton("Agregar Articulo");
		btnRopa.setForeground(Color.GREEN);
		btnRopa.setFont(new Font("Jokerman", Font.PLAIN, 13));
		btnRopa.setBackground(Color.DARK_GRAY);
		btnRopa.setBounds(1521, 233, 151, 64);
		main.add(btnRopa);

		comboCodigoRopa = new JComboBox();
		comboCodigoRopa.setSelectedIndex(-1);
		comboCodigoRopa.setForeground(Color.WHITE);
		comboCodigoRopa.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboCodigoRopa.setBackground(Color.DARK_GRAY);
		comboCodigoRopa.setBounds(1521, 113, 151, 46);
		cargarComboCodigoRopa();
		main.add(comboCodigoRopa);

		comboCodigoJuguete = new JComboBox();
		comboCodigoJuguete.setSelectedIndex(-1);
		comboCodigoJuguete.setForeground(Color.WHITE);
		comboCodigoJuguete.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboCodigoJuguete.setBackground(Color.DARK_GRAY);
		comboCodigoJuguete.setBounds(1521, 397, 151, 46);
		cargarComboCodigoJuguete();
		main.add(comboCodigoJuguete);

		comboCodigoPeli = new JComboBox();
		comboCodigoPeli.setSelectedIndex(-1);
		comboCodigoPeli.setForeground(Color.WHITE);
		comboCodigoPeli.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboCodigoPeli.setBackground(Color.DARK_GRAY);
		comboCodigoPeli.setBounds(1521, 679, 151, 46);
		cargarComboCodigoPeli();
		main.add(comboCodigoPeli);

		JLabel lblJuguetes = new JLabel("JUGUETES");
		lblJuguetes.setForeground(Color.WHITE);
		lblJuguetes.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblJuguetes.setBounds(825, 399, 312, 58);
		main.add(lblJuguetes);

		JLabel lblP = new JLabel("PELIS Y SERIES");
		lblP.setForeground(Color.WHITE);
		lblP.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblP.setBounds(777, 679, 312, 58);
		main.add(lblP);

		JLabel lblLineaDeRopa = new JLabel("LINEA DE ROPA");
		lblLineaDeRopa.setForeground(Color.WHITE);
		lblLineaDeRopa.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblLineaDeRopa.setBounds(792, 123, 312, 58);
		main.add(lblLineaDeRopa);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRopa)) {
			insertarCesta();
		} else if (e.getSource().equals(btnJuguete)) {
			insertarCesta();
		} else if (e.getSource().equals(btnPeli)) {
			insertarCesta();
		} else if (e.getSource().equals(btnCasa)) {
			this.dispose();
			Ventana_Principal prin = new Ventana_Principal(null);
			prin.setVisible(true);
		} else if (e.getSource().equals(iniciar)) {
			Inicio_Sesion inicio = new Inicio_Sesion(this, true);
			inicio.setVisible(true);
		} else if (e.getSource().equals(registro)) {
			Registro reg = new Registro(this);
			reg.setVisible(true);
		} else if (e.getSource().equals(borrado)) {
			tabbedPane.setSelectedIndex(1);
			tabbedPane.setVisible(true);
			
		} else if (e.getSource().equals(btnCesta)) {
			this.dispose();
			Finalizar_Compra fin = new Finalizar_Compra();
			fin.setVisible(true);
		}

	}

	private void insertarCesta() {
		DBImplementacion db = new ControladorBdImplementacion();
		Cesta_Compra cesta;

		cesta = new Cesta_Compra();
		if (comboCodigoRopa.getSelectedIndex() > -1) {
			cesta.setNumReferencia(comboCodigoRopa.getSelectedItem().toString());
		} else if (comboCodigoJuguete.getSelectedIndex() > -1) {
			cesta.setNumReferencia(comboCodigoJuguete.getSelectedItem().toString());
		} else if (comboCodigoPeli.getSelectedIndex() > -1) {
			cesta.setNumReferencia(comboCodigoPeli.getSelectedItem().toString());
		}
		cesta.setFecha_Inicio(LocalDate.now());
		cesta.setFecha_fin(null);

	}

	private float sumarPrecio() {
		DBImplementacion db = new ControladorBdImplementacion();
		ArrayList<Producto> productoss = db.recogerProductos();
		return 0;

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

	private void presentarTablaRopa(Producto producto, DBImplementacion db, JPanel main) {

		JScrollPane linea = new JScrollPane();
		linea.setBounds(428, 192, 1037, 149);
		main.add(linea);
		tablaProducto = this.cargarTablaRopa(producto, db);
		linea.setViewportView(tablaProducto);

	}

	private JTable cargarTablaRopa(Producto producto, DBImplementacion db) {

		String[] columnas = { "Codigo_Producto", "Nombre", "Precio", "Peso", "Stock", "Dimensiones", "Talla", "Tejido",
				"Color", "Fabricante" };
		String[] registros = new String[10];

		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		modelo.setRowCount(0);

		productos = db.listarProdRopa();

		for (Producto prod : productos.values()) {
			registros[0] = prod.getCodigoProducto();
			registros[1] = prod.getNombre();
			registros[2] = Float.toString(prod.getPrecio());
			registros[3] = Float.toString(prod.getPeso());
			registros[4] = Integer.toString(prod.getNumExistencias());
			registros[5] = prod.getDimensiones();
			registros[6] = ((Linea_De_Ropa) prod).getTalla();
			registros[7] = ((Linea_De_Ropa) prod).getTejido();
			registros[8] = ((Linea_De_Ropa) prod).getColor();
			registros[9] = ((Linea_De_Ropa) prod).getFabricante();
			modelo.addRow(registros);

		}
		return new JTable(modelo);
	}

	private void presentarTablaJuguete(Producto producto, DBImplementacion db, JPanel main) {

		JScrollPane linea = new JScrollPane();
		linea.setBounds(428, 468, 1037, 149);
		main.add(linea);
		tablaProducto = this.cargarTablaJuguete(producto, db);
		linea.setViewportView(tablaProducto);

	}

	private JTable cargarTablaJuguete(Producto producto, DBImplementacion db) {

		String[] columnas = { "Codigo_Producto", "Nombre", "Precio", "Peso", "Stock", "Dimensiones", "Material",
				"Articulable", "Edad_Minima", "Pilas" };
		String[] registros = new String[10];

		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		modelo.setRowCount(0);

		productos = db.listarProdJuguete();

		for (Producto prod : productos.values()) {
			registros[0] = prod.getCodigoProducto();
			registros[1] = prod.getNombre();
			registros[2] = Float.toString(prod.getPrecio());
			registros[3] = Float.toString(prod.getPeso());
			registros[4] = Integer.toString(prod.getNumExistencias());
			registros[5] = prod.getDimensiones();
			registros[6] = ((Juguete) prod).getMaterial();
			registros[7] = ((Juguete) prod).getArticulable();
			registros[8] = Integer.toString(((Juguete) prod).getEdadMinima());
			registros[9] = ((Juguete) prod).getPilas();
			modelo.addRow(registros);

		}
		return new JTable(modelo);
	}

	private void presentarTablaPeli(Producto producto, DBImplementacion db, JPanel main) {

		JScrollPane linea = new JScrollPane();
		linea.setBounds(428, 759, 1037, 149);
		main.add(linea);
		tablaProducto = this.cargarTablaPeli(producto, db);
		linea.setViewportView(tablaProducto);

	}

	private JTable cargarTablaPeli(Producto producto, DBImplementacion db) {

		String[] columnas = { "Codigo_Producto", "Nombre", "Precio", "Peso", "Stock", "Dimensiones", "Genero",
				"Fecha de Lanzamineto", "Idioma", "Subtitulado", "Duracion" };
		String[] registros = new String[11];

		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		modelo.setRowCount(0);

		productos = db.listarProdPeli();

		for (Producto prod : productos.values()) {
			registros[0] = prod.getCodigoProducto();
			registros[1] = prod.getNombre();
			registros[2] = Float.toString(prod.getPrecio());
			registros[3] = Float.toString(prod.getPeso());
			registros[4] = Integer.toString(prod.getNumExistencias());
			registros[5] = prod.getDimensiones();
			registros[6] = ((Pelicula_Serie) prod).getGenero();
			registros[7] = ((Pelicula_Serie) prod).getFechaLanzamiento();
			registros[8] = ((Pelicula_Serie) prod).getIdioma();
			registros[9] = ((Pelicula_Serie) prod).getSubtitulado();
			registros[10] = ((Pelicula_Serie) prod).getDuracion();
			modelo.addRow(registros);

		}
		return new JTable(modelo);
	}

	public void cargarComboCodigoRopa() {

		DBImplementacion db = new ControladorBdImplementacion();
		ArrayList<Producto> codProd = db.recogerProductos();
		comboCodigoRopa.removeAllItems();
		for (Producto prod : codProd) {
			if (prod.getCodigoProducto().charAt(0) == 'L') {
				comboCodigoRopa.addItem(prod.getCodigoProducto());
			}
		}

		comboCodigoRopa.setSelectedIndex(-1);
	}

	public void cargarComboCodigoJuguete() {

		DBImplementacion db = new ControladorBdImplementacion();
		ArrayList<Producto> codProd = db.recogerProductos();
		comboCodigoJuguete.removeAllItems();
		for (Producto prod : codProd) {
			if (prod.getCodigoProducto().charAt(0) == 'J') {
				comboCodigoJuguete.addItem(prod.getCodigoProducto());
			}
		}

		comboCodigoJuguete.setSelectedIndex(-1);
	}

	public void cargarComboCodigoPeli() {

		DBImplementacion db = new ControladorBdImplementacion();
		ArrayList<Producto> codProd = db.recogerProductos();
		comboCodigoPeli.removeAllItems();
		for (Producto prod : codProd) {
			if (prod.getCodigoProducto().charAt(0) == 'P') {
				comboCodigoPeli.addItem(prod.getCodigoProducto());
			}
		}

		comboCodigoPeli.setSelectedIndex(-1);
	}
}
