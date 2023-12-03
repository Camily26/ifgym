package controllers;

import java.util.List;

import models.Treino;
import play.cache.Cache;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Treinos extends Controller {

    public static void form() {
        Treino t = (Treino) Cache.get("treino");
        Cache.clear();
        render(t);
    }

    public static void salvar(@Valid Treino t) {
        if (Validation.hasErrors()) {
            validation.keep();
            flash.error("Falha ao salvar treino");
            Cache.set("treino", t);
            form();
        }

        t.save();
        flash.success("Salvo com sucesso");
        listar();
    }

    public static void listar() {
        List<Treino> t = Treino.findAll();
        render(t);
    }

    public static void detalhar(long id) {
        Treino t = Treino.findById(id);
        render(t);
    }

    public static void editar(long id) {
        Treino t = Treino.findById(id);
        renderTemplate("Treinos/form.html", t);
    }

    public static void remover(Long id) {
        Treino t = Treino.findById(id);
        t.save();

        Usuarios.index();
    }

}
