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
import clases.Tarjeta;
import clases.Usuario;
import modelo.ControladorBdImplementacion;
import modelo.DAO;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class Ventana_Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
///jmdk,reo,e
	private final JPanel contentPanel = new JPanel();
	private JTextField textField, textNombre, textApellido, textDireccion, textTelefono;
	private JTable tablaProducto;
	private DAO db = new ControladorBdImplementacion();
	private Map<String, Producto> productos;
	private JButton btnAgregar, btnCasa;
	private JComboBox comboCodigo;
	private JMenuItem iniciar, registro, borrado, btnCesta;
	private JPanel usuario, main;
	private JMenuBar menuBar;
	private JButton btnNewButton;
	JTabbedPane tabbedPane;
	private JButton btnGestionarProductos, btnBorrar;
	public Map<String, Cesta_Compra> compras;
	private JTextField textCantidad;
	private JLabel lblNewLabel_2, lblNewLabel_3, lblNewLabel_4;
	public Persona pers;

	public Ventana_Principal(Producto producto, Persona per) {

		setIconImage(Toolkit.getDefaultToolkit().getImage("././imagenes/icono.png"));
		setBounds(100, 100, 1920, 1024);
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

		JLabel texto = new JLabel("Bienvenido  Alienigena a la Tienda ");
		texto.setBounds(576, 30, 661, 81);
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

		btnCesta = new JMenuItem("Cesta");
		mnNewMenu_1.add(btnCesta);
		btnCesta.setEnabled(false);
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
		User.setBounds(845, 29, 247, 55);
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
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setOpaque(false);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textField.setBackground(new Color(102, 255, 102));
		textField.setBounds(832, 96, 174, 18);
		usuario.add(textField);

		JLabel lblNewLabel = new JLabel("Tus Datos:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblNewLabel.setBounds(847, 125, 152, 86);
		usuario.add(lblNewLabel);

		JLabel lblArticulo = new JLabel("Nombre");
		lblArticulo.setForeground(Color.WHITE);
		lblArticulo.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblArticulo.setBounds(538, 231, 163, 68);
		usuario.add(lblArticulo);

		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setEditable(false);
		textNombre.setOpaque(false);
		textNombre.setForeground(Color.WHITE);
		textNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textNombre.setBackground(new Color(102, 255, 102));
		textNombre.setBounds(711, 262, 218, 18);
		usuario.add(textNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblApellido.setBounds(995, 231, 163, 68);
		usuario.add(lblApellido);

		textApellido = new JTextField();
		textApellido.setEnabled(false);
		textApellido.setEditable(false);
		textApellido.setOpaque(false);
		textApellido.setForeground(Color.WHITE);
		textApellido.setFont(new Font("Tahoma", Font.BOLD, 20));
		textApellido.setColumns(10);
		textApellido.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textApellido.setBackground(new Color(102, 255, 102));
		textApellido.setBounds(1168, 262, 200, 18);
		usuario.add(textApellido);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblDireccion.setBounds(538, 368, 163, 68);
		usuario.add(lblDireccion);

		textDireccion = new JTextField();
		textDireccion.setEnabled(false);
		textDireccion.setEditable(false);
		textDireccion.setOpaque(false);
		textDireccion.setForeground(Color.WHITE);
		textDireccion.setFont(new Font("Tahoma", Font.BOLD, 20));
		textDireccion.setColumns(10);
		textDireccion.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textDireccion.setBackground(new Color(102, 255, 102));
		textDireccion.setBounds(711, 399, 218, 18);
		usuario.add(textDireccion);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblTelefono.setBounds(995, 368, 163, 68);
		usuario.add(lblTelefono);

		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setEnabled(false);
		textTelefono.setOpaque(false);
		textTelefono.setForeground(Color.WHITE);
		textTelefono.setFont(new Font("Tahoma", Font.BOLD, 20));
		textTelefono.setColumns(10);
		textTelefono.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textTelefono.setBackground(new Color(102, 255, 102));
		textTelefono.setBounds(1168, 399, 200, 18);
		usuario.add(textTelefono);

		JLabel lblComprasRealizadas = new JLabel("Compras Realizadas:");
		lblComprasRealizadas.setForeground(Color.WHITE);
		lblComprasRealizadas.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblComprasRealizadas.setBounds(822, 428, 311, 86);
		usuario.add(lblComprasRealizadas);
		tabbedPane.setBackgroundAt(1, Color.DARK_GRAY);
		tabbedPane.setForegroundAt(1, new Color(128, 255, 128));

		btnAgregar = new JButton("Agregar Articulo");
		btnAgregar.setEnabled(false);
		btnAgregar.setForeground(new Color(0, 0, 0));
		btnAgregar.setFont(new Font("Jokerman", Font.BOLD, 15));
		btnAgregar.setBackground(new Color(128, 255, 128));
		btnAgregar.setBounds(1521, 222, 220, 64);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCesta(pers);
			}
		});
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
		lblP.setBounds(792, 678, 312, 58);
		main.add(lblP);

		JLabel lblLineaDeRopa = new JLabel("LINEA DE ROPA");
		lblLineaDeRopa.setForeground(Color.WHITE);
		lblLineaDeRopa.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblLineaDeRopa.setBounds(792, 123, 312, 58);
		main.add(lblLineaDeRopa);

		btnGestionarProductos = new JButton("Gestionar Productos");
		btnGestionarProductos.setForeground(new Color(0, 0, 0));
		btnGestionarProductos.setFont(new Font("Jokerman", Font.BOLD, 15));
		btnGestionarProductos.setBackground(new Color(255, 153, 102));
		btnGestionarProductos.addActionListener(this);
		btnGestionarProductos.setBounds(343, 33, 205, 87);

		btnGestionarProductos.setVisible(false);
		main.add(btnGestionarProductos);

		JLabel lblStock = new JLabel("STOCK");
		lblStock.setForeground(Color.WHITE);
		lblStock.setFont(new Font("Jokerman", Font.BOLD, 15));
		lblStock.setBounds(1743, 77, 105, 58);
		main.add(lblStock);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("././imagenes/logo.png"));
		lblNewLabel_1.setBounds(40, 113, 269, 256);
		main.add(lblNewLabel_1);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("././imagenes/rapidin.png"));
		lblNewLabel_4.setBounds(1388, 208, 520, 863);
		main.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("././imagenes/4.png"));
		lblNewLabel_5.setBounds(50, 374, 412, 669);
		main.add(lblNewLabel_5);

		this.presentarTablaCompra(null, db, usuario, pers);

		btnBorrar = new JButton("BORRAR");

		btnBorrar.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnBorrar.setBackground(new Color(250, 128, 114));
		btnBorrar.setBounds(845, 861, 200, 50);
		btnBorrar.addActionListener(this);
		usuario.add(btnBorrar);

		JLabel lblBorrarCuenta = new JLabel("BORRAR CUENTA");
		lblBorrarCuenta.setForeground(Color.WHITE);
		lblBorrarCuenta.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblBorrarCuenta.setBounds(832, 756, 259, 86);
		usuario.add(lblBorrarCuenta);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("././imagenes/BEN.png"));
		lblNewLabel_2.setBounds(1558, 441, 426, 581);
		usuario.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("././imagenes/linterna.png"));
		lblNewLabel_3.setBounds(63, 11, 444, 1011);
		usuario.add(lblNewLabel_3);

		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				presentarTablaRopa(producto, db, main);
				presentarTablaJuguete(producto, db, main);
				presentarTablaPeli(producto, db, main);
				cargarComboCodigo();
				presentarTablaCompra(null, db, usuario, per);

			}

			public void windowLostFocus(WindowEvent e) {
			}
		});

	}

	public String generarCodigoRef(Cesta_Compra cesta) {
		DAO bd = new ControladorBdImplementacion();

		String codigo = "", num;
		int numero;
		numero = bd.numeroReferencia(cesta) + 1;

		codigo = "R" + String.format("%03d", numero);

		return codigo;
	}

	private void insertarCesta(Persona per) {
		DAO db = new ControladorBdImplementacion();
		Cesta_Compra cesta;
		boolean cantidad = db.validarFloat(textCantidad.getText());
		Producto prod;
		Realiza realiza = null;

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

					cesta.setPeso_total(sumarPeso());
					cesta.setPrecio_total(sumarPrecio());
					db.insertarCompra_Cesta(cesta);

					realiza = new Realiza();
					realiza.setNumReferencia(cesta.getNumReferencia());
					realiza.setCodigoProducto(comboCodigo.getSelectedItem().toString());
					realiza.setCodigoPersona(per.getCodigoPersona());
					realiza.setCantidad(Integer.parseInt(textCantidad.getText()));
					db.insertarRealiza(realiza);
					prod.setNumExistencias(prod.getNumExistencias() - Integer.parseInt(textCantidad.getText()));

					db.insertarRealiza(realiza);
					db.modificarProducto(prod);
					textCantidad.setText("");
					JOptionPane.showMessageDialog(this, "PRODUCTO AÑADIDO CORRECTAMENTE A LA CESTA!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "LA CANTIDAD DEBE DE SER UN NUMERO!");
			}
		}
	}

	public Persona logeo(Persona per) {
		DAO db = new ControladorBdImplementacion();

		if (per != null) {
			if (per.getCodigoPersona().charAt(0) == 'U') {
				tabbedPane.setEnabledAt(1, true);
				btnAgregar.setEnabled(true);
				borrado.setEnabled(true);
				btnCesta.setEnabled(true);
				registro.setEnabled(false);
				iniciar.setEnabled(false);
				cargarDatosCuenta(per);

			} else if (per.getCodigoPersona().charAt(0) == 'A') {
				borrado.setEnabled(false);
				btnGestionarProductos.setVisible(true);
				btnAgregar.setEnabled(false);
				borrado.setEnabled(false);
				registro.setEnabled(false);
				iniciar.setEnabled(false);

			}
		} else {
			tabbedPane.setEnabledAt(1, false);
			borrado.setEnabled(false);
			btnAgregar.setEnabled(false);
			btnGestionarProductos.setVisible(false);
			btnCesta.setEnabled(false);
			registro.setEnabled(true);
			iniciar.setEnabled(true);
		}
		return per;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		DAO db = new ControladorBdImplementacion();
		if (e.getSource().equals(iniciar)) {
			Inicio_Sesion inicio = new Inicio_Sesion(this, true);
			inicio.setVisible(true);
			pers = inicio.iniciar();
			if (pers != null) {
				logeo(pers);
			}

		} else if (e.getSource().equals(registro)) {
			Registro reg = new Registro(this, true);
			reg.setVisible(true);
			pers = reg.obtenerPersona();

		} else if (e.getSource().equals(borrado)) {
			tabbedPane.setSelectedIndex(1);
			tabbedPane.setVisible(true);

		} else if (e.getSource().equals(btnGestionarProductos)) {

			Gestionar_Articulo gest = new Gestionar_Articulo(this, true);
			gest.setVisible(true);

		} else if (e.getSource().equals(btnBorrar)) {
			borrarCuenta(pers);
		} else if (e.getSource().equals(btnCesta)) {

			verCesta(pers);
		}

	}

	private void borrarCuenta(Persona pers) {
		DAO db = new ControladorBdImplementacion();
		int pregunt;

		pregunt = JOptionPane.showOptionDialog(null, "¿ESTAS SEGURO QUE DESEAS MODIFICAR EL CUENTA?  ", // ventana
				"Pregunta", // titulo de la ventana
				JOptionPane.YES_NO_OPTION, // para 3 botones si/no/cancel
				JOptionPane.QUESTION_MESSAGE, // tipo de ícono
				null, // null para icono por defecto.
				new Object[] { "SI", "NO" }, // objeto para las opciones
				// null para YES, NO y CANCEL
				"SI");
		if (pregunt == 0) {
			db.eliminarTarjeta(pers);
			db.eliminarCuenta(pers);
			JOptionPane.showMessageDialog(this, "CUENTA ELIMINADA CORRECTAMENTE!");
			tabbedPane.setSelectedIndex(0);

			pers = logeo(null);

		} else {
			JOptionPane.showMessageDialog(this, "SE HA CANCELADO EL BORRADO!");
		}

	}

	private void verCesta(Persona per) {
		DAO db = new ControladorBdImplementacion();

		Tarjeta tar;
		tar = db.recogerDatosTarjeta(per.getEmail());
		Finalizar_Compra fin = new Finalizar_Compra(per, null, true);
		fin.cargarDatosCompra(per, tar);
		fin.setVisible(true);

	}

	private float sumarPrecio() {
		DAO db = new ControladorBdImplementacion();
		Producto prod;
		prod = db.recogerProductoId(comboCodigo.getSelectedItem().toString());
		float suma;
		int textoLinea = Integer.parseInt(textCantidad.getText());
		suma = prod.getPrecio() * textoLinea;

		return suma;

	}

	private float sumarPeso() {
		DAO db = new ControladorBdImplementacion();
		Producto prod;
		prod = db.recogerProductoId(comboCodigo.getSelectedItem().toString());
		float suma;
		int textoLinea = Integer.parseInt(textCantidad.getText());
		suma = prod.getPeso() * textoLinea;

		return suma;

	}

	public void cargarComboCodigo() {

		DAO db = new ControladorBdImplementacion();
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

	private void presentarTablaRopa(Producto producto, DAO db, JPanel main) {
		JScrollPane linea = new JScrollPane();
		linea.setBounds(428, 192, 1037, 149);
		main.add(linea);
		tablaProducto = this.cargarTablaRopa(producto, db);
		tablaProducto.setEnabled(false);
		linea.setViewportView(tablaProducto);

	}

	private JTable cargarTablaRopa(Producto producto, DAO db) {

		String[] columnas = { "Codigo_Producto", "Nombre", "Precio", "Peso", "Stock", "Dimensiones", "Talla", "Tejido",
				"Color", "Fabricante" };
		String[] registros = new String[10];

		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		modelo.setRowCount(0);

		productos = db.listarProdRopa();

		for (Producto prod : productos.values()) {
			if (prod.getNumExistencias() > 0) {
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
		}
		return new JTable(modelo);
	}

	private void presentarTablaJuguete(Producto producto, DAO db, JPanel main) {

		JScrollPane linea = new JScrollPane();
		linea.setBounds(428, 468, 1037, 149);
		main.add(linea);
		tablaProducto = this.cargarTablaJuguete(producto, db);
		tablaProducto.setEnabled(false);
		linea.setViewportView(tablaProducto);

	}

	private JTable cargarTablaJuguete(Producto producto, DAO db) {

		String[] columnas = { "Codigo_Producto", "Nombre", "Precio", "Peso", "Stock", "Dimensiones", "Material",
				"Articulable", "Edad_Minima", "Pilas" };
		String[] registros = new String[10];

		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		modelo.setRowCount(0);

		productos = db.listarProdJuguete();

		for (Producto prod : productos.values()) {
			if (prod.getNumExistencias() > 0) {
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
		}
		return new JTable(modelo);
	}

	private void presentarTablaPeli(Producto producto, DAO db, JPanel main) {

		JScrollPane linea = new JScrollPane();
		linea.setBounds(428, 759, 1037, 149);
		main.add(linea);
		tablaProducto = this.cargarTablaPeli(producto, db);
		tablaProducto.setEnabled(false);
		linea.setViewportView(tablaProducto);

	}

	private JTable cargarTablaPeli(Producto producto, DAO db) {

		String[] columnas = { "Codigo_Producto", "Nombre", "Precio", "Peso", "Stock", "Dimensiones", "Genero",
				"Fecha de Lanzamineto", "Idioma", "Subtitulado", "Duracion" };
		String[] registros = new String[11];

		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		modelo.setRowCount(0);

		productos = db.listarProdPeli();

		for (Producto prod : productos.values()) {
			if (prod.getNumExistencias() > 0) {
				registros[0] = prod.getCodigoProducto();
				registros[1] = prod.getNombre();
				registros[2] = Float.toString(prod.getPrecio());
				registros[3] = Float.toString(prod.getPeso());
				registros[4] = Integer.toString(prod.getNumExistencias());
				registros[5] = prod.getDimensiones();
				registros[6] = ((Pelicula_Serie) prod).getGenero();
				registros[7] = ((Pelicula_Serie) prod).getFechaLanzamiento().toString();
				registros[8] = ((Pelicula_Serie) prod).getIdioma();
				registros[9] = ((Pelicula_Serie) prod).getSubtitulado();
				registros[10] = ((Pelicula_Serie) prod).getDuracion();
				modelo.addRow(registros);
			}
		}
		return new JTable(modelo);
	}

	private void presentarTablaCompra(Cesta_Compra compra, DAO db, JPanel usuario, Persona per) {
		JScrollPane linea = new JScrollPane();
		linea.setBounds(400, 514, 1179, 242);
		usuario.add(linea);
		
		tablaProducto = this.cargarTablaCompra(compra, db, per);
		tablaProducto.setBackground(new Color(128, 255, 128));
		tablaProducto.setEnabled(false);
		linea.setViewportView(tablaProducto);

	}

	private JTable cargarTablaCompra(Cesta_Compra compra, DAO db, Persona per) {
		String[] columnas = { "Numero_Referencia", "Fecha_Ini", "Fecha_Fin", "Peso_Total", "Precio_Total" };
		String[] registros = new String[5];

		DefaultTableModel modelo = new DefaultTableModel(null, columnas);

		if (per != null) {
			modelo.setRowCount(0);

			compras = db.listarCompra(per);

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
		}
		return new JTable(modelo);

	}

	public Persona cargarDatosCuenta(Persona pers) {
		DAO bd = new ControladorBdImplementacion();

		if (pers != null) {
			pers = db.recogerDatosPersonaEmail(pers.getEmail());
			textNombre.setText(((Usuario) pers).getNombrePersonal());
			textApellido.setText(((Usuario) pers).getApellido());
			textDireccion.setText(((Usuario) pers).getDireccion());
			textField.setText(pers.getNombre());
			textTelefono.setText(Integer.toString(((Usuario) pers).getNumTelefono()));

		}
		return pers;
	}

}
