package br.com.paula.mercadoLivre.validador;

import br.com.paula.mercadoLivre.exception.CadastroExistenteException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UnicoValidator implements ConstraintValidator<Unico, Object> {

    private String campo;
    private Class<?> modelClass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(Unico unicoAnnotation) {
        campo = unicoAnnotation.campo();
        modelClass = unicoAnnotation.modelClass();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("SELECT 1 FROM " + this.modelClass.getName() + " WHERE " + this.campo + "=:param")
                .setParameter("param", value);
        List<?> list = query.getResultList();
        if (!list.isEmpty()) { throw new CadastroExistenteException(); }

        return true;
    }
}
