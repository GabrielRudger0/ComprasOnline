package com.senai.ComprasOnline.Repositorys;

import com.senai.ComprasOnline.Models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
