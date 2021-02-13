package com.oracle;

import com.oracle.model.SalesOrder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesOrderDemo {

    public static void main(String[] args) {
        getSalesOrderData();
    }

    private static final String QUERY = "select * from sales_order fetch first 1000 rows only";

    public static List<SalesOrder> getSalesOrderData() {

        List<SalesOrder> salesOrders = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                SalesOrder salesOrder = new SalesOrder();
                int saleId = rs.getInt("SALE_ID");
                String region = rs.getString("REGION");
                String country = rs.getString("COUNTRY");
                String itemType = rs.getString("ITEM_TYPE");
                String saleChannel = rs.getString("SALES_CHANNEL");
                salesOrder.setSalesId(saleId);
                salesOrder.setRegion(region);
                salesOrder.setCountry(country);
                salesOrder.setItemType(itemType);
                salesOrder.setSalesChannel(saleChannel);

                salesOrders.add(salesOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesOrders;
    }
}
