package services;

import java.util.List;

import com.tienda_l.tienda.domain.Cliente;

public interface ClienteService {
    public List<Cliente> getClientes();

    public Cliente getClient(Cliente cliente);

    public void save(Cliente cliente);

    public void delete(Cliente cliente);
}
