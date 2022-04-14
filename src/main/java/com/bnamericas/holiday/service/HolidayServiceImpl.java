package com.bnamericas.holiday.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bnamericas.holiday.clientes.HolidayClientRest;
import com.bnamericas.holiday.entity.HolidayEntity;
import com.bnamericas.holiday.repository.HolidayRepository;
import com.bnamericas.holiday.dto.HolidayDto;
import org.springframework.stereotype.Service;

@Service
public class HolidayServiceImpl implements HolidayService {

	private final HolidayClientRest clientFeign;
	private final HolidayRepository holidayRepository;

	public HolidayServiceImpl(HolidayClientRest clientFeign,
							  HolidayRepository holidayRepository){
		this.clientFeign = clientFeign;
		this.holidayRepository = holidayRepository;
	}


	//	obtengo la informacion del endpoint consumido de feriados
	@Override
	public List<HolidayDto> findAll() {
		return clientFeign
				.listar();
	}

	//	se guarda la respuesta del endpoint feriados heroku
	@Override
	public List<HolidayEntity> saveHoliday(){
		List<HolidayEntity> listHoliday = findAll().stream().map(map -> {
			HolidayEntity entity = new HolidayEntity();
			entity.setDate(map.getDate());
			entity.setExtra(map.getExtra());
			entity.setTitle(map.getTitle());
			return entity;
		}).collect(Collectors.toList());

		return holidayRepository.saveAll(listHoliday);
	}


//	objeto dto para no exponer entity en el controlador
//	conversion de entity a dto
    @Override
	public List<HolidayDto> responseHolidaySave(){
		return saveHoliday().stream().map(map->{
			HolidayDto dto = new HolidayDto();
			dto.setDate(map.getDate());
			dto.setExtra(map.getExtra());
			dto.setTitle(map.getTitle());
			return dto;
		}).collect(Collectors.toList());
	}
}
