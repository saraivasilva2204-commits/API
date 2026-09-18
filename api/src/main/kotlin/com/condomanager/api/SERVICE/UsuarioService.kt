package com.condomanager.api.SERVICE

import com.condomanager.api.ENTITY.Usuario
import com.condomanager.api.REPOSITORY.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService (val repository: UsuarioRepository){
fun cadastrar(usuario: Usuario): Usuario {
    return repository.save(usuario)
   }
    fun list(): List<Usuario> {
        return repository.findAll()
    }
    fun buscar(id : Long) : Usuario? {
        return repository.findById(id).orElse(null)
    }
    fun excluir(id: Long) : Boolean {
        if (repository.existsById(id)) {
            return false
        }
        repository.deleteById(id)
        return true
    }
    fun atualizar(id : Long,usuario: Usuario) : Usuario? {
        var usuarioExistente = repository.findById(id).orElse(null)
        usuarioExistente.email = usuario.email
        usuarioExistente.senha = usuario.senha
        return repository.save(usuarioExistente)
    }
}