import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        workWithFolder();
        readFile();
        registration();
        login();
    }

    public static void workWithFolder() throws IOException {

        String path = "src/file";
        Path pathToFile = Paths.get(path);
        if (!Files.exists(pathToFile.getParent())) {
            Files.createDirectories(pathToFile.getParent());
        }
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write("Snow on the ground.\n" +
                "Snow on the tree.\n" +
                "Snow on the house.\n" +
                "Snow on me!");
        fileWriter.close();
    }

    public static void readFile() throws IOException {
        FileReader fileReader = new FileReader("src/file");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
        fileReader.close();
    }

    public static void registration() throws IOException {
        String login;
        String password;
        String confirmPassword;
        FileWriter fileWriter = new FileWriter("src/user.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Create your login: ");
        login = scanner.nextLine();
        System.out.print("Create your password: ");
        password = scanner.nextLine();
        System.out.print("Confirm your password: ");
        confirmPassword = scanner.nextLine();

        if (password.equals(confirmPassword)) {
            fileWriter.write(login.concat(" <--Login\n"));
            fileWriter.write(password.concat(" <--Password\n"));
            fileWriter.close();
        } else {
            System.err.println("Password does not match, please try again");
        }
    }

    public static void login() {
        String login;
        String password;
        int i = 0;
        while (i < 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Write your login: ");
            login = scanner.nextLine();
            System.out.print("Write your password: ");
            password = scanner.nextLine();
            if (login.equals("Dennis@gmail.com") && password.equals("123")){
                System.out.println("Welcome to you account");
                break;
            }
            i++;
            System.out.println("Login/Password is incorrect.Try again");
        } if (i == 3){
            System.err.println("Unsuccessfully entered username/password, please try to log in later");
        }
    }
}
