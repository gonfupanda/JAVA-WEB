package com.ipartek.examen.spring.pojos;

import org.hibernate.annotations.GenericGenerator;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resenas")
public class Resena {
	
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	@Id
	private  Long id;
	
	@Column(name="texto")
	@Nonnull
	private  String texto;
	
	@ManyToOne
    @JoinColumn(name="libros_id")
	private Libro libro;

}
