package curso.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role  implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id   // Anotação define que este será a chave da tabela
	@GeneratedValue( strategy = GenerationType.AUTO)   // Auto incremental
	private Long id;
	
	private String nomeRole;
	
	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public String getAuthority() {
		// Sempre vai retornar ROLE_ADMIN , ROLE_GERENTE...
		return this.nomeRole;
	}

}
