package ua.roman.springmvcpr2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import ua.roman.springmvcpr2.models.Avto;

import java.util.List;

@Controller
public class AvtoDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AvtoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Avto> index() {
        return  jdbcTemplate.query("SELECT * FROM AVTO", new BeanPropertyRowMapper<>(Avto.class));

    }

    public Avto show(int id) {
        return jdbcTemplate.query("SELECT * FROM AVTO WHERE ID=?"
                , new Object[]{id},
                new BeanPropertyRowMapper<>(Avto.class)).stream().findAny().orElse(null);
    }

    public void add(Avto avto) {
        jdbcTemplate.update("INSERT INTO AVTO VALUES (?,?,?,?,?)",
                avto.getId(),
                avto.getNumber(),
                avto.getPrice(),
                avto.getMarka(),
                avto.getCurrency());
    }

    public void change(int id, Avto avto) {
        jdbcTemplate.update("UPDATE AVTO SET NUMBER=?, PRICE=?, MARKA=?, CURRENCY=? WHERE ID=?",
                avto.getNumber(),
                avto.getPrice(),
                avto.getMarka(),
                avto.getCurrency(),
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM AVTO WHERE id=?", id);
    }
}
