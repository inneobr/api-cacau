package org.inneo.cacau.utilitarios.specs;

import org.inneo.cacau.model.Videos;
import org.inneo.cacau.utilitarios.enums.Situacao;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class SpecVideos {
	public static Specification<Videos> daSituacao(Situacao situacao){
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
