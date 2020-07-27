package com.av.springmvc.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringConfigDispatchInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {SpringConfig.class} ;
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
}