package com.condomanager.api.CONTROLLER

import com.condomanager.api.ENTITY.Usuario
import com.condomanager.api.SERVICE.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController (val service: UsuarioService) {
    @PostMapping
    fun cadastrarUsuario(@RequestBody usuario: Usuario) : ResponseEntity<Usuario> {
        return ResponseEntity.ok(service.cadastrar(usuario))
    }
    @GetMapping
    fun listar(): ResponseEntity<List<Usuario>> {
        return ResponseEntity.ok(service.list())
    }
    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody usuario: Usuario
    ): ResponseEntity<Usuario> {
      val atualizado = service.atualizar(id, usuario) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(atualizado)
    }
    @DeleteMapping("/{id}")
    fun remover(@PathVariable id: Long) : ResponseEntity<Void> {
        val excluir = service.excluir(id)
        if (!excluir){
            return ResponseEntity.notFound().build()
    }
        return ResponseEntity.ok().build()
        }


}