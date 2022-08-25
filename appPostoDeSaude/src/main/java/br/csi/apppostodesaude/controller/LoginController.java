package br.csi.apppostodesaude.controller;

import br.csi.apppostodesaude.model.Usuario;
import br.csi.apppostodesaude.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha, HttpSession session, Model model){

        Usuario usuario = new UsuarioService().autenticado(email, senha);


        String url;
        boolean loginFalhou = false;

        if(usuario != null){
            model.addAttribute("usuario", usuario);
            session.setAttribute("usuario_logado", usuario);
            url = "dashboard";
            System.out.println(session);
        }else{
            loginFalhou = true;
            url = "login";
        }

        model.addAttribute("logado", loginFalhou);
        return url;
    }

    @GetMapping("/LogOut")
    public String LogOut(HttpSession session, Model model){
        session.invalidate();
        model.addAttribute("usuario", new Usuario());
        return "login";
    }


}
