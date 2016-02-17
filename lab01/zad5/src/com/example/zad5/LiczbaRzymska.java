package com.example.zad5;

public class LiczbaRzymska {
	private static String[] rzymskie = {"M", "CM", "D", "CD", "C","XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	private static int[] arabskie   = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	private int liczba;
	public LiczbaRzymska(int liczba){
		if (liczba < 1 || liczba > 3999) throw new IllegalArgumentException();
		else this.liczba = liczba;
	}
	public String toString(){
		String wynik = "";
		for (int i = 0; i < arabskie.length; i++) {
			while (liczba >= arabskie[i]) {
				wynik += rzymskie[i];
				liczba -= arabskie[i];
			}
		}
		return wynik;
	}
	
}
