package com.ShoppingAPI.Shopping.service.ShowCycleServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ShoppingAPI.Shopping.dao.ShowCycleDao;
import com.ShoppingAPI.Shopping.entity.ShowCycle;
import com.ShoppingAPI.Shopping.service.ShowCycleService;

@Service
public class ShowCycleServiceImpl implements ShowCycleService {
	
	@Autowired
	private ShowCycleDao showCycleDao;

	@Override
	public ResponseEntity<Boolean> addShowCycle(ShowCycle showCycle) {
		if(showCycle!=null) {
			try {
				showCycleDao.save(showCycle);
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<List<ShowCycle>> getShowCycles(long movieId) {
		if(movieId>0) {
			var showCycle = showCycleDao.findAll(movieId);
			if(showCycle!=null) {
				return new ResponseEntity<List<ShowCycle>>(showCycle,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<ShowCycle>>(HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<List<ShowCycle>>(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Boolean> deleteShowCycle(long showCycleId) {
		if(showCycleId>0) {
			var showCycle = showCycleDao.findById(showCycleId);
			if(showCycle!=null) {
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Boolean> updateShowCycle(ShowCycle showCycle) {
		if(showCycle!=null) {
			var id=showCycle.getShowCycleId();
			var _showCycle = showCycleDao.findById(id);
			if(_showCycle!=null) {
				try {
					showCycleDao.save(showCycle);
					return new ResponseEntity<Boolean>(true,HttpStatus.OK);
				}
				catch(Exception e) {
					return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			else {
				return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.NO_CONTENT);
		}
	}

}
