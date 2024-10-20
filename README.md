# Resume Generator

This Java application helps you create a professional resume in PDF format. It offers the option to generate the resume in Portuguese or both Portuguese and English.

## Features

- Create a resume in Portuguese
- Create a resume in both Portuguese and English (with automatic translation)
- Generate a PDF file with your resume information

## Requirements

- Java 21 or higher
- Maven
- DeepL API key (for English translation)

## Setup

1. Clone the repository or download the source code.
2. Make sure you have Java 21 and Maven installed on your system.
3. Open a terminal and navigate to the project directory.
4. Run the following command to build the project:

   ```
   mvn clean install
   ```

## How to Use

1. Run the application using the following command:

   ```
   java -jar target/ResumeGenerator-1.0-SNAPSHOT.jar
   ```

2. Follow the on-screen prompts:

   - Choose the language option:
     1. Portuguese only
     2. Portuguese and English

3. If you chose option 2 (Portuguese and English):
   - You'll be prompted to enter your DeepL API key.
   - Make sure you have a valid API key from [DeepL](https://www.deepl.com/pro-api).

4. Enter your personal information as requested:
   - Name
   - Email
   - Phone number
   - Address
   - Professional experience
   - Education
   - Skills
   - Summary

5. The program will generate a PDF file with your resume in the chosen language(s).

## Important Notes

- When entering multiple items (e.g., for experience, education, or skills), separate them with commas.
- For dates, use the format (Year)Start.End, e.g., (2020)2020.2022.
- Avoid using special characters, as they may cause issues with the PDF generation or translation.

## Example Input

Here's an example of how to input your information:

- Name: John Doe
- Email: john.doe@example.com
- Phone: +55 11 98765-4321
- Address: 123 Main St, São Paulo, SP, 01234-567
- Professional Experience: Software Developer - TechCorp - (2020)2020.2022, Intern - CodeCo - (2019)2019.2020
- Education: Bachelor's in Computer Science - University of São Paulo - (2016)2016.2020
- Skills: Java 3 years, Python 2 years, Git 4 years
- Summary: Passionate software developer with experience in web applications and machine learning.

## Troubleshooting

- If you encounter any issues with character encoding, make sure your terminal supports UTF-8.
- If the translation doesn't work, double-check your DeepL API key and internet connection.

For any other issues or questions, please open an issue on the project's GitHub repository.
