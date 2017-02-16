/*package com.wxc.adplatform.core;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;

*//**
 * tomcat 配置
 * 
 * @author liaokailin
 * @version v1.0 2016年12月6日
 * @author luceas
 *//*
@Configuration
public class TomcatConfig {

	// @Bean
	// public EmbeddedServletContainerFactory servletContainer() {
	// TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
	// tomcat.setUriEncoding("UTF-8");
	// return tomcat;
	// }

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.setUriEncoding("UTF-8");
		tomcat.addAdditionalTomcatConnectors(createSslConnector());
		return tomcat;
	}

	private Connector createSslConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		try {
			File truststore = new File("/Users/liaokailin/software/ca1/keystore");
			connector.setScheme("https");
			protocol.setSSLEnabled(true);
			connector.setSecure(true);
			connector.setPort(8443);
			protocol.setKeystoreFile(truststore.getAbsolutePath());
			protocol.setKeystorePass("123456");
			protocol.setKeyAlias("springboot");
			return connector;
		} catch (Exception ex) {
			throw new IllegalStateException("cant access keystore: [" + "keystore" + "]  ", ex);
		}
	}

}*/