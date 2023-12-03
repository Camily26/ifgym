package controllers;

import models.Status;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;
import play.mvc.With;
 
@With(Secure.class)
public class Usuarios extends Controller {

    public static void form() {
        Usuario u = (Usuario) Cache.get("usuario");
        Cache.clear();   
        render(u);
    }

    public static void index() {
        render();
    }

    public static void salvar(@Valid Usuario u) {
        if (Validation.hasErrors()) {
            validation.keep();
            flash.error("Falha ao salvar usuário");
            Cache.set("usuario", u);
            form();
        }

        flash.success("Salvo com sucesso");
        u.save();
        Medidas.form();
    }

    public static void editar(long id) {
        Usuario u = Usuario.findById(id);
        renderTemplate("Usuarios/form.html", u);
    }

    public static void excluir(long id) {
        Usuario u = Usuario.findById(id);
        flash.success("Removido com sucesso");
        u.status = Status.INATIVO;
        Logins.logout();
    }
}
