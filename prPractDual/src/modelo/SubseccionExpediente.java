package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.Datos;

public enum SubseccionExpediente {
	// GOBIERNO
	AYUNTAMIENTO("Consejo / Ayuntamiento", SeccionExpediente.GOBIERNO),
	ALCALDE("Alcalde", SeccionExpediente.GOBIERNO),
	COMISIONES_GOBIERNO("Comisiones de Gobierno", SeccionExpediente.GOBIERNO),
	COMISIONES_INFORMATIVAS("Comisiones inform. y esp.", SeccionExpediente.GOBIERNO),
	
	// ADMINISTRACION
	SECRETARIA("Secretaría", SeccionExpediente.ADMINISTRACION),
	REGISTRO_GENERAL("Registro General", SeccionExpediente.ADMINISTRACION),
	PATRIMONIO("Patrimonio", SeccionExpediente.ADMINISTRACION),
	PERSONAL("Personal", SeccionExpediente.ADMINISTRACION),
	SERVICIOS_JURIDICOS("Servicios Jurídicos", SeccionExpediente.ADMINISTRACION),
	CONTRATACION("Contratación", SeccionExpediente.ADMINISTRACION),
	ARCHIVO("Archivo", SeccionExpediente.ADMINISTRACION),
	
	// SERVICIOS
	OBRAS("Obras y Urbanismo", SeccionExpediente.SERVICIOS),
	PROMOCION_ECONOMICA("Promoción Económica", SeccionExpediente.SERVICIOS),
	ABASTOS("Abastos y Consumo", SeccionExpediente.SERVICIOS),
	TRANSPORTES("Transportes", SeccionExpediente.SERVICIOS),
	SEGURIDAD_CIUDADANA("Seguridad Ciudadana", SeccionExpediente.SERVICIOS),
	SANIDAD("Sanidad", SeccionExpediente.SERVICIOS),
	BENEFICENCIA("Benef. y Asistencia Social", SeccionExpediente.SERVICIOS),
	EDUCACION("Educación", SeccionExpediente.SERVICIOS),
	CULTURA("Cultura", SeccionExpediente.SERVICIOS),
	DEPORTES("Deporte", SeccionExpediente.SERVICIOS),
	POBLACION("Población", SeccionExpediente.SERVICIOS),
	QUINTAS("Quintas", SeccionExpediente.SERVICIOS),
	ELECCIONES("Elecciones", SeccionExpediente.SERVICIOS),
	
	// HACIENDA
	INTERVENCION_ECONOMICA("Intervención Económica", SeccionExpediente.HACIENDA),
	FINANCIACION("Financiación y Tributación", SeccionExpediente.HACIENDA),
	TESORERIA("Tesorería", SeccionExpediente.HACIENDA);
	
	static Connection c;
	private String nombre;
	private SeccionExpediente seccion;
	
	public SeccionExpediente getSeccion() {return this.seccion;}
	
	private SubseccionExpediente(String nombre, SeccionExpediente seccion) {
		this.nombre = nombre;
		this.seccion = seccion;
	}
	
	public static SubseccionExpediente buscarPorNombre(String str) {
		boolean encontrado = false;
		SubseccionExpediente s = null;
		SubseccionExpediente[] subsecciones = SubseccionExpediente.values();
		for (int i = 0; i<subsecciones.length && !encontrado; i++) {
			if (subsecciones[i].toString().equals(str)) {
				encontrado = true;
				s = subsecciones[i];
			}
		}
		return s;
	}
	
	public static List<SubseccionExpediente> getValuesFromSeccion(SeccionExpediente sec) {
		List<SubseccionExpediente> subsecciones = new ArrayList<>();
		for (SubseccionExpediente sub: SubseccionExpediente.values()) {
			if (sub.seccion.toString().equals(sec.toString()))
				subsecciones.add(sub);
		}
		return subsecciones;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
