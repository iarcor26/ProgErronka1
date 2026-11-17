package ikuspegia;

public class Logoa {
	// Logoa sortu
	public void inprimatuLogo() {
		Integer lerroak = 3;
		for (Integer i = 0; i <= lerroak; i++) {
			for (Integer j = lerroak + 1; j <= lerroak + i; j++) {
				IO.print(" ");
			}
			for (Integer k = 0; k <= (lerroak * 2 - 1) - (2 * i - 1); k++) {
				IO.print("*");
			}
			IO.println();
		}
		Integer lerroa = 4;
		for (Integer i = 1; i <= lerroa; i++) {
			for (Integer j = 1; j <= lerroa - i; j++) {
				IO.print(" ");
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				IO.print("*");
			}
			IO.println();
		}
		Integer lerro = 4;
		for (Integer i = 1; i <= lerro; i++) {
			for (Integer j = 1; j <= lerro - i; j++) {
				IO.print(" ");
			}
			for (Integer k = 1; k <= (2 * i - 1); k++) {
				if (k == 1 || k == (2 * i - 1) || i == lerro) {
					IO.print("*");
				} else {
					IO.print(" ");
				}
			}
			IO.println();
		}
		Integer lerrok = 4;
		for (Integer i = 1; i <= lerrok; i++) {
			for (Integer j = 1; j <= lerrok - i; j++) {
				IO.print(" ");
			}
			for (Integer k = 1; k <= (2 * i - 1); k++) {
				if (k == i || i == lerro) {
					IO.print("*");
				} else {
					IO.print(" ");
				}
			}
			IO.println();
		}
		Integer le = 4;
		for (Integer i = 1; i <= le; i++) {
			for (Integer j = 1; j <= le - i; j++) {
				IO.print(" ");
			}
			for (Integer k = 1; k <= (2 * i - 1); k++) {
				if (k == 1 || k == (2 * i - 1)) {
					IO.print("*");
				} else {
					IO.print(" ");
				}
			}
			IO.println();
		}
	}
}
