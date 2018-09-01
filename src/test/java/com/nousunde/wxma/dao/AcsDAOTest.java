package com.nousunde.wxma.dao;

import com.nousunde.wxma.entity.Acs;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcsDAOTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    AcsDAO acsDAO;

    @Ignore
    @Test
    public void getAcs() {
        List<Acs> acsList = acsDAO.getAcs();
        logger.info("ACS data size: {}", acsList.size());
        assertEquals(1, acsList.size());
    }

    @Ignore
    @Test
    public void getAcsById() {
    }

    @Ignore
    @Test
    public void getAcsByUserId() {
        Acs acs = new Acs();
        acs = acsDAO.getAcsByUserId("402881e6650dfaf801650dfd05e10000");
        logger.info("{}",  acs.getAcsId());
    }

//    @Ignore
    @Test
    public void addAcs() {
        Acs acs = new Acs();
//        acs.setUserId("402881e6650dfaf801650dfd05e10000");//test
//        acs.setUserId("402881e6650eb62601650eb631090000");//nousunde
        acs.setUserId("402881e6650eb8aa01650eb8b4c80000");//a10
        acs.setKeytab("123123");
        acsDAO.addAcs(acs);
    }

    @Ignore
    @Test
    public void updateAcs() {
        Acs acs ;
//        acs = acsDAO.getAcsByUserId("402881e6650eb62601650eb631090000");//nousunde
        acs = acsDAO.getAcsByUserId("402881e6650eb8aa01650eb8b4c80000");//a10
        acs.setStatues((short) -1);
        acs.setUserMod((short) 4430);
        acs.setLastActiveTime(new Date().getTime());
        acsDAO.updateAcs(acs);

    }

    @Ignore
    @Test
    public void deleteAcsById() {
    }


}