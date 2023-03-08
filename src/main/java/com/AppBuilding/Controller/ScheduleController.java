package com.AppBuilding.Controller;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.AppBuilding.Model.Schedule;
import com.AppBuilding.Repository.ScheduleRepository;

public class ScheduleController {
	@Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/{userId}")
    public Map<String, List<Schedule>> getSchedules(@PathVariable Long userId) {
        Map<String, List<Schedule>> schedulesByDay = new HashMap<>();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            List<Schedule> schedules = scheduleRepository.findByUserIdAndDayOfWeek(userId, dayOfWeek);
            schedulesByDay.put(dayOfWeek.toString(), schedules);
        }
        return schedulesByDay;
    }
}
