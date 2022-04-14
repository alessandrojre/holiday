package com.bnamericas.holiday.controllers;

import java.util.List;

import com.bnamericas.holiday.dto.HolidayDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnamericas.holiday.service.HolidayService;


@RestController
public class HolidayController {
	
	private static Logger log = LoggerFactory.getLogger(HolidayController.class);


	private final HolidayService holidayService;

	public HolidayController(HolidayService holidayService){
		this.holidayService = holidayService;
	}


	@GetMapping("/listar")
	public List<HolidayDto> listar(){
		return holidayService.findAll();
	}


	@PostMapping("/save")
	public List<HolidayDto> save(){
		return holidayService.responseHolidaySave();
	}

}
