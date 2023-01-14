package com.github.filipmalczak.inwent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@PropertySource("classpath:application-test.yml")
class InwentApplicationTests {

	@Container
	static final PostgreSQLContainer DB = new PostgreSQLContainer("postgres:15.1").withUsername("inwent").withPassword("inwent-pass").withDatabaseName("inwent");

	@Test
	void contextLoads() {
		var ctx = InwentApplication.run("--POSTGRES_PORT="+DB.getFirstMappedPort());
		ctx.close();
	}

}
