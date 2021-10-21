/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 *
 * @author jgarc
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan("co.edu.escuelaing.arsw.letsdraw")
public class LetsDrawApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(LetsDrawApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
    }
}
