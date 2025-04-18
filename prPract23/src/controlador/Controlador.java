package controlador;

import vista.Vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.FincaRustica;
import modelo.Inmobiliaria;
import modelo.Propiedad;
import modelo.TipoPropiedad;
import modelo.TipoTerreno;
import modelo.TipoVivienda;
import modelo.Vivienda;

public class Controlador implements ItemListener, ActionListener,
									FocusListener, KeyListener {

	private Vista miVista;
	private Inmobiliaria miInmobiliaria;
	
	public Controlador(Vista v) {
		this.miVista = v;
		this.miInmobiliaria = new Inmobiliaria();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bSource = (JButton)e.getSource();
		try {
			if (bSource == miVista.getbGuardar()) { // BOTON DE GUARDAR
				int respuesta = JOptionPane.showConfirmDialog(miVista, "Seguro que desea añadir esta propiedad?");
				if (respuesta == JOptionPane.OK_OPTION) {
					guardarPropiedad();
				} else
					return;
				
			}
		} catch (Exception e1) {e1.printStackTrace();}
		
		if (bSource == miVista.getbBorrar()) { // BOTON DE BORRAR
			int respuesta = JOptionPane.showConfirmDialog(miVista, "Seguro que desea borrar la propiedad con el código " + miVista.getTfCodigo().getText() + "?");
			if (respuesta == JOptionPane.OK_OPTION)
				miInmobiliaria.borra(Integer.parseInt(miVista.getTfCodigo().getText()));
			else
				return;
		}
		
		miVista.limpiaInterfaz();
	}
	
	public void guardarPropiedad() {
		int codigo = Integer.parseInt(miVista.getTfCodigo().getText());
		
		switch (miVista.getCbPropiedades().getSelectedItem()) {
		case TipoPropiedad.VIVIENDA -> {
			miInmobiliaria.añade(new Vivienda(
					codigo,
					miVista.getTfDireccion().getText(),
					miVista.getTaDescripcion().getText(),
					Integer.parseInt(miVista.getTfSuperficie().getText()),
					Double.parseDouble(miVista.getTfPrecio().getText()),
					(TipoVivienda)miVista.getCbViviendas().getSelectedItem(),
					(byte)miVista.getCbBaños().getSelectedItem(),
					(byte)miVista.getCbDormitorios().getSelectedItem()));
		}
		case TipoPropiedad.FINCA -> {
			miInmobiliaria.añade(new FincaRustica(
					codigo,
					miVista.getTfDireccion().getText(),
					miVista.getTaDescripcion().getText(),
					Integer.parseInt(miVista.getTfSuperficie().getText()),
					Double.parseDouble(miVista.getTfPrecio().getText()),
					(TipoTerreno)miVista.getCbTerrenos().getSelectedItem(),
					miVista.getRbElectricidad()[0].isSelected(),
					miVista.getRbAgua()[0].isSelected(),
					miVista.getRbVivienda()[0].isSelected()));
		}
		default -> {
			miInmobiliaria.añade(new Propiedad(
					codigo,
					miVista.getTfDireccion().getText(),
					miVista.getTaDescripcion().getText(),
					(TipoPropiedad)miVista.getCbPropiedades().getSelectedItem(),
					Integer.parseInt(miVista.getTfSuperficie().getText()),
					Double.parseDouble(miVista.getTfPrecio().getText())));
		}
		}
		
		JOptionPane.showMessageDialog(miVista, "Se han almacenado los siguientes datos:\n\t"
				+ miInmobiliaria.buscar(codigo).toString());
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

	@Override
	public void focusGained(FocusEvent e) {}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField src = (JTextField)e.getComponent();
		
		if (src.getText().equals("")) return;
		
		if (src == miVista.getTfCodigo()) {
			checkCodigo();
			return;
		}
		
		if (src == miVista.getTfPrecio()) {
			checkPrecio();
			return;
		}
		
		if (src == miVista.getTfSuperficie())
			checkSuperficie();
			
	}
	
	public void mostrarPropiedad(Propiedad p) {
		
		miVista.getTfCodigo().setText(p.getCodigo()+"");
		miVista.getCbPropiedades().setSelectedItem(p.getTipoProp());
		miVista.getTfPrecio().setText(p.getPrecio()+"");
		miVista.getTfSuperficie().setText(p.getMetrosCuadrados()+"");
		miVista.getTfDireccion().setText(p.getDireccion());
		miVista.getTaDescripcion().setText(p.getDescripcion());
		
		miVista.getbBorrar().setEnabled(true);
		miVista.getbGuardar().setEnabled(false);
		
		if (p instanceof Vivienda) {
			Vivienda v = (Vivienda)p;
			
			miVista.getCbViviendas().setSelectedItem(v.getTipoViv());
			miVista.getCbDormitorios().setSelectedItem(v.getDormitorios());
			miVista.getCbBaños().setSelectedItem(v.getBannos());
			
			return;
		}
			
		if (p instanceof FincaRustica) {
			FincaRustica f = (FincaRustica)p;
			
			miVista.getCbTerrenos().setSelectedItem(f.getTipoTerr());
			miVista.getRbElectricidad()[f.isLuz()?0:1].setSelected(true);
			miVista.getRbAgua()[f.isAgua()?0:1].setSelected(true);
			miVista.getRbVivienda()[f.isVivienda()?0:1].setSelected(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		JTextField src = (JTextField)e.getComponent();
		if (src.getText().equals("")) return;
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if (src==miVista.getTfCodigo()) {
				checkCodigo();
				return;
			}
			if (src==miVista.getTfPrecio()) {
				checkPrecio();
				return;
			}
			if (src==miVista.getTfSuperficie()) {
				checkSuperficie();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	private void checkCodigo() {
		JTextField tfCheck = miVista.getTfCodigo();
		try {
			int cod = Integer.parseInt(tfCheck.getText());
			Propiedad p = miInmobiliaria.buscar(cod);
			if (p instanceof Propiedad) {
				int respuesta = JOptionPane.showConfirmDialog(miVista, "Este código ya existe, desea ver la propiedad correspondiente?");
				if (respuesta == JOptionPane.OK_OPTION);
					mostrarPropiedad(p);
			}
		} catch (Exception e1) {
			tfCheck.setText("");
			JOptionPane.showMessageDialog(miVista, "Formato del código incorrecto: Solo se pueden introducir números.");
		}
	}
	
	private void checkPrecio() {
		JTextField tfCheck = miVista.getTfPrecio();
		try {
			Integer.parseInt(tfCheck.getText());
		} catch (Exception e1) {
			tfCheck.setText("");
			JOptionPane.showMessageDialog(miVista, "Formato del precio incorrecto: Solo se pueden introducir números.");
		}
	}
	
	private void checkSuperficie() {
		JTextField tfCheck = miVista.getTfSuperficie();
		try {
			Integer.parseInt(tfCheck.getText());
		} catch (Exception e1) {
			tfCheck.setText("");
			JOptionPane.showMessageDialog(miVista, "Formato de la superficie incorrecto: Solo se pueden introducir números.");
		}
	}
}
