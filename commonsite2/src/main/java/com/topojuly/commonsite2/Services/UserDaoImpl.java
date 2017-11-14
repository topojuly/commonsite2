package com.topojuly.commonsite2.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.topojuly.commonsite2.Domains.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(rollbackFor={IllegalArgumentException.class})
    public int add(User user) {
        return jdbcTemplate.update("insert into t_author(real_name, nick_name) values(?, ?)",
        		user.getUserName(), user.getPassword());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("update t_author set real_name = ?, nick_name = ? where id = ?",
                new Object[]{user.getUserName(), user.getPassword(),user.getId()});
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from t_author where id = ?", id);
    }

    @Override
    public User findUser(Long id) {
        List<User> list = jdbcTemplate.query("select * from t_author where id = ?", new Object[]{id}, new BeanPropertyRowMapper(User.class));
        if(null != list && list.size()>0){
        	User auhtor = list.get(0);
            return auhtor;
        }else{
            return null;
        }
    }
    @Override
    public List<User> findUserList() {
        List<User> list = jdbcTemplate.query("select * from t_author", new Object[]{}, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }
}

