package com.AppBuilding.Service;

import java.util.List;
import java.util.Map;

import com.AppBuilding.Model.Schedule;

public interface ScheduleService {
	List<Schedule> getWeeklySchedules(Long userId);

	List<Schedule> getSchedulesByUserId(Long userId);

	Map<String, List<Schedule>> getSchedulesByUserIdGroupedByDay(Long userId);

	Schedule addSchedule(Schedule schedule);

	void deleteSchedule(Long id);

	}

