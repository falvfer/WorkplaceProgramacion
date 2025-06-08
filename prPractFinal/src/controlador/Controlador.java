package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.MenuSelectionManager;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import bd.*;
import modelo.Expediente;
import modelo.MiExcepcion;
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
		System.out.println("Menu Crear");
		v.getpCrear().setVisible(true);
		v.getpBusqueda().setVisible(false);
		v.getpInformacion().setVisible(false);
		v.getpBordeExpedientes().setVisible(false);
		v.getMenuAdd().setBackground(Color.decode("#d4d4d4"));
		v.getMenuBuscar().setBackground(UIManager.getColor("Menu.background"));
	}

	private void menuBuscar() {
		System.out.println("Menu Buscar");
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
		v.getAddCaja().setText(ultExpediente.getNumCaja()+"");
		v.getAddExpediente().setText(ultExpediente.getNumExpediente()+"");
		v.getAddFecha().setText(ultExpediente.getAnno()+"");
		v.getAddSeccion().setSelectedItem(ultExpediente.getSeccion());
		actualizarSubseccionAdd();
		v.getAddSubseccion().setSelectedItem(ultExpediente.getSubseccion());
		v.getAddDescripcion().setText(ultExpediente.getDescripcion()+"");
		v.getAddNombres().setText(ultExpediente.getNombres()+"");
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
				// Todo está habilitado
				v.setSize(400, 530+35*((ultContExp+3)/4));
			} else {
				// Panel buscar y Panel de cajas están habilitados
				v.setSize(400, 235+35*((ultContExp+3)/4));
			}
		} else if (v.getpInformacion().isVisible()) {
			// Panel buscar y Panel información están habilitados
			v.setSize(400, 500);
		} else if (v.getpCrear().isVisible()){
			// Panel de crear está visible unicamente.
			v.setSize(400, 365);
		} else {
			// Panel buscar está habilitado unicamente
			v.setSize(400, 205);
		}
	}
	
	
}
