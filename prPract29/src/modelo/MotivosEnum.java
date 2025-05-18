package modelo;

public enum MotivosEnum {

	SIN_ESPECIFICAR("Sin especificar"),
	FIEBRE_MUY_ALTA("Fiebre muy alta"),
	PROTOCOLO_INFARTO("Protocolo infarto"),
	PROTOCOLO_PERITONITIS("Protocolo peritonitis"),
	DOLOR_TORACICO("Dolor torácico"),
	DOLOR_ABDOMINAL_INTENSO("Dolor abdominal intenso"),
	DIFICULTAD_RESPIRATORIA("Dificultad respiratoria"),
	SOSPECHA_ICTUS("Sospecha de ictus"),
	HIPOGLUCEMIA_SEVERA("Hipoglucemia severa"),
	CRISIS_EPILEPTICA("Crisis epiléptica"),
	TRAUMATISMO_CRANEOENCEFALICO("Traumatismo craneoencefálico"),
	HERIDA_ABIERTA("Herida abierta"),
	QUEMADURA_EXTENSA("Quemadura extensa"),
	PERDIDA_DE_CONSCIENCIA("Pérdida de consciencia"),
	VOMITOS_CON_SANGRE("Vómitos con sangre"),
	HEMORRAGIA_ABUNDANTE("Hemorragia abundante"),
	RETENCION_URINARIA("Retención urinaria"),
	REACCION_ALERGICA_GRAVE("Reacción alérgica grave"),
	INTOXICACION_MEDICAMENTOSA("Intoxicación medicamentosa"),
	ACCIDENTE_DE_TRAFICO("Accidente de tráfico");
	
	private String descripcion;
	public String getDescripcion() {return descripcion;}
	
	private MotivosEnum(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return descripcion;
	}
}
