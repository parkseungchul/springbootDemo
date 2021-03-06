package com.psc.demo0042.transcation;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.psc.demo0042.db3.repository.CityRepository3;
import com.psc.demo0042.mapper.first.CityMapper1;
import com.psc.demo0042.mapper.second.CityMapper2;
import com.psc.demo0042.model.City;
import com.psc.demo0042.service.CityService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionTest {

	
	@Autowired
	CityMapper1 cityMapper1;
	
	@Autowired
	CityMapper2 cityMapper2;
	
	@Autowired
	CityRepository3 cityRepository;
	
	@Autowired
	CityService cityService;
	
	@Before
	@Transactional
	public void deleteAllDB() {
		cityMapper1.deleteCity1();
		cityMapper2.deleteCity2();
		cityRepository.deleteAll();
	}
	
	/**
	 * 트랜잭션이 롤백이 되므로 조회했을 경우 데이터가 0이 되어야 한다.
	 */
	@Test
	public void A001_DB1개에서의_트랜잭션_롤백Y(){
		try {
			cityService.transcationDB1RollBackY();
		}catch(Exception e) {
			e.printStackTrace();
		}
		List<City> cityList = cityService.cityDb1List();
		Assert.assertTrue(0 == cityList.size());
	} 
	
	/**
	 * 트랜잭션이 롤백이 되지 않음으로 조회했을 경우 데이터 갯수가 2이 되어야 한다.
	 */
	@Test
	public void A002_DB1개에서의_트랜잭션_롤백N(){
		try {
			cityService.transcationDB1RollBackN();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<City> cityList = cityService.cityDb1List();
		Assert.assertTrue(2 == cityList.size());
	}
	
	
	/**
	 * 트랜잭션이 묶여서 롤백 동작하므로 반드시 각각의 데이터 베이스에 커밋된것은 0이다.
	 */
	@Test
	public void B001_DB2개에서의_트랜잭션_롤백Y(){
		try {
			cityService.transcationDB2RollBackY();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<City> cityList1 = cityService.cityDb1List();
		List<City>  cityList2 = cityService.cityDb2List();
		
		Assert.assertTrue(0 == cityList1.size() && 0 == cityList2.size());
	}
	
	/**
	 * 트랜잭션이 별개로 동작하므로 각각의 데이터 베이스에 커밋된 것은 1이다.
	 */
	@Test
	public void B002_DB2개에서의_트랜잭션_롤백N(){
		try {

			cityService.transcationDB2RollBackN();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<City> cityList = cityService.cityDb1List();
		Assert.assertTrue(1 == cityList.size());
		
		cityList = cityService.cityDb2List();
		Assert.assertTrue(1 == cityList.size());
	}
	
	
	/**
	 * 트랜잭션이 묶여서 롤백 동작하므로 반드시 각각의 데이터 베이스에 커밋된것은 0이다.
	 */
	@Test
	public void C001_DB3개에서의_트랜잭션_롤백Y(){
		try {
			cityService.transcationDB3RollBackY();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<City> cityList1 = cityService.cityDb1List();
		List<City> cityList2 = cityService.cityDb2List();
		Assert.assertTrue(0 == cityList1.size() && 0 == cityList2.size() && !cityRepository.findAll().iterator().hasNext());
	}
	
	/**
	 * 트랜잭션이 별개로 동작하므로 각각의 데이터 베이스에 커밋된 것은 1이다.
	 */
	@Test
	public void C002_DB3개에서의_트랜잭션_롤백N(){
		try {

			cityService.transcationDB3RollBackN();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<City> cityList1 = cityService.cityDb1List();
		List<City> cityList2 = cityService.cityDb2List();
		Assert.assertTrue(1 == cityList1.size() && 1 == cityList2.size() && cityRepository.findAll().iterator().hasNext());
		
	}
}
