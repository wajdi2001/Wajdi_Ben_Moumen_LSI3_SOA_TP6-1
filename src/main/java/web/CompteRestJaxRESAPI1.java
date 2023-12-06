package web;

import entities.Compte;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import repositories.CompteRepository;
import java.util.List;

//methode jersey pour le devoir
@Component
@Path("/banque")
public class CompteRestJaxRESAPI1 {

    @Autowired
    private CompteRepository compteRepository;



    @Path("/comptes")
    @GET @Transactional
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }




    @Path("/comptes/{id}")
    @GET @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam("id") Long id){
        return compteRepository.findById(id).get();
    }





    @Path("/comptes")
    @POST @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Compte createCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }





    @Path("/comptes/{id}")
    @PUT @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte, @PathParam("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Long id){
        compteRepository.deleteById(id);
        System.out.println("Compte est supprimé");
    }
}