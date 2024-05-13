package br.faceapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.faceapi.model.Usuario;
import br.faceapi.service.UsuarioService;
import lombok.AllArgsConstructor;

/* Foi utilizado a linha de comando: 
chrome.exe --user-data-dir="C:/Chrome dev session" --disable-web-security 
na pasta c:\Program Files\Google\Chrome\Application, 
para visualizar a pagina Http://localhost:4200  */

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> list() {
        return usuarioService.findAll();

    }

    @GetMapping("{id}")
    public Usuario get(@PathVariable Long id) {
        return usuarioService.findById(id);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.create(usuario);

    }

    @PutMapping("{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario form) {
        return usuarioService.update(id, form);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);

    }

}
