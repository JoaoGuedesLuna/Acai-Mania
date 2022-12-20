package com.acaimania;

import com.acaimania.model.decorator.*;
import com.acaimania.model.*;
import com.acaimania.service.DeliveryService;
import com.acaimania.strategy.*;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe onde o programa será executado.
 *
 * @author João Guedes.
 */
public class AcaiManiaApplication {

    /**
     * Método que exibe um menu onde o usuário poderá escolher se deseja uma porção pequena ou uma porção grande de açaí.
     * Retorna o açaí que o usuário escolheu, caso ele opte por sair será retornado o valor null.
     *
     * @param scan Scanner que fará a leitura de dados.
     *
     * @return Retorna o açaí que o usuário escolheu, caso ele opte por sair será retornado o valor null.
     */
    public static Acai showAcaiOptionsMenu(Scanner scan) {
        clearScreen();
        StringBuilder acaiOptions = acaiOptions();
        String validOptions = "12X";
        String userOption;
        do {
            System.out.print(acaiOptions);
            userOption = scan.next();
            if (userOption.length() > 1 || !validOptions.contains(userOption.toUpperCase())) {
                System.out.print("\n           ❌ Opção inválida ❌");
                showEndLine();
            }
            else {
                showEndLine();
                return getAcai(userOption);
            }
        } while(true);
    }

    /**
     * Método que retorna um StringBuilder contendo as opções de açaí disponíveis.
     *
     * @return Retorna um StringBuilder contendo as opções de açaí disponíveis.
     */
    public static StringBuilder acaiOptions() {
        Acai smallAcai = SmallAcai.getInstance();
        Acai bigAcai = BigAcai.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("🍨 🍨 🍨 🍨 🍨 🍨 AÇAÍ MANIA 🍨 🍨 🍨 🍨 🍨 🍨\n\n");
        sb.append("Escolha uma das opções de tamanho:\n");
        sb.append("\n[1] - Açaí no copo (").append(smallAcai.getQuantity()).append(") -> R$").append(smallAcai.getPrice());
        sb.append("\n[2] - Açaí na tigela (").append(bigAcai.getQuantity()).append(") -> R$").append(bigAcai.getPrice());
        sb.append("\n[x] - Sair");
        sb.append("\n\n               Opção: ");
        return sb;
    }

    /**
     * Método que retorna um açaí conforme a opção do usuário.
     *
     * @param userOption Opção do usuário.
     *
     * @return Retorna um açaí conforme a opção do usuário.
     */
    public static Acai getAcai(String userOption) {
        return switch (userOption) {
            case "1": yield SmallAcai.getInstance();
            case "2": yield BigAcai.getInstance();
            default:
                showByeMessage();
                yield null;
        };
    }

    /**
     * Método que exibe um menu onde o usuário poderá escolher quais adicionais ele deseja adicionar ao seu açaí.
     * Retorna o açaí que o usuário escolheu, com os adicionais que ele optou por colocar. Caso o usuário opte por
     * sair será retornado o valor null.
     *
     * @param acai Açai do usuário.
     *
     * @param scan Scanner que fará a leitura dos dados.
     *
     * @return Retorna o açaí que o usuário escolheu, com os adicionais que ele optou por colocar. Caso o usuário opte por
     * sair será retornado o valor null.
     */
    public static Acai showAdditionalOptionsMenu(Acai acai, Scanner scan) {
        clearScreen();
        StringBuilder additionalOptions = additionalOptions();
        String validOptions = "123456SX";
        String userOption;
        do {
            System.out.print(additionalOptions);
            userOption = scan.next();
            if (userOption.length() > 1 || !validOptions.contains(userOption.toUpperCase())) {
                System.out.print("\n           ❌ Opção inválida ❌");
                showEndLine();
            }
            else {
                showEndLine();
                return assemblyAcai(acai, userOption, scan);
            }
        } while(true);
    }

    /**
     * Método que retorna um StringBuilder contendo as opções de adicionais disponíveis.
     *
     * @return Retorna um StringBuilder contendo as opções de adicionais disponíveis.
     */
    public static StringBuilder additionalOptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("🍨 🍨 🍨 🍨 🍨 🍨 AÇAÍ MANIA 🍨 🍨 🍨 🍨 🍨 🍨\n");
        sb.append("\nEscolha uma das opções de adicionais:\n");
        sb.append("\n[1] - Leite Condesado -> R$").append(CondensedMilk.ADDITIONAL_PRICE);
        sb.append("\n[2] - Leite em pó -> R$").append(MilkPowder.ADDITIONAL_PRICE);
        sb.append("\n[3] - Paçoca -> R$").append(Pacoca.ADDITIONAL_PRICE);
        sb.append("\n[4] - Granola -> R$").append(Muesli.ADDITIONAL_PRICE);
        sb.append("\n[5] - Kiwi -> R$").append(Kiwi.ADDITIONAL_PRICE);
        sb.append("\n[6] - Morango -> R$").append(Strawberry.ADDITIONAL_PRICE);
        sb.append("\n[s] - Sem mais adicionais");
        sb.append("\n[x] - Sair");
        sb.append("\n\n               Opção: ");
        return sb;
    }

    /**
     * Método que monta um açaí conforme a opção de adicional do usuário.
     *
     * @param acai Açaí do usuário.
     *
     * @param additionalOption Opção de adicional que o usuário escolheu.
     *
     * @param scan Scanner que fará a leitura de dados.
     *
     * @return Retorna um açaí conforme a opção de adicional do usuário.
     */
    public static Acai assemblyAcai(Acai acai, String additionalOption, Scanner scan) {
        return switch (additionalOption.toUpperCase()) {
            case "1": yield showAdditionalOptionsMenu(new CondensedMilk(acai), scan);
            case "2": yield showAdditionalOptionsMenu(new MilkPowder(acai), scan);
            case "3": yield showAdditionalOptionsMenu(new Pacoca(acai), scan);
            case "4": yield showAdditionalOptionsMenu(new Muesli(acai), scan);
            case "5": yield showAdditionalOptionsMenu(new Kiwi(acai), scan);
            case "6": yield showAdditionalOptionsMenu(new Strawberry(acai), scan);
            case "S":
                yield acai;
            default:
                showByeMessage();
                yield  null;
        };
    }

    /**
     * Método que exibe um menu onde o usuário poderá escolher o serviço de entrega que ele deseja.
     *
     * @param scan Scanner que fará a leitura de dados.
     *
     * @return Retorna o valor da entrega.
     */
    public static Double showDeliveryOptionsMenu(Scanner scan) {
        StringBuilder deliveryOptions = deliveryOptions();
        String validOptions = "1234X";
        String userOption;
        boolean invalid = true;
        do {
            System.out.print(deliveryOptions);
            userOption = scan.next();
            if (userOption.length() > 1 || !validOptions.contains(userOption.toUpperCase())) {
                System.out.print("\n           ❌ Opção inválida ❌");
                showEndLine();
            }
            else {
                invalid = false;
            }
        } while(invalid);
        showEndLine();
        if (userOption.equalsIgnoreCase("x")) {
            showByeMessage();
            return null;
        }
        DeliveryServiceStrategy deliveryServiceStrategy = getDeliveryServiceStrategy(userOption);
        DeliveryService deliveryService = new DeliveryService(deliveryServiceStrategy);
        return deliveryService.calculateDeliveryPrice();
    }

    /**
     * Método que retorna um StringBuilder contendo todas as opções de serviço de entrega.
     *
     * @return Retorna um StringBuilder contendo todas as opções de serviço de entrega.
     */
    public static StringBuilder deliveryOptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("🍨 🍨 🍨 🍨 🍨 🍨 AÇAÍ MANIA 🍨 🍨 🍨 🍨 🍨 🍨\n");
        sb.append("\nEscolha uma das opções de entrega:\n");
        sb.append("\n[1] - Ifood -> R$").append(IFood.DELIVERY_PRICE);
        sb.append("\n[2] - NineNineFood -> R$").append(NineNineFood.DELIVERY_PRICE);
        sb.append("\n[3] - UberEats -> R$").append(UberEats.DELIVERY_PRICE);
        sb.append("\n[4] - YourSelfFood -> R$").append(YourSelfFood.DELIVERY_PRICE);
        sb.append("\n[x] - Sair");
        sb.append("\n\n               Opção: ");
        return sb;
    }

    /**
     * Método que retorna uma implementação de um DeliveryService conforme a opção do usuário.
     *
     * @param userOption Opção do usuário.
     *
     * @return Retorna uma implementação de um DeliveryService conforme a opção do usuário.
     */
    public static DeliveryServiceStrategy getDeliveryServiceStrategy(String userOption) {
        return switch (userOption) {
            case "1" -> IFood.getInstance();
            case "2" -> NineNineFood.getInstance();
            case "3" -> UberEats.getInstance();
            case "4" -> YourSelfFood.getInstance();
            default -> throw new IllegalArgumentException("Unknown delivery strategy");
        };
    }

    /**
     * Método que exibe o menu de preparação do pedido.
     * 
     * @param acai Açaí que o usuário escolheu, com todos os seus adicionais.
     *             
     * @param deliveryPrice Preço cobrado pelo serviço de entrega.
     */
    public static void showOrderPreparationMenu(Acai acai, Double deliveryPrice) {
        double totalPrice = acai.getPrice() + deliveryPrice;
        System.out.println("🍨 🍨 🍨 🍨 🍨 🍨 AÇAÍ MANIA 🍨 🍨 🍨 🍨 🍨 🍨\n");
        System.out.print("🔘 Preparando o pedido");
        sleep(1000);
        System.out.print(".");
        sleep(1000);
        System.out.print(".");
        sleep(1000);
        System.out.println(".\n");
        sleep(1000);
        System.out.println(acai.list());
        System.out.println("\n🔘 Açaí pronto\n");
        System.out.println("       -------------------------");
        System.out.println("         > Preço  Açaí: R$" + acai.getPrice());
        System.out.println("         > preço Entrega: R$" + deliveryPrice);
        System.out.println("       -------------------------");
        System.out.println("          VALOR TOTAL: R$" + totalPrice);
        System.out.println("\n🍨 🍨 🍨 🍨 🍨 🍨 🍨  🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨\n");
        sleep(2000);
    }

    /**
     * Método que pergunta se o usuário deseja confirmar sua compra, caso ele deseje será retornado o valor true,
     * caso ele não deseje será retornado o valor false.
     *
     * @param scan Scanner que fará a leitura de opção do usuário.
     *
     * @return Retorna um valor boolean que corresponde a opção do usuário de finalizar ou não sua compra.
     */
    public static boolean showFinalizeOrderConfirmation(Scanner scan) {
        System.out.print("\n          ");
        String message = "Confirmar compra [s/n]? ";
        char[] letters = message.toCharArray();
        for (char letter : letters) {
            System.out.print(letter);
            sleep(150);
        }
        String option = scan.next();
        showEndLine();
        return option.equalsIgnoreCase("s");
    }

    //TODO:
    /**
     * Método que gera a nota fiscal da compra do usuário.
     *
     * @param acai Açaí comprado pelo usuário.
     *
     * @param deliveryPrice Preço da entrega do Açaí.
     *
     * @return Retorna o caminho de diretório da nota fiscal do usuário.
     */
    public static String generateReceipt(Acai acai, Double deliveryPrice) {
        double totalPrice = acai.getPrice() + deliveryPrice;
        StringBuilder receiptDescription = new StringBuilder();
        receiptDescription.append("Data da Compra:").append(LocalDate.now()).append("\n");
        receiptDescription.append(acai.list()).append("\n");
        receiptDescription.append("Preço do Açaí: R$").append(acai.getPrice()).append("\n");
        receiptDescription.append("Preço da Entrega: R$").append(deliveryPrice).append("\n");
        receiptDescription.append("Preço Total: R$").append(totalPrice).append("\n");
        return null;
    }

    //TODO:
    /**
     * Método que exibe um menu com os dados da nota fiscal e o tempo de entrega do pedido do usuário.
     *
     * @param path Caminho de diretório da nota fiscal da compra do usuário.
     */
    public static void showReceipt(String path) {
        int minutes = new Random().nextInt(15,36);
        System.out.println("🍨 🍨 🍨 🍨 🍨 🍨 AÇAÍ MANIA 🍨 🍨 🍨 🍨 🍨 🍨\n");
        System.out.println("Obrigado pela sua compra! 🤩");
        System.out.println("\nSeu pedido será entregue em " + minutes + " minutos.");
        System.out.println("\nSua nota fiscal foi gerada e está no arquivo de");
        System.out.println("nome " + path + ".");
        System.out.println("\nEsse é um mostruário da sua nota ⬇");
        System.out.println("\n🍨 🍨 🍨 🍨 🍨 🍨 🍨  🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨\n");
    }

    /**
     * Método que exibe uma mensagem caso o usuário opte por não finalizar a compra.
     */
    public static void showCancelOrderMessage() {
        System.out.println("🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨");
        System.out.println("       Que pena, você não finalizou sua compra.         ");
        System.out.println("                Esperamos que volte!                    ");
        System.out.println("🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨    ");
        sleep(1000);
    }

    /**
     * Método que exibe uma mensagem de despedida caso o usuário deseje sair da aplicação.
     */
    public static void showByeMessage() {
        System.out.println("🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 ");
        System.out.println("         Já está indo embora? Que pena.               ");
        System.out.println("           Esperamos te ver novamente!                ");
        System.out.println("🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨     ");
        sleep(1000);
    }

    /**
     * Método que exibe as últimas linhas de menu.
     */
    public static void showEndLine() {
        System.out.println("\n\n🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨  🍨 🍨 🍨 🍨 🍨 🍨 🍨");
        sleep(2000);
        clearScreen();
    }

    /**
     * Esse método tem a função de limpar a tela do console.
     */
    private static void clearScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        //Para que esse método funcione é necessário adicionar o atalho Ctrl + shift + Q  ao clear all do console do intellij.
        // O que ocorre aqui é que um bot será criado para apertar esse atalho, dessa forma limpando a tela.
        //try {
        //Robot bot = new Robot();
        //bot.keyPress(KeyEvent.VK_CONTROL);
        //bot.keyPress(KeyEvent.VK_SHIFT);
        //bot.keyPress(KeyEvent.VK_Q);
        //bot.keyRelease(KeyEvent.VK_CONTROL);
        //bot.keyRelease(KeyEvent.VK_SHIFT);
        //bot.keyRelease(KeyEvent.VK_Q);
        //}
        //catch(AWTException ignored){}
        //sleep(500);
    }

    /**
     * Método que faz uma pausa no programa.
     *
     * @param millis Tempo em milissegundo em que o programa será "pausado".
     */
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Acai acai = showAcaiOptionsMenu(scan);
        if (acai == null) {
            return;
        }
        acai = showAdditionalOptionsMenu(acai, scan);
        if (acai == null) {
            return;
        }
        Double deliveryPrice = showDeliveryOptionsMenu(scan);
        if (deliveryPrice == null) {
            return;
        }
        showOrderPreparationMenu(acai, deliveryPrice);
        boolean finalizeOrder = showFinalizeOrderConfirmation(scan);
        if (!finalizeOrder) {
            showCancelOrderMessage();
            return;
        }
        scan.close();
        String path = generateReceipt(acai, deliveryPrice);
        showReceipt(path);
    }

}