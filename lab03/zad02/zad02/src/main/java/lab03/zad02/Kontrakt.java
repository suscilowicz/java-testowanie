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
			else{
				convertChars[whatChange]='6';
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
		// TODO Auto-generated method stub
		return false;
	}

	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusException {
		// TODO Auto-generated method stub
		return 0;
	}

}
