package write.read;

import main.logic.InfoPerson;
import java.sql.*;

public class ConnectToBase implements WriteAndRead { // шаблон Singleton+FactoryMethod
    private static final ConnectToBase instance = new ConnectToBase();

    private ResultSet resSet = null;

    public static ConnectToBase getInstance () {
        return instance;
    }

    public ResultSet getResultSet () { return resSet; }

//    public static final String INSERT = "INSERT INTO persons (name) VALUE (?)";
//
//    public void insert (String name) {
//        firstConn();
//        try (PreparedStatement ps = conn.prepareStatement(INSERT)) {
//            ps.setString(1, name);
//            ps.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

    private String createInfoForBase (InfoPerson ip) {
        String n = ip.getName();
        String f = ip.getFamily();
        int a = ip.getAge();
        return "INSERT INTO persons (name, family, age) VALUE ('"+ n +"', '"+ f +"', '"+ a + "')";
    }
    @Override
    public void write (InfoPerson obj) {
        try {
            ConnectMySQL.getConnect().createStatement().execute(createInfoForBase(obj));
            ConnectMySQL.getConnect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void read (int id) {
        String exeQ = "SELECT * FROM persons WHERE id = " + id;
        System.out.println("in search");
        try {
            Statement stmt = ConnectMySQL.getConnect().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet rs = stmt.executeQuery(exeQ);
//            ResultSet rs = ConnectMySQL.getConnect().createStatement().executeQuery(exeQ);
//            while (rs.next()) {
//                System.out.println(rs.getString("name")+" "+rs.getString("family")+" "+
//                        rs.getString("age"));
//            }
//            saveInfoInLabel(rs);
            resSet = rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    private void saveInfoInLabel(ResultSet rs) {
//        String name = null;
//        String family = null;
//        String age = null;
//        try {
//            if (rs.next()) {
//                name = rs.getString("name");
//                family = rs.getString("family");
//                age = rs.getString("age");
//            } else {
//                MainOfFrame.fieldSearch.setText("Не найдено");
//            }
//        } catch (SQLException e ) {
//            e.printStackTrace();
//        }
//            MainOfFrame.labelFoundName.setText("Имя: " + name);
//            MainOfFrame.labelFoundFamily.setText("Фамилия: " + family);
//            MainOfFrame.labelFoundAge.setText("Возраст: " + age);
//
//    }
    public void delete (String id) {
        System.out.println("in delete");
        String exeUp = "DELETE FROM persons WHERE id = " + id;
        try {
            Statement stmt = ConnectMySQL.getConnect().createStatement();
            stmt.executeUpdate(exeUp);
            stmt.close();
            ConnectMySQL.getConnect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
