package co.id.javan.berbageekprasimsha.co.id.javan.berbageekprasimsha.controller;

import antlr.ASTNULLType;
import co.id.javan.berbageekprasimsha.Kolam;
import co.id.javan.berbageekprasimsha.Petani;
import co.id.javan.berbageekprasimsha.co.id.javan.berbageekprasimsha.respositories.KolamRespository;
import co.id.javan.berbageekprasimsha.co.id.javan.berbageekprasimsha.respositories.PetaniRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
//@RequestMapping("/petani")
public class HomeController {

    @Autowired
    PetaniRespository petaniRespository;
    KolamRespository kolamRespository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Petani> petaniList = petaniRespository.findAll();
        model.addAttribute("petaniList", petaniList);
        return "index";
    }

    @GetMapping("/add")
    public String addPetani (@Valid Petani petani){
        return "add-petani";
    }

    @PostMapping("/save")
    public String savePetani(@Valid Petani petani, Model model){
        petaniRespository.save(petani);
        model.addAttribute("petani",petaniRespository.findAll());
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public String editPetani(@PathVariable("id") long id, Model model){
        Petani petani = petaniRespository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid petani Id:"+ id));

        model.addAttribute("petani",petani);
        return "update-petani";
    }

    @PostMapping("/update/{id}")
    public String updatePetani(@PathVariable("id") long id, Petani petani, Model model){
        petaniRespository.save(petani);
        model.addAttribute("petaniList",petaniRespository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deletePetani(@PathVariable("id") long id, Model model){
        Petani petani = petaniRespository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid petani Id:" + id));
        petaniRespository.delete(petani);
        model.addAttribute("petaniList",petaniRespository.findAll());
        return "index";
    }



    /*private void initData(){
        Petani petani = new Petani();
        petani.setNamaLengkap("Owen Prasimsha");
        petani.setNoTlp("081234567890");
        petaniRespository.save(petani);

        Kolam kolam = new Kolam(100l, petani);
        kolamRespository.save(kolam);
    }*/


}
