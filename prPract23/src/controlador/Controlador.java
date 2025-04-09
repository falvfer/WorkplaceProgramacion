package controlador;

import vista.Vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import modelo.Inmobiliaria;
import modelo.TipoPropiedad;

public class Controlador implements ItemListener, ActionListener/*, TODO Implementar funciones
									FocusListener, KeyListener*/ {

	private Vista miVista;
	private Inmobiliaria miInmobiliaria;
	
	public Controlador(Vista v) {
		this.miVista = v;
		this.miInmobiliaria = new Inmobiliaria();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Posiblemente tenga que hacer una máquina de estados
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JComboBox<TipoPropiedad> cb = miVista.getCbPropiedades();

		if (cb.getSelectedItem() == TipoPropiedad.VIVIENDA) {
			setEstado(miVista.getPanelVivienda(), true);
			setEstado(miVista.getPanelFinca(), false);
			return;
		}
		if (cb.getSelectedItem() == TipoPropiedad.FINCA) {
			setEstado(miVista.getPanelVivienda(), false);
			setEstado(miVista.getPanelFinca(), true);
			return;
		}
		setEstado(miVista.getPanelVivienda(), false);
		setEstado(miVista.getPanelFinca(), false);
		
	}
	
	private void setEstado(JPanel panel, boolean estado) {
		if (panel.isEnabled() != estado) {
			setEstadoComponentes(panel, estado);
		}
	}
	
	private void setEstadoComponentes(JPanel panel, boolean estado) {
		panel.setEnabled(estado);
		for (Component comp: panel.getComponents()) {
			if (comp instanceof JPanel)
				setEstadoComponentes((JPanel)comp, estado);
			else
				comp.setEnabled(estado);
		}
	}
	
}
