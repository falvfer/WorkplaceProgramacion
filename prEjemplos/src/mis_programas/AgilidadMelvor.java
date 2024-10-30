package mis_programas;

public class AgilidadMelvor {

	public static void main(String[] args) {
		
/*		int []  ob01m = {6,8,4},
				ob02m = {45,34,27,40},
				ob03m = {63,24,67,56,96,92},
				ob04m = {80,45,140,96,66,40},
				ob05m = {288,172,91,117,296,82},
				ob06m = {247,565,252,521,578,505},
				ob07m = {640,849,1035,598,777},
				ob08m = {2399,2200,2301,1228,2619,1603,2360},
				ob09m = {604,1560,888,1086,3898,3488},
				ob10m = {3257,7175,7626,2915,3380},
				ob11m = {5111,7044,4341,5130,8269},
				ob12m = {5478,6628,8552,6204,9164},
				ob13m = {9844,7567,9080,8682,8387},
				ob14m = {10897,9274,7123,10357,6659},
				ob15m = {11571,9899,10103,11556,13542};
		
		int[] ob01t = {4,4,6},
				ob02t = {5,4,3,7},
				ob03t = {9,4,9,6,5,5},
				ob04t = {7,6,8,7,8,6},
				ob05t = {6,4,5,4,10,13},
				ob06t = {7,11,10,14,11,13},
				ob07t = {9,5,8,8,13},
				ob08t = {12,12,8,12,14,11,8},
				ob09t = {8,10,5,15,6,5},
				ob10t = {14,20,23,15,23},
				ob11t = {24,31,19,22,27},
				ob12t = {20,24,25,23,34},
				ob13t = {34,42,38,27,38},
				ob14t = {32,39,28,35,36},
				ob15t = {48,36,27,41,44};
*/
		int []  ob01m = {1, 8},
				ob01t = {1, 4},
				ob02m = {3, 27,34,45},
				ob02t = {3, 3,4,5},
				ob03m = {2, 24,96},
				ob03t = {2, 4,5},
				ob04m = {3, 45,96,140},
				ob04t = {3, 6,7,8},
				ob05m = {3, 172,288,296},
				ob05t = {3, 4,6,10},
				ob06m = {3, 247,252,578},
				ob06t = {3, 7,10,11},
				ob07m = {2, 849,1035},
				ob07t = {2, 5,8},
				ob08m = {3, 2360,2399,2619},
				ob08t = {3, 8,12,14},
				ob09m = {2, 3488,3898},
				ob09t = {2, 5,6},
				ob10m = {3, 3257,7175,7626},
				ob10t = {3, 14,20,23},
				ob11m = {3, 4341,5130,8269},
				ob11t = {3, 19,22,27},
				ob12m = {5, 5478,6204,6628,8552,9164},
				ob12t = {5, 20,23,24,25,34},
				ob13m = {2, 8682,9844},
				ob13t = {2, 27,34},
				ob14m = {2, 7123,10897},
				ob14t = {2, 28,32},
				ob15m = {3, 10103,11556,13542},
				ob15t = {3, 27,41,44},
				cont = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		
		float sumaM = 0, sumaT=0, total=0, max = 0;
		String resultado = "";
		
		while (cont[1]<=ob01m[0]) {
			while (cont[2]<=ob02m[0]) {
				while (cont[3]<=ob03m[0]) {
					while (cont[4]<=ob04m[0]) {
						while (cont[5]<=ob05m[0]) {
							while (cont[6]<=ob06m[0]) {
								while (cont[7]<=ob07m[0]) {
									while (cont[8]<=ob08m[0]) {
										while (cont[9]<=ob09m[0]) {
											while (cont[10]<=ob10m[0]) {
												while (cont[11]<=ob11m[0]) {
													while (cont[12]<=ob12m[0]) {
														while (cont[13]<=ob13m[0]) {
															while (cont[14]<=ob14m[0]) {
																while (cont[15]<=ob15m[0]) {
																	
																	sumaM = ob01m[cont[1]] + ob02m[cont[2]]
																		  + ob03m[cont[3]] + ob04m[cont[4]]
																		  + ob05m[cont[5]] + ob06m[cont[6]]
																		  + ob07m[cont[7]] + ob08m[cont[8]]
																		  + ob09m[cont[9]] + ob10m[cont[10]]
																		  + ob11m[cont[11]] + ob12m[cont[12]]
																		  + ob13m[cont[13]] + ob14m[cont[14]] + ob15m[cont[15]];

																	sumaT = ob01t[cont[1]] + ob02t[cont[2]]
																		  + ob03t[cont[3]] + ob04t[cont[4]]
																		  + ob05t[cont[5]] + ob06t[cont[6]]
																		  + ob07t[cont[7]] + ob08t[cont[8]]
																		  + ob09t[cont[9]] + ob10t[cont[10]]
																		  + ob11t[cont[11]] + ob12t[cont[12]]
																		  + ob13t[cont[13]] + ob14t[cont[14]] + ob02t[cont[15]];
																	
																	total=sumaM*3600/sumaT;
																	if (total>max) {
																		resultado = "Obstaculo 1: " + ob01m[cont[1]] + ", " + ob01t[cont[1]] + "\n" +
																					"Obstaculo 2: " + ob02m[cont[2]] + ", " + ob02t[cont[2]] + "\n" +
																					"Obstaculo 3: " + ob03m[cont[3]] + ", " + ob03t[cont[3]] + "\n" +
																					"Obstaculo 4: " + ob04m[cont[4]] + ", " + ob04t[cont[4]] + "\n" +
																					"Obstaculo 5: " + ob05m[cont[5]] + ", " + ob05t[cont[5]] + "\n" +
																					"Obstaculo 6: " + ob06m[cont[6]] + ", " + ob06t[cont[6]] + "\n" +
																					"Obstaculo 7: " + ob07m[cont[7]] + ", " + ob07t[cont[7]] + "\n" +
																					"Obstaculo 8: " + ob08m[cont[8]] + ", " + ob08t[cont[8]] + "\n" +
																					"Obstaculo 9: " + ob09m[cont[9]] + ", " + ob09t[cont[9]] + "\n" +
																					"Obstaculo 10: " + ob10m[cont[10]] + ", " + ob10t[cont[10]] + "\n" +
																					"Obstaculo 11: " + ob11m[cont[11]] + ", " + ob11t[cont[11]] + "\n" +
																					"Obstaculo 12: " + ob12m[cont[12]] + ", " + ob12t[cont[12]] + "\n" +
																					"Obstaculo 13: " + ob13m[cont[13]] + ", " + ob13t[cont[13]] + "\n" +
																					"Obstaculo 14: " + ob14m[cont[14]] + ", " + ob14t[cont[14]] + "\n" +
																					"Obstaculo 15: " + ob15m[cont[15]] + ", " + ob15t[cont[15]] + "\n";
																		max=total;
																	}
																	cont[15]++;
																}
																cont[15]=1;
																cont[14]++;
															}
															cont[14]=1;
															cont[13]++;
														}
														cont[13]=1;
														cont[12]++;
													}	
													cont[12]=1;
													cont[11]++;
												}
												cont[11]=1;
												cont[10]++;
											}
											cont[10]=1;
											cont[9]++;
										}
										cont[9]=1;
										cont[8]++;
									}
									cont[8]=1;
									cont[7]++;
								}	
								cont[7]=1;
								cont[6]++;
							}
							cont[6]=1;
							cont[5]++;
						}
						cont[5]=1;
						cont[4]++;
					}
					cont[4]=1;
					cont[3]++;
				}
				cont[3]=1;
				cont[2]++;
			}	
			cont[2]=1;
			cont[1]++;
		}
		System.out.println(resultado);
		System.out.println("De "+(ob01m[0]*ob02m[0]*ob03m[0]*ob04m[0]*ob05m[0]*ob06m[0]*ob07m[0]*ob08m[0]*ob09m[0]*ob10m[0]*ob11m[0]*ob12m[0]*ob13m[0]*ob14m[0]*ob15m[0])+" posibilidades, esa es la mejor.");
	}
}