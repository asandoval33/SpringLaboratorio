package mx.com.springlabs.security;

import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;
import mx.com.springlabs.models.UsuarioModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final UsuarioModel usuarioModel;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return usuarioModel.getPassword();
    }

    @Override
    public String getUsername() {
        return usuarioModel.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return usuarioModel.getNombre();
    }

}
