package controlador;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import bd.DAOCajas;
import bd.DAOExpedientes;
import modelo.Expediente;
import modelo.MiExcepcion;
import vista.Vista;

public class CTREdicion {

	public static void editar(Controlador ctr) {
		// Activar y desactivar botones y partes de la interfaz
		cambiarEstadoEditar(ctr, true);
	}

	public static void borrar(Controlador ctr) {
		Vista v = ctr.getV();
		
		// Preguntar al usuario si de verdad quiere borrar el expediente
		int respuesta = JOptionPane.showConfirmDialog(v,
				"¿Seguro que quieres borrar este expediente?");
		
		if (respuesta == JOptionPane.OK_OPTION) {
			// Si se ha podido borrar el expediente
			if (borrarUltimoExpediente(ctr)) {
				ctr.limpiarBusqueda(); // Limpiar los datos de la busqueda
				cambiarEstadoEditar(ctr, false);
			}
		}
	}

	public static void guardar(Controlador ctr) {
		Vista v = ctr.getV();
		
		// Preguntar al usuario para confirmar
		int respuesta = JOptionPane.showConfirmDialog(v,
				"¿Seguro que quieres guardar los cambios en el expediente?");
		
		if (respuesta == JOptionPane.OK_OPTION) {
			try {
				// Actualizar el ultimo expediente con el expediente de la interfaz
				actualizarUltimoExpediente(ctr, CTRBuscadores.getExpedienteInterfaz(ctr));
				cambiarEstadoEditar(ctr, false);
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(v, "Comprueba los datos introducidos",
						"Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
			
	}

	public static void cancelar(Controlador ctr) {
		Vista v = ctr.getV();
		
		int respuesta = JOptionPane.showConfirmDialog(v,
							"¿Seguro que quieres cancelar los cambios realizados en el expediente?");
		if (respuesta == JOptionPane.OK_OPTION) {
			ctr.mostrarUltExpediente();
			cambiarEstadoEditar(ctr, false);
		}
	}
	
	public static boolean borrarUltimoExpediente(Controlador ctr) {
		Vista v = ctr.getV();
		
		try {
			DAOExpedientes.borraExpediente(ctr.getUltExpediente());
		} catch (MiExcepcion e) { // Salir si no se ha encontrado o ha habido cualquier error
			JOptionPane.showMessageDialog(v, e.getMessage(),
					"Error en la búsqueda", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		ctr.setUltExpediente(null);
		return true;
		
	}
	
	public static void cambiarEstadoEditar(Controlador ctr, boolean b) {
		Vista v = ctr.getV();
		
		v.setEditableBuscar(b);
		
		v.getbBorrar().setEnabled(!b);
		v.getbEditar().setEnabled(!b);
		v.getbGuardar().setEnabled(b);
		v.getbCancelar().setEnabled(b);
		
		v.getBuscarCaja().setEnabled(!b);
		v.getBuscarExpAnno().setEnabled(!b);
		
		if (v.getpExpedientes().getComponents().length > 0)
			v.getpBordeExpedientes().setVisible(!b);
		
		if (!b) {
			try {
				int caja = ctr.getUltExpediente().getNumCaja();
				if (DAOCajas.findCaja(caja).size()>0 && v.getpExpedientes().getComponents().length > 0)
					CTRBuscadores.buscarCaja(ctr, false);
				else
					v.getpBordeExpedientes().setVisible(false);
			} catch (Exception e) {
				v.getpBordeExpedientes().setVisible(false);
			}
			v.getpInformacion().setVisible(true);
		}
		ctr.actualizarTamañoPantalla();
	}
	
	public static void actualizarUltimoExpediente(Controlador ctr, Expediente nuevoExp) {
		Vista v = ctr.getV();
		
		try {
			DAOExpedientes.actualizarExpediente(ctr.getUltExpediente(), nuevoExp);
		} catch (MiExcepcion e) { // Salir si no se ha encontrado o ha habido cualquier error
			JOptionPane.showMessageDialog(v, e.getMessage(),
					"Error en la actualización", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}
