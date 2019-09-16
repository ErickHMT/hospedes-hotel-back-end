package com.hotel.repository;

import com.hotel.entity.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {

//    @Query(value="SELECT * FROM HOSPEDE h WHERE h.nome LIKE CONCAT('%', :nome, '%') ", nativeQuery = true)
//    List<Hospede> getHospedesByNome(@Param("nome") String nome);

    List<Hospede> getHospedesByNomeContainingIgnoreCase(String nome);

    Optional<Hospede> getHospedesByDocumentoContaining(String documento);

    List<Hospede> getHospedesByTelefoneContaining(String telefone);

    @Query(value="SELECT h FROM HOSPEDE h INNER JOIN CHECK_IN ci ON ci.FK_HOSPEDE = h.PK_HOSPEDE WHERE ci.data_saida IS NOT NULL ", nativeQuery = true)
    Optional<Hospede> getHospedesAnteriores();

    @Query(value="SELECT h FROM HOSPEDE h INNER JOIN CHECK_IN ci ON ci.FK_HOSPEDE = h.PK_HOSPEDE WHERE ci.data_saida IS NULL ", nativeQuery = true)
    Optional<Hospede> getHospedesAtuais();

    @Query(value="SELECT * FROM HOSPEDE h INNER JOIN CHECK_IN ci ON ci.hospede_id = h.id", nativeQuery = true)
    List<Hospede> findAllShow();
}
