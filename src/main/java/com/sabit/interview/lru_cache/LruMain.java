package com.sabit.interview.lru_cache;

public class LruMain {

	public static void main(String[] args) {

		LRUCache<String, String> cache = new LRUCache<>(3);
		cache.put("1", "11");
		cache.put("2", "22");
		cache.put("3", "33");
		System.out.println(cache.get("1"));
		cache.put("4", "44");
		System.out.println(cache.get("2")); 
		
	}

}
