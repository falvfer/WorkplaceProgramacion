package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import modelo.AgendaCitas;
import modelo.EspecialistasEnum;
import vista.Vista;

public class Controlador implements ActionListener {
	
	private Vista miVista;
	private AgendaCitas agenda;
	
	public Controlador(Vista v) {
		miVista = v;
		agenda = new AgendaCitas();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source instanceof JRadioButton) {
			miVista.getCbPrioridad().setEnabled(
					miVista.getRbUrgente().isSelected());
			return;
		}
		
		if (source == miVista.getbAddCita()) { // AÑADIR CITA
			
			// Recolectar datos
			byte prioridad = (miVista.getRbNormal().isSelected()?0:
						(byte)miVista.getCbPrioridad().getSelectedItem());
			EspecialistasEnum especialidad = (EspecialistasEnum)miVista.getCbEspecialidad().getSelectedItem();
			String numSS = miVista.getTfNumSS().getText();
			String nombre = miVista.getTfNombre().getText();
			String hora = (String)miVista.getCbHora().getSelectedItem();
			// TODO seguir por aqui, hace falta recolectar la lista de motivos y demás
			
		} else if (source == miVista.getbCancelar()) { // CANCELAR / REINICIAR
			
			
			
		} else if (source == miVista.getbLista()) { // VER LISTA DE CITAS
			
			
			
		} else if (source == miVista.getbImportar()) { // IMPORTAR DESDE ARCHIVO
			
			
			
		} else { // EXPORTAR A ARCHIVO
			
			
			
		}
		
	}
	
}
