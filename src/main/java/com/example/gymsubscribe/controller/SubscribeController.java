package com.example.gymsubscribe.controller;

import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.gymsubscribe.model.*;
import com.example.gymsubscribe.service.*;

@Controller
@RequestMapping("/api/v1/subscribes")
@RequiredArgsConstructor
public class SubscribeController {
    final SubscribeService subscribeService;
    final ClientService clientService;

    @GetMapping({"/", "/index", ""})
    public String index(){ return "index"; }

    @GetMapping("allsubcribes")
    public String getSubscribes(Model model){
        List<Subscribe> subscribes = subscribeService.findAllSubscribe();
        model.addAttribute("subscribes", subscribes);
        return "allsubcribes";
    }

    @GetMapping("allclients")
    public String getClients(Model model){
        List<Client> clients = clientService.findAllClients();
        model.addAttribute("clients", clients);
        return "allclients";
        }

    @PostMapping("/add_subscribe")
    public String addSubscribe(@RequestParam String startDate,
                               @RequestParam String endDate,
                               @RequestParam Double price,
                               @RequestParam Long clientId) {
        Subscribe subscribe = new Subscribe();
        subscribe.setStartDate(LocalDate.parse(startDate));
        subscribe.setEndDate(LocalDate.parse(endDate));
        subscribe.setPrice(price);
        Client client = clientService.findById(clientId);
        subscribe.setClient(client);
        subscribeService.saveSubscribe(subscribe);
        return "redirect:/api/v1/subscribes/allsubcribes";
    }

    @PostMapping("/add_client")
    public String addClient(@RequestParam String firstName,
                               @RequestParam String secondName,
                               @RequestParam String dateOfBirth) {
        Client client = new Client();
        client.setFirstName(firstName);
        client.setSecondName(secondName);
        client.setDateOfBirth(LocalDate.parse(dateOfBirth));
        clientService.saveClient(client);
        return "redirect:/api/v1/subscribes/allclients";
    }

}//class SubscribeController
