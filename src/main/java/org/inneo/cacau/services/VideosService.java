package org.inneo.cacau.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.inneo.cacau.model.Videos;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.inneo.cacau.repository.VideosRep;
import org.springframework.stereotype.Service;
import org.inneo.cacau.utilitarios.enums.Situacao;
import org.inneo.cacau.utilitarios.specs.SpecVideos;
import org.inneo.cacau.utilitarios.filters.VideosFilter;

@Service
@RequiredArgsConstructor
public class VideosService {	
	private final VideosRep videosRep;
	
	public Videos save(Videos request) {		
		Videos videos = request.getUuid() != null ? videosRep.getReferenceById(request.getUuid()) : new Videos();
		request.setCreatedAt(videos.getCreatedAt());
		BeanUtils.copyProperties(request, videos);
		return videosRep.save(videos);		
	}	
	
	public List<Videos> findFilter(VideosFilter filter) {
		return videosRep.findAll();
	}
	
	public List<Videos> findAll() {
		List<Videos> videos = videosRep.findAll(SpecVideos.daSituacao(Situacao.ATIVO));
		return videos;		
	}
	
	public Videos findEvent(UUID uuid) {
		return videosRep.findByUuid(uuid);
	}
	
	public void disable(UUID uuid) {
		Videos videos = videosRep.findByUuid(uuid);
		videos.setDisabledAt(new Date());
		videosRep.save(videos);
	}
	
	public void enable(UUID uuid) {
		Videos videos = videosRep.findByUuid(uuid);
		videos.setDisabledAt(null);
		videosRep.save(videos);
	}

}
