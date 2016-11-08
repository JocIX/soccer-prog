package hu.icontest.soccer.prog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author developer
 */
public class DB {

    public static List<Players> readPlayer() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        List<Players> jatekosok = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:h2:~/probe", "sa", "");
        System.out.println("Siker van, more!");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from jatekosok");
        while (rs.next()) {
            String first_name = rs.getString("keresztnev");
            String last_name = rs.getString("vezeteknev");
            int age = rs.getInt("eletkor");
            String position = rs.getString("poszt");
            String nationality = rs.getString("nemzetiseg");

            String team = rs.getString("csapat");
            Teams _team = new Teams();
            _team.setName(team);

            Float current_salary = rs.getFloat("kereset");
            Float fitness = rs.getFloat("eronlet");
            Float skills = rs.getFloat("technika");
            Float value = rs.getFloat("piaci_ertek");
            Players jatekos = new Players(first_name, last_name, position, age, nationality, current_salary, fitness, skills, value);
            jatekos.setCurrent_team(_team);

            jatekosok.add(jatekos);
        }
        rs.close();

        conn.close();
        return jatekosok;
    }

    public static List<Coaches> readCoach() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        List<Coaches> edzok = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:h2:~/probe", "sa", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from edzok");
        while (rs.next()) {
            String first_name = rs.getString("keresztnev");
            String last_name = rs.getString("vezeteknev");
            int age = rs.getInt("eletkor");
            String nationality = rs.getString("nemzetiseg");
            int experience = rs.getInt("rutin");
            String accomplishment = rs.getString("legjobb_eredmeny");

            String team = rs.getString("csapat");
            Teams _team = new Teams();
            _team.setName(team);

            float salary = rs.getFloat("fizetes");
            Coaches edzo = new Coaches(first_name, last_name, age, experience, accomplishment, salary);
            edzo.setCurrent_team(_team);

            edzok.add(edzo);
        }
        rs.close();
        conn.close();
        return edzok;
    }

    public static List<Owners> readOwner() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        List<Owners> tulajok = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:h2:~/probe", "sa", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tulajdonosok");
        while (rs.next()) {
            String first_name = rs.getString("keresztnev");
            String last_name = rs.getString("vezeteknev");
            int age = rs.getInt("eletkor");
            String nationality = rs.getString("nemzetiseg");
            double net_worth = rs.getDouble("vagyon");
            double competence = rs.getDouble("hozzáértés");
            double control = rs.getDouble("kontroll");

            String team = rs.getString("csapat");
            Teams _team = new Teams();
            _team.setName(team);

            Owners tulaj = new Owners(first_name, last_name, age, net_worth, competence, control);
            tulaj.setCurrent_team(_team);
            tulajok.add(tulaj);
        }
        rs.close();
        conn.close();
        return tulajok;

    }

    public static List<Teams> readTeam() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        List<Teams> csapatok = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:h2:~/probe", "sa", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from csapatok");
        while (rs.next()) {
            String name = rs.getString("nev");
            String nationality = rs.getString("nemzetiseg");
            Float strength = rs.getFloat("erosseg");
            float squad_value = rs.getInt("keret_erteke");

            String owner = rs.getString("tulajdonos");
            Owners _tul = new Owners();
            // owner: "Florentino Perez"
            String nevek[] = owner.split(" ");
            _tul.setFirst_name(nevek[0]);
            _tul.setLast_name(nevek[1]);
            
            String edzo = rs.getString("edzo");
            Coaches _edzo = new Coaches();
            String nev[] = edzo.split(" ");
            _edzo.setFirst_name(nev[0]);
            _edzo.setLast_name(nev[1]);
            
            Teams csapat = new Teams(name, nationality, strength, squad_value, _tul, _edzo);
            //edzo.setCurrent_team(_team);

            csapatok.add(csapat);
        }
        rs.close();
        conn.close();
        return csapatok;
    }

    public static void insertPlayer(Players player) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:~/probe", "sa", "");

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO jatekosok(vezeteknev, keresztnev, eletkor, poszt, nemzetiseg, kereset, eronlet, technika, piaci_ertek, csapat) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, player.getLast_name());
        stmt.setString(2, player.getFirst_name());
        stmt.setInt(3, player.getAge());
        stmt.setString(4, player.getPosition());
        stmt.setString(5, player.getNationality());
        stmt.setDouble(6, player.getCurrent_salary());
        stmt.setDouble(7, player.getFitness());
        stmt.setDouble(8, player.getSkills());
        stmt.setDouble(9, player.getValue());
        stmt.setString(10, player.getCurrent_team().getName());

        stmt.execute();
        conn.commit();
        conn.close();

    }

    public static List<Players> searchPlayer() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.h2.Driver");
        List<Players> megfelelo_jatekosok = new ArrayList<>();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String keresendo = input.readLine();

        Connection conn = DriverManager.getConnection("jdbc:h2:~/probe", "sa", "");
        System.out.println("Siker van, more!");

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from jatekosok" + " where vezeteknev = '" + keresendo + "'");
        megfelelo_jatekosok = vmi(rs);
        rs.close();

        conn.close();

        return megfelelo_jatekosok;
    }

    public static List<Players> searchPlayerPr() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.h2.Driver");
        List<Players> megfelelo_jatekosok = new ArrayList<>();
        Connection conn = DriverManager.getConnection("jdbc:h2:~/probe", "sa", "");

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM jatekosok WHERE vezeteknev = ?");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String keresendo = input.readLine();
        stmt.setString(1, keresendo);

        ResultSet rs = stmt.executeQuery();
        megfelelo_jatekosok = vmi(rs);
        conn.commit();
        conn.close();
        return megfelelo_jatekosok;

    }

    private static List<Players> vmi(ResultSet rs) throws SQLException {
        List<Players> megfelelo_jatekosok = new ArrayList<>();
        while (rs.next()) {
            String first_name = rs.getString("keresztnev");
            String last_name = rs.getString("vezeteknev");
            int age = rs.getInt("eletkor");
            String position = rs.getString("poszt");
            String nationality = rs.getString("nemzetiseg");

            String team = rs.getString("csapat");
            Teams _team = new Teams();
            _team.setName(team);

            Float current_salary = rs.getFloat("kereset");
            Float fitness = rs.getFloat("eronlet");
            Float skills = rs.getFloat("technika");
            Float value = rs.getFloat("piaci_ertek");
            Players jatekos = new Players(first_name, last_name, position, age, nationality, current_salary, fitness, skills, value);
            jatekos.setCurrent_team(_team);

            megfelelo_jatekosok.add(jatekos);
        }
        return megfelelo_jatekosok;
    }
}
