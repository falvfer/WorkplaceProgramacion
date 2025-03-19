package prPract18_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Ejer2 extends JFrame {

	private static final long serialVersionUID = -1829917949583413180L;

	JLabel lPuntos;
	JTextField tDadoJ1;
	JTextField tDadoJ2;
	JTextField tDadoR1;
	JTextField tDadoR2;
	
	public Ejer2() {
		// Contenedor y Frame principal
		this.setTitle("Jugar a los Dados");
		Container cp = this.getContentPane();
		
		JPanel principal = new JPanel(new BorderLayout());
			principal.setBorder(new EmptyBorder(5, 5, 5, 5));
			cp.add(principal);
		
		// Recursos a usar luego
		Font fPuntos = new Font("Comic Sans MS", Font.BOLD, 16);
		LineBorder borderLinea = new LineBorder(Color.decode("#c3d5e7"),1);
		CompoundBorder[] borderApuestas = {
				new CompoundBorder(
						new TitledBorder(borderLinea,"Apuesta Jugador"),
						new BevelBorder(BevelBorder.RAISED)),
				new CompoundBorder(
						new TitledBorder(borderLinea,"Resultado"),
						new BevelBorder(BevelBorder.RAISED))
		};
		TitledBorder[] borderDados = {
				new TitledBorder(borderLinea, "Dado 1"),
				new TitledBorder(borderLinea, "Dado 2")
		};
		Font fDados = new Font("Comic Sans MS", Font.BOLD, 16);
		
		// Controlador para el botón (ActionListener)
		ControladorLanzar cl = new ControladorLanzar();
			
		// Parte Norte (Contador de puntos)
		JPanel panelPuntos = new JPanel(new BorderLayout(15,15));
			principal.add(panelPuntos, BorderLayout.NORTH);
			JLabel lTxtPuntos = new JLabel("Puntos obtenidos:");
				lTxtPuntos.setFont(fPuntos);
				lTxtPuntos.setForeground(Color.RED);
				lTxtPuntos.setHorizontalAlignment(SwingConstants.RIGHT);
				panelPuntos.add(lTxtPuntos, BorderLayout.CENTER);
			lPuntos = new JLabel("0");
				lPuntos.setFont(fPuntos);
				lPuntos.setForeground(Color.RED);
				panelPuntos.add(lPuntos, BorderLayout.EAST);
				
		// Parte Centro (Dados de Jugador y Resultado)
		JPanel panelCentro = new JPanel(new GridLayout(1,2,5,5));
			principal.add(panelCentro, BorderLayout.CENTER);
			JPanel pJugador = new JPanel(new GridLayout(2,1));
				pJugador.setBorder(borderApuestas[0]);
				panelCentro.add(pJugador);
				tDadoJ1 = new JTextField(9);
					tDadoJ1.setBorder(borderDados[0]);
					tDadoJ1.setBackground(UIManager.getColor("Panel.Background"));
					tDadoJ1.setFont(fDados);
					pJugador.add(tDadoJ1);
				tDadoJ2 = new JTextField(9);
					tDadoJ2.setBorder(borderDados[1]);
					tDadoJ2.setBackground(UIManager.getColor("Panel.Background"));
					tDadoJ2.setFont(fDados);
					pJugador.add(tDadoJ2);
			JPanel pResultado = new JPanel(new GridLayout(2,1));
				pResultado.setBorder(borderApuestas[1]);
				panelCentro.add(pResultado);
				tDadoR1 = new JTextField(9);
					tDadoR1.setEditable(false);
					tDadoR1.setBorder(borderDados[0]);
					tDadoR1.setBackground(UIManager.getColor("Panel.Background"));
					tDadoR1.setFont(fDados);
					pResultado.add(tDadoR1);
				tDadoR2 = new JTextField(9);
					tDadoR2.setEditable(false);
					tDadoR2.setBorder(borderDados[1]);
					tDadoR2.setBackground(UIManager.getColor("Panel.Background"));
					tDadoR2.setFont(fDados);
					pResultado.add(tDadoR2);
		
		// Parte Sur (Botón de Lanzar los dados y comprobar el resultado)
		JPanel pBoton = new JPanel(new FlowLayout());
			principal.add(pBoton, BorderLayout.SOUTH);
			JButton bLanzar = new JButton("Lanzar dados",
										new ImageIcon("recursos/dados1x50.png"));
				bLanzar.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED),
													new EmptyBorder(5, 5, 5, 5)));
				bLanzar.addActionListener(cl);
				pBoton.add(bLanzar);
			
	}
	
	
	public static void main(String[] args) {
		Ejer2 v = new Ejer2();
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLocationRelativeTo(null);
	}
	
	class ControladorLanzar implements ActionListener {
		
		private static Random rdn = new Random();

		@Override
		public void actionPerformed(ActionEvent e) {
			//lPuntos; tDadoJ1; tDadoJ2; tDadoR1; tDadoR2;
			boolean haFallado = false;
			int[] dJugador = new int[2];
			int resultado = 0;
			try {
				dJugador[0] = Integer.parseInt(tDadoJ1.getText());
				dJugador[1] = Integer.parseInt(tDadoJ2.getText());
				for (int num: dJugador)
					if (num > 6 || num < 1)
						throw new Exception();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Debe introducir dos números entre 1 y 6");
				haFallado = true;
			}
			if (!haFallado) {
				int[] dResultado = {rdn.nextInt(1,7), rdn.nextInt(1,7)};
				tDadoR1.setText(dResultado[0]+"");
				tDadoR2.setText(dResultado[1]+"");
				
				if (dJugador[0] == dResultado[0])
					if (dJugador[1] == dResultado[1])
						resultado = 25;
					else
						resultado = 10;
				else if (dJugador[0] == dResultado[1])
					if (dJugador[1] == dResultado[0])
						resultado = 25;
					else
						resultado = 10;
				else if (dJugador[1] == dResultado[0] || dJugador[1] == dResultado[1])
					resultado = 10;
				else
					resultado = -5;
				
				lPuntos.setText((Integer.parseInt(lPuntos.getText())+resultado)+"");
			}
		}
		
	}
}
