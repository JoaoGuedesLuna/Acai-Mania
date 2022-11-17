package com.acaimania;

import com.acaimania.decorator.*;
import com.acaimania.model.Acai;
import com.acaimania.model.BigAcai;
import com.acaimania.model.SmallAcai;
import com.acaimania.service.DeliveryService;
import com.acaimania.strategy.*;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class AcaiManiaApplication {

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

    public static Acai getAcai(String userOption) {
        switch (userOption) {
            case "1" -> {
                return SmallAcai.getInstance();
            }
            case "2" -> {
                return BigAcai.getInstance();
            }
            default -> {
                return null;
            }
        }
    }

    public static Acai showAcaiAdditionalOptionsMenu(Acai acai, Scanner scan) {
        clearScreen();
        StringBuilder acaiAdditionalOptions = acaiAdditionalOptions();
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

    public static StringBuilder acaiAdditionalOptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("🍨 🍨 🍨 🍨 🍨 🍨 AÇAÍ MANIA 🍨 🍨 🍨 🍨 🍨 🍨\n");
        sb.append("\nEscolha uma das opções de adicionais:\n");
        sb.append("\n[1] - Leite Condesado -> R$").append(LeiteCondesado.PRICE);
        sb.append("\n[2] - Leite em pó -> R$").append(LeiteEmPo.PRICE);
        sb.append("\n[3] - Paçoca -> R$").append(Pacoca.PRICE);
        sb.append("\n[4] - Granola -> R$").append(Granola.PRICE);
        sb.append("\n[5] - Kimi -> R$").append(Kiwi.PRICE);
        sb.append("\n[6] - Morango -> R$").append(Morango.PRICE);
        sb.append("\n[s] - Sem mais adicionais");
        sb.append("\n[x] - Sair");
        sb.append("\n\n               Opção: ");
        return sb;
    }

    public static Acai assemblyAcai(Acai acai, String additionalOption, Scanner scan) {
        if (additionalOption.equals("1")) {
            return showAcaiAdditionalOptionsMenu(new LeiteCondesado(acai), scan);
        }
        if (additionalOption.equals("2")) {
            return showAcaiAdditionalOptionsMenu(new LeiteEmPo(acai), scan);
        }
        if (additionalOption.equals("3")) {
            return showAcaiAdditionalOptionsMenu(new Pacoca(acai), scan);
        }
        if (additionalOption.equals("4")) {
            return showAcaiAdditionalOptionsMenu(new Granola(acai), scan);
        }
        if (additionalOption.equals("5"))  {
            return showAcaiAdditionalOptionsMenu(new Kiwi(acai), scan);
        }
        if (additionalOption.equals("6")) {
            return showAcaiAdditionalOptionsMenu(new Morango(acai), scan);
        }
        if (additionalOption.equalsIgnoreCase("s")) {
            showEndLine();
            return acai;
        }
        showEndLine();
        return null;
    }

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
            else
                invalid = false;
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

    public static StringBuilder deliveryOptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("🍨 🍨 🍨 🍨 🍨 🍨 AÇAÍ MANIA 🍨 🍨 🍨 🍨 🍨 🍨\n");
        sb.append("\nEscolha uma das opções de entrega:\n");
        sb.append("\n[1] - Ifood -> R$").append(IFood.DELIVERYPRICE);
        sb.append("\n[2] - NineNineFood -> R$").append(NineNineFood.DELIVERYPRICE);
        sb.append("\n[3] - UberEats -> R$").append(UberEats.DELIVERYPRICE);
        sb.append("\n[4] - YourSelfFood -> R$").append(YourSelfFood.DELIVERYPRICE);
        sb.append("\n[x] - Sair");
        sb.append("\n\n               Opção: ");
        return sb;
    }

    public static DeliveryServiceStrategy getDeliveryServiceStrategy(String userOption) {
        DeliveryServiceStrategy deliveryServiceStrategy;
        switch (userOption) {
            case "1" ->
                    deliveryServiceStrategy = IFood.getInstance();
            case "2" ->
                    deliveryServiceStrategy = NineNineFood.getInstance();
            case "3" ->
                    deliveryServiceStrategy = UberEats.getInstance();
            case "4" ->
                    deliveryServiceStrategy = YourSelfFood.getInstance();
            default ->
                throw new IllegalArgumentException("Unknown delivery strategy");
        }
        return deliveryServiceStrategy;
    }
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
        acai.make();
        System.out.println("\n🔘 Açaí pronto\n");
        System.out.println("       -------------------------");
        System.out.println("         > Preço  Açaí: R$" + acai.getPrice());
        System.out.println("         > preço Entrega: R$" + deliveryPrice);
        System.out.println("       -------------------------");
        System.out.println("          VALOR TOTAL: R$" + totalPrice);
        System.out.println("\n🍨 🍨 🍨 🍨 🍨 🍨 🍨  🍨 🍨 🍨 🍨 🍨 🍨 🍨 🍨\n");
        sleep(2000);
    }

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
        acai = showAcaiAdditionalOptionsMenu(acai, scan);
        if (acai == null)
            return;
        double deliveryPrice = showDeliveryOptionsMenu(scan);
        scan.close();
        if (deliveryPrice == 0)
            return;
        showOrderPreparationMenu(acai, deliveryPrice);
    }

}