package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.UIManager;

import modelo.Expediente;
import modelo.SeccionExpediente;
import modelo.SubseccionExpediente;
import vista.Vista;

public class Controlador implements ActionListener, ItemListener, MouseListener {

// Variables
	private Vista v;
	private int ultContExp;
	private Expediente ultExpediente;
	
// Getters
	public Vista getV() {return v;}
	public int getUltContExp() {return ultContExp;}
	public void setUltContExp(int ultContExp) {this.ultContExp = ultContExp;}
	public Expediente getUltExpediente() {return ultExpediente;}
	public void setUltExpediente(Expediente ultExpediente) {this.ultExpediente = ultExpediente;}
	
// Constructor
	public Controlador(Vista v) {
		this.v = v;
	}
	
// Metodos
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == v.getBuscarCaja())
			CTRBuscadores.buscarCaja(this, true);
		else if (source == v.getBuscarExpAnno())
			CTRBuscadores.buscarExpAnno(this);
		else if (source == v.getbInfBorrar())
			CTREdicion.borrar(this);
		else if (source == v.getbInfEditar())
			CTREdicion.editar(this);
		else if (source == v.getbInfGuardar())
			CTREdicion.guardar(this);
		else if (source == v.getbInfCancelar())
			CTREdicion.cancelar(this);
		else if (source == v.getbAddGuardar())
			CTRCreacion.guardar(this);
		else if (source == v.getbAddCancelar())
			CTRCreacion.cancelar(this);
		else
			CTRBuscadores.buscarExpediente(this, e);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == v.getInfSeccion())
			actualizarSubseccionInf();
		else
			actualizarSubseccionAdd();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == v.getMenuAdd())
			menuCrear();
		else
			menuBuscar();
		
		actualizarTamañoPantalla();
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	public void actualizarSubseccionInf() {
		v.getInfSubseccionModel().removeAllElements();
		v.getInfSubseccionModel().addAll(
			SubseccionExpediente.getValuesFromSeccion(
				(SeccionExpediente)v.getInfSeccion().getSelectedItem()));
		v.getInfSubseccion().setSelectedIndex(0);
	}

	public void actualizarSubseccionAdd() {
		v.getAddSubseccionModel().removeAllElements();
		v.getAddSubseccionModel().addAll(
			SubseccionExpediente.getValuesFromSeccion(
				(SeccionExpediente)v.getAddSeccion().getSelectedItem()));
		v.getAddSubseccion().setSelectedIndex(0);
	}
	
	private void menuCrear() {
		v.getpCrear().setVisible(true);
		v.getpBusqueda().setVisible(false);
		v.getpInformacion().setVisible(false);
		v.getpBordeExpedientes().setVisible(false);
		v.getMenuAdd().setBackground(Color.decode("#d4d4d4"));
		v.getMenuBuscar().setBackground(UIManager.getColor("Menu.background"));
	}

	private void menuBuscar() {
		v.getpCrear().setVisible(false);
		v.getpBusqueda().setVisible(true);
		v.getMenuAdd().setBackground(UIManager.getColor("Menu.background"));
		v.getMenuBuscar().setBackground(Color.decode("#d4d4d4"));
	}
	
	public void mostrarUltExpediente() {
		v.getInfCaja().setText(ultExpediente.getNumCaja()+"");
		v.getInfExpediente().setText(ultExpediente.getNumExpediente()+"");
		v.getInfFecha().setText(ultExpediente.getAnno()+"");
		v.getInfSeccion().setSelectedItem(ultExpediente.getSeccion());
		actualizarSubseccionInf();
		v.getInfSubseccion().setSelectedItem(ultExpediente.getSubseccion());
		v.getInfDescripcion().setText(ultExpediente.getDescripcion()+"");
		v.getInfNombres().setText(ultExpediente.getNombres()+"");
	}
	
	public void limpiarInterfazCrear() {
		v.getAddCaja().setText("");
		v.getAddExpediente().setText("");
		v.getAddFecha().setText("");
		v.getAddSeccion().setSelectedIndex(0);
		actualizarSubseccionAdd();
		v.getAddSubseccion().setSelectedIndex(0);
		v.getAddDescripcion().setText("");
		v.getAddNombres().setText("");
	}
	
	public void limpiarBusqueda() {
		v.getInfCaja().setText("");
		v.getInfExpediente().setText("");
		v.getInfFecha().setText("");
		v.getInfSeccion().setSelectedIndex(0);
		actualizarSubseccionInf();
		v.getInfSubseccion().setSelectedIndex(0);
		v.getInfDescripcion().setText("");
		v.getInfNombres().setText("");
	}
	
	public void actualizarTamañoPantalla() {
		v.pack();
		
		if (v.getpBordeExpedientes().isVisible()) {
			if (v.getpInformacion().isVisible()) {
				// Todo lo de buscar está visibles
				v.setSize(400, 530+35*((ultContExp+3)/4));
			} else {
				// Panel buscar y Panel de cajas están visibles
				v.setSize(400, 235+35*((ultContExp+3)/4));
			}
		} else if (v.getpInformacion().isVisible()) {
			// Panel buscar y Panel información están visibles
			v.setSize(400, 500);
		} else if (v.getpCrear().isVisible()){
			// Panel de crear está visible unicamente.
			v.setSize(400, 365);
		} else {
			// Panel buscar está visible unicamente
			v.setSize(400, 205);
		}
	}
	
	
}
