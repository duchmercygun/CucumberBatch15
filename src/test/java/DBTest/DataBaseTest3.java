package DBTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataBaseTest3 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");
            //Create a statement to send sql series
            Statement statement = conn.createStatement();
            String query = "select * from person;";
            ResultSet rset = statement.executeQuery(query);
            ResultSetMetaData rsmData = rset.getMetaData();

            //extract data from resultSet and store it in java data structure
            List <Map<String, String>> listFromRSet = new ArrayList<>();
            //iterate through every single row
            while (rset.next()){
                Map<String, String> map = new LinkedHashMap<>();
                //Iterate over columns
                for (int i=1; i<rsmData.getColumnCount(); i++){
                    //fetching key and value from the columns
                    String key = rsmData.getColumnName(i);
                    String value = rset.getString(key);
                    map.put(key, value);
                }
                System.out.println(map);
                listFromRSet.add(map);
            }
            }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
