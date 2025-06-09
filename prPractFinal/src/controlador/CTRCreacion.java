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

public class CTRCreacion {

	public static void guardar(Controlador ctr) {
		Vista v = ctr.getV();
		
		try {
			// Añadir el expediente
			Expediente e = CTRBuscadores.getExpedienteAddInterfaz(ctr);
			
			// Preguntar al usuario para confirmar
			int respuesta = JOptionPane.showConfirmDialog(v,
					"¿Seguro que quieres crear el expediente?");
			
			if (respuesta == JOptionPane.OK_OPTION) {
				DAOExpedientes.crearExpediente(e);
				ctr.limpiarInterfazCrear();
			}
			
		} catch(MiExcepcion e) {
			JOptionPane.showMessageDialog(v, "Comprueba los datos introducidos",
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public static void cancelar(Controlador ctr) {
		Vista v = ctr.getV();
		
		int respuesta = JOptionPane.showConfirmDialog(v,
							"¿Seguro que quieres borrar los datos de la interfaz?");
		if (respuesta == JOptionPane.OK_OPTION) {
			ctr.limpiarInterfazCrear();
		}
	}
}
