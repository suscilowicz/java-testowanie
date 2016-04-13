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
			if (tabHaszujaca[h]==null){
				tabHaszujaca[h] = k;
				petla = false;
			}
			else if (tabHaszujaca[h] == k) throw new IllegalArgumentException();
			else {
				h++;
				if (h == m-1) h=0;
				if (h == k) throw new ArrayIndexOutOfBoundsException();
			}
		}
	}
	
	public Integer znajdzHasz (Integer k){
		Integer h = h(k);
		boolean petla = true;
		Integer wynik = null;
		while (petla){
			if (tabHaszujaca[h] == k) {
				petla = false;
				wynik = h;
			}
			else {
				h++;
				if (h == m-1) h=0;
				if (h == k) {
					petla = false;
					throw new IllegalArgumentException();
				}
			}
		}
		return wynik;
	}
	
	public void usunHash(int k){
		Integer h = h(k);
		boolean petla = true;
		while (petla){
			if (tabHaszujaca[h].equals(null) || tabHaszujaca[h]!=k){
				h++;
				if (h == m-1) h=0;
				if (h == k){
					petla = false;
					throw new IllegalArgumentException();
				}
			}
			else if (tabHaszujaca[h] == k) {
				petla = false;
				tabHaszujaca[h] = null;
			}
		}
		
	}	
}
