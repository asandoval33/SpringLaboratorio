package mx.com.springlabs.controlers;

import java.util.ArrayList;
import java.util.Optional;
import mx.com.springlabs.models.UsuarioModel;
import mx.com.springlabs.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /*
    curl --location --request GET 'http://localhost:8080/usuario' \
    --header 'Authorization: Basic YWRtaW46YWRtaW4='
     */
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerPorPrioridad(@RequestParam("prioridad") Integer priodidad) {
        return usuarioService.obtenerPorPrioridad(priodidad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminaUsuario(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminaUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con el id " + id;
        } else {
            return "No pudo eliminar el usuario con el id " + id;
        }
    }
}
