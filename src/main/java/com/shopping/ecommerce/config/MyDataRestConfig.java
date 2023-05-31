package com.shopping.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.shopping.ecommerce.entity.Country;
import com.shopping.ecommerce.entity.Product;
import com.shopping.ecommerce.entity.ProductCategory;
import com.shopping.ecommerce.entity.State;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	@Value("${allowed.origins}")
	private String[] theAllowedOrigins;
	
	private EntityManager entityManager;
	
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.POST, HttpMethod.DELETE};
		
		disableHttpMethods(Product.class, config, theUnsupportedActions);
		disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);
		disableHttpMethods(Country.class, config, theUnsupportedActions);
		disableHttpMethods(State.class, config, theUnsupportedActions);
		
		exposeIds(config);
		
		cors.addMapping(config.getBasePath() + "/**").allowedOrigins(theAllowedOrigins);
	}

	private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
		config.getExposureConfiguration()
		.forDomainType(theClass)
		.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	}

	private void exposeIds(RepositoryRestConfiguration config) {
		
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		List<Class<?>> entityClasses = new ArrayList<>();
		
		for (EntityType<?> tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
		
		Class<?>[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}

	
	
}
