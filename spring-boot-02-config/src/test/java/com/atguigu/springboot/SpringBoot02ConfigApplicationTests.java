package com.atguigu.springboot;

import com.atguigu.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试;
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;

	@Test
	public void contextLoads() {
		System.out.println(person);
	}

	@Autowired
	ApplicationContext ioc;

	@Test
	public void testHelloService(){
		boolean helloService = ioc.containsBean("helloService");
		boolean helloService02 = ioc.containsBean("helloService02");
		System.out.println("helloService:" + helloService);
		System.out.println("helloService02:" + helloService02);
	}

}
