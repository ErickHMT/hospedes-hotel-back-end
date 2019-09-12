package com.hotel.repository;

import com.hotel.entity.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {

    Optional<Hospede> getByNome(String nome);

    Optional<Hospede> getHospedesByDocumento(String documento);

    List<Hospede> getHospedesByTelefone(String telefone);

    @Query(value="SELECT h FROM HOSPEDES h INNER JOIN CHECK_IN ci ON ci.FK_HOSPEDE = h.PK_HOSPEDE WHERE ci.data_saida IS NOT NULL ", nativeQuery = true)
    Optional<Hospede> getHospedesAnteriores();

    @Query(value="SELECT h FROM HOSPEDES h INNER JOIN CHECK_IN ci ON ci.FK_HOSPEDE = h.PK_HOSPEDE WHERE ci.data_saida IS NULL ", nativeQuery = true)
    Optional<Hospede> getHospedesAtuais();
}
