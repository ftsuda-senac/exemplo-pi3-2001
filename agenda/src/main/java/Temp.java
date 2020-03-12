
import br.senac.tads.pi3.agenda.model.entidades.Contato;
import br.senac.tads.pi3.agenda.model.entidades.Email;
import br.senac.tads.pi3.agenda.model.entidades.Telefone;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando.tsuda
 */
public class Temp {
    
    
    public void x() {
                List<Contato> contatos = new ArrayList<Contato>();
        Contato c1 = new Contato();
        c1.setId(1);
        c1.setNome("Fulano");
        c1.setApelido("Fulano");
        c1.setDataNascimento(LocalDate.of(2000, Month.JULY, 3));
        Email email = new Email();
        email.setId(1);
        email.setEndereco("fulano@teste.com.br");
        email.setTipo("PRINCIPAL");
        c1.setEmails(Arrays.asList(email));
        Telefone telefone = new Telefone();
        telefone.setId(1);
        telefone.setNumero("+55 11 99999-9999");
        telefone.setTipo("PRINCIPAL");
        c1.setTelefones(Arrays.asList(telefone));
        contatos.add(c1);

    }
}
