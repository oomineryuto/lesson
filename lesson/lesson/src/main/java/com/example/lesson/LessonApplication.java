package com.example.lesson;

import com.example.lesson.Entity.ProductsRecord;
import com.example.lesson.Exception.ProductNotFoundException;
import com.example.lesson.repository.IProductsRepository;
import com.example.lesson.service.IProductsService;
import com.example.lesson.service.ProductsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LessonApplication {

	public static void main(String[] args) {
		// 戻り値を受け取る
		var context = SpringApplication.run(LessonApplication.class, args);

		// newが不要でインスタンスを取得できる
		var productsService = context.getBean(IProductsService.class);

		var list = productsService.findAll();
    	list.stream().forEach(System.out::println);
		var productsService2 = productsService.findById(1); // IDが1のユーザーのみを取得
		System.out.println(productsService2);
		try{var productsService3 = productsService.findById(5);}
		catch (ProductNotFoundException e){
			System.out.println("idが登録されていません");
		}
//		var productsRecord = new ProductsRecord(4, "ものさし", 10000);
//		productsService.insert(productsRecord);
//	    var user = productsService.findById(4);
//		System.out.println(user);
//		var productsRecord2 = new ProductsRecord(4,"はさみ",120);
//		productsService.update(productsRecord2);
//		var user2 = productsService.findById(4);
//		System.out.println(user2);
		System.out.println(productsService.delete(4));




	}
}
