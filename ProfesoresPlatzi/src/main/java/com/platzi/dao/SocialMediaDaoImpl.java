package com.platzi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.model.SocialMedia;
import com.platzi.model.TeacherSocialMedia;

@Repository
@Transactional
public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao {

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().save(socialMedia);
	}

	@Override
	public void deleteSocialMediaById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		SocialMedia socialMedia = findById(idSocialMedia);
		if ( socialMedia != null ) {
			getSession().delete(socialMedia);
		}
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().update(socialMedia);
	}

	@Override
	public List<SocialMedia> findAllSocialMedias() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from SocialMedia").list();
	}

	@Override
	public SocialMedia findById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		return getSession().get(SocialMedia.class, idSocialMedia);
	}

	@Override
	public SocialMedia findByName(String name) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().createQuery("from SocialMedia where name = :name").setParameter("name", name).uniqueResult();
	}
	
	@Override
	public SocialMedia findByIcon(String icon) {
		return (SocialMedia) getSession().createQuery("from SocialMedia where icon = :icon").setParameter("icon", icon).uniqueResult();
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickName) {
		// TODO Auto-generated method stub
		List<Object[]> objects = getSession().createQuery(
				"from TeacherSocialMedia tsm join tsm.socialMedia sm"
				+ " where sm.idSocialMedia = :idSocialMedia and tsm.nickname = :nickName").setParameter("idSocialMedia", idSocialMedia)
				.setParameter("nickName", nickName).list();
		
		if (objects.size() > 0 ) {
			for (Object[] object2 : objects) {
				for ( Object object : object2) {
					if ( object instanceof TeacherSocialMedia) {
						return (TeacherSocialMedia) object;
					}
				}
			}
		}
		
		return null;
	}


}
