package es.dominguez.inigo.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.dominguez.inigo.clases.Peliculas;
import es.dominguez.inigo.db.Filtrar;
import es.dominguez.inigo.json.Conexion;
import es.dominguez.inigo.main.Principal;

/*
 * 	Clase extendida de JFrame para mostrar un Combo con la busqueda y un textfield,
 * 	el cual contendra los datos a buscar.
 * 
 * @author Iñigo Dominguez
 * @date 14-11-2022	
 */
public class Filtracion extends JFrame {

	private static final long serialVersionUID = 522817177582716650L;
	private JTextField txtBuscar;
	private JPanel contentPane;
	private static ArrayList<Peliculas> peli;


	/**
	 * Initialize the contents of the frame.
	 */
	public Filtracion(Conexion con) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Detalles");
		setBounds(100, 100, 527, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(49, 89, 129, 27);
		comboBox.addItem("Titulo");
		comboBox.addItem("Year");
		comboBox.addItem("type");
		comboBox.addItem("imdbID");
		comboBox.addItem("Poster");
		comboBox.addItem("valoracion");
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Filtrar fl = new Filtrar();
					peli = fl.filtrarLista(con, comboBox.getSelectedItem().toString(), txtBuscar.getText()); 
					con.Desconectar();
					Principal.rellenarTabla(con,peli);
					con.Desconectar();
			}
		});
		btnNewButton.setBounds(149, 141, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Filtrar por:");
		lblNewLabel.setBounds(49, 61, 71, 16);
		contentPane.add(lblNewLabel);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(206, 88, 171, 26);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Texto a buscar:");
		lblNewLabel_1.setBounds(208, 61, 97, 16);
		contentPane.add(lblNewLabel_1);
	}
}
