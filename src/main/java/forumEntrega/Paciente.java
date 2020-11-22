package forumEntrega;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Paciente {
	@Id
	private String id;
	
	private String nome;
	private LocalDate dataNascimento;
	private String sexo;

	private Paciente() {
		id = UUID.randomUUID().toString();
	}

	public Paciente(String nome, LocalDate dataNascimento, String sexo) {
		this();
		//super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		

	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSexo() {
		return sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Paciente)) {
			return false;
		}
		Paciente paciente = (Paciente) o;
		return Objects.equals(id, paciente.id);
	}

}
