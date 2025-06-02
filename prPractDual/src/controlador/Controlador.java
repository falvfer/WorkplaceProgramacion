package controlador;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Caja;
import modelo.Expediente;
import modelo.Gestor;
import vista.VentanaBusqueda;

public class ControladorBusqueda implements ActionListener {

	private VentanaBusqueda v;
	private Gestor gestor;
	int ultContExp;
	
	public ControladorBusqueda(VentanaBusqueda v, Gestor gestor) {
		this.v = v;
		this.gestor = gestor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == v.getBuscarCaja())
			buscarCaja();
		else if (e.getSource() == v.getBuscarExpAnno())
			buscarExpAnno();
		else
			buscarExpediente(e);
		
	}
	
	private void buscarCaja() {
		Caja caj = null;
		boolean error = false;
		try {
			caj = gestor.findCaja(Integer.parseInt(v.getBusCaja().getText()));
		} catch (Exception e) {error = true;}
		
		if (caj instanceof Caja) {
			v.getpBordeExpedientes().remove(v.getpExpedientes());
			v.setpExpedientes(new JPanel(new FlowLayout(FlowLayout.LEFT)));
			v.getpBordeExpedientes().add(v.getpExpedientes());
			
			ultContExp = 0;
			for (Expediente exp: caj.getExpedientes()) {
				JButton bExp = new JButton(exp.getNumExpediente()+"/"+exp.getAnno());
				bExp.addActionListener(this);
				v.getpExpedientes().add(bExp);
				ultContExp++;
			}
			
			if (v.getpInformacion().isVisible())
				v.getpInformacion().setVisible(false);
			
			v.getpBordeExpedientes().setPreferredSize(new Dimension(370, 25+35*((ultContExp+3)/4)));
			if (!v.getpBordeExpedientes().isVisible())
				v.getpBordeExpedientes().setVisible(true);
			
			v.pack();
			v.setSize(400, 210+35*((ultContExp+3)/4));
			
		} else {
			if (error)
				JOptionPane.showMessageDialog(null, "Solamente se admiten datos numéricos",
						"Error en la búsqueda", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna caja",
						"Error en la búsqueda", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void buscarExpAnno() {
		Expediente exp = null;
		boolean error = false;
		try {
			exp = gestor.findExpediente(Short.parseShort(v.getBusExpediente().getText()),
										Short.parseShort(v.getBusAnno().getText()));
		} catch (Exception e) {error = true;}
		
		if (exp instanceof Expediente) {
			v.getInfCaja().setText(exp.getNumCaja()+"");
			v.getInfExpediente().setText(exp.getNumExpediente()+"");
			v.getInfFecha().setText(exp.getAnno()+"");
			v.getInfSeccion().setText(exp.getSeccion().toString()+"");
			v.getInfSubseccion().setText(exp.getSubseccion().toString()+"");
			v.getInfDescripcion().setText(exp.getDescripcion()+"");
			v.getInfNombres().setText(exp.getNombres()+"");
			
			if (v.getpBordeExpedientes().isVisible())
				v.getpBordeExpedientes().setVisible(false);
			if (!v.getpInformacion().isVisible())
				v.getpInformacion().setVisible(true);
			
			v.pack();
			v.setSize(400, 425);
			
		} else {
			if (error)
				JOptionPane.showMessageDialog(null, "Solamente se admiten datos numéricos",
						"Error en la búsqueda", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "No se ha encontrado ningún expediente",
						"Error en la búsqueda", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void buscarExpediente(ActionEvent e) {
		String[] datosExp = ((JButton)e.getSource()).getText().split("/");
		Expediente exp = gestor.findExpediente(Short.parseShort(datosExp[0]),
												Short.parseShort(datosExp[1]));
		
		v.getInfCaja().setText(exp.getNumCaja()+"");
		v.getInfExpediente().setText(exp.getNumExpediente()+"");
		v.getInfFecha().setText(exp.getAnno()+"");
		v.getInfSeccion().setText(exp.getSeccion().toString()+"");
		v.getInfSubseccion().setText(exp.getSubseccion().toString()+"");
		v.getInfDescripcion().setText(exp.getDescripcion()+"");
		v.getInfNombres().setText(exp.getNombres()+"");
		
		if (!v.getpInformacion().isVisible())
			v.getpInformacion().setVisible(true);
		
		v.pack();
		v.setSize(400, 455+35*((ultContExp+3)/4));
	}

}
