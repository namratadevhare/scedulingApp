package com.AppBuilding.Service;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppBuilding.Model.Schedule;
import com.AppBuilding.Repository.ScheduleRepository;

@Service
	public class ScheduleServiceImpl implements ScheduleService {

	    @Autowired
	    private ScheduleRepository scheduleRepository;

	    @Override
	    public List<Schedule> getSchedulesByUserId(Long userId) {
	        return scheduleRepository.findByUserId(userId);
	    }

	    @Override
	    public Map<String, List<Schedule>> getSchedulesByUserIdGroupedByDay(Long userId) {
	        Map<String, List<Schedule>> schedulesByDay = new HashMap<>();
	        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
	            List<Schedule> schedules = scheduleRepository.findByUserIdAndIsWeekday(userId, dayOfWeek.getValue() < 6);
	            schedulesByDay.put(dayOfWeek.toString(), schedules);
	        }
	        return schedulesByDay;
	    }

	    @Override
	    public Schedule addSchedule(Schedule schedule) {
	        return scheduleRepository.save(schedule);
	    }

	    @Override
	    public void deleteSchedule(Long id) {
	        scheduleRepository.deleteById(id);
	    }

		@Override
		public List<Schedule> getWeeklySchedules(Long userId) {
			// TODO Auto-generated method stub
			return null;
		}
	}


