// specialty, client, message, reservation, doctor
//1.modelo o entidad
//2.interfaces
//3.repositorio
//4.servicios
//5.controlador o web


package Usa.ciclo3.Reto3final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"Usa.ciclo3.Reto3final.modelo"})
public class Reto3finalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto3finalApplication.class, args);
	}

}
