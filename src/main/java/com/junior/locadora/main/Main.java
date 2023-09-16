package com.junior.locadora.main;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.junior.locadora.domain.Cadastro;
import com.junior.locadora.services.CadastroService;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.junior.locadora")
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        CadastroService cadastroService = context.getBean(CadastroService.class);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Digite 1 para cadastrar um novo filme ou 0 para finalizar o cadastro:");
            int opcao = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha pendente

            if (opcao == 0) {
                System.out.println("Agradecemos o seu cadastro, volte sempre !!!");
                break; // Encerra o programa quando o usuário digitar "0"
            } else if (opcao != 1) {
                System.out.println("Opção inválida. Digite 1 para cadastrar um novo filme ou 0 para finalizar o cadastro.");
                continue; // Volta ao início do loop para pedir uma opção válida
            }

            System.out.println("Cadastro Do Produto");
            System.out.println("Nome do filme:");
            String nome = sc.nextLine();

            System.out.println("Informe a descricao:");
            String descricao = sc.nextLine();
            System.out.println("Informe a duracao:");
            double duracao = sc.nextDouble();
            System.out.println("Informe a idade minima:");
            int idademin = sc.nextInt();

            sc.nextLine(); // Consumir a quebra de linha pendente

            Cadastro cadastro = cadastroService.criarCadastro(nome, descricao, duracao, idademin);

            System.out.println("Cadastro criado com sucesso: ID = " + cadastro.getId());
        }

        sc.close();
    }
}
