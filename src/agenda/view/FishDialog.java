package agenda.view;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;

public class FishDialog {
    public static void GETFISHED() {
        Object[] opcoes = {"ok", "ok", "dont"};
        int escolha;

        ImageIcon fishIcon = new ImageIcon("fish.png");

        AudioClip blup = null;
        try {
            URL url = new File("blup.wav").toURI().toURL();
            blup = Applet.newAudioClip(url);
        } catch (Exception e) {
            System.out.println("Erro ao carregar som: " + e.getMessage());
        }

        do {
            escolha = JOptionPane.showOptionDialog(
                    null,
                    "fissh",
                    "WARNING",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    fishIcon,
                    opcoes,
                    opcoes[0]
            );

            if (escolha == 0 || escolha == 1) {

                if (blup != null) {
                    blup.play();
                }


                JOptionPane.showMessageDialog(
                        null,
                        "fissh",
                        "WARNING",
                        JOptionPane.INFORMATION_MESSAGE,
                        fishIcon
                );
            }

        } while (escolha != 2);
    }
}
