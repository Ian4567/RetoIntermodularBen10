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
import javax.swing.JOptionPane;
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
import clases.Persona;
import clases.Producto;
import clases.Usuario;
import modelo.ControladorBdImplementacion;
import modelo.DBImplementacion;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Ventana_Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField us, name, apell, dir, tfno;
	private JTable tablaProducto;
	private DBImplementacion db = new ControladorBdImplementacion();
	private Map<String, Producto> productos;
	public Map<String, Cesta_Compra> compras;
	private JButton btnPeli;
	private JButton btnJuguete;
	private JButton btnRopa;
	private JComboBox comboCodigoRopa;
	private JComboBox comboCodigoJuguete;
	private JComboBox comboCodigoPeli;
	private Cesta_Compra compra;
	private JTextField textLinea;
	private JTextField textJuguetes;
	private JTextField textPelis;
	private JButton btnCasa;
	private JMenuItem iniciar;
	private JMenuItem registro;
	private JMenuItem borrado;
	private JPanel usuario;
	private JTabbedPane tabbedPane ;
	public Ventana_Principal(Producto producto, DBImplementacion info) {
		setBounds(100, 100, 1920, 1080);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setForeground(new Color(128, 255, 128));
		tabbedPane.setBackground(Color.DARK_GRAY);
		tabbedPane.setBounds(0, 0, 1999, 1008);
		contentPanel.add(tabbedPane);

		JPanel main = new JPanel();
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

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 255, 128));
		menuBar.setBounds(0, 0, 255, 64);
		main.add(menuBar);

		btnCasa = new JButton("");
		btnCasa.addActionListener(this);
		btnCasa.setBackground(new Color(128, 255, 128));
		btnCasa.setIcon(new ImageIcon("././imagenes/casa-removebg-preview.png"));
		menuBar.add(btnCasa);

		JMenu cu_us = new JMenu("");
		cu_us.setBackground(new Color(128, 255, 128));
		cu_us.setIcon(new ImageIcon("././imagenes/Ben_10_Omnitrix-removebg-preview.png"));
		menuBar.add(cu_us);

		iniciar = new JMenuItem("Iniciar sesion");
		iniciar.addActionListener(this);
		iniciar.setForeground(Color.BLACK);
		iniciar.setBackground(new Color(128, 255, 128));
		iniciar.setFont(new Font("Jokerman", Font.PLAIN, 15));
		cu_us.add(iniciar);

		registro = new JMenuItem("Registrarse");
		registro.addActionListener(this);
		registro.setBackground(new Color(128, 255, 128));
		registro.setFont(new Font("Jokerman", Font.PLAIN, 15));
		cu_us.add(registro);

		borrado = new JMenuItem("Borrar Cuenta");
		borrado.addActionListener(this);
		borrado.setBackground(new Color(128, 255, 128));
		borrado.setFont(new Font("Jokerman", Font.PLAIN, 15));
		cu_us.add(borrado);

		JMenu cesta = new JMenu("");
		cesta.setBackground(new Color(128, 255, 128));
		cesta.setIcon(new ImageIcon("././imagenes/carrito-removebg-preview (1).png"));
		menuBar.add(cesta);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		cesta.add(mntmNewMenuItem_2);
		texto.setHorizontalAlignment(SwingConstants.CENTER);

		usuario = new JPanel();
		usuario.setForeground(new Color(128, 255, 128));
		usuario.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Cuenta", null, usuario, null);
		usuario.setLayout(null);

		JLabel User = new JLabel("Usuario:");
		User.setFont(new Font("Jokerman", Font.PLAIN, 30));
		User.setForeground(new Color(128, 255, 128));
		User.setBounds(916, 35, 247, 55);
		usuario.add(User);

		us = new JTextField();
		us.setOpaque(false);
		us.setForeground(Color.WHITE);
		us.setFont(new Font("Tahoma", Font.BOLD, 14));
		us.setColumns(10);
		us.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		us.setBackground(new Color(102, 255, 102));
		us.setBounds(906, 101, 174, 18);
		usuario.add(us);

		JLabel lblNewLabel = new JLabel("Tus Datos:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblNewLabel.setBounds(929, 130, 152, 86);
		usuario.add(lblNewLabel);

		JLabel lblArticulo = new JLabel("Nombre");
		lblArticulo.setForeground(Color.WHITE);
		lblArticulo.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblArticulo.setBounds(367, 231, 163, 68);
		usuario.add(lblArticulo);

		name = new JTextField();
		name.setOpaque(false);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		name.setColumns(10);
		name.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		name.setBackground(new Color(102, 255, 102));
		name.setBounds(540, 262, 174, 18);
		usuario.add(name);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblApellido.setBounds(1282, 231, 163, 68);
		usuario.add(lblApellido);

		apell = new JTextField();
		apell.setOpaque(false);
		apell.setForeground(Color.WHITE);
		apell.setFont(new Font("Tahoma", Font.BOLD, 14));
		apell.setColumns(10);
		apell.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		apell.setBackground(new Color(102, 255, 102));
		apell.setBounds(1455, 262, 174, 18);
		usuario.add(apell);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblDireccion.setBounds(367, 424, 163, 68);
		usuario.add(lblDireccion);

		dir = new JTextField();
		dir.setOpaque(false);
		dir.setForeground(Color.WHITE);
		dir.setFont(new Font("Tahoma", Font.BOLD, 14));
		dir.setColumns(10);
		dir.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		dir.setBackground(new Color(102, 255, 102));
		dir.setBounds(540, 455, 174, 18);
		usuario.add(dir);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblTelefono.setBounds(1282, 424, 163, 68);
		usuario.add(lblTelefono);

		tfno = new JTextField();
		tfno.setOpaque(false);
		tfno.setForeground(Color.WHITE);
		tfno.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfno.setColumns(10);
		tfno.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		tfno.setBackground(new Color(102, 255, 102));
		tfno.setBounds(1455, 455, 174, 18);
		usuario.add(tfno);

		JLabel lblComprasRealizadas = new JLabel("Compras Realizadas:");
		lblComprasRealizadas.setForeground(Color.WHITE);
		lblComprasRealizadas.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblComprasRealizadas.setBounds(882, 557, 311, 86);
		usuario.add(lblComprasRealizadas);

		this.presentarTablaRopa(producto, db, main);
		this.presentarTablaJuguete(producto, db, main);
		this.presentarTablaPeli(producto, db, main);

		btnJuguete = new JButton("Agregar Articulo");
		btnJuguete.setForeground(Color.GREEN);
		btnJuguete.setFont(new Font("Jokerman", Font.PLAIN, 13));
		btnJuguete.setBackground(Color.DARK_GRAY);
		btnJuguete.setBounds(1521, 553, 151, 64);
		main.add(btnJuguete);

		btnPeli = new JButton("Agregar Articulo");
		btnPeli.setForeground(Color.GREEN);
		btnPeli.setFont(new Font("Jokerman", Font.PLAIN, 13));
		btnPeli.setBackground(Color.DARK_GRAY);
		btnPeli.setBounds(1521, 844, 151, 64);
		main.add(btnPeli);

		btnRopa = new JButton("Agregar Articulo");
		btnRopa.setForeground(Color.GREEN);
		btnRopa.setFont(new Font("Jokerman", Font.PLAIN, 13));
		btnRopa.setBackground(Color.DARK_GRAY);
		btnRopa.setBounds(1521, 277, 151, 64);
		main.add(btnRopa);

		comboCodigoRopa = new JComboBox();
		comboCodigoRopa.setSelectedIndex(-1);
		comboCodigoRopa.setForeground(Color.WHITE);
		comboCodigoRopa.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboCodigoRopa.setBackground(Color.DARK_GRAY);
		comboCodigoRopa.setBounds(1521, 181, 151, 46);
		cargarComboCodigoRopa();
		main.add(comboCodigoRopa);

		comboCodigoJuguete = new JComboBox();
		comboCodigoJuguete.setSelectedIndex(-1);
		comboCodigoJuguete.setForeground(Color.WHITE);
		comboCodigoJuguete.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboCodigoJuguete.setBackground(Color.DARK_GRAY);
		comboCodigoJuguete.setBounds(1521, 457, 151, 46);
		cargarComboCodigoJuguete();
		main.add(comboCodigoJuguete);

		comboCodigoPeli = new JComboBox();
		comboCodigoPeli.setSelectedIndex(-1);
		comboCodigoPeli.setForeground(Color.WHITE);
		comboCodigoPeli.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboCodigoPeli.setBackground(Color.DARK_GRAY);
		comboCodigoPeli.setBounds(1521, 748, 151, 46);
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

		textLinea = new JTextField();
		textLinea.setOpaque(false);
		textLinea.setForeground(Color.WHITE);
		textLinea.setFont(new Font("Tahoma", Font.BOLD, 14));
		textLinea.setColumns(10);
		textLinea.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textLinea.setBackground(new Color(102, 255, 102));
		textLinea.setBounds(1718, 209, 174, 18);
		main.add(textLinea);

		textJuguetes = new JTextField();
		textJuguetes.setOpaque(false);
		textJuguetes.setForeground(Color.WHITE);
		textJuguetes.setFont(new Font("Tahoma", Font.BOLD, 14));
		textJuguetes.setColumns(10);
		textJuguetes.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textJuguetes.setBackground(new Color(102, 255, 102));
		textJuguetes.setBounds(1718, 472, 174, 18);
		main.add(textJuguetes);

		textPelis = new JTextField();
		textPelis.setOpaque(false);
		textPelis.setForeground(Color.WHITE);
		textPelis.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPelis.setColumns(10);
		textPelis.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textPelis.setBackground(new Color(102, 255, 102));
		textPelis.setBounds(1718, 776, 174, 18);
		main.add(textPelis);

		this.presentarTablaCompra(compra, db, usuario);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(new Color(128, 255, 128));
		menuBar_1.setBounds(0, 0, 255, 64);
		usuario.add(menuBar_1);

		JButton inicio = new JButton("");
		inicio.setIcon(new ImageIcon("././imagenes/casa-removebg-preview.png"));
		inicio.setBackground(new Color(128, 255, 128));
		menuBar_1.add(inicio);

		JMenu mnNewMenu_2 = new JMenu("");
		mnNewMenu_2.setIcon(new ImageIcon("././imagenes/Ben_10_Omnitrix-removebg-preview.png"));
		mnNewMenu_2.setBackground(new Color(128, 255, 128));
		menuBar_1.add(mnNewMenu_2);

		JMenuItem iniciar_1 = new JMenuItem("Iniciar sesion");
		iniciar_1.setForeground(Color.BLACK);
		iniciar_1.setFont(new Font("Jokerman", Font.PLAIN, 15));
		iniciar_1.setBackground(new Color(128, 255, 128));
		mnNewMenu_2.add(iniciar_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Registrarse");
		mntmNewMenuItem_3.setFont(new Font("Jokerman", Font.PLAIN, 15));
		mntmNewMenuItem_3.setBackground(new Color(128, 255, 128));
		mnNewMenu_2.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Borrar Cuenta");
		mntmNewMenuItem_1_1.setFont(new Font("Jokerman", Font.PLAIN, 15));
		mntmNewMenuItem_1_1.setBackground(new Color(128, 255, 128));
		mnNewMenu_2.add(mntmNewMenuItem_1_1);

		JMenu mnNewMenu_1_1 = new JMenu("");
		mnNewMenu_1_1.setIcon(new ImageIcon("././imagenes/carrito-removebg-preview (1).png"));
		mnNewMenu_1_1.setBackground(new Color(128, 255, 128));
		menuBar_1.add(mnNewMenu_1_1);

		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("New menu item");
		mnNewMenu_1_1.add(mntmNewMenuItem_2_1);
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRopa)) {
			insertarCesta();
		} else if (e.getSource().equals(btnJuguete)) {
			insertarCesta();
		} else if (e.getSource().equals(btnPeli)) {
			insertarCesta();
		} else if (e.getSource().equals(btnCasa)) {
			this.dispose();
			Ventana_Principal prin = new Ventana_Principal(null, null);
			prin.setVisible(true);
		} else if (e.getSource().equals(iniciar)) {
			this.dispose();
			Inicio_Sesion inicio = new Inicio_Sesion();
			inicio.setVisible(true);
		} else if (e.getSource().equals(registro)) {
			this.dispose();
			Registro reg = new Registro();
			reg.setVisible(true);
		} else if (e.getSource().equals(borrado)) {
			this.dispose();
			Ventana_Principal borrar = new Ventana_Principal(null, null);
			
			borrar.setVisible(true);
			tabbedPane.setSelectedIndex(1);
			
			
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

	private void presentarTablaCompra(Cesta_Compra compra, DBImplementacion db, JPanel usuario) {

		JScrollPane linea = new JScrollPane();
		linea.setBounds(450, 642, 1179, 242);
		usuario.add(linea);
		tablaProducto = this.cargarTablaCompra(compra, db);
		tablaProducto.setBackground(new Color(128, 255, 128));
		linea.setViewportView(tablaProducto);

	}

	private JTable cargarTablaCompra(Cesta_Compra compra, DBImplementacion db) {

		String[] columnas = { "Numero_Referencia", "Fecha_Ini", "Fecha_Fin", "Peso_Total", "Precio_Total" };
		String[] registros = new String[5];

		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		modelo.setRowCount(0);

		compras = db.listarCompra();

		for (Cesta_Compra com : compras.values()) {

			registros[0] = com.getNumReferencia();
			registros[1] = com.getFecha_Inicio().toString();
			registros[2] = com.getFecha_fin().toString();
			registros[3] = Float.toString(com.getPeso_total());
			registros[4] = Float.toString(com.getPrecio_total());
			modelo.addRow(registros);

		}
		return new JTable(modelo);
	}

	private Persona recogerUsuario() {
		DBImplementacion bd = new ControladorBdImplementacion();
		return null;

	}

	public void introducirStock() {
		if (Integer.parseInt(textLinea.getText()) > productos.get(comboCodigoRopa.getSelectedItem().toString())
				.getNumExistencias()) {
			JOptionPane.showMessageDialog(null, "Error no puedes introducir mas de stock del que queda");
		}
	}
}
