package com.jwt.dao;

import org.springframework.data.repository.CrudRepository;

import com.jwt.model.PswWsmsgs;

public interface MessageDao extends CrudRepository<PswWsmsgs, String>	 {

}
