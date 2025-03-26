package prPractDual;

public enum SubseccionExpediente {
	// GOBIERNO
	AYUNTAMIENTO("Consejo / Ayuntamiento"),
	ALCALDE("Alcalde"),
	COMISIONES_GOBIERNO("Comisiones de Gobierno"),
	COMISIONES_INFORMATIVAS("Comisiones inform. y esp."),
	
	// ADMINISTRACION
	SECRETARIA("Secretaría"),
	REGISTRO_GENERAL("Registro General"),
	PATRIMONIO("Patrimonio"),
	PERSONAL("Personal"),
	SERVICIOS_JURIDICOS("Servicios Jurídicos"),
	CONTRATACION("Contratación"),
	ARCHIVO("Archivo"),
	
	// SERVICIOS
	OBRAS("Obras y Urbanismo"),
	PROMOCION_ECONOMICA("Promoción Económica"),
	ABASTOS("Abastos y Consumo"),
	TRANSPORTES("Transportes"),
	SEGURIDAD_CIUDADANA("Seguridad Ciudadana"),
	SANIDAD("Sanidad"),
	BENEFICENCIA("Benef. y Asistencia Social"),
	EDUCACION("Educación"),
	CULTURA("Cultura"),
	DEPORTES("Deporte"),
	POBLACION("Población"),
	QUINTAS("Quintas"),
	ELECCIONES("Elecciones"),
	
	// HACIENDA
	INTERVENCION_ECONOMICA("Intervención Económica"),
	FINANCIACION("Financiación y Tributación"),
	TESORERIA("Tesorería");
	
	private String nombre;
	
	private SubseccionExpediente(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
