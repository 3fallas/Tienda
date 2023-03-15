package services;

import java.util.List;

import com.tienda_l.tienda.domain.Categoria;

public interface CategoriaService {
    public List<Categoria> getCategorias(boolean activos);

    public Categoria getCategoria(Categoria Categoria);

    public void save(Categoria Categoria);

    public void delete(Categoria Categoria);
}
