package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.service.ICuentaBancariaService;
import com.example.demo.banco.service.ITransferenciaService;
import com.example.demo.herencia.CitaMedicaH;
import com.example.demo.herencia.MedicoH;
import com.example.demo.herencia.PacienteTerceraEdadH;
import com.example.demo.spring.boot.CitaMedicaSB;
import com.example.demo.spring.boot.MedicoSB;
import com.example.demo.spring.boot.PacienteCancerSB;
import com.example.demo.spring.boot.PacienteTerceraEdadSB;

@SpringBootApplication
public class ProyectoU1HCApplication implements CommandLineRunner {

	@Autowired	
	private ICuentaBancariaService bancariaService;
	@Autowired
	private ITransferenciaService transferenciaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU1HCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CuentaBancaria bancaria1 = new CuentaBancaria();
		bancaria1.setNumero("0002");
		bancaria1.setSaldo(new BigDecimal(200));
		bancaria1.setTipo("A");
		bancaria1.setTitular("Henry");
		
		
		CuentaBancaria bancaria2 = new CuentaBancaria();
		bancaria2.setNumero("0001");
		bancaria2.setSaldo(new BigDecimal(300));
		bancaria2.setTipo("B");
		bancaria2.setTitular("Edison");
		
		this.bancariaService.insertar(bancaria1);
		this.bancariaService.insertar(bancaria2);
		
		System.out.println("Reporte1");
		
		for (Transferencia t : this.transferenciaService.buscarReporte()) {

				System.out.println(t);
	
		}
		
		this.transferenciaService.realizar("0002", "0001", new BigDecimal(50));

		System.out.println("Reporte2");
		for (Transferencia t : this.transferenciaService.buscarReporte()) {

			System.out.println(t);	
		}

		
	}
}

