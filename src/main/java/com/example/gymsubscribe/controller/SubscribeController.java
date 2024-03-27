package com.example.gymsubscribe.controller;

import java.sql.SQLOutput;
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

    @GetMapping("/allsubcribes")
    public String getSubscribes(Model model){
        List<Subscribe> subscribes = subscribeService.findAllSubscribe();
        model.addAttribute("subscribes", subscribes);
        return "allsubcribes";
    }

    @PostMapping("save_subscribe")
    public String saveSubscribe(@RequestBody Subscribe subscribe){
        subscribeService.saveSubscribe(subscribe);
        return "saved: "+subscribe.toString();
    }

    @GetMapping("get_all_clients")
    public List<Client> getClients(){
        return clientService.findAll();
    }

    @PostMapping("/add_subscribe")
    public String addSubscribe(@RequestParam String startDate,
                               @RequestParam String endDate,
                               @RequestParam Double price,
                               @RequestParam Long clientId) {
        // Обработка данных и сохранение подписки
        System.out.println(" @PostMapping(add_subscribe)");
        Subscribe subscribe = new Subscribe();
        subscribe.setStartDate(LocalDate.parse(startDate));
        subscribe.setEndDate(LocalDate.parse(endDate));
        subscribe.setPrice(price);
        Client client = clientService.findById(clientId);
        subscribe.setClient(client);
        subscribeService.saveSubscribe(subscribe);
        System.out.println(subscribe);

        return "redirect:/api/v1/subscribes/allsubcribes";

//        Subscribe subscribe = new Subscribe();
//        subscribe.setStartDate(LocalDate.parse(request.getStartDate()));
//        subscribe.setEndDate(LocalDate.parse(request.getEndDate()));
//        subscribe.setPrice(request.getPrice());
//        Client client = clientService.findById(request.getClientID());
//        subscribe.setClient(client);
//        subscribeService.saveSubscribe(subscribe);
//        return "redirect:/api/v1/subscribes/allsubcribes";
    }

}//class SubscribeController
/*
@PostMapping("/addSubscribe")
    public String addSubscribe(@RequestParam String startDate,
                               @RequestParam String endDate,
                               @RequestParam Double price,
                               @RequestParam Long clientId) {
        Subscribe subscribe = new Subscribe();
        subscribe.setStartDate(LocalDate.parse(startDate));
        subscribe.setEndDate(LocalDate.parse(endDate));
        subscribe.setPrice(price);

        // Здесь нужно получить клиента по ID
        Client client = clientService.findById(clientId);
        subscribe.setClient(client);

        subscribeService.saveSubscribe(subscribe);

        // После сохранения перенаправляем на страницу с подписками
        return "redirect:/subscribes";
 */