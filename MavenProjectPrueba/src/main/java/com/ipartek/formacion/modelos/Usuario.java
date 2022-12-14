package com.ipartek.formacion.modelos;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne
    @JoinColumn(name="roles_id")
	private Rol rol;
	
	@OneToOne(mappedBy="usuario")
	private Cliente cliente;
	
	public Usuario(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}


	
	
}
