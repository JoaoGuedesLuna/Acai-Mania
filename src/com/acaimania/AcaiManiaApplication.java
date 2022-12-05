package com.acaimania;

import com.acaimania.model.decorator.*;
import com.acaimania.model.Acai;
import com.acaimania.model.BigAcai;
import com.acaimania.model.SmallAcai;
import com.acaimania.service.DeliveryService;
import com.acaimania.strategy.*;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
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
        StringBuilder acaiOptions = acaiOptions();
        String validOptions = "12xX";
        String userOption;
        do {
            System.out.print(acaiOptions);
            userOption = scan.next();
            if (userOption.length() > 1 || !validOptions.contains(userOption)) {
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
     * Método que retorna um açaí de acordo com a opção do usuário.
     *
     * @param userOption Opção do usuário.
     *
     * @return Retorna um açaí de acordo com a opção do usuário.
     */
    public static Acai getAcai(String userOption) {
        return switch (userOption) {
            case "1" -> SmallAcai.getInstance();
            case "2" -> BigAcai.getInstance();
            default -> null;
        };
    }

    /**
     * Método que exibe um menu onde o usuário poderá escolher quais adicionais ele deseja adicionar ao seu açaí.
     * Retorna o açaí que o usuário escolheu, com os adicionais que ele optou por colocar. Caso o usuário opte por
     * sair será retornaoo o valor Null.
     *
     * @param acai Açai do usuário.
     *
     * @param scan Scanner que fará a leitura dos dados.
     *
     * @return Retorna o açaí que o usuário escolheu, com os adicionais que ele optou por colocar. Caso o usuário opte por
     * sair será retornaoo o valor Null.
     */
    public static Acai showAdditionalOptionsMenu(Acai acai, Scanner scan) {
        clearScreen();
        StringBuilder acaiAdditionalOptions = additionalOptions();
        String validOptions = "123456sSxX";
        String userOption;
        do {
            System.out.print(acaiAdditionalOptions);
            userOption = scan.next();
            if (userOption.length() > 1 || !validOptions.contains(userOption)) {
                System.out.print("\n           ❌ Opção inválida ❌");
                showEndLine();
            }
            else {
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
     * Método que monta um açaí de acordo com a opção de adicional do usuário.
     *
     * @param acai Açaí do usuário.
     *
     * @param additionalOption Opção de adicional que o usuário escolheu.
     *
     * @param scan Scanner que fará a leitura de dados.
     *
     * @return Retorna um açaí de acordo com a opção de adicional do usuário.
     */
    public static Acai assemblyAcai(Acai acai, String additionalOption, Scanner scan) {
        return switch (additionalOption.toLowerCase()) {
            case "1" -> showAdditionalOptionsMenu(new CondensedMilk(acai), scan);
            case "2" -> showAdditionalOptionsMenu(new MilkPowder(acai), scan);
            case "3" -> showAdditionalOptionsMenu(new Pacoca(acai), scan);
            case "4" -> showAdditionalOptionsMenu(new Muesli(acai), scan);
            case "5" -> showAdditionalOptionsMenu(new Kiwi(acai), scan);
            case "6" -> showAdditionalOptionsMenu(new Strawberry(acai), scan);
            case "s" -> acai;
            default -> null;
        };
    }

    /**
     * Método que exibe um menu onde o usuário poderá escolher o serviço de entrega que ele deseja.
     *
     * @param scan Scanner que fará a leitura de dados.
     *
     * @return Retorna o valor da entrega.
     */
    public static double showDeliveryOptionsMenu(Scanner scan) {
        StringBuilder deliveryOptions = deliveryOptions();
        String validOptions = "1234xX";
        String userOption;
        boolean invalid = true;
        do {
            System.out.print(deliveryOptions);
            userOption = scan.next();
            if (userOption.length() > 1 || !validOptions.contains(userOption)) {
                System.out.print("\n           ❌ Opção inválida ❌");
                showEndLine();
            }
            else {
                invalid = false;
            }
        } while(invalid);
        if (userOption.equalsIgnoreCase("x")) {
            showEndLine();
            return 0;
        }
        DeliveryServiceStrategy deliveryServiceStrategy = getDeliveryServiceStrategy(userOption);
        DeliveryService deliveryService = new DeliveryService(deliveryServiceStrategy);
        showEndLine();
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
     * Método que retorna uma implementação de um DeliveryService de acordo com a opção do usuário.
     *
     * @param userOption Opção do usuário.
     *
     * @return Retorna uma implementação de um DeliveryService de acordo com a opção do usuário.
     */
    public static DeliveryServiceStrategy getDeliveryServiceStrategy(String userOption) {
        DeliveryServiceStrategy deliveryServiceStrategy;
        switch (userOption) {
            case "1" -> deliveryServiceStrategy = IFood.getInstance();
            case "2" -> deliveryServiceStrategy = NineNineFood.getInstance();
            case "3" -> deliveryServiceStrategy = UberEats.getInstance();
            case "4" -> deliveryServiceStrategy = YourSelfFood.getInstance();
            default -> throw new IllegalArgumentException("Unknown delivery strategy");
        }
        return deliveryServiceStrategy;
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
        acai.list();
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
     * Método que exibe as últimas linhas de menu.
     */
    public static void showEndLine() {
        System.out.println("\n\n🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨  🍨 🍨 🍨 🍨 🍨 🍨 🍨");
        sleep(2000);
        clearScreen();
    }

    /**
     * Esse método tem a função de limpar a tela do console. Para que esse método funcione é necessário adicionar
     * o atalho Ctrl + shift + Q  ao clear all do console do intellij. O que ocorre aqui é que um bot será criado
     * para apertar esse atalho, dessa forma limpando a tela.
     */
    private static void clearScreen() {
        try {
            Robot bot = new Robot();
            bot.keyPress(KeyEvent.VK_CONTROL);
            bot.keyPress(KeyEvent.VK_SHIFT);
            bot.keyPress(KeyEvent.VK_Q);
            bot.keyRelease(KeyEvent.VK_CONTROL);
            bot.keyRelease(KeyEvent.VK_SHIFT);
            bot.keyRelease(KeyEvent.VK_Q);
        }
        catch(AWTException ignored){}
        sleep(500);
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
        if (acai == null)
            return;
        acai = showAdditionalOptionsMenu(acai, scan);
        showEndLine();
        if (acai == null)
            return;
        double deliveryPrice = showDeliveryOptionsMenu(scan);
        scan.close();
        if (deliveryPrice == 0)
            return;
        showOrderPreparationMenu(acai, deliveryPrice);
    }

}