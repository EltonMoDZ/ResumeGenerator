package br.com.eltonodev.model;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;

public class PdfCreator {

    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String experiencia;
    private String educacao;
    private String habilidades;
    private String resume;
    private String dest = "Curriculo.pdf";

    public PdfCreator(String nome, String email, String telefone, String endereco, String experiencia, String educacao, String habilidades, String resume) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.experiencia = experiencia;
        this.educacao = educacao;
        this.habilidades = habilidades;
        this.resume = resume;
        createPdf();
    }

    public void createPdf() {
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Currículo").setFontSize(20).setBold().setFontColor(ColorConstants.BLACK));

            addPersonalInfo(document, nome, email, telefone, endereco);
            addExperience(document, experiencia);
            addEducation(document, educacao);
            addSkills(document, habilidades);
            addResume(document, resume);

            document.close();
            System.out.println("PDF criado com sucesso em " + dest + "!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addPersonalInfo(Document document, String nome, String email, String telefone, String endereco) {
        document.add(new Paragraph("Informações Pessoais").setBold());
        if (!nome.isEmpty()) document.add(new Paragraph("Nome: " + nome));
        if (!email.isEmpty()) document.add(new Paragraph("Email: " + email));
        if (!telefone.isEmpty()) document.add(new Paragraph("Telefone: " + telefone));
        if (!endereco.isEmpty()) document.add(new Paragraph("Endereço: " + endereco));
        document.add(new Paragraph("\n"));
    }

    private void addExperience(Document document, String experiencia) {
        if (!experiencia.isEmpty()) {
            document.add(new Paragraph("Experiência Profissional").setBold());
            List experienceList = new List();
            for (String experienciaString : experiencia.split(",")) {
                experienceList.add(new ListItem(experienciaString));
            }
            document.add(experienceList);
            document.add(new Paragraph("\n"));
        }
    }

    private void addEducation(Document document, String educacao) {
        if (!educacao.isEmpty()) {
            document.add(new Paragraph("Educação").setBold());
            List educationList = new List();
            for (String educacaoString : educacao.split(",")) {
                educationList.add(new ListItem(educacaoString)); // Corrigido para ListItem
            }
            document.add(educationList);
            document.add(new Paragraph("\n"));
        }
    }

    private void addSkills(Document document, String habilidades) {
        if (!habilidades.isEmpty()) {
            document.add(new Paragraph("Habilidades / Skills").setBold());
            List skillsList = new List();
            for (String habilidade : habilidades.split(",")) {
                skillsList.add(new ListItem(habilidade.trim())); // Corrigido para ListItem
            }
            document.add(skillsList);
        }
    }

    private void addResume(Document document, String resume) {
        if (!resume.isEmpty()) {
            document.add(new Paragraph("Resumo").setBold());
            document.add(new Paragraph(resume));
        };
    }
}
