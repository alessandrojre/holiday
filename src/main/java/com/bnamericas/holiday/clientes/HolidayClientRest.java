package com.bnamericas.holiday.clientes;

import java.util.List;

import com.bnamericas.holiday.dto.HolidayDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//	FeignClient para el consumo de endpoint (se pudo haber usado RestTemplate, Retrofit, WebClient )
//	dependiendo de la tecnologia a utilizar y de lo que se requiere
@FeignClient(name="holiday",url = "https://feriados-cl-api.herokuapp.com")
public interface HolidayClientRest {


	@GetMapping("/feriados")
	List<HolidayDto> listar();


}
