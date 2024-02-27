package app.gestion.banque.controllers;

import app.gestion.banque.entities.Client;
import app.gestion.banque.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    @GetMapping(value = "/")

    @ResponseBody
    public String home() { return "Hello Spring Boot"; }
    @GetMapping(value = "/clients")
    public String index(Model model)
    {
        return "pages/index";
    }
    @GetMapping(value="/search")
    public String search(Model model,
                         @RequestParam(name="page",defaultValue="0") int page,

                         @RequestParam(name="motCle",defaultValue="") String mc) {


        Page<Client> pageClients =
                //clientRepository.findByNomClientContains(mc, PageRequest.of(page,2));
        clientRepository.findAll(PageRequest.ofSize(10));
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
}



