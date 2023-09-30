package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import uniandes.edu.co.proyecto.modelo.TiposUsuario;
import uniandes.edu.co.proyecto.repositorio.TiposUsuarioRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO ELIMINAR ESTO
@SpringBootApplication
public class RunQuery implements CommandLineRunner {

	@Autowired
	private TiposUsuarioRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Collection<TiposUsuario> tu = repo.darTiposUsuario();

		for (TiposUsuario i : tu) {
			System.out.println(i);
		}

	}

}
