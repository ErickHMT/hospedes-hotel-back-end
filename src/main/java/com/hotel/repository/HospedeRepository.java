package com.hotel.repository;

import com.hotel.entity.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {

    List<Hospede> getHospedesByNomeContainingIgnoreCase(String nome);

    @Query(value="SELECT * FROM HOSPEDE h WHERE h.nome LIKE CONCAT('%', :nome, '%') " +
            " AND h.documento LIKE CONCAT('%', :documento, '%') " +
            " AND h.telefone LIKE CONCAT('%', :telefone, '%') "
            , nativeQuery = true)
    List<Hospede> getHospedeByFiltro(@Param("nome") String nome,
                                     @Param("documento")String documento,
                                     @Param("telefone") String telefone);
}
