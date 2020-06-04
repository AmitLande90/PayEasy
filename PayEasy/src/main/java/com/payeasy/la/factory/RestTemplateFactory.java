package com.payeasy.la.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.client.RestTemplate;

public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean{

	private RestTemplate restTemplate;
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RestTemplate getObject() throws Exception {
		return restTemplate;
	}

	@Override
	public Class<?> getObjectType() {
		return RestTemplate.class;
	}

}
