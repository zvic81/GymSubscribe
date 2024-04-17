package com.example.gymsubscribe.controller;

import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.gymsubscribe.model.*;
import com.example.gymsubscribe.service.*;

@Controller
//@RequestMapping("/api/v1/subscribes")
@RequiredArgsConstructor
public class SubscribeController {
    final SubscribeService subscribeService;
    final ClientService clientService;

    @GetMapping({"/", "/index", ""})
    public String index(Model model){
        String userName = "Guest";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof DefaultOAuth2User) {
                DefaultOAuth2User oauth2User = (DefaultOAuth2User) principal;
                userName = oauth2User.getAttribute("name");
                String email = oauth2User.getAttribute("email");
                System.out.println("Имя: " + userName);
                System.out.println("Email: " + email);
            } else {
                System.out.println("Тип principal не является ожидаемым типом DefaultOAuth2User");
            }
        }
        model.addAttribute("username",userName);
        return "index";
    }

    @GetMapping("allsubcribes")
    public String getSubscribes(Model model){
        List<Subscribe> subscribes = subscribeService.findAllSubscribe();
        model.addAttribute("clients", clientService.getAllClients());
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
        return "redirect:/allsubcribes";
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
        return "redirect:/allclients";
    }
    @GetMapping("/login/oauth2/code/google")
    public String googleLoginCallback(OAuth2AuthenticationToken authenticationToken) {
        // Вывод информации об аутентификации для отладки
        System.out.println("Authentication: " + authenticationToken);
        System.out.println("Principal: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return "redirect:/index"; // Перенаправление на защищенную страницу после успешной аутентификации
    }
}//class SubscribeController
