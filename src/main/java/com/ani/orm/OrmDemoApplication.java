package com.ani.orm;

import com.ani.orm.mapping.MappingService;
import com.ani.orm.query.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmDemoApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrmDemoApplication.class, args);
//		query(ctx);
		mapping(ctx);
	}

	private static void query(ApplicationContext ctx) {
		BookService service = ctx.getBean(BookService.class);
//		service.methods();

//		service.query();
	}

	private static void mapping(ApplicationContext ctx) {
		MappingService service = ctx.getBean(MappingService.class);
		/*System.out.println("---Crafting Board---");
		service.craftBoard();
		System.out.println("---Crafting Board With Processor---");
		service.craftBoardWithProcessor();
		System.out.println("---Crafting Processor---");
		service.craftProcessor();
		System.out.println("---All Processors---");
		service.findAllProcessors();
		System.out.println("---Crafting Board With Chips---");
		service.craftBoardWithChips();
		System.out.println("---Crafting Chip---");
		service.craftChip();
		System.out.println("---All Chips on Board---");
		service.findAllChipsOnTheBoard();
		System.out.println("---Crafting VM---");
		service.craftVm();*/

		service.chipsOnTheBoard();

	}
}
