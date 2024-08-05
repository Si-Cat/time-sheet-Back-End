package com.satge.satge.Service;

import com.satge.satge.DTO.ClientDTO;
import com.satge.satge.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAllClientDTOs() {
        return clientRepository.findAllClientDTOs();
    }
}
