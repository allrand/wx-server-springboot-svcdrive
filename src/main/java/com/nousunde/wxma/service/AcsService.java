package com.nousunde.wxma.service;

import com.nousunde.wxma.dao.AcsDAO;
import com.nousunde.wxma.entity.Acs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcsService {
    @Autowired
    private AcsDAO acsDAO;

    public List<Acs> getAcs(){
        return acsDAO.getAcs();
    }

    public Acs getAcsById(String acsId){
        return acsDAO.getAcsById(acsId);
    }

    public Acs getAcsByUserId(String userId){
        return acsDAO.getAcsByUserId(userId);
    }

    public void addAcs(Acs acs){
        acsDAO.addAcs(acs);
    }

    public void updateAcs(Acs acs){
        acsDAO.updateAcs(acs);
    }

    public void deleteAcsById(String acsId){
        acsDAO.deleteAcsById(acsId);
    }
}
