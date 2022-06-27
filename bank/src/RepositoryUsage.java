import model.City;
import reposity.CityRepository;

import java.io.IOException;
import java.sql.SQLException;

public class RepositoryUsage {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        CityRepository repository = new CityRepository();
        City moscow = new City("Moscow");
        repository.create(moscow);

    }
}
