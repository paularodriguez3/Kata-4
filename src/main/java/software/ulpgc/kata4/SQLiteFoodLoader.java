package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLiteFoodLoader implements FoodLoader{

    private final Connection connection;

    public SQLiteFoodLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Food> loadall() throws SQLException {
        return load(queryAll());
    }

    private ResultSet queryAll() throws SQLException {
        return connection.createStatement().executeQuery(queryAll());
    }

    private static final String queryAll = "SELECT * FROM dataset WHERE NAME = SCIENTIFICNAME";
    private List<Food> load(ResultSet resultSet) throws SQLException {
        List<Food> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(foodFrom(resultSet));
        }return list;
    }

    private Food foodFrom(ResultSet resultSet) throws SQLException {
        return new Food(
                resultSet.getString("NAME"),
                resultSet.getString("SCIENTIFICNAME"),
                resultSet.getString("GROUP"),
                resultSet.getString("SUBGROUP")
        );
    }
}
