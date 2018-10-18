package com.spring.springdata;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringdataApplication {
	static Map<String, Long> orders = new ConcurrentHashMap<>();

	static void processOrders() {
		for(String city: orders.keySet()){
			for (int i = 0; i < 50 ; i++) {
				Long oldOrder = orders.get(city);
				orders.put(city, oldOrder + 1);
			}
		}
	}

	@Autowired
	Environment environment;



	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SpringdataApplication.class, args);
//		Map<Order, Integer> orders = new WeakHashMap<>();
//
//		orders.put(new Order(1, "cat"), 100);
//		orders.put(new Order(2, "dog"), 200);
//
//		Order o3 = new Order(3, "rat");
//
//		orders.put(o3, 300);
//
//		System.out.println(orders.size());
//		System.gc();
//		System.out.println(orders.size());

//		orders.put("a1", 1l);
//		orders.put("a2", 1l);
//		orders.put("a3", 1l);
//		orders.put("a4", 1l);
//		orders.put("a5", 1l);
//
//		ExecutorService service = Executors.newFixedThreadPool(2);
//		service.submit(SpringdataApplication::processOrders);
//		service.submit(SpringdataApplication::processOrders);
//
//		service.awaitTermination(1, TimeUnit.SECONDS);
//		System.out.println(orders);
	}
}