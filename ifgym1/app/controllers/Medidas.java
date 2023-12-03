package controllers;

import models.Medida;
import models.Treino;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Medidas extends Controller {

    public static void form() {
        Medida m = (Medida) Cache.get("medida");
        Cache.clear();
        render(m);
    }

    public static void salvar(@Valid Medida m) {
        if (Validation.hasErrors()) {
            validation.keep();
            flash.error("Falha ao salvar medida");
            Cache.set("medida", m);
            form();
        }

        m.save();
        Treinos.form();
    }

    public static void detalhar(long id) {
        Medida m = Medida.findById(id);
        render(m);
    }

    public static void editar(long id) {
        Medida m = Medida.findById(id);
        renderTemplate("Medidas/form.html", m);
    }

}
