package com.rubenrdc.lectorexcel.models.dao;

import com.rubenrdc.lectorexcel.models.Users;
import com.rubenrdc.lectorexcel.models.interfaces.Exportables;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class UsersDao {

    private static DaoConnection dao = new DaoConnection();
    private static String Query;
    private static List<String> paramsSql = new ArrayList<>();

    public UsersDao() {

    }

    public static List<Exportables> getAllUsersListInExport() {
        if (dao.ExtablecerC() != null) {
            List<Exportables> lista = new ArrayList();
            Query = "SELECT * FROM users";
            ResultSet rs = dao.GenericQuery(Query, null);
            try {
                while (rs.next()) {
                    Users u = new Users(rs.getString("Nombre"), rs.getString("Apellido"), null);
                    Date date = rs.getDate("FechaDeIngreso");
                    if (date != null) {
                        u.setFechaDeIngreso(date.toLocalDate());
                    }
                    lista.add(u);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            dao.getCloseC();
            return lista;
        }
        return null;
    }

    public static boolean addUser(Users u) {
        if (dao.ExtablecerC() != null) {
            boolean exito = false;
            Query = "INSERT INTO users (Nombre,Apellido,FechaDeIngreso) SELECT ?,?,? WHERE NOT EXISTS(SELECT 1 FROM users WHERE Nombre = ? AND Apellido = ? AND FechaDeIngreso = ?);";
            paramsSql.add(u.getNombre());
            paramsSql.add(u.getApellido());
            paramsSql.add(u.getFechaDeIngreso().toString());
            ///
            paramsSql.add(u.getNombre());
            paramsSql.add(u.getApellido());
            paramsSql.add(u.getFechaDeIngreso().toString());
            ///
            exito = dao.GenericUpdate(Query, paramsSql);
            paramsSql.clear();
            dao.getCloseC();

            return exito;
        }
        return false;
    }

}
