import java.sql.*;

public class ConnectToBase {
    static String JDBC_driver = "com.mysql.cj.jdbc.Driver";
    static String JDBC_url = "jdbc:mysql://localhost:3306/simpledatabase";
    static String JDBC_user = "root";
    static String JDBC_password = "483672";

    static Connection conn;
    private static void firstConn () {
        try { // подключаем драйвер СУБД
            Class.forName(JDBC_driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn = DriverManager.getConnection(JDBC_url, JDBC_user, JDBC_password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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


    public static String createInfoForBase (InfoPerson ip) {
        String n = ip.getName();
        String f = ip.getFamily();
        int a = ip.getAge();
        String insertStr = "INSERT INTO persons (name, family, age) VALUE ('"+ n +"', '"+ f +"', '"+ a + "')";
        return insertStr;
    }
    public static void add (String ins) {
        firstConn();
        try {
            conn.createStatement().execute(ins);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void search (int id) {
        String exeQ = "SELECT * FROM persons WHERE id = " + id;
        System.out.println("in search");
        firstConn();
        try {
            ResultSet rs = conn.createStatement().executeQuery(exeQ);
//            while (rs.next()) {
//                System.out.println(rs.getString("name")+" "+rs.getString("family")+" "+
//                        rs.getString("age"));
//            }
            saveInfoInLabel(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void saveInfoInLabel(ResultSet rs) {
        String name = null;
        String family = null;
        String age = null;
        try {
            if (rs.next()) {
                name = rs.getString("name");
                family = rs.getString("family");
                age = rs.getString("age");
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        }
            MainOfFrame.labelFoundName.setText("Имя: " + name);
            MainOfFrame.labelFoundFamily.setText("Фамилия: " + family);
            MainOfFrame.labelFoundAge.setText("Возраст: " + age);

    }


}
