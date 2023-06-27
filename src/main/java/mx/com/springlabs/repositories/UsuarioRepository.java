package mx.com.springlabs.repositories;

import java.util.ArrayList;
import java.util.Optional;
import mx.com.springlabs.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);

    Optional<UsuarioModel> findOneByUsername(String username);

}
