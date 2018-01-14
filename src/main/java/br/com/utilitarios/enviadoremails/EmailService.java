package br.com.utilitarios.enviadoremails;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void enviar(String nome, String emaildestino) {

        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("sistemasparaempreitas@gmail.com", "Killers092."));
            email.setSSLOnConnect(true);

            email.setFrom("enviadordeemail@github.com");
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP - Obrigado por fazer parte do meu teste Att, Jefferson.");
            email.addTo(emaildestino);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
