package es.dominguez.inigo.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import es.dominguez.inigo.clases.Peliculas;
import es.dominguez.inigo.db.Obtener;
import es.dominguez.inigo.db.Update;
import es.dominguez.inigo.json.Conexion;
import es.dominguez.inigo.main.Principal;


public class valoracion extends JFrame {

	private static final long serialVersionUID = -5924637590897179118L;
	private JPanel contentPane;
	private boolean resto;
	private static ArrayList<Peliculas> peli;



	public valoracion(Conexion con, String text,String id,int val) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Detalles");
		setBounds(100, 100, 527, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tituloP = new JLabel("");
		tituloP.setText(text);
		tituloP.setBounds(29, 29, 363, 16);
		contentPane.add(tituloP);
		
		JLabel lblNewLabel_1 = new JLabel("Valoración:");
		lblNewLabel_1.setBounds(60, 88, 84, 16);
		contentPane.add(lblNewLabel_1);
		
		SpinnerNumberModel model1 = new SpinnerNumberModel(val, 0, 5, 1);
		JSpinner spinner = new JSpinner(model1);
		spinner.setBounds(156, 78, 34, 26);
		contentPane.add(spinner);
		
		JButton btnNewButton = new JButton("Subir Valoración");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update up = new Update();
				int num = (Integer) spinner.getValue();
				System.out.println(num);
				con.Conectar();
				resto=up.insertar(con,num, id);
				con.Desconectar();

				if(resto) {
					Obtener ob= new Obtener();
					peli = ob.listarPelis(con);
					Principal.mostrar("Actualizacion de valoración");
					con.Conectar();
					Principal.rellenarTabla(con,peli);
					con.Desconectar();
					}
			}
		});
		btnNewButton.setBounds(254, 102, 138, 29);
		contentPane.add(btnNewButton);
	}
}
