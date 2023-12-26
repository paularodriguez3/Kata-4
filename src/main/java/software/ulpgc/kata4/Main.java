package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:FoodDB.db");
        List<Food> foods = new SQLiteFoodLoader(connection).loadall();
        for(Food food : foods){
            System.out.println(food);
        }
    }
}
