package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.BilleteTren;
import modelo.BilleteTrenFamiliar;
import modelo.EnumDescuentos;
import modelo.Punto;
import vista.Vista;

public class Controlador implements ItemListener, ActionListener,
									FocusListener {
	
	private Vista miVista;
	private BilleteTren billeteActual;
	private DecimalFormat df;
	
	public Controlador(Vista v) {
		miVista = v;
		billeteActual = new BilleteTren(new Punto(), new Punto(), EnumDescuentos.SIN_DESCUENTO);
		df = new DecimalFormat("#.##");
	}
	
	@Override
	public void focusGained(FocusEvent e) {}
	
	@Override
	public void focusLost(FocusEvent e) {
		JTextField tf = (JTextField)e.getSource();
		
		try {
			Double.parseDouble(tf.getText());
		} catch (Exception e1) {
			tf.setText("0");
		}
		
		actualizarDistancia();
		actualizarDatos();
	}
	
	private void actualizarDistancia() {
		JTextField[] coordenadas = miVista.getTfCoordenadas();
		
		billeteActual.getOrigen().setCoordX(Double.parseDouble(coordenadas[0].getText()));
		billeteActual.getOrigen().setCoordY(Double.parseDouble(coordenadas[1].getText()));
		billeteActual.getDestino().setCoordX(Double.parseDouble(coordenadas[2].getText()));
		billeteActual.getDestino().setCoordY(Double.parseDouble(coordenadas[3].getText()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miVista.getbVender())
			guardarBillete();
		
		reiniciarDatos();
		actualizarBillete();
		actualizarDatosCompletos();
		
	}
	
	private void reiniciarDatos() {
		for (JTextField tf: miVista.getTfCoordenadas())
			tf.setText("0");
		miVista.getCbTipoDescuento().setSelectedItem(EnumDescuentos.SIN_DESCUENTO);
		miVista.getCbBilleteFamiliar().setSelected(false);
	}
	
	private void guardarBillete() {
		boolean nombreCorrecto;
		if (miVista.getCbBilleteFamiliar().isSelected()) {
			do {
				BilleteTrenFamiliar bA = ((BilleteTrenFamiliar)billeteActual);
				bA.setNombre(JOptionPane.showInputDialog("Escriba el nombre del familiar:"));
				nombreCorrecto = JOptionPane.showConfirmDialog(miVista, "Es correcto el nombre \""+bA.getNombre()+"\"?")
										==JOptionPane.OK_OPTION;
			} while (!nombreCorrecto);
		}
		
		try (BufferedWriter bw = Files.newBufferedWriter(Path.of("recursos/billetes.txt"),
				StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
			
			bw.write(billeteActual.toString()+'\n');
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		actualizarBillete();
		actualizarDatosCompletos();
	}

	private void actualizarBillete() {
		// Creación de los puntos origen y destino
		JTextField[] coordenadas = miVista.getTfCoordenadas();
		
		Punto pOrigen = new Punto(Double.parseDouble(coordenadas[0].getText()), Double.parseDouble(coordenadas[1].getText()));
		Punto pDestino = new Punto(Double.parseDouble(coordenadas[2].getText()), Double.parseDouble(coordenadas[3].getText()));
		
		// Creación del descuento
		EnumDescuentos descuento = (EnumDescuentos)miVista.getCbTipoDescuento().getSelectedItem();
		
		if (!miVista.getCbBilleteFamiliar().isSelected())
			billeteActual = new BilleteTren(pOrigen, pDestino, descuento);
		else
			billeteActual = new BilleteTrenFamiliar(pOrigen, pDestino, descuento, "");
	}
	
	private void actualizarDatos() {
		miVista.getlDistancia().setText(df.format(billeteActual.getDistancia())+" km");
		miVista.getlPrecio().setText(billeteActual.getPrecio());
	}
	
	private void actualizarDatosCompletos() {
		miVista.getlDescuentoAplicar().setText(billeteActual.getDescuento());
		actualizarDatos();
	}
}
