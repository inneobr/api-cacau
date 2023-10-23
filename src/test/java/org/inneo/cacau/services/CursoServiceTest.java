package org.inneo.cacau.services;

import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.inneo.cacau.model.Videos;
import static org.mockito.Mockito.when;
import org.inneo.cacau.repository.VideosRep;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class VideosServiceTest {
	@Autowired
	private VideosService videosService;
	
	@Mock
	private VideosRep videosRep;

	@Mock
	private Videos videos;
	
	@Test
	public void saveTest() {
		getVideo();
		when(videosRep.save(videos)).thenReturn(videos);
		var create = videosService.save(videos);
		assertNotNull(create.getUuid());
		
	} 
	
	@Test
	public void findAllTest() {
		var create = videosService.findAll();
		assertNotNull(create);		
	} 
	
	public Videos getVideo() {
		Videos videos = new Videos();
		videos.setTitulo("Blusinha");
		return videos;
	}
}
