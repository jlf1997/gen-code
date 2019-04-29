package com.cecii;

import java.io.UnsupportedEncodingException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.cimr.boot.convert.EnableHttpConvert;
import com.cimr.boot.swagger.EnableSwagger2Doc;


/**
 * 
 * @author slwu
 *
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
@EnableSwagger2Doc
@EnableHttpConvert
@EnableScheduling
@MapperScan("com.cecii.api.lanecur.dao")
@EnableFeignClients
public class CimrServerApplication {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		SpringApplication.run(CimrServerApplication.class, args);
	}
	
}
