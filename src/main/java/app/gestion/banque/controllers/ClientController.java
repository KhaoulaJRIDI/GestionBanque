package app.gestion.banque.controllers;

import app.gestion.banque.entities.Client;
import app.gestion.banque.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    @GetMapping(value = "/")

    @ResponseBody
    public String home() { return "Hello Spring Boot"; }
    @GetMapping(value = "/index")
    public String index()
    {
        return "test";
    }
    @GetMapping(value="/search")
    public String search(Model model,
                         @RequestParam(name="page",defaultValue="0") int page,

                         @RequestParam(name="motCle",defaultValue="") String mc) {


        Page<Client> pageClients =
                clientRepository.findByNomClientContains(mc, PageRequest.of(page,5));
        //clientRepository.findAll(PageRequest.ofSize(10));
        for (Client c:pageClients){
            System.out.println("nom client: "+c.getNomClient());
        }
        int pageCount = pageClients.getTotalPages();
        System.out.println("PageCount is "+pageCount);
        int[] pages = new int[pageCount];
        for(int i=0;i<pageCount;i++)
            pages[i]=i;
        model.addAttribute("pages",pages);
        model.addAttribute("motCle",mc);
        model.addAttribute("pagecourante",page);
        model.addAttribute("pageclients",pageClients);


        return "pages/client";
    }
    @GetMapping("/delete")
    public String delete(Long id,int page, String motCle) {
        clientRepository.deleteById(id);
        return "redirect:/search?page="+page+"&motCle="+motCle;
    }



    @GetMapping("edit/{id}")
    public String showClientFormToUpdate(@PathVariable("id") Long id, Model model) {
        Client client = clientRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "pages/updateClient";
    }
    @PostMapping("update")
    public String updateClient(Client client, BindingResult result, Model model) {
        clientRepository.save(client);
        return "redirect:search";
    }

    @GetMapping("list")
    public String listClients(Model model)
    {
        model.addAttribute("clients", clientRepository.findAll());
        return "pages/listClients";
    }


}



