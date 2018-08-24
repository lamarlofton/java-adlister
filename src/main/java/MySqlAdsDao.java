import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;


public class MySqlAdsDao implements Ads {

    Config config = new Config();
    private Connection  connection;

    public MySqlAdsDao(Config config) {

        try {
            DriverManager.registerDriver(new Driver());
             this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public List<Ad> all() {
            try {
                Statement statement = connection.createStatement();
                String findAllQuery = "SELECT * FROM ads";
                ResultSet rs = statement.executeQuery(findAllQuery);
//                rs = statement.executeQuery(findAllQuery);
                return buildAds(rs);

            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Problem with building Ads");
            }
    }


    public Long insert(Ad ad) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO ads (user_id, title, description) VALUES('%d', '%s', '%s')",
                    ad.getUserId(),
                    ad.getTitle(),
                    ad.getDescription()
            );
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            return generatedKeys.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("ALERT, ALERT, ALERT");
        }
    }

    private List<Ad> buildAds(ResultSet rs) throws SQLException {
        List<Ad> Ads = new ArrayList<>();
        try {
            while (rs.next()) {
                Ads.add (
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Ads;
    }
}
