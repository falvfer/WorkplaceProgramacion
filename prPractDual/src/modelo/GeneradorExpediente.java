package prPractDual;

import java.util.Random;

public class GeneradorExpediente {
	
	private static Random rdn;
	private static final String[] nombres = {
		    "Alejandro", "Beatriz", "Carlos", "Diana", "Eduardo", "Fernanda", "Gabriel", "Helena",
		    "Ignacio", "Julia", "Luis", "Marina", "Nicolás", "Olga", "Pablo", "Raquel", "Sergio", "Teresa"
	}, apellidos = {
		    "García", "Fernández", "López", "Martínez", "Sánchez", "Pérez", "González", "Rodríguez",
		    "Díaz", "Moreno", "Álvarez", "Torres", "Romero", "Rubio", "Jiménez", "Ortega", "Navarro", "Castro"
	};
	
	public GeneradorExpediente() {
		rdn = new Random();
	}
	
	public Expediente next(short numExpediente, short anno) {
		SeccionExpediente seccion = genSeccion();
		return new Expediente(0, numExpediente, anno, seccion, genSubseccion(seccion),
								genDescripcion(numExpediente, anno), genNombres());
	}
	
	private SeccionExpediente genSeccion() {
		return SeccionExpediente.values()[rdn.nextInt(0,SeccionExpediente.values().length-1)];
	}
	
	private SubseccionExpediente genSubseccion(SeccionExpediente seccion) {
		return SubseccionExpediente.values()[rdn.nextInt(seccion.getIniSub(),seccion.getFinSub())];
	}

	private String genDescripcion(short numExpediente, short anno) {
		return "Descripción del expediente " + numExpediente + "/" + anno + " de ejemplo.";
	}
	
	private String genNombres() {
		String str = nombres[rdn.nextInt(0,nombres.length-1)]
				+ " " + apellidos[rdn.nextInt(0,apellidos.length-1)]
				+ " " + apellidos[rdn.nextInt(0,apellidos.length-1)];
		while (rdn.nextBoolean()) {
			str += ", " + nombres[rdn.nextInt(0,nombres.length-1)]
					+ " " + apellidos[rdn.nextInt(0,apellidos.length-1)]
					+ " " + apellidos[rdn.nextInt(0,apellidos.length-1)];
		};
		return str;
	}

}
