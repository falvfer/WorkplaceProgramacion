package controlador;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bd.DAOCajas;
import bd.DAOExpedientes;
import modelo.Expediente;
import modelo.MiExcepcion;
import modelo.Persona;
import modelo.SubseccionExpediente;
import vista.Vista;

public class CTRBuscadores {

	public static void buscarCaja(Controlador ctr, boolean estado) {
		Vista v = ctr.getV();
		
		// Set donde guardar los expedientes de la caja
		SortedSet<Expediente> caja;
		
		// Buscar la caja
		try {
			caja = DAOCajas.findCaja(Integer.parseInt(v.getBusCaja().getText()));
		} catch (MiExcepcion e) { // Salir si no se ha encontrado o ha habido cualquier error
			JOptionPane.showMessageDialog(v, e.getMessage(),
					"Error en la búsqueda", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (caja.size() == 0) {
			if (estado)
				JOptionPane.showMessageDialog(v, "No hay cajas con ese número",
						"Error en la búsqueda", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// Crear un nuevo JPanel para añadir nuevos botones
		v.getpBordeExpedientes().remove(v.getpExpedientes());
		v.setpExpedientes(new JPanel(new FlowLayout(FlowLayout.LEFT)));
		v.getpBordeExpedientes().add(v.getpExpedientes());
		
		// Añadir todos los expedientes
		ctr.setUltContExp(0);
		for (Expediente exp: caja) {
			JButton bExp = new JButton(exp.getNumExpediente()+"/"+exp.getAnno());
			bExp.addActionListener(ctr);
			v.getpExpedientes().add(bExp);
			ctr.setUltContExp(ctr.getUltContExp()+1);
		}
		
		// Controlar visibilidades y tamaños de ventana
		if (v.getpInformacion().isVisible())
			v.getpInformacion().setVisible(false);
		
		v.getpBordeExpedientes().setPreferredSize(new Dimension(370, 25+35*((ctr.getUltContExp()+3)/4)));
		if (!v.getpBordeExpedientes().isVisible())
			v.getpBordeExpedientes().setVisible(true);
		
		ctr.actualizarTamañoPantalla();
	}
	
	public static void buscarExpAnno(Controlador ctr) {
		Vista v = ctr.getV();
		Expediente exp = null;
		
		// Buscar el expediente por numero de expediente y año
		try {
			exp = DAOExpedientes.findExpediente(Short.parseShort(v.getBusExpediente().getText()),
										Short.parseShort(v.getBusAnno().getText()));
		} catch (MiExcepcion e) { // Salir si no se ha encontrado o ha habido cualquier error
			JOptionPane.showMessageDialog(v, e.getMessage(),
					"Error en la búsqueda", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// Guardar el expediente y mostrarlo
		ctr.setUltExpediente(exp);
		ctr.mostrarUltExpediente();
		
		// Controlar visibilidades y tamaños de ventana
		if (v.getpBordeExpedientes().isVisible()) {
			v.getpBordeExpedientes().setVisible(false);
			v.setpExpedientes(new JPanel(new FlowLayout(FlowLayout.LEFT)));
			ctr.setUltContExp(0);
		}
		if (!v.getpInformacion().isVisible())
			v.getpInformacion().setVisible(true);
		
		ctr.actualizarTamañoPantalla();
	}

	public static void buscarExpediente(Controlador ctr, ActionEvent e) {
		Vista v = ctr.getV();
		
		// Recoger los datos del botón presionado
		String[] datosExp = ((JButton)e.getSource()).getText().split("/");
			
		// Buscar el expediente y guardarlo
		try {
			ctr.setUltExpediente(DAOExpedientes.findExpediente(Short.parseShort(datosExp[0]),
																Short.parseShort(datosExp[1])));
		} catch (MiExcepcion e1) { // Salir si no se ha encontrado o ha habido cualquier error
			JOptionPane.showMessageDialog(v, e1.getMessage(),
					"Error en la búsqueda", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// Mostrar el expediente
		ctr.mostrarUltExpediente();
		
		// Controlar visibilidades y tamaños de ventana
		if (!v.getpInformacion().isVisible())
			v.getpInformacion().setVisible(true);

		ctr.actualizarTamañoPantalla();
		
	}

	public static Expediente getExpedienteInterfaz(Controlador ctr) throws Exception {
		Vista v = ctr.getV();
		
		return new Expediente(Integer.parseInt(v.getInfCaja().getText()),
				Short.parseShort(v.getInfExpediente().getText()),
				Short.parseShort(v.getInfFecha().getText()),
				(SubseccionExpediente)v.getInfSubseccion().getSelectedItem(),
				v.getInfDescripcion().getText(),
				Persona.splitNombres(v.getInfNombres().getText()));
	}
}
