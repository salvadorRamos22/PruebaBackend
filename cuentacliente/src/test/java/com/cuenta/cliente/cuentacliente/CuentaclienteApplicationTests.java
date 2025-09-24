package com.cuenta.cliente.cuentacliente;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CuentaclienteApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() throws Exception {

		try (Connection connection = dataSource.getConnection()) {

			assertThat(connection).isNotNull();

			System.out.println("✅ Conexión establecida con: " +
                    connection.getMetaData().getURL());
            System.out.println("👤 Usuario: " +
                    connection.getMetaData().getUserName());
            System.out.println("📦 Driver: " +
                    connection.getMetaData().getDriverName());
			
		} 
	}

}
