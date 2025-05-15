package controlador;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import modelo.AgendaCitas;
import modelo.CitaMedica;
import modelo.EspecialistasEnum;
import modelo.MotivosEnum;
import vista.Vista;

public class Controlador implements ActionListener {
	
	private Vista miVista;
	private JFrame f;
	private AgendaCitas agenda;
	
	public Controlador(Vista v, JFrame frame) {
		miVista = v;
		f = frame;
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
			addCita();
			reiniciarFormulario();
			
		} else if (source == miVista.getbCancelar()) { // CANCELAR / REINICIAR FORMULARIO
			reiniciarFormulario();
			
		} else if (source == miVista.getbLista()) { // VER LISTA DE CITAS
			verCitas();
			
		} else if (source == miVista.getbImportar()) { // IMPORTAR DESDE ARCHIVO
			int importado;
			
			do {
				importado = importar();
			} while (importado < 0);
			
			if (importado == 1) reiniciarFormulario();
			
		} else { // EXPORTAR A ARCHIVO
			int exportado;
			
			do {
				exportado = exportar();
			} while (exportado < 0);
		}
		
	}
	
	private void addCita() {
		// Recolectar datos
		byte prioridad = (miVista.getRbNormal().isSelected()?0:
					(byte)miVista.getCbPrioridad().getSelectedItem());
		EspecialistasEnum especialidad = (EspecialistasEnum)miVista.getCbEspecialidad().getSelectedItem();
		String numSS = miVista.getTfNumSS().getText();
		String nombre = miVista.getTfNombre().getText();
		String hora = (String)miVista.getCbHora().getSelectedItem();
		List<MotivosEnum> listaMotivos = miVista.getListaMotivos().getSelectedValuesList();
		
		// Crear la cita médica y añadirla a la agenda
		boolean resultado = agenda.addCita(new CitaMedica(prioridad, numSS, nombre, listaMotivos, especialidad, hora));
		
		if (resultado)
			JOptionPane.showMessageDialog(miVista, "Cita creada", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(miVista, "No se ha podido crear la Cita", "Error",
					JOptionPane.ERROR_MESSAGE);
	}
	
	private void reiniciarFormulario() {
		miVista.getRbNormal().setSelected(true);
		miVista.getCbPrioridad().setSelectedIndex(0);
		miVista.getCbPrioridad().setEnabled(false);
		miVista.getTfNumSS().setText("");
		miVista.getTfNombre().setText("");
		miVista.getCbHora().setSelectedIndex(16);
		miVista.getListaMotivos().setSelectedIndex(0);
	}
	
	private void verCitas() {
		agenda.ordenaCitas();
		
		JDialog d = new JDialog(f,"Listado de citas",true);
		d.setLayout(new FlowLayout());
		
		String [] nombreColumnas = {"Prioridad","Hora","Num SS","Nombre","Motivos consulta","Especialista","Precio"};
		Object [] datos = agenda.getCitas().toArray();
		
		// Crear la matriz que va a contener los datos segmentados por columnas y filas
		String [][] datos2 = new String[datos.length][nombreColumnas.length]; 
		
		// Añadir los datos a la matriz recorriendo cada una de las citas
		for (int i=0; i<datos.length; i++) {
			CitaMedica miCita = (CitaMedica) datos[i];
			datos2[i][0]=Byte.toString(miCita.getPrioridad());
			datos2[i][1]=miCita.getHoraVisita().toString();
			datos2[i][2]=miCita.getNumSS();
			datos2[i][3]=miCita.getNombre();
			datos2[i][4]=miCita.getMotivos().toString();
			datos2[i][5]=miCita.getEspecialista().toString();
			datos2[i][6]=Integer.toString(miCita.getPrecio());
		}
		
		// Creación de un JTable
		JTable tablaResultados = new JTable(datos2,nombreColumnas);
		
		// Obtener el modelo de las columnas
		TableColumnModel columnModel = tablaResultados.getColumnModel();
		
		// Centrar algunas columnas en la tabla de resultados
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		columnModel.getColumn(0).setCellRenderer(tcr);
		columnModel.getColumn(1).setCellRenderer(tcr);
		columnModel.getColumn(6).setCellRenderer(tcr);
		
		// Establecer diferententes tamaños para las columnas
		columnModel.getColumn(0).setPreferredWidth(70);
		columnModel.getColumn(1).setPreferredWidth(70);
		columnModel.getColumn(2).setPreferredWidth(90);
		columnModel.getColumn(3).setPreferredWidth(150);
		columnModel.getColumn(4).setPreferredWidth(220);
		columnModel.getColumn(5).setPreferredWidth(130);
		columnModel.getColumn(6).setPreferredWidth(70);
		
		// Colocar el JTable en un scrollPane
		JScrollPane sp = new JScrollPane(tablaResultados);
		sp.setPreferredSize(new Dimension(800,200));
		
		d.add(sp);
	    
	    d.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	d.pack();  
		d.setVisible(true);   // Para mostrar el dialogo
		d.setResizable(false);
	}
	
	private int importar() {
		JFileChooser fc = new JFileChooser(new File("source"));
		int returnVal = fc.showOpenDialog(f);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            	
            	agenda = (AgendaCitas)ois.readObject();
            	
            	JOptionPane.showMessageDialog(f, "Se ha cargado la agenda correctamente", "Información",
            			JOptionPane.INFORMATION_MESSAGE);
            	
            	return 1;
            	
            } catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(f, "No se ha podido cargar el archivo: no contiene una agenda", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(f, "No se ha podido cargar el archivo", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
            
            return -1;
            
        }
		return 2;
	}
	
	private int exportar() {
		JFileChooser fc = new JFileChooser(new File("source"));
		int returnVal = fc.showSaveDialog(f);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(file))) {
            	
            	ois.writeObject(agenda);
            	
            	JOptionPane.showMessageDialog(f, "Se ha guardado el archivo correctamente", "Información",
            			JOptionPane.INFORMATION_MESSAGE);
            	
            	return 1;
            	
            } catch (IOException e) {
				JOptionPane.showMessageDialog(f, "No se ha podido guardar el archivo", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
            
            return -1;
            
        }
		return 2;
	}
	
}
