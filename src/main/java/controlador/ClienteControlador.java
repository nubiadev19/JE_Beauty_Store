package controlador;

import dao.ClienteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import vista.FrmRegistroCliente;

/**
 *
 * @author Nubia
 */
public class ClienteControlador implements ActionListener {
    
    private final FrmRegistroCliente vista;
    private final ClienteDAO dao;

    // El constructor recibe la ventana y el DAO
    public ClienteControlador(FrmRegistroCliente vista, ClienteDAO dao) {
        this.vista = vista;
        this.dao = dao;
        
        // Ponemos al controlador a "escuchar" los clics de los botones
        this.vista.getBtnRegistrar().addActionListener(this);
        this.vista.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Si el usuario hace clic en Registrar
        if (e.getSource() == vista.getBtnRegistrar()) {
            ejecutarRegistro();
        }
        
        // Si el usuario hace clic en Cancelar
        if (e.getSource() == vista.getBtnCancelar()) {
            vista.dispose(); // Cierra la ventana actual
        }
    }

    private void ejecutarRegistro() {
        // 1. Extraer los datos desde la vista
        String nombre = vista.getNombre();
        String direccion = vista.getDireccion();
        String telefono = vista.getTelefono();
        String contrasena = vista.getContrasena();

        // 2. Validación básica de campos vacíos
        if (nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, llene todos los campos obligatorios.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Crear el modelo con los datos recolectados
        Cliente nuevoCliente = new Cliente(0, nombre, direccion, telefono, contrasena, "Cliente");

        // 4. Enviar al DAO para guardar en MySQL
        boolean exito = dao.registrarCliente(nuevoCliente);

        // 5. Responder visualmente al usuario
        if (exito) {
            JOptionPane.showMessageDialog(vista, "¡Cliente registrado exitosamente en JE Beauty Store!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al guardar el cliente. Verifique la conexión.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        // Limpiamos la ventana usando los nombres de las variables que creaste
        // Nota: Si NetBeans te saca alerta aquí, puedes crear un método limpiar() dentro del Frm o acceder directo cambiando a public
        vista.dispose(); // Por ahora, cerramos tras guardar para evitar duplicados en pruebas rápidos
    }
}