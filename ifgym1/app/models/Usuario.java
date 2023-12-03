package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {

    @Required
    public String nome;

    @Required
    @Email
    public String email;

    @Required
    public String senha;

    @Enumerated(EnumType.STRING)
    public Status status;

    @OneToOne
    public Medida medidas;

    @OneToMany
    public List<Treino> treinos = new ArrayList();

    public Usuario() {
        this.status = status.ATIVO;
    }

}
