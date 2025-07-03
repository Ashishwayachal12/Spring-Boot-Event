package com.jsp.event;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

	@Autowired
	EventRepository er;

	@RequestMapping("/save")
	public Event save(@RequestBody Event e) {
		return er.save(e);
	}

	@RequestMapping("/findall")
	public List<Event> findAlldetails(@RequestBody Event e) {
		return er.findAll();

	}

	@RequestMapping("/findid/{id}")
	public Event findbyid(@PathVariable int id) {
		Optional<Event> optional = er.findById(id);
		if (optional.isPresent()) {
			Event event = optional.get();
			return event;
		} else {
			return null;
		}
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Optional<Event> optional = er.findById(id);
		if (optional.isPresent()) {
			er.deleteById(id);
			return "Event deleted successfully...";
		} else {
			return "invalid id,unable to delete...";
		}
	}

}
