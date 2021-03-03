//package softuni.fashionshop.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import softuni.fashionshop.security.DemoUserDetailsService;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final DemoUserDetailsService demoUserDetailsService;
//    private final PasswordEncoder passwordEncoder;
//
//    public SecurityConfig(DemoUserDetailsService demoUserDetailsService,
//                          PasswordEncoder passwordEncoder) {
//        this.demoUserDetailsService = demoUserDetailsService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.
//                userDetailsService(demoUserDetailsService).
//                passwordEncoder(passwordEncoder);
//    }
////tuk se posochva scope na dostup for all and for authenthificated
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.
//                authorizeRequests().
//                antMatchers("/","login","register").permitAll().
//                antMatchers("/admin").hasRole("ADMIN").
//                antMatchers("/user").hasRole("USER").
//                and().
//                formLogin();
//    }
//}