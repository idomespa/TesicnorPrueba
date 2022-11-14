package es.dominguez.inigo.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.dominguez.inigo.clases.Peliculas;
import es.dominguez.inigo.db.Insertar;
import es.dominguez.inigo.db.Obtener;
import es.dominguez.inigo.json.Conexion;
import es.dominguez.inigo.json.ObtainJSON;
import es.dominguez.inigo.main.Principal;

/*
 * 	Clase extendida de JFrame para mostrar un textfield, por el cual pasar la url del JSON
 * 
 * @author Iñigo Dominguez
 * @date 14-11-2022	
 */
public class ObtenerYRellenar extends JFrame{

	private static final long serialVersionUID = -326616039173382091L;
	private JPanel contentPane;
	private static ArrayList<Peliculas> peli;
	private JTextField textField;

	public ObtenerYRellenar(Conexion con) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Obtener JSON");
		setBounds(100, 100, 527, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Obtener JSON");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ObtainJSON ob = new ObtainJSON();
				ArrayList<Peliculas> pel = ob.obtieneJson(textField.getText());
				Obtener obt = new Obtener();
				peli=obt.listarPelis(con);
				con.Desconectar();
				boolean var=false;
				for(int i=0;i<pel.size();i++){
					for(int j=0;j<peli.size();j++){
						if (peli.get(j).getImdbID().equals(pel.get(i).getImdbID())) {
							var=true;
							
						}
					}
					if(var ==false) {
						Insertar insertar = new Insertar();
						insertar.insertar(con, 
								pel.get(i).getTitle(), 
								pel.get(i).getYear(), 
								pel.get(i).getType(), 
								pel.get(i).getImdbID(), 
								pel.get(i).getPoster());
						con.Desconectar();
					}
					
				}
				if (var==true) {
					Principal.mostrar("Ese registro ya existe");

				}else {
					Principal.mostrar("Insertadas correctamente");
					Obtener obts = new Obtener();
					peli.clear();
					peli=obts.listarPelis(con);
					con.Desconectar();
					Principal.rellenarTabla(con, peli);
				}
			}
		});
		btnNewButton.setBounds(161, 151, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("URL, para obtener JSON");
		lblNewLabel.setBounds(65, 58, 200, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(65, 86, 427, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}
}
