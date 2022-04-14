package com.bnamericas.holiday.service;

import java.util.List;

import com.bnamericas.holiday.entity.HolidayEntity;
import com.bnamericas.holiday.dto.HolidayDto;

public interface HolidayService {

    List<HolidayDto> findAll();

    List<HolidayEntity> saveHoliday();

    List<HolidayDto> responseHolidaySave();
}
