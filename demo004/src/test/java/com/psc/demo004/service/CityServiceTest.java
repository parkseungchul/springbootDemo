package com.psc.demo004.service;

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

import com.psc.demo004.model.City;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityServiceTest {

	@Autowired
	CityService cityService;
	
	
	
	@Before
	public void 모든_데이터_삭제() throws Exception{
		cityService.deleteAll();
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
		List<City> cityList = cityService.firstDbSelect();
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
		List<City> cityList = cityService.firstDbSelect();
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
		List<City> cityList = cityService.firstDbSelect();
		Assert.assertTrue(0 == cityList.size());
		
		cityList = cityService.secondDbSelect();
		Assert.assertTrue(0 == cityList.size());
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
		List<City> cityList = cityService.firstDbSelect();
		Assert.assertTrue(1 == cityList.size());
		
		cityList = cityService.secondDbSelect();
		Assert.assertTrue(1 == cityList.size());
	}
}
