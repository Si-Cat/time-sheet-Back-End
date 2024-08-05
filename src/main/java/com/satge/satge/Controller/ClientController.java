package com.satge.satge.Controller;

import com.satge.satge.DTO.ClientDTO;
import com.satge.satge.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClientDTOs();
    }
}
