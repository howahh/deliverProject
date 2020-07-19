package com.dao;

import com.domain.Fee;

import java.util.List;

public interface FeeInter {
    public List<Fee> findAll() throws Exception;
}
