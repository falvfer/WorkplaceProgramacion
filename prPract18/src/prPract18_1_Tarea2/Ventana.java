package prPract18_1_Tarea2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1428479032774116479L;
	
	public JButton bAceptar, bCancelar;
	public JLabel lMensaje;
	public JTextField tfUsuario;
	public JPasswordField tfPassword;
	
	public Ventana() {
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		
		JPanel principal = new JPanel(new BorderLayout());
			principal.setBorder(new EmptyBorder(15, 15, 15, 15));
			cp.add(principal);

		JPanel grid = new JPanel(new GridLayout(2,3,5,5));
			principal.add(grid);
		
		JLabel lUsuario = new JLabel("Usuario", JLabel.RIGHT);
			grid.add(lUsuario);
		tfUsuario = new JTextField();
			grid.add(tfUsuario);
			
		bAceptar = new JButton("Aceptar");
			grid.add(bAceptar);
		
		JLabel lPassword = new JLabel("Password", JLabel.RIGHT);
			grid.add(lPassword);
		tfPassword = new JPasswordField();
			grid.add(tfPassword);
		
		bCancelar = new JButton("Cancelar");
			grid.add(bCancelar);
		
		lMensaje = new JLabel("Introduzca usuario y clave");
			lMensaje.setHorizontalAlignment(SwingConstants.CENTER);
			principal.add(lMensaje, BorderLayout.SOUTH);
		
	}
	
}
