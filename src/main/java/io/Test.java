package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import org.apache.commons.io.IOUtils;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Map<String,String> map = new HashMap<>();
		map.put("APPLE LAI", "123");
		map.put("APPLE LAI 1", "123");
		map.put("APPLE LAI 22", "123");
		map.put("APPLE LAI (分鐘)", "123222");
		
		System.out.println(map.get("APPLE LAI (分鐘)"));
		
		
		Map<String,Integer> map1 = new HashMap<>();
//		map1.put("A", 1);
//		map1.put("B", 2);
//		Integer integer = map1.get("B");
//		map1.put("B", integer+2);
//		
//		System.out.println(map.get("B"));
		
		List<Integer> n = Arrays.asList(1,2,3,4);
//		 n.stream().mapToInt(x -> {
//			 if(x % 2 == 0) {
//				 return x*x;
//			 }
//		 }).sum();
		int sum = n.stream().filter(x -> x%2 == 0).mapToInt(x -> x*x).sum();
		System.out.println(sum);
		
	}
}
