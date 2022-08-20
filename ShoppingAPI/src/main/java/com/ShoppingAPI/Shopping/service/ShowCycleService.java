package com.ShoppingAPI.Shopping.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ShoppingAPI.Shopping.entity.ShowCycle;

@Service
public interface ShowCycleService {
	
	public ResponseEntity<Boolean> addShowCycle(ShowCycle showCycle);
	public ResponseEntity<List<ShowCycle>> getShowCycles(long movieId);
	public ResponseEntity<Boolean> deleteShowCycle(long showCycleId);
	public ResponseEntity<Boolean> updateShowCycle(ShowCycle showCycle);

}
