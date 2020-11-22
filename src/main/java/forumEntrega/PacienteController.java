package forumEntrega;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping
	public List<Paciente> getAll() {
		return pacienteRepository.findAll();
	}

	@PostMapping
	public String post(@RequestBody Paciente newPaciente) {
		if (pacienteRepository.findById(newPaciente.getId()).isPresent()) {
			throw new NotUniqueException();
		}
		newPaciente = pacienteRepository.save(newPaciente);
		return "Paciente cadastrado! ID: ".concat(newPaciente.getId());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> put(@PathVariable("id") String id, @RequestBody Paciente newPaciente) {
		if (!id.equals(newPaciente.getId())) {
			throw new InvalidIDException();
		}
		if (!pacienteRepository.findById(newPaciente.getId()).isPresent()) {            
			return ResponseEntity.notFound().build();

        }
		pacienteRepository.save(newPaciente);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> exclusao(@PathVariable String id) {
		try {
    		pacienteRepository.deleteById(id);
    		return ResponseEntity.ok().build();
		} catch (Exception e) {
    		return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}")
	public Paciente getById(@PathVariable String id) {
		return pacienteRepository.findById(id).get();
	}
	
	
	@GetMapping("/total")
	public String totalizadorPacientes(){
		
		String total;
		total = "Total de ".concat(pacienteRepository.totaliza()).concat(" paciente(s) cadastrados no sistema.");
		return total;		
	}

}
