package com.AppBuilding.Repository;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Repository;

import com.AppBuilding.Model.Schedule;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedules, Long> {

	    List<Schedule> findByUserIdAndDayOfWeek(Long userId, DayOfWeek dayOfWeek);

		List<Schedule> findByUserId(Long userId);

		List<Schedule> findByUserIdAndIsWeekday(Long userId, boolean b);

		Schedule save(Schedule schedule);

	}


