package software.ulpgc.kata4;

import java.sql.SQLException;
import java.util.List;

public interface FoodLoader {
    List<Food> loadall() throws SQLException;
}
