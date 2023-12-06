package web;

import entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.CompteRepository;

import java.util.List;
//methode RestController n'est pas pour le devoir mais pour le test
@RestController
@RequestMapping("/banque")
public class CompteRestJaxRSAPI {

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping("/comptes")
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{id}")
    public Compte getCompteById(@PathVariable Long id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));
    }

    @PostMapping("/comptes")
    public Compte createCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte updateCompte(@PathVariable Long id, @RequestBody Compte updatedCompte) {
        return compteRepository.findById(id)
                .map(existingCompte -> {
                    existingCompte.setSolde(updatedCompte.getSolde());
                    existingCompte.setDateCreation(updatedCompte.getDateCreation());
                    existingCompte.setType(updatedCompte.getType());
                    existingCompte.setEtat(updatedCompte.getEtat());
                    return compteRepository.save(existingCompte);
                })
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));
    }

    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}
