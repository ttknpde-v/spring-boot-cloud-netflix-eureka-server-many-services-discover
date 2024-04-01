package com.ttknpdev.client.service;

import com.ttknpdev.client.entity.Mobile;
import com.ttknpdev.client.postgres.Command;
import com.ttknpdev.client.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Service
public class MobileService implements MobileRepository<Mobile> , RowMapper<Mobile> {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public MobileService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Mobile> reads() {
        // return jdbcTemplate.query(Command.MOBILES_READS, this::mapRow);
        List<Mobile> mobiles = jdbcTemplate.query(Command.MOBILES_READS, this); // can write one line
        return mobiles;
    }

    @Override
    public Mobile read(Long id) {
        return jdbcTemplate.queryForObject(Command.MOBILES_READ,new Object[]{id},this);
    }

    @Override
    public Boolean create(Mobile obj) {
        Object[] objects = new Object[5];
        objects[0]=obj.getBrand();
        objects[1]=obj.getModel();
        objects[2]=obj.getStock();
        objects[3]=obj.getPrice();
        objects[4]=obj.getState();
        // Jdbc is not the same jpa
        // you have to know when you inserted into table
        // it is not returned your object Clear!
        int row = jdbcTemplate.update(Command.MOBILES_CREATE,objects);
        return row > 0;
    }

    @Override
    public Boolean update(Mobile obj, Long id) {
        Object[] objects = new Object[6];
        objects[0]=obj.getBrand();
        objects[1]=obj.getModel();
        objects[2]=obj.getStock();
        objects[3]=obj.getPrice();
        objects[4]=obj.getState();
        objects[5]=id;
        int row = jdbcTemplate.update(Command.MOBILES_UPDATE,objects);
        return row > 0;
    }

    @Override
    public Boolean delete(Long id) {
        int row = jdbcTemplate.update(Command.MOBILES_DELETE, id);
        return row > 0;
    }


    @Override
    public Mobile mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mobile mobile = new Mobile();
        mobile.setMid(rs.getLong("mid"));
        mobile.setBrand(rs.getString("brand"));
        mobile.setModel(rs.getString("model"));
        mobile.setStock(rs.getShort("stock"));
        mobile.setStock(rs.getShort("stock"));
        mobile.setPrice(rs.getFloat("price"));
        mobile.setState(rs.getBoolean("states"));
        return mobile;
    }
}
