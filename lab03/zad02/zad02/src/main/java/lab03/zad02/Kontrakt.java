package lab03.zad02;

import java.util.Random;

public class Kontrakt implements Psikus {
	Random random = new Random();
	public Integer cukierek = 0;

	public Integer CyfroKrad(Integer liczba) {
		if (liczba.toString().length()<2) return null;
		else if ((liczba.toString().length()<3) && (liczba.toString().equals("-"))) return null;
		else {
			if(liczba.toString().equals("-")){
				String convert = liczba.toString();
				int position = random.nextInt(convert.length()-1)+1;
				return (Integer.parseInt(convert.substring(0,position)+convert.substring(position+1)));
			
				
			} else {
				String convert = liczba.toString();
				int position = random.nextInt(convert.length());
				return (Integer.parseInt(convert.substring(0,position)+convert.substring(position+1)));
			}
		}
	}

	public Integer Nieksztaltek(Integer liczba) {
		String convert = liczba.toString();
		int position[] = new int[100], j=0;
		char [] convertChars = convert.toCharArray();
		for (int i = 0; i<convert.length(); i++){
			if (convertChars[i]=='3' || convertChars[i]=='6' || convertChars[i]=='7'){
				position[j]=i;
				j++;
			}
		}
		if (j==0) return liczba;
		else {
			int whereIsChange = random.nextInt(j);
			int whatChange = position[whereIsChange];
			if (convertChars[whatChange] =='3'){
				convertChars[whatChange]='8';
			}
			else if (convertChars[whatChange]=='7'){
				convertChars[whatChange]='1';
			}
			else if (convertChars[whatChange]=='6'){
				convertChars[whatChange]='9';
			}
			convert = String.valueOf(convertChars);
			return (Integer.parseInt(convert));
		}
	}


	public Integer Heheszki(Integer liczba) {
		if (liczba < 0) 
			throw new IllegalArgumentException();
		else if (liczba == 0) return 0;
		else return random.nextInt(liczba);
	}

	public boolean Titit(Integer liczba_dziel) {
		if (liczba_dziel == 0) throw new ArithmeticException();
		else if (liczba_dziel == null) throw new NullPointerException();
		else if (cukierek == 0) return true;
		else if (cukierek % liczba_dziel == 0) return true;
		else return false;
	}

	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusException {
		String convert = liczba.toString();
		char [] convertChars = convert.toCharArray();
		if (liczba == null) throw new NullPointerException();
		else if (liczba >= -9 && liczba <=9 ) throw new NieudanyPsikusException();
		else if (liczba % 10 == 0 && liczba >=-90 && liczba <= 90) throw new NieudanyPsikusException();
		else {
			int digit1 = random.nextInt(liczba.toString().length());
			int digit2 = random.nextInt(liczba.toString().length());
			if (convertChars[digit1]=='-') digit1++;
			if (convertChars[digit2] =='-') digit2++;	
			while (digit1 == digit2) {
				digit2 = random.nextInt(liczba.toString().length());
				if (convertChars[digit1]=='-') digit1++;
				if (convertChars[digit2] =='-') digit2++;	
			}
			char temp = convertChars[digit1];
			convertChars[digit1] = convertChars[digit2];
			convertChars[digit2] = temp;
		}
		convert = String.valueOf(convertChars);
		return (Integer.parseInt(convert));
	}

}
