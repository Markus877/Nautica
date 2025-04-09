package com.base;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.base.model.barco;
import com.base.service.barco_service;
import com.base.service.salida_service;
import com.base.service.socios_service;

import javax.sql.DataSource;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @SuppressWarnings("unused")
    @Bean
    CommandLineRunner init(barco_service barcoService, socios_service socios_service, salida_service salida_service, DataSource DataSource) {
        return (args) -> {
            
        	// Imprimir todos los barcos, socios y salidas
            barcoService.findAll().forEach(barco -> System.out.println(barco.getNombre() + " id=" + barco.getId_barco()+ " matricula="+barco.getMatricula()+" amarre="+barco.getAmarre()+" cuota=" + barco.getCuota()+" socio="+barco.getId_barco()));
            socios_service.findAll().forEach(socio -> System.out.println("Hola!! Yo soy "+socio.getNombre()+" "+socio.getApellido()+" y mi email es " + socio.getEmail()));
            salida_service.findAll().forEach(salida -> System.out.println(salida.getFecha()+" Destino="+salida.getDestino()+" datos_patron="+salida.getDatos_patron()));
            
            //Con JPQL busca un barco y te dice si lo encuentra o no
            barco barcoEncontrado = barcoService.getBarcoPorNombre("BarcoUno");
            if (barcoEncontrado != null) {
                System.out.println("Barco encontrado: " + barcoEncontrado.getNombre());
            } else {
                System.out.println("No se encontró ningún barco con el nombre especificado.");
            }
            
            //Con JPQL modifica la cuota de un barco
            barco barcoParaActualizar = barcoService.getBarcoPorNombre("BarcoUno");
            if (barcoParaActualizar != null) {
                barcoParaActualizar.setCuota(1500);
                barcoService.update(barcoParaActualizar);
                System.out.println("Barco actualizado: " + barcoParaActualizar.getNombre() + " nueva cuota=" + barcoParaActualizar.getCuota());
            } else {
                System.out.println("No se encontró el barco para actualizar.");
            }
            
            //Eliminar todos los barcos en el amarre 8
            
            barcoService.findAll().forEach(barco -> {
                if ("9".equals(barco.getAmarre())) {
                    barcoService.deleteByAmarre(barco.getAmarre());
                    System.out.println("Barco eliminado: " + barco.getNombre() + " en el amarre " + barco.getAmarre());
                }
            });
            
           
        };
    }
}
   

        
    




        
    

