package com.tecsup.lab07.controller;

import com.tecsup.lab07.dao.CategoriaDAO;
import com.tecsup.lab07.model.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/categorias")
public class CategoriaServlet extends HttpServlet {
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
        List<Categoria> categorias = categoriaDAO.listarTodos();
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/views/categorias/listar.jsp").forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/categorias/form.jsp").forward(request, response);
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Categoria categoria = categoriaDAO.obtenerPorId(id);
        request.setAttribute("categoria", categoria);
        request.getRequestDispatcher("/views/categorias/form.jsp").forward(request, response);
    }

    private void insertar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);

        categoriaDAO.insertar(categoria);
        response.sendRedirect("categorias");
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);

        categoriaDAO.actualizar(categoria);
        response.sendRedirect("categorias");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoriaDAO.eliminar(id);
        response.sendRedirect("categorias");
    }
}