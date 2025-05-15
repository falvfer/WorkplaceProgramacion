package test;

import modelo.*;

public class TestModelo {
	
	public static void main(String[] args) {
		
		// Crear una nueva agenda
        AgendaCitas agenda = new AgendaCitas();

        // Añadir varias citas médicas
        CitaMedica cita1 = new CitaMedica("123456789012", "Juan Pérez", 
            MotivosEnum.DOLOR_TORACICO, EspecialistasEnum.CARDIOLOGIA, "10:00");
        
        CitaMedica cita2 = new CitaMedica((byte)1, "123456789012", "Ana López", 
            MotivosEnum.FIEBRE_MUY_ALTA, EspecialistasEnum.MEDICINA_GENERAL, "11:30");
        
        CitaMedica cita3 = new CitaMedica((byte)3, "123456789012", "Carlos Ruiz", 
            MotivosEnum.CRISIS_EPILEPTICA, EspecialistasEnum.NEUMOLOGIA, "09:15");
        
        CitaMedica cita4 = new CitaMedica((byte)2, "987654321000", "Lucía García",
        	    MotivosEnum.SOSPECHA_ICTUS, EspecialistasEnum.NEUROLOGIA, "08:45");
        cita4.addMotivo(MotivosEnum.FIEBRE_MUY_ALTA);

    	CitaMedica cita5 = new CitaMedica((byte)1, "555666777888", "Miguel Torres",
    	    MotivosEnum.VOMITOS_CON_SANGRE, EspecialistasEnum.GASTROENTEROLOGIA, "13:00");

    	CitaMedica cita6 = new CitaMedica("444333222111", "Sofía Martínez",
    	    MotivosEnum.HIPOGLUCEMIA_SEVERA, EspecialistasEnum.ENDOCRINOLOGIA, "12:15");

    	CitaMedica cita7 = new CitaMedica("222111000999", "Raúl Fernández",
    	    MotivosEnum.REACCION_ALERGICA_GRAVE, EspecialistasEnum.MEDICINA_INTERNA, "15:30");
        cita7.addMotivo(MotivosEnum.DOLOR_TORACICO);

    	CitaMedica cita8 = new CitaMedica((byte)2, "333222111000", "Elena Navarro",
    	    MotivosEnum.TRAUMATISMO_CRANEOENCEFALICO, EspecialistasEnum.TRAUMATOLOGIA, "10:30");

        // Agregar citas a la agenda
        agenda.addCita(cita1);
        agenda.addCita(cita3);
        agenda.addCita(cita2);
        agenda.addCita(cita4);
        agenda.addCita(cita6);
        agenda.addCita(cita5);
        agenda.addCita(cita8);
        agenda.addCita(cita7);

        // Mostrar todas las citas
        System.out.println(agenda+"\n");

        // Ordenar la lista
        agenda.ordenaCitas();

        // Mostrar todas las citas
        System.out.println(agenda);
        
		
	}

}
