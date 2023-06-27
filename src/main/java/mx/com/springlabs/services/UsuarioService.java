package mx.com.springlabs.services;

import java.util.ArrayList;
import java.util.Optional;
import mx.com.springlabs.models.UsuarioModel;

public interface UsuarioService {

    public ArrayList<UsuarioModel> obtenerUsuarios();

    public UsuarioModel guardarUsuario(UsuarioModel usuario);

    public Optional<UsuarioModel> obtenerPorId(Long id);

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer priodidad);

    public boolean eliminaUsuario(Long id);
}
