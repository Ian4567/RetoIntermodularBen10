package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.Juguete;
import clases.Linea_De_Ropa;
import clases.Pelicula_Serie;
import clases.Producto;
import modelo.ControladorBdImplementacion;
import modelo.DBImplementacion;

import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gestionar_Articulo extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNumEstancias, textPrecio, textNombre, textDimensiones, textPeso, textColor, textFabricante,
			textIdioma, textDuracion, textMaterial, textTejido, textGenero;
	private JComboBox comboArticulable, comboPilas, comboSubtitulado, comboTalla, comboTipo, comboPegi;
	private JButton btnAñadir, btnModificar, btnBorrar;
	private JLabel lblLinea;
	private JLabel lblJuguete;
	private JLabel lblSeriePeli;
	private JComboBox comboCodigos;
	private JLabel lblCodigoParaBorrar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Gestionar_Articulo dialog = new Gestionar_Articulo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Gestionar_Articulo() {
		setBounds(100, 100, 1920, 1080);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblArticulo = new JLabel("Nombre");
		lblArticulo.setForeground(Color.WHITE);
		lblArticulo.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblArticulo.setBounds(527, 261, 163, 68);
		contentPanel.add(lblArticulo);

		JLabel lblArticulo_1 = new JLabel("ARTICULO");
		lblArticulo_1.setForeground(Color.WHITE);
		lblArticulo_1.setFont(new Font("Jokerman", Font.BOLD, 59));
		lblArticulo_1.setBounds(772, 180, 424, 68);
		contentPanel.add(lblArticulo_1);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblPrecio.setBounds(527, 334, 163, 68);
		contentPanel.add(lblPrecio);

		JLabel lblNumEstancias = new JLabel("Numº Estancias");
		lblNumEstancias.setForeground(Color.WHITE);
		lblNumEstancias.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblNumEstancias.setBounds(455, 419, 266, 68);
		contentPanel.add(lblNumEstancias);

		textNumEstancias = new JTextField();
		textNumEstancias.setOpaque(false);
		textNumEstancias.setForeground(Color.WHITE);
		textNumEstancias.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNumEstancias.setColumns(10);
		textNumEstancias.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textNumEstancias.setBackground(new Color(102, 255, 102));
		textNumEstancias.setBounds(694, 450, 174, 18);
		contentPanel.add(textNumEstancias);

		JLabel lblDimensiones = new JLabel("Dimensiones");
		lblDimensiones.setForeground(Color.WHITE);
		lblDimensiones.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblDimensiones.setBounds(1028, 261, 266, 68);
		contentPanel.add(lblDimensiones);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblPeso.setBounds(1060, 334, 266, 68);
		contentPanel.add(lblPeso);

		comboTipo = new JComboBox();
		comboTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoElegido();
			}
		});
		comboTipo.setModel(new DefaultComboBoxModel(new String[] { "LINEA DE ROPA", "JUGUETE", "PELICULA/SERIE" }));
		comboTipo.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboTipo.setBackground(Color.DARK_GRAY);
		comboTipo.setForeground(Color.WHITE);
		comboTipo.setBounds(1190, 434, 209, 46);
		comboTipo.setSelectedIndex(-1);
		contentPanel.add(comboTipo);

		lblLinea = new JLabel("LINEA DE ROPA");
		lblLinea.setForeground(Color.WHITE);
		lblLinea.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblLinea.setBounds(200, 511, 312, 58);
		contentPanel.add(lblLinea);

		comboTalla = new JComboBox();
		comboTalla.setModel(new DefaultComboBoxModel(new String[] { "XS", "S", "M", "L", "XL", "XXL", "XXXL" }));
		comboTalla.setEnabled(false);
		comboTalla.setForeground(Color.WHITE);
		comboTalla.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboTalla.setBackground(Color.DARK_GRAY);
		comboTalla.setBounds(279, 614, 195, 46);
		comboTalla.setSelectedIndex(-1);
		contentPanel.add(comboTalla);

		JLabel lblTalla = new JLabel("Talla");
		lblTalla.setForeground(Color.WHITE);
		lblTalla.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblTalla.setBounds(104, 597, 163, 68);
		contentPanel.add(lblTalla);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblTipo.setBounds(1070, 419, 163, 68);
		contentPanel.add(lblTipo);

		JLabel lblColor = new JLabel("Color");
		lblColor.setForeground(Color.WHITE);
		lblColor.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblColor.setBounds(104, 755, 163, 68);
		contentPanel.add(lblColor);

		textPrecio = new JTextField();
		textPrecio.setOpaque(false);
		textPrecio.setForeground(Color.WHITE);
		textPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPrecio.setColumns(10);
		textPrecio.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textPrecio.setBackground(new Color(102, 255, 102));
		textPrecio.setBounds(694, 363, 174, 18);
		contentPanel.add(textPrecio);

		textNombre = new JTextField();
		textNombre.setOpaque(false);
		textNombre.setForeground(Color.WHITE);
		textNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNombre.setColumns(10);
		textNombre.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textNombre.setBackground(new Color(102, 255, 102));
		textNombre.setBounds(694, 287, 174, 18);
		contentPanel.add(textNombre);

		textDimensiones = new JTextField();
		textDimensiones.setOpaque(false);
		textDimensiones.setForeground(Color.WHITE);
		textDimensiones.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDimensiones.setColumns(10);
		textDimensiones.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textDimensiones.setBackground(new Color(102, 255, 102));
		textDimensiones.setBounds(1225, 292, 174, 18);
		contentPanel.add(textDimensiones);

		textPeso = new JTextField();
		textPeso.setOpaque(false);
		textPeso.setForeground(Color.WHITE);
		textPeso.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPeso.setColumns(10);
		textPeso.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textPeso.setBackground(new Color(102, 255, 102));
		textPeso.setBounds(1225, 365, 174, 18);
		contentPanel.add(textPeso);

		textColor = new JTextField();
		textColor.setEnabled(false);
		textColor.setOpaque(false);
		textColor.setForeground(Color.WHITE);
		textColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		textColor.setColumns(10);
		textColor.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textColor.setBackground(new Color(102, 255, 102));
		textColor.setBounds(279, 786, 174, 18);
		contentPanel.add(textColor);

		textFabricante = new JTextField();
		textFabricante.setEnabled(false);
		textFabricante.setOpaque(false);
		textFabricante.setForeground(Color.WHITE);
		textFabricante.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFabricante.setColumns(10);
		textFabricante.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textFabricante.setBackground(new Color(102, 255, 102));
		textFabricante.setBounds(279, 865, 174, 18);
		contentPanel.add(textFabricante);

		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setForeground(Color.WHITE);
		lblFabricante.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblFabricante.setBounds(104, 834, 174, 68);
		contentPanel.add(lblFabricante);

		lblJuguete = new JLabel("JUGUETE");
		lblJuguete.setForeground(Color.WHITE);
		lblJuguete.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblJuguete.setBounds(815, 511, 312, 58);
		contentPanel.add(lblJuguete);

		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setForeground(Color.WHITE);
		lblMaterial.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblMaterial.setBounds(720, 597, 163, 68);
		contentPanel.add(lblMaterial);

		JLabel lblArticulable = new JLabel("Articulable");
		lblArticulable.setForeground(Color.WHITE);
		lblArticulable.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblArticulable.setBounds(707, 676, 201, 68);
		contentPanel.add(lblArticulable);

		JLabel lblPegi = new JLabel("Pegi");
		lblPegi.setForeground(Color.WHITE);
		lblPegi.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblPegi.setBounds(705, 755, 163, 68);
		contentPanel.add(lblPegi);

		JLabel lblPilas = new JLabel("Pilas");
		lblPilas.setForeground(Color.WHITE);
		lblPilas.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblPilas.setBounds(707, 847, 163, 68);
		contentPanel.add(lblPilas);

		comboArticulable = new JComboBox();
		comboArticulable.setModel(new DefaultComboBoxModel(new String[] { "SI", "NO" }));
		comboArticulable.setEnabled(false);
		comboArticulable.setForeground(Color.WHITE);
		comboArticulable.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboArticulable.setBackground(Color.DARK_GRAY);
		comboArticulable.setBounds(918, 691, 130, 46);
		comboArticulable.setSelectedIndex(-1);
		contentPanel.add(comboArticulable);

		comboPegi = new JComboBox();
		comboPegi.setModel(new DefaultComboBoxModel(new String[] { "3", "7", "12", "16", "18" }));
		comboPegi.setEnabled(false);
		comboPegi.setForeground(Color.WHITE);
		comboPegi.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboPegi.setBackground(Color.DARK_GRAY);
		comboPegi.setBounds(918, 770, 130, 46);
		comboPegi.setSelectedIndex(-1);
		contentPanel.add(comboPegi);

		comboPilas = new JComboBox();
		comboPilas.setModel(new DefaultComboBoxModel(new String[] { "SI", "NO" }));
		comboPilas.setEnabled(false);
		comboPilas.setForeground(Color.WHITE);
		comboPilas.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboPilas.setBackground(Color.DARK_GRAY);
		comboPilas.setBounds(918, 865, 130, 46);
		comboPilas.setSelectedIndex(-1);
		contentPanel.add(comboPilas);

		textMaterial = new JTextField();
		textMaterial.setEnabled(false);
		textMaterial.setOpaque(false);
		textMaterial.setForeground(Color.WHITE);
		textMaterial.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMaterial.setColumns(10);
		textMaterial.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textMaterial.setBackground(new Color(102, 255, 102));
		textMaterial.setBounds(866, 630, 174, 18);
		contentPanel.add(textMaterial);

		lblSeriePeli = new JLabel("SERIE / PELICULA");
		lblSeriePeli.setForeground(Color.WHITE);
		lblSeriePeli.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblSeriePeli.setBounds(1403, 511, 312, 58);
		contentPanel.add(lblSeriePeli);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblGenero.setBounds(1344, 580, 163, 68);
		contentPanel.add(lblGenero);

		JLabel lblLanzamiento = new JLabel("Lanzamiento");
		lblLanzamiento.setForeground(Color.WHITE);
		lblLanzamiento.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblLanzamiento.setBounds(1344, 659, 231, 68);
		contentPanel.add(lblLanzamiento);

		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setForeground(Color.WHITE);
		lblIdioma.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblIdioma.setBounds(1344, 738, 163, 68);
		contentPanel.add(lblIdioma);

		JLabel lblSubtitulado = new JLabel("Subtitulado");
		lblSubtitulado.setForeground(Color.WHITE);
		lblSubtitulado.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblSubtitulado.setBounds(1348, 808, 231, 68);
		contentPanel.add(lblSubtitulado);

		JLabel lblGenero_4 = new JLabel("Duracion");
		lblGenero_4.setForeground(Color.WHITE);
		lblGenero_4.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblGenero_4.setBounds(1344, 887, 163, 68);
		contentPanel.add(lblGenero_4);

		textIdioma = new JTextField();
		textIdioma.setEnabled(false);
		textIdioma.setOpaque(false);
		textIdioma.setForeground(Color.WHITE);
		textIdioma.setFont(new Font("Tahoma", Font.BOLD, 14));
		textIdioma.setColumns(10);
		textIdioma.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textIdioma.setBackground(new Color(102, 255, 102));
		textIdioma.setBounds(1585, 769, 174, 18);
		contentPanel.add(textIdioma);

		comboSubtitulado = new JComboBox();
		comboSubtitulado.setModel(new DefaultComboBoxModel(new String[] { "SI ", "NO" }));
		comboSubtitulado.setEnabled(false);
		comboSubtitulado.setForeground(Color.WHITE);
		comboSubtitulado.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboSubtitulado.setBackground(Color.DARK_GRAY);
		comboSubtitulado.setBounds(1605, 825, 130, 46);
		comboSubtitulado.setSelectedIndex(-1);
		contentPanel.add(comboSubtitulado);

		textDuracion = new JTextField();
		textDuracion.setEnabled(false);
		textDuracion.setOpaque(false);
		textDuracion.setForeground(Color.WHITE);
		textDuracion.setFont(new Font("Tahoma", Font.BOLD, 14));
		textDuracion.setColumns(10);
		textDuracion.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textDuracion.setBackground(new Color(102, 255, 102));
		textDuracion.setBounds(1585, 918, 174, 18);
		contentPanel.add(textDuracion);

		JLabel lblTejido = new JLabel("Tejido");
		lblTejido.setForeground(Color.WHITE);
		lblTejido.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblTejido.setBounds(104, 676, 163, 68);
		contentPanel.add(lblTejido);

		textTejido = new JTextField();
		textTejido.setEnabled(false);
		textTejido.setOpaque(false);
		textTejido.setForeground(Color.WHITE);
		textTejido.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTejido.setColumns(10);
		textTejido.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textTejido.setBackground(new Color(102, 255, 102));
		textTejido.setBounds(279, 711, 174, 18);
		contentPanel.add(textTejido);

		btnAñadir = new JButton("AÑADIR ");
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.setBackground(new Color(102, 255, 153));
		btnAñadir.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnAñadir.setBounds(163, 225, 200, 50);
		btnAñadir.addActionListener(this);
		contentPanel.add(btnAñadir);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnModificar.setBackground(new Color(102, 255, 153));
		btnModificar.setBounds(163, 320, 200, 50);
		btnModificar.addActionListener(this);
		contentPanel.add(btnModificar);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnBorrar.setBackground(new Color(102, 255, 153));
		btnBorrar.setBounds(163, 418, 200, 50);
		btnBorrar.addActionListener(this);
		contentPanel.add(btnBorrar);

		textGenero = new JTextField();
		textGenero.setOpaque(false);
		textGenero.setForeground(Color.WHITE);
		textGenero.setFont(new Font("Tahoma", Font.BOLD, 14));
		textGenero.setEnabled(false);
		textGenero.setColumns(10);
		textGenero.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(102, 255, 102)));
		textGenero.setBackground(new Color(102, 255, 102));
		textGenero.setBounds(1573, 614, 174, 18);
		contentPanel.add(textGenero);

		comboCodigos = new JComboBox();
		comboCodigos.setSelectedIndex(-1);
		comboCodigos.setForeground(Color.WHITE);
		comboCodigos.setFont(new Font("Jokerman", Font.BOLD, 14));
		comboCodigos.setBackground(Color.DARK_GRAY);
		comboCodigos.setBounds(1386, 202, 209, 46);
		cargarComboCodigo();
		contentPanel.add(comboCodigos);

		lblCodigoParaBorrar = new JLabel("Codigo de productos");
		lblCodigoParaBorrar.setForeground(new Color(255, 153, 102));
		lblCodigoParaBorrar.setFont(new Font("Jokerman", Font.PLAIN, 25));
		lblCodigoParaBorrar.setBounds(1386, 131, 349, 68);
		contentPanel.add(lblCodigoParaBorrar);

		btnLimpiar = new JButton("LIMPIAR ");
		btnLimpiar.setFont(new Font("Jokerman", Font.BOLD, 20));
		btnLimpiar.setBackground(new Color(102, 255, 153));
		btnLimpiar.setBounds(1648, 198, 163, 50);
		btnLimpiar.addActionListener(this);
		contentPanel.add(btnLimpiar);

	}

	protected void tipoElegido() {
		if (comboTipo.getSelectedIndex() > -1) {
			lineaRopa();
			juguete();
			serie_Pelicula();
		}

	}

	public void lineaRopa() {
		if (comboTipo.getSelectedItem().equals("LINEA DE ROPA")) {
			comboTalla.setEnabled(true);
			textTejido.setEnabled(true);
			textColor.setEnabled(true);
			textFabricante.setEnabled(true);
			lblLinea.setForeground(Color.yellow);

		} else {
			comboTalla.setEnabled(false);
			textTejido.setEnabled(false);
			textColor.setEnabled(false);
			textFabricante.setEnabled(false);
			lblLinea.setForeground(Color.white);
			limpiarCampos();
		}
	}

	public void juguete() {
		if (comboTipo.getSelectedItem().equals("JUGUETE")) {
			textMaterial.setEnabled(true);
			comboArticulable.setEnabled(true);
			comboPilas.setEnabled(true);
			comboPegi.setEnabled(true);
			lblJuguete.setForeground(Color.yellow);
		} else {
			textMaterial.setEnabled(false);
			comboArticulable.setEnabled(false);
			comboPilas.setEnabled(false);
			comboPegi.setEnabled(false);
			lblJuguete.setForeground(Color.white);
			limpiarCampos();
		}
	}

	public void serie_Pelicula() {
		if (comboTipo.getSelectedItem().equals("PELICULA/SERIE")) {
			textIdioma.setEnabled(true);
			textDuracion.setEnabled(true);
			textGenero.setEnabled(true);
			comboSubtitulado.setEnabled(true);
			lblSeriePeli.setForeground(Color.YELLOW);

		} else {
			textIdioma.setEnabled(false);
			textDuracion.setEnabled(false);
			textGenero.setEnabled(false);
			comboSubtitulado.setEnabled(false);
			lblSeriePeli.setForeground(Color.white);
			limpiarCampos();
		}
	}

	public void limpiarCampos() {
		textColor.setText("");
		textFabricante.setText("");
		textIdioma.setText("");
		textDuracion.setText("");
		textMaterial.setText("");
		textTejido.setText("");
		textGenero.setText("");
		comboArticulable.setSelectedIndex(-1);
		comboPegi.setSelectedIndex(-1);
		comboPilas.setSelectedIndex(-1);
		comboSubtitulado.setSelectedIndex(-1);
		comboTalla.setSelectedIndex(-1);
	}

	public void limpiarTodosLosCampos() {
		limpiarCampos();
		textNumEstancias.setText("");
		textDimensiones.setText("");
		textNombre.setText("");
		textPeso.setText("");
		comboTipo.setSelectedIndex(-1);
		textPrecio.setText("");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAñadir)) {
			añadirProducto();
		} else if (e.getSource().equals(btnModificar)) {
			modificarProducto();
		} else if (e.getSource().equals(btnBorrar)) {
			borrarProducto();
			limpiarCampos();
			limpiarTodosLosCampos();
		} else if (e.getSource().equals(btnLimpiar)) {
			comboCodigos.setSelectedIndex(-1);
			limpiarCampos();
			limpiarTodosLosCampos();
		}
	}

	private Producto modificarProducto() {
		DBImplementacion bd = new ControladorBdImplementacion();
		Producto prod = null;
		if (comboCodigos.getSelectedIndex() > -1) {
			prod = bd.recogerProductoId(comboCodigos.getSelectedItem().toString());
			textNombre.setText(prod.getNombre());
			textPrecio.setText(Float.toString(prod.getPrecio()));
			textNumEstancias.setText(Integer.toString(prod.getNumExistencias()));
			textPeso.setText(Float.toString(prod.getPeso()));
			textDimensiones.setText(prod.getDimensiones());
			if (prod.getCodigoProducto().charAt(0) == 'L') {
				prod = bd.recogerLineaRopaId(comboCodigos.getSelectedItem().toString());
				comboTalla.setSelectedItem(((Linea_De_Ropa) prod).getTalla());
				textTejido.setText(((Linea_De_Ropa) prod).getTejido());
				textColor.setText(((Linea_De_Ropa) prod).getColor());
				textFabricante.setText(((Linea_De_Ropa) prod).getFabricante());
			} else if (prod.getCodigoProducto().charAt(0) == 'J') {
				prod =bd.recogerJugueteId(comboCodigos.getSelectedItem().toString());
				textMaterial.setText(((Juguete) prod).getMaterial());
				comboArticulable.setSelectedItem(((Juguete) prod).getArticulable());
				comboPegi.setSelectedItem(((Juguete) prod).getEdadMinima());
				comboPilas.setSelectedItem(((Juguete) prod).getPilas());
			}else  {
				prod =bd.recogerPeliculasId(comboCodigos.getSelectedItem().toString());
			}
		} else {
			JOptionPane.showMessageDialog(btnModificar, "NO HAS ELEGIDO NINGUN CODIGO DE ARTICULO!");
		}
		return prod;

	}

	private void borrarProducto() {
		DBImplementacion bd = new ControladorBdImplementacion();
		Producto prod = bd.recogerProductoId(comboCodigos.getSelectedItem().toString());
		if (comboCodigos.getSelectedIndex() > -1) {
			if (prod != null) {
				bd.eliminarProducto(prod);
				JOptionPane.showMessageDialog(btnAñadir, "SE HA DADO DE BAJA AL PRODUCTO!");
				comboCodigos.setSelectedIndex(-1);
			}
		} else {
			JOptionPane.showMessageDialog(this, "NO HAS ELEGIDO NINGUN CODIGO TODAVIA!");
		}
	}

	private void añadirProducto() {
		Producto prod;
		DBImplementacion bd = new ControladorBdImplementacion();
		boolean pre = bd.validarFloat(textPrecio.getText()), peso = bd.validarFloat(textPeso.getText());
		boolean exis = bd.validarFloat(textNumEstancias.getText());
		if (textNumEstancias.getText().equals("") || textPrecio.getText().equals("") || textNombre.getText().equals("")
				|| textDimensiones.getText().equals("") || textPeso.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR!");

		} else {
			if (pre != false) {
				if (exis != false) {
					if (peso != false) {
						if (comboTipo.getSelectedIndex() > -1) {

							bd = new ControladorBdImplementacion();
							if (comboTipo.getSelectedItem().toString().equals("LINEA DE ROPA")) {
								if (comboTalla.getSelectedIndex() == -1 || textTejido.getText().equals("")
										|| textColor.getText().equals("") || textFabricante.getText().equals("")) {
									JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR!");
								} else {
									prod = new Linea_De_Ropa();
									prod.setCodigoProducto(generarCodigo(prod));
									prod.setNombre(textNombre.getText());
									prod.setPrecio(Float.parseFloat(textPrecio.getText()));
									prod.setNumExistencias(Integer.parseInt(textNumEstancias.getText()));
									prod.setDimensiones(textDimensiones.getText());
									prod.setPeso(Float.parseFloat(textPeso.getText()));
									((Linea_De_Ropa) prod).setTalla(comboTalla.getSelectedItem().toString());
									((Linea_De_Ropa) prod).setTejido(textTejido.getText());
									((Linea_De_Ropa) prod).setColor(textColor.getText());
									((Linea_De_Ropa) prod).setFabricante(textFabricante.getText());
									bd.insertarProducto(prod);
									limpiarTodosLosCampos();
									JOptionPane.showMessageDialog(this, "PRODUCTO INTRODUCIDO CORRECTAMENTE!");
								}

							} else if (comboTipo.getSelectedItem().toString().equals("JUGUETE")) {
								if (textMaterial.getText().equals("") || comboArticulable.getSelectedIndex() == -1
										|| comboPegi.getSelectedIndex() == -1 || comboPilas.getSelectedIndex() == -1) {
									JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR!");
								} else {
									prod = new Juguete();
									prod.setCodigoProducto(generarCodigo(prod));
									prod.setNombre(textNombre.getText());
									prod.setPrecio(Float.parseFloat(textPrecio.getText()));
									prod.setNumExistencias(Integer.parseInt(textNumEstancias.getText()));
									prod.setDimensiones(textDimensiones.getText());
									prod.setPeso(Float.parseFloat(textPeso.getText()));
									((Juguete) prod).setMaterial(textMaterial.getText());
									((Juguete) prod).setArticulable(comboArticulable.getSelectedItem().toString());

									((Juguete) prod)
											.setEdadMinima(Integer.parseInt(comboPegi.getSelectedItem().toString()));
									((Juguete) prod).setPilas(comboPilas.getSelectedItem().toString());

									bd.insertarProducto(prod);
									limpiarTodosLosCampos();
									JOptionPane.showMessageDialog(this, "PRODUCTO INTRODUCIDO CORRECTAMENTE!");
								}
							} else if (comboTipo.getSelectedItem().toString().equals("PELICULA/SERIE")) {
								if (textGenero.getText().equals("") || textIdioma.getText().equals("")
										|| textIdioma.getText().equals("") || comboSubtitulado.getSelectedIndex() == -1
										|| comboPegi.getSelectedIndex() == -1) {
									JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR!");
								} else {
									prod = new Pelicula_Serie();
									prod.setCodigoProducto(generarCodigo(prod));
									prod.setNombre(textNombre.getText());
									prod.setPrecio(Float.parseFloat(textPrecio.getText()));
									prod.setNumExistencias(Integer.parseInt(textNumEstancias.getText()));
									prod.setDimensiones(textDimensiones.getText());
									prod.setPeso(Float.parseFloat(textPeso.getText()));
									((Pelicula_Serie) prod).setGenero(textGenero.getText());
									((Pelicula_Serie) prod).setFechaLanzamiento(null);
									((Pelicula_Serie) prod).setIdioma(textIdioma.getText());
									if (comboSubtitulado.getSelectedItem().equals("SI")) {
										((Pelicula_Serie) prod).setSubtitulado(true);
									} else {
										((Pelicula_Serie) prod).setSubtitulado(false);
									}
									((Pelicula_Serie) prod).setDuracion(textDuracion.getText());
									bd.insertarProducto(prod);
									JOptionPane.showMessageDialog(this, "PRODUCTO INTRODUCIDO CORRECTAMENTE!");
									limpiarTodosLosCampos();
								}

							}

						} else {
							JOptionPane.showMessageDialog(this, "DEBES ELEGIR UN TIPO!");
						}
					} else {
						JOptionPane.showMessageDialog(this, "EL PESO DEBE SER UN NUMERO!");
					}
				} else {
					JOptionPane.showMessageDialog(this, "EL NUMERO DE EXISTENCIAS DEBE DE SER UN NUMERO!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "EL PRECIO DEBE SER UN NUMERO!");
			}

		}

	}

	public String generarCodigo(Producto prod) {
		DBImplementacion bd = new ControladorBdImplementacion();

		String codigo = "", num;
		int numero;
		numero = bd.numeroProducto(prod) + 1;
		if (prod instanceof Linea_De_Ropa) {
			codigo = "L" + String.format("%03d", numero);
		} else if (prod instanceof Juguete) {
			codigo = "J" + String.format("%03d", numero);
		} else {
			codigo = "P" + String.format("%03d", numero);
		}

		return codigo;
	}

	public void cargarComboCodigo() {
		DBImplementacion db = new ControladorBdImplementacion();
		ArrayList<Producto> codProd = db.recogerProductos();
		comboCodigos.removeAllItems();

		for (Producto prod : codProd) {
			comboCodigos.addItem(prod.getCodigoProducto());
		}
		comboCodigos.setSelectedIndex(-1);
	}
}
