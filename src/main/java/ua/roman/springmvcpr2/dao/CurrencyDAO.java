package ua.roman.springmvcpr2.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import ua.roman.springmvcpr2.models.Avto;
import ua.roman.springmvcpr2.models.Currency;

import java.util.List;

@Controller
public class CurrencyDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CurrencyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Currency> index() {
        return  jdbcTemplate.query("SELECT * FROM Currency", new BeanPropertyRowMapper<>(Currency.class));

    }

    public Currency show(int id) {
        return jdbcTemplate.query("SELECT * FROM Currency WHERE ID=?"
                , new Object[]{id},
                new BeanPropertyRowMapper<>(Currency.class)).stream().findAny().orElse(null);
    }

    public void change(int id, Currency currency) {
        jdbcTemplate.update("UPDATE Currency SET VALUE=? WHERE ID=?",
                currency.getValue(),
                id
        );
    }

    /*public void changeAvto(float dol, Currency currency) {
        jdbcTemplate.update("UPDATE Currency SET DOL=?, EURO=? WHERE DOL=?",
                currency.getDollar(),
                currency.getEuro(),
                dol
        );
    }*/

}
