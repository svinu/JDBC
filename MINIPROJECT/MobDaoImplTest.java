package com.cg.mob.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.mob.dao.MobDao;
import com.cg.mob.dao.MobDaoImpl;
import com.cg.mob.exception.MOBException;
import com.cg.mob.model.Mobile;

public class MobDaoImplTest {
	MobDao mobDao = null;

	@Before
	public void setUp() throws Exception {
		mobDao = new MobDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		mobDao = null;
	}

	@Test
	public void testInsertMobile() {
		Mobile mobile = new Mobile();
		mobile.setCustomerName("Vinod");
		mobile.setCustomerMailId("vinod@gmail.com");
		mobile.setCustomerPhoneNumber(9876543210l);
		mobile.setId(1001);
		try {
			int rows = mobDao.addMobileDetails(mobile);
			assertEquals(1,rows);
		} catch (MOBException e) {

			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetMobilesOnPrice() {
		
		Mobile mobile = new Mobile();
		mobile.setMinPrice(15000);
		mobile.setMaxPrice(16000);
		try {
			List<Mobile> list = mobDao.getMobilesOnPrice(mobile);
			assertEquals(1, list.size());
		} catch (MOBException e) {
			e.printStackTrace();
		}
		
	}

}
