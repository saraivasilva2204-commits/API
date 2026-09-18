package com.condomanager.api.REPOSITORY

import com.condomanager.api.ENTITY.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {
}