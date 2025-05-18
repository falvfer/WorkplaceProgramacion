package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import librerias.LibFechas;
import modelo.GestorAlojamientos;
import modelo.MiExcepcion;
import modelo.Persona;
import modelo.Reserva;
import modelo.UbicacionesEnum;
import vista.Vista;

public class Controlador implements ActionListener, ItemListener, FocusListener {
	private Vista miVista;
	private GestorAlojamientos gestor;
	private Reserva reservaActual;
	// No me funciona el ACollection normal,
	// He generado uno yo con los Alojamientos que generé en el TestModelo
	private final File UBICACION_ALOJAMIENTOS = new File("files/miACollection.dat");
	
	public GestorAlojamientos getGestor() {return this.gestor;}
	
	public Controlador(Vista miVista) {
		this.miVista = miVista;
		try {
			gestor = new GestorAlojamientos(UBICACION_ALOJAMIENTOS);
		} catch (MiExcepcion e) {
			JOptionPane.showMessageDialog(miVista, "Error", "Error al cargar el archivo de Alojamientos, reviselo.",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {}

	@Override
	public void focusLost(FocusEvent e) { // tfFechaIni
		actualizarDatos();
	}

	@Override
	public void itemStateChanged(ItemEvent e) { // cbUbicaciones, cbNoches, cbAlojamiento
		if (e.getSource() == miVista.getCbUbicaciones())
			actualizarAlojamientos();
		
		actualizarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) { // bDetalles, bLimpiar, bReservar
		if (e.getSource() == miVista.getbDetalles())
			mostrarDetalles();
		else if (e.getSource() == miVista.getbLimpiar())
			limpiarFormulario();
		else {
			System.out.println("hola");
			if (realizarReserva()) {
				addFilaTabla();
				limpiarFormulario();
			}
		}
			
	}

	private void actualizarAlojamientos() {
		UbicacionesEnum ubicacion = (UbicacionesEnum)miVista.getCbUbicaciones().getSelectedItem();

		DefaultComboBoxModel<String> cb = miVista.getModeloCbAlojamiento();
		
		cb.removeAllElements();
		
		if (ubicacion == UbicacionesEnum.Todas)
			cb.addAll(gestor.getAlojamientosEnUbicacion());
		else
			cb.addAll(gestor.getAlojamientosEnUbicacion(ubicacion));
		
		cb.setSelectedItem(cb.getElementAt(0));
	}

	private void actualizarDatos() {
		if (!LibFechas.isFechaCorrecta(miVista.getTfFechaIni().getText())) 
			return; // No se puede actualizar
		
		try {
			reservaActual = new Reserva(gestor.buscarAlojamiento((String)miVista.getCbAlojamiento().getSelectedItem()),
					miVista.getTfFechaIni().getText(), (byte)(int)miVista.getCbNoches().getSelectedItem(), null);
			
			miVista.getTfFechaFin().setText(LibFechas.getFechaShort(reservaActual.getFin()));
			miVista.getLabelCoste().setText(""+reservaActual.getPrecioFinal());
			
		} catch (MiExcepcion e) {
			e.printStackTrace();
		}
	}

	private boolean realizarReserva() {
		
		if (miVista.getTfNombre().getText().equals("") || miVista.getTfTel().getText().equals("")) {
		
			JOptionPane.showMessageDialog(miVista, "El nombre y teléfono son obligatorios",
					"Error", JOptionPane.ERROR_MESSAGE);
			
			return false;
			
		} else {
			try {
				reservaActual = new Reserva(gestor.buscarAlojamiento((String)miVista.getCbAlojamiento().getSelectedItem()),
						miVista.getTfFechaIni().getText(),
						(byte)(int)miVista.getCbNoches().getSelectedItem(),
						new Persona(miVista.getTfNombre().getText(),
									miVista.getTfDNI().getText(),
									miVista.getTfTel().getText()));
				
				gestor.addReserva(reservaActual);
				
			} catch (MiExcepcion e) {

				JOptionPane.showMessageDialog(miVista, e.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}

	public void limpiarFormulario() {
		miVista.getCbUbicaciones().setSelectedItem(UbicacionesEnum.Todas);
		actualizarAlojamientos();
		miVista.getCbNoches().setSelectedIndex(0);
		miVista.getTfFechaIni().setText("");
		miVista.getTfFechaFin().setText("");
		miVista.getLabelCoste().setText("0");
		miVista.getTfNombre().setText("");
		miVista.getTfDNI().setText("");
		miVista.getTfTel().setText("");
	}

	private void mostrarDetalles() {
		JOptionPane.showMessageDialog(miVista,
				"DETALLES DEL ALOJAMIENTO\n\n"
				+ gestor.buscarAlojamiento((String)miVista.getCbAlojamiento().getSelectedItem())); //TODO rehacer toString?
	}
	
	private void addFilaTabla() {
		String[] fila = new String[7];
		fila[0] = reservaActual.getAlojamiento().getNombre();
		fila[1] = LibFechas.getFechaShort(reservaActual.getInicio());
		fila[2] = LibFechas.getFechaShort(reservaActual.getFin());
		fila[3] = Integer.toString(reservaActual.getNumNoches());
		fila[4] = reservaActual.getPersona().getNombre();
		fila[5] = reservaActual.getPersona().getDni();
		fila[6] = reservaActual.getPersona().getTelefono();

		miVista.getDatos().addRow(fila); // Añado la fila al DefaultTableModel
	}
	
}
