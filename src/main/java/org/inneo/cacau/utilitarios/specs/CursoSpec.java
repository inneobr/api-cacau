package org.inneo.cacau.utilitarios.specs;

import org.inneo.cacau.model.Cursos;
import jakarta.persistence.criteria.Predicate;
import org.inneo.cacau.utilitarios.enums.Situacao;
import org.springframework.data.jpa.domain.Specification;

public class CursoSpec {
	public static Specification<Cursos> daSituacao(Situacao situacao){
        return (root, query, builder) -> {
            if(situacao != null) {
                if(situacao.equals(Situacao.ATIVO)) {
                    return builder.isNull(root.get("disabledAt"));
                }
                else if(situacao.equals(Situacao.INATIVO)) {
                    return builder.isNotNull(root.get("disabledAt"));
                }
            }
            return builder.and(new Predicate[0]);
        };
    }
}
