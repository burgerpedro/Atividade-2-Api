package br.com.residencia.biblioteca.controller;

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

import br.com.residencia.biblioteca.DTO.AlunoDTO;
import br.com.residencia.biblioteca.DTO.AlunoEmprDTO;
import br.com.residencia.biblioteca.entity.Aluno;
import br.com.residencia.biblioteca.service.AlunoService;

@RestController
@RequestMapping("/alunos") //hhtp://localhost:8080/alunos
public class AlunoController {

	@Autowired
	AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> getAllAlunos(){
		return new ResponseEntity<>(alunoService.getAllAlunos(),HttpStatus.OK);
		
	}
	
	@GetMapping("/dto")
	public ResponseEntity<List<AlunoDTO>> getAllAlunosDTO(){
		return new ResponseEntity<>(alunoService.getAllAlunosDTO(),HttpStatus.OK);
		
	}
	
	@GetMapping("/aluno-emprestimo")
	public ResponseEntity<List<AlunoEmprDTO>> getAllAlunobyEmprestimosDTO(){
		return new ResponseEntity<>(alunoService.getAllAlunobyEmprestimosDTO(),HttpStatus.OK);
		
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> HelloWorld() {
		return new ResponseEntity<>("A API esta funcionando",HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Integer id) {
		Aluno aluno = alunoService.getAlunoById(id);
		if(aluno != null)
			return new ResponseEntity<> (aluno,HttpStatus.OK);
		else
			return new ResponseEntity<>(aluno,HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping//("/save")
	public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno aluno) {
		return new  ResponseEntity<>(alunoService.saveAluno(aluno),HttpStatus.CREATED);
		
	}
	
	@PostMapping("/dto")
	public ResponseEntity<AlunoDTO> saveAlunoDTO(@RequestBody AlunoDTO alunoDTO) {
		return new  ResponseEntity<>(alunoService.saveAlunoDTO(alunoDTO),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> updateAluno(@RequestBody Aluno aluno,@PathVariable Integer id){
		return new ResponseEntity<>(alunoService.updateAluno(aluno, id),HttpStatus.OK);
	}
	
	@PutMapping("/dto/{id}")
	public ResponseEntity<AlunoDTO> updateAlunoDTO(@RequestBody AlunoDTO alunoDTO,@PathVariable Integer id){
		return new ResponseEntity<>(alunoService.updateAlunoDTO(alunoDTO, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> deleteAluno(@PathVariable Integer id){
		Aluno aluno = alunoService.getAlunoById(id);
		if(aluno == null)
			return new ResponseEntity<>(aluno,HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(alunoService.deleteAluno(id),HttpStatus.OK);
	}
}
