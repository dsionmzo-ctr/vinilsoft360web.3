package com.vinilsoft360.dao;

import com.vinilsoft360.model.Producto;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductoDAOTest {

    private ProductoDAO dao;

    @BeforeEach
    void setUp() {
        dao = new ProductoDAO();
    }

    @Test
    @Order(1)
    void testAgregarProducto() {
        Producto producto = new Producto();
        producto.setNombre("Piso Prueba JUnit");
        producto.setCategoria("Laminado");
        producto.setDescripcion("Producto de prueba automatizada");
        producto.setPrecio(45000.0);
        producto.setStock(10);
        producto.setEstado("Activo");

        boolean resultado = dao.agregarProducto(producto);
        assertTrue(resultado, "El producto debería registrarse correctamente");
    }

    @Test
    @Order(2)
    void testListarProductos() {
        List<Producto> lista = dao.listarProductos();
        assertNotNull(lista);
        assertFalse(lista.isEmpty(), "Debería haber al menos un producto registrado");
    }

    @Test
    @Order(3)
    void testBuscarPorId() {
        List<Producto> lista = dao.listarProductos();
        Assumptions.assumeFalse(lista.isEmpty());

        int id = lista.get(0).getIdProducto();
        Producto encontrado = dao.buscarPorId(id);

        assertNotNull(encontrado);
        assertEquals(id, encontrado.getIdProducto());
    }

    @Test
    @Order(4)
    void testActualizarProducto() {
        List<Producto> lista = dao.listarProductos();
        Producto producto = lista.stream()
                .filter(p -> "Piso Prueba JUnit".equals(p.getNombre()))
                .findFirst()
                .orElse(null);

        assertNotNull(producto, "Debe existir el producto de prueba");

        producto.setPrecio(50000.0);
        boolean actualizado = dao.actualizarProducto(producto);

        assertTrue(actualizado);

        Producto verificado = dao.buscarPorId(producto.getIdProducto());
        assertEquals(50000.0, verificado.getPrecio());
    }

    @Test
    @Order(5)
    void testEliminarProducto() {
        List<Producto> lista = dao.listarProductos();
        Producto producto = lista.stream()
                .filter(p -> "Piso Prueba JUnit".equals(p.getNombre()))
                .findFirst()
                .orElse(null);

        assertNotNull(producto, "Debe existir el producto de prueba");

        boolean eliminado = dao.eliminarProducto(producto.getIdProducto());
        assertTrue(eliminado);

        Producto verificado = dao.buscarPorId(producto.getIdProducto());
        assertNull(verificado, "El producto ya no debería existir");
    }
}