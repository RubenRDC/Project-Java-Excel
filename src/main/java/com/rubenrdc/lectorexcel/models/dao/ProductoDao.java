package com.rubenrdc.lectorexcel.models.dao;

import com.rubenrdc.lectorexcel.models.Producto;
import com.rubenrdc.lectorexcel.models.interfaces.Exportables;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class ProductoDao {

    private static DaoConnection dao = new DaoConnection();
    private static List<String> paramsSql = new ArrayList<>();
    private static String Query = "";

    public ProductoDao() {

    }

    public static List<Exportables> getAllProductListInExport() {
        if (dao.ExtablecerC() != null) {
            List<Exportables> lista = new ArrayList();
            Query = "SELECT * FROM productos";
            ResultSet rs = dao.GenericQuery(Query, null);
            try {
                while (rs.next()) {
                    Producto p = new Producto(rs.getString("Codigo"), rs.getString("Nombre"), rs.getString("Marca"), rs.getDouble("Precio"));
                    lista.add(p);
                }
            } catch (SQLException ex) {
            }
            dao.getCloseC();
            return lista;
        }
        return null;
    }

    public static boolean addProduct(Producto product) {
        if (dao.ExtablecerC() != null) {
            boolean exito;
            Query = "INSERT IGNORE INTO productos (nombre,marca,precio) VALUES(?,?,?);";
            paramsSql.add(0, product.getDescrip());
            paramsSql.add(1, product.getMarca());
            paramsSql.add(2, Double.toString(product.getPrecio()));

            exito = dao.GenericUpdate(Query, paramsSql);

            dao.getCloseC();
            return exito;
        }
        return false;
    }


}
