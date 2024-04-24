package com.example.gymsubscribe.controller;

import com.example.gymsubscribe.model.Client;
import com.example.gymsubscribe.model.Subscribe;
import com.example.gymsubscribe.service.ClientService;
import com.example.gymsubscribe.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SubscribeController {
    final SubscribeService subscribeService;
    final ClientService clientService;

    @GetMapping({"/", "/index", ""})
    public String index(Model model) {
        String userName = "Guest";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof DefaultOAuth2User oauth2User) {
                userName = oauth2User.getAttribute("name");
                String email = oauth2User.getAttribute("email");
                System.out.println("Имя: " + userName);
                System.out.println("Email: " + email);
            } else {
                System.out.println("Тип principal не является ожидаемым типом DefaultOAuth2User");
            }
        }
        model.addAttribute("username", userName);
        return "index";
    }

    @GetMapping("allsubcribes")
    public String getSubscribes(Model model) {
        List<Subscribe> subscribes = subscribeService.findAllSubscribe();
        model.addAttribute("subscribes", subscribes);
        return "allsubcribes";
    }

    @GetMapping("allclients")
    public String getClients(Model model) {
        List<Client> clients = clientService.findAllClients();
        model.addAttribute("clients", clients);
        return "allclients";
    }

    @PostMapping("/subscription")
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
        return "redirect:/allsubcribes";
    }

    @PostMapping("/client")
    public String addClient(@RequestParam String firstName,
                            @RequestParam String secondName,
                            @RequestParam String dateOfBirth) {
        Client client = new Client();
        client.setFirstName(firstName);
        client.setSecondName(secondName);
        client.setDateOfBirth(LocalDate.parse(dateOfBirth));
        clientService.saveClient(client);
        return "redirect:/allclients";
    }
}//class SubscribeController
