package com.example.yu.journey0106;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yu on 2016/1/6.
 */
public class JourneyDB{

    String add = "INSERT INTO journey (jName) VALUES ";
    String delete = "DELETE FROM journey WHERE jId=";
    String read = "SELECT * FROM journey ";
    DBManager dbManager = new DBManager();

    public JourneyDB(){
    }

    public void addJourney(String jName){
        String sql = add+"(\""+jName+"\");";
        dbManager.DBexecuteUpdate(sql);
    }

    public void deleteJourney(String jId){
        String sql = delete+"\""+jId+"\"";
        dbManager.DBexecuteUpdate(sql);
    }

    public List<Journey> journeyList(){
        ResultSet resultSet = dbManager.DBexecute(read);
        List<Journey> journeyList = new ArrayList<Journey>();
        try {
            while (resultSet.next()){
                Journey journey = new Journey(resultSet.getString(0), resultSet.getString(1));
                journeyList.add(journey);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journeyList;
    }
}
