package com.StaticRs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class KhoitaoWebXml extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {SpringProjectCfg.class, HibernateConfig.class, tileConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
	
//		return new Class<?>[] {SpringProjectCfg.class};
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
}
