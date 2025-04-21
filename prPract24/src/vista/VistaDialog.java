package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VistaDialog extends JPanel {
	
	private static final long serialVersionUID = 3741673321396587557L;
	
	// Variables
	JComboBox<Byte> dimensiones;
	
	public VistaDialog() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		// Texto de arriba
		JPanel panelTexto = new JPanel(new GridLayout(3,1));
		panelTexto.add(new JLabel("A continuación debe seleccionar la dimensión que"));
		panelTexto.add(new JLabel("tendrá el cuadrado mágico, dicha dimensión deberá"));
		panelTexto.add(new JLabel("ser un número entero positivo e impar."));
		for (Component c: panelTexto.getComponents()) {
			c.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
			((JLabel)c).setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		panelPrincipal.add(panelTexto);
		
		// Selección de dimensión del cuadrado
		JPanel panelDimension = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelDimension.setBorder(new EmptyBorder(20,0,20,0));
		JLabel lDimension = new JLabel("Seleccione la dimensión del cuadrado");
		lDimension.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
		Byte[] arrDimensiones = {3,5,7,9,11,15};
		dimensiones = new JComboBox<Byte>(arrDimensiones);
		panelDimension.add(lDimension);
		panelDimension.add(dimensiones);
		panelPrincipal.add(panelDimension);
		
		// Botones
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton comenzar = new JButton("Comenzar");
		JButton salir = new JButton("Salir");
		panelBotones.add(comenzar);
		panelBotones.add(salir);
		panelPrincipal.add(panelBotones);
		
		this.add(panelPrincipal);
	}
}
