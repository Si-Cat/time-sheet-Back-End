package com.satge.satge.Repository;
import com.satge.satge.DTO.ClientDTO;
import com.satge.satge.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT new com.satge.satge.DTO.ClientDTO(c.clientId, c.name) FROM Client c")
    List<ClientDTO> findAllClientDTOs();
}
