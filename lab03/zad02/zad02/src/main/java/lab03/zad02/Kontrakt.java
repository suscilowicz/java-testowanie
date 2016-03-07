package lab03.zad02;

import java.util.Random;

public class Kontrakt implements Psikus {
	Random random = new Random();

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
		// TODO Auto-generated method stub
		return 0;
	}

	public Integer Heheszki(Integer liczba) {
		// TODO Auto-generated method stub
		return 0;
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
