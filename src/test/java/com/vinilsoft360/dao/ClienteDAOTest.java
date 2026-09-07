package com.vinilsoft360.dao;

import com.vinilsoft360.model.Cliente;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteDAOTest {

    private ClienteDAO dao;

    @BeforeEach
    void setUp() {
        dao = new ClienteDAO();
    }

    @Test
    @Order(1)
    void testAgregarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Cliente Prueba JUnit");
        cliente.setTelefono("3001234567");
        cliente.setDireccion("Calle Falsa 123");

        dao.agregarCliente(cliente);

        List<Cliente> lista = dao.listarClientes();
        boolean encontrado = lista.stream()
                .anyMatch(c -> "Cliente Prueba JUnit".equals(c.getNombre()));

        assertTrue(encontrado, "El cliente de prueba debería existir en la base de datos");
    }

    @Test
    @Order(2)
    void testListarClientes() {
        List<Cliente> lista = dao.listarClientes();
        assertNotNull(lista, "La lista de clientes no debería ser null");
        assertFalse(lista.isEmpty(), "Debería haber al menos un cliente registrado");
    }

    @Test
    @Order(3)
    void testBuscarPorId() {
        List<Cliente> lista = dao.listarClientes();
        Assumptions.assumeFalse(lista.isEmpty());

        int id = lista.get(0).getId();
        Cliente encontrado = dao.buscarPorId(id);

        assertNotNull(encontrado, "Debería encontrar un cliente con ese id");
        assertEquals(id, encontrado.getId());
    }

    @Test
    @Order(4)
    void testActualizarCliente() {
        List<Cliente> lista = dao.listarClientes();
        Cliente cliente = lista.stream()
                .filter(c -> "Cliente Prueba JUnit".equals(c.getNombre()))
                .findFirst()
                .orElse(null);

        assertNotNull(cliente, "Debe existir el cliente de prueba para poder actualizarlo");

        cliente.setDireccion("Dirección Actualizada JUnit");
        dao.actualizarCliente(cliente);

        Cliente actualizado = dao.buscarPorId(cliente.getId());
        assertEquals("Dirección Actualizada JUnit", actualizado.getDireccion());
    }

    @Test
    @Order(5)
    void testEliminarCliente() {
        List<Cliente> lista = dao.listarClientes();
        Cliente cliente = lista.stream()
                .filter(c -> "Cliente Prueba JUnit".equals(c.getNombre()))
                .findFirst()
                .orElse(null);

        assertNotNull(cliente, "Debe existir el cliente de prueba para poder eliminarlo");

        dao.eliminarCliente(cliente.getId());

        Cliente eliminado = dao.buscarPorId(cliente.getId());
        assertNull(eliminado, "El cliente ya no debería existir tras eliminarlo");
    }
}
