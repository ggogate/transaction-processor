package test;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMetrics;

import demo.vo.Merchant;

public class App {

	public static void main(String[] args) {
		//Ignition.setClientMode(true);
		Ignite ignite = Ignition.start();
		final String CACHE_NAME = "merchant-characteristics";
        try (IgniteCache<String, Merchant> cache = ignite.getOrCreateCache(CACHE_NAME)) {
        	CacheMetrics metrics = cache.metrics();
        	System.out.println("Cache entries read: " + metrics.getSize());
        }finally{
        	//ignite.close();
        }

	}

}
