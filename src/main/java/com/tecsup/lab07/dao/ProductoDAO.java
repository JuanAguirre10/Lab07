package com.tecsup.lab07.dao;

import com.tecsup.lab07.config.ConexionDB;
import com.tecsup.lab07.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public List<Producto> listarTodos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.*, c.nombre as categoria_nombre FROM producto p " +
                "INNER JOIN categoria c ON p.categoria_id = c.id ORDER BY p.id DESC";

        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoriaId(rs.getInt("categoria_id"));
                producto.setCategoriaNombre(rs.getString("categoria_nombre"));
                productos.add(producto);
            }
        }
        return productos;
    }

    public Producto obtenerPorId(int id) throws SQLException {
        String sql = "SELECT p.*, c.nombre as categoria_nombre FROM producto p " +
                "INNER JOIN categoria c ON p.categoria_id = c.id WHERE p.id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoriaId(rs.getInt("categoria_id"));
                producto.setCategoriaNombre(rs.getString("categoria_nombre"));
                return producto;
            }
        }
        return null;
    }

    public boolean insertar(Producto producto) throws SQLException {
        String sql = "INSERT INTO producto (nombre, precio, stock, categoria_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setInt(4, producto.getCategoriaId());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean actualizar(Producto producto) throws SQLException {
        String sql = "UPDATE producto SET nombre = ?, precio = ?, stock = ?, categoria_id = ? WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setInt(4, producto.getCategoriaId());
            pstmt.setInt(5, producto.getId());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM producto WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }
}