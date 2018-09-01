package com.nousunde.wxma.service;

import com.nousunde.wxma.entity.Dock;
import com.nousunde.wxma.repository.DockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DockSvc {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DockRepository dockRepository;

    public List<Dock> getDockInfoByBookISBN(String bookISBN) {
        List<Dock> reslist = new ArrayList<Dock>();

        Iterable<Dock> iterlists = dockRepository.findAll();

        iterlists.forEach(dock -> {
                    if (bookISBN.equals(dock.getBarcode())) {
                        reslist.add(dock);
                    }
                }
        );
        return reslist;
    }

    public Boolean addDock(Dock dock) {
        if (dock == null)
            return false;
        Object object = dockRepository.save(dock);

        return true;
    }

    public Boolean updateDock(Dock dock){
        if (dock == null)
            return false;
        Object object = dockRepository.save(dock);
        return true;
    }
}
