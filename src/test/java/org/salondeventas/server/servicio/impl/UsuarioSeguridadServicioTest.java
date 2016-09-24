package org.salondeventas.server.servicio.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from the static inner ContextConfiguration class
@ContextConfiguration(locations = {"file:src/main/webapp/META-INF/spring/applicationContext.xml"})

public class UsuarioSeguridadServicioTest {

 @Configuration
 static class ContextConfiguration {

     // this bean will be injected into the OrderServiceTest class
     @Bean
     public UsuarioSeguridadServicio orderService() {
    	 UsuarioSeguridadServicio orderService = new UsuarioSeguridadServicio();
         // set properties, etc.
         return orderService;
     }
 }

 @Autowired
 private UsuarioSeguridadServicio orderService;

 @Test
 public void testOrderService() {
	 orderService.comprobarUsuario("leonel", "123");
 }
}