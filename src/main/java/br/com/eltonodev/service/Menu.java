package br.com.eltonodev.service;

import br.com.eltonodev.model.PdfCreator;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    private Translator translator;

    public Menu() {
        getMenu();
    }

    private void getMenu() {
        System.out.println("Bem-vindo ao seu assistente personalizado de Currículo!!");
        System.out.println("Você deseja criar um currículo em:");
        System.out.println("1 - Português");
        System.out.println("2 - Inglês (e português)");

        while (true) {
            try {
                int optionLang = sc.nextInt();
                sc.nextLine(); // Consume newline
                if (optionLang == 1) {
                    createCurriculum(false);
                } else if (optionLang == 2) {
                    createCurriculum(true);
                } else {
                    System.out.println("Escolha apenas 1 ou 2 (Caso queira encerrar o programa, aperte CTRL + C)");
                }
            } catch (InputMismatchException e) {
                System.out.println("Escolha apenas uma das opções.");
                sc.next(); // Clear the invalid input
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createCurriculum(boolean requiresTranslation) throws Exception {
        if (requiresTranslation) {
            System.out.println("Aviso: Não use caracteres especiais.");
            System.out.println("Antes de prosseguirmos, você precisa ter uma APIKEY do Deepl.");
            System.out.print("Digite sua APIKEY: ");
            String apiKey = sc.nextLine();
            translator = new Translator(apiKey);
        } else {
            System.out.println("Aviso: Não use caracteres especiais.");
        }

        String nome = getInput("Nome: ");
        String email = getInput("Email: ");
        String telefone = getInput("Celular (Ex: +55 91 998314565): ");
        String endereco = getInput("Endereço: ");
        String experiencia = getInput("Experiência Profissional (ex: Cargo - Empresa - (Ano)Inicio.Fim, separadas por vírgula): ");
        String educacao = getInput("Educação (ex: Grau - Instituição - (Ano)Inicio.Fim, separadas por vírgula): ");
        String habilidades = getInput("Habilidades (ex: JAVA 1 ANO, PHP 4 ANOS, separadas por vírgula): ");
        String resumo = getInput("Resumo: ");

        if (requiresTranslation) {
            if (!endereco.isEmpty()){
                endereco = translator.translate(endereco);
            }
            if (!experiencia.isEmpty()) {
                experiencia = translator.translate(experiencia);
            }
            if (!educacao.isEmpty()) {
                educacao = translator.translate(educacao);
            }
            if (!resumo.isEmpty()) {
                resumo = translator.translate(resumo);
            }
        }

        new PdfCreator(nome, email, telefone, endereco, experiencia, educacao, habilidades, resumo);
    }

    private String getInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}
