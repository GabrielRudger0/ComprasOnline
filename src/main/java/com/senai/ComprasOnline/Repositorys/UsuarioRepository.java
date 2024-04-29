package com.senai.ComprasOnline.Repositorys;

import com.senai.ComprasOnline.Models.UsuarioModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {
    
    //- Método que realiza o select no banco de dados filtrando no where o email do usuário
    public Optional<UsuarioModel> findByEmail(String email);
    
}