import java.sql.*;
import java.util.*;

public class EmployeDAO {

    public void save(Employe e) throws Exception {

        String sql = "INSERT INTO employes VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = DBConnection.getInstance().prepareStatement(sql);

        ps.setInt(1, e.id);
        ps.setString(2, e.nom);
        ps.setString(3, e.email);
        ps.setString(4, e.departement);
        ps.setDate(5, java.sql.Date.valueOf(e.dateEmbauche));

        ps.executeUpdate();
    }

    public Map<String, Double> getMasseSalarialeParDept() throws Exception {

        Map<String, Double> map = new HashMap<>();

        String sql = "SELECT departement, SUM(salaire_net) FROM employes GROUP BY departement";

        Statement st = DBConnection.getInstance().createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            map.put(rs.getString(1), rs.getDouble(2));
        }

        return map;
    }
}