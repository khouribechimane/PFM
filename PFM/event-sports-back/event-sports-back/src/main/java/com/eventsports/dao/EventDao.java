package com.eventsports.dao;

import com.eventsports.entity.Category;
import com.eventsports.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDao extends JpaRepository<Event, Integer> {

	List<Event> findByStatusOrderByIdDesc(String status);

	List<Event> findByStatusAndStartDateGreaterThan(String status, String startDate);

	List<Event> findByStatusAndCategoryAndStartDateGreaterThan(String status, Category category, String startDate);

	List<Event> findByStatusAndNameContainingIgnoreCaseAndStartDateGreaterThan(String status, String name,
                                                                               String startDate);

	List<Event> findByStatusAndCategory(String status, Category category);

}