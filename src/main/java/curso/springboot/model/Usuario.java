package curso.springboot.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn ;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Entity 	// Anotação força JPA a estanciar na tabela de banco de dados
public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id   // Anotação define que este será a chave da tabela
	@GeneratedValue( strategy = GenerationType.AUTO)   // Auto incremental
	private Long id;
	
	private String login;
	private String senha;
	private String email;
	
	

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_role",	
		joinColumns = @JoinColumn(name = "usuario_id", 
					referencedColumnName = "id",
					table = "usuario"), // Cria tabela de acessos do usuario
			inverseJoinColumns =  @JoinColumn(name = "role_id",
								referencedColumnName = "id",
								table = "role")) 
	
	
	private List<Role> roles;
	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		// Codifica a senha para salvar no banco de dados
		BCryptPasswordEncoder codificador = new BCryptPasswordEncoder();
		this.senha = codificador.encode(senha);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	
	

}
