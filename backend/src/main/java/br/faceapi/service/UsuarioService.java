package br.faceapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.faceapi.model.Usuario;
import br.faceapi.repository.UsuarioRepositorio;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepositorio repositorio;

    public List<Usuario> findAll() {
        return repositorio.findAll();

    }

    public Usuario findById(Long id) {
        return repositorio.findById(id)
                .orElse(null);
    }

    public Usuario create(Usuario usuario) {
        return repositorio.save(usuario);

    }

    public Usuario update(Long id, Usuario form) {
        Usuario usuarioDB = findById(id);

        usuarioDB.setNome(form.getNome());
        usuarioDB.setCpf(form.getCpf());
        usuarioDB.setUrlAvatar(form.getUrlAvatar());

        return repositorio.save(usuarioDB);

    }

    public void delete(Long id) {
        Usuario usuarioDB = findById(id);
        repositorio.delete(usuarioDB);

    }

}