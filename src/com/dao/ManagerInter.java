
package com.dao;

import com.domain.Manager;
import com.domain.vo.MagStation;

import java.sql.SQLException;
import java.util.List;

    public interface ManagerInter {

        public List<Manager> findall() throws SQLException;

        public  Manager findByid(int manager_id) throws SQLException;

        public  int insert(Manager manager) throws SQLException;

        public int update(Manager manager) throws SQLException;

        public int delete(int manager_id) throws SQLException;

        public List<MagStation> findAllScores() throws SQLException;
    }

