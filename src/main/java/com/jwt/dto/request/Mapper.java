package com.jwt.dto.request;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.jdbc.support.oracle.StructMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.StringUtils;



import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;


public class Mapper implements StructMapper<ObjGd> ,Serializable {

	@Override
	public STRUCT toStruct(ObjGd source, Connection conn, String typeName) throws SQLException {
		StructDescriptor descriptor = new StructDescriptor(typeName, conn);
		java.sql.ResultSetMetaData rsmd = descriptor.getMetaData();
		int columns = rsmd.getColumnCount();
		Object[] values = new Object[columns];
		for (int i = 1; i <= columns; i++) {
			String column = JdbcUtils.lookupColumnName(rsmd, i).toLowerCase();
			//    PropertyDescriptor fieldMeta = (PropertyDescriptor) this.mappedFields.get(column);
			/*    if (fieldMeta != null) {
		            BeanWrapper bw = new BeanWrapperImpl(source);
		            if (bw.isReadableProperty(fieldMeta.getName())) {
		                try {

		                       System.out.println("Mapping column named \"" + column + "\"" + " to property \"" + fieldMeta.getName() + "\"");

		                    values[i - 1] = bw.getPropertyValue(fieldMeta.getName());
		                } catch (NotReadablePropertyException ex) {
		                    throw new DataRetrievalFailureException("Unable to map column " + column + " to property " + fieldMeta.getName(), ex);
		                }
		            } else {
		            	System.out.println("Unable to access the getter for " + fieldMeta.getName() + ".  Check that " + "get" + StringUtils.capitalize(fieldMeta.getName()) + " is declared and has public access.");
		            }
		        }

			 */
			values[0]=	source.getFI_MOP();
			values[1]=	source.getFI_UNO();
		}
		
		Struct struct = conn.createStruct(typeName, values);
		return (STRUCT) struct;
	}

	@Override
	public ObjGd fromStruct(STRUCT struct) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}




}
