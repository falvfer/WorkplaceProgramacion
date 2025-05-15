package modelo;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CitaMedica implements Comparable<CitaMedica>, Serializable{
	private static final long serialVersionUID = 4784410810186898326L;
	
	// Variables
	private byte prioridad;
	private String numSS, nombre;
	private List<MotivosEnum> motivos;
	private EspecialistasEnum especialista;
	private LocalTime horaVisita;
	private static final int PRECIO_BASE = 100, PRECIO_ESPECIALISTA = 30, PR1 = 50, PR2 = 100, PR3 = 150;
	
// Getters y Setters
	public byte getPrioridad() {return prioridad;}
	public String getNumSS() {return numSS;}
	public String getNombre() {return nombre;}
	public List<MotivosEnum> getMotivos() {return motivos;}
	public EspecialistasEnum getEspecialista() {return especialista;}
	public LocalTime getHoraVisita() {return horaVisita;}
	
	public void setPrioridad(byte prioridad) {this.prioridad = prioridad;}
	public void setNumSS(String numSS) {this.numSS = numSS;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setMotivos(List<MotivosEnum> motivos) {this.motivos = motivos;}
	public void setEspecialista(EspecialistasEnum especialista) {this.especialista = especialista;}
	public void setHoraVisita(LocalTime horaVisita) {this.horaVisita = horaVisita;}
	
// Constructores
	public CitaMedica(byte prioridad, String numSS, String nombre, List<MotivosEnum> motivos, EspecialistasEnum especialista,
			LocalTime horaVisita) {
		if (prioridad > 3) {prioridad = 3;}
		this.prioridad = prioridad;
		this.numSS = numSS;
		this.nombre = nombre;
		this.motivos = motivos;
		this.especialista = especialista;
		this.horaVisita = horaVisita;
	}
	public CitaMedica(byte prioridad, String numSS, String nombre, List<MotivosEnum> motivos, EspecialistasEnum especialista,
			String horaVisita) {
		this(prioridad, numSS, nombre, motivos, especialista, convertirFecha(horaVisita));
	}
	
	public CitaMedica(String numSS, String nombre, List<MotivosEnum> motivos, EspecialistasEnum especialista,
			String horaVisita) {
		this((byte)0, numSS, nombre, motivos, especialista, convertirFecha(horaVisita));
	}
	
	public CitaMedica(String numSS, String nombre, MotivosEnum motivo, EspecialistasEnum especialista,
			String horaVisita) {
		this((byte)0, numSS, nombre, crearMotivos(motivo), especialista, convertirFecha(horaVisita));
	}
	
	public CitaMedica(byte prioridad, String numSS, String nombre, MotivosEnum motivo, EspecialistasEnum especialista,
			String horaVisita) {
		this(prioridad, numSS, nombre, crearMotivos(motivo), especialista, convertirFecha(horaVisita));
	}
	
	// Metodo para crear la hora en LocalTime
	private static LocalTime convertirFecha(String hora) {
		String[] horaSplit = hora.split(":");
		return LocalTime.of(Integer.parseInt(horaSplit[0]), Integer.parseInt(horaSplit[1]));
	}
	
	// Metodo para crear la coleccion de motivos
	private static List<MotivosEnum> crearMotivos(MotivosEnum motivo) {
		List<MotivosEnum> motivos = new ArrayList<MotivosEnum>();
		motivos.add(motivo);
		return motivos;
	}
	
// Métodos
	public int getPrecio() {
		int total = PRECIO_BASE;
		
		if (this.especialista != EspecialistasEnum.MEDICINA_GENERAL)
			total += PRECIO_ESPECIALISTA;
		
		switch (prioridad) {
		case 1 -> total += PR1;
		case 2 -> total += PR2;
		case 3 -> total += PR3;
		}
		
		return total;
	}
	
	public boolean addMotivo(MotivosEnum motivo) {
		return this.motivos.add(motivo);
	}
	
// toString
	public String toString() {
		return prioridad+" - "+horaVisita+" - "+numSS+" - "+nombre+" - "
				+motivos.toString()+" - "+especialista+" - "+this.getPrecio();
	}
	
// compareTo
	@Override
	public int compareTo(CitaMedica o) {
		int comparacion = Integer.compare(o.prioridad, this.prioridad);
		if (comparacion == 0)
			comparacion = this.horaVisita.compareTo(o.horaVisita);
		if (comparacion == 0)
			comparacion = this.nombre.compareTo(o.nombre);
		return comparacion;
	}
	
}
