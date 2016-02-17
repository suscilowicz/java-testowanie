package com.example.nwd;

public class NWD {
	public int nwd(int first, int second){
		if (first < 0 || second < 0) throw new IllegalArgumentException();
		else if (second == 0) return first;
		else return nwd(second,first%second);
	}
}
