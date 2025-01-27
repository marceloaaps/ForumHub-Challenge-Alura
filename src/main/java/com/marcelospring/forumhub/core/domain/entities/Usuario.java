package com.marcelospring.forumhub.core.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "Usuario")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private boolean isActive;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(
            name = "perfil_id", referencedColumnName ="id")
    private Perfil role;

    public Usuario(String nome, String email, String senha, Perfil role) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String localRole = String.valueOf(role.getName());

        return switch (localRole) {
            case "Admin" -> List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
            case "Member" -> List.of(new SimpleGrantedAuthority("ROLE_MEMBER"));
            case "Guest" -> List.of(new SimpleGrantedAuthority("ROLE_GUEST"));
            default -> throw new RuntimeException("Erro ao obter perfil");
        };
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
