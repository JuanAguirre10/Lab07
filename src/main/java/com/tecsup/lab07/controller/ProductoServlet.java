package com.tecsup.lab07.controller;

import com.tecsup.lab07.dao.CategoriaDAO;
import com.tecsup.lab07.dao.ProductoDAO;
import com.tecsup.lab07.model.Categoria;
import com.tecsup.lab07.model.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
    private ProductoDAO productoDAO = new ProductoDAO();
    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                listar(request, response);
            } else if (action.equals("nuevo")) {
                mostrarFormularioNuevo(request, response);
            } else if (action.equals("editar")) {
                mostrarFormularioEditar(request, response);
            } else if (action.equals("eliminar")) {
                eliminar(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("insertar")) {
                insertar(request, response);
            } else if (action.equals("actualizar")) {
                actualizar(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Producto> productos = productoDAO.listarTodos();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("/views/productos/listar.jsp").forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Categoria> categorias = categoriaDAO.listarTodos();
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/views/productos/form.jsp").forward(request, response);
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Producto producto = productoDAO.obtenerPorId(id);
        List<Categoria> categorias = categoriaDAO.listarTodos();

        request.setAttribute("producto", producto);
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/views/productos/form.jsp").forward(request, response);
    }

    private void insertar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setCategoriaId(categoriaId);

        productoDAO.insertar(producto);
        response.sendRedirect("productos");
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));

        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setCategoriaId(categoriaId);

        productoDAO.actualizar(producto);
        response.sendRedirect("productos");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productoDAO.eliminar(id);
        response.sendRedirect("productos");
    }
}