package br.faceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.faceapi.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
