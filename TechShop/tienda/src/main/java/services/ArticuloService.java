package services;

import java.util.List;

import com.tienda_l.tienda.domain.Articulo;

public interface ArticuloService {
    public List<Articulo> getArticulos(boolean activos);

    public Articulo getArticulos(Articulo Articulo);

    public void save(Articulo Articulo);

    public void delete(Articulo Articulo);
}
