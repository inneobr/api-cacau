package org.inneo.cacau.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;

import org.apache.tomcat.util.codec.binary.Base64;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_aulas")
public class Aulas extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="url_video")
	private String urlVideo;
	
	@Column(name = "id_curso")
	private String idCurso;
	
	@Transient
	private String thumbnail;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "bytes")
    private byte[] bytes; 
	
	@Transient
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String base64;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public byte[] getBase64ToBytes() {
        return Base64.decodeBase64(base64);
    }
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getBytesToBase64() {
        return Base64.encodeBase64String(bytes);
    }
}
