package controlador;
// Clase para controlar los eventos de ventana
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import librerias.LibFechas;
import modelo.GestorAlojamientos;
import modelo.Reserva;
import vista.Vista;
/*
public class ControlVentana extends WindowAdapter
{
	// Metodo para el cierre de ventana
	public void windowClosing(WindowEvent e)
	 {
	   System.exit(0);     
	 }
}

*/
public class ControlVentana implements WindowListener {
	
	private Vista miVista;
	private GestorAlojamientos gestor;
	private final Path archivo = Path.of("files/Reservas.txt");
	
	public ControlVentana(Vista miVista, GestorAlojamientos gestor) {
		this.miVista = miVista;
		this.gestor = gestor;
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		
		int respuesta = JOptionPane.showConfirmDialog(miVista, "¿Desea volcar las reservas creadas al archivo reservas?");
		
		if (respuesta == JOptionPane.OK_OPTION) {
			try (BufferedWriter bw = Files.newBufferedWriter(archivo, StandardOpenOption.APPEND)) {
				bw.write("\nRESERVAS REALIZADAS EL DÍA: " + LibFechas.getFechaFull(LocalDate.now())
				+ "\n--------------------------------------------------------\n");
				for (Reserva r: gestor.getReservas()) {
					bw.write(r.toString()+"\n");
				}
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(miVista, "No se ha podido guardar en el archivo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		System.exit(0);     
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	
}
