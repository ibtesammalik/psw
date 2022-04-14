package com.jwt.dao;

import java.sql.SQLException;
import java.util.Map;

import com.jwt.dto.response.TokenAcquisitionResponse;

public interface TokenManagementDao {

	Map<String, Object> addToken(TokenAcquisitionResponse dto, String code) throws SQLException;

	Map<String, Object> getForInActiveToken(StringBuilder token, String wsCat) throws SQLException;

}
