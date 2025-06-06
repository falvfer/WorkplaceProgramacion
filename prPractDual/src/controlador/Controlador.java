package controlador;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

import bd.*;
import modelo.Expediente;
import modelo.MiExcepcion;
import modelo.SeccionExpediente;
import modelo.SubseccionExpediente;
import vista.Vista;

public class Controlador implements ActionListener, ItemListener {

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
		else if (source == v.getbBorrar())
			CTREdicion.borrar(this);
		else if (source == v.getbEditar())
			CTREdicion.editar(this);
		else if (source == v.getbGuardar())
			CTREdicion.guardar(this);
		else if (source == v.getbCancelar())
			CTREdicion.cancelar(this);
		else if (source == v.getMenuAdd())
			menuCrear();
		else if (source == v.getMenuBuscar())
			menuBuscar();
		else
			CTRBuscadores.buscarExpediente(this, e);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
			actualizarSubseccion();
	}

	private void actualizarSubseccion() {
		v.getInfSubseccionModel().removeAllElements();
		v.getInfSubseccionModel().addAll(
			SubseccionExpediente.getValuesFromSeccion(
				(SeccionExpediente)v.getInfSeccion().getSelectedItem()));
		v.getInfSubseccion().setSelectedIndex(0);
	}
	
	private void menuCrear() {
		// TODO Auto-generated method stub
		
	}

	private void menuBuscar() {
		// TODO Auto-generated method stub
		
	}
	
	public void mostrarUltExpediente() {
		v.getInfCaja().setText(ultExpediente.getNumCaja()+"");
		v.getInfExpediente().setText(ultExpediente.getNumExpediente()+"");
		v.getInfFecha().setText(ultExpediente.getAnno()+"");
		v.getInfSeccion().setSelectedItem(ultExpediente.getSeccion());
		actualizarSubseccion();
		v.getInfSubseccion().setSelectedItem(ultExpediente.getSubseccion());
		v.getInfDescripcion().setText(ultExpediente.getDescripcion()+"");
		v.getInfNombres().setText(ultExpediente.getNombres()+"");
	}
	
	public void limpiarBusqueda() {
		v.getInfCaja().setText("");
		v.getInfExpediente().setText("");
		v.getInfFecha().setText("");
		v.getInfSeccion().setSelectedIndex(0);
		actualizarSubseccion();
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
		} else {
			// Panel buscar está habilitado unicamente
			v.setSize(400, 205);
		}
	}
}
