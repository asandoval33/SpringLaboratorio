package mx.com.springlabs.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        //este metodo requiere de un Bean "org.springframework.security.authentication.AuthenticationManager" para funcionar
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
        System.out.println("filterChain");
        return http.
                csrf().disable()//Deshabilitar Cross Site Request Forgery
                .authorizeRequests()//Reglas de las solicitudes
                .antMatchers("/usuario").permitAll()
                .anyRequest()//Cualquier solicitud de la api
                .authenticated()// este autenticada
                //.and() //ademas
                //.httpBasic()//autenticacioon basica, para enviar un usuario y una contraseña
                .and()
                .sessionManagement()//gestion de las sesiones
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//establecemos la politica de gestion de sesiones: Sin estado
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();//finalmente contruimos el SecurityFilterChain
    }

//    //para probar la implentacion
//    @Bean
//    UserDetailsService userDetailsService() {
//        //Creamos un usuario en memoria
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("admin")
//                .password(this.passwordEncoder().encode("admin"))
//                .roles()
//                .build());
//        return manager;
//    }
    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
        System.out.println("authManager");
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                //.userDetailsService(this.userDetailsService())
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(this.passwordEncoder())
                .and()
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        //"BCryptPasswordEncoder()" implentación de "PasswordEncoder" pero podemos usar una personalizada 
        return new BCryptPasswordEncoder();
    }
    
//    public static void main(String[] args) {
//        System.out.println("pp:"+new BCryptPasswordEncoder().encode("arturouser"));
//    }
}
