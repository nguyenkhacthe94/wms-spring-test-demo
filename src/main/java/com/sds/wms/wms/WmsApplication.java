package com.sds.wms.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sds.wms.wms.units.UnitService;
import com.sds.wms.wms.units.UnitServiceImpl;

@SpringBootApplication
public class WmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmsApplication.class, args);
	}

	@Bean
	public UnitService unitService() {
		return new UnitServiceImpl();
	}
}
