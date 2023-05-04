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
import java.sql.Date;
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
import clases.Realiza;
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
	private JButton btnAgregar;
	private JComboBox comboCodigo;
	private JButton btnCasa;
	private JMenuItem iniciar, registro, borrado, btnCesta;
	private JPanel usuario, main;
	private JMenuBar menuBar;
	private JButton btnNewButton;
	JTabbedPane tabbedPane;
	private JButton btnGestionarProductos;
	public Map<String, Cesta_Compra> compras;
	private JTextField textCantidad;

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
		borrado.setEnabled(false);
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
		tabbedPane.setEnabledAt(1, false);
		usuario.setLayout(null);

		JLabel User = new JLabel("Usuario:");
		User.setFont(new Font("Jokerman", Font.PLAIN, 30));
		User.setForeground(new Color(128, 255, 128));
		User.setBounds(966, 30, 247, 55);
		usuario.add(User);

		textCantidad = new JTextField();
		textCantidad.setOpaque(false);
		textCantidad.setForeground(Color.WHITE);
		textCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		textCantidad.setColumns(10);
		textCantidad.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textCantidad.setBackground(new Color(102, 255, 102));
		textCantidad.setBounds(1721, 129, 130, 18);
		main.add(textCantidad);

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
		lblComprasRealizadas.setBounds(894, 533, 311, 86);
		usuario.add(lblComprasRealizadas);
		tabbedPane.setBackgroundAt(1, Color.DARK_GRAY);
		tabbedPane.setForegroundAt(1, new Color(128, 255, 128));

		this.presentarTablaRopa(producto, db, main);
		this.presentarTablaJuguete(producto, db, main);
		this.presentarTablaPeli(producto, db, main);

		btnAgregar = new JButton("Agregar Articulo");
		btnAgregar.setEnabled(false);
		btnAgregar.setForeground(Color.GREEN);
		btnAgregar.setFont(new Font("Jokerman", Font.PLAIN, 13));
		btnAgregar.setBackground(Color.DARK_GRAY);
		btnAgregar.setBounds(1521, 233, 151, 64);
		btnAgregar.addActionListener(this);
		main.add(btnAgregar);

		comboCodigo = new JComboBox();
		comboCodigo.setSelectedIndex(-1);
		comboCodigo.setForeground(Color.WHITE);
		comboCodigo.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboCodigo.setBackground(Color.DARK_GRAY);
		comboCodigo.setBounds(1521, 113, 151, 46);
		cargarComboCodigo();
		main.add(comboCodigo);

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

		btnGestionarProductos = new JButton("Gestionar Productos");
		btnGestionarProductos.setForeground(new Color(255, 153, 102));
		btnGestionarProductos.setFont(new Font("Jokerman", Font.PLAIN, 13));
		btnGestionarProductos.setBackground(Color.DARK_GRAY);
		btnGestionarProductos.addActionListener(this);
		btnGestionarProductos.setBounds(70, 190, 185, 87);

		btnGestionarProductos.setVisible(false);
		main.add(btnGestionarProductos);

		JLabel lblStock = new JLabel("STOCK");
		lblStock.setForeground(Color.WHITE);
		lblStock.setFont(new Font("Jokerman", Font.BOLD, 15));
		lblStock.setBounds(1743, 77, 105, 58);
		main.add(lblStock);
		this.presentarTablaCompra(null, db, usuario);

	}

	public String generarCodigoRef(Cesta_Compra cesta) {
		DBImplementacion bd = new ControladorBdImplementacion();

		String codigo = "", num;
		int numero;
		numero = bd.numeroReferencia(cesta) + 1;

		codigo = "R" + String.format("%03d", numero);

		return codigo;
	}

	private void insertarCesta() {
		DBImplementacion db = new ControladorBdImplementacion();
		Cesta_Compra cesta;
		boolean cantidad = db.validarFloat(textCantidad.getText());
		Producto prod;
		Realiza realiza = null;
		Persona per = null;
		per = db.login(per);
		if (comboCodigo.getSelectedIndex() == -1 || textCantidad.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR!");
		} else {
			prod = db.recogerProductoId(comboCodigo.getSelectedItem().toString());
			if (cantidad) {
				if (Integer.parseInt(textCantidad.getText()) > prod.getNumExistencias()) {
			  		JOptionPane.showMessageDialog(null, "Error no puedes introducir mas de stock del que queda!");
				} else {
					cesta = new Cesta_Compra();
					cesta.setNumReferencia(generarCodigoRef(cesta));
					cesta.setFecha_Inicio(Date.valueOf(LocalDate.now()));
					cesta.setFecha_fin(Date.valueOf(LocalDate.ofYearDay(ALLBITS, ABORT)));
					cesta.setPeso_total(sumarPeso());
					cesta.setPrecio_total(sumarPrecio());
					db.insertarCompra_Cesta(cesta);
					realiza = new Realiza();
					realiza.setNumReferencia(cesta.getNumReferencia());
					realiza.setCodigoProducto(comboCodigo.getSelectedItem().toString());
					realiza.setCodigoPersona(per.getCodigoPersona());
					realiza.setCantidad(Integer.parseInt(textCantidad.getText()));
					db.insertarRealiza(realiza);
					JOptionPane.showMessageDialog(this, "PRODUCTO AÑADIDO CORRECTAMENTE A LA CESTA!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "LA CANTIDAD DEBE DE SER UN NUMERO!");
			}
		}
	}

	public boolean logeo(Persona per) {
		DBImplementacion db = new ControladorBdImplementacion();
		per = db.recogerD
		boolean logeado = false;
		if (per.getCodigoPersona().charAt(0) == 'U') {
			tabbedPane.setEnabledAt(1, true);
			btnAgregar.setEnabled(true);
			borrado.setEnabled(true);
			btnCesta.setEnabled(true);

			logeado = true;
		} else if (per.getCodigoPersona().charAt(0) == 'A') {
			borrado.setEnabled(false);
			btnGestionarProductos.setVisible(true);
			btnAgregar.setEnabled(false);
			borrado.setEnabled(true);
			logeado = true;
		} else {
			tabbedPane.setEnabledAt(1, false);
			borrado.setEnabled(false);
			btnAgregar.setEnabled(false);
			btnGestionarProductos.setVisible(false);
			btnCesta.setEnabled(false);

		}
		return logeado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Persona per = null;
		DBImplementacion db = new ControladorBdImplementacion();

		if (e.getSource().equals(btnAgregar)) {
			logeo(per);
			insertarCesta();
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
			Finalizar_Compra fin = new Finalizar_Compra();
			fin.setVisible(true);
		} else if (e.getSource().equals(btnGestionarProductos)) {
			Gestionar_Articulo gest = new Gestionar_Articulo(null, true);
			gest.setVisible(true);
		}

	}

	private float sumarPrecio() {
		DBImplementacion db = new ControladorBdImplementacion();
		Producto prod;
		prod = db.recogerProductoId(comboCodigo.getSelectedItem().toString());
		float suma;
		int textoLinea = Integer.parseInt(textCantidad.getText());
		suma = prod.getPrecio() * textoLinea;

		return suma;

	}

	private float sumarPeso() {
		DBImplementacion db = new ControladorBdImplementacion();
		Producto prod;
		prod = db.recogerProductoId(comboCodigo.getSelectedItem().toString());
		float suma;
		int textoLinea = Integer.parseInt(textCantidad.getText());
		suma = prod.getPeso() * textoLinea;

		return suma;

	}

	public void cargarComboCodigo() {

		DBImplementacion db = new ControladorBdImplementacion();
		ArrayList<Producto> codProd = db.recogerProductos();
		comboCodigo.removeAllItems();
		for (Producto prod : codProd) {
			comboCodigo.addItem(prod.getCodigoProducto());
		}

		comboCodigo.setSelectedIndex(-1);
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

	private void presentarTablaCompra(Cesta_Compra compra, DBImplementacion db, JPanel usuario) {

		JScrollPane linea = new JScrollPane();
		linea.setBounds(444, 655, 1179, 242);
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
			if (com.getFecha_fin() != null) {
				registros[0] = com.getNumReferencia();
				registros[1] = com.getFecha_Inicio().toString();
				registros[2] = com.getFecha_fin().toString();
				registros[3] = Float.toString(com.getPeso_total());
				registros[4] = Float.toString(com.getPrecio_total());
				modelo.addRow(registros);
			}
		}
		return new JTable(modelo);
	}

	private Persona recogerUsuario() {
		DBImplementacion bd = new ControladorBdImplementacion();
		return null;

	}

	public void introducirStock() {
		if (Integer.parseInt(textCantidad.getText()) > productos.get(comboCodigo.getSelectedItem().toString())
				.getNumExistencias()) {
			JOptionPane.showMessageDialog(null, "Error no puedes introducir mas de stock del que queda");
		}

	}
}
