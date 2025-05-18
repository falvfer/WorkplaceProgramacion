package vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.EspecialistasEnum;
import modelo.MotivosEnum;

public class Vista extends JPanel {
	private static final long serialVersionUID = -5752211613049689258L;
	
// Variables
	JRadioButton rbNormal, rbUrgente;
	JComboBox<Byte> cbPrioridad;
	JComboBox<EspecialistasEnum> cbEspecialidad;
	JTextField tfNumSS, tfNombre;
	JComboBox<String> cbHora;
	JList<MotivosEnum> listaMotivos;
	JButton bAddCita, bCancelar, bLista;
	JButton bImportar, bExportar;
	
// Getters
	public JRadioButton getRbNormal() {return rbNormal;}
	public JRadioButton getRbUrgente() {return rbUrgente;}
	public JComboBox<Byte> getCbPrioridad() {return cbPrioridad;}
	public JComboBox<EspecialistasEnum> getCbEspecialidad() {return cbEspecialidad;}
	public JTextField getTfNumSS() {return tfNumSS;}
	public JTextField getTfNombre() {return tfNombre;}
	public JComboBox<String> getCbHora() {return cbHora;}
	public JList<MotivosEnum> getListaMotivos() {return listaMotivos;}
	public JButton getbAddCita() {return bAddCita;}
	public JButton getbCancelar() {return bCancelar;}
	public JButton getbLista() {return bLista;}
	public JButton getbImportar() {return bImportar;}
	public JButton getbExportar() {return bExportar;}
	// Constructor
	public Vista() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		//panelPrincipal.setPreferredSize(new Dimension(520, 330));
		
		panelPrincipal.add(crearDatosCita());
		panelPrincipal.add(crearMotivos());
		panelPrincipal.add(crearOperaciones());
		panelPrincipal.add(crearExportarImportar());
		
		this.add(panelPrincipal);
	}
	
	private JPanel crearDatosCita() {
		JPanel principal = new JPanel(new GridLayout(6,2,5,5));
		estableceBorde(principal, "Datos cita");
		
		// Crear labels y ajustarlos
		JLabel[] textos = {
				new JLabel("Tipo de cita:"),
				new JLabel("Prioridad:"),
				new JLabel("Especialidad:"),
				new JLabel("Nº de Seguridad Social:"),
				new JLabel("Nombre paciente:"),
				new JLabel("Hora visita:")};
		for (JLabel l: textos) {
			l.setHorizontalAlignment(SwingConstants.RIGHT);
			l.setBorder(new EmptyBorder(0, 0, 0, 5));
		}
		
		// Crear demás componentes
		JPanel panelRBPrioridad = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rbNormal = new JRadioButton("Normal");
		rbUrgente = new JRadioButton("Urgente");
		JPanel panelPrioridades = new JPanel(new FlowLayout(FlowLayout.LEFT));
			Byte[] prioridades = {1,2,3};
		cbPrioridad = new JComboBox<Byte>(prioridades);
		cbEspecialidad = new JComboBox<EspecialistasEnum>(EspecialistasEnum.values());
		tfNumSS = new JTextField();
		tfNombre = new JTextField();
		JPanel panelHoras = new JPanel(new FlowLayout(FlowLayout.LEFT));
		DecimalFormat df = new DecimalFormat("00");
			String[] horas = new String[24];
			for (int i = 0; i<horas.length; i++)
					horas[i] = df.format(i)+":00";
		cbHora = new JComboBox<String>(horas);
		
		// Agrupar los dos JRadioButton
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbNormal);
		bg.add(rbUrgente);
		
		// Añadir los componentes al panel principal
		principal.add(textos[0]);
			panelRBPrioridad.add(rbNormal);
			panelRBPrioridad.add(rbUrgente);
		principal.add(panelRBPrioridad);
		principal.add(textos[1]);
			panelPrioridades.add(cbPrioridad);
		principal.add(panelPrioridades);
		principal.add(textos[2]);
		principal.add(cbEspecialidad);
		principal.add(textos[3]);
		principal.add(tfNumSS);
		principal.add(textos[4]);
		principal.add(tfNombre);
		principal.add(textos[5]);
			panelHoras.add(cbHora);
		principal.add(panelHoras);
		
		return principal;
	}
	
	private JPanel crearMotivos() {
		JPanel principal = new JPanel(new FlowLayout(FlowLayout.CENTER));
		estableceBorde(principal, "Motivos para solicitar cita");
		
		// Crear la lista de Motivos
		listaMotivos = new JList<>(MotivosEnum.values());
		JScrollPane panel = new JScrollPane(listaMotivos);

		// Ajustar el tamaño del panel
		panel.setPreferredSize(new Dimension(198, 80));
		
		// Añadirla al panel
		principal.add(panel);
		
		// Habilitar la seleccion multiple
		listaMotivos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		return principal;
	}
	
	private JPanel crearOperaciones() {
		JPanel principal = new JPanel(new FlowLayout(FlowLayout.CENTER));
		estableceBorde(principal, "Operaciones permitidas");
		
		// Crear los botones
		bAddCita = new JButton("Añadir cita");
		bCancelar = new JButton("Cancelar");
		bLista = new JButton("Ver lista citas");
		
		// Añadir los botones
		principal.add(bAddCita);
		principal.add(bCancelar);
		principal.add(bLista);
		
		return principal;
	}
	
	public JPanel crearExportarImportar() {
		JPanel principal = new JPanel(new FlowLayout(FlowLayout.CENTER));
		estableceBorde(principal, "Exportar / Importar");
		
		// Crear los botones
		bImportar = new JButton("Importar agenda");
		bExportar = new JButton("Exportar agenda");
		
		// Añadir los botones
		principal.add(bImportar);
		principal.add(bExportar);
		
		return principal;
	}

	private static void estableceBorde(JPanel p, String titulo) {
		p.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder(titulo)));
	}
	
	public void control(Controlador ctrl) {
		
		rbNormal.addActionListener(ctrl);
		rbUrgente.addActionListener(ctrl);
		
		bAddCita.addActionListener(ctrl);
		bCancelar.addActionListener(ctrl);
		bLista.addActionListener(ctrl);
		
		bImportar.addActionListener(ctrl);
		bExportar.addActionListener(ctrl);
		
	}

}
