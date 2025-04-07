package Calculadora;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Vista extends JPanel {
	
	private JButton [] bDigitos;
	private JButton [] bOperaciones;
	private JButton bPunto, bIgual;
	private JTextField tfRdo;
	
	// Getters
	public JButton[] getbDigitos() {
		return bDigitos;
	}

	public JButton[] getbOperaciones() {
		return bOperaciones;
	}

	public JButton getbPunto() {
		return bPunto;
	}

	public JButton getbIgual() {
		return bIgual;
	}

	public JTextField getTfRdo() {
		return tfRdo;
	}
	
	/**
	 * Constructor
	 */
	
	public Vista() {
		
		JPanel panelPrincipal = new JPanel(new BorderLayout(5, 5));
		
		panelPrincipal.add(preparaPanelResultado(), BorderLayout.NORTH);
		panelPrincipal.add(preparaPanelCentro(), BorderLayout.CENTER);
		panelPrincipal.add(preparaPanelEste(), BorderLayout.EAST);
		
		this.add(panelPrincipal);
		
	}

	private JPanel preparaPanelResultado() {
		tfRdo = new JTextField(10);
		
		tfRdo.setEditable(false);
		tfRdo.setHorizontalAlignment(SwingConstants.RIGHT);
		tfRdo.setBackground(Color.WHITE);
				
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Resultado"));
		p.add(tfRdo);
		
		return p;		
	}

	private JPanel preparaPanelCentro() {
		this.bDigitos = new JButton[10];
		
		for(int i = 0; i<bDigitos.length; i++) {
			bDigitos[i] = new JButton(String.valueOf(i));
			bDigitos[i].setBackground(Color.CYAN);
			bDigitos[i].setBorder(new BevelBorder(BevelBorder.RAISED));			
		}
		
		this.bPunto = new JButton(".");
		this.bIgual = new JButton("=");
		
		JPanel p = new JPanel(new GridLayout(4,3));
		for(int i = 1; i < this.bDigitos.length; i++) {
			p.add(this.bDigitos[i]);
		}
		
		p.add(bPunto);
		p.add(bDigitos[0]);
		p.add(bIgual);
		
		return p;
	}
	
	private JPanel preparaPanelEste() {
		String [] operaciones = { "+", "-", "*", "/" };
		this.bOperaciones = new JButton[4];
		JPanel p = new JPanel(new GridLayout(4,1));
		Font fuente = new Font("Courier", Font.PLAIN, 16);
		
		for(int i = 0; i<bOperaciones.length; i++) {
			bOperaciones[i] = new JButton(" " + operaciones[i] + " ");
			bOperaciones[i].setFont(fuente);
			bOperaciones[i].setActionCommand(operaciones[i]);
			p.add(bOperaciones[i]);
		}
		
		return p;
		
	}
	
	public void control(Controlador ctr) {
        for(int i=0;i<this.bDigitos.length;i++) {
            bDigitos[i].addActionListener(ctr);
            bDigitos[i].addKeyListener(ctr);
            bDigitos[i].addFocusListener(ctr);
        }
        
        
        for(int i=0;i<this.bOperaciones.length;i++) {
            bOperaciones[i].addActionListener(ctr);
            bOperaciones[i].addKeyListener(ctr);
            bOperaciones[i].addFocusListener(ctr);
        }
        
        bPunto.addActionListener(ctr);
        bPunto.addKeyListener(ctr);
        bPunto.addFocusListener(ctr);
        
        bIgual.addActionListener(ctr);
        bIgual.addKeyListener(ctr);
        bIgual.addFocusListener(ctr);
        
        tfRdo.addKeyListener(ctr);
    }
	
}
