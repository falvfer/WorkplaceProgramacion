package prPract18_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejer1 extends JFrame {

	private static final long serialVersionUID = -1829917949583413180L;
	
	JTextArea logs;
	
	public Ejer1() {
		ControladorLogs cl = new ControladorLogs();
		this.setTitle("Ejemplo con FocusListener");
		Container cp = this.getContentPane();
		
		JPanel principal = new JPanel(new BorderLayout());
			cp.add(principal);
			
		JPanel gridCenter = new JPanel(new GridLayout(2,1));
			principal.add(gridCenter, BorderLayout.CENTER);
		JPanel flowNorth = new JPanel(new FlowLayout());
			principal.add(flowNorth, BorderLayout.NORTH);
			
		JTextField campoTexto = new JTextField("Campo de texto");
			campoTexto.addFocusListener(cl);
			flowNorth.add(campoTexto);
		JLabel etiqueta = new JLabel("Una etiqueta");
			etiqueta.addFocusListener(cl);
			flowNorth.add(etiqueta);
		String[] itemsSel = new String[10];
			for (int i = 0; i<itemsSel.length; i++)
				itemsSel[i] = "Selecciona item #"+(i+1);
			JComboBox<String> selecciona = new JComboBox<>(itemsSel);
			selecciona.addFocusListener(cl);
				flowNorth.add(selecciona);
		JButton boton = new JButton("Botón");
			boton.addFocusListener(cl);
			flowNorth.add(boton);
			
		StringBuilder itemsLis = new StringBuilder();
			for (int i = 0; i<20; i++)
				itemsLis.append("Lista item #"+(i+1)+"\n");
			JTextArea lista = new JTextArea(itemsLis.toString());
				lista.setFont(new Font("", Font.BOLD, 12));
				lista.setEditable(false);
				lista.addFocusListener(cl);
				JScrollPane spLista = new JScrollPane(lista);
					spLista.setPreferredSize(new Dimension(WIDTH, 150));
					gridCenter.add(spLista);
			
		logs = new JTextArea();
			logs.setEditable(false);
			logs.addFocusListener(cl);
			JScrollPane spLogs = new JScrollPane(logs);
				spLogs.setPreferredSize(new Dimension(WIDTH, 150));
				gridCenter.add(spLogs);
	}
	
	
	public static void main(String[] args) {
		Ejer1 v = new Ejer1();
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ControladorLogs implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			logs.setText(logs.getText() + "Foco ganado: " + e.getComponent().toString() + "\n");
		}

		@Override
		public void focusLost(FocusEvent e) {
			logs.setText(logs.getText() + "Foco perdido: " + e.getComponent().toString() + "\n");
		}
	}
}
