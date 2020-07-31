package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String a = "1";
		
		List<String> list = new ArrayList<>();

		for(String temp : a.split("")) {
			list.add(temp);
		}
		
		System.out.println(Arrays.toString(list.toArray()));
	}

}
