package es.dominguez.inigo.main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import es.dominguez.inigo.clases.Peliculas;
import es.dominguez.inigo.db.Obtener;
import es.dominguez.inigo.interfaces.Filtracion;
import es.dominguez.inigo.interfaces.ObtenerYRellenar;
import es.dominguez.inigo.interfaces.valoracion;
import es.dominguez.inigo.json.Conexion;
import es.dominguez.inigo.json.Utils;
/*
 * 	Clase main
 * 
 * @author Iñigo Dominguez
 * @date 14-11-2022	
 */
public class Principal extends JFrame {

	private static final long serialVersionUID = -4352259477745249049L;
	private JPanel contentPane;
	private static JTable tabla;
	private static ArrayList<Peliculas> peli;
	public static Conexion con;
	private JButton btnNewButton_1;
	private static URI url;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		con = new Conexion();
		setTitle("Listado Pelicuas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(new Dimension(1000,550));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		tabla = new JTable();
		tabla.setBounds(139, 261, 300, 83);
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(70, 139, 894, 274);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tabla);
		
		JButton btnNewButton = new JButton("Modificar Valoración");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabla.getSelectedRow() != -1) {
					int row = tabla.getSelectedRow();
					String titulo = tabla.getValueAt(row, 0).toString();
					String id = tabla.getValueAt(row, 3).toString();
					int valor = Integer.parseInt(tabla.getValueAt(row, 5).toString());
					valoracion val = new valoracion(con,titulo,id,valor);
					val.setVisible(true);	
				}else {
					
					mostrar("Debe seleccionar una fila");
				}
			}
		});
		btnNewButton.setBounds(802, 426, 162, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Insertar Nuevo JSON");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObtenerYRellenar oBYR = new ObtenerYRellenar(con);
				oBYR.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(70, 426, 162, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Podemos Ordenar pulsando en cada Header");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel.setBounds(70, 120, 298, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Filtrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filtracion flt = new  Filtracion(con);
				flt.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(668, 426, 117, 29);
		contentPane.add(btnNewButton_2);

		Obtener ob= new Obtener();
		peli = ob.listarPelis(con);
		con.Desconectar();
		rellenarTabla(con,peli);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(WindowEvent winEvt) {
				con.Desconectar();
			}
		});
	}
/*
 * 	Creacion de la estructura del Jtable, en el cual pasamos los Headers, y le ponemos las opciones
 * 		sobre el model de JTABLE
 * 
 * @author Iñigo Dominguez
 * @date 14-11-2022	
 */
public static void displayResult(ArrayList<Peliculas> resultList) {
		

		try {
			
			Vector<String> tableHeaders = new Vector<String>();
			Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();
			tableHeaders.add("Titulo");
			tableHeaders.add("Año");
			tableHeaders.add("Tipo");
			tableHeaders.add("ImdbID");
			tableHeaders.add("Poster");
			tableHeaders.add("Valoracion");

			resultList.forEach((l) -> {
				Vector<Object> oneRow = new Vector<Object>();
				oneRow.add(l.getTitle());
				oneRow.add(l.getYear());
				oneRow.add(l.getType());
				
				oneRow.add(l.getImdbID());
				try {
					url = new URI(l.getPoster());
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				oneRow.add(url);
				oneRow.add(l.getValoracion());
				tableData.add(oneRow);
			});
			tabla.setModel(new DefaultTableModel(tableData, tableHeaders));
			tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
			tabla.getColumnModel().getColumn(1).setPreferredWidth(10);
			tabla.getColumnModel().getColumn(2).setPreferredWidth(15);
			tabla.getColumnModel().getColumn(3).setPreferredWidth(15);
			tabla.getColumnModel().getColumn(4).setPreferredWidth(60);
			tabla.getColumnModel().getColumn(5).setPreferredWidth(2);
			tabla.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
			centrar.setHorizontalAlignment(JLabel.CENTER);
			DefaultTableCellRenderer izq = new DefaultTableCellRenderer();
			centrar.setHorizontalAlignment(JLabel.LEFT);
			tabla.getColumnModel().getColumn(0).setCellRenderer(izq);
			tabla.getColumnModel().getColumn(4).setCellRenderer(izq);
			tabla.getColumnModel().getColumn(5).setCellRenderer(izq);
			tabla.setAutoCreateRowSorter(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			Utils.escribirLog("Error en la tabla de gestion de citas:" + e.getMessage());
		}
	}

/*
 * 	Metodo para rellenar datos en la tabla, pasandole un array de de objeto peliculas
 * 
 * @author Iñigo Dominguez
 * @date 14-11-2022	
 */
	public static void rellenarTabla(Conexion con,ArrayList<Peliculas> peli) {
		try {
			
			displayResult(peli);
			
		} catch (Exception e) {
		}
	}
	/*
	 * 	Metodo para usar JOptionPane pasandole por parametro un texto el cual mostrara
	 * 
	 * @author Iñigo Dominguez
	 * @date 14-11-2022	
	 */
	public static void mostrar(String text) {
		  JOptionPane.showOptionDialog(null, text, 
                "Aviso" , 
                JOptionPane.OK_OPTION, 
                JOptionPane.WARNING_MESSAGE, 
                null,    
                new Object[] { "Aceptar"},
                "SO");
	  }
}
