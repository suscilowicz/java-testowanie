package sample.projekt3;

public class Haszowanie {
	public Integer m;
	public Integer[] tabHaszujaca;
	//H(k,i) = (h(k)+i) mod m, gdzie h(k) = k mod m
	
	Haszowanie (Integer m){
		if (m == 1 || m%2 == 0 || m%3 == 0 || m%5 == 0 || m%7 == 0 || m%11 == 0){
			throw new IllegalArgumentException();
		}
		this.m = m;
		tabHaszujaca = new Integer[m];
	}
	
	public Integer h (Integer k){
		if(k == null) throw new NullPointerException();
		if (k<0) throw new IllegalArgumentException();
		return k%m;
	}
	
	public void dodajHasz (Integer k){
		Integer h = h(k);
		boolean petla = true;
		while (petla){
			if (tabHaszujaca[h].equals(null)){
				tabHaszujaca[h] = k;
				petla = false;
			}
			else if (tabHaszujaca[h] == k) throw new IllegalArgumentException();
			else {
				h++;
				if (h == m-1) h=0;
				if (h == k) throw new IllegalArgumentException();
			}
		}
	}
	
	public boolean znajdzHasz (int k){
		Integer h = h(k);
		boolean petla = true;
		boolean wynik = false;
		while (petla){
			if (tabHaszujaca[h].equals(null) || tabHaszujaca[h]!=k){
				h++;
				if (h == m-1) h=0;
				if (h == k) petla = false;
			}
			else if (tabHaszujaca[h] == k) {
				petla = false;
				wynik = true;
			}
		}
		return wynik;
	}
	
	public void usunHash(int k){
		if (znajdzHasz(k)==false){
			throw new IllegalArgumentException();
		}
		else {
			Integer h = h(k);
			boolean petla = true;
			while (petla){
				if (tabHaszujaca[h].equals(null) || tabHaszujaca[h]!=k){
					h++;
					if (h == m-1) h=0;
					if (h == k) petla = false;
				}
				else if (tabHaszujaca[h] == k) {
					petla = false;
					tabHaszujaca[h] = null;
				}
			}
		}
	}
	
	
}
