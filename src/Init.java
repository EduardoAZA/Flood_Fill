import java.util.*;

public class Init {
    Image pixelImage;

    public Init() {
        boolean control = true;
        Scanner scan = new Scanner(System.in);

        System.out.println("Olá, seja bem-vindo ao programa de floodfill");

        System.out.println("Primeiramente informe o tamanho da imagem:");
        int size = scan.nextInt();

        pixelImage = new Image(size, size);

        do {
            try {
                System.out.println("Escolha uma das seguintes opções");
                System.out.println("1. Alterar pixels. \n2. Sair.");
                int option = scan.nextInt();
                if (option == 1) {
                    System.out.println("Selecione a coordenada 'x': ");
                    int x = scan.nextInt();

                    System.out.println("Selecione a coordenada 'y': ");
                    int y = scan.nextInt();

                    System.out.println("Escolha agora o método de uso: \n1- Pilha \n2- Fila ");
                    int option2 = scan.nextInt();

                    if (option2 == 1) {
                        pixelImage.StackFloodFill(new Coordinates(x, y));
                    } else {
                        pixelImage.QueueFloodFill(new Coordinates(x, y));
                    }

                } else {
                    control = false;
                    System.out.println("Flood fill realizado com sucesso");
                }

            } catch (InputMismatchException e) {
                System.out.println("Digite um numero natural,por favor.");
                scan.next();
            }

        } while (control);
    }
}