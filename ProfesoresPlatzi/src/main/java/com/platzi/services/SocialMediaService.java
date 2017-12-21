package com.platzi.services;

import java.util.List;

import com.platzi.model.SocialMedia;
import com.platzi.model.TeacherSocialMedia;

public interface SocialMediaService {

	void saveSocialMedia(SocialMedia socialMedia);

	void deleteSocialMediaById(Long idSocialMedia);

	void updateSocialMedia(SocialMedia socialMedia);

	List<SocialMedia> findAllSocialMedias();

	SocialMedia findById(Long idSocialMedia);

	SocialMedia findByName(String name);
	
	SocialMedia findByIcon(String icon);

	TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickName);

}
