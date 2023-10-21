package org.inneo.cacau.utilitarios;

import org.inneo.cacau.model.Eventos;
import org.inneo.cacau.utilitarios.enums.Situacao;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class SpecEventos {
	public static Specification<Eventos> daSituacao(Situacao situacao){
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
