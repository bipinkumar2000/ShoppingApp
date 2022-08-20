package com.ShoppingAPI.Shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingAPI.Shopping.entity.ShowCycle;
import com.ShoppingAPI.Shopping.service.ShowCycleService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/movie/showcycle")
@RestController
public class ShowCycleController {
	
	@Autowired
	private ShowCycleService showCycleService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Boolean> addShowCycle(@RequestBody ShowCycle showCycle){
		return showCycleService.addShowCycle(showCycle);
	}
	
	@RequestMapping(value="/{movieId}",method=RequestMethod.GET)
	public ResponseEntity<List<ShowCycle>> getShowCycles(@PathVariable long movieId){
		return showCycleService.getShowCycles(movieId);
	}
	
	@RequestMapping(value="/{showCycleId}",method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteShowCycle(@PathVariable long showCycleId){
		return showCycleService.deleteShowCycle(showCycleId);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Boolean> updateShowCycle(@RequestBody ShowCycle showCycle){
		return showCycleService.updateShowCycle(showCycle);
	}

}
