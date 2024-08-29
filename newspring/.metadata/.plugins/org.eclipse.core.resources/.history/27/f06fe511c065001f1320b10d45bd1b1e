package com.springrest.springrest.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Dao.loadDao;
import com.springrest.springrest.entity.Load;

import java.util.List;

@Service
public class LoadServerImpl implements LoadServer {

    @Autowired   
    private loadDao loaddao;
    
    

    @Override
    public String addLoad(Load load) {
        loaddao.save(load);
        return "loads details added successfully";
    }

    @Override
    public List<Load> getLoad() {
        return loaddao.findAll();
    }

    @Override
    public Load getspecificLoad(String id) {
        return loaddao.findById(id).orElse(null);
    }

    @Override
    public String update(Load load, String id) {
        loaddao.save(load);
        return "Load updated successfully";
    }

    @Override
    public String delete(String loadId) {
        loaddao.deleteById(loadId);
        return "Load removed successfully";
    }
}
