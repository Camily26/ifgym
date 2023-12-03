package models;

import javax.persistence.Entity;

import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Treino extends Model {

    @Required
    public String nome;
    @Required
    public String descricao;
    @Required
    @Min(0)
    public Integer series;
    @Required
    @Min(0)
    public Integer repeticoes;
    @Required
    @Min(0)
    public Double duracao;

}
