package com.senai.ComprasOnline.Repositorys;

import com.senai.ComprasOnline.Models.PermissaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<PermissaoModel, Long> {
    public boolean existsByAcao(Integer acao);
}
