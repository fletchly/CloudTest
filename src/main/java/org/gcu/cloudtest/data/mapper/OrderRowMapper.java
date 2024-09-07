package org.gcu.cloudtest.data.mapper;

import org.gcu.cloudtest.data.entity.OrderEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return new OrderEntity(
                rs.getLong("ID"),
                rs.getString("ORDER_NO"),
                rs.getString("PRODUCT_NAME"),
                rs.getFloat("PRICE"),
                rs.getInt("QUANTITY")
        );
    }
}
