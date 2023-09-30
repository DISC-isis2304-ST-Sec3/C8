package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO ELIMINAR ESTO
@SpringBootApplication
public class RunQuery implements CommandLineRunner {

	@Autowired
	private UsuariosRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Collection<Usuarios> tu = repo.darUsuarios();

		for (Usuarios i : tu) {
			System.out.println(i.getPk().getNombre());
		}

	}

}
