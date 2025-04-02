package prPract20_MVC;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controlador implements ListSelectionListener, ItemListener {

	private Vista v;
	
	public Controlador(Vista v) {
		this.v = v;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		v.getEtiqueta().setForeground(Color.blue);
		
		if (source == v.getCbRadios()) {
			v.getEtiqueta().setText("Número de radios: " + v.getCbRadios().getSelectedItem());
			return;
		}

		v.getEtiqueta().setText(((JCheckBox)source).getText());
		
		if (source == v.getChAsientos()) {
			if (v.getChAsientos().isSelected()) {
				v.getChTapiceria().setSelected(true);
				v.getChTapiceria().setEnabled(false);
			} else
				v.getChTapiceria().setSelected(false);
			return;
		}
			
		if (source == v.getChLlantas()) {
			v.getCbRadios().setEnabled(v.getChLlantas().isSelected());
			return;
		}
		
		if (source == v.getChPintura()) {
			v.getListaColores().setEnabled(v.getChPintura().isSelected());
			return;
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String strColor = v.getListaColores().getSelectedValue();
		v.getEtiqueta().setText("Color pintura: " + strColor);
		v.getEtiqueta().setForeground(v.getMapaColores().get(strColor));
	}

}
