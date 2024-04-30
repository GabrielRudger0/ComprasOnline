package com.senai.ComprasOnline.Repositorys;

import com.senai.ComprasOnline.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    public List<ProdutoModel> findByDescricaoContaining (String descricao);
}
